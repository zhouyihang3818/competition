package com.ustc.competition.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * 考试表
 * @author yihangZhou
 * @create 2019-01-29 22:15
 */
@Entity
@Data
public class TestMaster {

    /** 考试id */
    @Id
    private String testId;

    /** 考试开始时间 */
    private Date startTime;

    /** 考试结束时间 */
    private Date endTime;

    /** 考试标题 */
    private String title;

    /** 试卷id */
    private String paperId;

    /** 考试状态 */
    private String status;

}
