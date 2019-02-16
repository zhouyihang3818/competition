package com.ustc.competition.service.impl;

import com.ustc.competition.VO.UserInfoVO;
import com.ustc.competition.dataobject.UserInfo;
import com.ustc.competition.service.UserInfoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author yihangZhou
 * @create 2019-01-31 21:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoServiceImplTest {

    @Autowired
    private UserInfoService userInfoService;

    @Test
    public void findByUserName() {

        UserInfo result = userInfoService.findByUserName("zyh");
        Assert.assertNotNull(result);
    }
}
