(function(){
    var basePath=window.getDistPath()+'mock/';
    //var mockActions={
    //    login:1,
    //    loginTitle:1,
    //    dictGxsdm:1,//管辖所代码
    //    systemXtdhList:1,
    //    systemMessageList:1,
    //    appMyappsAlllist:1,
    //    jsglNoticViewInit:1,
    //    jsglTechnicianPersonInfo:1,
    //    statSbtjEcharts:1,
    //    statSbtjKyzlEcharts:1
    //};
    //var mockActions={};
    //var mockActionsArr=[
    //    'login',
    //    'logout',
    //    'sys/param',
    //    'sys/sysUser/upd'
    //];


    //mockActionsArr.each(function(act){
    //    var act2=window['dash2camel'](act.replace(/\//g,'-'));
    //    var url=basePath+ act.replace(/\//g,'-')+'.json';
    //    mockActions[act]=mockActions[act2]=url;
    //});
    //window.config.mock && (window.config.actions=mockActions);
    var mActs=window.config.mockActions;
    for(var n in  mActs){
        mActs[n]=basePath + (mActs[n]||n).replace(/\//g,'-') + '.json';
        //var n2=window['dash2camel'](mActs[n]);
        //mActs[n]=basePath+ window['camel2dash'](mActs[n]||n2) +'.json';
    }
})();

