var scrollFunc=function (evt) {
    evt = evt || window.event;
    if(evt.preventDefault) {
        // Firefox
        evt.preventDefault();
        evt.stopPropagation();
    } else{
        // IE
        evt.cancelBubble=true;
        evt.returnValue = false;
    }
    return false;
};
var $scope={};
var _data=Object.create(null);
var _dict=Object.create(null);

$scope.extending({
    get:function (key) {
        return _data[key];
    },
    check:function(key,val,always){
        var selector=_dict[key];
        var ct=$(selector);
        var curData=ct.data('current-data');
        if(selector && (always||curData!=val)){//} || !JSON.equal(val,curData) )){
            ct.template(val,ct.data('helper'),ct.data('allow-html'));//,$scope.get(ct.attr('helper')),$scope.get(ct.attr('allowhtml')));
        }
    },
    //通过set设置数据, 进行dirtyCheck
    set:function (key,val,alwaysCheck) {
        _data[key]=val;
        if(alwaysCheck!==false){
            $scope.check(key,val,alwaysCheck);
        }
        return $scope;
    },
    //通过bind绑定数据
    bind:function (data,seletor,helper,allowHTML) {
        var key;
        //传入的是data的key
        if(typeof data=='string'){
            key=data;
            data=_data[key];
        }
        //一般传入数据,自动生成key
        else{
            key=new Date().getTime();
        }
        _dict[key]=seletor;
        $(seletor).data('helper',helper).data('allow-html',allowHTML);
        data && $scope.set(key,data);
        return $scope;
    },
    //更新绑定的数据
    update:function(key,fn,eachItem){
        var data=_data[key];
        var newData;
        fn=$lambda(fn);
        if(data){
            if(eachItem && Array.isArray(data)){
                data.each(fn);
                newData=data;
            }else{
                newData=fn(data);
                newData=typeof newData=='undefined' ? data : newData;
            }
            $scope.set (key, newData, true);
        }
        return newData;
    }
},true);
var stpWidget=require('./stp.widget');
module.exports={
        //json与string互转
        obj2str:function(obj){return typeof obj=='object'?JSON.stringify(obj):obj;},
        str2obj:function(str,b){
            var obj;
            if(typeof str=='string'){
                obj=b?eval('('+str+')'):JSON.parse(str);
            }else{
                obj=str;
            }
            return obj;
        },
        dash2camel:function(str){
            var arr=str.split('-');
            for(var i= 1;i<arr.length;i++){
                if(arr[i]){
                    arr[0]=arr[0]+arr[i][0].toUpperCase()+arr[i].slice(1);
                }
            }
            return arr[0];
        },
        camel2dash:function(str){
            for(var i=1;i<str.length;i++){
                if(str[i].match(/[A-Z]/)){
                    str=str.slice(0,i)+'-'+str[i].toLowerCase()+str.slice(i+1);
                }
            }
            return str;
        },
        //简写原生选择器，支持传入第二参数iframe的document
        byid:function(id,doc){return (doc||document).getElementById(id);},
        bytag:function(tag,doc){return (doc||document).getElementsByTagName(tag);},
        //获取位置
        getRect:function(ele){return ele.getBoundingClientRect();},
        //是否出现滚动条 也可以设置overflow-y:hidden,overflow:visible,再恢复保存的overflow值,来比较两次是否有变化来判断 TODO 不准有待修复
        hasScroll:function(p,xory){
            var cstyles=getComputedStyle(p);
            //var paddingsSize= xory=='y' ? (parseInt(cstyles.paddingLeft) + parseInt(cstyles.paddingRight)) : (parseInt(cstyles.paddingTop) + parseInt(cstyles.paddingBottom));
            //var contentUseSize=xory=='y' ? (p.offsetWidth - paddingsSize-bordersSize) : (p.offsetHeight - paddingsSize-bordersSize);;
            var bordersSize= xory=='y'? (parseInt(cstyles.borderLeftWidth) + parseInt(cstyles.borderRightWidth)) : (parseInt(cstyles.borderTopWidth) + parseInt(cstyles.borderBottomWidth));
            var scrollBarWidth=xory=='y'? (p.offsetWidth - p.clientWidth-bordersSize) : (p.offsetHeight - p.clientHeight-bordersSize);
            return scrollBarWidth;
        },
        //调试
        log:function (param){typeof console!='undefined' && console.log(param);},
        info:function(param){typeof console!='undefined' && console.info(param);},
        warn:function(param){typeof console!='undefined' && console.warn(param);},
        error:function(param){typeof console!='undefined' && console.error(param);},
        logEx:function(msg,cssTxt){
                //默认fontsize 16px写前面，后写的可覆盖
                cssTxt= cssTxt ? 'font-size:16px;'+cssTxt : 'font-size:16px;color:red;';
                console.log('%c'+msg,cssTxt);
            },
        //类型判断
        typeOf:(function(){
                var dic={'[object Object]':'object','[object RegExp]':'regexp','[object Date]':'date','[object Array]':'array','[object String]':'string','[object Number]':'number','[object Boolean]':'boolean','[object Error]':'error','[object Window]':'window'};
                var stringify=Object.prototype.toString;
                return function(obj,plus){
                    if(typeof obj !='object')
                        return typeof obj;
                    else if(obj===null)
                        return 'null';
                    else if(plus)
                        return dic[stringify.apply(obj)] || stringify.call(obj).slice(8,-1).toLowerCase()|| 'object';
                    else
                        return dic[stringify.apply(obj)] || 'object';
                };
                })(),
        //queryStr解析
        queryParse:function (str){
                var str=str||location.search;
                var result =str.match(new RegExp("[\?\&][^\?\&]+=[^\?\&]*","g"));
                if(result==null)return false;
                var j=result.length;
                var obj={},arr=[];
                for(var i=0;i<j;i++){
                    arr=result[i].slice(1).split('=');
                    obj[arr[0]]=arr[1];
                }
                return obj;
            },
        //防止百分号标签空白输出在页面上
        getJspData:function(data){
                return data||null;
            },
        replaceDDD:function(value){return value.replace(/\<ddd\>/gmi,"'");},
        //禁止滚轮事件
        disabledMouseWheel:function (ele) {
            var ele=ele||document;
            if(ele.addEventListener) {
                document.addEventListener('DOMMouseScroll', scrollFunc, false);
            }//W3C
            //window.onmousewheel =
            ele.onmousewheel = scrollFunc;//IE/Opera/Chrome
        },
        enabledMouseWheel:function (ele,fn){
            var ele=ele||document;
            if(ele.removeEventListener) {
                ele.removeEventListener('DOMMouseScroll', scrollFunc, false);
            }
            //window.onmousewheel =
            ele.onmousewheel = fn||function(){};
        },
        //原生弹窗的封装
        open2:function(){
                var features='';
                var config={status:0,width:top.getWidth()-40,height:top.getHeight()-70,top:20,left:20,scrollbars:1,resizable:1,fullscreen:0,channelmode:0,directories:1,help:0,menubar:0,toolbar:0,location:0};
                var obj=typeof arguments[0]=='object' ? arguments[0]:{url:arguments[0],name:arguments[1],width:arguments[2],height:arguments[3],left:arguments[4],top:arguments[5]} ;
                for (var n in obj){
                    typeof obj[n]!='undefined' && (config[n]=obj[n]);
                }
                for (var m in config){
                    if(m!='url' || m!='name')
                    features += ','+ m + '=' +config[m];
                }
                //log(url +'\n'+ name +'\n'+ features.slice(1))
                var win=window.open(config.url,config.name||'_blank',features.slice(1));
                return win;
            },
        removeTag:function(src,tagName){
            var tags=document.head.getElementsByTagName(tagName||'script');
            src=src.replace('../','').replace('..\\','').replace('.\\','').replace('./','')+'?version='+config.version;
            for(var i=0;i<tags.length;i++){
                if((tagName=='link'?tags[i].href:tags[i].src).split('').reverse().join('').indexOf(src.split('').reverse().join(''))==0){
                    document.head.removeChild(tags[i]);
                }
            }
        },
        checkExistTag:function(src,tagName){
            var tags=document.head.getElementsByTagName(tagName||'script');
            src=src.replace('../','').replace('..\\','').replace('.\\','').replace('./','')+'?version='+config.version;
            //warn(src)
            for(var i=0;i<tags.length;i++){
                //info([tags[i].href,tags[i].src])
                if((tagName=='link'?tags[i].href:tags[i].src).split('').reverse().join('').indexOf(src.split('').reverse().join(''))==0){
                    return tags[i];
                }
            }
            return false;
        },
        //简单加载样式 304改为走200，缓存10天
        $style:function(src,cb,redoExist){
                //src.match(/^http|^\.|^\//)!=null || (src=top.path+'/style/'+src);
                src.match(/\.css$/i)!=null || (src+='.css');
                //src+='?version='+Date.format('YYYYMMDD').slice(0,-1);
                var exist=checkExistTag(src,'link');
                if(exist && !redoExist){
                    return cb();
                }else {
                    exist && document.head.removeChild(exist);
                    var link = document.createElement("link");
                    link.rel = "stylesheet";
                    link.type = "text/css";
                    link.media = "screen";
                    link.href = src + (window.config.version ? '?version=' + window.config.version : '');
                    document.head.appendChild(link);
                    cb && cb.call(link);
                    return link;
                }
            },
        $script:function (src,cb,redoExist){
            var bol=false;
            var tag=document.createElement("script");
            var exist=checkExistTag(src);
            if(exist && !redoExist){
                return cb();
            }else{
                exist && document.head.removeChild(exist);
                tag.type="text/javascript";
                tag.language="javascript";
                //tag.setAttribute('async','async');
                //tag.setAttribute('defer','defer');
                src.match(/\.js$/i)!=null || (src+='.js');
                tag.src=src+(window.config.version?'?version='+window.config.version:'');
                tag.onload=tag.onreadystatechange=function(){
                    if(!bol&&(!tag.readyState||tag.readyState=="loaded"||tag.readyState=="complete")){
                        bol=true;
                        tag.onload=tag.onreadystatechange=null;
                        if(cb){
                            cb.call(tag);
                        }
                    }
                };
                document.head.appendChild(tag);
                return tag;
            }
        },
        $loadHTML:function(src,cb){
            if(window.loadHTMLCache[src]){
                cb();
            }else{
                $.get(window.getViewPath(src),function(res){
                    window.loadHTMLCache[src]=res;
                    cb();
                });
            }
        },
        importing:function(){
            var ags=arguments;
            var ag=ags[0];
            //log(['进入importing',ags])
            //if(window._concatDone_!==true){
            //    var list=window._includeList_=$('div').filter('[include*=".htm"],[replace*=".htm"]');
            //    var arr=window._includeArr=[];
            //    list.each(function(){
            //        arr.push($(this).attr('include')||$(this).attr('replace'));
            //    });
            //    arr=arr.distinct();
            //    if(arr.length){
            //        //window._include_=true;
            //        window._concatDone_=true;
            //        return window.importing.apply(this,arr.concat(arr.slice.call(ags)));
            //    }
            //}
            //log('进入importing();将运行reg')

            var cb=stpWidget.reg([].slice.call(ags));
            if(cb){
                //log('有额外调用importing')
                return cb();
            }

            if(typeof ag!='string'){
                //log('importing走到回调函数');
                //log(ags.length)
                //console.warn('window.loadHTMLCache: ');console.log(window.loadHTMLCache);
                ////window._include_=true;
                ////delete window._concatDone_;
                //window._includeList_.each(function(i){
                //    var html=window.loadHTMLCache[window._includeArr[i]]||'';
                //    if(this.hasAttribute('replace')){
                //        $(this).replaceWith($(html));
                //    }else{
                //        $(this).html(html).attr('include','');
                //    }
                //});
                stpWidget.init();

                $('body,body>.body-agent').removeClass('unready');

                typeof ag=='function' && $(function(){
                    ag($scope);
                });
                return false;
            }
            //log('走到识别插件开始')
            //识别插件
            var plugins=window.config.plugins;
            if(plugins[ag]){
                ag=window.getDistPath()+'plugin/'+plugins[ag];
            }
            else if(!ag){
                return  window.importing.apply(this,[].slice.call(ags,1));
            }
            //对应默认文件夹
            else if(ag.indexOf('http')!=0){

                //如果是页面有专门的getViewPath处理
                if(ag.match(/.*.html?/i)){
                    return window.$loadHTML(ag,function(){
                        window.importing.apply(this,[].slice.call(ags,1));
                    },ags[ags.length-1]===true);
                }

                //如果直接写css或js就表示在对应的基本目录下
                else if(ag.indexOf('/')<0) {
                    if (ag.match(/.*.css$/i)) {
                        ag = window.getDistPath() + 'css/' + ag;
                    } else if (ag.match(/.*.js$/i)) {
                        ag = window.getDistPath() + 'js/' + ag;
                    }
                }

                //否则就是相对distPath的路径
                else{
                    ag=ag.indexOf(window.getDistPath())>-1 ?ag:window.getDistPath()+ag;
                }
            }
            //识别加载方式
            window[ag.match(/.*\/css\/.+|.css$/i)?'$style':'$script'](ag,function(){
                window.importing.apply(this,[].slice.call(ags,1));
            },ags[ags.length-1]===true);
        }
    };