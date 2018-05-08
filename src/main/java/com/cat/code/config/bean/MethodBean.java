package com.cat.code.config.bean;

import java.io.Serializable;

/**
 * 方法
 * @author Administrator
 *
 */
public class MethodBean
      implements
         Serializable{

   private static final long serialVersionUID = 1L;

   /**
    * 方法名
    */
   private String name;

   /**
    * 参数类型
    */
   private String paramType;

   /**
    * 参数名
    */
   private String paramName;

   /**
    * 返回类型
    */
   private String resultType;

   public String getName(){
      return name;
   }

   public void setName(String name){
      this.name = name;
   }

   public String getParamType(){
      return paramType;
   }

   public void setParamType(String paramType){
      this.paramType = paramType;
   }

   public String getParamName(){
      return paramName;
   }

   public void setParamName(String paramName){
      this.paramName = paramName;
   }

   public String getResultType(){
      return resultType;
   }

   public void setResultType(String resultType){
      this.resultType = resultType;
   }

}
