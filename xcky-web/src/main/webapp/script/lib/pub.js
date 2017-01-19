
//require('./treemenu');
require('./jquery.extend');
require('./previewbox');

top._rootTabUrls=top._rootTabUrls||Object.create(null);

window.getting({
    currentTab:function(){return top.rootTabs.tabs('getSelected');},
    currentTabWin:function(){return top.$('.tabs-panels>.epanel:not(hide)').find('.tab-content-frame')[0].contentWindow;}
});

window.$.fn.$close=function(){
    var id=this[0].id;
    if(id && id.indexOf('root-tab')==0){
        var index=top.rootTabs.tabs('getTabIndex', this);
        top.rootTabs.tabs('close', index);
    }else {
        this.window('close');
    }
    return this;
};
window.$.fn.$select=function(){
    if(this.hasClass('epanel-body')){
        var index=top.rootTabs.tabs('getTabIndex', this);
        top.rootTabs.tabs('select', index);
    }else {
        //
    }
    return this;
};
window.$.fn.$open=function(ops){
    return window.$open(this,ops||this.data('open-params')||{});
};
module.exports={
    //----------------基于jquery的拓展------------------
    showLoading:function (needMask){
        var loading=$('.loading-mask');
        (loading.length) || (loading=$('<div class="loading-mask"><div class="loading"><i class="icon-spinner"></i><p>加载中...</p></div></div>').appendTo('body'));
        return loading[needMask===false?'addClass':'removeClass']('transparent').show();
    },
    hideLoading:function(){
        return $('.loading-mask').fadeOut(150);
    },
    showMask:function (){
        var mask=$('.common-mask.preview-mask');
        (mask.length) || (mask=$('<div class="common-mask preview-mask">'));
        return mask.appendTo('body').show();
    },
    hideMask:function(){
        return $('.common-mask.preview-mask').fadeOut(150);
    },

    //吐司消息
    toast:function(str){
        var holding;
        var callback;
        var itv;
        var done;
        str=String(str);
        var bol= str.length>15;
        var len= bol ? str.length : 15;
        if(typeof arguments[1]=='number'){
            holding=arguments[1];
            typeof arguments[2]=='function' && (callback=arguments[2]);
        }else if(typeof arguments[1]=='function'){
            callback=arguments[1];
        }
        var mid=new Date().getTime();
        // 根据文字长度增加延时, 限制最高秒数
        holding= holding || 1600+(len-15)*30;
        var p=jQuery('<div><p>str</p></div>'.replace('str',str));
        var fadeOut=function(){
            if(!done){
                //jQuery('.the-mask').remove();
                p.animate({'opacity':0},500,function(){callback && callback(p);p.remove();});
                done=true;
            }
        };
        jQuery('.toast').hide();
        //jQuery('body').one('click',fadeOut);

        document.body.addEventListener('click',fadeOut,true);

        // 预制样式
        return  p.addClass('toast').appendTo('body')
            //透明度 文字居中居左判断
            .css({'text-align':bol?'left':'center'})
            // 移入暂停
            .bind('mouseenter',function(){clearTimeout(itv);})
            .bind('mouseleave',function(){itv=setTimeout(fadeOut,200);})
            // 增加icon
            .extend({
                ok:function(){return p.addClass('ok');},
                err:function(){return p.addClass('err');},
                warn:function(){return p.addClass('warn');}
            })
            // 显示
            .fadeIn(function(){
                itv=setTimeout(fadeOut,holding||900);
            });
    },
    //tab控件
    tabsInit:function (selector){
        $(selector||document.body).find('.tabs-list').find('li').on('click', function(event) {
            var tabsList = this.parentNode//$('.tabs-list');
            var tabsWrap = tabsList.parentNode;//$('.tabs-wrap');
            tabsList.find('.current').removeClass('current');
            tabsWrap.find('.tabs-content').hide();
            $(this).addClass('current');
            $(this.getAttribute('direct')).show();
        });
    },
    //--------------基于eui的扩展----------------
    // 弹窗
    $open:require('./win').$open,
    // 单确定框
    _$alert:function(param){
        var title='提示',icon='info',cb=function(){},msg;
        if(typeof param!='object'){
            msg=param;
            cb=arguments[1]||cb;
        }else{
            title=param.title||title;
            icon=param.icon||icon;
            cb=param.callback||cb;
            msg=param.msg;
        }
        var ele=jQuery.messager.alert(title,msg,icon,cb);
        jQuery('.messager-window, .messager-window+.window-shadow').css('top',function(i,v){return Math.max(100,parseInt(v,10)-60);});
        $.noOutline();
        return ele.parent();
    },
    // 二选一确认框
    _$confirm:function(param){
        var title='提示',cb=function(){},msg;
        if(typeof param!='object'){
            msg=param;
            cb=arguments[1]||cb;
        }else{
            title=param.title||title;
            cb=param.callback||cb;
            msg=param.msg;
        }
        var ele=jQuery.messager.confirm(title,msg,cb);
        jQuery('.messager-window, .messager-window+.window-shadow').css('top',function(i,v){return Math.max(100,parseInt(v,10)-60);});
        $.noOutline();
        return ele.parent();
    },
    $alert:function(){
        return top._$alert.apply(this,[].slice.call(arguments));
    },
    $confirm:function(){
        return top._$confirm.apply(this,[].slice.call(arguments));
    },
    // 自动关闭提示框
    $show:function(str){
        return jQuery.messager.show({
            title:'提示',
            msg:str,
            showType:'fade',
            timeout:1500,
            showSpeed:500,
            width:220,
            height:120,
            style:{
                right:'50%',
                top:'50%',
                margin:'-120px -110px 0  0 '
            }
        });
        $.noOutline();
    },
    //右下角消息通知
    $msg:function(ops){
        typeof ops=='string' && (ops={msg:ops});
        return $.messager.show({
            title:ops.title||'<i class="icon-envelope-alt"></i> 新消息提醒',
            msg:ops.msg,
            timeout:ops.timeout||8000,
            width:ops.width||380,
            height:ops.height||210,
            showType:'slide'
        }).closest('.window').addClass('corner-msg '+ (ops.className||''));
    },
    $close:function(isTag){
        if(isTag){
            //关闭整个当前标签页
            var rootTabs=top.rootTabs||top.$('#root-tabs');
            var tab = rootTabs.tabs('getSelected');
            if (tab){
                var index = rootTabs.tabs('getTabIndex', tab);
                index!==0 && rootTabs.tabs('close', index);
            }
        }else{
            //关闭包含本iframe的模态窗
            var ifr=window.iframe;
            if(ifr){
                var win=top._mol_wins[ifr.getAttribute('win-id')];
                win && win.window('close');
            }
        }
    },
    $select:function(){
        var wraper=$(this.iframe).parentsUntil('.epanel','.epanel-body');
        return wraper.$select();
    },
    $append:function(src,label,onlyOnce,closable,iconCls){
        var rootTabs=top.rootTabs||top.$('#root-tabs');
        rootTabs.data('tab-urls') || rootTabs.data('tab-urls',{});
        var rootTabUrls=rootTabs.data('tab-urls');

        if(onlyOnce!==false && rootTabUrls[src]){
            var pbodys=rootTabs.find('>.tabs-epanels>.epanel>.epanel-body');
            var ele;
            pbodys.each(function(){
                if(!ele){
                    var url=top.$(this).data('tab-src');
                    if(src==url){
                        ele=top.$(this).$select();
                    }
                }
            });
            if(ele){
                return ele;
            }
        }
        rootTabUrls[src]=true;

        //给新页签注册一个id
        var id='root-tab-'+new Date().getTime();
        //把调用窗口登记到全局
        var openerId='opener-'+id;
        top._opener_wins[openerId]=this;
        var addTab=function(id){
            rootTabs.tabs('add',{
                title: label,//'Tab'+index,
                id:id,
                content:'<iframe class="tab-content-frame" src="{0}" opener-id="{1}" frameborder="0"></iframe>'.format(src,openerId),
                iconCls:iconCls||null,//'icon-reload',
                closable: closable!==false
            });
        };
        if(rootTabs.tabs('tabs').length>(parseInt(window.config.maxTabCount)||9)){
            top.$confirm('页签窗口过多!<br>将关闭最先打开的页签, 再打开新窗口。<br>是否继续?',function(res){
                if(res) {
                    rootTabs.tabs('close', 1);
                    addTab(id);
                }
            });
        }else{
            addTab(id);
        }
        return top.$('#'+id).data('tab-src',src).addClass('root-tab-one');
    },
    $ajax:function(url,params,cb,type,beforeSend,complete){
        var ag=arguments[0];
        if(typeof ag=='object'){
            url=ag.url, params=ag.data||ag.params, cb=ag.success||ag.callback, type=ag.type||type, beforeSend=ag.beforeSend, complete=ag.complete;
        }

        //for mock
        if(typeof url=='string' && url.match(/\/mock\/.+\.json/i)){
            type='GET';
        }

        params=params||{};
        var voidFn=function(){};
        if(beforeSend===false){
            beforeSend=voidFn;
        }else if(typeof beforeSend!='function'){
            beforeSend=function () {showLoading();};
        }
        if(beforeSend==voidFn){
            complete=voidFn;
        }else{
            complete=typeof complete=='function'?complete:function(){hideLoading()};
        }

        //typeof params =='object' && (params.token=top.token);

        //if(type!=='GET'){
        //params=obj2str(params);//post时避免自动将参数序列化为a=1&b=2的形式
        //}
        return $.ajax($.extend({
            type: type || "POST",
            url: url,
            headers:{
                'token':window.token||(window.token=localData.get('token'))
            },
            contentType: "application/json; charset=UTF-8",
            dataType: 'json',
            data: type=="GET"?params:obj2str(params),
            beforeSend: beforeSend,
        },typeof arguments[0]=='object'?arguments[0]:null)).always(function(res,status){
            complete(res,status);
            if(status == 'success'){
                if(res.flag==1){
                    typeof cb=='function' && cb(res);
                }else if(res.flag==0){
                    toast(res.msg||'后台请求失败').err();
                    warn('ajax请求失败!\n请求路径为:{0}\n请求参数为:{1}\n后台返回的错误信息为:{2}'.format(url,obj2str(params),res.msg||''));
                }else if(res.flag==-1){
                    toast('登录状态过期,请重新登录',function(){top.logout()});//top.location.replace('http://'+top.location.host+'/intoLogin');
                }
            }else{
                warn('$ajax请求地址错误或网络问题, status: {0}, action:{1} '.format(status,url));
            }
        });
    },
    $post:function(url,params,cb,beforeSend,complete){
        return $ajax(url,params,cb,'POST',beforeSend,complete);
    },
    $get:function(url,params,cb,beforeSend,complete){
        return $ajax(url,params,cb,'GET',beforeSend,complete);
    },
    action2link:function(action){
        return action + (action.indexOf('?')>-1 ? '&token={0}'.format(top.token) : '?token={0}'.format(top.token));
    },
    act2link:this.action2link,
    makeAct:function(act,log){
        var url='/'+act;
        var acts=window.config.mock?window.config.mockActions:window.config.actions;
        var concat=arguments[1]||'api';//默认在service 和 action 中间用api连接
        var baseRestPath=window.config.restfuls[0]+'/'+window.getPrjName()+'/'+concat+'/';
        act=act.replace(/^\//,'').replace(/\?.+/,'');
        if(!acts[act]){
            acts[act]=window.config.mock?window.getDistPath('mock/{0}.json'.format(act.replace(/\/|\./g,'-'))):act;
        }
        //console.log(act);
        //arguments.caller && console.info(arguments.caller.toString());
        return acts[act].indexOf('http')==0 ? acts[act] :
            (window.config.mock ? acts[act] : baseRestPath+acts[act] ); //||(window.path+url);
    },
    //内容在4行内的不显示“更多”
    isShowMore:function (selector){
        var container=$(selector||document.body);
        var letterNum = 140;
        var showMore = function (el,letterNum) {
            var elHtml = el.innerHTML.replace(/\n/gm,'<br>'),
                letterNum = letterNum,
                elBriefHtml = '',
                elHtmlLen = elHtml.length,
                $el = $(el),
                $aObj = $el.next(),
                moreId = $aObj.attr('moreId'),
                mt = elHtml.match(/<br/gm);
            //var allFixWrap=$($aObj).closest('.all-fix-wrap');
            //var nativeTable=$($aObj).closest('.native-fix-wrap>table');
            if(elHtmlLen>letterNum ){//|| (mt && mt.length > 3)
                elBriefHtml = elHtml.substring(0,letterNum);
                $el.html(elBriefHtml);
                $aObj.show();
                $aObj.on('click',function () {
                    toggleMore(this,moreId,letterNum,elHtml,elBriefHtml);
                    //allFixWrap.length && allFixWrap.children('.native-fix-wrap').children('table').trigger('refitFix');
                    //nativeTable.trigger('refitFix');
                    container.find('.native-fix-wrap>table').trigger('refitFix');
                });
            }
        };
        $(selector||'body').find('p.brief-content').each(function(index,el){
            showMore(el,letterNum);
        });
        container.find('.native-fix-wrap>table').trigger('refitFix');
        letterNum = null;
    },
    //显示更多、收起
    toggleMore:(function () {
        var isShow = [];//isShow = [{id:'1u',show:true},{id:'2c',show:false}];
        return function (obj,id,letterNum,elHtml,elBriefHtml) {
            var isShowLen = isShow.length,
                moreId = id,
                isMatch = false,//默认false,没有点击过,isShow数组里没有它的id
                i=0,
                obj = $(obj);
            
            for(;i<isShowLen;i++){
                if(isShow[i].id === moreId){
                    if(isShow[i].show){
                        obj.text('收起').prev().html(elHtml);
                        isShow[i].show = false;
                    }else{
                        obj.text('更多').prev().html(elBriefHtml);
                        isShow[i].show = true;
                    }
                    isMatch = true;
                }
            }
            if(!isMatch){
                obj.text('收起').prev().html(elHtml);
                isShow.push({id:moreId,show:false});
            }
        };
    })()
};



