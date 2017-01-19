package com.hisign.mock;

/**
 * 服务测试例子
 * @author wangping
 * @version 1.0
 * @since 2016/8/4 9:17
 */
public class ServiceTest extends ServiceBaseTest {

   /* @InjectMocks
    private SysUserServiceImpl sysUserService;

    @Mock
    private SysUserMapper sysUserMapper;

    @Test
    public void testFindSysUserByUserName() throws Exception {
        when(sysUserMapper.findSysUserByUserName(anyString())).then(new Answer<SysUser>() {

            @Override
            public SysUser answer(InvocationOnMock invocationOnMock) throws Throwable {
                SysUser user = new SysUser();
                user.setUserName("sys");
                user.setCardId("11111111");
                return user;
            }
        });

        SysUser sysUser = sysUserService.findSysUserByUserName("sys");
        Assert.assertTrue("sys".equals(sysUser.getUserName()));
    }*/

}
