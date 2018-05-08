package com.cat.code.bean.ds;

import java.sql.Timestamp;

/**
 * 表名：[ds_datasource]数据源表
 * 
 * @author Administrator
 */
public class DsDatasource implements java.io.Serializable {

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
	 * 类型
	 */
	private String typeCd;

	/**
	 * 代码(数据源名)
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
	 * 驱动类
	 */
	private String driverClass;

	/**
	 * 数据库连接地址
	 */
	private String jdbcUrl;

	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 密码
	 */
	private String userPassword;

	/**
	 * 开发项目编号
	 */
	private Integer projectId;

	/**
	 * 虚字段：项目名称
	 */
	private String projectLabel;

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

	public String getTypeCd() {
		return typeCd;
	}

	public void setTypeCd(String typeCd) {
		this.typeCd = typeCd;
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

	public String getDriverClass() {
		return driverClass;
	}

	public void setDriverClass(String driverClass) {
		this.driverClass = driverClass;
	}

	public String getJdbcUrl() {
		return jdbcUrl;
	}

	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getProjectLabel() {
		return projectLabel;
	}

	public void setProjectLabel(String projectLabel) {
		this.projectLabel = projectLabel;
	}

	public Integer getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Integer createUserId) {
		this.createUserId = createUserId;
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
