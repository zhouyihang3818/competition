package com.ustc.competition.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 收藏表
 * @author yihangZhou
 * @create 2019-01-29 21:54
 */
@Entity
@Data
public class CollectQuestion {

    /** 收藏题目id */
    @Id
    private String collectId;

    /** 用户openid */
    private String userOpenid;

    /** 题目id */
    private String questionId;

}
