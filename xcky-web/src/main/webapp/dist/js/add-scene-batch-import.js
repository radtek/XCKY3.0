/**
 * Created by Administrator on 2016/12/29.
 */
importing('slick',function(){

    //存放轮播图片数组
    var nodes = {
        'fwt': [],
        'pmt': [],
        'gmfwzp': [],
        'zdbwzp': [],
        'xmzp': [],
        'print': [],
        'foot':[],
        'bio':[],
        'tool':[],
        'video':[],
        'gun':[],
        'drug':[],
        'physic':[],
        'doc':[],
        'elec':[],
        'qtxct': []
    };
    //现场痕迹物证类别代码
    var xchjwzlbDM = [
        {'key':'print', 'value':'1'},
        {'key':'foot', 'value':'2'},
        {'key':'tool', 'value':'3'},
        {'key':'gun', 'value':'4'},
        {'key':'bio', 'value':'6'},
        {'key':'drug', 'value':'7'},
        {'key':'physic', 'value':'8'},
        {'key':'doc', 'value':'9'},
        {'key':'elec', 'value':'10'},
        {'key':'video', 'value':'11'}
    ];
    //进入批量修改的类型
    var batchEditType = '';

    //生成32位的id
    var getGuid = function(){
        function S4() {
            return (((1+Math.random())*0x10000)|0).toString(16).substring(1);
        }
        return (S4()+S4()+S4()+S4()+S4()+S4()+S4()+S4());
    };
    /**
     *
     * @param fileList
     * @param type
     * @param cb
     * @returns {boolean}
     */
    var doDropUp = function(fileList,type){
        var $this = $(this);
        // var formdata = new FormData();
        //检测是否是拖拽文件到页面的操作
        if(fileList.length == 0) {
            return false;
        }
        //图片在浏览器上显示 并添加到上传数据对象
        for (var i = 0; i < fileList.length; i++) {
            var file = fileList[i];
            //类型检测
            if(file.type.indexOf('image') === -1){
                alert("您拖的文件存在除图片以外的文件！");
                return false;
            }
            //大小限制
            if (file.size > 5*1024*1024) {
                $alert('单张图片大小超过5M， 上传速度将过慢，请压缩后重新上传');
                break;
            }
            window.uploadFile(file, function(res){
                // var t_src = top.sysParams.fileServerPath+'/'+res.data.fileNameRemote;
                var obj = {
                    'batchImportId':getGuid(),
                    'type':type,
                    'attachmentId':res.data.fileNameRemote,
                    'src':top.sysParams.fileServerPath+'/'+res.data.fileNameRemote
                };
                if(type=='fwt') {
                    obj.category = '1';
                    obj.pictureType = '1082';   //地图方位示意图的代码
                    obj.pictureTypeDict = 'XCTZLDM';    //为现场图的字典
                    obj.description = '';
                } else if(type == 'pmt') {
                    obj.category = '1';
                    obj.pictureType = '2010';   //平面比例图的代码
                    obj.pictureTypeDict = 'XCTZLDM';    //为现场图的字典
                    obj.description = '';
                } else if(type=='gmfwzp') {
                    obj.category = '2';
                    obj.pictureType = '1';   //概貌&方位的代码
                    obj.pictureTypeDict = 'XCZPZLDM';    //为现场照片的字典
                    obj.description = '';
                } else if(type=='zdbwzp') {
                    obj.category = '2';
                    obj.pictureType = '3';   //重点部位的代码
                    obj.pictureTypeDict = 'XCZPZLDM';    //为现场照片的字典
                    obj.description = '';
                } else if(type=='xmzp') {
                    obj.category = '2';
                    obj.pictureType = '4';   //细目的代码
                    obj.pictureTypeDict = 'XCZPZLDM';    //为现场照片的字典
                    obj.description = '';
                } else if(type=='qtxct') {
                    obj.category = '1';
                    obj.pictureType = '';   //代码
                    obj.pictureTypeDict = 'XCTZLDM';    //为现场图的字典
                    obj.description = '';
                }
                nodes[type].push(obj);
                if(type == 'gun' || type == 'drug' || type == 'physic' || type =='doc' || type == 'elec' || type=='qtxct'){
                    //显示在其他区域
                    var tnodes = [];
                    tnodes = tnodes.concat(nodes['gun'],nodes['drug'],nodes['physic'],nodes['doc'],nodes['elec'],nodes['qtxct']);
                    slick($this, tnodes, 4);
                }else {
                    slick($this, nodes[type]);
                }
            });
            /*formdata.append('myfile', file);
            $.ajax({
                url: "http://192.168.1.211:53000/api/file/upload",
                type: "POST",
                data: formdata,
                contentType: false,
                processData: false,
                success: function (data) {
                    console.log(data);
                    var t_src = 'http://192.168.1.211:53000/api/file/download/'+data.fileId+'?preview=true';
                    nodes[type].push({
                        'batchImportId':getGuid(),
                        'type':type,
                        'attachmentId':t_src
                    });
                    if(type == 'gun' || type == 'drug' || type == 'physic' || type =='doc' || type == 'elec'){
                        //显示在其他区域
                        var tnodes = [];
                        tnodes = tnodes.concat(nodes['gun'],nodes['drug'],nodes['physic'],nodes['doc'],nodes['elec']);
                        slick($this, tnodes, 4);
                    }else {
                        slick($this, nodes[type]);
                    }
                },
                error: function () {
                    alert("上传失败！");
                }
            });*/
        }
    };
    /**
     *
     * @param $box 存放轮播图片的box
     * @param arr 轮播图片的arr
     * @param number 每次轮播的图片数量
     */
    function slick($box, arr, number){
        $box.unslick();
        $box.template(arr).slick({
            dots: true,
            dotsClass: 'slick-pagination',
            arrows: true,
            slidesToShow: number || 2,
            slidesToScroll: number || 2,
            prevArrow: '<span class="ss-prev .fa icon-chevron-left fs24"></span>',
            nextArrow: '<span class="ss-next .fa icon-chevron-right fs24"></span>'
        });
        //对应区域数量修改
        $box.closest('.drag-box').children('h5').find('em').text(arr.length);
    }
    //进入批量导入页面
    function intoBatchImport(){
        //需要先清空
        nodes = {
            'fwt': [],
            'pmt': [],
            'gmfwzp': [],
            'zdbwzp': [],
            'xmzp': [],
            'print': [],
            'foot':[],
            'bio':[],
            'tool':[],
            'video':[],
            'gun':[],
            'drug':[],
            'physic':[],
            'doc':[],
            'elec':[],
            'qtxct':[]
        };
        //删除所有active class
        $('#batch-import-block>div>.drag-box').removeClass('active');
        $('#batch-import-block>div>.drag-other-area>.other').hide();
        //遍历新增现场页面中已有的图片 显示在批量导入页面 存放在nodes数组中

        $('#add-scene-xct-ul').find('li:nth-child(n+2)').each(function(i, item){
            var t_data = $(item).data('picInfo');
            t_data.src = top.sysParams.fileServerPath + t_data.attachmentId;
            if(t_data.pictureType == '1082') {    //地图方位示意图
                nodes['fwt'].push(t_data);
            } else if(t_data.pictureType == '2010') { //平面图
                nodes['pmt'].push(t_data);
            } else {
                nodes['qtxct'].push(t_data);
            }
        });
        $('.form-field[data-pictype="1"] .ul-img .slick-slide').each(function () {  //概貌&方位渲染
            var t_data = $(this).data('picInfo');
            t_data.src = top.sysParams.fileServerPath + t_data.attachmentId;
            nodes['gmfwzp'].push(t_data);
        });
        $('.form-field[data-pictype="3"] .ul-img .slick-slide').each(function () {  //重点部位渲染
            var t_data = $(this).data('picInfo');
            t_data.src = top.sysParams.fileServerPath + t_data.attachmentId;
            nodes['zdbwzp'].push(t_data);
        });
        $('.form-field[data-pictype="4"] .ul-img .slick-slide').each(function () {  //细目渲染
            var t_data = $(this).data('picInfo');
            t_data.src = top.sysParams.fileServerPath + t_data.attachmentId;
            nodes['xmzp'].push(t_data);
        });
        slick($('#fwt-import-box'), nodes['fwt']);
        slick($('#pmt-import-box'), nodes['pmt']);
        slick($('#gmfwzp-import-box'), nodes['gmfwzp']);
        slick($('#zdbwzp-import-box'), nodes['zdbwzp']);
        slick($('#xmzp-import-box'), nodes['xmzp']);

        throughPic('#hjwz-print', 'print');
        throughPic('#hjwz-foot', 'foot');
        throughPic('#hjwz-bio', 'bio');
        throughPic('#hjwz-tool', 'tool');
        throughPic('#hjwz-video', 'video');
        throughPic('#hjwz-gun', 'gun');
        throughPic('#hjwz-drug', 'drug');
        throughPic('#hjwz-physic', 'physic');
        throughPic('#hjwz-doc', 'doc');
        throughPic('#hjwz-elec', 'elec');
        //打开批量导入页面
        $open('#batch-import-block', {width:'1030px', title:'批量添加'});
    }
    //进入批量导入页面后，遍历新增页面上各模块已经新增的图片
    function throughPic(selector, type){
        var $printBox = $('#print-import-box'),
            $footBox = $('#foot-import-box'),
            $bioBox = $('#bio-import-box'),
            $toolBox = $('#tool-import-box'),
            $videoBox = $('#video-import-box'),
            $otherBox = $('#other-import-box');
        $(selector).find('li:not(.add)').each(function(i, item){
            var t_data = $(item).data('picInfo');
            t_data.src = top.sysParams.fileServerPath + t_data.attachmentId;
            nodes[type].push(t_data);
        });
        type == 'print' && slick($printBox, nodes[type]);
        type == 'foot' && slick($footBox, nodes[type]);
        type == 'bio' && slick($bioBox, nodes[type]);
        type == 'tool' && slick($toolBox, nodes[type]);
        type == 'video' && slick($videoBox, nodes[type]);
        if(type == 'gun' || type == 'drug' || type == 'physic' || type =='doc' || type == 'elec' || type == 'qtxct'){
            var tnodes = [];
            tnodes = tnodes.concat(nodes['gun'],nodes['drug'],nodes['physic'],nodes['doc'],nodes['elec'], nodes['qtxct']);
            slick($otherBox,tnodes, 4);
        }
    }
    //批量导入确定 痕迹物证保存
    function hjwzSaveOpt(){
        var $titleUl = $('.hjwz-tabs[param="hjwz"]'),
            $allUl = $('#hjwz-all'),
            liHtml = $('#hjwz-li-tp').html();

        for(var key in nodes){
            if(key=='fwt'||key=='gmfwzp'||key=='zdbwzp'||key=='pmt'||key=='xmzp'||key=='qtxct') {
                continue;
            }
            var $ul = $('#hjwz-'+key);
            nodes[key].each(function(item, i){
                //存在batchImportId 表示是此次批量导入的照片
                if(item.batchImportId) {
                    item.uuid = item.batchImportId;
                    item.module = item.type == 'print' ? '1' : '';

                    //图片存放的data需要这么多的属性
                    var hjwzSaveObj = {
                        category:'',
                        attachmentId:'',
                        materialEvidenceName:'',
                        materialEvidenceTypeDict:'',
                        materialEvidenceType:'',
                        materialEvidenceCode:'',
                        materialEvidenceJudgement:'',
                        leftPosition:'',
                        collectionModeDict:'',
                        collectionMode:'',
                        collectedTime:'',
                        feature:'',
                        bulletModel:'',
                        bulletType:'',
                        storageFlag:'',
                        storageStatus:'',
                        collectedFlag:'',
                        sceneCollectedPerson:[]
                    };
                    var tobj = str2obj(obj2str(nodes[key][i]));
                    delete tobj['uuid'];
                    delete tobj['batchImportId'];
                    delete tobj['module'];
                    delete tobj['type'];
                    delete tobj['src'];
                    $.extend(hjwzSaveObj, tobj);
                    hjwzSaveObj.category = xchjwzlbDM.where('o=>o.key=="{0}"'.format(key))[0].value;//痕迹物证图片类型
                    hjwzSaveObj.attachmentId = item.attachmentId;//图片上传服务器后的绝对路径，后台后来改成需要传attachmentId

                    //compile html
                    $ul.append($compile(liHtml, item));
                    $allUl.append($compile(liHtml, item));
                    $titleUl.find('li[param="{0}"]'.format(key)).find('em').text($ul.children('li').length - 1);

                    //data
                    $ul.find('img[paramId="{0}"]'.format(item.batchImportId)).closest('li').data('picInfo', hjwzSaveObj);
                    $allUl.find('img[paramId="{0}"]'.format(item.batchImportId)).closest('li').data('picInfo', hjwzSaveObj);
                }
            });
            $titleUl.children('li[param="all"]').find('em').text($allUl.children('li').length);
        }
    }
    //批量导入确定 现场图保存
    function xctSaveOpt() {
        var $xctUl = $('#add-scene-xct-ul');
        appendxtc($xctUl, nodes['fwt']);
        appendxtc($xctUl, nodes['pmt']);
        appendxtc($xctUl, nodes['qtxct']);
    }
    function appendxtc($ele, data) {
        data.each(function (item) {
            var $li = $($compile('#add-scene-xct-li', item));
            delete item.src;
            delete item.batchImportId;
            delete item.type;
            $li.data('picInfo', item);
            $ele.append($li);
        });
    }
    //批量导入确定 现场照片保存
    function xczpSaveOpt() {
        var $gmfwzpUlImg = $('.form-field[data-pictype="1"]').find('.ul-img').unslick();
        var $zdbwzpUlImg = $('.form-field[data-pictype="3"]').find('.ul-img').unslick();
        var $xmzpUlImg = $('.form-field[data-pictype="4"]').find('.ul-img').unslick();
        var $liDiv;
        nodes['gmfwzp'].each(function (item) {
            $liDiv = $($compile('#add-scene-xctp-div', item));
            delete item.src;
            delete item.batchImportId;
            delete item.type;
            $liDiv.data('picInfo', item);
            $gmfwzpUlImg.append($liDiv);
            var $span = $('.form-field[data-pictype="1"] .type-in-label-ms span');
            $span.text(parseInt($span.text()) + 1);
        });
        nodes['zdbwzp'].each(function (item) {
            $liDiv = $($compile('#add-scene-xctp-div', item));
            delete item.src;
            delete item.batchImportId;
            delete item.type;
            $liDiv.data('picInfo', item);
            $zdbwzpUlImg.append($liDiv);
            var $span = $('.form-field[data-pictype="3"] .type-in-label-ms span');
            $span.text(parseInt($span.text()) + 1);
        });
        nodes['xmzp'].each(function (item) {
            $liDiv = $($compile('#add-scene-xctp-div', item));
            delete item.src;
            delete item.batchImportId;
            delete item.type;
            $liDiv.data('picInfo', item);
            $xmzpUlImg.append($liDiv);
            var $span = $('.form-field[data-pictype="4"] .type-in-label-ms span');
            $span.text(parseInt($span.text()) + 1);
        });
        $gmfwzpUlImg.slick({
            dots: true,
            dotsClass: 'slick-pagination',
            infinite: false,
            arrows: true,
            slidesToShow: 4,
            slidesToScroll: 1,
            prevArrow: '<span class="pic-lr pic-l"><i class="icon-chevron-left"></i></span>',
            nextArrow: '<span class="pic-lr pic-r"><i class="icon-chevron-right"></i></span>'
        });
        $zdbwzpUlImg.slick({
            dots: true,
            dotsClass: 'slick-pagination',
            infinite: false,
            arrows: true,
            slidesToShow: 4,
            slidesToScroll: 1,
            prevArrow: '<span class="pic-lr pic-l"><i class="icon-chevron-left"></i></span>',
            nextArrow: '<span class="pic-lr pic-r"><i class="icon-chevron-right"></i></span>'
        });
        $xmzpUlImg.slick({
            dots: true,
            dotsClass: 'slick-pagination',
            infinite: false,
            arrows: true,
            slidesToShow: 4,
            slidesToScroll: 1,
            prevArrow: '<span class="pic-lr pic-l"><i class="icon-chevron-left"></i></span>',
            nextArrow: '<span class="pic-lr pic-r"><i class="icon-chevron-right"></i></span>'
        });
    }
    //痕迹物证修改初始化赋值
    function batchHjwzInitEditInput(type, $div, data){
        //移除必填项不合格验证
        $div.find('.validatebox-invalid').removeClass('validatebox-invalid');
        //输入框赋值
        $div.find('[name="materialEvidenceName"]').val(data.materialEvidenceName);//物证名称
        $div.find('[name="leftPosition"]').val(data.leftPosition);//遗留部位
        $div.find('[name="collectedTime"]').val(data.collectedTime);//提取时间
        $div.find('[name="feature"]').val(data.feature);//基本特征
        $div.find('[name="collectionModeDict"]').val(data.collectionModeDict);//提取方法输入框
        //字典radio选中判断
        $div.find('[dict-name="materialEvidenceType"]').children('input[value="{0}"]'.format(data.materialEvidenceType)).prop('checked', true);
        $div.find('[dict-name="collectionMode"]').children('input[value="{0}"]'.format(data.collectionMode)).prop('checked', true);
        $div.find('[dict-name="bulletModel"]').children('input[value="{0}"]'.format(data.bulletModel)).prop('checked', true);
        //checkbox选中判断
        if(data.storageFlag == '1'){$('input[name="storageFlag"]').prop('checked', true);}
        if(data.collectedFlag == '1'){$('input[name="collectedFlag"]').prop('checked', true);}
        //提取人选中判断
        data.sceneCollectedPerson && data.sceneCollectedPerson.each(function(item){
            $div.find('.tqr-info-fill li[data-key="{0}"]'.format(item.collectedPersonId)).addClass('active');
        });
    }
    //对批量修改 的文本内容进行html初始化
    function cloneContent(cloneSelector, batchId){
        var $picInfo = $('#batch-edit-block>.pic-info');

        var divContent = $(cloneSelector).clone();
        $(divContent).find(':text').val('');
        $(divContent).find(':checkbox').prop('checked', false);
        $(divContent).find('.tqr-info-fill li').removeClass('active');

        //文本内容赋值
        $picInfo.html(divContent);

        //对单选字典进行重新定义
        $picInfo.find('[dict-type]').dict(function(){
            //痕迹物证输入框初始化
            batchHjwzInitEditInput(batchEditType, $picInfo,nodes[batchEditType].where('o=>o.batchImportId=="{0}"'.format(batchId))[0]);
            //TODO 其他照片输入框初始化
            var data = nodes[batchEditType].where('o=>o.batchImportId=="{0}"'.format(batchId))[0];
            data.pictureType && $picInfo.find('dict').dictSelect(data.pictureType);
            $picInfo.find('input:text').val(data.description);
        });
    }

    //重新渲染方位图 平面图 概貌&方位 重点部位 细目 图
    function repeatRender() {
        if(batchEditType == 'fwt' || batchEditType == 'pmt') {  //方位图和平面图的重新渲染（主要用于修改类型的情况下）
            nodes['fwt'].each(function (item, i) {
                if(item.pictureType == "2010") {
                    nodes['pmt'].push(item);
                    nodes['fwt'].splice(i, 1);
                }
            });
            nodes['pmt'].each(function (item, i) {
                if(item.pictureType == "1082") {
                    nodes['fwt'].push(item);
                    nodes['pmt'].splice(i, 1);
                }
            });
            slick($('#fwt-import-box'), nodes['fwt']);
            slick($('#pmt-import-box'), nodes['pmt']);
        } else if(batchEditType == 'gmfwzp' || batchEditType == 'zdbwzp' || batchEditType == 'xmzp') {
            nodes['gmfwzp'].each(function (item, i) {
                if(item.pictureType == "3") {
                    nodes['zdbwzp'].push(item);
                    nodes['gmfwzp'].splice(i, 1);
                } else if(item.pictureType == "4") {
                    nodes['xmzp'].push(item);
                    nodes['gmfwzp'].splice(i, 1);
                }
            });
            nodes['zdbwzp'].each(function (item, i) {
                if(item.pictureType == "1" || item.pictureType == "2") {
                    nodes['gmfwzp'].push(item);
                    nodes['zdbwzp'].splice(i, 1);
                } else if(item.pictureType == "4") {
                    nodes['xmzp'].push(item);
                    nodes['zdbwzp'].splice(i, 1);
                }
            });
            nodes['xmzp'].each(function (item, i) {
                if(item.pictureType == "1" || item.pictureType == "2") {
                    nodes['gmfwzp'].push(item);
                    nodes['xmzp'].splice(i, 1);
                } else if(item.pictureType == "3") {
                    nodes['zdbwzp'].push(item);
                    nodes['xmzp'].splice(i, 1);
                }
            });
            slick($('#gmfwzp-import-box'), nodes['gmfwzp']);
            slick($('#zdbwzp-import-box'), nodes['zdbwzp']);
            slick($('#xmzp-import-box'), nodes['xmzp']);
        }
    }

    //事件注册
    $('.main-content').on('click', '.into-batch-import', function(){
        intoBatchImport();
    });

    //阻止浏览器默认行为
    $(document).on({
        dragleave:function(e){		//拖离
            e.preventDefault();
        },
        drop:function(e){			//拖后放
            e.preventDefault();
        },
        dragenter:function(e){		//拖进
            e.preventDefault();
        },
        dragover:function(e){		//拖来拖去
            e.preventDefault();
        }
    });

    $('#batch-import-block').on('dragenter', '.drag-area', function(e){
        e.preventDefault();
    }).on('drop', '.drag-area', function(e){
        e.preventDefault();

        var fileList = e.originalEvent.dataTransfer.files;
        var param;
        var $storage;
        if($(this).hasClass('drag-box')){
            $storage = $(this).children('.storage-area');
            param = $storage.attr('param');
        }else{
            //其他 区域内容图片的拖拽
            $storage = $(this).closest('.drag-box').children('.storage-area');
            param = $(this).attr('param');
            if(this.tagName == 'U'){
                $(this).removeClass('drag');
                $(this).closest('.other').hide();
            }
        }
        doDropUp.apply($storage, [fileList, param]);

    }).on('dragover', '.drag-area', function(e){
        e.preventDefault();

        var $dragBox = $(this).closest('.drag-box');
        $dragBox.addClass('active').siblings('.drag-box').removeClass('active');

        if(this.tagName == 'U'){
            $(this).addClass('drag').siblings('u').removeClass('drag');
        }
        if(!$dragBox.hasClass('drag-other-area')){
            $('.drag-other-area').children('.other').hide();
        }
    }).on('dragleave', '.drag-area', function(e){
        e.preventDefault();
    }).on('dragenter', '.drag-other-area', function(){
        $(this).children('.other').show();
    }).on('click', '.del-import-pic', function(){
        //只有新拖入的图片才可以删除
        var $box = $(this).closest('.storage-area');
        var batchImportId = $(this).attr('paramId'),
            type = $(this).attr('paramType');
        nodes[type].each(function(o, i){
            if(o.batchImportId == batchImportId){
                nodes[type].splice(i,1);
                return false;
            }
        });
        //删除一张图片之后，需要重新slick一下
        if(type == 'gun' || type == 'drug' || type == 'physic' || type =='doc' || type == 'elec' || type=='qtxct'){
            var tnodes = [];
            tnodes = tnodes.concat(nodes['gun'],nodes['drug'],nodes['physic'],nodes['doc'],nodes['elec'],nodes['qtxct']);
            slick($box, tnodes, 4);
        }else {
            slick($box, nodes[type]);
        }
    }).on('click', '#batch-import-ok', function(){
        //点击确定，将新拖入的图片保存到对应的区域
        hjwzSaveOpt();  //痕迹物证的相关保存
        xctSaveOpt();   //现场图保存
        xczpSaveOpt();   //现场照片保存
        $('#batch-import-block').$close();
    }).on('click', '#batch-import-close', function(){
        $('#batch-import-block').$close();
    }).on('click', '.into-batch-edit', function(){
        var param = $(this).attr('param'),
            $box = $('#batch-edit-block>.pic-box'),
            $info = $('#batch-edit-block>.pic-info');
        var batchArr = nodes[param].where('o=>o.batchImportId');

        batchEditType = param;//进入批量修改的照片类型
        if(batchArr.length == '0'){
            toast(' 本次没有上传该类型的照片，请先上传照片').width(340).warn();
        }else {
            //进入批量修改页面
            $open('#batch-edit-block', {width: 800, title: '批量修改', onClose: function () {
                repeatRender();
            }});

            //照片重新slick
            $box.unslick();
            slick($box, batchArr, 4);
            //文本内容清空
            $info.html('');
            //进入默认点击第一张图片
            $box.find('.slick-slide:not(.slick-cloned):first').click();
        }
    });
    
    $('#batch-edit-block').on('click', '.slick-slide', function(){
        //修改页面点击图片 填写文本信息
        //当前照片样式修改
        $(this).addClass('active').siblings('.slick-slide').removeClass('active');

        var batchId = $(this).attr('paramId'),//获取图片对应的id
            type = $(this).attr('paramType'),//获取图片对应的类型
            cloneSelector = ''; //需要clone的html选择器

        if(type == 'print'){
            cloneSelector = '#hjwz-print-block>.batch-clone';
        }else if(type == 'foot'){
            cloneSelector = '#hjwz-foot-block>.batch-clone';
        }else if(type == 'bio'){
            cloneSelector = '#hjwz-bio-block>.batch-clone';
        }else if(type == 'tool'){
            cloneSelector = '#hjwz-tool-block>.batch-clone';
        }else if(type == 'video'){
            cloneSelector = '#hjwz-video-block>.batch-clone';
        }else if(type == 'fwt' || type == 'pmt') {
            cloneSelector = '#xct-add .batch-clone';
        }else if(type == 'gmfwzp' || type == 'zdbwzp' || type == 'xmzp') {
            cloneSelector = '#xctp-add .batch-clone';
        }
        cloneContent(cloneSelector, batchId);
    }).on('click', '#save-batch-edit', function(){
        //必填项验证
        var $block = $('#batch-edit-block');
        $block.find('.validate').validatebox();
        if($block.find('.validatebox-invalid').length > 0){
            return false;
        }
        //修改页面 修改图片文本信息后保存
        var saveObj;
        if(batchEditType == 'fwt' || batchEditType == 'pmt') {
            saveObj = getxctinfo($('#batch-edit-block>.pic-info'));
        } else if(batchEditType == 'gmfwzp' || batchEditType == 'zdbwzp' || batchEditType == 'xmzp') {
            saveObj = getxczpinfo($('#batch-edit-block>.pic-info'));
        } else {
            saveObj = getHjwzBlockObject($('#batch-edit-block>.pic-info'));
        }
        var batchId = $('#batch-edit-block>.pic-box').find('.slick-slide.active').attr('paramId');
        nodes[batchEditType].each(function(o,i){
            if(o.batchImportId == batchId){
                $.extend(nodes[batchEditType][i], saveObj);
            }
        });
        toast('保存成功！').ok();
    }).on('click', '#close-batch-edit', function(){
        //修改页面关闭按钮
        repeatRender();
        $('#batch-edit-block').$close();
    }).on('click', '.tqr-info-fill>li', function(){
        //提取人的点击事件
        if($(this).hasClass('active')){
            $(this).removeClass('active');
        }else{
            $(this).addClass('active');
        }
    });
});