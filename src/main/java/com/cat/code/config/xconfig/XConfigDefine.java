package com.cat.code.config.xconfig;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom2.Element;

import com.cat.common.lang.RList;
import com.cat.common.lang.RString;

public class XConfigDefine extends XBaseConfig {

	// Define标签
	public static final String NAME = "Define";

	public static void parse(Element element, Map<String, Object> map) {
		List<Element> list = element.getChildren(NAME);
		if (RList.isBlank(list)) {
			return;
		}
		Map<String, Object> defines = new HashMap<String, Object>();
		for (Element chilElement : list) {
			// 定义放在MAP 中
			String name = chilElement.getAttributeValue(PTY_NAME);
			String value = chilElement.getTextTrim();
			defines.put(name, value);
			value = formatDisplay(chilElement.getTextTrim(), defines);
			map.put(name, value);
		}
	}

	public static String formatDisplay(String value, Map<String, Object> defines) {
		int start = 0;
		while ((start = value.indexOf("${")) != -1) {
			int end = value.indexOf("}", start);
			if (end != -1) {
				String sub = value.substring(start + 2, end);
				String parse = RString.toString(defines.get(sub));
				if (parse == null) {
					parse = "";
				}
				value = value.substring(0, start) + parse + value.substring(end + 1);
			}
		}
		return value;
	}
}
