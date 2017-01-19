/**
 * Created by yao on 2016/11/15.
 */
$.fn.table=function(config){
    var the=this;
    if(typeOf(config)=='array'){
        var columns=arguments[0],data=arguments[1],helper=arguments[2],allowHTML=arguments[3];
    }else{
        var columns=config.cols,data=config.data,helper=config.helper,allowHTML=config.allowHTML!==false;
    }
    if(!the.length || !columns.length){
        return the;
    }
    if(!data||!data.length){
        return the.template(data);
    }
    var the=this;
    var len=columns.length;
    var thstr='<th class="stp-{0}-th-{1} {2} {3}" {4} {6} {8}>{7}{5}</th>';//'<th class="stp-{pid}-th-{key} {hide}" sort-name={sort}>{title}</th>'
    var tdstr='<td class="stp-{0}-td-{1} {2} {3} {6}" rowspan="{7}">{5}{{4}}</td>';//'<td class="stp-{pid}-td-{key} {hide}">{{value}}</td>'
    if(typeof columns[0]=='string'){
        columns=columns.select('r => {title:r,map:r}');
    }

    if( columns.any('o => o.rowspan') ){
        data.where('o => o.rowspan').each(function (item,i) {
            item.extending('$rowspanNum',i+1);
        })
    }

    //hide跟自定义列设置联动 另一方式实现 本方法废弃 new
    //var customSetting=the.data('customSetting')||new Array(columns.length);
    //if(customSetting.length!=len){
    //    throw new Error('customSetting.length!=columns.length');
    //}
    //columns.each(function(col,i){
    //    if(!col.hasOwnProperty('hide')){
    //        col.hide=customSetting[i] && customSetting[i].val==0;
    //    }
    //});

    //固定列
    if(config.fixCols){
        var leftCount=config.fixCols.left;
        var rightCount=config.fixCols.right;
        leftCount && columns.slice(0,leftCount).each('o => o.fix="left",o.custom=false');
        rightCount && columns.slice(len-rightCount).each('o => o.fix="right",o.custom=false');
    }

    //var keys=Object.keys(data[0]);
    var thtp='<tr>';
    var tdtp='<tr>';
    var str='',str2='';

    columns.each(function(col,i){
        //col.fix= col.fix ? (col.fix=='left'?'need-fix':'need-fix-end') : '';
        if(!col.hide){
            if(col.map.lower().replace('$','')=='rownum'){
                col.cls='tleft '+col.cls;
            }
            str=thstr.format(
                the[0].id||'',
                col.map.split('.')[0],
                col.fix ? (col.fix=='left'?'need-fix':'need-fix-end') : '',
                col.cls||'',
                col.sort ? 'sort-name="{0}"'.format(col.sort):'',
                col.title,
                col.custom!==false?(typeof col.custom=='string'?col.custom:'cs'):'',
                config.check && i==0 ?'<input type="checkbox" class="stp-check-tr-all"/>':'',
                col.customInit===false?'cs-init="false"':''
            );
            str2=tdstr.format(
                the[0].id||'',
                col.map.split('.')[0],
                col.fix ? (col.fix=='left'?'need-fix':'need-fix-end') : '',
                col.cls||'',
                (col.key||col.map)+(col.filter ? '.'+col.filter:''),
                config.check && i==0 ?'<input type="checkbox" class="stp-check-tr" tr-param="{{0}}" tr-index="{$index.toString}" tr-rownum="{{1}}" stp-checked="{_trChecked}"/>'.format(typeof config.check=='string'?config.check:'',col.map):'',
                col.rowspan?'hideplus{rowspan}':'',
                col.rowspan?'{rowspan}':''
            );
            thtp+=str;
            tdtp+=str2;
        }
    });

    thtp+='</tr>';
    tdtp+='</tr>';
    var table;
    var html='<thead class="{0}">{1}</thead><tbody>{2}</tbody>'.format(config.fixHead!==false?'need-fix':'',thtp,$compile(tdtp,data,helper,allowHTML));
    if(the.is('table')){
        table=the.addClass('typical-tb stp-table '+ (config.cls||'')).template(html,data);
    }else{
        table=the.html('<table class="typical-tb stp-table {1}">{0}</table>'.format(html,config.cls||'')).children();
    }
    if(table.hasClass('has-checkbox')){
        table.find('[stp-checked]').each(function () {
            this.checked=$(this).attr('stp-checked');
        });
    }
    var wrap=table.parent();
    wrap.on('click','.stp-check-tr-all',function(){
        var checked=this.checked;
        wrap.find('.stp-check-tr').prop('checked',checked?true:false);
        wrap.find('tbody:not("td>tbale>tbody")').children().each(function(){
            $(this)[checked===false?'removeClass':'addClass']('checked');
        });
    }).on('click','.stp-check-tr',function () {
        var i=$(this).closest('tr').index();
        wrap.checkRow(i,this.checked);
    });
    // table.find('>tbody>tr').each(function(i){
    //     $(this).data('current-data',data[i]);
    // });
    config.fixCols===false || table.fixTable('all');
    return config.custom===false?the:the.customCol('cs');

};

