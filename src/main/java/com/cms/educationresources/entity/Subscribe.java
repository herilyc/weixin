package com.cms.educationresources.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import lombok.Data;

/**
 * 
 * @TableName subscribe
 */
@TableName(value ="subscribe")
@Data
public class Subscribe implements Serializable {
    /**
     * 
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 
     */
    private String bookname;

    /**
     * 
     */
    private String userid;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}