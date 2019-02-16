package com.ustc.competition.service.impl;

import com.ustc.competition.VO.UserInfoVO;
import com.ustc.competition.dao.UserRoleMapper;
import com.ustc.competition.dataobject.UserInfo;
import com.ustc.competition.service.UserInfoService;
import com.ustc.competition.service.UserRoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yihangZhou
 * @create 2019-01-31 21:47
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<String> selectRolesByUserName(String userName) {

        List<String> userRoles = userRoleMapper.selectUserRole(userName);

        return userRoles;
    }
}
