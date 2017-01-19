/**
 * Created by Evany Yao on 2016/9/27.
 */

(function(){

    if(window!==top && !config.isLocal && (window.originSrc=window.iframe.getAttribute('o-src'))&&((location.pathname+location.search)!==originSrc)){
        console.info(location.pathname+location.search);
        console.error('状态过期,请刷新页面\n'+originSrc);
        top.document.body.innerHTML='<br><h2>状态过期,请刷新页面\n</h2>';
        //location.href=originSrc;
    }

    //处理键盘事件 禁止后退键（Backspace）密码或单行、多行文本框除外
    var banBackSpace=function (e){
        var ev = e || window.event;//获取event对象
        var obj = ev.target || ev.srcElement;//获取事件源
        var t = obj.type || obj.getAttribute('type');//获取事件源类型
        var editable = obj.hasAttribute('contenteditable');
        //获取作为判断条件的事件类型
        var vReadOnly = obj.getAttribute('readonly');
        var vEnabled = obj.getAttribute('enabled');
        //处理null值情况
        vReadOnly = (vReadOnly == null) ? false : vReadOnly;
        vEnabled = (vEnabled == null) ? true : vEnabled;
        //当敲Backspace键时，事件源类型为密码或单行、多行文本的，
        //并且readonly属性为true或enabled属性为false的，则退格键失效
        var flag1=(ev.keyCode == 8 && (t=="password" || t=="text" || t=="textarea") && (vReadOnly==true || vEnabled!=true))?true:false;
        //当敲Backspace键时，事件源类型非密码或单行、多行文本的，则退格键失效
        var flag2=(ev.keyCode == 8 && t != "password" && t != "text" && t != "textarea" && !editable) ?true:false;
        //判断
        if(flag2){
            return false;
        }
        if(flag1){
            return false;
        }
    };
    //禁止后退键 作用于Firefox、Opera
    //document.onkeypress=banBackSpace;
    //禁止后退键 作用于IE、Chrome
    document.onkeydown=banBackSpace;
    //document.attachEvent ? document.attachEvent('onkeydown',banBackSpace):  document.addEventListener('keydown',banBackSpace,false);

    $('.query-block').each(function(){
        this.addEventListener('click',function(){
            var $this=$(this);
            var oldHeight=$this[0].scrollHeight;
            setTimeout(function(){
                var newHeight=$this[0].scrollHeight;
                newHeight==oldHeight || $('.query-result').find('.native-fix-wrap>table').each(function(){
                    var $this=$(this);
                    var mode=$this.attr('fixed-mode');
                    mode && $this.fixTable(mode);
                });
            },500)
        },false);
    });
})();

