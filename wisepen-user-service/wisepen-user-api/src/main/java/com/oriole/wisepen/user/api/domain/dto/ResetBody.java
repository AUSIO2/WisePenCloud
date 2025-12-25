package com.oriole.wisepen.user.api.domain.dto;

import com.oriole.wisepen.user.api.validation.CampusNo;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.io.Serializable;

@Data
public class ResetBody implements Serializable {
    /** 学工号*/
    @NotBlank(message = "学工号不能为空")
    @CampusNo
    private String campusNum;
    /** 密码 */
    private String password;
    /** 验证码 (预留) */
    private String code;
    /** 唯一标识 (预留，用于验证码校验) */
    private String uuid;
}