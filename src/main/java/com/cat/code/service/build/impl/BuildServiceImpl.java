package com.cat.code.service.build.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.jdom2.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cat.code.bean.build.BuildBean;
import com.cat.code.bean.ds.DsColumn;
import com.cat.code.bean.ds.DsDatasource;
import com.cat.code.bean.ds.DsTable;
import com.cat.code.config.FConfigConsole;
import com.cat.code.config.bean.ClazzBean;
import com.cat.code.config.bean.EComponentType;
import com.cat.code.config.bean.FieldBean;
import com.cat.code.config.bean.MethodBean;
import com.cat.code.config.bean.TableBean;
import com.cat.code.config.bean.XActionBean;
import com.cat.code.config.bean.XBaseConfigBean;
import com.cat.code.config.bean.XBeanBean;
import com.cat.code.config.bean.XDaoBean;
import com.cat.code.config.bean.XMybatisBean;
import com.cat.code.config.bean.XServiceImplBean;
import com.cat.code.config.rconfig.RConfig;
import com.cat.code.config.rconfig.RDataType;
import com.cat.code.config.rconfig.RJavaSyntax;
import com.cat.code.config.rconfig.RSqlSyntax;
import com.cat.code.config.rconfig.RSymbol;
import com.cat.code.config.rconfig.RVelocity;
import com.cat.code.service.build.BuildService;
import com.cat.code.service.build.ColumnsService;
import com.cat.code.service.build.TablesService;
import com.cat.code.service.ds.DsColumnService;
import com.cat.code.service.ds.DsDatasourceService;
import com.cat.code.service.ds.DsTableService;
import com.cat.common.lang.RObject;
import com.cat.common.lang.RString;
import com.cat.common.listener.RSystemConfig;

@Service("buildService")
public class BuildServiceImpl implements BuildService {

	private Logger _logger = Logger.getLogger(this.getClass());
	
	private static final String dbSource_db = "db";
	
	private static final String encode = "utf-8";
	
	private static final String dbSource_ds = "ds";

	public Map<String, Object> parameterMap = null;


	public List<Element> eleList = null;
	
	@Autowired
	private TablesService tablesService;

	@Autowired
	private ColumnsService columnsService;

	@Autowired
	private DsTableService dsTableService;

	@Autowired
	private DsColumnService dsColumnService;

	@Autowired
	private DsDatasourceService dsDatasourceService;

	private static String developProjectPath = RSystemConfig.Class_Path + "config"+File.separator+"develop"+File.separator;

	BuildServiceImpl() {
		parameterMap = new HashMap<String, Object>();
		eleList = new ArrayList<Element>();
	}

	@Override
	public void buildAllForDb(String datasourceCode, String pageSqlType) {
		// 数据库系统表
		List<DsTable> tables = tablesService.findAllList(datasourceCode);
		if (RObject.isEmpty(tables)) {
			_logger.info("bulid  tables is null  ");
			return;
		}
		for (int i = 0; i < tables.size(); i++) {
			DsTable dsTable = tables.get(i);
			BuildBean bean = new BuildBean();
			bean.setPageSqlType(pageSqlType);
			bean.setDatasourceId(null);
			bean.setTableCode(dsTable.getCode());
			bean.setTypes(getTypes());
			bean.setTableType("S");
			bean.setDbSource(dbSource_db);// 数据库系统表来源
			build(bean);
		}
	}

	@Override
	public boolean buildAll(String datasourceCode, String pageSqlType) {
		DsDatasource dsDatasource = dsDatasourceService.load(datasourceCode);
		if (null == dsDatasource) {
			_logger.info(  "buildAll  dsDatasource is null  ");
			return false;
		}
		DsTable search = new DsTable();
		search.setDatasourceId(dsDatasource.getId());
		// 数据库自定义表
		List<DsTable> tables = dsTableService.findList(search, null, null, null);
		if (RObject.isEmpty(tables)) {
			_logger.info(  "buildAll  tables is null  ");
			return false;
		}
		for (int i = 0; i < tables.size(); i++) {
			DsTable dsTable = tables.get(i);
			BuildBean bean = new BuildBean();
			bean.setPageSqlType(pageSqlType);
			bean.setDatasourceId(dsDatasource.getId());
			bean.setDatasourceCode(datasourceCode);
			bean.setTableId(dsTable.getId());
			bean.setTableCode(dsTable.getCode());
			bean.setTypes(getTypes());
			bean.setTableType(dsTable.getTypeCd());
			bean.setDbSource(dbSource_ds);
			build(bean);
		}
		return true;
	}

