package com.cat.code.bean.build;

import java.sql.Timestamp;

/**
 * 表名：[dp_project]开发-项目表
 * 
 * @author Administrator
 */
public class DpProject implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主键编号
	 */
	private Long id;

	/**
	 * 对象全局标识
	 */
	private String ogid;

	/**
	 * 有效性 (Y有效, N无效)
	 */
	private String isValid;

	/**
	 * 对象版本 生成规则：操作状态+年月日时分秒+8位用户ID = 共25位(示例：U2009051414013500000002)
	 */
	private String over;

	/**
	 * 项目类型 (S系统,B业务)
	 */
	private String typeCd;

	/**
	 * 父编号
	 */
	private Long parentId;

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
	 * 项目描述
	 */
	private String projectDescribe;

	/**
	 * 开发模板地址
	 */
	private String templateUrl;

	/**
	 * 虚字段：父名称
	 */
	private String parentLabel;

	/**
	 * 范围摘要
	 */
	private String rangeSummary;

	/**
	 * 排序
	 */
	private Integer dispOrder;

	/**
	 * 图标名称
	 */
	private String iconName;

	/**
	 * 调度地址
	 */
	private String doInvoke;

	/**
	 * 转向地址
	 */
	private String doRedirect;

	/**
	 * 创建用户编号
	 */
	private Long createUserId;

	/**
	 * 创建时间
	 */
	private Timestamp createDate;

	/**
	 * 更新用户编号
	 */
	private Long updateUserId;

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOgid() {
		return ogid;
	}

	public void setOgid(String ogid) {
		this.ogid = ogid;
	}

	public String getIsValid() {
		return isValid;
	}

	public void setIsValid(String isValid) {
		this.isValid = isValid;
	}

	public String getOver() {
		return over;
	}

	public void setOver(String over) {
		this.over = over;
	}

	public String getTypeCd() {
		return typeCd;
	}

	public void setTypeCd(String typeCd) {
		this.typeCd = typeCd;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
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

	public String getProjectDescribe() {
		return projectDescribe;
	}

	public void setProjectDescribe(String projectDescribe) {
		this.projectDescribe = projectDescribe;
	}

	public String getTemplateUrl() {
		return templateUrl;
	}

	public void setTemplateUrl(String templateUrl) {
		this.templateUrl = templateUrl;
	}

	public String getParentLabel() {
		return parentLabel;
	}

	public void setParentLabel(String parentLabel) {
		this.parentLabel = parentLabel;
	}

	public String getRangeSummary() {
		return rangeSummary;
	}

	public void setRangeSummary(String rangeSummary) {
		this.rangeSummary = rangeSummary;
	}

	public Integer getDispOrder() {
		return dispOrder;
	}

	public void setDispOrder(Integer dispOrder) {
		this.dispOrder = dispOrder;
	}

	public String getIconName() {
		return iconName;
	}

	public void setIconName(String iconName) {
		this.iconName = iconName;
	}

	public String getDoInvoke() {
		return doInvoke;
	}

	public void setDoInvoke(String doInvoke) {
		this.doInvoke = doInvoke;
	}

	public String getDoRedirect() {
		return doRedirect;
	}

	public void setDoRedirect(String doRedirect) {
		this.doRedirect = doRedirect;
	}

	public Long getCreateUserId() {
		return createUserId;
	}

	public void setCreateUserId(Long createUserId) {
		this.createUserId = createUserId;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Long getUpdateUserId() {
		return updateUserId;
	}

	public void setUpdateUserId(Long updateUserId) {
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
