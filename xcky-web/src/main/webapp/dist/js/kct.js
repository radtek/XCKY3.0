/**
 * Created by Administrator on 2017/1/4.
 */

/**
 * 文件上传工具
 * @param filePath 文件路径
 * @param cb 上传成功后的回调
 */
function uploadFilePlugin(filePath, cb){
    try{
        var processName = 'UpLoadFilePlugin.exe';
        var exePath = getAppPath() + '\\dist\\UpLoadFilePlugin\\' + processName;
        isAppRunning(processName, function(v){
            if(v){
                killApp(processName, function(){
                    runApp(exePath, [filePath, top.sysParams.fileUploadPath], cb);
                });
            }else{
                runApp(exePath, [filePath, top.sysParams.fileUploadPath], cb);
            }
        });
    }catch(e){
        alert('启动失败，原因：'+e.message);
        console.log(e);
    }
}

/**
 * 根据nw下载远程文件到本地
 * @param name
 * @param cb
 */
function downloadFile(name, cb){
    var updater = require('hupdater');
    var fs = require('fs');

    var downloadApi = top.sysParams.fileServerPath + name; //要下载的服务器地址
    var targetPath = getAppPath() + '\\temp\\'; //存放的本地地址

    //新建文件夹
    if(!fs.existsSync(getAppPath() + '\\temp')){
        fs.mkdirSync(getAppPath() + '\\temp');
    }

    updater.downloadNewVersion(downloadApi, targetPath, function(err, filePath){
        if(err){
            console.log('下载失败');
            return;
        }
        cb && cb(filePath);
    });
}

/**
 * 启动勘测通插件
 */
function runKctPlugin(){
    try{
        var processName = 'KCTPlugin4Chrome.exe';
        var exePath = getAppPath() + '\\dist\\KCTPlugin\\' + processName;
        isAppRunning(processName, function(v){
            if(v){
                killApp(processName, function(){
                    runApp(exePath, [top.sysParams.fileUploadPath], receiveFilePath);
                });
            }else{
                runApp(exePath, [top.sysParams.fileUploadPath], receiveFilePath);
            }
        });
    }catch(e){
        alert('启动失败，原因：'+e.message);
        console.log(e);
    }
}

/**
 * 启动指纹处理工具
 */
function runPrintImgPlugin(type, printHandleSrc, printHandleCb){
    try{
        var processName = 'HisignImage.exe';
        var exePath = getAppPath() + '\\dist\\HisignImage\\' + processName;
        var imgSaveSrc = getAppPath() + '\\dist\\HisignImage\\print_temp\\';
        // var imgSaveSrc = getAppPath() + '\\temp\\';
        var fs = require('fs');
        if(!fs.existsSync(imgSaveSrc)){
            //新建文件夹
            fs.mkdirSync(imgSaveSrc);
        }else{
            //如果存在文件夹  则将文件夹内的文件清空
            var files = [];
            files = fs.readdirSync(imgSaveSrc);
            files.forEach(function(file, i){
                var curPath = imgSaveSrc + '/' + file;
                fs.unlinkSync(curPath);
            });
        }
        isAppRunning(processName, function(v){
            if(v){
                killApp(processName, function(){
                    runApp(exePath, [type, printHandleSrc, imgSaveSrc+'print.img', imgSaveSrc+'print_preview.jpg'],null, null, function(){
                        //获取本地路径，调用上传文件到服务器的exe上传文件
                        uploadFilePlugin(imgSaveSrc+'print.img', printHandleCb);
                        uploadFilePlugin(imgSaveSrc+'print_preview.jpg', printHandleCb);
                    });
                });
            }else{
                runApp(exePath, [type, printHandleSrc, imgSaveSrc+'print.img', imgSaveSrc+'print_preview.jpg'],null, null, function(){
                    //获取本地路径，调用上传文件到服务器的exe上传文件
                    uploadFilePlugin(imgSaveSrc+'print.img', printHandleCb);
                    uploadFilePlugin(imgSaveSrc+'print_preview.jpg', printHandleCb);
                });
            }
        });
    }catch(e){
        alert('启动失败，原因：'+e.message);
        console.log(e);
    }
}

/**
 * 接收勘测通返回信息
 * @param path
 */
