package com.cat.code.bean.build;

public class BuildBean implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 项目编号
	 */
	private Integer projectId;

	/**
	 * 项目模板文件地址
	 */
	private String templateUrl;

	/**
	 * 数据源编号
	 */
	private Integer datasourceId;

	/**
	 * 数据源代码
	 */
	private String datasourceCode;

	/**
	 * 数据源编号
	 */
	private String dbSource;

	/**
	 * 表类型
	 */
	private String tableType;

	/**
	 * 表编号
	 */
	private Integer tableId;

	/**
	 * 表名
	 */
	private String tableCode;

	/**
	 * 生成类型:多类型以","分割
	 */
	private String types;

	/**
	 * 自定义action名称
	 */
	private String actionName;

	/**
	 * 自定义bean名称
	 */
	private String beanName;

	/**
	 * 自定义service名称
	 */
	private String serviceName;

	/**
	 * 自定义serviceImpl名称
	 */
	private String serviceImplName;

	/**
	 * 自定义dao名称
	 */
	private String daoName;

	/**
	 * 自定义mybatis名称
	 */
	private String mybatisName;

	/**
	 * 分页sql类型（mysql,oracle)
	 */
	private String pageSqlType;

	/**
	 * 生成类型：B生成，P预览
	 */
	private String bulidTypeCd;

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getServiceImplName() {
		return serviceImplName;
	}

	public void setServiceImplName(String serviceImplName) {
		this.serviceImplName = serviceImplName;
	}

	public String getDaoName() {
		return daoName;
	}

	public void setDaoName(String daoName) {
		this.daoName = daoName;
	}

	public String getMybatisName() {
		return mybatisName;
	}

	public void setMybatisName(String mybatisName) {
		this.mybatisName = mybatisName;
	}

	public String getPageSqlType() {
		return pageSqlType;
	}

	public void setPageSqlType(String pageSqlType) {
		this.pageSqlType = pageSqlType;
	}

	public Integer getDatasourceId() {
		return datasourceId;
	}

	public void setDatasourceId(Integer datasourceId) {
		this.datasourceId = datasourceId;
	}

	public String getTableCode() {
		return tableCode;
	}

	public void setTableCode(String tableCode) {
		this.tableCode = tableCode;
	}

	public String getTableType() {
		return tableType;
	}

	public void setTableType(String tableType) {
		this.tableType = tableType;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getDbSource() {
		return dbSource;
	}

	public void setDbSource(String dbSource) {
		this.dbSource = dbSource;
	}

	public String getDatasourceCode() {
		return datasourceCode;
	}

	public void setDatasourceCode(String datasourceCode) {
		this.datasourceCode = datasourceCode;
	}

	public Integer getTableId() {
		return tableId;
	}

	public void setTableId(Integer tableId) {
		this.tableId = tableId;
	}

	public String getBulidTypeCd() {
		return bulidTypeCd;
	}

	public void setBulidTypeCd(String bulidTypeCd) {
		this.bulidTypeCd = bulidTypeCd;
	}

	public String getTemplateUrl() {
		return templateUrl;
	}

	public void setTemplateUrl(String templateUrl) {
		this.templateUrl = templateUrl;
	}

}
