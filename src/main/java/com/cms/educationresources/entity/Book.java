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
 * @TableName book
 */
@TableName(value ="book")
@Data
public class Book implements Serializable {
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
    private String author;

    /**
     * 
     */
    private String discription;

    /**
     * 
     */
    private String coverurl;

    /**
     * 
     */
    @JsonSerialize(using = DateTimeSerializer.class)
    private Date time;

    /**
     * 
     */
    private String subject;

    /**
     * 
     */
    private Integer isswiper;

    /**
     * 
     */
    private String swiperpic;

    /**
     * 
     */
    private Integer swipersort;

    /**
     * 
     */
    private String grade;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}