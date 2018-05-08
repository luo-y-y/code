package com.cat.code.config.rconfig;

import com.cat.common.lang.RString;

public class RDataType{
   
   /**
    * 根据数据库类型转换JAVA数据类型包
    * @param type
    * @return
    */
   public static String formatDataTypePack(String type){
      if(RString.isBlank(type)){
         return RString.EMPTY;
      }
      type = type.toLowerCase();
      if(type.startsWith("bigdecimal")){
         return "java.math.BigDecimal";
      }else if(type.startsWith("date")){
         return "java.sql.Date";
      }else if(type.startsWith("timestamp")){
         return "java.sql.Timestamp";
      }else if(type.startsWith("time")){
         return "java.sql.Time";
      }
      return RString.EMPTY;
   }
   /**
    * 根据数据库类型转换JAVA数据类型
    * @param type
    * @return
    */
   public static String formatDataType(String type){
      if(RString.isBlank(type)){
         return RString.EMPTY;
      }
      type = type.toLowerCase();
      if(type.startsWith("char") || type.startsWith("varchar") || type.startsWith("clob") || type.startsWith("longvarchar")){
         return "String";
      }else if(type.startsWith("decimal") || type.startsWith("numeric")){
         return "BigDecimal";
      }else if(type.startsWith("bit")){
         return "boolean";
      }else if(type.startsWith("tinyint")){
         return "byte";
      }else if(type.startsWith("smallint")){
         return "Short";
      }else if(type.startsWith("integer") || type.startsWith("int")){
         return "Integer";
      }else if(type.startsWith("bigint") || type.startsWith("number")){
         return "Long";
      }else if(type.startsWith("real")){
         return "Float";
      }else if(type.startsWith("float") || type.startsWith("double")){
         return "Double";
      }else if(type.startsWith("binary") || type.startsWith("blob") || type.startsWith("varbinary") || type.startsWith("longvarbinary")){
         return "byte[]";
      }else if(type.startsWith("date")){
         return "Date";
      }else if(type.startsWith("timestamp")){
         return "Timestamp";
      }else if(type.startsWith("time")){
         return "Time";
      }
      return "String";
   }
   
   /**
    * 根据数据库类型转换JAVA数据类型
    * @param type
    * @return
    */
   public static String formatMybatisDataType(String type){
      if(RString.isBlank(type)){
         return RString.EMPTY;
      }
      type = type.toLowerCase();
      if(type.equalsIgnoreCase("varchar")){
         return "VARCHAR";
      }else if(type.equalsIgnoreCase("timestamp")){
         return "TIMESTAMP";
      }else if(type.equalsIgnoreCase("int") || type.equalsIgnoreCase("Integer")){
         return "NUMERIC";
      }else if(type.equalsIgnoreCase("date")){
         return "DATE";
      }else if(type.equalsIgnoreCase("bigint")){
         return "BIGINT";
      }else if(type.equalsIgnoreCase("char")){
         return "CHAR";
      }else if(type.equalsIgnoreCase("double")){
         return "DOUBLE";
      }else if(type.equalsIgnoreCase("float")){
         return "Float";
      }else if(type.equalsIgnoreCase("clob")){
         return "CLOB";
      }
      return "VARCHAR";
   }
}
