package com.oriole.wisepen.user.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.oriole.wisepen.user.api.enums.DegreeLevel;
import com.oriole.wisepen.user.api.enums.GenderType;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 用户详细档案实体
 */
@Data
@TableName("sys_user_profile")
public class UserProfile implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @TableId(type = IdType.INPUT)
    private Long userId;

    private String realName;
    private String campusNo;

    private GenderType sex;

    private String university;
    private String college;

    private String major;
    private String className;
    private Integer enrollmentYear;
    private DegreeLevel degreeLevel;

    private String academicTitle;
}