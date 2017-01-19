/*
/!**
 * Created by Administrator on 2016/12/12.
 *!/
importing('dict', 'hsmap', function(){

    var liHtml = $('#hjwz-li-tp').html(); //原图li模板
    var divHtml = $('#hjwz-div-tp').html(); //修改图div模板
    var sContentHtml = $('#hjwz-map-s-content-tp').html(); //摄像头打点 标注点基础信息
    var $allUl = $('#hjwz-all');

    //现场痕迹物证类别代码
    var xchjwzlbDM = [
        {'key':'print', 'value':'1'},
        {'key':'foot', 'value':'2'},
        {'key':'bio', 'value':'3'},
        {'key':'tool', 'value':'4'},
        {'key':'gun', 'value':'5'},
        {'key':'drug', 'value':'6'},
        {'key':'physic', 'value':'7'},
        {'key':'doc', 'value':'8'},
        {'key':'elec', 'value':'9'},
        {'key':'video', 'value':'10'}
    ];

    var cameraInfo = [];//存放摄像头打点信息
    var map;

    // $('.dict').dict();

    //图片上传
    function picUpload(selector, input){
        var formdata = new FormData();
        formdata.append('myfile', input.files[0]);
        $.ajax({
            url: "http://192.168.1.211:53000/api/file/upload",
            type: "POST",
            data: formdata,
            contentType: false,
            processData: false,
            success: function (data) {
                console.log(data)
                if(data.flag == '1') {
                    $(selector).val('http://192.168.1.211:53000/api/file/download/' + data.fileId + '?preview=true')
                }
            },
            error: function () {
                alert("上传失败！");
            }
        });
    }
    //获取图片唯一ID
    function getPicGuid(type){
        return (type+(((1+Math.random())*0x1000)|0));
    }
    //获取新增内容
    function getHjwzBlockObject(selector){
        var obj = {}, t_obj = {};
        $(selector).find('input').each(function(){
            if(this.type == 'radio' && this.checked){
                obj[this.name] = this.value;
                obj[this.name+'Dict'] = $(this).next().text();
            }else if(this.type == 'checkbox' && this.checked){
                obj[this.name] = this.value;
            }else if(this.type == 'text'){
                obj[this.name] = this.value;
            }
        });

        //提取人
        obj.sceneCollectedPerson = [];
        $(selector).find('.tqr-info-fill li').each(function(){
            if($(this).hasClass('active')){
                t_obj = {};
                t_obj.collectedType = '1';//痕迹物证
                t_obj.collectedPersonId = $(this).data('key');
                t_obj.collectedPerson = $(this).text();
                obj.sceneCollectedPerson.push(t_obj);
            }
        });
        console.log(obj);
        return obj;
    }
    //初始化痕迹物证模块
    function initHjwz(){
        var initDragbar = $('#hjwz-all');
        initDragbar.sortable({
            revert:true
        });
    }
    //新增弹窗input初始化
    function initAddInput(type, $div, order){
        $div.find(':text').val('');//清空之前的数据
        $div.find(':checkbox,:radio').prop('checked', false);
        $div.find('.tqr-info-fill li').removeClass('active');
        $div.find('.validatebox-invalid').removeClass('validatebox-invalid');
        $div.find('#{0}-no'.format(type)).val(order+1);
        $div.find('div[dict-type="radio"]').find('input:first').prop('checked', true);
        $div.find('.tqwp-info').addClass('hide');
        $div.children('p').find('b[id^="add-{0}-"]'.format(type)).removeClass('hideplus');
        $div.children('p').find('b[id^="edit-{0}-"]'.format(type)).addClass('hideplus');
    }
    //修改弹窗input赋值
    function initEditInput(type, $div, data){
        $div.find('.tqr-info-fill li').removeClass('active');
        //操作按钮显示与否
        $div.children('p').find('b[id^="add-{0}-"]'.format(type)).addClass('hideplus');
        $div.children('p').find('b[id^="edit-{0}-"]'.format(type)).removeClass('hideplus');
        //template要修改的内容
        $div.template(data);
        //template后，提取时间datepicker初始化
        $div.find('.cm-input-date').datepicker();
        //template后，树形字典重新初始化
        $div.find('[dict-type="tree"]').dict(null, function(){
            //枪弹种类赋值
            $div.find('input[name="bulletType"]').val(data.bulletType);
            $div.find('input[name="bulletType_displayValue"]').val(data.bulletType_displayValue);
        });
        //字典radio选中判断
        $div.find('[dict-name="materialEvidenceType"]').children('input[value="{0}"]'.format(data.materialEvidenceType)).prop('checked', true);
        $div.find('[dict-name="collectionMode"]').children('input[value="{0}"]'.format(data.collectionMode)).prop('checked', true);
        $div.find('[dict-name="bulletModel"]').children('input[value="{0}"]'.format(data.bulletModel)).prop('checked', true);
        //checkbox选中判断
        if(data.storageFlag == '1'){$('input[name="storageFlag"]').prop('checked', true);}
        if(data.collectedFlag == '1'){$('input[name="collectedFlag"]').prop('checked', true);}
        //提取人选中判断
        data.sceneCollectedPerson.each(function(item){
            $div.find('.tqr-info-fill li[data-key="{0}"]'.format(item.collectedPersonId)).addClass('active');
        });
    }
    //弹窗保存 @type add or edit @module 痕迹物证子类
    function saveOpt(type, module){
        var $div = $('#hjwz-'+module+'-block'),
            $ul = $('#hjwz-'+module),
            $titleUl = $('.hjwz-tabs[param="hjwz"]');
        var saveObj = {category:xchjwzlbDM.where('o=>o.key=="{0}"'.format(module))[0].value};
        var dataObj = {};//data('picInfo', dataObj);
        //必填项验证
        $div.find('.validate').validatebox();
        if($div.find('.validatebox-invalid').length > 0){
            return false;
        }
        //获取输入内容的json对象
        saveObj = $.extend(saveObj, getHjwzBlockObject('#hjwz-'+module+'-block'));
        saveObj.attachmentId = saveObj.pictureId;//痕迹图片路径（文件服务器返回给前端）
        //判断 是否包含实体提取物品 是否勾选。
        //勾选，则需要向提取物品中添加信息。
        if(saveObj.collectedFlag == '1'){
            var tqwpObj = {};
            tqwpObj.name = saveObj.tqwpName;
            tqwpObj.materialEvidenceFlag = '1';
            tqwpObj.amount = saveObj.tqwpAmount;
            tqwpObj.collectedPosition = saveObj.leftPosition;
            tqwpObj.collectedMethod = saveObj.collectionMode;
            tqwpObj.collectedTime = saveObj.collectedTime;
            tqwpObj.pictureId = saveObj.pictureId;
            tqwpObj.attachmentId = saveObj.attachmentId;
            tqwpObj.category = saveObj.category;
            tqwpObj.materialEvidenceType = saveObj.tqwpType;
            tqwpObj.materialEvidenceTypeDict = saveObj.tqwpTypeDict;
            tqwpObj.sceneCollectedPerson = str2obj(obj2str(saveObj.sceneCollectedPerson));
            //调用提取物品的新增方法
            window.tqwpAdd(tqwpObj);
        }
        if(type == 'add'){
            saveObj.uuid = getPicGuid(module);
            //手印的图片，移上去需要显示编辑图片按钮，其他的不需要显示
            if(module == 'print'){saveObj.module = 'print';}
            //新增保存时需要append一个新的图片
            var t_html = $compile(liHtml, saveObj);
            $ul.append(t_html);
            $allUl.append(t_html);
            //将照片的基础信息存放在img上
            dataObj = {};
            dataObj = str2obj(obj2str(saveObj));
            delete dataObj['order'];
            delete dataObj['uuid'];
            delete dataObj['tqwpName'];
            delete dataObj['tqwpAmount'];
            delete dataObj['tqwpProp'];
            delete dataObj['tqwpType'];
            delete dataObj['tqwpTypeDict'];

            $ul.children('li:last').find('img').data('picInfo', dataObj);
            $allUl.children('li:last').find('img').data('picInfo', dataObj);

            //更新数量
            $titleUl.children('li[param="{0}"]'.format(module)).find('em').text($ul.children('li').length - 1);
            $titleUl.children('li[param="all"]').find('em').text($allUl.children('li').length);
        }else if(type == 'edit'){
            saveObj.uuid = $div.find('[uuid]').attr('uuid');

            dataObj = {};
            dataObj = str2obj(obj2str(saveObj));
            delete dataObj['order'];
            delete dataObj['uuid'];
            delete dataObj['tqwpName'];
            delete dataObj['tqwpAmount'];
            delete dataObj['tqwpProp'];
            delete dataObj['tqwpType'];
            delete dataObj['tqwpTypeDict'];

            $ul.find('img[paramId="{0}"]'.format(saveObj.uuid))
                .data('picInfo', dataObj)
                .prop('src', saveObj.pictureId)
                .parent().find('.name').text(saveObj.materialEvidenceName);

            $allUl.find('img[paramId="{0}"]'.format(saveObj.uuid))
                .data('picInfo', dataObj)
                .prop('src', saveObj.pictureId)
                .parent().find('.name').text(saveObj.materialEvidenceName);
        }
        $div.$close();
    }

    //进入新增指纹页面
    function intoAddPrint(){
        var $div = $('#hjwz-print-block');
        var order = $('#hjwz-print').children('li').length - 1;//存放指纹以保存的图片的数量

        initAddInput('print', $div, order);

        /!*$div.find(':text').val('');//清空之前的数据
         $div.find(':checkbox,:radio').prop('checked', false);
         $div.find('.validatebox-invalid').removeClass('validatebox-invalid');
         $div.find('#print-no').val(rownum+1);
         $div.children('p').find('b[id^="add-print-"]').removeClass('hideplus');
         $div.children('p').find('b[id^="edit-print-"]').addClass('hideplus');*!/
        $open('#hjwz-print-block', {width: 1000, title:'添加手印痕迹'});
    }
    //新增指纹保存 @type add:新增保存 edit:修改保存
    function savePrint(type, cb){
        var bol = saveOpt(type, 'print');
        //新增验证不通过，会return false；当验证通过时，不会返回任何内容
        if(bol == undefined){cb && cb();}
    }
    //进入指纹修改页面
    function intoEditPrint(data){
        var $div = $('#hjwz-print-block');
        initEditInput('print', $div, data);
        /!*!//操作按钮显示与否
         $div.children('p').find('b[id^="add-print-"]').addClass('hideplus');
         $div.children('p').find('b[id^="edit-print-"]').removeClass('hideplus');
         //template要修改的内容
         $div.template(data);
         //字典radio选中判断
         $div.find('[dict-name="materialEvidenceType"]').children('input[value="{0}"]'.format(data.materialEvidenceType)).prop('checked', true);
         $div.find('[dict-name="collectionMode"]').children('input[value="{0}"]'.format(data.collectionMode)).prop('checked', true);
         //checkbox选中判断
         if(data.storageFlag == '1'){$('input[name="storageFlag"]').prop('checked', true);}
         if(data.collectedFlag == '1'){$('input[name="collectedFlag"]').prop('checked', true);}*!/
        //打开修改弹出框
        $open('#hjwz-print-block', {width: 1000, title:'修改手印痕迹'});
    }
    //进入新增足迹页面
    function intoAddFoot(){
        var $div = $('#hjwz-foot-block');
        var order = $('#hjwz-foot').children('li').length - 1;

        initAddInput('foot', $div, order);
        $open('#hjwz-foot-block', {width: 1000, title:'添加足迹痕迹'});
    }
    //新增足迹保存 @type add:新增保存 edit:修改保存
    function saveFoot(type, cb){
        var bol = saveOpt(type, 'foot');
        //新增验证不通过，会return false；当验证通过时，不会返回任何内容
        if(bol == undefined){cb && cb();}
    }
    //进入足迹修改页面
    function intoEditFoot(data){
        var $div = $('#hjwz-foot-block');
        initEditInput('foot', $div, data);
        //打开修改弹出框
        $open('#hjwz-foot-block', {width: 1000, title:'修改足迹痕迹'});
    }
    //进入新增生物页面
    function intoAddBio(){
        var $div = $('#hjwz-bio-block');
        var order = $('#hjwz-bio').children('li').length - 1;//存放指纹以保存的图片的数量

        initAddInput('bio', $div, order);
        $open('#hjwz-bio-block', {width: 1000, title:'添加生物痕迹'});
    }
    //生物保存
    function saveBio(type, cb){
        var bol = saveOpt(type, 'bio');
        //新增验证不通过，会return false；当验证通过时，不会返回任何内容
        if(bol == undefined){cb && cb();}
    }
    //进入生物修改页面
    function intoEditBio(data){
        var $div = $('#hjwz-bio-block');
        initEditInput('bio', $div, data);
        //打开修改弹出框
        $open('#hjwz-bio-block', {width: 1000, title:'修改DNA痕迹'});
    }
    //进入新增工具页面
    function intoAddTool(){
        var $div = $('#hjwz-tool-block');
        var order = $('#hjwz-tool').children('li').length - 1;
        initAddInput('tool', $div, order);
        $open('#hjwz-tool-block', {width: 1000, title:'添加工具痕迹'});
    }
    //工具保存
    function saveTool(type, cb){
        var bol = saveOpt(type, 'tool');
        //新增验证不通过，会return false；当验证通过时，不会返回任何内容
        if(bol == undefined){cb && cb();}
    }
    //进入工具修改页面
    function intoEditTool(data){
        var $div = $('#hjwz-tool-block');
        initEditInput('tool', $div, data);
        //打开修改弹出框
        $open('#hjwz-tool-block', {width: 1000, title:'修改工具痕迹'});
    }
    //进入新增枪弹页面
    function intoAddGun(){
        var $div = $('#hjwz-gun-block');
        var order = $('#hjwz-gun').children('li').length - 1;
        initAddInput('gun', $div, order);
        $open('#hjwz-gun-block', {width: 1000, title:'添加枪弹痕迹'});
    }
    //枪弹保存
    function saveGun(type, cb){
        var bol = saveOpt(type, 'gun');
        //新增验证不通过，会return false；当验证通过时，不会返回任何内容
        if(bol == undefined){cb && cb();}
    }
    //进入枪弹修改页面
    function intoEditGun(data){
        var $div = $('#hjwz-gun-block');
        initEditInput('gun', $div, data);
        //打开修改弹出框
        $open('#hjwz-gun-block', {width: 1000, title:'修改枪弹痕迹'});
    }
    //进入新增毒化页面
    function intoAddDrug(){
        var $div = $('#hjwz-drug-block');
        var order = $('#hjwz-drug').children('li').length - 1;
        initAddInput('drug', $div, order);
        $open('#hjwz-drug-block', {width: 1000, title:'添加毒化痕迹'});
    }
    //毒化保存
    function saveDrug(type, cb){
        var bol = saveOpt(type, 'drug');
        //新增验证不通过，会return false；当验证通过时，不会返回任何内容
        if(bol == undefined){cb && cb();}
    }
    //进入毒化修改页面
    function intoEditDrug(data){
        var $div = $('#hjwz-drug-block');
        initEditInput('drug', $div, data);
        //打开修改弹出框
        $open('#hjwz-drug-block', {width: 1000, title:'修改毒化痕迹'});
    }
    //进入新增理化页面
    function intoAddPhysic(){
        var $div = $('#hjwz-physic-block');
        var order = $('#hjwz-physic').children('li').length - 1;
        initAddInput('physic', $div, order);
        $open('#hjwz-physic-block', {width: 1000, title:'添加理化痕迹'});
    }
    //保存理化
    function savePhysic(type, cb){
        var bol = saveOpt(type, 'physic');
        //新增验证不通过，会return false；当验证通过时，不会返回任何内容
        if(bol == undefined){cb && cb();}
    }
    //进入理化修改页面
    function intoEditPhysic(data){
        var $div = $('#hjwz-physic-block');
        initEditInput('physic', $div, data);
        //打开修改弹出框
        $open('#hjwz-physic-block', {width: 1000, title:'修改理化痕迹'});
    }
    //进入新增文检页面
    function intoAddDoc(){
        var $div = $('#hjwz-doc-block');
        var order = $('#hjwz-doc').children('li').length - 1;
        initAddInput('doc', $div, order);
        $open('#hjwz-doc-block', {width: 1000, title:'添加文检痕迹'});
    }
    //文检保存
    function saveDoc(type, cb){
        var bol = saveOpt(type, 'doc');
        //新增验证不通过，会return false；当验证通过时，不会返回任何内容
        if(bol == undefined){cb && cb();}
    }
    //进入文检修改页面
    function intoEditDoc(data){
        var $div = $('#hjwz-doc-block');
        initEditInput('doc', $div, data);
        //打开修改弹出框
        $open('#hjwz-doc-block', {width: 1000, title:'修改文检痕迹'});
    }
    //进入新增电子页面
    function intoAddElec(){
        var $div = $('#hjwz-elec-block');
        var order = $('#hjwz-elec').children('li').length - 1;
        initAddInput('elec', $div, order);
        $open('#hjwz-elec-block', {width: 1000, title:'添加电子痕迹'});
    }
    //电子保存
    function saveElec(type, cb){
        var bol = saveOpt(type, 'elec');
        //新增验证不通过，会return false；当验证通过时，不会返回任何内容
        if(bol == undefined){cb && cb();}
    }
    //进入电子修改页面
    function intoEditElec(data){
        var $div = $('#hjwz-elec-block');
        initEditInput('elec', $div, data);
        //打开修改弹出框
        $open('#hjwz-elec-block', {width: 1000, title:'修改电子痕迹'});
    }
    //进入新增视频页面
    function intoAddVideo(){
        var $div = $('#hjwz-video-block');
        var order = $('#hjwz-video').children('li').length - 1;
        initAddInput('video', $div, order);
        $open('#hjwz-video-block', {width: 1000, title:'添加视频痕迹'});
    }
    //视频保存
    function saveVideo(type, cb){
        var bol = saveOpt(type, 'video');
        //新增验证不通过，会return false；当验证通过时，不会返回任何内容
        if(bol == undefined){cb && cb();}
    }
    //进入视频修改页面
    function intoEditVideo(data){
        var $div = $('#hjwz-video-block');
        initEditInput('video', $div, data);
        //打开修改弹出框
        $open('#hjwz-video-block', {width: 1000, title:'修改视频痕迹'});
    }
    //进入新增摄像头打点页面
    function intoAddCamera(){
        $open('#hjwz-camera-block', {width:'max', height:'max', title:'摄像头打点', onClose: function(){
            var tb = $('#dzwz-camera-table');
            //更新数量
            $('.hjwz-tabs[param="dzwz"]').children('[param="camera"]').find('em').text(cameraInfo.length);
            //将新增的数据template到摄像头结果列表上
            tb.children('tbody').template(cameraInfo);
            //将数据存放在摄像头的table上
            tb.data('tableData', cameraInfo.select('o => {cameraName:o.cameraName, cameraType:o.cameraType, cameraOrientation:o.cameraOrientation, longitude:o.longitude, latitude:o.latitude, pictureId:o.pictureId,attachmentId:o.pictureId}'));
            //注册查看图片
            tb.find('.dzwz-into-view-pic').previewBox('picSrc');
        }});
        $('#map-getpoint-camera').css({width:'100%', height:'100%'});
        initHsMap(function(){
            var casePoints=[];
            var caseMarkers=[];
            var currentCasePoint;

            //部署地配置
            var bsdMapCityArr=["厦门", "118.08", "24.49"];//localData.get('sysParams')['defaultMapCity'].split(',');info([bsdMapCityArr,convert2bdPP({lat:bsdMapCityArr[1],lng:bsdMapCityArr[2]})]);
            var bsdMapCityName=bsdMapCityArr[0];
            var bsdMapCenter={lng:+bsdMapCityArr[1], lat:+bsdMapCityArr[2]};//
            var bsdMapDefaultZoom=+(bsdMapCityArr[3]||12);
            //坐标对象
            //var pp = {lng:117.28, lat:31.86};
            //创建Map实例
            map = new BMap.Map('map-getpoint-camera',window.config.defaultZoomSetting||{minZoom:12,maxZoom:18});
            //点实例
            var point = new BMapPoint(bsdMapCenter);
            //标注点实例
            //var marker=addMarker(point);
            //圆实例, 标注圆
            //var circle = new BMap.Circle(point,5000,{fillColor:'blue', strokeWeight: 1 ,fillOpacity: 0.1, strokeOpacity: 0.1});
            //map.addOverlay(circle);
            //信息框实例
            //var sContent=byid('map-info-window').innerHTML;
            //var infoWindow = new BMap.InfoWindow(sContent,{width:400,marginLeft:100});//, title : '案件详情'});  // 创建信息窗口对象
            //设置中心点和缩放级别
            map.centerAndZoom(point, bsdMapDefaultZoom);
            //允许地图类型选择
            //map.addControl(new BMap.MapTypeControl());
            //当前城市
            map.setCurrentCity(bsdMapCityName);
            //滚轮缩放
            map.enableScrollWheelZoom(true);
            // map.setDefaultCursor("url('C:/Users/Administrator/Desktop/cur/光标/Altr_Fsh.cur')");
            // map.setDefaultCursor('Crosshair');


            //单击获取点击的经纬度
            map.addEventListener('click',function(e){
                var $addCamera = $('#hjwz-add-camera');
                //清空input的值
                $addCamera.find('input:text').val('');
                $addCamera.find('.validatebox-invalid').removeClass('validatebox-invalid');
                //设置默认选中值
                $addCamera.find('[dict-type="radio"]').find('input:first').prop('checked', true);
                $addCamera.find('#camera-lng').val(e.point.lng);
                $addCamera.find('#camera-lat').val(e.point.lat);
                $open('#hjwz-add-camera', {width:500, title:'新增摄像头'});
            });
        });
    }
    //新增摄像头保存
    function saveCamera(){
        var $div = $('#hjwz-add-camera'),
            $tb = $('#camera-result-tb');

        //必填项判断
        $div.find('.validate').validatebox();
        if($div.find('.validatebox-invalid').length > 0){
            return false;
        }

        var obj = getHjwzBlockObject('#hjwz-add-camera');
        obj.uuid = getPicGuid('camera');
        cameraInfo.push(obj);
        $tb.children('tbody').template(cameraInfo);

        $div.$close();
    }

    initHjwz();

    //痕迹物证块事件注册
    $('.main-content').on('click', '#add-scene-hjwz .hjwz-tabs>li', function(){
        //点击样式修改
        $(this).addClass('active').siblings('li').removeClass('active');

        var pTitle = $(this).parent().attr('param'), //获取点击块的title hjwz or dzwz
            theParam = $(this).attr('param'); //获取所属类型
        var dragBar = $('#{0}-{1}'.format(pTitle,theParam));//获取拖拽图片所在区域

        //内容区域的显示、隐藏
        dragBar.removeClass('hide').siblings().addClass('hide');

        if(pTitle == 'hjwz'){
            //图片拖拽初始化
            dragBar.sortable({
                items: "li:not(.add)",
                revert: true
            });
        }
    }).on('mouseenter', '#add-scene-hjwz .pic-detail', function(){
        $(this).find('.opt').fadeIn();
    }).on('mouseleave', '#add-scene-hjwz .pic-detail', function(){
        $(this).find('.opt').fadeOut();
    }).on('click', '.print-edit-pic', function(){
        toast('调用指纹处理软件').warn();
        var data = $.extend({}, $(this).parent().prev().data('picInfo'));
        var $li = $('.hjwz-content').find('img[paramId="{0}"]'.format(data.uuid)).closest('li');
        if(($li.children('.pic-detail').length / $li.length) == 1) {
            data.uuid = getPicGuid('edit-print');
            data.pictureId = 'http://192.168.1.211:53000/api/file/download/585743b5abad320006ec0b54?preview=true';
            $li.addClass('after-edit').append($compile(divHtml, data));
            $li.find('img[paramId^="edit-"]').data('picInfo', data);
        }else{
            data.pictureId = 'http://192.168.1.211:53000/api/file/download/5854b3f1abad320006ec0b34?preview=true';
            $li.find('img[paramId^="edit-"]')
                .data('picInfo', data)
                .prop('src', data.pictureId);
        }
    }).on('click', '.into-edit', function(){
        // var data = $(this).closest('li').data('picInfo');
        var data = $(this).closest('.pic-detail').find('img').data('picInfo');
        var ulParam = $(this).closest('ul').attr('param');
        var editType = ulParam == 'all' ? data.category : ulParam;
        if(editType == 'print'){
            intoEditPrint(data);
        }else if(editType == 'foot'){
            intoEditFoot(data);
        }else if(editType == 'bio'){
            intoEditBio(data);
        }else if(editType == 'tool'){
            intoEditTool(data);
        }else if(editType == 'gun'){
            intoEditGun(data);
        }else if(editType == 'drug'){
            intoEditDrug(data);
        }else if(editType == 'physic'){
            intoEditPhysic(data);
        }else if(editType == 'doc'){
            intoEditDoc(data);
        }else if(editType == 'elec'){
            intoEditElec(data);
        }else if(editType == 'video'){
            intoEditVideo(data);
        }
    }).on('click', '.into-del', function(){
        var len = $(this).closest('li').children('.pic-detail').length;
        var data = $(this).closest('.pic-detail').find('img').data('picInfo');
        var uuid = data.uuid;
        var $li = $('.hjwz-content').find('img[paramId="{0}"]'.format(uuid)).closest('li');
        if(len > 1){
            //存在修改图
            if(uuid.indexOf('edit-') > -1){
                //删除的是修改图
                $li.removeClass('after-edit');
                $li.find('img[paramId="{0}"]'.format(uuid)).closest('.pic-detail').remove();
            }else{
                //删除的是原图，修改图一起删除
                $li.remove();
            }
        }else{
            //只要原图
            $li.remove();
        }
    }).on('click', '#add-scene-hjwz .into-add-print', function(){
        intoAddPrint();
    }).on('click', '#add-scene-hjwz .into-add-foot', function(){
        intoAddFoot();
    }).on('click', '#add-scene-hjwz .into-add-bio', function(){
        intoAddBio();
    }).on('click', '#add-scene-hjwz .into-add-tool', function(){
        intoAddTool();
    }).on('click', '#add-scene-hjwz .into-add-gun', function(){
        intoAddGun();
    }).on('click', '#add-scene-hjwz .into-add-drug', function(){
        intoAddDrug();
    }).on('click', '#add-scene-hjwz .into-add-physic', function(){
        intoAddPhysic();
    }).on('click', '#add-scene-hjwz .into-add-doc', function(){
        intoAddDoc();
    }).on('click', '#add-scene-hjwz .into-add-elec', function(){
        intoAddElec();
    }).on('click', '#add-scene-hjwz .into-add-video', function(){
        intoAddVideo();
    }).on('click', '#add-scene-hjwz .into-add-camera', function(){
        intoAddCamera();
    }).on('click', '#add-scene-hjwz .dzwz-into-map', function(){
        //摄像头 进入地图
        intoAddCamera();
    }).on('click', '#add-scene-hjwz .dzwz-into-add-pic', function(){
        //摄像头 导入图片
        var $input = $(this).children('input');
        var uuid = $(this).attr('uuid');
        $input.on('change', function() {
            window.uploadImg($input.get(0).files[0], function(res){
                var tb = $('#dzwz-camera-table');
                cameraInfo.where('o=>o.uuid=="{0}"'.format(uuid))[0].pictureId = top.sysParams.fileServerPath+'/'+res.data.fileNameRemote;
                tb.children('tbody').template(cameraInfo);
                //注册查看图片
                tb.find('.dzwz-into-view-pic').previewBox('picSrc');
            });
            /!*var cformdata = new FormData();
            cformdata.append('myfile', $input.get(0).files[0]);
            $.ajax({
                url: "http://192.168.1.211:53000/api/file/upload",
                type: "POST",
                data: cformdata,
                contentType: false,
                processData: false,
                success: function (data) {
                    console.log(data)
                    if(data.flag == '1') {
                        var tb = $('#dzwz-camera-table');
                        cameraInfo.where('o=>o.uuid=="{0}"'.format(uuid))[0].pictureId = 'http://192.168.1.211:53000/api/file/download/' + data.fileId + '?preview=true';
                        tb.children('tbody').template(cameraInfo);
                        //注册查看图片
                        tb.find('.dzwz-into-view-pic').previewBox('picSrc');
                    }
                },
                error: function () {
                    alert("上传失败！");
                }
            });*!/
        });
    });

    //勘验人点击事件
    $('.hjwz-open-block').on('click', '.tqr-info-fill li', function(){
        var $this = $(this);
        if($this.hasClass('active')){
            $this.removeClass('active');
        }else{
            $this.addClass('active');
        }
    });

    //新增指纹事件注册
    $('#hjwz-print-block').on('click', '#print-cancel', function(){
        var $div = $('#hjwz-print-block');
        $div.$close();
    }).on('click', '#add-print-save', function(){
        savePrint('add');
    }).on('click', '#add-print-save2', function(){
        savePrint('add', intoAddPrint);
    }).on('change','#print-pic-file', function(){
        // picUpload('#print-pic-src', byid('print-pic-file'))
        window.uploadImg(byid('print-pic-file').files[0], function(res){
            $('#print-pic-src').val(top.sysParams.fileServerPath+'/'+res.data.fileNameRemote);
        });
    }).on('click', '#edit-print-save', function(){
        savePrint('edit');
    }).on('click', '.take-goods-flag', function(){
        var checked = $(this).prop('checked');
        var $tqwpInfo = $(this).parent().next('.tqwp-info');
        if(checked){
            $tqwpInfo.removeClass('hide');
        }else{
            $tqwpInfo.addClass('hide');
            $tqwpInfo.find(':text').val('');
            $tqwpInfo.find('div[dict-type="radio"]').find('input:first').prop('checked', true);
        }
    });

    //足迹弹窗注册事件
    $('#hjwz-foot-block').on('click', '#foot-cancel', function(){
        $('#hjwz-foot-block').$close();
    }).on('click', '#add-foot-save', function(){
        saveFoot('add');
    }).on('click', '#add-foot-save2', function(){
        saveFoot('add', intoAddFoot);
    }).on('change', '#foot-pic-file', function(){
        // picUpload('#foot-pic-src', byid('foot-pic-file'));
        window.uploadImg(byid('foot-pic-file').files[0], function(res){
            $('#foot-pic-src').val(top.sysParams.fileServerPath+'/'+res.data.fileNameRemote);
        });
    }).on('click', '#edit-foot-save', function(){
        saveFoot('edit');
    }).on('click', '.take-goods-flag', function(){
        var checked = $(this).prop('checked');
        var $tqwpInfo = $(this).parent().next('.tqwp-info');
        if(checked){
            $tqwpInfo.removeClass('hide');
        }else{
            $tqwpInfo.addClass('hide');
            $tqwpInfo.find(':text').val('');
            $tqwpInfo.find('div[dict-type="radio"]').find('input:first').prop('checked', true);
        }
    });

    //生物弹窗注册事件
    $('#hjwz-bio-block').on('click', '#bio-cancel', function(){
        $('#hjwz-bio-block').$close();
    }).on('click', '#add-bio-save', function(){
        saveBio('add');
    }).on('click', '#add-bio-save2', function(){
        saveBio('add', intoAddBio);
    }).on('change', '#bio-pic-file', function(){
        // picUpload('#bio-pic-src', byid('bio-pic-file'));
        window.uploadImg(byid('bio-pic-file').files[0], function(res){
            $('#bio-pic-src').val(top.sysParams.fileServerPath+'/'+res.data.fileNameRemote);
        });
    }).on('click', '#edit-bio-save', function(){
        saveBio('edit');
    }).on('click', '.take-goods-flag', function(){
        var checked = $(this).prop('checked');
        var $tqwpInfo = $(this).parent().next('.tqwp-info');
        if(checked){
            $tqwpInfo.removeClass('hide');
        }else{
            $tqwpInfo.addClass('hide');
            $tqwpInfo.find(':text').val('');
            $tqwpInfo.find('div[dict-type="radio"]').find('input:first').prop('checked', true);
        }
    });

    //工具弹窗注册事件
    $('#hjwz-tool-block').on('click', '#tool-cancel', function(){
        $('#hjwz-tool-block').$close();
    }).on('click', '#add-tool-save', function(){
        saveTool('add');
    }).on('click', '#add-tool-save2', function(){
        saveTool('add', intoAddTool);
    }).on('change', '#tool-pic-file', function(){
        // picUpload('#tool-pic-src', bid('tool-pic-file'));
        window.uploadImg(byid('tool-pic-file').files[0], function(res){
            $('#tool-pic-src').val(top.sysParams.fileServerPath+'/'+res.data.fileNameRemote);
        });
    }).on('click', '#edit-tool-save', function(){
        saveTool('edit');
    }).on('click', '.take-goods-flag', function(){
        var checked = $(this).prop('checked');
        var $tqwpInfo = $(this).parent().next('.tqwp-info');
        if(checked){
            $tqwpInfo.removeClass('hide');
        }else{
            $tqwpInfo.addClass('hide');
            $tqwpInfo.find(':text').val('');
            $tqwpInfo.find('div[dict-type="radio"]').find('input:first').prop('checked', true);
        }
    });

    //枪弹弹窗注册事件
    $('#hjwz-gun-block').on('click', '#gun-cancel', function(){
        $('#hjwz-gun-block').$close();
    }).on('click', '#add-gun-save', function(){
        saveGun('add');
    }).on('click', '#add-gun-save2', function(){
        saveGun('add', intoAddGun);
    }).on('change', '#gun-pic-file', function(){
        // picUpload('#gun-pic-src', byid('gun-pic-file'));
        window.uploadImg(byid('gun-pic-file').files[0], function(res){
            $('#gun-pic-src').val(top.sysParams.fileServerPath+'/'+res.data.fileNameRemote);
        });
    }).on('click', '#edit-gun-save', function(){
        saveGun('edit');
    }).on('click', '.take-goods-flag', function(){
        var checked = $(this).prop('checked');
        var $tqwpInfo = $(this).parent().next('.tqwp-info');
        if(checked){
            $tqwpInfo.removeClass('hide');
        }else{
            $tqwpInfo.addClass('hide');
            $tqwpInfo.find(':text').val('');
            $tqwpInfo.find('div[dict-type="radio"]').find('input:first').prop('checked', true);
        }
    });

    //毒化弹窗注册事件
    $('#hjwz-drug-block').on('click', '#drug-cancel', function(){
        $('#hjwz-drug-block').$close();
    }).on('click', '#add-drug-save', function(){
        saveDrug('add');
    }).on('click', '#add-drug-save2', function(){
        saveDrug('add', intoAddDrug);
    }).on('change', '#drug-pic-file', function(){
        // picUpload('#drug-pic-src', byid('drug-pic-file'));
        window.uploadImg(byid('drug-pic-file').files[0], function(res){
            $('#drug-pic-src').val(top.sysParams.fileServerPath+'/'+res.data.fileNameRemote);
        });
    }).on('click', '#edit-drug-save', function(){
        saveDrug('edit');
    }).on('click', '.take-goods-flag', function(){
        var checked = $(this).prop('checked');
        var $tqwpInfo = $(this).parent().next('.tqwp-info');
        if(checked){
            $tqwpInfo.removeClass('hide');
        }else{
            $tqwpInfo.addClass('hide');
            $tqwpInfo.find(':text').val('');
            $tqwpInfo.find('div[dict-type="radio"]').find('input:first').prop('checked', true);
        }
    });

    //理化弹窗注册事件
    $('#hjwz-physic-block').on('click', '#physic-cancel', function(){
        $('#hjwz-physic-block').$close();
    }).on('click', '#add-physic-save', function(){
        savePhysic('add');
    }).on('click', '#add-physic-save2', function(){
        savePhysic('add', intoAddPhysic);
    }).on('change', '#physic-pic-file', function(){
        // picUpload('#physic-pic-src', byid('physic-pic-file'));
        window.uploadImg(byid('physic-pic-file').files[0], function(res){
            $('#physic-pic-src').val(top.sysParams.fileServerPath+'/'+res.data.fileNameRemote);
        });
    }).on('click', '#edit-physic-save', function(){
        savePhysic('edit');
    }).on('click', '.take-goods-flag', function(){
        var checked = $(this).prop('checked');
        var $tqwpInfo = $(this).parent().next('.tqwp-info');
        if(checked){
            $tqwpInfo.removeClass('hide');
        }else{
            $tqwpInfo.addClass('hide');
            $tqwpInfo.find(':text').val('');
            $tqwpInfo.find('div[dict-type="radio"]').find('input:first').prop('checked', true);
        }
    });

    //文检弹窗注册事件
    $('#hjwz-doc-block').on('click', '#doc-cancel', function(){
        $('#hjwz-doc-block').$close();
    }).on('click', '#add-doc-save', function(){
        saveDoc('add');
    }).on('click', '#add-doc-save2', function(){
        saveDoc('add', intoAddDoc);
    }).on('change', '#doc-pic-file', function(){
        // picUpload('#doc-pic-src', byid('doc-pic-file'));
        window.uploadImg(byid('doc-pic-file').files[0], function(res){
            $('#doc-pic-src').val(top.sysParams.fileServerPath+'/'+res.data.fileNameRemote);
        });
    }).on('click', '#edit-doc-save', function(){
        saveDoc('edit');
    }).on('click', '.take-goods-flag', function(){
        var checked = $(this).prop('checked');
        var $tqwpInfo = $(this).parent().next('.tqwp-info');
        if(checked){
            $tqwpInfo.removeClass('hide');
        }else{
            $tqwpInfo.addClass('hide');
            $tqwpInfo.find(':text').val('');
            $tqwpInfo.find('div[dict-type="radio"]').find('input:first').prop('checked', true);
        }
    });

    //电子弹窗注册事件
    $('#hjwz-elec-block').on('click', '#elec-cancel', function(){
        $('#hjwz-elec-block').$close();
    }).on('click', '#add-elec-save', function(){
        saveElec('add');
    }).on('click', '#add-elec-save2', function(){
        saveElec('add', intoAddElec);
    }).on('change', '#elec-pic-file', function(){
        // picUpload('#elec-pic-src', byid('elec-pic-file'));
        window.uploadImg(byid('elec-pic-file').files[0], function(res){
            $('#elec-pic-src').val(top.sysParams.fileServerPath+'/'+res.data.fileNameRemote);
        });
    }).on('click', '#edit-elec-save', function(){
        saveElec('edit');
    }).on('click', '.take-goods-flag', function(){
        var checked = $(this).prop('checked');
        var $tqwpInfo = $(this).parent().next('.tqwp-info');
        if(checked){
            $tqwpInfo.removeClass('hide');
        }else{
            $tqwpInfo.addClass('hide');
            $tqwpInfo.find(':text').val('');
            $tqwpInfo.find('div[dict-type="radio"]').find('input:first').prop('checked', true);
        }
    });

    //视频弹窗注册事件
    $('#hjwz-video-block').on('click', '#video-cancel', function(){
        $('#hjwz-video-block').$close();
    }).on('click', '#add-video-save', function(){
        saveVideo('add');
    }).on('click', '#add-video-save2', function(){
        saveVideo('add', intoAddVideo);
    }).on('change', '#video-pic-file', function(){
        // picUpload('#video-pic-src', byid('video-pic-file'));
        window.uploadImg(byid('video-pic-file').files[0], function(res){
            $('#video-pic-src').val(top.sysParams.fileServerPath+'/'+res.data.fileNameRemote);
        });
    }).on('click', '#edit-video-save', function(){
        saveVideo('edit');
    }).on('click', '.take-goods-flag', function(){
        var checked = $(this).prop('checked');
        var $tqwpInfo = $(this).parent().next('.tqwp-info');
        if(checked){
            $tqwpInfo.removeClass('hide');
        }else{
            $tqwpInfo.addClass('hide');
            $tqwpInfo.find(':text').val('');
            $tqwpInfo.find('div[dict-type="radio"]').find('input:first').prop('checked', true);
        }
    });

    //摄像头打点弹窗注册事件
    $('#hjwz-camera-block').on('click', 'u', function(){
        $(this).addClass('active').siblings('u').removeClass('active');
    }).on('click', '.del-camera', function(){
        var uuid = $(this).attr('uuid');
        var index = cameraInfo.select('o => o.uuid').indexOf(uuid);
        if(index > -1){
            cameraInfo.splice(index, 1);
            $('#camera-result-tb').children('tbody').template(cameraInfo);
        }
    }).on('click', '.show-map-point', function(){
        //点击摄像头名称，在地图中显示标注点
        var uuid = $(this).attr('uuid'), lng = $(this).attr('lng'), lat = $(this).attr('lat');
        //设置标注点为摄像头图片
        var cameraIcon = new BMap.Icon('../img/icon/on-camera.png', new BMap.Size(32,32));
        //设置中心点
        var new_point = new BMap.Point(lng, lat);
        //创建标注
        var marker = new BMap.Marker(new_point,{icon:cameraIcon});
        // 创建信息窗口对象
        var infoWindow = new BMap.InfoWindow($compile(sContentHtml, cameraInfo.where('o=>o.uuid=="{0}"'.format(uuid))));
        // 将标注添加到地图中
        map.addOverlay(marker);
        map.panTo(new_point);
        marker.addEventListener('click', function(){
            this.openInfoWindow(infoWindow);
            event.stopPropagation();
        });
    });

    //摄像头打点新增弹窗
    $('#hjwz-add-camera').on('click', '#add-camera-save', function(){
        saveCamera();
    }).on('click', '#add-camera-save2', function(){

    });
});*/
