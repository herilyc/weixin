package com.cms.educationresources.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 
 * @TableName category
 */
@TableName(value ="category")
@Data
public class Category implements Serializable {
    /**
     * 
     */
    private Integer id;

    /**
     * 
     */
    private String subject;

    /**
     * 
     */
    private String subjectpic;

    @TableField(select = false)
    private List<Book> sbjBookList;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}