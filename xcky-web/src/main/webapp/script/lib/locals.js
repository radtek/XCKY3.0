/**
 * Created by evans on 16/5/22.
 **/


var prefix='@prj:'+window.getPrjName()+'-';

var localParamsInit=function(_modules){
    var localParams={};
    var _set=function(module,key,val){
        return localParams['set'](module+key,val);
    };
    var _get=function(module,key,val){
        return localParams['get'](module+key,val);
    };
    // _modules={global:null, sys:null, reports:null, prjWatch:null, fstPage:null, infoMng:null, feedBack:null};
    var obj={
        set:function(key,val){
            key=prefix+key;
            localStorage['params@'+key]=val;
            return true;
        },
        get:function(key){
            key=prefix+key;
            return localStorage['params@'+key];
        }
    };
    _modules.push('global');
    //for(var n in _modules){
       // var space=n=='global'?'':n+'@';
       // obj[n]={
    for(var i= 0;i<_modules.length;i++){
        var space=_modules[i]=='global'?'':_modules[i]+'@';
        obj[dash2camel(_modules[i])]={
            get:function(space){return function (key,val) {return _get(space,key);}}(space),
            set:function(space){return function (key,val) {return _set(space,key,val);}}(space)
        };
    }
    localParams.extending(obj);
    window.extending({localParams:localParams});
}



var localData={};
localData.extending({
    set:function(key,val){
        key=prefix+key;
        if(val==null){
            localStorage[key]='null';
        }
        if(typeof val=='string'){
            localStorage[key]=val;
        }
        if(typeof val=='number'){
            localStorage[key]="[number]:"+val;
        }
        if(typeof val=='boolean'){
            localStorage[key]="[boolean]:"+val;
        }
        if(typeOf(val)=='date'){
            localStorage[key]="[date]:"+val.getTime();
        }
        else{
            try {
                localStorage[key] = JSON.stringify(val);
            }catch(e){
                localStorage[key] = String(val);
            }
        }
        return true;
    },
    get:function(key){
        key=prefix+key;
        var obj;
        var val=localStorage[key];
        if(typeof val!='string'){
            return val;
        }
        else if(val==='null'){
            return null;
        }
        else if(val.indexOf('[number]:')==0){
            return +(val.slice(9));
        }
        else if(val.indexOf('[boolean]:')==0){
            return val.slice(10)==='true';
        }
        else if(val.indexOf('[date]:')==0){
            return new Date(+(val.slice(7)));
        }else{
            try{
                obj=JSON.parse(val);
            }catch(e){
                obj=String(val);
            }
            return obj;
        }
    }
});

var registryInit=function(){
    if(window==top){
        window.extending({
            //注册中心
            registry:(function(){
                var obj={};
                for(var i=0;i<window.molDatas.length;i++){
                    obj.extending(dash2camel(window.molDatas[i].molNo),{});
                }
                obj.extending('global',{});
                return obj;
            })()
        });
    }
    //else{
    //    window.extending({
    //        registry:top.registry
    //    });
    //}
};

module.exports=({
    localData:localData,
    //因为下面两个是对应系统模块下分模块的,因此需要提供init方法,以供index.js中取得LIMITS配置后生成
    localParamsInit:localParamsInit,
    registryInit:registryInit
    //localParams:localParams
});

