/**
 * Created by EvanYao on 2016/9/21.
 */
//清除linkbutton点击后的虚线
window.$.noOutline=function(selector){
    $(selector||'a').on('focus',function(){this.blur();});
};

//jQuery from 序列化扩展 将jquery系列化后的值转为name:value的形式。
//$("#form2").serializeObject() => {id:"007",age:"24""}
window.$.fn.serializeObject=function(){
    var convertArray=function (arr) {
        var i=arr.length, obj = {};
        while (i--){
            if(typeof obj[arr[i].name]=='undefined')
                obj[arr[i].name] = arr[i].value;
            else
                obj[arr[i].name] += ','+arr[i].value;
        }
        return obj;
    };
    return function(){
        return convertArray(this.serializeArray());
    };
}();

window.$.fn.val2=function(){
    if(this.is(':text')|| this.is('textarea')){
        return this.val().trim();
    }else{
        return this.val();
    }
};

window.$.fn.checkRow=function (i,checked) {
    $(this).find('tbody:not("td>tbale>tbody")').children('tr:nth-child({0})'.format(i+1))[checked===false?'removeClass':'addClass']('checked');
}