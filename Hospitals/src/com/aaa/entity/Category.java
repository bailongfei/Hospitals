package com.aaa.entity;



/**
 * Category entity. @author MyEclipse Persistence Tools
 */

public class Category  implements java.io.Serializable {


    // Fields    

     private Integer cateId;
     private String cateName;
     private String cateDesc;


    // Constructors

    /** default constructor */
    public Category() {
    }

    
    /** full constructor */
    public Category(String cateName, String cateDesc) {
        this.cateName = cateName;
        this.cateDesc = cateDesc;
    }

   
    // Property accessors

    public Integer getCateId() {
        return this.cateId;
    }
    
    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return this.cateName;
    }
    
    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public String getCateDesc() {
        return this.cateDesc;
    }
    
    public void setCateDesc(String cateDesc) {
        this.cateDesc = cateDesc;
    }
   








}