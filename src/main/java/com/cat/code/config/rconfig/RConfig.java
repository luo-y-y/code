package com.cat.code.config.rconfig;

import java.util.List;
import java.util.Map;

import org.jdom2.Element;

import com.cat.code.config.bean.EComponentType;
import com.cat.code.config.bean.XActionBean;
import com.cat.code.config.bean.XBaseConfigBean;
import com.cat.code.config.bean.XBeanBean;
import com.cat.code.config.bean.XDaoBean;
import com.cat.code.config.bean.XMybatisBean;
import com.cat.code.config.bean.XServiceImplBean;
import com.cat.common.lang.RList;
import com.cat.common.lang.RString;

public class RConfig {

	public static XBaseConfigBean baseBan = null;

	public static XBeanBean xBean = null;

	public static XDaoBean xDao = null;

	public static XMybatisBean xMybatisBean = null;

	public static XServiceImplBean xServiceImplBean = null;

	public static XActionBean xAcitonBean = null;

	public static void putAllDefine(Map<String, Object> initMap, Map<String, Object> map) {
		for (String key : initMap.keySet()) {
			Object v = initMap.get(key);
			String k = RString.replace(key, RSymbol.POINT, RSymbol.UNDERLINE);
			map.put(k, v);
		}
	}

	public static XBaseConfigBean find(List<Element> list, String type) {
		if (RList.isBlank(list)) {
			return baseBan;
		}
		for (Element element : list) {
			if (type.equalsIgnoreCase(element.getAttributeValue(XBaseConfigBean.PTY_TYPE))) {
				baseBan = new XBaseConfigBean(element);
				break;
			}
		}
		return baseBan;
	}


	public static XBeanBean findBean(List<Element> list) {
		if (RList.isBlank(list)) {
			return null;
		}
		for (Element element : list) {
			if (EComponentType.Bean.toString().equalsIgnoreCase(element.getAttributeValue(XBaseConfigBean.PTY_TYPE))) {
				xBean = new XBeanBean(element);
				break;
			}
		}
		return xBean;
	}

	public static XDaoBean findDao(List<Element> list) {
		if (RList.isBlank(list)) {
			return null;
		}
		for (Element element : list) {
			if ( EComponentType.Dao.toString().equalsIgnoreCase(element.getAttributeValue(XBaseConfigBean.PTY_TYPE))) {
				xDao = new XDaoBean(element);
				break;
			}
		}
		return xDao;
	}

	public static XMybatisBean findMybatis(List<Element> list) {
		if (RList.isBlank(list)) {
			return null;
		}
		for (Element element : list) {
			if ( EComponentType.Mybatis.toString().equalsIgnoreCase(element.getAttributeValue(XBaseConfigBean.PTY_TYPE))) {
				xMybatisBean = new XMybatisBean(element);
				break;
			}
		}
		return xMybatisBean;
	}

	public static XServiceImplBean findServiceImpl(List<Element> list) {
		if (RList.isBlank(list)) {
			return null;
		}
		for (Element element : list) {
			if ( EComponentType.ServiceImpl.toString().equalsIgnoreCase(element.getAttributeValue(XBaseConfigBean.PTY_TYPE))) {
				xServiceImplBean = new XServiceImplBean(element);
				break;
			}
		}
		return xServiceImplBean;
	}

	public static XActionBean findAction(List<Element> list) {
		if (RList.isBlank(list)) {
			return null;
		}
		for (Element element : list) {
			if ( EComponentType.Action.toString().equalsIgnoreCase(element.getAttributeValue(XBaseConfigBean.PTY_TYPE))) {
				xAcitonBean = new XActionBean(element);
				break;
			}
		}
		return xAcitonBean;
	}
}
