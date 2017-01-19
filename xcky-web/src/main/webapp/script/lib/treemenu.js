/**
 * Created by EvanYao on 2016/9/21.
 */
//左侧折叠菜单
window.$.fn.treemenu=(function(){
    function expandMenu(){
        //event.stopPropagation();
        var ul=$(this);
        if(ul.data('showed')==1){
            ul.slideUp().data('showed',0).parent().removeClass('expanded');
        }else{
            ul.slideDown().data('showed',1).parent().addClass('expanded');
        }
    }

    function reset(treeMenu){
        //treeMenu.clearQueue();
        treeMenu.stop(true,true);
        treeMenu.children('ul').stop(true,true);
        treeMenu.width(170);
        treeMenu.data('collapsed',false);
        treeMenu.children('ul').show();
        //treeMenu.queue(function(){
        //    treeMenu.width(170).find('.tree-menu-accordion').show();
        //});
        return treeMenu;
    }
    function selectItem(event,selectHandle) {
        var li=$(this);
        event.stopPropagation();
        var src,navlink,ul,ul3,defaultInto=li.attr('default-into');

        //清空尚未完成的效果
        var treeMenu=li.closest('.tree-menu-accordion').parent();
        //reset(treeMenu);

        //所有项移除,自身加上selected
        treeMenu.find('li').removeClass('selected');
        li.addClass('selected').parents('li').addClass('selected');

        //先去找默认进入
        li.find('li').each(function(){
            var $this=$(this);
            if(defaultInto && $this.attr('page-no')==defaultInto){
                navlink=$this.addClass('selected').children('a').eq(0);
            }
        });

        //没找到默认就打开自己内部第一个a
        if(!navlink){
            if(li.hasClass('grade-2')){
                navlink=li.find('.grade-3>a').eq(0).addClass('selected')
            }else{
                navlink=li.children('a').eq(0).addClass('selected');
            }
        }

        //一级,设置二级selected
        if(li.hasClass('grade-1')){
            ul=li.children('ul').eq(0);
            expandMenu.call(ul);
        }
        //二级,设置一级selected,
        else{
            ul=li.parent();
            ul.parents().addClass('selected');
            (ul.data('showed')!=1) && expandMenu.call(ul);

            ul3=li.children('ul');
            ul3.length && expandMenu.call(ul3);
        }

        src=navlink.attr('direct')||navlink.siblings('ul').find('li').eq(0).addClass('selected').find('a').eq(0).attr('direct');

        //与导航条联动
        (window.rootNav||$('#root-nav')) && (window.rootNav||$('#root-nav')).find('.nav-seconds a').each(function(){
            var $this=$(this);
            var direct=this.getAttribute('direct');
            if(direct){
                $this.removeClass('current');
            }
            if(direct==src){
                $this.addClass('current');
            }
        });
        selectHandle=selectHandle||function(){};
        //log(src)
        event.target.nodeName!=='B'&& src && selectHandle(src,this);
    }

    var hider=function($this,treeMenu,time){
        treeMenu.find('.tree-menu-accordion').fadeOut(time||100,function () {
            treeMenu.animate({width:1},time||200);
            //treeMenu.dequeue();
        });
        $this.html('<b class="fs16">▶</b>');
    };

    //低版本chrome下需要取消动画
    var shower=function($this,treeMenu,time){
        treeMenu.animate({width:170},time||200,function(){
            treeMenu.find('.tree-menu-accordion').fadeIn(time||100);
            //treeMenu.dequeue();
        });
        $this.html('◄');
    };

    var doToggle=function(parse){
        var $this=$(this);
        var lastTime=$this.data('clicked-time');
        if(lastTime && (lastTime+500>new Date().getTime())){
            return false;
        }
        var treeMenu=$this.parent();
        var collapsed=treeMenu.data('collapsed');
        collapsed ? shower($this,treeMenu) : hider($this,treeMenu);
        $this.data('clicked-time',new Date().getTime());
        treeMenu.data('collapsed',!collapsed);
        return true;
    };

    window.hideSlideMenu=function(time){top.rootTreeMenu.trigger('collapse',['hide',time]);}
    window.showSlideMenu=function(time){top.rootTreeMenu.trigger('collapse',['show',time]);}

    return function(data,selectHandle){
        var ul=$('<ul class="tree-menu-accordion" tpsource="#tree-menu-tp"></ul>');
        $template(ul,data);
        return reset(
            this.empty().append($('<p class="toggle-tag">◄</p>').click(doToggle)).append(ul)
                .find('li').click(function(eve){selectItem.apply(this,[eve,selectHandle]);}).end().on('collapse',function(eve,param,time){
                //提供给默认折叠侧菜单的控制,与hider和shower不同,不采用动画
                if(param==='hide'){
                    this.find('ul').hide().end().data('collapsed',true).find('.toggle-tag').html('<b class="fs16">▶</b>').end().animate({width:1},time||60);
                }else{
                    this.find('ul').show().end().data('collapsed',false).find('.toggle-tag').html('◄').end().animate({width:170},time||60);
                }
            })
        );
    }
})();