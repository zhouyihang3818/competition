package com.ustc.competition.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 错题表
 * @author yihangZhou
 * @create 2019-01-29 22:30
 */
@Entity
@Data
public class WrongQuestion {

    @Id
    private String wrongId;

    /** 用户openid */
    private String userOpenid;

    /** 题目id */
    private String questionId;

}
