/**
 * Created by yao on 2017/1/17.
 */
var dict=Object.create(null);
var $state={
    go:function(name){
        var stater=dict[name];
        var imports=stater.importing||[];
        var view=stater.view;
        var isFrame=view.match(/.html$/);

        $state.current=top.currentPageNo=name;

        //处理frame跳转
        if(isFrame){
            $state.ct.addClass('hide-plus').empty();
            $state.frame.removeClass('hide-plus');
            $state.frame[0].src=getViewPath(view);
            $state.frame.attr('page-no',name);
        }
        //处理单页路由
        else{
            window.importing.apply(null,imports.concat(view).concat(function(scope){
                $state.frame.addClass('hide-plus');
                $state.ct.removeClass('hide-plus').tpsource(view).template();
                typeof stater.init=='function' && stater.init(scope);
            }));
        }
        return $state;
    },
    on:function (name,stater) {
        if(!dict[name]){
            dict[name]=stater;
        }else{
            $.extend(dict[name],stater);
        }

        return $state;
    },
    current:null,
    ct:null,
    frame:null
};


if(typeof module === "object" && typeof module.exports === "object" ){
    module.exports=$state;
}