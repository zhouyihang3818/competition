package com.ustc.competition.service;

import com.ustc.competition.VO.UserInfoVO;

import java.util.List;

/**
 * @author yihangZhou
 * @create 2019-01-31 21:34
 */
public interface UserRoleService {

    List<String> selectRolesByUserName(String userName);

}
