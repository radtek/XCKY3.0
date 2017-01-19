/**
 * Created by evans on 16/11/27.
 */
(function(context){
    Object.defineProperty(Object.prototype,'extending',{
        value:function() { //name,val or obj
            var obj={};
            typeof arguments[0]=='object'? (obj=arguments[0]):(obj[arguments[0]]=arguments[1]);
            for(var n in obj){
                Object.defineProperty(this, n, {
                    value: obj[n],
                    writable:false, enumerable:arguments[arguments.length-1]===true, configurable:false
                });
            }
        },writable:false, enumerable:false, configurable:false
    });
    Object.defineProperty(Object.prototype,'getting',{
        value:function() { //name,getter or obj
            var obj={};
            typeof arguments[0]=='object'? (obj=arguments[0]):(obj[arguments[0]]=arguments[1]);
            for(var n in obj){
                Object.defineProperty(this, n, {
                    get:obj[n],enumerable:arguments[arguments.length-1]===true, configurable:false
                });
            }
        },writable:false, enumerable:false, configurable:false
    });
})(window);

Object.prototype.extending('fixing',function(key){
    Object.defineProperty(this, key, {
        writable:false,
        configurable:false
    });
});

window.extending(window===top ?{_mol_wins:{},_opener_wins:{}}:{$window:top.$window,$document:top.$document,$$:top.$$});

window.getting({
    doc:function(){return document.documentElement;},
    width:function(){return this.innerWidth;},
    height:function(){return this.innerHeight;},
    scrollTop:function(){return document.documentElement.scrollTop||document.body.scrollTop;},
    scrollLeft:function(){return document.documentElement.scrollLeft||document.body.scrollLeft;},
    iframe:function(){
        //if(window===top)return null;
        //var frs=parent.document.getElementsByTagName('iframe');
        //for(var i=frs.length-1;i>-1;i--){
        //    if(frs[i].contentWindow==self){return frs[i];}
        //}
        //return null;
        return window.frameElement;
    },
    $opener:function(){
        var openerId=this.iframe.getAttribute('opener-id');
        return top._opener_wins[openerId];
    }
});

window.extending('getPrjName',function(){
    // var querys=window.queryParse()||Object.create(null);
    // var prjName=querys['prj-name']||window.config.prjName;
    // return prjName;
    return window.config.prjName;
});