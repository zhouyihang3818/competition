package com.ustc.competition.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author yihangZhou
 * @create 2019-02-11 12:05
 */
@Entity
@Data
public class PaperInfo {

    /** 试卷编号 */
    @Id
    private String paperId;

    /** 试卷标题 */
    private String title;

    /** 试卷描述 */
    private String description;

    /** 试卷状态 */
    private String status;

    /** 试卷难度 */
    private Integer difficulty;

}
