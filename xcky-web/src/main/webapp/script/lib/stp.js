
//for null,undefined,number,xss and others
function $encode(str,allowHTML){
    var dic={'<':'&lt;','>':'&gt;','"':'&quot',"'":'‘',':':'：','{':'&#123;','}':'&#125;'};//&#39; &apos;
    // 数字0会做false,false做‘’处理(字符串'0'不会),需要显示0或不做为false条件则需要{i.toString}转为字符串形式
    //if($encode.zeroAsEmpty!==false && str===0){
    //    return '';//不再提供此配额, 有需要显示按上面i.toString方法
    //}
    if(str==null || str=='null' || str=='NULL' || str===0 || str===false ){
        return '';
    }
    str =  allowHTML ? String(str).replace(/\<\/?script[^\>]*\>/gmi,function(s){return s.replace(/\<|\>/gm,function($){return dic[$]})})
        : String(str).replace(/\<|\>/gm,function($){return dic[$]});
    //后台没做转义才开启，避免性能消耗
    return $encode.tranSymbol ? str.replace(/\"\'\{\}\:/gm,function($){return dic[$];}):str;
}
//core
function $compile(source,data,arg2,arg3) {
    var allowHTML;
    var helper;
    if(data==null || (typeOf(data)=='array' && data.length==0)){
        return '';
    }else if(typeof data=='object'){
        if(Object.keys(data).length==0){
            return '';
        }
        // var kCount=0;
        // for(var _n in data){
        //     if(data.hasOwnProperty(_n)){
        //         continue;
        //     }
        //     _n!='_stp_helper_done_' && kCount++;
        //     if(kCount){
        //         break;
        //     }
        // }
        // if(!kCount){
        //     return '';
        // }
    }
    data = typeof data.pop=='function' ? data : [data];
    if(typeof arg2=='boolean'){
        allowHTML=arg2;
    }else{
        typeof arg2=='function' && (helper=arg2);
        allowHTML=arg3;
    }
    var the=this;
    if(typeof source=='string' && source[0]=='#'){
        source=$(source).html();
    }
    if(!source){
        throw new Error('source undefined! please checkout the template source,id or url!');
    }
    var format=function (obj,str,$index){//,prefix) {
        var vuestr=function(key){
            var val=obj;
            var arr=key.split('.');
            for(var i=0;i<arr.length;i++){
                //对第一个属性判断
                if(i==0 ){
                    //如果是this则指向代入的this, 直接赋值走向下个属性
                    if(arr[i]=='this'){
                        val=the;
                        continue;
                    }
                    //如果是$index或$rownum就直接代入索引和序号
                    if(arr[i]=='$index'){
                        val=$index;
                        continue;
                    }
                    if(arr[i]=='$rownum'){
                        val=$index+1;
                        continue;
                    }
                    if(arr[i]=='$nth'){
                        val =  $index%2==0 ? 'nth-even':'nth-odd';
                        $index%3==0  && (val += ' nth-third');
                        continue;
                    }
                }
                //数字并不会真的获取它的length,而是返回本身. i=0,k=5; i.length返回空值, k.length返回5, 这样的设计是让空值的length属性也为空, 数字的length属性只用于真假值判断
                if(typeof val=='number' && arr[i]=='length'){
                    //val=val;
                }else{
                    if(typeof val[arr[i]]=='function'){
                        val=val[arr[i]].toString().indexOf('[native code]')>-1?val[arr[i]]():val[arr[i]].apply(val,[obj,$index]);
                    }else{
                        val=val[arr[i]];
                    }
                }
                if((val==null||val=='null' || val=='NULL') && typeof arr[i+1]!='undefined'){
                    val='';
                }
                //console.info('一次循环结束\n\n  ')
            }
            return $encode(val,allowHTML);
        };
        //prefix=prefix||'';
        //{{arr:#tp2}}
        ///{{!?[A-z]+(\.?\w+)*\s?&{2}\s?#[\w\-]+}}/
        ///{{!?[A-z]+(\.?\w+)*\s?&{2}\s?#[^#].+}}/
        ///{{!?[A-z]+(\.?\w+)*\s?&{2}\s?\n[^\xdd]+\s*\n}}/
        ///{{[A-z]+(\.?\w+)*\s?:?\s?#[\w\-]+}}/
        ///{{\w*\s?:?\s?#[^#].+#}}/
        str=str.replace(/&amp;&amp;/g,'&&').replace(/{{!?[A-z]+(\.?\w+)*\s?&{2}\s?#[\w\-]+}}|{{!?[A-z]+(\.?\w+)*\s?&{2}\s?#[^#].+}}|{{[A-z]+(\.?\w+)*\s?:?\s?#[\w\-]+}}|{{\w*\s?:?\s?#[^#].+#}}|{{!?[A-z]+(\.?\w+)*\s?&{2}\s?\n[^\xdd]+\n\s*}}/g,function(g){
            //if(g.match(/{{[A-z]+(\.?\w+)*\s?&{2}\s?\n[^\xdd]+\n\s*}}/)){
            //    info(g.match(/{{[A-z]+(\.?\w+)*\s?&{2}\s?\n[^\xdd]+\n\s*}}/))
            //    return g;
            //}
            g=g.replace(/^{{|}}$/g,'');
            //使用了换行代替#<p>内容</p>#包裹
            var n1=g.indexOf('\n'),x1=g.indexOf('#');
            if(( n1>-1 && x1>-1 && n1<x1) | (n1>-1 && x1==-1)){
                var n2=g.lastIndexOf('\n');
                g= g.replace(/\n/,'#');
                g=g.slice(0,n2)+ '#'+g.slice(n2+1);
            }
            g=g.trim();//replace(/^\s+|\s+$/gm,'');
            var d,t,e, j,_i,i=g.indexOf(':'),i2=g.indexOf('&&');
            if(i==-1 && i2==-1){
                return $(g).html()||(typeof console=='object' && console.error('can`t find the inlaid template: '+id))||'';
            }else{
                j=(g.indexOf(':')>0 && g.indexOf(':') < g.indexOf('#')) ? 1:2;
                d= j==1 ? g.slice(0,i).trim():g.slice(0,i2).trim();
                _i=j==1 ? i:i2;
                var gtrim=g.slice(_i+j).trim();
                if(g.lastIndexOf('#')==g.length-1){
                    t= gtrim.slice(1,-1);
                    //t=g.slice(i+2,-1);
                }else{
                    t=gtrim.indexOf('#')==0 ? $(gtrim).html() : gtrim.slice(1,-1);
                }
                //if(g.indexOf('#站内消息')>-1){console.warn(d);console.log(t)}
                if(j===1){
                    return vuestr(d)?$compile.apply(this,[t,obj[d],function(item){
                        //('super' in item)  && (console.info(item) || console.warn("don't use keyword 'super' as key"));
                        typeof item=='object'&& item.extending('$super',obj);
                        return false;
                    },allowHTML]):'';
                }else if(d.indexOf('!')==0){
                    return vuestr(d.slice(1))?'':$compile.apply(this,[t,obj,null,allowHTML]);
                }else{
                    //if(g.indexOf('#站内消息')>-1){console.warn(d);console.log(t)}
                    return vuestr(d)?$compile.apply(this,[t,obj,null,allowHTML]):'';
                }
            }
        });
        str=str.replace(/{\$?[A-z]+(\.?\w+)*}/gm,function(key){
            key=key.slice(1,-1);
            return vuestr(key);
            //return the[key.replace(/{|}|(this)|\./g,'')];
        });
        return str;
    }

    var i=0,j=data.length,sb=[];
    for(;i<j;i++){
        typeof helper=='function' && !data[i]._stp_helper_done_ && helper(data[i],i) && (data[i].extending({_stp_helper_done_:true}));
        sb.push(format(data[i],source,i));
        //sb.push(format(data[i],source,i).replace(/\{\$rownum\}/g,i+1).replace(/\{\$index\}/g,$encode(i)).replace(/\{\$nth2\}/g,i%2==1?'nth-even':'nth-odd'));
    }
    return sb.join('');
}
//原来是用于将表格中有ID的子元素备份为文本, 改写拷贝的ID后再找回,避免拷贝后有ID冲突
//var backUpWrapBegin='<script type="text/backup">';
//var backUpWrapEnd='</script>';

//seal4quick
var $template=(function($){
    var cache=window.loadHTMLCache;//={};
    return function (container,data,arg2,arg3){
        var args=arguments;
        var $container=$(container);
        //未设置tpspource表示template存储于自身innerHTML, 需要钩子来做cache, 否则执行一次template后,保存在自身内的模板会丢失
        var tpsource=$container.attr('tpsource')||'';
        var id=$container.attr('id')||'';
        var selector=$container.selector||'';
        var tpcache=$container.attr('tpcache')||$container.attr('tpcache',+new Date()).attr('tpcache');  //未设tpsource,未设id,未通过选择器,那就需要随意赋值一个唯一值给tpcahce属性
        //依次尝试钩子,如果都没有,报错  改为自动加上钩子
        (!tpsource && id && byid(id+'-tp')) && (tpsource='#{0}-tp'.format(id));
        tpsource=tpsource || ( id ? ('#'+id) : selector );
        tpsource=tpsource || (tpcache ? '[tpcache={0}]'.format(tpcache) : '' );
        if(!tpsource){
            throw new Error('The template tpsource was not found! check the container selector or id or attr:tpcache');
        }

        var initIt=function(){
            var children;
            var _data;
            var dataType=typeOf(data);

            //空template()
            if(args.length==1){
                return $container.html(cache[tpsource]);
            }

            //template(html)来代替html(html), 来实现一些template中通用的操作, 并且可以传数据对象进来, 利用template绑定
            else if(typeof data=='string'){
                _data=arg2;
                $container.html(data);
            }

            //普通情况
            else{
                _data=data;
                $container.html($compile.apply(this,[cache[tpsource],data,arg2,arg3])).removeClass('stp-hide');
            }

            if($container.is('tbody')){
                //console.log("$container.is('tbody') 将触发table custom重绘")
               $container.parent('table').customCol('cs').fixTable('all');
            }else if($container.is('table')){
                //console.log("$container.is('table') 将触发自身 custom重绘")
                $container.customCol('cs').fixTable('all');
            }

            if($container.hasClass('has-checkbox')){
                $container.find('[stp-checked]').each(function () {
                    this.checked=$(this).attr('stp-checked');
                });
            }

            //编译完后, 数据绑定在容器
            $container.data('current-data',_data);


            //数组分解赋值给子项
            if($container.is('table')){
                children=$container.find('>tbody>tr');
                if(dataType=='array'){
                    _data=data;
                }else if(data.tbodyDataKey){
                    _data=data[data.tbodyDataKey];
                }
            }
            else if(dataType=='array'){
                children=$container.children();
                _data=data;
            }

            children && _data && children.each(function (i) {
                $(this).data('current-data',_data[i]);
            });

            return $container;

        };

        if(cache[tpsource]){
            //注意init抽取为function后,其代码中默认this指向变化,由于$(selector).template(...)会传入元素的fixData作为this,因此需要一路传进子方法,或者外层用the保存
            initIt.call(this);
        }else if(tpsource.indexOf('.htm')>0){
            $.get(tpsource,function(res){
                cache[tpsource]=res;
                initIt.call(this);
            });
        }else{
            cache[tpsource]=$(tpsource).eq(0).html();
            initIt.call(this);
        }

        return $container;
    }
})(window.jQuery);

window.$.fn.fixData=window.$.fn.thisData=function(data){
    return arguments.length==0 ? this.data('fix-data') : this.each(function(){$(this).data('fix-data',data)});
};
window.$.fn.template=function(data,arg2,arg3){
    var args=arguments;
    return this.each(function() {$template.apply($(this).data('fix-data') || window, [this].concat([].slice.call(args)));});
};
window.$.fn.tpsource=function(tps){
    return arguments.length==0 ? this[0].getAttribute('tpsource') : this.each(function(){$(this).attr('tpsource',typeof tps=='function'?tps($(this)):tps);});
};

require('./stp.filter');
require('./stp.table');
require('./stp.fixtable');
require('./stp.customcols');
var stp={
    $encode:$encode,
    $compile:$compile,
    $template:$template
}
//window.extending(obj);
typeof module === "object" && typeof module.exports === "object"  && (module.exports=stp);