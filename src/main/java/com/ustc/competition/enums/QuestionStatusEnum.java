package com.ustc.competition.enums;

import lombok.Getter;

/**
 * @author yihangZhou
 * @create 2019-02-01 20:58
 */
@Getter
public enum QuestionStatusEnum implements CodeEnum {

    DRAFT(0,"未使用"),
    PUBLISHED(1,"已使用");

    private Integer code;
    private String message;

    QuestionStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
