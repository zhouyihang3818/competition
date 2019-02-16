package com.ustc.competition.service.impl;

import com.ustc.competition.VO.UserInfoVO;
import com.ustc.competition.service.UserRoleService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author yihangZhou
 * @create 2019-01-31 21:54
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserRoleServiceImplTest {

    @Autowired
    private UserRoleService userRoleService;

    @Test
    public void selectRolesByUserName() {

        List<String> result = userRoleService.selectRolesByUserName("zyh");
        Assert.assertNotEquals(result.size(),0);
    }
}
