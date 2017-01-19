importing('daterangepicker', 'dict', function () {
    var usualSearchArr = [];
    var kyryArr = [];
    var queryCache; //查询的上一次缓存
    //判断是否存在案件和警情编号
    $filter('querySceneIfExist', function(){
        var value = this.valueOf();
        if(value){
            return $compile('#q-r-no-detail',{value: this.valueOf()});
        }else{
            return '--';
        }
    });
    //注册事件
    function regEvent() {
        //筛选框的隐藏显示
        $('.body-agent').on('click', '.more-condition', function() {
            //点击展开更多条件栏
            $('.query-condition-hide').slideToggle();
            $(this).find('i').toggleClass('icon-angle-down');
            if ($(this).find('i').is('.icon-angle-down')) {
                $(this).attr('title', '展开查询条件栏');
            } else {
                $(this).attr('title', '隐藏查询条件栏');
            }
        });
        //查询点击
        $('.query-block').on('click', '#scene-query-btn', function (e, query) {
            query = query || getScreenQuery();
            queryCache = query;
            var act = makeAct('sceneQuery/sceneSimpleQuery/query');
            var columns = [
                {title:'序号',map:'rowNum',cls:'mem6'},
                {title:'勘验号',map:'investigationNo',cls:'mem12'},
                {title:'案件关联',map:'caseNo.querySceneIfExist',cls:'mem6 pr over-v'},
                {title:'警情关联',map:'alarmNo.querySceneIfExist',cls:'mem6 pr over-v'},
                {title:'案件类别',map:'caseTypeCn',cls:'mem6'},
                {title:'勘验时间', map:'investigationDateFrom',cls:'mem6'},
                {title:'勘验地点', map:'investigationPlace',cls:'mem6'},
                {title:'勘验人', map:'investigatorName',cls:'mem6'},
                {title:'发案区划', map:'caseRegionalismCn',cls:'mem14'},
                {title:'现场图',map:'scenePhotoAmount',cls:'mem6'},
                {title:'现场照片',map:'scenePictureAmount',cls:'mem6'},
                {title:'痕迹物证', map:'evidenceAmount',cls:'mem6'},
                {title:'视频', map:'videoEvidenceAmount',cls:'mem6'},
                {title:'提取物品', map:'collectedGoodsAmount',cls:'mem6'},

                {title:'案件性质',map:'caseNatureCn',cls:'mem6',customInit:false},
                {title:'勘验单位',map:'organName',cls:'mem6',customInit:false},
                {title:'勘验指挥人',map:'commandName',cls:'mem6',customInit:false},
                {title:'发案地点',map:'caseLocation',cls:'mem6',customInit:false},
                {title:'发案时间',map:'crimeTimeBegin',cls:'mem6',customInit:false},
                {title:'见证人',map:'witnessName',cls:'mem6',customInit:false},
                {title:'保护人',map:'protector',cls:'mem6',customInit:false},
                {title:'现场保护时间',map:'protectionDate',cls:'mem6',customInit:false},
                {title:'保护措施',map:'protectionMeasureCn',cls:'mem6',customInit:false},
                {title:'损失物品总价值',map:'lostTotalValue',cls:'mem6',customInit:false},
                {title:'受伤人数',map:'woundedAmount',cls:'mem6',customInit:false},
                {title:'死亡人数',map:'deadAmount',cls:'mem6',customInit:false},
                {title:'选择对象',map:'chooseObject',cls:'mem6',customInit:false},
                {title:'选择处所',map:'choosePlace',cls:'mem6',customInit:false},
                {title:'作案进出口',map:'crimeInOut',cls:'mem6',customInit:false},
                {title:'作案时机',map:'crimeTime',cls:'mem6',customInit:false},
                {title:'作案手段',map:'crimeType',cls:'mem6',customInit:false},
                {title:'侵入方式',map:'invasionType',cls:'mem6',customInit:false},
                {title:'作案过程',map:'commissionDesc',cls:'mem6',customInit:false},
                {title:'作案人特点',map:'criminalPoints',cls:'mem6',customInit:false},
                {title:'作案工具',map:'crimeTools',cls:'mem6',customInit:false},
                {title:'提交时间',map:'lastSubmitDatetime',cls:'mem6',customInit:false}
            ];
            $('.query-result').pagingList({
                action:act,
                // currentPage:$qr.children('.paging').data('currentPage'),
               // pageOnce:10,
                jsonObj: query,
                callback: function(data){
                    $('#default-table').table({
                        data:data,
                        cols:columns,
                        fixCols:{left:2},
                        helper:function(item){
                            // item._trChecked = !!top.registry.xcgl.checkScene[item.rowNum]
                        },
                        allowHTML:true,
                        check:'id',
                        //cls:'tleft'
                    })//.data('current-data', data);
                }
            });
        });
        //重置点击
        $('.query-block').on('click', '#scene-reset-btn', function () {

        });
        //保存为常用查询点击
        $('.query-block').on('click', '#scene-save-btn', function () {
            $open('#save-usual-search', {title: '保存为常用项', width: 350, height: 220});
        });
        //保存为常用查询-保存
        $('#save-usual-search').on('click', '.save', function () {
            // var queryContent = getScreenQuery();
            var act = makeAct('sceneCollecting/queryHistory/add');
            var queryContent = obj2str(getScreenQuery())
            var query = {
                "queryType": "2",
                "queryContent": queryContent,
                "queryName": $('#save-usual-search').find('input[name="queryName"]').val(),
                "remark": $('#save-usual-search').find('textarea[name="remark"]').val()
            };
            $post(act, query, function (res) {
                toast('保存成功');
                query.id=res.data.id;
                var li = $compile('#usual-search-li', query);
                usualSearchArr.unshift(query);
                // $li.data('query', queryContent);
                $('#usual-search').prepend(li);
            });
        });
        //保存为常用查询-取消
        $('#save-usual-search').on('click', '.cancel', function () {
            $('#save-usual-search').$close();
        });
        //常用查询的点击
        $('#usual-search').on('click', 'li span', function () {
            var $this = $(this);
            var id = $this.closest('li').attr('data-id');
            var query = str2obj(usualSearchArr.where('o=>o.id=="{0}"'.format(id))[0].queryContent);
            $('##scene-query-btn').trigger('click', query);
        });
        //常用查询的删除
        $('#usual-search').on('click', '.icon-remove', function () {
            var $this = $(this);
            var $li = $this.closest('li');
            var id = $li.attr('data-id');
            $confirm('是否删除'+$li.find('span').text(), function (isyes) {
                if(isyes) {
                    var act = makeAct('sceneCollecting/queryHistory/del');
                    $post(act, id, function () {
                        toast('删除成功');
                        usualSearchArr = usualSearchArr.where('o=>o.id!="{0}"'.format(id));
                        $li.remove();
                    });
                }
            });
        });
        //勘验人员输入筛选人
        $('#investigator').on('keyup', function () {
            var val = $(this).val();
            var data = kyryArr.where('o=>o.value.match(/.*?{0}.*?/g)'.format(val));
            if(data.length > 0) {
                $('#kyry').show();
            }
            var liarr = $compile('#util-li', data);
            $('#kyry').html(liarr);
        }).on('blur', function () {
            $('#kyry').hide();
        });
        //勘验人员显示列表的点击
        $('#kyry').on('click', 'li', function () {
            $('#investigator').val($(this).text());
            $('#kyry').hide();
        });
        //结果展现方式的change
        $('#show-way').on('change', function () {
            var query = queryCache;
            var val = $(this).val();
            query.catagory = val;
            $('#scene-query-btn').trigger('click', query);
        });
    }
    //获取筛选条件的query
    function getScreenQuery() {
        var query = {};
        $('.query-condition-hide').find('input:text, .dict').each(function () {
            var tagName = this.tagName;
            var $this = $(this);
            var name;
            var val;
            if(tagName == 'INPUT') {
                name = $this.prop('name');
                val = $this.val();
                if(name == 'createTime' || name == 'investigationDate' || name == 'lastSubmitDatetime') {
                    var valArr = val.split(',');
                    query[name+'Begin'] = valArr[0];
                    query[name+'End'] = valArr[1] || '';
                    return true;
                } else if(name == 'crimeTime' ) {
                    var valArr = val.split(',');
                    query[name+'BeginStr'] = valArr[0];
                    query[name+'EndStr'] = valArr[1] || '';
                    return true;
                }
            } else if(tagName == 'DICT') {
                name = $this.attr('dict-name');
                val = $this.find('input[type="hidden"]').val() || '';
            }
            query[name] = val;
        });
        query.duty = $('#duty').val() || '';    //职责
        query.catagory = $('#show-way').val() || '';    //结果展现方式
        return query;
    }
    function init() {
        regEvent(); //事件注册方法
        $('.date-range-picker').daterangepicker({
            timePicker: true
        });
        $('.dict').dict();
        //常用查询的li列表
        var act = makeAct('sceneCollecting/queryHistory/query');
        $post(act, {"queryType": "2"}, function (res) {
            res.data && (usualSearchArr = res.data);
            var arrLi = $compile('#usual-search-li', res.data);
            $('#usual-search').html(arrLi);
        },false);
        //勘验人员
        act = makeAct('sys/sysUser/queryTreeUser');
        $post(act, {}, function (res) {
            kyryArr = res.data.where('o=>o.personFlag=="1"');
        }, false);
        //案情信息 发案区划
        var unitAct = makeAct('sys/sysOrganization/dict_unit');
        $get(unitAct,{},function (res) {
            $('#faqh').dict(res.data);
        },false);
        //查询结果展现方式
        act = makeAct('/sys/sysDict/single/XCHJWZLBDM');
        $get(act, {}, function (res) {
            console.log(res);
            var data = res.data.slice(0,11);
            var optionArr = $compile('#util-option', data);
            $('#show-way').append(optionArr);
        },false);
    }

    init();
    var setTime = 200;
    setTimeout(function () {
        console.log($('.unready').length);
        if($('.unready').length == 0) {
            $('#scene-query-btn').trigger('click');
        } else {
            setTimeout(arguments.callee, setTime)
        }
    }, setTime);
});