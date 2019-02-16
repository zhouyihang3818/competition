package com.ustc.competition.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.ustc.competition.dataobject.QuestionInfo;
import lombok.Data;

import java.util.List;

/**
 * @author yihangZhou
 * @create 2019-02-01 21:05
 */
@Data
public class QuestionVO {

    /** 题目总数 */
    @JsonProperty("total")
    private Integer total;

    /** 题目数组 */
    @JsonProperty("items")
    private List<QuestionInfo> items;
}
