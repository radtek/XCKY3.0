/**
 * Created by evans on 16/12/9.
 */
//test02
var test02Str='test02Str: ';
var setting=[
    {
        key:'rowNum',
        display:true,
        width:'auto',
        fixed:false,
        editable:true
    },
    {
        key:'organName',
        display:true,
        width:'auto',
        fixed:false,
        editable:true
    },
    {
        key:'username',
        display:true,
        width:'auto',
        fixed:false,
        editable:true
    },
    {
        key:'trueName',
        display:true,
        width:'auto',
        fixed:false,
        editable:true
    },
    {
        key:'roleName',
        display:true,
        width:'auto',
        fixed:false,
        editable:true
    }
];
var test02InitFn=function(){
    importing('dataTable',function(){
        $.fn.initDataTable=function(options) {
            var params = $.extend({
                scrollX: true,
                //scrollCollapse: true,
                paging: false,
                info: false,
                searching: false,
                ordering: false,
                dom: '<<t><"datatable-bottom-bar"lp>>',
                bDestroy: true,
                language: {
                    sProcessing: "处理中...",
                    sLengthMenu: "显示 _MENU_ 项结果",
                    sZeroRecords: "",
                    sInfo: "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                    sInfoEmpty: "显示第 0 至 0 项结果，共 0 项",
                    sInfoFiltered: "(由 _MAX_ 项结果过滤)",
                    sInfoPostFix: "",
                    sSearch: "搜索:",
                    sUrl: "",
                    sEmptyTable: "",
                    sLoadingRecords: "载入中...",
                    sInfoThousands: ",",
                    oPaginate: {
                        "sFirst": "首页",
                        "sPrevious": "上页",
                        "sNext": "下页",
                        "sLast": "末页"
                    },
                    oAria: {
                        "sSortAscending": ": 以升序排列此列",
                        "sSortDescending": ": 以降序排列此列"
                    }
                }
            }, options);
            return this.DataTable(params);
        }

        var data=[
            [1,22,33,44,55],
            [2,22,33,44,55],
            [3,22,33,44,55],
            [4,22,33,44,55],
            [5,22,33,44,55]
        ];

        $post(makeAct('sys/sysUser/pagequery'),{roleName: '', note: '', begin: 1, end: 60},function ( res ){
            res.data=res.data.slice(0,20)
            res.data.each('o => o.roleName=o.roleName||"",o.rowNum=parseInt(o.rowNum)')
            $('#test-table').initDataTable({
                data: res.data,
                ordering:true,
                info:true,
                // scrollY: window.height-400,
                columns: [
                    { "data": "rowNum" ,title:'序号'},
                    { "data": "organName" ,title:'单位'},
                    { "data": "organName" ,title:'单位2'},
                    { "data": "organName" ,title:'单位3'},
                    { "data": "organName" ,title:'单位4'},
                    { "data": "username" ,title:'用户名'},
                    { "data": "trueName" ,title:'真实姓名'},
                    { "data": "roleName" ,title:'角色名', sortable: false}
                ],
                //order: [[ 1, "asc" ],[ 2, "desc" ]],
                //columns: ['序号','名称','名称2','名称3','操作'].select('o => {title:o}'),
                fixedColumns: {
                    leftColumns: 1+1,
                    rightColumns: 1+0
                },
                //createdRow: function(row, data, index){
//            var pageNum,pageSize;
//            var actionContent = getActionContentByPageId(this.pageId, index).join('');
//            var actionHtml =$compile(actionContent,data);
//            var orderNum = (pageNum-1)*pageSize+index+1;
//            var submId = allData[index].id;
//
//            $('td:last-child', row).attr('data-id', submId).append(actionHtml);
//            $('td:first-child', row).append(orderNum);

                //}
            });
        })

    });

    var ct=$('.dt-custom-setting');
    var sortableList = ct.find('li');

    ct.length && ct.sortable({
        connectWith: 'ul',
        axis: 'y',
        items: 'li:not(.unsortable)'
    })

        .on('sortstart', function(e, ui){
            window.prevIndex = sortableList.index($(ui.item));
        })

        .on('sortupdate', function(e, ui) {

            var target = $(e.target);
            window.activeIndex = sortableList.index($(ui.item));

            if(!ui.sender){
                var list = setting;
                var item = list[prevIndex];

                list.splice(prevIndex, 1);
                list.splice(activeIndex, 0, item);
            }else{
                var list = setting;
                var item = list[activeIndex];

                if(target.hasClass('fixed-left') || target.hasClass('fixed-right')) {
                    item.fixed = true;
                } else {
                    item.fixed = false;
                }
            }
        });

}