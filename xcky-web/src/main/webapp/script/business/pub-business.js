/**
 * Created by EvanYao on 2016/9/21.
 */

window.sysParams=window.sysParams||localData.get('sysParams')||{};

var cobwebPath=window.sysParams['cobwebPath']||'http://10.130.151.151:8088/cobweb';
var shortPath=cobwebPath.replace('http://','').replace('/cobweb','');
var cobwebPagePath=getViewPath('page-cobweb.html')+'&shortPath={0}&phoneNo={1}'.format(shortPath,12345);

if(typeof module === "object" && typeof module.exports === "object" ){
    module.exports={
        //打开word控件页面
        openDoc:function(docID,tableID,tableName,title,allowEdit,showCustomBar,showMenuBar,theFrame){
            var obj=arguments[0];
            var ag=typeof obj=='object'?[obj.docID,obj.tableID,obj.tableName,obj.title,obj.allowEdit,obj.showCustomBar,obj.showMenuBar]:arguments;
            var wordPath=top.config['wordJspPath']||(top.path+'/jsp/word.jsp');
            var src=wordPath+'?docID={0}&tableID={1}&tableName={2}&title={3}&allowEdit={4}&showCustomBar={5}&showMenuBar={6}'.format(ag[0],ag[1],ag[2]||'',ag[3]||'',ag[4]||'0',ag[5]||'0',ag[6]||'0');
            if(typeof theFrame=='object'){
                return theFrame.src=src;
            }else{
                return top.$open(src,{title:title,width:top.innerWidth-120,height:top.innerHeight-20});
            }
        },
        //在指定的iframe中打开word
        openDocInFrame:function(theFrame,docID,tableID,tableName,title,allowEdit,showCustomBar,showMenuBar){
            return openDoc(docID,tableID,tableName,title,allowEdit,showCustomBar,showMenuBar,theFrame);
        },
        //蛛网SIS登录
        cobwebInit:function(cobwebPath){
            window.open(cobwebPagePath);
        },
        //蛛网指向具体页面
        cobwebDirect:function(url){
            info('蛛网页面地址:'+url);
            var ifr=document.createElement('iframe');
            ifr.height=0,ifr.width=0;
            document.body.appendChild(ifr);
            ifr.onload=function(){
                setTimeout(function(){
                    window.open(url);
                    setTimeout(function(){
                        document.body.removeChild(ifr);
                    },2000);
                },360);
            }
            ifr.src=cobwebPagePath;
        },
        //蛛网查询
        cobwebSearch:function(keyWord,keyType){
            //if(!keyWord){
            //    $alert('查询关键字为空!');
            //    return false;
            //}
            keyWord=keyWord||'';
            keyType=keyType||'handsetNum';
            keyType=='id' && (keyType='identification');

            var url=keyWord?'{0}/oneSearch/searchResult?keyType={1}&keyWord={2}'.format(cobwebPath,keyType,keyWord)
                :'{0}/oneSearch/searchPage'.format(cobwebPath);
            cobwebDirect(url);
        },
        //SIS首页
        sisInit:function(){
            cobwebDirect(cobwebPath+'/sisSearch/getIndex');
        }

    }
}

/*
*
* $.post('http://10.130.151.151:8088/cobweb/system/thirdAutoLogin',{phoneNo:13738083247,idCard:350524199000000000,jumpUrl:'/oneSearch/searchResult?keyType=handsetNum&keyWord=13738083247'},function(res){ info(res)})



 http://10.130.151.151:8088/cobweb/oneSearch/searchResult?keyType=handsetNum&keyWord=13738083247


 function cobwebInit(){
 var fr=document.createElement('form')
 fr.action='http://10.130.151.151:8088/cobweb/system/thirdAutoLogin'
 fr.method='POST'
 var ipt=document.createElement('input')
 ipt.name='phoneNo'
 ipt.value='13738083247'
 fr.appendChild(ipt)
 var ipt2=document.createElement('input')
 ipt2.name='idCard'
 ipt2.value='350524199000000000'
 fr.appendChild(ipt2)
 var ipt3=document.createElement('input')
 ipt3.name='jumpUrl'
 ipt3.value='/oneSearch/searchResult?keyType=handsetNum&keyWord=13738083247'
 fr.appendChild(ipt3)
 document.body.appendChild(fr);
 fr.submit();
 }

 function cobwebSearch(phoneNo,cobwebPath){
 var ifr=document.createElement('iframe');
 ifr.height=0,ifr.width=0;
 document.body.appendChild(ifr);
 ifr.onload=function(){
 setTimeout(function(){
 window.open( ('http://'+ (cobwebPath||'10.130.151.151:8088') +'/cobweb') + '/oneSearch/searchResult?keyType=handsetNum&keyWord='+(phoneNo||'13738083247'))
 document.body.removeChild(ifr);
 },300);
 }
 ifr.src=getViewPath('cobweb.html')+'&cobwebPath='+(cobwebPath||'10.130.151.151:8088') +'&phoneNo='+phoneNo
 }

 function cobwebIndex(cobwebPath){
 window.open( getViewPath('cobweb.html')+'&cobwebPath='+(cobwebPath||'10.130.151.151:8088') + '&phoneNo=13766668888' )
 }


 cityTreeName:福建省厅,福建福州,福建厦门,福建泉州,福建龙岩,福州海关,福建泉州安溪县,福建政和县
 cityTreeId:3500,3501,3502,3505,3508,3589,3598,3599
 card:
 phone:15759273144
 plate:
 name:
 beginTime:
 endTime:
 checkAllCity:0

 <ul class="dropdown-menu kind-dropdown" role="menu" id="kindValueList" style="display: block;">
 <li class="kind_item" id="handsetNum"><a><i class="icon-ok"></i>手机号码</a></li>
 <li class="kind_item" id="identification"><a><i class="icon-ok"></i>证件号码</a></li>
 <li class="kind_item" id="viNum"><a><i class="icon-ok"></i>虚拟号码</a></li>
 <!-- 搜索时不显示 -->
 <li class="kind_item" id="qqNum"><a class="current-kind"><i class="icon-ok"></i>QQ号码</a></li>
* */