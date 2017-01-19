/**
 * Created by yao on 2016/11/21.
 */
//方法如下
var hideClass='custom-col-hide';
var arr=[];
//var reg=/\<\/?[^\<\>]+\>/g;
//window.extending({html2txt:function(html){return html.replace(reg,'').trim();}});
var isFix=function($ele){
    return $ele.hasClass('need-fix')|| $ele.hasClass('need-fix-end');

}
//列排序方法
var customSortFn=function(cells,isTh){
    //避免引发重绘
    window._cancelGlobalReFixTbTime=new Date().getTime();

    if(!cells.length){
        return false;
    }
    var parent=$(cells[0].parentNode);
    var cellsArr=arr.slice.call(cells).orderby('o => +o.getAttribute("sort-index")');

    //位置不变的不替换,性能会好点,但算法复杂,容易出bug,可靠性差
    //$cells.each(function(j,cell){
    //    var $cell=$(cell);
    //    if(j!=$cell.attr('sort-index')){
    //        $cell.replaceWith($cellsArr[j]);
    //    }
    //});
//if(isTh){
//    log(parent)
//    console.info(cellsArr)
//}
    //避免引发重绘
    window._cancelGlobalReFixTbTime=new Date().getTime();

    cells.remove();
    cellsArr.each(function(cell){
        parent.append(cell);
    });
};

//隐藏指定列的方法
var customFn=function(table,rs){
    //每次非初始化进入,比如先页面载入又保存按钮点过之后,原来的tds顺序已经无法确定,只能重走template来找回th和td的对应关系
    var theadRow=table.children('thead').children('tr');
    var ths=theadRow.children('th');
    var thsArr;
    var tds;

    //避免引发重绘
    window._cancelGlobalReFixTbTime=new Date().getTime();

    table.hide();

    //先保存原有的index
    table.find(' >thead>tr>th , >tbody>tr>td ').each(function(){
        this.hasAttribute('native-index') || this.setAttribute('native-index',$(this).index());
    })

    thsArr=ths.toArray().orderby('th => +th.getAttribute("native-index")');

    //先加隐藏类,打上排序标记
    thsArr.each(function(th,i){
        var $th=$(th)
        var text=$th.text();
        var colConfig=rs.where('o => o.cn=="{0}"'.format(text))[0];
        // rs.each(function(item){   if(!colConfig && item.cn==$th.text()) { colConfig=item; }    });
        var act=colConfig.custom==0 ?  'addClass':'removeClass';
        var sortIndex=colConfig.sortIndex;

        //原来的排序依赖于nth的对应,那么template的表格,每次都要初始化template来找回原来的顺序
        //tds=table.children('tbody').children('tr').children('td:nth-child({0})'.format(i+1));
        tds=table.find('>tbody>tr>td').filter('[native-index="{0}"]'.format(i));

        $th.add(tds)[act](hideClass).attr('sort-index',sortIndex);
    });

    //console.info(['sort-index处理后的ths',arr.slice.call(ths).select('td => td.outerHTML')]);
    //每行进行每个单元格位置的检测和替换
    customSortFn(ths,true);
    table.find('>tbody>tr').each(function(i,tr){
        var tds=$(tr).children('td');//.clone();
        customSortFn(tds);
    });

    table.show();

    var mode=table.attr('fixed-mode');
    mode && table.fixTable(mode);//重走fixTable (todo fixTable要做是否因溢出而需要fix的检测，与本方法无关)
};


//小控件模版
var btnHtml='<div class="custom-tool"><i class="fa icon-cogs" title="自定义列"></i></div>';
var winHtml='<div id="{0}" class="custom-setting-modal">'+
    '<ul class="custom-col-options">{1}</ul>'+
    '<div class="btn-bar"><b class="cm-save-btn"></b><b class="cm-cancel-btn"></b></div>'+
    '</div>';
var tp='<li class="{2}"><input type="checkbox" id="{1}"/><label for="{1}"></label><u>{0}</u><label for="{1}" class="custom-col-switch" data-on="显示" data-off="隐藏"></label></li>';//checked={1} readOnly={2}

