package com.ustc.competition.VO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

/**
 * @author yihangZhou
 * @create 2019-01-31 21:12
 */
@Data
public class UserInfoVO {

    /** 用户头像 */
    @JsonProperty("avatar")
    private String avatar;

    /** 用户姓名 */
    @JsonProperty("name")
    private String userName;

    /** 用户的权限 */
    @JsonProperty("roles")
    private List<String> roles;
}
