package com.ustc.competition.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * 用户表
 * @author yihangZhou
 * @create 2019-01-29 16:51
 */
@Entity
@Data
public class UserInfo {

    /** 用户id */
    @Id
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

    public Object getCredentialsSalt() {
        return password;
    }
}
