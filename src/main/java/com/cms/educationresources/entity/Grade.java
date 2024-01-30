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
 * @TableName grade
 */
@TableName(value ="grade")
@Data
public class Grade implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer id;

    /**
     * 
     */
    private String grade;

    @TableField(select = false)
    private List<Book> gradeBookList;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}