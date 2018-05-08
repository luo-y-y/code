package com.cat.code.bean.db;

import java.io.Serializable;

/**
 * MySQL数据库表字段
 * @author ZengDeGuan
 */
public class TableColumn
      implements
         Serializable{

   private static final long serialVersionUID = 1L;

   /**
    * 字段名称
    */
   private String columnName;

   /**
    * 数据类型
    */
   private String dataType;

   /**
    * 字段类型: 类型(长度)
    */
   private String columnType;

   /**
    * 字段说明
    */
   private String columnComment;

   public String getColumnName(){
      return columnName;
   }

   public void setColumnName(String columnName){
      this.columnName = columnName;
   }

   public String getDataType(){
      return dataType;
   }

   public void setDataType(String dataType){
      this.dataType = dataType;
   }

   public String getColumnType(){
      return columnType;
   }

   public void setColumnType(String columnType){
      this.columnType = columnType;
   }

   public String getColumnComment(){
      return columnComment;
   }

   public void setColumnComment(String columnComment){
      this.columnComment = columnComment;
   }

}
