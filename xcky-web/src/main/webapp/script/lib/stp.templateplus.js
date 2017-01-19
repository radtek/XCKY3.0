/**
 * Created by yao on 2016/11/15.
 */
// 这个方法和$compile一样暴露出来，供特殊情况时手动使用。
var $makeTemplate=function (tempstr,colsData,isHead){
    var wrapArr = isHead ? ['<thead>','','</thead>']:['<tr>','','</tr>'];
    tempstr = $compile(tempstr,colsData,function(item){
        for(var n in item){
            item[n]=item[n]||'null';
        }
    });
    isHead ||  (tempstr = tempstr.replace(/\[/g,'{').replace(/\]/g,'}'));
    wrapArr[1] =  tempstr ;
    return wrapArr.join('');
}

// 执行有权限列配置的template注入生成
var $templatePlus=(function($){
    var singleTable='<td class="{labelClass} {name}-lable">{label}</td><td class="{valClass} {name}-val">[{name}]</td>';
    var commonBody='<td class="{valClass} {name}-val">[{name}]</td>';
    var commonHead='<th class="{labelClass} {name}-lable">{label}</th>';
    var commonForm='<div class="stp-cell {name}-cell"><div class="stp-label {labelClass} {name}-lable">{label}</div><div class="stp-val {vallClass} {name}-val">[{name}]</div></div>';
    return function (container,config,data,allowHTML){
        var tempHead;
        var tempBody;
        var html = '';
        if(config.type=='map'){
            tempBody=$makeTemplate(commonForm,config.cols);
            html=$compile(tempBody,data);
        }else{
            tempHead=$makeTemplate(commonHead,config.cols,true);
            tempBody=$makeTemplate(commonBody,config.cols);
            html=tempHead + '<tbody>'+$compile(tempBody,data,allowHTML)+'</tbody>';
        }
        $(container).html(html);
    }
})(window.jQuery);

typeof module === "object" && typeof module.exports === "object"  && (module.exports={
    $makeTemplate:$makeTemplate,
    $templatePlus:$templatePlus
});