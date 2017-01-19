/**
 * Created by EvanYao on 2016/9/10.
 */
function mapGetpointInitFn(){
    importing('hsmap',function(){
        $('#map-getpoint-ct').css({ height:'100%'});
        //载入地图相关
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
            var map =window.map= new BMap.Map('map-getpoint-ct',window.config.defaultZoomSetting||{minZoom:12,maxZoom:18});
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


            //单击获取点击的经纬度
            map.addEventListener("click",function(e){
                alert(e.point.lng + "," + e.point.lat);
            });
        });
    });
}