	@Override
	public String preview(BuildBean bulidBean) {
		if (null == bulidBean) {
			_logger.info(  "preview  bulidBean is null");
			return null;
		}
		//
		String table = bulidBean.getTableCode();
		String types = bulidBean.getTypes();
		if (RString.isBlank(table) || RString.isBlank(types)) {
			_logger.info(  "preview  bulidBean param is error");
			return null;
		}
		_logger.info("preview = "+ developProjectPath);
		if (RString.isBlank(bulidBean.getTemplateUrl())) {
			_logger.info(  "preview  bulidBean fail, template url is null");
			return null;
		}
		// 加载项目文件
		Map<String, Object> initMap = new HashMap<String, Object>();
		eleList = FConfigConsole.parse(developProjectPath, bulidBean.getTemplateUrl(),initMap);
		RConfig.putAllDefine(initMap,parameterMap);

		if (RString.isBlank(bulidBean.getPageSqlType())) {
			bulidBean.setPageSqlType("mysql");
		}
		if (RString.isBlank(bulidBean.getTableType())) {
			bulidBean.setTableType("S");
		}
		bulidBean.setTableCode(RString.toLower(table));
		// 表信息
		parameterMap.put("tableBean", bulidTableBean(bulidBean));
		if (RString.contains(types, EComponentType.Bean.toString())) {
			return RJavaSyntax.format(buildBean(bulidBean));
		} else if (RString.contains(types, EComponentType.Dao.toString())) {
			return RJavaSyntax.format(buildDao(bulidBean));
		} else if (RString.contains(types, EComponentType.Mybatis.toString())) {
			return RSqlSyntax.format(buildMybatis(bulidBean));
		} else if (RString.contains(types, EComponentType.Service.toString())) {
			return RJavaSyntax.format(buildService(bulidBean, types));
		} else if (RString.contains(types, EComponentType.ServiceImpl.toString())) {
			return RJavaSyntax.format(buildServiceImpl(bulidBean));
		} else if (RString.contains(types, EComponentType.Action.toString())) {
			return RJavaSyntax.format(buildAction(bulidBean));
		} else if (RString.contains(types, EComponentType.MySqlTable.toString()) || RString.contains(types, EComponentType.MySqlTableHs.toString())
				|| RString.contains(types, EComponentType.MySqlField.toString())) {
			return RSqlSyntax.format(buildSqlTable(bulidBean, types));
		}
		return null;
	}

	@Override
	public boolean build(BuildBean bulidBean) {
		if (null == bulidBean) {
			_logger.info(  "bulid  bulidBean is null.");
			return false;
		}
		String pageSqlType = bulidBean.getPageSqlType();
		String table = bulidBean.getTableCode();
		String tableType = bulidBean.getTableType();
		String types = bulidBean.getTypes();
		if (RString.isBlank(pageSqlType) || RString.isBlank(table) || RString.isBlank(tableType) || RString.isBlank(types)) {
			_logger.info(  "bulid  bulidBean param is error.");
			return false;
		}
		if (RString.isBlank(bulidBean.getTemplateUrl())) {
			_logger.info(  "preview  bulidBean fail, template url is null.");
			return false;
		}
		_logger.info(  "build"+developProjectPath);
		// 加载项目文件
		
		Map<String, Object> initMap = new HashMap<String, Object>();
		eleList = FConfigConsole.parse(developProjectPath, bulidBean.getTemplateUrl(),initMap);
		RConfig.putAllDefine(initMap,parameterMap);

		bulidBean.setTableCode(RString.toLower(table));
		// 表信息
		parameterMap.put("tableBean", bulidTableBean(bulidBean));
		if (RString.contains(types, EComponentType.Bean.toString())) {
			buildBean(bulidBean);
		}
		if (RString.contains(types, EComponentType.Dao.toString())) {
			buildDao(bulidBean);
		}
		if (RString.contains(types, EComponentType.Mybatis.toString())) {
			buildMybatis(bulidBean);
		}
		if (RString.contains(types, EComponentType.Service.toString())) {
			buildService(bulidBean, EComponentType.Service.toString());
		}
		if (RString.contains(types, EComponentType.ServiceImpl.toString())) {
			buildServiceImpl(bulidBean);
		}
		if (RString.contains(types, EComponentType.Action.toString())) {
			buildAction(bulidBean);
		}
		return true;
	}

