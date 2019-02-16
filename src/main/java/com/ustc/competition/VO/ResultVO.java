package com.ustc.competition.VO;

import lombok.Data;

/**
 * http请求的最外层对象
 * @author yihangZhou
 * @create 2019-01-30 17:27
 */

@Data
public class ResultVO<T> {


    /** 错误码 */
    private Integer code;

    /** 提示信息 */
    private String message;

    /** 具体内容 */
    private T data;
}
