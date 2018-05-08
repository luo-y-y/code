package com.cat.code.config.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 类元素实体
 * @author ZengDeGuan
 */
public class ClazzBean
      implements
         Serializable{

   private static final long serialVersionUID = 1L;

   /**
    * 包路径
    */
   private String packagePath;

   /**
    * 包名
    */
   private String packageName;

   /**
    * 引入包列表
    */
   private List<String> importList;

   /**
    * 类名(前缀+表名+后缀: FUserService=F+User+Service)
    */
   private String className;

   /**
    * 类别名(前缀+表名+后缀: fUserService=f+User+Service)
    */
   private String classAliasName;

   /**
    * 类注解
    */
   private String classAnnotation;

   /**
    * 类描述
    */
   private String classNode;

   /**
    * 表名
    */
   private String dataName;

   /**
    * 实现接口名
    */
   private String implementsName;

   /**
    * 继承类名
    */
   private String extendsName;

   /**
    * 实体名(PmUser)
    */
   private String entityName;

   /**
    * 实体别名(示例：pmUser)
    */
   private String entityAliasName;

   /**
    * 实体包
    */
   private String entityPackage;

   /**
    * Autowired装配dao层
    */
   private List<String> autowiredList;

   /**
    * 属性列表
    */
   private List<FieldBean> fieldList;

   /**
    * 自定义属性区内容
    */
   private String defPropertyContent;

   /**
    * 方法列表
    */
   private List<MethodBean> methodList;

   /**
    * 自定义方法区内容
    */
   private String defMethodContent;

   /**
    * 自定义引入区内容
    */
   private String defImportContent;

   /**
    * spring-mvc请求映射路径
    * @return  
    */
   private String requestMappingPath;

   /**
    * spring-mvc请求路径
    */
   private String requestPath;

   public String getPackageName(){
      return packageName;
   }

   public void setPackageName(String packageName){
      this.packageName = packageName;
   }

   public List<String> getImportList(){
      return importList;
   }

   public void setImportList(List<String> importList){
      this.importList = importList;
   }

   public String getClassName(){
      return className;
   }

   public void setClassName(String className){
      this.className = className;
   }

   public String getImplementsName(){
      return implementsName;
   }

   public void setImplementsName(String implementsName){
      this.implementsName = implementsName;
   }

   public String getExtendsName(){
      return extendsName;
   }

   public void setExtendsName(String extendsName){
      this.extendsName = extendsName;
   }

   public List<String> getAutowiredList(){
      return autowiredList;
   }

   public void setAutowiredList(List<String> autowiredList){
      this.autowiredList = autowiredList;
   }

   public String getDefPropertyContent(){
      return defPropertyContent;
   }

   public void setDefPropertyContent(String defPropertyContent){
      this.defPropertyContent = defPropertyContent;
   }

   public String getDefMethodContent(){
      return defMethodContent;
   }

   public void setDefMethodContent(String defMethodContent){
      this.defMethodContent = defMethodContent;
   }

   public String getPackagePath(){
      return packagePath;
   }

   public void setPackagePath(String packagePath){
      this.packagePath = packagePath;
   }

   public List<FieldBean> getFieldList(){
      return fieldList;
   }

   public void setFieldList(List<FieldBean> fieldList){
      this.fieldList = fieldList;
   }

   public List<MethodBean> getMethodList(){
      return methodList;
   }

   public void setMethodList(List<MethodBean> methodList){
      this.methodList = methodList;
   }

   public String getClassAliasName(){
      return classAliasName;
   }

   public void setClassAliasName(String classAliasName){
      this.classAliasName = classAliasName;
   }

   public String getClassNode(){
      return classNode;
   }

   public void setClassNode(String classNode){
      this.classNode = classNode;
   }

   public String getClassAnnotation(){
      return classAnnotation;
   }

   public void setClassAnnotation(String classAnnotation){
      this.classAnnotation = classAnnotation;
   }

   public String getDataName(){
      return dataName;
   }

   public void setDataName(String dataName){
      this.dataName = dataName;
   }

   public String getEntityName(){
      return entityName;
   }

   public void setEntityName(String entityName){
      this.entityName = entityName;
   }

   public String getDefImportContent(){
      return defImportContent;
   }

   public void setDefImportContent(String defImportContent){
      this.defImportContent = defImportContent;
   }

   public String getEntityAliasName(){
      return entityAliasName;
   }

   public void setEntityAliasName(String entityAliasName){
      this.entityAliasName = entityAliasName;
   }

   public String getEntityPackage(){
      return entityPackage;
   }

   public void setEntityPackage(String entityPackage){
      this.entityPackage = entityPackage;
   }

   public String getRequestMappingPath(){
      return requestMappingPath;
   }

   public void setRequestMappingPath(String requestMappingPath){
      this.requestMappingPath = requestMappingPath;
   }

   public String getRequestPath(){
      return requestPath;
   }

   public void setRequestPath(String requestPath){
      this.requestPath = requestPath;
   }

}