	/**
	 * 获取表信息
	 * 
	 * @param bulidBean
	 * @return
	 */
	private TableBean bulidTableBean(BuildBean bulidBean) {
		TableBean tb = new TableBean();
		// 表信息获取
		if (dbSource_ds.equals(bulidBean.getDbSource())) {
			DsTable dsTable = dsTableService.load(bulidBean.getTableId());
			tb.setSqlType(bulidBean.getPageSqlType());
			tb.setTypeCd(dsTable.getTypeCd());
			tb.setCode(dsTable.getCode());
			tb.setLabel(dsTable.getLabel());
			tb.setNote(dsTable.getNote());
			tb.setSequenceName(dsTable.getSequenceName());
			tb.setTablespaceName(dsTable.getTablespaceName());
			// 主键处理
			List<DsColumn> dsColumnlist = dsColumnService.findColumnList(bulidBean.getDatasourceId(), bulidBean.getTableId());
			for (int i = 0; i < dsColumnlist.size(); i++) {
				DsColumn dsColumn = dsColumnlist.get(i);
				if (RString.equals(dsColumn.getIsPk(), "Y")) {
					String pkey = dsColumn.getName();
					tb.setPkey(dsColumn.getName());
					if (RString.equals(dsColumn.getDataType(), "bigint")) {
						tb.setPkeyType("Long");
					} else if(RString.equalsIgnoreCase(dsColumn.getDataType(), "int")) {
						tb.setPkeyType("Integer");
					} else{
						tb.setPkeyType("String");
					}
					String pkeyFirstUpper = formatFirstUpperName(pkey);
					tb.setPkeyFirstUpper(pkeyFirstUpper);
					tb.setPkeyFirstLower(RString.firstLower(pkeyFirstUpper));
				} else if (RString.equals(dsColumn.getName(), "CREATE_DATE")) {
					tb.setValidCreateDate("Y");
				} else if (RString.equals(dsColumn.getName(), "UPDATE_DATE")) {
					tb.setValidUpdateDate("Y");
				} else if (RString.equals(dsColumn.getName(), "OVER")) {
					tb.setValidOgid("Y");
				} else if (RString.equals(dsColumn.getName(), "OGID")) {
					tb.setValidOver("Y");
				} else if (RString.equals(dsColumn.getName(), "UPDATE_USER_ID")) {
					tb.setValidCreateUserId("Y");
				} else if (RString.equals(dsColumn.getName(), "CREATE_USER_ID")) {
					tb.setValidCreateUserId("Y");
				}
			}

			String linkUnique = RString.isBlank(dsTable.getLinkUnique()) ? "" : dsTable.getLinkUnique();
			tb.setLinkUnique(linkUnique);
		} else {
			tb.setSqlType(bulidBean.getPageSqlType());
			tb.setTypeCd(bulidBean.getTableType());
			tb.setCode(bulidBean.getTableCode());
			tb.setLabel("");
			tb.setNote("");
			tb.setSequenceName("");
			tb.setTablespaceName("");
			// 主键处理
			String pkey = "id";
			tb.setPkey(pkey);
			String pkeyFirstUpper = formatFirstUpperName(pkey);
			tb.setPkeyFirstUpper(pkeyFirstUpper);
			tb.setPkeyFirstLower(RString.firstLower(pkeyFirstUpper));
			tb.setLinkUnique("");
			tb.setValidCreateDate("N");
			tb.setValidUpdateDate("N");
			tb.setValidOgid("N");
			tb.setValidOver("N");
			tb.setValidCreateUserId("N");
			tb.setValidUpdateUserId("N");
		}
		return tb;
	}

