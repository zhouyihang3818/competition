package com.ustc.competition.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 用户挑战表
 * @author yihangZhou
 * @create 2019-01-29 22:23
 */
@Entity
@Data
public class UserChallenge {

    @Id
    private String userChallengeId;

    /** 用户openid */
    private String userOpenid;

    /** 挑战id */
    private String challengeId;

    /** 挑战分数 */
    private Integer challengeScore;

    /** 挑战结果 */
    private Integer challengeOutcome;

}
