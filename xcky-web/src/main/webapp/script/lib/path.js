//window.path=typeof top.path=='string'? top.path:location.href.replace(/index2?\.(html|jsp)/,'').replace(/\/dist\/view\/.*/,'');
window.path=window.path||localData.get('path')||''; //top.path:location.href.replace(/index2?\.(html|jsp)/,'').replace(/\/dist\/view\/.*/,'');

//window.distPath= location.protocol!='file:'? window.path+'/dist/': (location.pathname.match(/\/index\.html|\/login\.html|\\index\.html|\\login\.html/) ? './' : '../');
window.getDistPath=function (src){
    src=src||'';
    if(!config.isLocal){//location.protocol!=='file:'){
        return window.path+'/dist/'+src;
    }else{
        var str=location.href;
        var k=''
        var i=str.indexOf('/view/');
        var j=str.indexOf('/plugin/');
        if(i>-1){
            for(i=i+6;i<str.length;i++){
                (str[i]=='/') && (k+='../');
            }
        }else if(j>-1){
            for(j=j+8;j<str.length;j++){
                (str[j]=='/') && (k+='../');
            }
        }
        return (location.pathname.match(/\/index\.html|\/login\.html|\\index\.html|\\login\.html/) ? './' : k+'../')+src;
    }
};
window.getSrcPath=function(src){
    if(src.match(/^https?|^\.|^\//i)){
        return src;
    }
    if(src.match(/.*.css$/i)){
        return window.getDistPath()+'css/'+src;
    }
    if(src.match(/.*.js$/i)){
        return window.getDistPath()+'js/'+src;
    }
    if(src.match(/.*.html$/i)){
        return window.getDistPath()+'view/'+src;
    }
};
window.getViewPath=function (src,prefix){
    var viewPrePath;
    if(src.match(/^https?|^\.|^\//i)){
        return src;
    }
    if(prefix){
        viewPrePath=prefix;
    }else{
        viewPrePath= window.getDistPath()+'view/';//index.html和login.html是例外,两者一般不需要被引用,需要时用getDistPath('index.html')
    }
    var querySymbol=viewPrePath.indexOf('?')>-1?'&':'?';
    return viewPrePath+(src||'404.html')+  querySymbol +'version='+window.config.version;
};
window.getMap_server= function () {
    var p= localData.get('sysParams') ? localData.get('sysParams')['defaultMapServer'] : '';
    p=p||window.config.mapServerPath;
    if(!p){
        throw new Error('the mapServerPath is empty or undefined!');
    }
    return p;
};