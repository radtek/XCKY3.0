/**
 * Created by evan on 2017/1/3.
 */
function num2txt(txt1,txt2,txt3){
    var the=parseInt(this);
    if(the===1){
        return txt1;
    }else if(the===0){
        return txt2;
    }else{
        return typeof txt3!='undefined'? txt3:this.valueOf();
    }
}
window.$filter('sub16',function(){
    return this.trim().slice(0,16);
    //return (new Date(this)).format('YYYY-M-D hh:mm');
},String);

window.$filter('asDate16',function(){
    // return this.trim().slice(0,16);
    return this.valueOf()?(new Date(this)).format('YYYY-M-D hh:mm'):'';
});

window.$filter('asCnTime',function(){
    return this.valueOf()?(new Date(this)).format('YYYY年M月D日 hh:mm'):(window.config.emptyDate||'--');
});

window.$filter('asCnDate',function(){
    return (new Date(this)).format('YYYY年M月D日');
});
//<b>{dateTxt.asCnDate}</b>

window.$filter('asRead',function(){
    return num2txt.apply(this,['已读','未读']);
});
//<b>{num.asRead}</b>

window.$filter('asEnable', function () {
    return num2txt.apply(this,['启用','禁用','禁用']);
});

window.$filter('asSolved',function(){
    return num2txt.apply(this,['已解决','未解决']);
});
//<b>{num.asSolved}</b>


window.$filter('asActive',function(){
    return num2txt.apply(this,['active','no-active','']);
});
//<a class="btn-edit {num.asActive}"></a>
//<a class="nav-link-{num.asActive}"></a>

window.$filter('toInt', function(){
    return parseInt(this.valueOf());
});

window.$filter('asSex', function () {
    return this.toString().trim().replace('1', '男').replace('2', '女').replace('0', '未知');
});

window.$filter('exNum',function () {
    return parseInt(this)===1?0:1;
});
window.$filter('asYes',function () {
    return parseInt(this)===1?'是':'否';
});
window.$filter('asUndefined',function () {
    return this.toString() == 'undefined' ? undefined : this;
});