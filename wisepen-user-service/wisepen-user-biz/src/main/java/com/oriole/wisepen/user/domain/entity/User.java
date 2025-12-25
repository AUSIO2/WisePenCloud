package com.oriole.wisepen.user.domain.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 核心用户账号实体
 */
@Data
@TableName("sys_user")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /** 主键ID (使用雪花算法生成) */
    @TableId(type = IdType.ASSIGN_ID)
    private Long id;

    /** 用户名 */
    private String username;

    /** 密码 (序列化时忽略，防止泄露) */
    private String password;

    /** 身份 1:学生 2:老师 3:管理员 */
    @TableField("identity_type")
    private Integer identityType;

    private String nickname;
    private String avatar;
    private String email;
    private String mobile;

    /** 状态 1:正常 -1:未验证身份 -2:系统封禁 */
    private Integer status;

    /** 逻辑删除 0:未删 1:已删 */
    @TableLogic
    @TableField("del_flag")
    private Integer delFlag;

    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(value = "update_time", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    /** 学工号（非数据库字段，用于登录查询时关联获取） */
    @TableField(exist = false)
    private String campusNo;
}