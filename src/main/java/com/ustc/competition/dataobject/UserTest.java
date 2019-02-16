package com.ustc.competition.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 用户考试表
 * @author yihangZhou
 * @create 2019-01-29 22:28
 */
@Entity
@Data
public class UserTest {

    @Id
    private String userTestId;

    /** 用户openid */
    private String userOpenid;

    /** 考试id */
    private String testId;

    /** 考试分数 */
    private Integer testScore;

}
