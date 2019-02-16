package com.ustc.competition.service;

import com.ustc.competition.VO.UserInfoVO;
import com.ustc.competition.dataobject.RoleInfo;
import com.ustc.competition.dataobject.UserInfo;

import java.util.List;

/**
 * @author yihangZhou
 * @create 2019-01-29 17:07
 */
public interface UserInfoService {

    UserInfo findByUserName(String userName);


}