	private String buildBean(BuildBean bulidBean) {
		XBeanBean x = RConfig.findBean(eleList);
		if (RObject.isEmpty(x)) {
			return null;
		}
		String table = bulidBean.getTableCode();
		ClazzBean clazzBean = new ClazzBean();
		clazzBean.setDataName(table);
		// pm_user-->PmUser
		String entityName = formatFirstUpperName(table);
		clazzBean.setEntityName(entityName);
		clazzBean.setEntityAliasName(RString.firstLower(entityName));
		// pm_user-->pm.user
		String rightPackage = makeRightPackage(table);
		// 生成bean包全路径
		String packageName = RString.format(x.getPackagePath(), rightPackage);
		clazzBean.setPackageName(packageName);
		clazzBean.setClassName(entityName);
		// ////////////////////////////////////////////////////////////////////////////////////////////////////////
		clazzBean.setImplementsName(x.getImplInterface());
		boolean isSuccess = buildFileContext(bulidBean.getDatasourceId(), bulidBean.getTableId(), bulidBean.getDatasourceCode(), table, clazzBean, bulidBean
				.getDbSource());
		if (!isSuccess) {
			return null;
		}
		// 生成文件名全路径
		String buildFileName = "";//makeFilePath(x.getBuildPath(), rightPackage, entityName, x.getFileNameTempLet(), bulidBean.getBulidTypeCd());
		return bulidFile(bulidBean.getBulidTypeCd(), x.getTempletFilePath(), x.getTempletFile(), buildFileName, clazzBean);
	}

	private String buildDao(BuildBean bulidBean) {
		XDaoBean x = RConfig.findDao(eleList);
		if (RObject.isEmpty(x)) {
			return null;
		}
		String table = bulidBean.getTableCode();
		ClazzBean clazzBean = new ClazzBean();
		clazzBean.setDataName(table);
		// pm_user-->PmUser
		String tableFormatName = formatFirstUpperName(table);
		// pm_user-->pm.user
		String rightPackage = makeRightPackage(table);
		String entityPackage = RString.format(x.getEntityPackage(), rightPackage, tableFormatName);
		String entityName = RString.right(entityPackage, ".");
		clazzBean.setEntityName(entityName);
		clazzBean.setEntityAliasName(RString.firstLower(entityName));
		// 生成DAO包全路径
		String packageName = RString.format(x.getPackagePath(), rightPackage);
		clazzBean.setPackageName(packageName);

		// 类包全路径(实体起始路径+包路径)
		clazzBean.setClassName(tableFormatName);
		clazzBean.setClassAliasName(RString.firstLower(tableFormatName));
		// ////////////////////////////////////////////////////////////////////////////////////////////////////////
		clazzBean.setExtendsName(x.getSuperClass());
		List<String> importList = new ArrayList<String>();
		importList.add(x.getSuperClassPackage());
		importList.add(entityPackage);
		clazzBean.setImportList(importList);
		// 文件(起始路径+包路径+文件名+扩展名)
		String buildFileName = "";//makeFilePath(x.getBuildPath(), rightPackage, tableFormatName, x.getFileNameTempLet(), bulidBean.getBulidTypeCd());
		return bulidFile(bulidBean.getBulidTypeCd(), x.getTempletFilePath(), x.getTempletFile(), buildFileName, clazzBean);
	}

