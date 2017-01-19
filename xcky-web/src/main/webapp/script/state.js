/**
 * Created by yao on 2017/1/17.
 */
$state.on('test01',{
    importing:['sys.js'],
    init:function(scope){
        sysLoginLogFn();
    }
});