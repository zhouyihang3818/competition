package com.ustc.competition.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 考试题表
 * @author yihangZhou
 * @create 2019-01-29 22:19
 */
@Entity
@Data
public class PaperQuestion {

    /** 试卷题表id */
    @Id
    private String paperQuestionId;

    /** 试卷id */
    private String paperId;

    /** 题目id */
    private String questionId;

}