	private String buildService(BuildBean bulidBean, String type) {
		// XBaseConfigBean x = RConfig.find(node,
		// EComponentType.Service.toString());
		XBaseConfigBean x = RConfig.find(eleList, type);
		if (RObject.isEmpty(x)) {
			return null;
		}
		String table = bulidBean.getTableCode();
		ClazzBean clazzBean = new ClazzBean();
		clazzBean.setDataName(table);
		// pm_user-->PmUser
		String tableFormatName = formatFirstUpperName(table);
		// pm_user-->pm.user
		String rightPackage = makeRightPackage(table);
		String entityPackage = RString.format(x.getEntityPackage(), rightPackage, tableFormatName);
		String entityName = RString.right(entityPackage, ".");
		clazzBean.setEntityName(entityName);
		clazzBean.setEntityAliasName(RString.firstLower(entityName));
		// 生成包全路径
		String packageName = RString.format(x.getPackagePath(), rightPackage);
		clazzBean.setPackageName(packageName);
		clazzBean.setClassName(tableFormatName);
		clazzBean.setClassAliasName(RString.firstLower(tableFormatName));
		// ////////////////////////////////////////////////////////////////////////////////////////////////////////
		List<String> importList = new ArrayList<String>();
		// 实体包全路径(实体起始路径+包路径+类名)
		importList.add(entityPackage);
		clazzBean.setImportList(importList);
		// 文件(起始路径+包路径+文件名+扩展名)
		String buildFileName = "";//makeFilePath(x.getBuildPath(), rightPackage, tableFormatName, x.getFileNameTempLet(), bulidBean.getBulidTypeCd());
		return bulidFile(bulidBean.getBulidTypeCd(), x.getTempletFilePath(), x.getTempletFile(), buildFileName, clazzBean);
	}

	private String buildServiceImpl(BuildBean bulidBean) {
		XServiceImplBean x = RConfig.findServiceImpl(eleList);
		if (RObject.isEmpty(x)) {
			return null;
		}
		String table = bulidBean.getTableCode();
		ClazzBean clazzBean = new ClazzBean();
		clazzBean.setDataName(RString.toLower(table));
		// pm_user-->PmUser
		String tableFormatName = formatFirstUpperName(table);
		// pm_user-->pm.user
		String rightPackage = makeRightPackage(table);
		String entityPackage = RString.format(x.getEntityPackage(), rightPackage, tableFormatName);
		String entityName = RString.right(entityPackage, ".");
		clazzBean.setEntityName(entityName);
		clazzBean.setEntityAliasName(RString.firstLower(entityName));
		// 生成包全路径
		String packageName = RString.format(x.getPackagePath(), rightPackage);
		clazzBean.setPackageName(packageName);

		// 类包全路径(实体起始路径+包路径)
		clazzBean.setClassName(tableFormatName);
		clazzBean.setClassAliasName(RString.firstLower(tableFormatName));
		// ////////////////////////////////////////////////////////////////////////////////////////////////////////
		String implementsPackage = RString.format(x.getImplInterface(), rightPackage, tableFormatName);
		String implementsName = RString.right(implementsPackage, ".");
		clazzBean.setImplementsName(implementsName);
		clazzBean.setClassAnnotation(RString.firstLower(implementsName));

		List<String> importList = new ArrayList<String>();
		importList.add(implementsPackage);
		importList.add(entityPackage);
		String daoPackage = RString.format(x.getDaoPackage(), rightPackage, tableFormatName);
		importList.add(daoPackage);
		clazzBean.setImportList(importList);

		// 文件(起始路径+包路径+文件名+扩展名)
		String buildFileName = "";//makeFilePath(x.getBuildPath(), rightPackage, tableFormatName, x.getFileNameTempLet(), bulidBean.getBulidTypeCd());
		return bulidFile(bulidBean.getBulidTypeCd(), x.getTempletFilePath(), x.getTempletFile(), buildFileName, clazzBean);
	}

	private String buildMybatis(BuildBean bulidBean) {
		XMybatisBean x = RConfig.findMybatis(eleList);
		if (RObject.isEmpty(x)) {
			return null;
		}
		String table = bulidBean.getTableCode();
		ClazzBean clazzBean = new ClazzBean();
		clazzBean.setDataName(table);

		String tableFormatName = formatFirstUpperName(table);
		String rightPackage = makeRightPackage(table);
		String entityPackage = RString.format(x.getEntityPackage(), rightPackage, tableFormatName);
		String entityName = RString.right(entityPackage, ".");
		clazzBean.setEntityName(entityName);
		clazzBean.setEntityAliasName(RString.firstLower(entityName));

		clazzBean.setClassName(tableFormatName);
		clazzBean.setClassAliasName(RString.firstLower(tableFormatName));
		// ////////////////////////////////////////////////////////////////////////////////////////////////////////
		// mybaiti空间命名是dao层类名(实体起始路径+包路径)
		clazzBean.setPackageName(RString.format(x.getPackagePath(), rightPackage, tableFormatName));
		clazzBean.setEntityPackage(entityPackage);
		boolean isSuccess = buildFileContext(bulidBean.getDatasourceId(), bulidBean.getTableId(), bulidBean.getDatasourceCode(), table, clazzBean, bulidBean
				.getDbSource());
		if (!isSuccess) {
			return null;
		}
		String buildFileName = "";//makeFilePath(x.getBuildPath(), rightPackage, tableFormatName, x.getFileNameTempLet(), bulidBean.getBulidTypeCd());
		return bulidFile(bulidBean.getBulidTypeCd(), x.getTempletFilePath(), x.getTempletFile(), buildFileName, clazzBean);
	}

