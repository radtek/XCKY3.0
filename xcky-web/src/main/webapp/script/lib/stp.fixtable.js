/**
 * Created by yao on 2016/11/15.
 */
window.$.fn.fixTable=function fixTable(mode,cb){//,wraped,cb){
    var nativeTable=this;
    if(nativeTable.hasClass('no-need-fix')){
        return nativeTable;
    }else if(nativeTable.hasClass('no-fix-head')){
        if(mode=='all')
        mode=='all' && (mode='col');
    }else if(nativeTable.hasClass('no-fix-col')){
        mode=='all' && (mode='head')
    }
    nativeTable.closest('.query-result').addClass('changing');
    setTimeout(function(){
        //先去除原来的包裹
        nativeTable.closest('.all-fix-wrap').replaceWith(nativeTable);

        var nativeTableWidth=getRect(nativeTable[0]).width;
        var nativeTableHeight=getRect(nativeTable[0]).height;
        var nativeTableParentWidth=getRect(nativeTable.parent()[0]).width;
        var nativeTableParentHeight=getRect(nativeTable.parent()[0]).height;

        var widthOverflow=nativeTableWidth>nativeTableParentWidth;
        var heightOverflow=nativeTableHeight>nativeTableParentHeight;

        var needFixCol=nativeTable.children('thead').find('th.need-fix').length>0 //&& widthOverflow;
        var needFixColEnd=nativeTable.children('thead').find('th.need-fix-end').length>0 //&& widthOverflow;
        var needFixHead=nativeTable.children('thead.need-fix').length>0;

        var wrapHeight=nativeTable.attr('wrap-height');
        var isMultipleHead=nativeTable.children('thead').children('tr').length>1;
        var rootWrap, nativeWrap, theCopyForCol,theCopyForHead,theCopyForColEnd;

        if(!nativeTable[0] || nativeTable.hasClass('no-need-fix') || (mode=='all'&&!(needFixCol||needFixHead||needFixColEnd)) || (mode=='col'&&!needFixCol&&!needFixColEnd) || (mode=='head'&&!needFixHead) ){
            nativeTable.closest('.query-result').children(':not(.new-color-bar)').add(nativeTable).css('visibility','visible');
            nativeTable.closest('.query-result').children('.all-fix-wrap').find('.head-fix-wrap>table, table.cross-fix-cols-head, .col-fix-wrap>table').css('visibility','visible');
            return nativeTable;
        }

        //console.log([ getRect(nativeTable[0]).width,getRect(nativeTable.parent()[0]).width,getRect(nativeTable[0]).height,getRect(nativeTable.parent()[0]).height,hasScroll(nativeTable.parent()[0],'y')]);
        if(!widthOverflow){
            if(mode=='col'){
                nativeTable.closest('.query-result').removeClass('changing');
                return nativeTable;
            }
            mode=='all'&& (mode='head');
        }else{
            mode=='head'&& (mode='all');
        }
        //判断是否超出容器最大高度
        //var winHeight=nativeTable.closest('.window').length ? wrapHeight:window.innerHeight;
        //if(parseInt(wrapHeight) &&  nativeTableHeight<winHeight-120){//(!hasScroll(nativeTable.parent()[0],'y')){ // !heightOverflow){
        //    if(mode=='head'){
        //          nativeTable.closest('.query-result').removeClass('changing');
        //          return nativeTable;
        //    }
        //    mode=='all' && (mode='col');
        //}


        nativeTable.wrap('<div class="native-fix-wrap">').parent().wrap('<div class="all-fix-wrap">');

        rootWrap=nativeTable.closest('.all-fix-wrap');
        nativeWrap=nativeTable.closest('.native-fix-wrap');

        !isMultipleHead && nativeTable.children('thead').find('th').each(function(i,th) {
            nativeTable.children('tbody').children('tr').each(function (j,tr) {
                //$(tr).children('td.hide,td.stp-hide,td.hideplus,td.hide-plus,td.hidePlus').remove();
                var $td=$(tr).children('td').eq(i);
                $(th).hasClass('need-fix') && $td.addClass('need-fix');
                $(th).hasClass('need-fix-end') && $td.addClass('need-fix-end');
            });
        });

        nativeTable.on('refitFix',function(){
            theCopyForCol && theCopyForCol.add(theCopyForColEnd).children('tbody').children('tr').each(function(i,ele) {
                $(this).children('td').height(0);
                var proto=nativeTable.children('tbody').children('tr').eq(i);
                proto[0] && $(this).height(getComputedStyle(proto[0]).height);
            });
            theCopyForColEnd && theCopyForColEnd.children('tbody').children('tr').each(function(i,ele) {
                //同上,先把内部height置空避免tr设置高度无效, 然后直接设置tr的高度就可以了, 不一一再循环设置td的高度了
                $(this).children('td').height(0);
                var proto=nativeTable.children('tbody').children('tr').eq(i);
                proto[0] && $(this).height(getComputedStyle(proto[0]).height);
            });
        });

         $(window).resize(function(){
             setTimeout(function(){
                 nativeTable.trigger('refitFix');
             },120);
         });

        //fix-col
        if( (mode=='col' || mode=='all') && needFixCol){
            theCopyForCol=$(nativeTable.clone(true)).width('auto');
            theCopyForCol[0].id='';
            theCopyForCol.children('thead,tbody').each(function(){
                this.id='';
            });
            theCopyForCol.children('thead,tbody').children('tr').each(function(i,ele) {
                var proto=nativeTable.children('thead,tbody').children('tr').eq(i);
                $(this).children('th,td').each(function(k){
                    var $this=$(this);
                    if($this.hasClass('need-fix')){// && proto.nextElementSibling){
                        var protoCell=proto.children('th,td').eq(k);
                        $this.width(getComputedStyle(protoCell[0]).width);
                        $this.height(getComputedStyle(protoCell[0]).height);
                        proto.hover(function(){
                            $this.addClass('hover-like');
                        },function(){
                            $this.removeClass('hover-like');
                        });
                        $this.hover(
                            function(){
                                rootWrap.children('.col-end-fix-wrap>table>tbody>tr').eq(i).add(proto).addClass('hover-like');
                            },function(){
                                rootWrap.children('.col-end-fix-wrap>table>tbody>tr').eq(i).add(proto).removeClass('hover-like');
                            }
                        );
                    }else{
                        $this.remove();
                    }
                });
            });
            theCopyForCol.wrap('<div class="col-fix-wrap">');//.format(nativeWrap.clientHeight))
            theCopyForCol.parent().appendTo(rootWrap);
        }

        //fix-col-end
        if( (mode=='col' || mode=='all') && needFixColEnd){
            theCopyForColEnd=$(nativeTable.clone(true)).width('auto');
            theCopyForColEnd[0].id='';
            theCopyForColEnd.children('thead,tbody').each(function(){
                this.id='';
            });
            theCopyForColEnd.children('thead,tbody').children('tr').each(function(i,ele) {
                var proto=nativeTable.children('thead,tbody').children('tr').eq(i);
                $(this).children('th,td').each(function(k){
                    var $this=$(this);
                    if( $this.hasClass('need-fix-end')){//|| proto.is('.need-fix:last-child') ){
                        var protoCell=proto.children('th,td').eq(k);
                        $this.width(getComputedStyle(protoCell[0]).width);
                        $this.height(getComputedStyle(protoCell[0]).height);
                        proto.hover(function(){
                            $this.addClass('hover-like');
                        },function(){
                            $this.removeClass('hover-like');
                        });
                        $this.hover(
                            function(){
                                rootWrap.children('.col-fix-wrap>table>tbody>tr').eq(i).add(proto).addClass('hover-like');
                            },function(){
                                rootWrap.children('.col-fix-wrap>table>tbody>tr').eq(i).add(proto).removeClass('hover-like');
                            }
                        );
                    }else{
                        $this.remove();
                    }
                });
            });
            theCopyForColEnd.wrap('<div class="col-end-fix-wrap">');//.format(nativeWrap.clientHeight))
            theCopyForColEnd.parent().appendTo(rootWrap);
        }

        //fix-head
        if( (mode=='head' || mode=='all') && needFixHead){
            theCopyForHead=$(nativeTable.clone(true)).width('auto');
            //nativeTable.children('thead').children('tr').children('th').children('.custom-col-wrap').html(function(i,old){return backUpWrapBegin + old + backUpWrapEnd;});
            //指定表格区高度以便出现纵向滚动条
            //var ct=rootWrap.parent().parent();
            //var underModal= ct[0]!=document.body;
            if(isNaN(wrapHeight)){
                //wrapHeight= underModal ? getRect(ct.closest('.panel.window')[0]).height-40 :
                wrapHeight= window.innerHeight  - getRect(nativeTable[0]).top-parseInt(getComputedStyle(document.body).paddingBottom)- parseInt(getComputedStyle(rootWrap.parent()[0]||rootWrap[0]).marginBottom)- (rootWrap.next().length?getRect(rootWrap.next()[0]).height:0)-3;
            }
            wrapHeight=wrapHeight>300?wrapHeight:(window.height-100);
            nativeWrap.css({'max-height':+wrapHeight,'min-height':20});
            //固定列表格的高度是否遮盖下方的水平滚动条?
            rootWrap.children('.col-fix-wrap,.col-end-fix-wrap').height(nativeWrap[0].clientHeight);
            //rootWrap.children('.col-fix-wrap,.col-end-fix-wrap').height('100%');
            theCopyForHead[0].id='';
            theCopyForHead.children('thead,tbody').each(function(){
                this.id='';
            });
            theCopyForHead.children(':not(thead)').remove();
            theCopyForHead.children('thead').children('tr').each(function(i) {
                var proto=nativeTable.children('thead').children('tr').eq(i);
                $(this).children('th').each(function(k){
                    var $this=$(this);
                    var protoCell=proto.children('th,td').eq(k);
                    var computedStyle=getComputedStyle(protoCell[0]);
                    $this.width(computedStyle.width);
                    $this.height(computedStyle.height);
                });
            });

            if(needFixCol){
                var fixColsHead=theCopyForHead.clone(true).addClass('cross-fix-cols-head');
                fixColsHead[0].id='';
                //fixColsHead.children('thead').children('tr').children('th:not(.need-fix),th:last-child').remove();
                fixColsHead.children('thead').children('tr').children('th:not(.need-fix)').remove();
                fixColsHead.appendTo(rootWrap);
            }

            if(needFixColEnd) {
                var fixColsHeadEnd = theCopyForHead.clone(true).addClass('cross-fix-cols-head-end');
                fixColsHeadEnd[0].id = '';
                //fixColsHeadEnd.children('thead').children('tr').children('th:not(.need-fix:last-child,.need-fix-end)').remove();
                fixColsHeadEnd.children('thead').children('tr').children('th:not(.need-fix-end)').remove();

                var scrollbarWidth = nativeWrap[0].offsetWidth - nativeWrap[0].clientWidth;
                //fixColsHeadEnd.find('th').length > 0 && fixColsHeadEnd.find('th:last-child').width(function (i, old) {
                //    return old + scrollbarWidth
                //}).end().appendTo(rootWrap);
                //theCopyForColEnd && theCopyForColEnd.parent().css({zIndex: 1, right: scrollbarWidth});

                //为了防止滚动条被右上固定格子挡住
                fixColsHeadEnd.appendTo(rootWrap);
                theCopyForColEnd && theCopyForColEnd.parent().css({zIndex: 1, right: scrollbarWidth});
                fixColsHeadEnd.css({zIndex: 1, right: scrollbarWidth});
            }


            //TODO scrollWidth
            var scrollWidth=window.hasScroll(nativeWrap[0],'y');
            //var scrollHeight=hasScroll(nativeWrap[0],'x');//console.log([scrollWidth,scrollHeight]);
            var rootWrapWidth=getComputedStyle(rootWrap[0]).width;


            theCopyForHead.width(getComputedStyle(nativeTable[0]).width).wrap('<div class="head-fix-wrap">');


            //为了防止滚动条被右上固定格子挡住, headCopyWrap限制为比nativeWrap小一个滚动条的宽度, 记得取消min-width:100%
            //needFixColEnd &&
            // if(mode=='head'){
            //     // theCopyForHead.parent().css({
            //     //     width:'100%',
            //     //     paddingRight:scrollWidth,
            //     // }).appendTo(rootWrap);
            //     // theCopyForHead.width('100%');
            //     theCopyForHead.parent().appendTo(rootWrap).css('paddingRight','5');
            // }
            // else{
                theCopyForHead.parent().css({
                    width:nativeWrap.width()-scrollbarWidth,
                    //marginRight,scrollWidth,
                    paddingRight:scrollWidth,
                    minWidth:'auto',//不支持auto的浏览器,写一个100px来废掉原有的100%即可
                    background:'transparent'
                }).appendTo(rootWrap);
            // }



            //nativeTable的td居然会在computedStyle计算完成后, 再次自动扩展大小, 见于列少屏幕大的情况. 因此这种情况下, 重新拷贝
            //原单元格自动扩展, 导致computedStyle.width不准, 引起theCopyForHead宽度不适配
            var theCopyForHeadWidth=parseInt(getComputedStyle(theCopyForHead[0]).width);
            var nativeTableWidth=parseInt(getComputedStyle(nativeTable[0]).width);

            //logEx([theCopyForHeadWidth,nativeTableWidth,nativeTable[0].id])

            //先算下复制表头是否宽度准确
            //theCopyForHeadWidth=theCopyForHeadWidth-scrollWidth;
            var gap=nativeTableWidth-theCopyForHeadWidth;


            //todo 在添加padding前就判断最好,可避免先加又减,目前这样比较保险
            //固定头,出现纵向滚动条,  同时固定列又未出现横向滚动条时, headCopy为了让出右上角滚动遮挡损失了scrollWidth宽度, paddingRight需要去除, headcopy使用原型表头就可以了
            gap>0 && gap==scrollWidth && theCopyForHead.parent().css({paddingRight:0});
            //如复制的固定表头宽度不准,放弃,直接使用新的thead clone
            //if(Math.abs(gap)>2){
            //    log('need replace clone-head again  scrollWidth:{0}, gap:{1}, table:{2}'.format(scrollWidth,gap,nativeTable[0].id));
            //    //见于列少屏幕大的情况.
            //    theCopyForHead.parent().css({paddingRight:0});//theCopyForHead.parent().css({minWidth:'100%'});
            //    //theCopyForHead.css({width:'100%',margin:'0'});
            //    //theCopyForHead.children('thead').replaceWith(nativeTable.children('thead').clone());
            //}

            var firstWidth=getRect(theCopyForHead.find('th')[0]).width;
            var firstWidth2=getRect(nativeTable.children('thead').find('th')[0]).width;
            if(Math.abs(firstWidth-firstWidth2)){
                console.info([firstWidth,firstWidth2]);
                var thead=$('.native-fix-wrap>table>thead'),thead2=$('.head-fix-wrap>table>thead'); thead2.replaceWith(thead.clone());
                //$('.cross-fix-cols-head,.cross-fix-cols-head-end').remove();
            }
        }


        var fixCols=$(theCopyForCol).add(theCopyForColEnd);
        var rootHeight = rootWrap ? rootWrap.height():'';

        mode=='head' && theCopyForHead && nativeWrap.scroll(function(){
            theCopyForHead.css('right',this.scrollLeft);
        }) &&  $(fixColsHead).add(fixColsHeadEnd).remove();

        mode=='col' && fixCols.length && nativeWrap.scroll(function(){
            fixCols.css('bottom',this.scrollTop);
        });

        mode=='all' &&  (theCopyForHead||fixCols.length) && nativeWrap.scroll(function(){
            theCopyForHead && theCopyForHead.css('right',this.scrollLeft);
            fixCols.length && fixCols.css('bottom',this.scrollTop);
        });
        nativeTable.children('tbody').children().length || rootWrap.height(rootHeight+1);
        //return nativeTable;


        nativeTable.attr('fixed-mode',mode);


        //注册resize时,检测固定的th是否与td宽度一致
        if(mode && !nativeTable[0].hasAttribute('resize-reg')){
            $(window).resize(function() {
                var exeReFixTbTime=+nativeTable.attr('resize-reg');
                var now=new Date().getTime();

                //是否全局刚刚禁止触发reFix-table
                var gitv=now-window._cancelGlobalReFixTbTime||(now-9);
                //info(['window._cancelGlobalReFixTbTime '+window._cancelGlobalReFixTbTime, gitv])
                if(gitv<300 ||gitv==9){
                    log('global resize-reg cancel before ....')//{0}ms'.format(gitv))
                    return false;
                }

                exeReFixTbTime=exeReFixTbTime||now-9;
                var itv=now-exeReFixTbTime;
                if(itv>300 || itv==9){
                    var wrap=nativeTable.closest('.query-result');
                    var tds=nativeTable.find('>tbody>tr:first>td');
                    var need=false;

                    //setTimeout(function(){
                        //检测,判断是否需要重走fixTable,有些情况下table自适应
                        wrap.find('>.all-fix-wrap>.head-fix-wrap>table>thead').children('tr').each(function(){
                            var $this=$(this);
                            var ths=$this.children('th');
                            if(ths.length!=tds.length){
                                return false;
                            }else{
                                ths.each(function(i,th){
                                    if(need){
                                        return false;
                                    }
                                    //log([getRect(th).width,getRect(tds[i]).width])
                                    var width=getRect(th).width;
                                    var widthProp=getRect(tds[i]).width;
                                    // log([width,widthProp,width-widthProp]);
                                    // setTimeout(function(){
                                    //     (widthProp-getRect(tds[i]).width) && info([widthProp,getRect(tds[i]).width])
                                    // },1500);
                                    if(Math.abs(parseFloat(width-widthProp))){
                                        //info([getRect(th).width,getRect(tds[i]).width],Math.abs(parseFloat(getRect(th).width-getRect(tds[i]).width)))
                                        need=true;
                                    }
                                });
                            }
                        });

                        if(need){
                            wrap.animate({opacity:0},60);
                            nativeTable.attr('resize-reg',new Date().getTime());
                            //注意,每次进行可能引发resize的操作,而该操作本身会触发template或fixTable,或其他不需要触发下面语句的时候
                            //要执行上面那句,时间戳赋值,以避免短时间内触发多次
                            setTimeout(function(){
                                nativeTable.fixTable(nativeTable.attr('fixed-mode'),function(){
                                    setTimeout(function(){
                                        wrap.animate({opacity:1},80);
                                    },90);
                                });
                            },90);
                            info('window resize before {0}ms, {1}'.format(itv,' reFixed table:{0}'.format(nativeTable.prop('id'))));
                        }
                        else{
                            //log('window resize before {0}ms, {1}'.format(itv,' no needReFixed table:{0}'.format(nativeTable.prop('id'))));
                        }


                    //},50)

                }else{
                    log('just resize...')
                }
            });
        }
        nativeTable.attr('resize-reg','');

        nativeTable.closest('.query-result').removeClass('changing');
        typeof cb=='function' && cb(rootWrap);
    },50);

    return nativeTable;
};

//typeof module === "object" && typeof module.exports === "object"  && (module.exports=);
