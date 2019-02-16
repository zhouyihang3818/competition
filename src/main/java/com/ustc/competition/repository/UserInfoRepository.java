package com.ustc.competition.repository;

import com.ustc.competition.dataobject.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author yihangZhou
 * @create 2019-01-29 17:01
 */
public interface UserInfoRepository extends JpaRepository<UserInfo, String> {
    UserInfo findByUserName(String userName);
}
