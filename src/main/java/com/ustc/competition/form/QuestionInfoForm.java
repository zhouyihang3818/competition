package com.ustc.competition.form;

import com.ustc.competition.enums.QuestionStatusEnum;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * @author yihangZhou
 * @create 2019-02-09 21:54
 */
@Data
public class QuestionInfoForm {

    private String id;

    /** 题目内容 */
    private String content;

    /** 题目类型 */
    private String type;

    /** 题目专题 */
    private String group;

    /** 题目难度 */
    private Integer difficulty;

    /** 题目状态 */
    private Integer status = QuestionStatusEnum.DRAFT.getCode();

    /** 选项A */
    private String a;

    private String b;

    private String c;

    private String d;

    /** 题目答案 */
    private String answer;
}
