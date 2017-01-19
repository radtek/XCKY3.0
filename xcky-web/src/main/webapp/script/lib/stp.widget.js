/**
 * Created by yao on 2016/12/12.
 */

var voidFn=function(){};
var nullObj={_null_:''};//'just for make a no-empty data for template'};
var getData=function(data){
    return $.extend(data,nullObj);//注意顺序,会产生意外的同一引用
};
var templateFn=function(html,data){
    //var $this=$(this);
    return $($compile(html,data));
};
function getWigetParams(ele){
    var obj={};
    var attrs=[].slice.call(ele.attributes).where('a=>a.name.slice(0,2)=="w-"');
    attrs.each(function(a) {
        obj[a.name.slice(2)] = a.value;
    });
    return obj;
}
window.extending({_widgets_:Object.create(null)});

window.$widget=window.$widget||function(name,defineder) {
    window._widgets_[name]= window._widgets_[name]||defineder();
};

if(typeof module === "object" && typeof module.exports === "object" ){
    module.exports={
        reg:function(ags){
            if(window._concatDone_!==true){

                var list=window._includeList_=$('div,p').filter('[replace],[include],[widget]');
                var importArr=[];
                window._includeArr=[];

                list.each(function(){
                    var $this=$(this);
                    if($this.attr('widget')){
                        var widget=window._widgets_[$(this).attr('widget')];
                        importArr=importArr.concat(widget.importing||[]);

                        window._includeArr.push(widget.template.indexOf('<')==0?'':widget.template);
                    }else{
                        window._includeArr.push($this.attr('include')||$(this).attr('replace')||[]);

                    }
                    //throw new Error('these attr:include or replace, widget can not be empty');
                });


                importArr=importArr.concat(window._includeArr);

                window._concatDone_=true;

                if(importArr.length){
                    var newArgs=importArr.concat(ags).distinct();
                    //log('进入reg; only-one; 将运行importing()')
                    return function(){
                        window.importing.apply(null,newArgs);
                    };
                }
            }else{
                //log('未运行reg');
                return null;
            }

        },
        init:function(){
            window._includeList_.each(function(i){
                var $this=$(this);
                var data=getData($this.data());
                var html=window._includeArr[i]?window.loadHTMLCache[window._includeArr[i]]:'';


                if(this.hasAttribute('widget')){
                    var widget=window._widgets_[this.getAttribute('widget')];
                    if(!widget){
                        return false;
                    }
                    if(html==''){
                        html=widget.template;
                    }
                    if(this.hasAttribute('no-auto')){
                        // var boot=widget.boot||function(html){ return $(html);};
                        // var newEle= boot.apply(this,[html,data]);
                        var newEle=$(html);
                        $this.replaceWith(newEle);
                        //template等importing完成后手动定义data再进行, 之后手动trigger('ex-init')
                        //newEle.template($scope[newEle.attr('stp-data')]);
                        newEle.on('ex-init',function (e,ele,triggerData) {
                            //info([newEle,ele,newEle[0]==ele[0]])
                            widget.init.call(this,triggerData);
                        });
                    }

                    var boot=widget.boot||templateFn;
                    var newEle= boot.apply(this,[html,data]);
                    $this.replaceWith(newEle);
                    widget.init.call(newEle,data);
                }
                else if(this.hasAttribute('replace')){
                    $this.replaceWith($compile(html,data,true));
                }
                else if(this.hasAttribute('include')){
                    //template在此莫名产生异步问题, importing回调中元素已经生成, 可以获取html, 但无法注册事件, 可能页面标签未闭合
                    //$this.template($compile(html,data,true)).attr('include','');
                    $this.html($compile(html,data,true)).attr('include','');
                }
                else if(this.hasAttribute('template')){
                    $this.template(data,true).attr('template','');
                    //if(this.hasAttribute('tpdata')){
                    //    var tpdata=this.getAttribute('tpdata');
                    //    tpdata && $this.template(str2obj(tpdata,true));
                    //}else{
                    //    $this.template();
                    //}
                }
            });
        }
    }
}