package com.ustc.competition.dao;

import com.ustc.competition.dataobject.UserInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @author yihangZhou
 * @create 2019-01-31 20:14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserInfoMapperTest {

    @Autowired
    private UserInfoMapper mapper;

    @Test
    public void selectByUserName() {
        UserInfo result = mapper.selectByUserName("zyh");
        Assert.assertEquals("123456", result.getPassword());
    }
}
