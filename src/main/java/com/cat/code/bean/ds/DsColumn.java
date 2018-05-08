package com.cat.code.bean.ds;

import java.sql.Timestamp;

/**
 * 表名：[ds_column]数据源-字段表
 * 
 * @author Administrator
 */
public class DsColumn implements java.io.Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 主键编号
	 */
	private Integer id;

	/**
	 * 对象全局标识
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
	 * 数据源ID
	 */
	private Integer datasourceId;

	/**
	 * 表编号
	 */
	private Integer tableId;

	/**
	 * 数据类型
	 */
	private String dataType;

	/**
	 * 数据长度
	 */
	private String dataLength;

	/**
	 * 默认值
	 */
	private String defaultValue;

	/**
	 * 是否为空(Y为空, N不为空)
	 */
	private String isNull;

	/**
	 * 排序号
	 */
	private Integer sortNum;

	/**
	 * 是否主键 Y是，N否
	 */
	private String isPk;

	/**
	 * 是否唯一 Y唯一，N不唯一
	 */
	private String isUnique;

	/**
	 * 外键
	 */
	private String foreignKey;

	/**
	 * 字段类型 V[虚拟Virtual]，R[真实Real]
	 */
	private String typeCd;

	/**
	 * 创建用户编号
	 */
	private Integer createUserId;

	/**
	 * 虚字段：创建者
	 */
	private String createUserLabel;

	/**
	 * 虚字段：更新者
	 */
	private String updateUserLabel;

	/**
	 * 创建时间
	 */
	private Timestamp createDate;

	/**
	 * 更新用户编号
	 */
	private Integer updateUserId;

	/**
	 * 更新时间
	 */
	private Timestamp updateDate;

	/**
	 * 备注
	 */
	private String note;

	// / ***********************define begin***********************

	// / ***********************define end*************************

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOgid() {
		return ogid;
	}

	public void setOgid(String ogid) {
		this.ogid = ogid;
	}

	public String getOver() {
		return over;
	}

	public void setOver(String over) {
		this.over = over;
	}

	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getDatasourceId() {
		return datasourceId;
	}

	public void setDatasourceId(Integer datasourceId) {
		this.datasourceId = datasourceId;
	}

	public Integer getTableId() {
		return tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getDataLength() {
		return dataLength;
	}

	public void setDataLength(String dataLength) {
		this.dataLength = dataLength;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getIsNull() {
		return isNull;
	}

	public void setIsNull(String isNull) {
		this.isNull = isNull;
	}

	public Integer getSortNum() {
		return sortNum;
	}

	public void setSortNum(Integer sortNum) {
		this.sortNum = sortNum;
	}

	public String getIsPk() {
		return isPk;
	}

	public void setIsPk(String isPk) {
		this.isPk = isPk;
	}

	public String getIsUnique() {
		return isUnique;
	}

	public void setIsUnique(String isUnique) {
		this.isUnique = isUnique;
	}

	public String getForeignKey() {
		return foreignKey;
	}

	public void setForeignKey(String foreignKey) {
		this.foreignKey = foreignKey;
	}

	public String getTypeCd() {
		return typeCd;
	}

	public void setTypeCd(String typeCd) {
		this.typeCd = typeCd;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
	}

	public String getCreateUserLabel() {
		return createUserLabel;
	}

	public void setCreateUserLabel(String createUserLabel) {
		this.createUserLabel = createUserLabel;
	}

	public String getUpdateUserLabel() {
		return updateUserLabel;
	}

	public void setUpdateUserLabel(String updateUserLabel) {
		this.updateUserLabel = updateUserLabel;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Integer getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(Integer updateUserId) {
		this.updateUserId = updateUserId;
	}

	public Timestamp getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	// / ***********************method begin***********************

	// / ***********************method end*************************
}