$.fn.customCol=function(attr){
    //log('\ncustom col in'),log(this.html())
    //防止空table过来跑一遍customCol
    if(!this.children().length){
        return this;
    }
    if(this.hasClass('no-custom')){
        return this;
    }
    var table=this;
    var wrap=table.closest('.query-result');
    var attr=attr||'custom';//指令属性也可以自定义
    var key='cs-'+(window.iframe?window.iframe.getAttribute('page-no'):($('.spa-view')[0]||{}.id))+(table.prop('id')||'table');
    var thead=table.children('thead');
    var ths=thead.children('tr').children('th');
    var rs=localData.get(key);//rowsSetting
    //console.info(['取出的rs',rs])
    //检测基本条件
    if(!key || !table.is('table')){  //|| !ths.filter('[{0}]'.format(attr)).length){
        //console.warn([key,table]);
        return this;
    }

    //检测表头是否有更新
    if(rs){
        if(rs.length!=ths.length){
            rs=null;
        }else{
            rs=rs.orderby('r => r.cn');
            var thsArr=arr.slice.call(ths).orderby('th => $(th).text()');
            var msg='列名改变? {0},  自定义项改变?{1} , 自定义固定列改变?{2}';

            var needUp=rs.some(function(r,i){
                var b  =  r.cn!= $(thsArr[i]).text(); //info([r.cn,ths])
                var b2 = (r.custom==null && thsArr[i].hasAttribute(attr));
                var b3 = (r.custom!=null && !thsArr[i].hasAttribute(attr));
                var b4 = r.needFix!=(isFix($(thsArr[i]))?'fixed-item':'');//.className.match(/\s?need-fix|^need-fix/)

                //info([r.cn,r.needFix,isFix($(thsArr[i]))?'fixed-item':''])

                msg=msg.format(b,b2||b3,b4);
                return b || b2 || b3 ||b4;
            });

            needUp && console.info(['custom表格结构变化,更新custom设置...',msg,table.prop('id'),table]);
            needUp && (rs=null);
        }
    }
    //初始化
    if(!rs){
        rs=[];
        ths.each(function(i,th){
            var $th=$(th);
            //custom列默认显示，调成0为默认不显示
            rs[i]={
                cn:$th.text(),
                custom:this.hasAttribute(attr)?(this.getAttribute('cs-init')==='false'?0:1):null,
                nativeIndex:i,
                needFix:isFix($th)?'fixed-item':'',
                sortIndex:this.getAttribute('sort-index')||i //第0个是不变的,否则0||i会不对
            };

            //同时存到th上
            th.setAttribute('sort-index',rs[i].sortIndex);
            //th.setAttribute('native-index',rs[i].nativeIndex);
        });
        localData.set(key,rs);
    }
    //都更新下
    //localData.set(key,rs);

    //console.log('$.fn.customCol触发custom重绘!');
    customFn(table,rs);

    //table.on('customHide',function(){
    //    customHide(rs,table);
    //})

    //生成小控件
    if(!wrap.hasClass('has-custom-btn')){
        var btn=$(btnHtml);
        btn.appendTo(wrap.addClass('has-custom-btn'));//.attr('custom-btn-appended',true));//设定为table必须有.query-result包裹，因为小控件不生成于table中
        //btn.appendTo(wrap.length?wrap:table.closest(':not(".native-fix-wrap,.all-fix-wrap")'));

        //设置弹窗
        btn.on('click',function(){
            var ops='';
            var rs=localData.get(key);//防止闭包保存，从本地存储实时获取
            rs=rs.orderby('r => +r.sortIndex');
            rs.each(function(r,i){
                ops+=tp.format(r.cn, key+'-'+i, r.needFix);//,r.custom!=0,r.custom==null);
            });

            //todo 这个弹窗可以只生成一次，做好对映标识别，以后每次只更新check值就可以了
            var tempID='temp-'+new Date().getTime();
            var win=$(winHtml.format(tempID,ops));
            win.hide().appendTo(wrap);
            window.$open('#'+tempID,{width:350,title:'自定义列'}).focus();//$open接受元素传参


            win.find(':checkbox').each(function(i){
                this.checked=rs[i].custom!=0;
                this.disabled=rs[i].custom==null;
            });

            //保存按钮
            win.on('click','.cm-save-btn',function(){
                //更新rowsetting
                //var rs=localData.get(key);//防止闭包保存，从本地存储实时获取
                //var rs=[]
                win.find('li').each(function(i){
                    ////console.log([i,this.disabled,this.checked]);
                    var $this=$(this);
                    var checkBox=$this.find(':checkbox')[0];
                    var custom;
                    if(!checkBox.disabled){
                        custom=checkBox.checked?1:0;
                    }
                    //rs[i].sortIndex=i;
                    rs[i]={
                        cn:$this.children('u').text(),
                        custom:custom,
                        //nativeIndex:$this.attr('native-index'),
                        needFix:$this.hasClass('fixed-item')?'fixed-item':'',
                        sortIndex:i //第0个是不变的,否则0||i会不对
                    };
                    //console.info(obj2str(rs[i]))
                });
                //console.info(['更改后的rs',rs])
                //更新本地存储和视图显示
                //rs=rs.orderby('o => o.nativeIndex')
                localData.set(key,rs);
                //console.log('保存触发custom重绘!');
                customFn(table,rs);

                //var thead=table.children('thead');
                //var theadData=thead.data('current-data');
                //theadData && thead.template(theadData);
                //
                //var tbody=table.children('tbody');
                //var tbodyData=tbody.data('current-data');
                //tbodyData && tbody.template(tbodyData);
                //
                //var tableData=table.data('current-data');
                //tableData && table.template(tableData);

                //table.on('customHide',function(){
                //    customHide(rs,table);
                //})
                win.$close().remove();

            })
                .on('click','.cm-cancel-btn',function(){
                    //避免引发重绘
                    window._cancelGlobalReFixTbTime=new Date().getTime();
                    //因为没有走单例，因此每次动态生成，使用完后都清除
                    win.$close().remove();
                }).on('click','li',function (e) {
                    $(e.target).is('input,label') || $(this).find('input')[0].click();
                });
            importing('jui',function(){
                win.children('.custom-col-options').sortable({
                    //items: "li:not(:)"
                    cancel: 'li:first-child,li:last-child,.fixed-item',
                    cursor: 'move',
                    items: 'li:not(:first-child,:last-child,.fixed-item)',
                    axis: 'y'
                }).on('sortstart', function(e, ui){
                    //$(this).children().css({cursor:'move'});
                }).disableSelection();
            });
        });
    }

    return this;
};

//先在要走custom的th上加上custom属性, 如：<th custom>案件详情</th>

//然后自启动
$(function(){
    if(config.autoCustomCol){
        //console.log('domreay $.fn.customCol, 主要是为了处理静态写在页面上的表头');
        $('.query-result table:has("tbody"):not(".stp-table")').eq(0).customCol('cs');
    }
    //config.autoCustomCol && alert(config.autoCustomCol==true) && window!=top && $('.query-result table').eq(0).customCol('cs');//:has("th[custom]:first")
});