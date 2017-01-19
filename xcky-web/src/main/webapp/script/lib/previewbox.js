/**
 * Created by EvanYao on 2016/9/21.
 */
var previewWrap;
window.$.fn.previewBox=function(orgSrcAttr,eveType,hasWrap){
    previewWrap||(previewWrap=$('<div class="preview-wrap"><img/><a class="icon-remove"></a></div>').appendTo('body'));
    var previewImg=previewWrap.children('img');
    this.each(function(){
        var $this=$(this);
        if($this.attr('preview-reged')){
            return false;
        }
        $this.attr('preview-reged',true).on(eveType||'click',function(){
            var $this=$(this);
            var i=$this.index();
            var prev=$(this.parentNode).prev().children('img')[0];
            var next=$(this.parentNode).next().children('img')[0];
            //console.log(prev),console.info(next);
            var keyHandle;
            var canceler=function(){
                window.hideMask();
                previewWrap.fadeOut(150);
                $('body').off('keyup',keyHandle);
            };
            window.showMask();
            //调整图片大小
            previewImg.attr('src',this.getAttribute(orgSrcAttr||'src')).on('load',function(){
                var ratio=this.naturalHeight/this.naturalWidth;
                (this.naturalWidth<window.width*0.5 ||  this.naturalHeight> window.height*0.5 )&& previewWrap.addClass('preview-s');
                if(this.naturalWidth>this.naturalHeight && window.height/window.width>ratio ){
                    $(this).css({width:'100%',height:'auto'});
                }else{
                    $(this).css({width:'auto',height:'100%'});
                }
            });
            //监听键盘事件
            $('body').on('keyup',(keyHandle=function(event){
                if(event.keyCode==37 && prev){
                    previewImg.attr('src',prev.getAttribute(orgSrcAttr||'src'));//可以把大图地址记录在自定义属性上
                    if(prev){
                        next=$(prev.parentNode).next().children('img')[0];
                        prev=$(prev.parentNode).prev().children('img')[0];
                    }
                } else if(event.keyCode==39 && next){
                    previewImg.attr('src',next.getAttribute(orgSrcAttr||'src'));
                    if(next) {
                        prev=$(next.parentNode).prev().children('img')[0];
                        next=$(next.parentNode).next().children('img')[0];
                    }
                } else if(event.keyCode==13 || event.keyCode==27){
                    canceler();
                }
            }));
            //显示并注册关闭事件
            previewWrap.show().css({display:'flex'}).click(canceler);
        });
    });

};