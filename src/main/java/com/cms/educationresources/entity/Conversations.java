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
 * @TableName conversations
 */
@TableName(value ="conversations")
@Data
public class Conversations implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String avatarurl;

    /**
     * 
     */
    private String sender;

    /**
     * 
     */
    private String receiver;

    /**
     * 
     */
    @JsonSerialize(using = DateTimeSerializer.class)
    private Date time;

    /**
     * 
     */
    private String message;

    @TableField(select = false, exist = false)
    private String senderCode;

    @TableField(select = false, exist = false)
    private String receiverCode;

    @TableField(select = false, exist = false)
    private String receiverName;


    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}