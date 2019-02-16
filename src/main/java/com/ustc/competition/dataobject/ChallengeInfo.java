package com.ustc.competition.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * 挑战表
 * @author yihangZhou
 * @create 2019-01-29 21:52
 */
@Entity
@Data
public class ChallengeInfo {

    /** 挑战id */
    @Id
    private String challengeId;

    /** 挑战时间 */
    private Date challengeTime;

    /** 题目专题 */
    private String questionGroup;

}
