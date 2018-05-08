package com.cat.code.config.bean;

import java.util.List;

import org.jdom2.Element;

import com.cat.code.config.xconfig.XConfigProperty;
import com.cat.common.lang.RList;
import com.cat.common.lang.RString;

public class XBaseConfigBean {

	public static final String PTY_NAME = "name";

	public static final String PTY_LABEL = "label";

	public static final String PTY_VALUE = "value";

	public static final String PTY_TYPE = "type";

	public static final String PTY_BUILD_PATH = "buildPath";

	public static final String PTY_FILE_NAME_PREFIX = "fileNamePrefix";

	public static final String PTY_FILE_NAME_SUFFIX = "fileNameSuffix";

	public static final String PTY_FILE_NAME_TEMPLET = "fileNameTempLet";

	public static final String PTY_TEMPLET_FILE_PATH = "templetFilePath";

	public static final String PTY_TEMPLET_FILE = "templetFile";

	public static final String PTY_PACKAGE_PATH = "packagePath";

	public static final String PTY_ENTITY_PACKAGE = "entityPackage";

	public static final String PTY_IMPL_INTERFACE = "implInterface";

	public static final String PTY_SUPER_CLASS_PACKAGE = "superClassPackage";

	public static final String PTY_SERVICE_CLASS_PACKAGE = "servicePackage";
	
	public static final String PTY_DAO_PACKAGE = "daoPackage";
	
	public XBaseConfigBean(Element ele) {
		build(ele);
	}

	/**
	 * 生成java文件的路径
	 */
	public String buildPath;

	/**
	 * 文件名前缀
	 */
	public String fileNamePrefix;

	/**
	 * 文件名后缀
	 */
	public String fileNameSuffix;

	/**
	 * 文件名模板
	 */
	public String fileNameTempLet;

	/**
	 * 模板文件的路径
	 */
	public String templetFilePath;

	/**
	 * 模板文件
	 */
	public String templetFile;

	/**
	 * 包路径
	 */
	public String packagePath;

	/**
	 * 实体包
	 */
	public String entityPackage;

	/**
	 * 所实现的接口
	 */
	private String implInterface;

	/**
	 * 超类
	 */
	public String superClass;

	/**
	 * 超类包
	 */
	public String superClassPackage;

	/**
	 * 超类包
	 */
	public String servicePackage;

	/**
	 * 超类包
	 */
	public String daoPackage;

	
	public void build(Element ele) {
		List<Element> list = ele.getChildren(XConfigProperty.NAME);
		if (RList.isBlank(list)) {
			return;
		}
		for (Element propertyNode : list) {
			String name = propertyNode.getAttributeValue(PTY_NAME);
			String value = propertyNode.getAttributeValue(PTY_VALUE);
			if (RString.isBlank(name) || RString.isBlank(value)) {
				continue;
			}
			set(name, value);
		}
	}

	public void set(String name, String value) {
		if (PTY_BUILD_PATH.equals(name)) {
			this.buildPath = value;
		} else if (PTY_FILE_NAME_PREFIX.equals(name)) {
			this.fileNamePrefix = value;
		} else if (PTY_FILE_NAME_SUFFIX.equals(name)) {
			this.fileNameSuffix = value;
		} else if (PTY_FILE_NAME_TEMPLET.equals(name)) {
			this.fileNameTempLet = value;
		} else if (PTY_TEMPLET_FILE_PATH.equals(name)) {
			this.templetFilePath = value;
		} else if (PTY_TEMPLET_FILE.equals(name)) {
			this.templetFile = value;
		} else if (PTY_PACKAGE_PATH.equals(name)) {
			this.packagePath = value;
		} else if (PTY_ENTITY_PACKAGE.equals(name)) {
			this.entityPackage = value;
		} else if (PTY_IMPL_INTERFACE.equals(name)) {
			this.implInterface = value;
		} else if (PTY_SUPER_CLASS_PACKAGE.equals(name)) {
			this.superClassPackage = value;
			this.superClass = RString.right(value, ".");
		} else if (PTY_SERVICE_CLASS_PACKAGE.equals(name)){
			this.servicePackage = value;
		}else if (PTY_DAO_PACKAGE.equals(name)){
			this.daoPackage = value;
		}
	}

	public String getBuildPath() {
		return buildPath;
	}

	public void setBuildPath(String buildPath) {
		this.buildPath = buildPath;
	}

	public String getTempletFilePath() {
		return templetFilePath;
	}

	public void setTempletFilePath(String templetFilePath) {
		this.templetFilePath = templetFilePath;
	}

	public String getTempletFile() {
		return templetFile;
	}

	public void setTempletFile(String templetFile) {
		this.templetFile = templetFile;
	}

	public String getPackagePath() {
		return packagePath;
	}

	public void setPackagePath(String packagePath) {
		this.packagePath = packagePath;
	}

	public String getEntityPackage() {
		return entityPackage;
	}

	public void setEntityPackage(String entityPackage) {
		this.entityPackage = entityPackage;
	}

	public String getFileNameTempLet() {
		return fileNameTempLet;
	}

	public void setFileNameTempLet(String fileNameTempLet) {
		this.fileNameTempLet = fileNameTempLet;
	}

	public String getImplInterface() {
		return implInterface;
	}

	public void setImplInterface(String implInterface) {
		this.implInterface = implInterface;
	}

	public String getSuperClass() {
		return superClass;
	}

	public void setSuperClass(String superClass) {
		this.superClass = superClass;
	}

	public String getSuperClassPackage() {
		return superClassPackage;
	}

	public void setSuperClassPackage(String superClassPackage) {
		this.superClassPackage = superClassPackage;
	}

	public String getFileNamePrefix() {
		return fileNamePrefix;
	}

	public void setFileNamePrefix(String fileNamePrefix) {
		this.fileNamePrefix = fileNamePrefix;
	}

	public String getFileNameSuffix() {
		return fileNameSuffix;
	}

	public void setFileNameSuffix(String fileNameSuffix) {
		this.fileNameSuffix = fileNameSuffix;
	}

	public String getServicePackage() {
		return servicePackage;
	}

	public void setServicePackage(String servicePackage) {
		this.servicePackage = servicePackage;
	}

	public String getDaoPackage() {
		return daoPackage;
	}

	public void setDaoPackage(String daoPackage) {
		this.daoPackage = daoPackage;
	}

}
