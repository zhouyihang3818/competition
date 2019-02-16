package com.ustc.competition.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author yihangZhou
 * @create 2019-02-11 14:56
 */
@Data
public class PaperInfoVO {

    @JsonProperty("id")
    private Integer paperId;

    /** 试卷标题 */
    @JsonProperty("title")
    private String title;

    /** 试卷描述 */
    @JsonProperty("description")
    private String description;

    /** 试卷状态 */
    @JsonProperty("status")
    private String status;

    /** 试卷难度 */
    @JsonProperty("difficulty")
    private Integer difficulty;

    /** 该试卷的所有题号 */
    @JsonProperty("list")
    private List<String> questionIds;

}