function receiveFilePath(filePath){
    var filePath3 = '[' +
        '{"fileNameLocal":"data.xml","fileNameRemote":"M00/00/0B/NJCDKBCJDBJC.xml","isImage":false},' +
        '{"fileNameLocal":"K3502000000002017010026_bl-0.xml","fileNameRemote":"M00/00/0B/123456789.xml","isImage":false},' +
        '{"fileNameLocal":"K3502000000002017010026_bl-1.xml","fileNameRemote":"M00/00/0B/123456789.xml","isImage":false},' +
        '{"fileNameLocal":"K3502000000002017010026_bl-2.xml","fileNameRemote":"M00/00/0B/123456789.xml","isImage":false},' +
        '{"fileNameLocal":"K3502000000002017010026_bl-3.xml","fileNameRemote":"M00/00/0B/123456789.xml","isImage":false},' +
        '{"fileNameLocal":"K3502000000002017010026_bl-4.xml","fileNameRemote":"M00/00/0B/123456789.xml","isImage":false},' +
        '{"fileNameLocal":"K3502000000002017010026_bl-5.xml","fileNameRemote":"M00/00/0B/123456789.xml","isImage":false},' +
        '{"fileNameLocal":"K3502000000002017010026_bl-6.xml","fileNameRemote":"M00/00/0B/123456789.xml","isImage":false},' +
        '{"fileNameLocal":"K3502000000002017010026_bl-7.xml","fileNameRemote":"M00/00/0B/123456789.xml","isImage":false},' +
        '{"fileNameLocal":"WIFI-K3502000000002017010026_bl-8.xml","fileNameRemote":"M00/00/0B/123456789.xml","isImage":false},'  +
        '{"fileNameLocal":"WIFI-K3502000000002017010026_bl-9.xml","fileNameRemote":"M00/00/0B/123456789.xml","isImage":false}'  +
        ']';
    var pathStr  = require('querystring').parse(filePath).result;
    pathStr = filePath3;
    if(!pathStr){
        return;
    }
    var pathArray = str2obj(pathStr);
    var fileArray = [];
    pathArray.forEach(function (o, index) {
        var obj = {
            fileName: o.fileNameLocal,
            filePath: o.fileNameRemote,
            fileType: getKctFileType(o.fileNameLocal)
        };
        fileArray.push(obj);
    });
console.log(fileArray)
    if(!fileArray){
        alert('没有文件导入');
        return;
    }
    //新增现场中基站和WiFi table数据显示
    var jzdata = fileArray.where('o=>o.fileType=="0"||o.fileType=="1"'),
        wifidata = fileArray.where('o=>o.fileType=="2"');
    $('#dzwz-jz-table').children('tbody').template(jzdata, function(item, i){
        if(item.fileType == '0'){
            item.fileTypeTxt = '动态';
        }else if(item.fileType == '1'){
            item.fileTypeTxt = '静态';
        }
    });
    $('#dzwz-wifi-table').children('tbody').template(wifidata);

    //将数量放在对应标签上
    $('.hjwz-tabs[param="dzwz"]').children('[param="jz"]').find('em').text(jzdata.length);
    $('.hjwz-tabs[param="dzwz"]').children('[param="wifi"]').find('em').text(wifidata.length);
    //将数据存放在table上
    $('#dzwz-jz-table').data('tableData', jzdata.select('o=>{category:"01",fileName:o.fileName,fileServerPath:o.filePath}'));
    $('#dzwz-wifi-table').data('tableData', wifidata.select('o=>{category:"01",fileName:o.fileName,fileServerPath:o.filePath}'));
    fileArray = null;
}

/**
 * 获取基站文件类型
 * @param fileName
 * @returns {string} 0:动态 1:静态 2:wifi
 */
function getKctFileType(fileName){
    var fileType = '0';
    fileName = fileName.toLowerCase();
    if(fileName == 'data.xml'){
        fileType = '1';
    }else if(fileName.indexOf('wifi')>-1){
        fileType = '2';
    }
    return fileType;
}

/**
 * 新增现场 删除基站和WiFi的内容
 * @param selector
 * @param filePath
 */
function deleteKctFile(selector, filePath) {
    $(selector).parent().parent().remove();//remove tr
    console.log(filePath);
    // require('fs').unlinkSync(filePath);
}


/**
 * 根据路径运行程序并传递参数
 * @param exepath 程序绝对路径
 * @param args 参数
 * @param dataCallBack errCallBack closeCallBack 消息，错误，关闭回调
 * @returns {*}
 */
function runApp(exepath, args, dataCallBack, errCallBack, closeCallBack){
    var opts = {
        detached: true
    };
    var sp = require('child_process').spawn(exepath, args, opts);
    sp.stdout.on('data', function(data){
        if(typeof dataCallBack == 'function'){
            var str = require('iconv-lite').decode(data, 'gbk');
            dataCallBack(str);
        }
    });
    sp.stderr.on('data', function(err){
        if(typeof errCallBack == 'function') {
            errCallBack(err);
        }
    });
    sp.on('close', function(code){
        if(typeof closeCallBack == 'function') {
            closeCallBack(code);
        }
    });
    sp.unref();
    return sp;
}

/**
 * 根据进程名称检查程序是否正在运行
 * @param processName 进程名称
 * @param callBack 回调函数
 */
function isAppRunning(processName, callBack) {
    var cmd = process.platform == 'win32' ? 'tasklist' : 'ps aux';
    var cp = require('child_process');
    var nwexec = cp.spawn('cmd.exe', ['/s', '/c', cmd]);
    var num = 0;
    nwexec.on('close', function(code) {
        nwexec.kill();
        if(num > 0) {
            callBack(true);
        } else {
            callBack(false);
        }
    });
    nwexec.stdout.on('data', function(data) {
        var stdout = data.toString()
        stdout = stdout.trim();
        if(stdout.indexOf(processName) >= 0) {
            num++;
        }
    });
};

/**
 * 根据进程名称停止程序
 * @param processName 进程名称
 * @param callBack 回调函数
 */
function killApp(processName, callBack) {
    var cp = require('child_process');
    cp.exec('tasklist | find "'+processName+'"', function(error, stdout, stderr) {
        if(stdout != "") {
            cp.exec("taskkill /f /t /im "+processName, function(error, stdout, stderr) {
                callBack();
            });
        }
    });
};

/**
 * 使用默认浏览器打开URL
 * @param url
 */
function openUrl(url){
    require('nw.gui').Shell.openExternal(url);
};

/**
 * 使用IE打开链接
 * @param url
 */
function openUrlWithIE(url){
    require('child_process').exec('start,"" "iexplore" "'+url+'"');
}

/**
 * 使用默认软件打开文件
 * @param filePath
 */
function openFileWithDefault(filePath){
    require('nw.gui').Shell.openItem(filePath);
}

/**
 * 打开文件所在路径文件夹
 * @param filePath
 */
function showFileInFolder(filePath){
    require('nw.gui').Shell.showItemInFolder(filePath);
}

/**
 * 打开文件夹
 * @param path
 */
function showFolder(path){
    require('nw.gui').Shell.openExternal(path);
}


/**
 * 获取程序根目录
 * @returns {*}
 */
function getAppPath(){
    return require('path').dirname(process.execPath);
}