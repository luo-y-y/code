package com.cat.code.config.bean;

import java.io.Serializable;

/**
 * 字段元素实体
 * 
 * @author ZengDeGuan
 */
public class FieldBean implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 字段数据类型
	 */
	private String dataType;

	/**
	 * 数据库字段数据类型
	 */
	private String dbDataType;

	/**
	 * mybatis在ORcal 中数据类型
	 */
	private String myBatisDataType;

	/**
	 * 字段类型(R实字段,V虚字段)
	 */
	private String typeCd;

	/**
	 * 英文名称
	 */
	private String name;

	/**
	 * 数据库字段英文名称
	 */
	private String dataName;

	/**
	 * 中文名称
	 */
	private String label;

	/**
	 * 长度
	 */
	private String dataLength;

	/**
	 * 是否主键(Y是,N否)
	 */
	private String isPk;

	/**
	 * 是否为空(Y为空, N不为空)
	 */
	private String isNull;

	/**
	 * 是否唯一(Y唯一, N不唯一)
	 */
	private String isUnique;

	/**
	 * 默认值
	 * 
	 * @return
	 */
	private String defaultValue;

	/**
	 * 备注
	 */
	private String note;

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDataName() {
		return dataName;
	}

	public void setDataName(String dataName) {
		this.dataName = dataName;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getDataLength() {
		return dataLength;
	}

	public void setDataLength(String dataLength) {
		this.dataLength = dataLength;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getIsPk() {
		return isPk;
	}

	public void setIsPk(String isPk) {
		this.isPk = isPk;
	}

	public String getTypeCd() {
		return typeCd;
	}

	public void setTypeCd(String typeCd) {
		this.typeCd = typeCd;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getDbDataType() {
		return dbDataType;
	}

	public void setDbDataType(String dbDataType) {
		this.dbDataType = dbDataType;
	}

	public String getIsNull() {
		return isNull;
	}

	public void setIsNull(String isNull) {
		this.isNull = isNull;
	}

	public String getIsUnique() {
		return isUnique;
	}

	public void setIsUnique(String isUnique) {
		this.isUnique = isUnique;
	}

	public String getMyBatisDataType() {
		return myBatisDataType;
	}

	public void setMyBatisDataType(String myBatisDataType) {
		this.myBatisDataType = myBatisDataType;
	}

}
