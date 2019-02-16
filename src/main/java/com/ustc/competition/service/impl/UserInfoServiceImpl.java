package com.ustc.competition.service.impl;

import com.ustc.competition.VO.UserInfoVO;
import com.ustc.competition.dao.UserInfoMapper;
import com.ustc.competition.dao.UserRoleMapper;
import com.ustc.competition.dataobject.UserInfo;
import com.ustc.competition.enums.ResultEnum;
import com.ustc.competition.exception.CompetitionException;
import com.ustc.competition.repository.UserInfoRepository;
import com.ustc.competition.service.UserInfoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yihangZhou
 * @create 2019-01-29 17:11
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;



    @Override
    public UserInfo findByUserName(String userName) {
        UserInfo userInfo = userInfoMapper.selectByUserName(userName);
        if(userInfo == null) {
                throw new CompetitionException(ResultEnum.USER_NOT_EXIST);
        }
        return userInfo;
    }


}
