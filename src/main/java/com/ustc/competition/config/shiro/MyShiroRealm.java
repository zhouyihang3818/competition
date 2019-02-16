package com.ustc.competition.config.shiro;

import com.ustc.competition.VO.UserInfoVO;
import com.ustc.competition.dataobject.UserInfo;
import com.ustc.competition.service.UserInfoService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author yihangZhou
 * @create 2019-01-30 19:14
 */
@Slf4j
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private UserInfoService userInfoService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //        System.out.println("MyShiroRealm.doGetAuthenticationInfo()");
        //获取用户的输入的账号.
        UsernamePasswordToken token1 = (UsernamePasswordToken) token;
        String username = token1.getUsername();
        String password = new String(token1.getPassword());
        log.info("Yihang token username={}, password={}",username, password);
//        System.out.println(token.getCredentials());
        //通过username从数据库中查找 User对象，如果找到，没找到.
        //实际项目中，这里可以根据实际情况做缓存，如果不做，Shiro自己也是有时间间隔机制，2分钟内不会重复执行该方法
        UserInfo userInfo = userInfoService.findByUserName(username);
//        System.out.println("----->>userInfo="+userInfo);
        if (userInfo == null) {
            throw new AuthenticationException("该用户不存在");
        }
        log.info("Yihang flag1");
        /*if (userInfo.getState() == 1) { //账户冻结
            throw new LockedAccountException();
        }*/
        if((!username.equals(userInfo.getUserName())) || (!password.equals(userInfo.getPassword()))){
            throw new IncorrectCredentialsException("账号密码错误");
        }
        log.info("Yihang flag2");
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                userInfo, //用户名
                userInfo.getPassword(), //密码
//                ByteSource.Util.bytes(userInfo.getCredentialsSalt()),//salt=username+salt
                getName()  //realm name
        );
        log.info("Yihang flag3");
        return authenticationInfo;
    }
}
