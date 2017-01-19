/**
 * Created by yao on 2016/11/21.
 */
window.$filter=function(fliterName,fn,theType){
    if(theType){
        theType.prototype.extending(fliterName,fn);
    }else{
        String.prototype.extending(fliterName,fn);
        Number.prototype.extending(fliterName,fn);
    }
};
