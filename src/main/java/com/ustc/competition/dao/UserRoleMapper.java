package com.ustc.competition.dao;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yihangZhou
 * @create 2019-01-31 20:22
 */
@Repository
public interface UserRoleMapper {

    @Select("select ri.role_name " +
            "from role_info as ri " +
            "inner join user_role as ur on ri.role_id = ur.role_id " +
            "inner join user_info as ui on ui.user_id = ur.user_id " +
            "where ui.user_name = #{userName};")
//    @Result(column = "role_name", property = "role")
    List<String> selectUserRole(String userName);
}
