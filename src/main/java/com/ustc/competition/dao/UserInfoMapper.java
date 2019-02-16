package com.ustc.competition.dao;

import com.ustc.competition.dataobject.UserInfo;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @author yihangZhou
 * @create 2019-01-31 20:06
 */
@Repository
public interface UserInfoMapper {

    @Select("select * from user_info where user_name = #{userName}")
    @Results({
            @Result(column = "user_id", property = "userId"),
            @Result(column = "user_openid", property = "userOpenid"),
            @Result(column = "user_name", property = "userName"),
            @Result(column = "user_password", property = "userPassword"),
            @Result(column = "avatar", property = "avatar"),
            @Result(column = "last_login_time", property = "lastLoginTime")
    })
    UserInfo selectByUserName(String userName);
}