///* DEMO deleted
// var columnsSetting=[ '序号','姓名','性别','年龄'];
//
// var columnsData=[
//     {rownum:1, name:'ave',   sex:1, age:18},
//     {rownum:2, name:'alice', sex:0, age:24},
//     {rownum:2, name:'david', sex:1, age:24}
// ];
//
// $('body').table(columnsSetting,columnsData);
//
// */

/* DEMO2

 var columnsSetting=[
     {title:'序号', map:'rownum',hide:true,  fix:'left',  cls:'cell-xs'},
     {title:'姓名', map:'name',  hide:false, fix:false,   cls:'cell-m',  sort:'name'},
     {title:'性别', map:'sex',   hide:false, fix:false,   cls:'cell-m', sort:'sex', filter:'asCnSex'}, //分别是列中文名,排序字段名,取值键名
     {title:'年龄', map:'age',   hide:true,  fix:'right', cls:'cell-s',  key:'fakeAge' }
 ];


 var columnsData=[
     {rownum:1, name:'ave', sex:1, age:18},
     {rownum:2, name:'alice', sex:0, age:24},
     {rownum:2, name:'david', sex:1, age:24}
 ];


 $('body').attr('id','pid').table(columnsSetting,columnsData,function(item){
    item.fakeAge=item.age+100;
 });


 $filter('asCnSex',function(){
    return this==1?'男':'女';
 });

 var columns=[
 {title:'序号', map:'rownum',      hide:false,   cls:'cell-xs'},
 {title:'姓名', map:'name',        hide:false,  cls:'cell-m',   sort:'name' ,custom:true},
 {title:'性别', map:'sex.asCnSex', hide:false,  cls:'cell-m',   sort:'sex',custom:true},
 {title:'姓名2', map:'name',        hide:false,  cls:'cell-m',   sort:'name'},
 {title:'性别2', map:'sex.asCnSex', hide:true,  cls:'cell-m',   sort:'sex'},
 {title:'年龄', map:'fakeAge',     hide:false,   cls:'cell-s' }
 ];


 var data=[
    {rownum:1, name:'ave', sex:1, age:18},
    {rownum:2, name:'alice', sex:0, age:24},
    {rownum:3, name:'david', sex:1, age:24}
 ];

$('body').table({
    data:data,
    cols:columns,
    fixCols:{ left:1, right:1},
    helper:function(item){item.fakeAge=item.age+100;}
});


 columnsSetting.each('r => r.hide=0');

 var table=$('<table class="stp-table">').appendTo($('body').html(''));

 table.table({
    columns:columnsSetting,
    data:columnsData,
    helper:function(item){ item.fakeAge= '<b>'+(item.age+5)+'岁</b>'; }
 });

setTimeout(function(){
    table.closest('.all-fix-wrap').width(340);
},300)
 */

/*new demo

 $('body').empty();$('<div class="query-result"><div class="new-color-bar"></div><table id="mytable" class="typical-tb"></table></div>').appendTo('body');
 '1'.asCnSex || $filter('asCnSex',function(){return this==1?'男':'女';});

 var columns=[
 {title:'序号',  map:'rownum',        cls:'cell-xs'},
 {title:'姓名',  map:'name',          cls:'cell-m'},
 {title:'姓名2', map:'name.toUpper',  cls:'cell-m' ,hide:1},
 {title:'性别',  map:'sex.asCnSex',   cls:'cell-m'},
 {title:'年龄',  map:'age',       cls:'cell-s'}
 ];

 var columns=[
 {title:'序号', map:'rownum',      hide:false,   cls:'cell-xs'},
 {title:'姓名', map:'name',        hide:false,  cls:'cell-m',   sort:'name',custom:true},
 {title:'性别', map:'sex.asCnSex', hide:false,  cls:'cell-m',   sort:'sex',custom:true},
 {title:'姓名2', map:'name',        hide:false,  cls:'cell-m',   sort:'name',custom:true},
 {title:'性别2', map:'sex.asCnSex', hide:1,  cls:'cell-m',   sort:'sex'},
 {title:'姓名3', map:'name',        hide:false,  cls:'cell-l',   sort:'name'},
 {title:'性别3', map:'sex.asCnSex', hide:false,  cls:'cell-l',   sort:'sex'},
 {title:'姓名4', map:'name',        hide:false,  cls:'cell-l',   sort:'name'},
 {title:'性别4', map:'sex.asCnSex', hide:false,  cls:'cell-l',   sort:'sex'},
 {title:'年龄', map:'fakeAge',     hide:false,   cls:'cell-s' ,custom:true}
 ];


 var data=[
   {rownum:1, name:'ave', sex:1, age:18},
   {rownum:2, name:'alice', sex:0, age:24},
   {rownum:3, name:'david', sex:1, age:24}
 ];
 data=data.concat(data);data=data.concat(data);data=data.concat(data);

 $('#mytable').table({
   data:data,
   cols:columns,
   fixCols:{ left:1, right:1},
   helper:function(item){item.fakeAge=item.age+100;}
 });

*/