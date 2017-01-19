/**
 * Created by evans on 16/12/15.
 */
$.fn.hidden=function(){};
$.fn.visible=function(){};
module.exports= {
    $open: function (str, params, isAjax, cb) {
        var ele;
        var body=document.body;
        var innerMaxCss={}, outerMaxCss={},maxHeight,maxWidth;
        var rootSlideMenu = top.byid('root-menu') || {};
        //var fixBarHeight = window.config.winFixBarHeight||params.fixBarHeight||48;

        //固定底部按钮
        var fitLayout = function (ele) {

            var win=ele.closest('.window');
            var panelHead=win.children('.epanel-header');
            var fixBar=ele.children('.win-fix-bar');

            win.addClass('hidden');

            outerMaxCss = {maxHeight:maxHeight};
            innerMaxCss = {maxHeight:maxHeight,overflowY:'auto'};

            outerMaxCss.maxHeight=outerMaxCss.maxHeight-5;
            innerMaxCss.maxHeight=innerMaxCss.maxHeight-5;

            if(panelHead.length){
                var headHeight=getRect(panelHead[0]).height;
                innerMaxCss.maxHeight=innerMaxCss.maxHeight-headHeight;
            }

            if(fixBar.length){
                //win.addClass('has-fix-bar');
                var barHeight=getRect(fixBar[0]).height;
                innerMaxCss.maxHeight=innerMaxCss.maxHeight-barHeight;
                outerMaxCss.paddingBottom=barHeight;
            }

            win.css(outerMaxCss);
            ele.css(innerMaxCss);

            //info([params.height,innerMaxCss.maxHeight,outerMaxCss.maxHeight,outerMaxCss.maxHeight-])

            win.removeClass('hidden');
            ele.on('click', '.cm-cancel-btn,.win-close-btn', function () {
                $(this).closest('.window-body').$close();
            });
        };

        var calcSize=function(win){

            if(params.width == 'max'){
                params.width=win.width-20;
            }
            else if(params.width == 'full'){
                params.width=win.width;
            }

            if(params.height == 'max'){
                params.height=win.height-20;
                params.top=10;
            }
            else if(params.height == 'full' || parseInt(params.height) > win.height){
                params.height=win.height;
                params.top=0;
            }
            else{
                params.top=params.top||Math.min((win.height-~~params.height)/2,win==top?60:0);
            }
            maxHeight=win.height-params.top;
            //outerMaxCss = {maxHeight:maxHeight,overflowY:'auto'}
            //innerMaxCss = {visibility:'visible',maxHeight:maxHeight-36};//-fixBarHeight};//36+48=84,36为弹窗自带的title条的高度,48为底部固定按钮的高度

        };

        //tab弹窗转用$append
        if (typeof params == 'string') {
            return window.$append.apply(this, [].slice.call(arguments));
        }

        //默认不可缩小拉伸,模态显示,允许滚动条,空白标题
        ('maximizable' in params) || (params.maximizable = false);
        ('minimizable' in params) || (params.minimizable = false);
        ('collapsible' in params) || (params.collapsible = false);
        ('resizable' in params) || (params.resizable = false);
        ('scroll' in params) || (params.scroll = true);
        ('modal' in params) || (params.modal = true);
        ('cache' in params) || (params.cache = false);
        ('doSize' in params) || (params.doSize = true);
        ('shadow' in params) || (params.shadow = false);
        ('title' in params) || (params.title = ' ');
        ('height' in params) || (params.height = 'auto');
        ('mask' in params) || (params.mask = 'global');
        ('style' in params) || (params.style = {});//'max-height':window.height-20+'px', 'max-width':window.width-20+'px'});
        ('center' in params) || (params.center = 'global');


        //小于921的完全可以用辅助遮罩模式
        //if(parseInt(params.width)<921 && params.mode=='full-wrap'){
        //    params.mode=='help-mask';
        //}

        //var fn = function(ele){
        //    (params.onClose||window.voidFn)();
        //    ele[0].id=ele[0].id||('eui-win-'+new Date().getTime());
        //    $(body).data('open-params', params); //目前只有原有元素的弹窗可以缓存参数,用于直接发动 $('#mydiv').open();
        //}
        var fn = params.onClose||window.voidFn;


        //三种模态方
        if (window != top) {
            var topMain=top.$('#admin-design-main');//top.$('body>div:first-child');
            var topMainWrap=top.$('#main-wrap');
            var bodyAgent=$(body).children('.body-agent')[0]||$(body).children(':first-child')[0];


            //避免引发重绘
            window._cancelGlobalReFixTbTime=new Date().getTime();

            //延续上一个弹窗的模式
            if(topMain.hasClass('full-win-mode')){
                params.mode='full-win';
            }
            else if(topMain.hasClass('help-mask-mode')){
                params.mode='help-mask';
            }
            else{
                params.mode=params.mode||'trans-agent';
            }

            topMain.addClass(params.mode+'-mode');

            //辅助遮罩方案
            if(params.mode=='help-mask'){

                calcSize(window);

                var scrollTop=body.scrollTop;
                var disabledScroll=function(){body.scrollTop=scrollTop};
                $(window).on('scroll',disabledScroll);

                //废弃,改用addClass控制help-mask显示/隐藏
                //topMainWrap.hasClass('full-wrap')||top.showHelpMask(window.width+30>top.width);

                //暗化滚动条(仍然可滚)
                //$(body).addClass('darken-scroll');

                //彻底禁用滚轮会影响弹窗自身滚动
                //window.disabledMouseWheel(bodyAgent);

                //使用overflow:hidden
                //var completedCSS=getComputedStyle(body);
                //var scrollDis=body.scrollHeight-window.height-parseInt(completedCSS['margin-top'])-parseInt(completedCSS['margin-bottom']);
                //$(body).addClass(scrollDis>0 ? 'holdScrollWidth overflowHidden':'overflowHidden');

                params.onClose = function () {
                    if($(body).children('.window-mask:visible').length==0){

                        $(window).off('scroll',disabledScroll);
                        topMain.removeClass('trans-agent-mode help-mask-mode full-win-mode');

                        //以上对应的四种返回方式
                        //top.hideHelpMask();
                        //$(body).removeClass('darken-scroll');
                        //window.enabledMouseWheel(bodyAgent);
                        //$(body).removeClass('overflowHidden holdScrollWidth');
                    }
                    fn(ele);
                };

                var slideWidth=getRect(rootSlideMenu).width;
                var residue=window.innerWidth-parseInt(params.width);
                var maxLeft=params.width ? residue/-2 : -Infinity;//log(window.innerWidth)
                var marginLeft=Math.max(slideWidth/-2, residue<slideWidth ? 0:Math.min(maxLeft,0) );
                //如果不够调整为全局居中就放弃,让eui自动在内部居中即可
                //正数的marginLeft是因为 弹窗宽度大于窗口宽度了, 导致eui生成的left为负值往左缩入. 这个时候即使用marginLeft正值右移也是没用的. 因为弹窗宽度太大, 左边显示了,右边也是放不下的.info(marginLeft)
                ('margin-left' in params.style) || (params.style['margin-left']=marginLeft);//Math.min(0,marginLeft);



            }
            //最大化frame方案
            else if(params.mode=='full-win'){

                calcSize(top);

                topMainWrap.addClass('full-wrap');
                params.top=params.top||50;
                params.onClose = function () {
                    topMain.removeClass('trans-agent-mode help-mask-mode full-win-mode');

                    topMainWrap.removeClass('full-wrap');
                    $(body).removeClass('overflowHidden').removeClass('holdScrollWidth');
                    fn(ele);
                };



            }
            //移形换影方案 mock-agent
            else{
                calcSize(top);

                var scrollY = body.scrollTop;
                var scrollX = body.scrollLeft;
                $(body).addClass(top.$('body').hasClass('sb-l-m') ?'in-sb-l-m-full-wrap':'in-full-wrap');
                topMainWrap.addClass('full-wrap mock-agent');
                bodyAgent.scrollTop=scrollY;

                params.onClose = function () {
                    if ($(body).children('.window.animated').length == 0) {
                        topMain.removeClass('trans-agent-mode help-mask-mode full-win-mode');

                        topMainWrap.removeClass('full-wrap');
                        $(body).removeClass('in-full-wrap in-sb-l-m-full-wrap');
                        body.scrollTop = scrollY;
                        body.scrollLeft = scrollX;
                    }
                    fn(ele);
                };
            }

        }else{
            //calcSize(window);
        }


        //三种加载方式
        ele = arguments[0].jquery ? arguments[0] : null;


        if (ele || str.indexOf('#') == 0) {


            ele = $(str).addClass('e-win-wrap');
            //innerMaxCss.overflowY = 'auto';
            ele.show().window(params).window('hcenter')
                .parent().addClass('animated fadeInDown').end();
            fitLayout(ele);


        }
        else if (isAjax) {


            ele = $('<div class="e-win-wrap" dynamic>').css({overflow: params.scroll ? 'auto' : 'hidden'});

            if (window.loadHTMLCache[str]) {

                ele.window(params).css(outerMaxCss).html(window.loadHTMLCache[str])
                    .parent().addClass('animated fadeInDown').css(innerMaxCss).end();

                setTimeout(function () {
                    cb && cb();
                }, 0);

                fitLayout(ele);

            } else {

                ele.window(params).css(outerMaxCss).load(getViewPath(str), function (res) {

                    window.loadHTMLCache[str] = res;
                    cb && cb();
                    fitLayout(ele);

                }).parent().addClass('animated fadeInDown').css(innerMaxCss).end();
            }


        }
        else {


            str = getViewPath(str);

            var id = '' + Date.format('MMDDhhmmssS');

            ele = $('<div class="e-win-wrap overhide" dynamic win-id="{1}"><iframe scrolling="{0}" win-id="{1}"></iframe></div>'.format(params.scroll ? 'auto' : 'no', id));

            //setTimeout(function(){
            top._mol_wins[id] = ele.window(params).css(outerMaxCss)
                                    .find('iframe').attr('src', str).end()
                                    .parent().addClass('animated fadeInDown').css(innerMaxCss).end();
            //},0);


        }

        ele.data('open-params', params); //目前只有原有元素的弹窗可以缓存参数,用于直接发动 $('#mydiv').open();

        //hasMask && $('.window-mask').last().css('background-color','transparent');


        return ele;
    }
}