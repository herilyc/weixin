package com.cms.educationresources.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName user
 */
@TableName(value ="user")
@Data
public class User implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Integer age;

    /**
     * 
     */
    private String gender;

    /**
     * 
     */
    private String password;

    /**
     * 
     */
    private Integer isTeacher;

    /**
     * 
     */
    private String realname;

    /**
     * 
     */
    private String introduction;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}