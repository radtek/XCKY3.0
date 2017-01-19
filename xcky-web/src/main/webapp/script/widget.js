/**
 * Created by evan on 2017/1/3.
 */
var dateSelects={
    'empty':'不限',
    'today':'当天',
    '3days':'近三天',
    'week':'本周',
    'month':'本月',
    'season':'本季度',
    'year':'本年'
};
var dateOptionsInit = function(data){
    var $this=$(this);
    //var selected=defaults.indexOf(data.default);
    var selected = dateSelects[data.default];

    $this.find('.date-range-picker').daterangepicker();

    $this.find('.date-select').children().click(function(){
        var $the=$(this);

        $the.addClass('query-block-active').siblings('u').removeClass('query-block-active');

        var value = $the.text();
        var $input = $the.parent().siblings('.text-time').children('input');

        if(value == '不限'){
            $input.val('');
        }else if(value == '当天'){
            $input.val(DTU.today+','+DTU.today);
        }else if(value == '近三天'){
            $input.val(DTU.threeDaysBefore+','+DTU.today);
        }else if(value == '本周'){
            $input.val(DTU.weekBegin+','+DTU.weekEnd);
        }else if(value == '本月'){
            $input.val(DTU.monthBegin+','+DTU.monthEnd);
        }else if(value == '本季度'){
            $input.val(DTU.seasonBegin+','+DTU.seasonEnd);
        }else if(value == '本年'){
            $input.val(DTU.yearBegin+','+DTU.yearEnd);
        }
    });

    //if(selected==-1 && parseInt(data.default)){
    if(parseInt(data.default)){
        //selected=data.default; //TODO 应该用正则做字符串日期匹配验证
        //$this.find('input').val(selected);
        $this.find('input').val(data.default);
    }else{
        //$this.find('.date-select').children().eq(selected).click();
        $this.find('.date-select').children().each(function () {
            if($(this).text()==selected){
                $(this).click();
            }
        })
    }

};
//时间选择组件
window.$widget('date-options',function(){
    return {
        template:'_temp/date-options.htm',
        importing:['daterangepicker','currentDate'],
        init:dateOptionsInit
    };
});
//时间选择组件2
window.$widget('date-options2',function(){
    return {
        template:'_temp/date-options2.htm',
        importing:['daterangepicker','currentDate'],
        init:dateOptionsInit
    };
});

//查询区域组件
window.$widget('query-result',function(){
    return {
        template:'_temp/query-result.htm',
        importing:'panelCtrls',
        boot:function(html,data){
            var $this=$(this);

            var btnLimits={};
            var btns=($this.data('btns')||'').split(',');
            btns.each(function(btn){
                btnLimits[btn+'Limit']=true;
            });

            data.id=data.id||this.getAttribute('id');
            data.cls=data.cls||this.className;
            data.title=data.title||'查询结果';
            data=$.extend(data,btnLimits);

            return $( $compile(html,data) );
        },
        init:function(data){
            var $this=$(this);
            $.colorBox(data.share?null:this);
            $this.fullPanel();
            $this.on('up-count',function(e,count){
                $this.children('div').find('.total-count').html(count);
            });
            if(data.tablehtml){
                $this.find('.qr-tb').html( data.tablehtml.slice(0,1)=='#' ? $(data.tablehtml).html() : window.loadHTMLCache[data.tablehtml] );
            }
            $this.on('ex-check',function (e,i,checked) {
                var arr=[].concat(i);
                arr.each(function (k) {
                    $this.checkRow(k,checked);
                });
            });
        }
    };
});


//查询重置按钮
window.$widget('query-btns',function(){
    return {
        template:'_temp/query-btns.htm',
        init:function(data){
            var $this=$(this);
            $this.find('.cm-query-btn').click(function () {
                $this.closest('.query-block').trigger('ex-query');
            });
            $this.find('.cm-reset-btn').click(function () {
                $this.closest('.query-block').trigger('ex-reset');
            });
        }
    };
});

//展开更多查询条件
window.$widget('more-condition',function(){
    return {
        template:'<div class="more-condition" title="展开查询条件栏"><span>展开查询条件</span><i class="icon-angle-up icon-angle-down"></i></div>',
        init:function(data){
            var $this=$(this);
            var queryConditionHide=$('.query-condition-hide');
            $this.on('click', function(){
                var $this=$(this);
                var icon=$this.find('i');
                queryConditionHide.slideToggle();
                icon.toggleClass('icon-angle-down');

                var tip=icon.is('.icon-angle-down')?'展开查询条件':'折叠查询条件';
                $this.attr('title',tip ).find('span').html(tip);
            });
        }
    };
});



// var ops={
//     id:'user-query-block',
//     cls:'unready',
//     queryRows:[
//         [
//             {label:'用户姓名', input:{id:'trueName',cls:'common-input',type:'text'},cls:'col-auto'},
//             {label:'用户账号', input:'<input id="userName" type="text" class="common-input" placeholder=""/>'},
//             {label:'角色',     input:'<dict id="dict-query-role" dict-id="query-role" dict-name="queryRole" dict-type="select" dict-root="custom" return-value="true"></dict>'}
//         ],
//         [{widget:'date-options',inputer:'test-date'}]
//     ],
//     toggleRows:[],
//     toggle:false,
//     dash:true,
//     //btns:'query-btns'//['query','reset']
// };
//
// $scope.set('user-query-block-ops',ops);
//
// $('#user-query-block').widget('query-block',ops);