	private String buildAction(BuildBean bulidBean) {
		XActionBean x = RConfig.findAction(eleList);
		if (RObject.isEmpty(x)) {
			return null;
		}
		String table = bulidBean.getTableCode();
		ClazzBean clazzBean = new ClazzBean();
		clazzBean.setDataName(table);
		// pm_user-->PmUser
		String tableFormatName = formatFirstUpperName(table);
		// pm_user-->pm.user
		String rightPackage = makeRightPackage(table);
		//clazzBean.setRequestPath(RString.replace(rightPackage, ".  /"));
		clazzBean.setRequestMappingPath(makeRequestMappingPath(table));
		String entityPackage = RString.format(x.getEntityPackage(), rightPackage, tableFormatName);
		String entityName = RString.right(entityPackage, ".");
		clazzBean.setEntityName(entityName);
		clazzBean.setEntityAliasName(RString.firstLower(entityName));
		// 生成包全路径
		String packageName = RString.format(x.getPackagePath(), rightPackage);
		clazzBean.setPackageName(packageName);

		// 类包全路径(实体起始路径+包路径)
		clazzBean.setClassName(tableFormatName);
		clazzBean.setClassAliasName(RString.firstLower(tableFormatName));
		// ////////////////////////////////////////////////////////////////////////////////////////////////////////
		List<String> importList = new ArrayList<String>();
		importList.add(entityPackage);// 实体包
		String servicePackage = RString.format(x.getServicePackage(), rightPackage, tableFormatName);
		importList.add(servicePackage);// 业务包
		clazzBean.setImportList(importList);

		// 文件(起始路径+包路径+文件名+扩展名)
		String buildFileName = "";//makeFilePath(x.getBuildPath(), rightPackage, tableFormatName, x.getFileNameTempLet(), bulidBean.getBulidTypeCd());
		return bulidFile(bulidBean.getBulidTypeCd(), x.getTempletFilePath(), x.getTempletFile(), buildFileName, clazzBean);
	}

	private String buildSqlTable(BuildBean bulidBean, String type) {
		XBaseConfigBean x = RConfig.find(eleList, type);
		if (RObject.isEmpty(x)) {
			return null;
		}
		String table = bulidBean.getTableCode();
		ClazzBean clazzBean = new ClazzBean();
		clazzBean.setDataName(table);
		// pm_user-->PmUser
		String entityName = formatFirstUpperName(table);
		clazzBean.setEntityName(entityName);
		clazzBean.setEntityAliasName(RString.firstLower(entityName));
		// ////////////////////////////////////////////////////////////////////////////////////////////////////////
		boolean isSuccess = buildFileContext(bulidBean.getDatasourceId(), bulidBean.getTableId(), bulidBean.getDatasourceCode(), table, clazzBean, bulidBean
				.getDbSource());
		if (!isSuccess) {
			return null;
		}
		// 生成文件名全路径 预览不需要路径
		String buildFileName = "";//makeFilePath(x.getBuildPath(), rightPackage, entityName, x.getFileNameTempLet(), bulidBean.getBulidTypeCd());
		return bulidFile(bulidBean.getBulidTypeCd(), x.getTempletFilePath(), x.getTempletFile(), buildFileName, clazzBean);
	}

