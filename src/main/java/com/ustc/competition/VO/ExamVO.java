package com.ustc.competition.VO;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author yihangZhou
 * @create 2019-02-16 14:10
 */
@Data
public class ExamVO {

    private String id;

    private String title;

    private List<Date> time;

    private String paperTitle;

    private String status;

}
