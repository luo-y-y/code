package com.cat.code.config.xconfig;

import java.util.List;
import java.util.Map;

import org.jdom2.Element;

import com.cat.common.lang.RList;



public class XConfigComponent
      extends XBaseConfig{

   public static final String NAME = "Component";


   public static List<Element> loadConfig(Element element,Map<String, Object> defineMap){
	   List<Element> list = element.getChildren(NAME);
		if (RList.isBlank(list)) {
			return null;
		}
		for (Element chilElement : list) {
			//处理property
			XConfigProperty.loadConfig(chilElement, defineMap);
		}
		return list;
   }
}
