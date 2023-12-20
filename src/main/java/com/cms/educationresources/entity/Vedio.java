package com.cms.educationresources.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

/**
 * 
 * @TableName vedio
 */
@TableName(value ="vedio")
@Data
public class Vedio implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String category;

    /**
     * 
     */
    private String teacher;

    /**
     * 
     */
    private String book;

    /**
     * 
     */
    @JsonSerialize(using = DateTimeSerializer.class)
    private Date time;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}