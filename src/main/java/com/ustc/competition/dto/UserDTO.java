package com.ustc.competition.dto;

import com.ustc.competition.dataobject.RoleInfo;
import lombok.Data;

import javax.persistence.Id;
import java.util.Date;
import java.util.List;

/**
 * @author yihangZhou
 * @create 2019-01-30 18:55
 */
@Data
public class UserDTO {

    /** 用户id */
    private String userId;

    /** 用户的openid */
    private String userOpenid;

    /** 用户姓名 */
    private String userName;

    /** 用户密码 */
    private String password;

    /** 用户头像 */
    private String avatar;

    /** 最近登陆时间 */
    private Date lastLoginTime;

    /** 用户权限 */
    private List<RoleInfo> roles;

}
