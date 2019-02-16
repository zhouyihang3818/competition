package com.ustc.competition.exception;

import com.ustc.competition.VO.ResultVO;
import com.ustc.competition.utils.ResultVOUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;

/**
 * @author yihangZhou
 * @create 2019-01-31 15:51
 */
@RestControllerAdvice
public class GlobalExceptionHandler  {

    private static Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @Autowired
    private MappingJackson2HttpMessageConverter jsonConverter;

//    @ExceptionHandler(value = AuthenticationException.class)
//    public Object AuthenticationExceptionHandler(HttpServletResponse response, Exception e) throws Exception {
//        logger.error(e.getMessage());
//        jsonConverter.write(ResultVOUtil.error(800, e.getMessage()), MediaType.APPLICATION_JSON, new ServletServerHttpResponse(response));
//        return null;
//    }

}
