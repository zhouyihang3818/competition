package com.ustc.competition.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.google.gson.JsonObject;
import com.ustc.competition.VO.ResultVO;
import com.ustc.competition.VO.UserInfoVO;
import com.ustc.competition.dataobject.UserInfo;
import com.ustc.competition.service.UserRoleService;
import com.ustc.competition.utils.ResultVOUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yihangZhou
 * @create 2019-01-29 22:58
 */
@RequestMapping("/admin")
@RestController
@Slf4j
public class AdminLoginController {

    @Autowired
    private UserRoleService userRoleService;

    @PostMapping("/login")
    public ResultVO login(@RequestParam("username") String username,
                          @RequestParam("password") String password) {
        log.info("Yihang login start");
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        subject.login(token);

        Map<String, Serializable> map = new HashMap<>();
        map.put("token", subject.getSession().getId());
        return ResultVOUtil.success(map);

    }


    /**
     * 未登录，shiro应重定向到登录界面，此处返回未登录状态信息由前端控制跳转页面
     * @return
     */
    @RequestMapping(value = "/unauth")
    @ResponseBody
    public Object unauth() {
        Map<String, Object> map = new HashMap<>();
        map.put("code", "20001");
        map.put("msg", "未登录");
        return map;

    }

    @GetMapping("/info")
    public ResultVO info() {
        Subject subject = SecurityUtils.getSubject();
        UserInfo userInfo = (UserInfo)subject.getPrincipal();
        UserInfoVO userInfoVO = new UserInfoVO();
        List<String> userRoles = userRoleService.selectRolesByUserName(userInfo.getUserName());
        BeanUtils.copyProperties(userInfo, userInfoVO);
        userInfoVO.setRoles(userRoles);
        return ResultVOUtil.success(userInfoVO);
    }

    @PostMapping("/logout")
    public ResultVO logout() {

        SecurityUtils.getSubject().logout();
        return ResultVOUtil.success();

    }

}
