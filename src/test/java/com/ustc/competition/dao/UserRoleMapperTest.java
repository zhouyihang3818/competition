package com.ustc.competition.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author yihangZhou
 * @create 2019-01-31 20:56
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRoleMapperTest {

    @Autowired
    private UserRoleMapper mapper;

    @Test
    public void selectUserRole() {

        List<String> result = mapper.selectUserRole("zyh");
    }
}
