/**
 * Created by evans on 16/12/15.
 */
if(window==top){
    window.extending({
        $window:window.mainFrame.contentWindow,
        $document:window.mainFrame.contentWindow.document,
        $$:window.mainFrame.contentWindow.$
    });
}
module.exports= {
    $open: function (str, params, isAjax, cb) {
        //var useFullWrap=params.useFullWrap||window.config.useFullWrap||params.width=='max';
        //parseInt(params.width)<921 && (useFullWrap=false);
        //useFullWrap && window.parent==top && $(window.frameElement).parent().addClass('full-wrap');
        if (window != top) {
            var scrollY = document.body.scrollTop;
            var scrollX = document.body.scrollLeft;
            top.$('body').hasClass('sb-l-m') ? $(document.body).addClass('in-sb-l-m-full-wrap') : $(document.body).addClass('in-full-wrap');
            top.$('#main-wrap').addClass('full-wrap');
        }
        var rootSlideMenu = top.byid('root-menu') || {};//top.rootMenu[0];
        var maxWidth = window.innerWidth;//30
        var maxHeight;
        var maxobj, maxobj2;
        var fixBarHeight = 48;
        var fixBtn = function (ele) {
            //var btnWrap = ele.find('[class$="-btn"]').last().parent('div,p');
            //var openWin = ele.closest('.window');
            //ele.find('.open-win-fix-btn,.open-no-fix-btn').length || ((btnWrap.is('[class*="dict-"]') || btnWrap.length<1 ) || (btnWrap.addClass('open-win-fix-btn') && openWin.css('padding-bottom','48px')));
            ele.children('.win-fix-bar').length && ele.closest('.window').addClass('has-fix-bar');
        };
        //简写小,中,大 3种尺寸
        if (params == 's' || params == 'S') {
            params = {width: 360};
        } else if (params == 'm' || params == 'M') {
            params = {width: 640};
        } else if (params == 'l' || params == 'L') {
            params = {width: 920};
        }
        else if (typeof params == 'string') {
            return window.$append.apply(this, [str, params, arguments[2]]);
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

        params.fixBar === false && (fixBarHeight = 0);

        (params.width == 'max' || params.width > window.innerWidth) && (params.width = window.innerWidth); //-10);
        // params.style['margin-left']=5-5;//因为eui会自动生成left,值为 (window宽度-弹窗宽度)/2

        (params.height == 'max' || params.height > window.innerHeight) && (params.height = window.innerHeight); //-20);

        //window===top && (params.mask='no-need-help');
        //if(useFullWrap) {
        //    (params.mask = 'as-global') && (params.center = 'as-global');
        //    var fn = params.onClose;
        //    params.onClose = function () {
        //        $(window.frameElement).parent().removeClass('full-wrap');
        //        typeof fn == 'function' && fn();
        //    }
        //}

        //if(params.mask=='global'){
        //    var hasMask = false;
        //    $('.window-mask').each(function (i,ele) {
        //        $(ele).css('display')=='block' && (hasMask = true);
        //    });
        //useFullWrap||top.$('#main-wrap').hasClass('full-wrap')||top.showHelpMask(window.width+30>top.width);
        //$('body').addClass('overflowHidden');
        //document.body.clientHeight>window.height && $('body').addClass('holdScrollWidth');
        var fn = params.onClose;
        params.onClose = function () {
            if (window != top && $(document.body).children('.window.animated').length == 0) {
                top.$('#main-wrap').removeClass('full-wrap');
                $('body').removeClass('in-full-wrap in-sb-l-m-full-wrap');
                document.body.scrollTop = scrollY;
                document.body.scrollLeft = scrollX;
            }
            //useFullWrap && $(window.frameElement).parent().removeClass('full-wrap');
            typeof fn == 'function' && fn();
            //useFullWrap||hasMask||top.hideHelpMask();
            //$('body').removeClass('overflowHidden').removeClass('holdScrollWidth');
        };
        //params.top=params.top||(useFullWrap?50:5);
        //maxHeight=window.innerHeight-25;
        //if(params.center=='global'){
        //params.style['margin-left']=Math.max(getRect(rootSlideMenu).width/-2);
        //var slideWidth=getRect(rootSlideMenu).width;
        //var residue=window.innerWidth-parseInt(params.width);
        //var maxLeft=params.width ? residue/-2 : -Infinity;//log(window.innerWidth)
        //var marginLeft=Math.max(slideWidth/-2, residue<slideWidth ? 0:Math.min(maxLeft,0) );
        //如果不够调整为全局居中就放弃,让eui自动在内部居中即可
        //正数的marginLeft是因为 弹窗宽度大于窗口宽度了, 导致eui生成的left为负值往左缩入. 这个时候即使用marginLeft正值右移也是没用的. 因为弹窗宽度太大, 左边显示了,右边也是放不下的.info(marginLeft)
        //('margin-left' in params.style) || (params.style['margin-left']=marginLeft);//Math.min(0,marginLeft);
        //}
        //}else{
        //    params.top=params.top||Math.min((window.innerHeight-~~params.height)/2,40);
        //maxHeight=window.innerHeight-65;
        //maxHeight=window.innerHeight-45;
        //}
        maxobj = {};//useFullWrap?{maxHeight:maxHeight}:{maxWidth:maxWidth,maxHeight:maxHeight};
        maxobj2 = {visibility: 'visible'};//useFullWrap?{visibility:'visible',maxHeight:maxHeight-36-fixBarHeight}:{visibility:'visible',maxWidth:maxWidth-20,maxHeight:maxHeight-36-fixBarHeight};//36+48=84,36为弹窗自带的title条的高度,48为底部固定按钮的高度
        //先分辨是已有元素还是自动生成后ajax加载html或iframe的元素,随后启动,并返回句柄
        var ele = arguments[0].jquery ? arguments[0] : null;
        if (ele || str.indexOf('#') == 0) {
            ele = $(str).addClass('e-win-wrap');
            //ele.hasClass('window-body') && ele.hasClass('window-body,pannel-body') && ele.unwrap();
            //eui会缓存生成后的弹窗结构及位置, 因此要重置水平居中 ,来防止两次点击弹窗期间窗口大小变化引起的居中位置失准
            // return ele.css({visibility:'hidden'}).show().window(params).window('hcenter').css(maxobj2).parent().addClass('animated fadeInDown').css(maxobj).end();
            // 模拟全局弹窗后垂直居中不准,因此放弃.window('hcenter'),改为手动设置top,为了兼容和不与其他样式冲突,暂不用CSS3设置垂直居中样式来解决
            //ele.css({visibility:'hidden'}).show().window(params).window('hcenter').css(maxobj2).parent().addClass('animated fadeInDown hcenter').css(maxobj).end();
            params.top || (params.top = 60);
            maxobj.maxHeight = top.innerHeight - 65;
            maxobj.overflowY = 'auto';
            ele.css({visibility: 'hidden'}).show().window(params).css(maxobj2).parent().addClass('animated fadeInDown').css(maxobj).end();
            fixBtn(ele);
        } else if (isAjax) {
            ele = $('<div class="e-win-wrap" dynamic>').css({overflow: params.scroll ? 'auto' : 'hidden'});
            if (window.loadHTMLCache[str]) {
                ele.window(params).css(maxobj2).html(window.loadHTMLCache[str]).parent().addClass('animated fadeInDown').css(maxobj).end();
                setTimeout(function () {
                    cb && cb();
                }, 0);
                fixBtn(ele);
            } else {
                ele.window(params).css(maxobj2).load(getViewPath(str), function (res) {
                    window.loadHTMLCache[str] = res;
                    cb && cb();
                    fixBtn(ele);
                }).parent().addClass('animated fadeInDown').css(maxobj).end();
            }
        } else {
            str = getViewPath(str);
            var id = '' + Date.format('MMDDhhmmssS');
            maxobj.maxHeight = window.innerHeight; //-25;
            maxobj2.maxHeight = maxobj.maxHeight - 36;
            ele = $('<div class="e-win-wrap overhide" dynamic win-id="{1}"><iframe scrolling="{0}" win-id="{1}"></iframe></div>'.format(params.scroll ? 'auto' : 'no', id));
            //setTimeout(function(){
            (top._mol_wins[id] = ele.window(params).css(maxobj2).find('iframe').attr('src', str).end().parent().addClass('animated fadeInDown').css(maxobj).end());
            //},0);
        }
        ele.data('open-params', params);//只有原有元素的弹窗可以缓存参数,用于直接发动 $('#mydiv').open();
        //hasMask && $('.window-mask').last().css('background-color','transparent');
        ele.on('click', '.cm-cancel-btn,.win-close-btn', function () {
            $(this).closest('.window-body').$close();
        });
        return ele;
    }
}/**
 * Created by evans on 16/12/15.
 */
