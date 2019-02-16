package com.ustc.competition.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author yihangZhou
 * @create 2019-01-29 22:08
 */
@Entity
@Data
public class FinishedQuestion {

    /** 已做题目id */
    @Id
    private String finishedId;

    /** 用户openid */
    private String userOpenid;

    /** 题目id */
    private String questionId;

}
