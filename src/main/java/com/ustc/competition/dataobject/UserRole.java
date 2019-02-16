package com.ustc.competition.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 用户角色表
 * @author yihangZhou
 * @create 2019-01-29 21:42
 */
@Entity
@Data
public class UserRole {

    /** 用户角色管理id */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userRoleId;

    /** 用户id */
    private String userId;

    /** 角色id */
    private Integer roleId;

}
