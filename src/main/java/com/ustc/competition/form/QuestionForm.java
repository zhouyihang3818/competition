package com.ustc.competition.form;

import lombok.Data;

/**
 * 接收传进来的表单
 * @author yihangZhou
 * @create 2019-02-08 11:04
 */
@Data
public class QuestionForm {

    private String content;

    private String type;

    private String group;

    private Integer difficulty;

    private Integer page;

    private Integer limit;

}
