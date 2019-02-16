package com.ustc.competition.dataobject;

import com.ustc.competition.enums.QuestionStatusEnum;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 题库表
 * @author yihangZhou
 * @create 2019-01-28 20:14
 */
@Entity
@Data
public class QuestionInfo {

    @Id
    private String questionId;

    /** 题目内容 */
    private String questionContent;

    /** 题目类型 */
    private String questionType;

    /** 题目专题 */
    private String questionGroup;

    /** 题目难度 */
    private Integer questionDifficulty;

    /** 题目状态 */
    private Integer questionStatus = QuestionStatusEnum.DRAFT.getCode();

    /** 选项A */
    @Column(name = "question_select_a")
    private String questionSelectA;

    @Column(name = "question_select_b")
    private String questionSelectB;

    @Column(name = "question_select_c")
    private String questionSelectC;

    @Column(name = "question_select_d")
    private String questionSelectD;

    /** 题目答案 */
    private String questionAnswer;


}