	/**
	 * 制作全路径文件名(起始路径+包路径+文件名+扩展名)
	 * 
	 * @param buildPath
	 *            起始路径
	 * @param rightPackage
	 *            右侧包
	 * @param fileName
	 *            文件名
	 * @param fileNameTemplet
	 *            文件名模板{文件名}.扩展名
	 * @param typeCd
	 *            P预览或B编译生成
	 * @return
	 */
	/*private String makeFilePath(String buildPath, String rightPackage, String fileName, String fileNameTemplet, String typeCd) {
		String filePath = RString.format(buildPath, rightPackage) + File.separatorChar;
		filePath = RFile.makeFilename(RString.replace(filePath, RSymbol.POINT, File.separatorChar));
		if (RString.equals(typeCd, RVelocity.TYPE_BUILD)) {
			// 生成文件目录
			RFile.makeFileDirectory(filePath);
		}

		return filePath + RString.format(fileNameTemplet, fileName);
	}*/

	/**
	 * <p>
	 * 制作右边包体
	 * </p>
	 * 表规则:{0}_{1}_{2}以此类推，
	 * <ul>
	 * 生成规则
	 * <li>1、"_"符合大于2时，截取最后一位"_"替换成"."，当作包结束路径</li>
	 * <li>2、"_"符合小于2时，将"_"替换成".",当成包结束路径</li>
	 * </UL>
	 * 
	 * @param packagePath
	 *            包路径
	 * @param table
	 *            表名
	 * @return String
	 */
	private String makeRightPackage(String table) {
		String rightPackage = "";
		table = table.toLowerCase();
		String[] arry = table.split("_");
		if (arry.length > 2) {
			// 获取截取最后一位符号的替换成点，当作包结束路径
			rightPackage = RString.replace(RString.left(table, table.lastIndexOf(RSymbol.UNDERLINE)), RSymbol.UNDERLINE, RSymbol.POINT);
		} else {
			rightPackage = RString.replace(table, RSymbol.UNDERLINE, RSymbol.POINT);
		}
		return rightPackage;
	}

	/**
	 * 生成主要的文件内容
	 * 
	 * @param datasourceId
	 *            数据源编号
	 * @param tableId
	 *            表编号
	 * @param datasourceCode
	 *            数据源代码
	 * @param tableName
	 *            表名
	 * @param clazzBean
	 *            类实体
	 * @param dbSource
	 *            数据源来源(db数据库系统表, ds自定义表)
	 */
	private boolean buildFileContext(Integer datasourceId, Integer tableId, String datasourceCode, String tableName, ClazzBean clazzBean, String dbSource) {
		List<String> importList = new ArrayList<String>();
		List<FieldBean> fieldList = new ArrayList<FieldBean>();
		List<MethodBean> methodList = new ArrayList<MethodBean>();
		List<DsColumn> dsColumnList = null;
		if (dbSource_ds.equals(dbSource)) {
			DsColumn search = new DsColumn();
			search.setDatasourceId(datasourceId);
			search.setTableId(tableId);
			dsColumnList = dsColumnService.findList(search, null, null, null);
		} else {
			dsColumnList = columnsService.findList(datasourceCode, tableName);
		}
		if (RObject.isEmpty(dsColumnList)) {
			_logger.info(  "buildFileContext  dsColumnList is null  ");
			return false;
		}
		for (int j = 0; j < dsColumnList.size(); j++) {
			DsColumn c = dsColumnList.get(j);
			String importPack = RDataType.formatDataTypePack(c.getDataType());
			if (RString.isNotBlank(importPack) && !importList.contains(importPack)) {
				importList.add(importPack);
			}
			fieldList.add(bulidFieldBean(c));
			methodList.add(bulidMethodBean(c));
		}
		clazzBean.setFieldList(fieldList);
		clazzBean.setImportList(importList);
		clazzBean.setMethodList(methodList);
		return true;
	}

	

