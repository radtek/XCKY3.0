    require('./lib/defineding.js');
    window.extending({voidFn:function(){}})

    var config=require('../data/config.json');

    config.isLocal=((location.protocol=='file:' || location.protocol=='chrome-extension:') && typeof window['require']=='function') || (config.useLocalAgent && location.href.indexOf('webapp/dist/')>-1);


    window.extending({config:config});

    var locals=require('./lib/locals');
    window.extending(locals,true);
    window.extending({ loadHTMLCache:Object.create(null)});


    require('./lib/path.js');


    var $=require('./lib/jquery');
    window.extending({$:$,jQuery:$},true);

    //require('./lib/bootstrap.3.31');

    var $eui=require('./lib/eui');
    $eui($);

    var $cookie=require('./lib/jquery.cookie');
    $cookie($);

    var exy=require('./lib/exy');
    window.extending(exy,true);

    require('./lib/proto');

    var stp=require('./lib/stp');
    window.extending(stp);

    var pub=require('./lib/pub');
    window.extending(pub,true);

    var pubBusiness=require('./business/pub-business');
    window.extending(pubBusiness);


    var paging=require('./lib/paging.js');

    var validate=require('./lib/validate.js');

    top.molKeys && window.localParamsInit(top.molKeys);


    //for mock...
    require('./lib/mock-register.js');

    require('./filter.js');

    require('./widget.js');


    //TODO 应该生成到index.js中
    if(window==top){
        window.extending('$state',require('./lib/index.state.js'));
        window.$state=window.$state;
        require('./state.js');
    }


    require('./lib/patch.js');



    window.makeAct=window.makeAct;
    window.$post=window.$post;
    window.$open=window.$open;
    window.$get=window.$get;
    window.toast=window.toast;
    window.$alert=window.$alert;
    window.$confirm=window.$confirm;
    window.typeOf=window.typeOf;
    window.obj2str=window.obj2str;
    window.str2obj=window.str2obj;
    window.queryParse=window.queryParse;
    window.dash2camel=window.dash2camel;
    window.camel2dash=window.camel2dash;
    window.byid=window.byid;
    window.bytag=window.bytag;
    window.getRect=window.getRect;

    if(typeof module === "object" && typeof module.exports === "object" ){
        module.exports={
            checkDtd:function(){
                if(document.compatMode=='BackCompat'){
                    throw new Error('BackCompat！please check DTD！');
                }
            }
        }
    }


