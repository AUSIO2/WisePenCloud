package com.oriole.wisepen.user.api.domain.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class LoginBody implements Serializable {
    /** 用户名 */
    private String username;
    /** 密码 */
    private String password;
    /** 验证码 (预留) */
    private String code;
    /** 唯一标识 (预留，用于验证码校验) */
    private String uuid;
}