	/**
	 * 字段
	 * 
	 * @param dataType
	 *            数据类型
	 * @param fieldName
	 *            字段名称
	 * @param dsColumn
	 *            字段实体
	 * @return FieldBean
	 */
	private FieldBean bulidFieldBean(DsColumn dsColumn) {
		FieldBean field = new FieldBean();
		field.setDbDataType(dsColumn.getDataType());
		field.setDataType(RDataType.formatDataType(dsColumn.getDataType()));
		field.setMyBatisDataType(RDataType.formatMybatisDataType(dsColumn.getDataType()));
		field.setName(RString.joinFirstLower(dsColumn.getCode(), RSymbol.underline()));
		field.setDataName(dsColumn.getCode());
		field.setLabel(dsColumn.getLabel());
		String node = RString.isBlank(dsColumn.getNote()) ? "" : dsColumn.getNote();
		field.setNote(node);
		String defaultValue = RString.isBlank(dsColumn.getDefaultValue()) ? "" : dsColumn.getDefaultValue();
		field.setDefaultValue(defaultValue);
		String typeCd = RString.isBlank(dsColumn.getTypeCd()) ? "R" : dsColumn.getTypeCd();
		field.setTypeCd(typeCd);
		String isNull = RString.isBlank(dsColumn.getIsNull()) ? "Y" : dsColumn.getIsNull();
		field.setIsNull(isNull);
		String dataLength = "";
		if (RString.isNotBlank(dsColumn.getDataLength())) {
			dataLength = dsColumn.getDataLength();
		}
		field.setDataLength(dataLength);
		if (RString.isNotBlank(dsColumn.getIsPk()) && "Y".equals(dsColumn.getIsPk())) {
			field.setIsPk("Y");
			field.setIsNull("N");
		} else {
			field.setIsPk("N");
		}
		String isUnique = RString.isBlank(dsColumn.getIsUnique()) ? "" : dsColumn.getIsUnique();
		field.setIsUnique(isUnique);
		return field;
	}

	/**
	 * 方法
	 * 
	 * @param dsColumn
	 *            字段实体
	 * @return MethodBean
	 */
	private MethodBean bulidMethodBean(DsColumn dsColumn) {
		MethodBean method = new MethodBean();
		String fieldName = RString.joinFirstLower(dsColumn.getCode(), RSymbol.underline());
		method.setName(RString.firstUpper(fieldName));
		method.setParamName(fieldName);
		String dataType = RDataType.formatDataType(dsColumn.getDataType());
		method.setParamType(dataType);
		method.setResultType(dataType);
		return method;
	}

	/**
	 * 生成文件
	 * 
	 * @param typeCd
	 *            P预览或B编译生成
	 * @param resourcePath
	 *            资源路径
	 * @param templateName
	 *            模板名称
	 * @param buildFileName
	 *            生成的文件名
	 * @param object
	 *            对象
	 */
	private String bulidFile(String typeCd, String resourcePath, String templateName, String buildFileName, Object object) {
		parameterMap.put(RVelocity.KEY_DATA, object);
		if (RString.equals(typeCd, RVelocity.TYPE_BUILD)) {
			RVelocity.bulid(resourcePath, templateName, buildFileName, parameterMap, encode);
			return "S";
		} else if (RString.equals(typeCd, RVelocity.TYPE_PREVIEW)) {
			return RVelocity.preview(resourcePath, templateName, buildFileName, parameterMap, encode);
		}
		return null;
	}

	private String getTypes() {
		StringBuffer types = new StringBuffer();
		types.append(EComponentType.Bean.toString() + RSymbol.COMMA);
		types.append(EComponentType.Dao.toString() + RSymbol.COMMA);
		types.append(EComponentType.Service.toString() + RSymbol.COMMA);
		types.append(EComponentType.ServiceImpl.toString() + RSymbol.COMMA);
		types.append(EComponentType.Mybatis.toString() + RSymbol.COMMA);
		types.append(EComponentType.Action.toString());
		return types.toString();
	}

	/**
	 * pm_user转PmUser
	 * 
	 * @param table
	 * @return
	 */
	private String formatFirstUpperName(String table) {
		return RString.joinFirstUpper(table, RSymbol.underline());
	}

	private String makeRequestMappingPath(String table) {
		String[] array = RString.split(table, RSymbol.UNDERLINE);
		StringBuffer requestMappingPath = new StringBuffer();
		requestMappingPath.append(array[0] + "/");
		if (array.length == 2) {
			requestMappingPath.append(array[1]);
		} else if (array.length > 2) {
			for (int i = 1; i < array.length; i++) {
				requestMappingPath.append(RString.firstUpper(array[i]));
			}
		}
		return requestMappingPath.toString();
	}

}
