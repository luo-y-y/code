package com.cat.code.bean.build;

public class TableBean
      implements
         java.io.Serializable{

   private static final long serialVersionUID = 1L;

   /**
    * 数据源类型(mysql, oracle)
    */
   private String dbType;

   /**
    * 数据源代码
    */
   private String dbCode;
   
   /**
    * sql代码类型(mysql, oracle)
    */
   private String sqlType;

   /**
    * 表类型(W工作表,N虚拟表,S单例表)
    */
   private String typeCd;

   /**
    * 代码
    */
   private String code;

   /**
    * 英文名称
    */
   private String name;

   /**
    * 中文名称
    */
   private String label;

   /**
    * 空间名称
    */
   private String tablespaceName;

   /**
    * 序列名称
    */
   private String sequenceName;

   /**
    * 表主键
    */
   private String pkey;

   /**
    * 表主键别名：pm_user_id转PmUserId
    */
   private String pkeyFirstUpper;

   /**
    * 表主键别名：pm_user_Id转pmUserId
    */
   private String pkeyFirstLower;
   
   /**
    * 联合主键
    */
   private String linkUnique;

   /**
    * 备注
    */
   private String note;
   /**
    * 主键类型
    * @return
    */
   private String pkeyType;
   private String validCreateDate;
   private String validUpdateDate;
   private String validOgid;
   private String validOver;
   private String validUpdateUserId;
   private String validCreateUserId;
   
   public String getDbType(){
      return dbType;
   }

   public void setDbType(String dbType){
      this.dbType = dbType;
   }

   public String getDbCode(){
      return dbCode;
   }

   public void setDbCode(String dbCode){
      this.dbCode = dbCode;
   }

   public String getTypeCd(){
      return typeCd;
   }

   public void setTypeCd(String typeCd){
      this.typeCd = typeCd;
   }

   public String getCode(){
      return code;
   }

   public void setCode(String code){
      this.code = code;
   }

   public String getName(){
      return name;
   }

   public void setName(String name){
      this.name = name;
   }

   public String getLabel(){
      return label;
   }

   public void setLabel(String label){
      this.label = label;
   }

   public String getTablespaceName(){
      return tablespaceName;
   }

   public void setTablespaceName(String tablespaceName){
      this.tablespaceName = tablespaceName;
   }

   public String getSequenceName(){
      return sequenceName;
   }

   public void setSequenceName(String sequenceName){
      this.sequenceName = sequenceName;
   }

   public String getPkeyFirstUpper(){
      return pkeyFirstUpper;
   }

   public void setPkeyFirstUpper(String pkeyFirstUpper){
      this.pkeyFirstUpper = pkeyFirstUpper;
   }

   public String getPkeyFirstLower(){
      return pkeyFirstLower;
   }

   public void setPkeyFirstLower(String pkeyFirstLower){
      this.pkeyFirstLower = pkeyFirstLower;
   }

   public String getNote(){
      return note;
   }

   public void setNote(String note){
      this.note = note;
   }

   public String getSqlType(){
      return sqlType;
   }
   
   public void setSqlType(String sqlType){
      this.sqlType = sqlType;
   }

   public String getPkey(){
      return pkey;
   }

   public void setPkey(String pkey){
      this.pkey = pkey;
   }
   
   public String getLinkUnique(){
      return linkUnique;
   }

   public void setLinkUnique(String linkUnique){
      this.linkUnique = linkUnique;
   }


   public String getValidCreateDate(){
      return validCreateDate;
   }
   
   public void setValidCreateDate(String validCreateDate){
      this.validCreateDate = validCreateDate;
   }
   
   public String getValidUpdateDate(){
      return validUpdateDate;
   }
   
   public void setValidUpdateDate(String validUpdateDate){
      this.validUpdateDate = validUpdateDate;
   }
   
   public String getValidOgid(){
      return validOgid;
   }

   public void setValidOgid(String validOgid){
      this.validOgid = validOgid;
   }

   public String getValidOver(){
      return validOver;
   }
   
   public void setValidOver(String validOver){
      this.validOver = validOver;
   }
   
   public String getPkeyType(){
      return pkeyType;
   }
   
   public void setPkeyType(String pkeyType){
      this.pkeyType = pkeyType;
   }
   
   public String getValidUpdateUserId(){
      return validUpdateUserId;
   }

   public void setValidUpdateUserId(String validUpdateUserId){
      this.validUpdateUserId = validUpdateUserId;
   }

   public String getValidCreateUserId(){
      return validCreateUserId;
   }

   public void setValidCreateUserId(String validCreateUserId){
      this.validCreateUserId = validCreateUserId;
   }

}
