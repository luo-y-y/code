package com.cat.code.bean.ds;
import java.sql.Timestamp;
/**
 * 表名：[ds_table]数据源-数据集表
 * @author Administrator
 */
public class DsTable
      implements 
          java.io.Serializable{

   private static final long serialVersionUID = 1L;

   /**
    * 主键编号
    */
   private Integer id;

   /**
    * 对象
    */
   private String ogid;

   /**
    * 对象版本
    */
   private String over;

   /**
    * 有效性(Y有效, N无效)
    */
   private String isValid;

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
    * 联合唯一
    */
   private String linkUnique;

   /**
    * 数据源编号
    */
   private Integer datasourceId;

   /**
    * 创建用户编号
    */
   private Integer createUserId;

   /**
    * 创建时间
    */
   private Timestamp createDate;

   /**
    * 更新用户编号
    */
   private Integer updateUserId;

   /**
    * 虚字段：创建者
    */
   private String createUserLabel;

   /**
    * 虚字段：更新者
    */
   private String updateUserLabel;

   /**
    * 更新时间
    */
   private Timestamp updateDate;

   /**
    * 备注
    */
   private String note;
   /// ***********************define begin***********************

   /// ***********************define end*************************

   public Integer getId(){
      return id;
   }

   public void setId(Integer id){
      this.id = id;
   }

   public String getOgid(){
      return ogid;
   }

   public void setOgid(String ogid){
      this.ogid = ogid;
   }

   public String getOver(){
      return over;
   }

   public void setOver(String over){
      this.over = over;
   }

   public String getIsValid(){
      return isValid;
   }

   public void setIsValid(String isValid){
      this.isValid = isValid;
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

   public String getLinkUnique(){
      return linkUnique;
   }

   public void setLinkUnique(String linkUnique){
      this.linkUnique = linkUnique;
   }

   public Integer getDatasourceId(){
      return datasourceId;
   }

   public void setDatasourceId(Integer datasourceId){
      this.datasourceId = datasourceId;
   }

   public Integer getCreateUserId(){
      return createUserId;
   }

   public void setCreateUserId(Integer createUserId){
      this.createUserId = createUserId;
   }

   public Timestamp getCreateDate(){
      return createDate;
   }

   public void setCreateDate(Timestamp createDate){
      this.createDate = createDate;
   }

   public Integer getUpdateUserId(){
      return updateUserId;
   }

   public void setUpdateUserId(Integer updateUserId){
      this.updateUserId = updateUserId;
   }

   public String getCreateUserLabel(){
      return createUserLabel;
   }

   public void setCreateUserLabel(String createUserLabel){
      this.createUserLabel = createUserLabel;
   }

   public String getUpdateUserLabel(){
      return updateUserLabel;
   }

   public void setUpdateUserLabel(String updateUserLabel){
      this.updateUserLabel = updateUserLabel;
   }

   public Timestamp getUpdateDate(){
      return updateDate;
   }

   public void setUpdateDate(Timestamp updateDate){
      this.updateDate = updateDate;
   }

   public String getNote(){
      return note;
   }

   public void setNote(String note){
      this.note = note;
   }
   /// ***********************method begin***********************

   /// ***********************method end*************************
}
