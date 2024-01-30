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
    @TableId
    private String id;

    /**
     * 
     */
    private String nickname;

    /**
     * 
     */
    private String gender;

    /**
     * 
     */
    private Integer isteacher;

    /**
     * 
     */
    private String realname;

    /**
     * 
     */
    private String introduction;

    /**
     * 
     */
    private String avatarurl;

    /**
     * 
     */
    private String password;

    @TableField(select = false,exist = false)
    private String code;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}