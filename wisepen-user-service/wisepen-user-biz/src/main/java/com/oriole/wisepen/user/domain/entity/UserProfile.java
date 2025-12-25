package com.oriole.wisepen.user.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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

    @TableField("campus_no")
    private String campusNo;

    @TableField("sex")
    private Integer sex;

    private String university;
    private String college;

    private String major;

    @TableField("class_name")
    private String className;

    @TableField("enrollment_year")
    private Integer enrollmentYear;

    @TableField("degree_level")
    private Integer degreeLevel;

    @TableField("academic_title")
    private String academicTitle;
}