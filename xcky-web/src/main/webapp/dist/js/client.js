/**
 * Created by Administrator on 2017/1/4.
 */

/**
 * 文件上传工具
 * @param filePath 文件路径（本地绝对路径）
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
        $alert('启动失败，原因：'+e.message);
        console.log(e);
    }
}

/**
 * 根据nw下载远程文件到本地
 * @param name
 * @param cb
 */
function downloadFilePlugin(name, cb){
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
 * @param receiveFilePathCb
 */
function runKctPlugin(receiveFilePathCb){
    try{
        var processName = 'KCTPlugin4Chrome.exe';
        var exePath = getAppPath() + '\\dist\\KCTPlugin\\' + processName;
        isAppRunning(processName, function(v){
            if(v){
                killApp(processName, function(){
                    runApp(exePath, [top.sysParams.fileUploadPath], receiveFilePathCb);
                });
            }else{
                runApp(exePath, [top.sysParams.fileUploadPath], receiveFilePathCb);
            }
        });
    }catch(e){
        $alert('启动失败，原因：'+e.message);
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
        $alert('启动失败，原因：'+e.message);
        console.log(e);
    }
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
}

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
}

/**
 * 使用默认浏览器打开URL
 * @param url
 */
function openUrl(url){
    require('nw.gui').Shell.openExternal(url);
}

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