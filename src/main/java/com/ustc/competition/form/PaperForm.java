package com.ustc.competition.form;

import lombok.Data;

import javax.persistence.Id;
import java.util.List;

/**
 * @author yihangZhou
 * @create 2019-02-13 11:14
 */
@Data
public class PaperForm {

    /** 试卷编号 */
    private String id;

    /** 试卷标题 */
    private String title;

    /** 试卷描述 */
    private String description;

    /** 试卷难度 */
    private Integer difficulty;

    /** 试卷状态 */
    private String status;

    /** 试卷题目编号 */
    private List<String> list;

}
