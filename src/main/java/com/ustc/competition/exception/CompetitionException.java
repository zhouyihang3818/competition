package com.ustc.competition.exception;

import com.ustc.competition.enums.ResultEnum;
import lombok.Getter;

/**
 * @author yihangZhou
 * @create 2019-01-31 21:25
 */
@Getter
public class CompetitionException extends RuntimeException {
    private Integer code;

    public CompetitionException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code=resultEnum.getCode();
    }

    public CompetitionException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
