package com.ustc.competition.enums;

import lombok.Getter;

/**
 * @author yihangZhou
 * @create 2019-01-31 15:00
 */
@Getter
public enum ResultEnum {

    USER_NOT_EXIST(10, "用户不存在"),
    INSERT_FAIL(11,"插入失败"),
    QUESTION_NOT_EXIST(12,"该题目不存在"),
    UPDATE_FAIL(13,"更新失败"),
    PAPER_CREATE_FAIL(14,"试卷创建失败"),
    PAPER_NOT_EXIST(15,"该试卷不存在"),
    PAPER_MODIFY_FAIL(16,"试卷修改失败"),
    PAPER_DELETE_FAIL(17,"试卷删除失败"),
    EXAM_INSERT_FAIL(18,"考试插入失败"),
    PARAM_ERROR(19,"参数错误"),
    EXAM_NOT_EXIST(20,"该考试不存在"),
    EXAM_MODIFY_FAIL(21,"考试修改失败"),
    EXAM_DELETE_FAIL(22,"考试删除失败");


    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
