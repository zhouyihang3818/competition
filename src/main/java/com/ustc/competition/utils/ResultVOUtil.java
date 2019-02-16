package com.ustc.competition.utils;

import com.ustc.competition.VO.ResultVO;

/**
 * 返回给前端的数据格式
 * @author yihangZhou
 * @create 2019-01-30 17:28
 */

public class ResultVOUtil {

    public static ResultVO success(Object object){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(20000);
        resultVO.setMessage("成功");
        resultVO.setData(object);
        return resultVO;
    }

    public static ResultVO success(){
        return success(null);
    }

    public static ResultVO error(Integer code,String msg){
        ResultVO resultVO=new ResultVO();
        resultVO.setCode(code);
        resultVO.setMessage(msg);
        return resultVO;
    }

}
