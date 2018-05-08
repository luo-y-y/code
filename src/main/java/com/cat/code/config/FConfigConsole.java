package com.cat.code.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.input.SAXBuilder;

import com.cat.code.config.xconfig.XConfigComponent;
import com.cat.code.config.xconfig.XConfigDefine;
import com.cat.common.lang.RList;

public class FConfigConsole {

	public static List<Element> parse(String filePath, String fileName, Map<String, Object> map) {

		Element root = loadFromPath(filePath + fileName);
		XConfigDefine.parse(root, map);

		List<Element> comList = new ArrayList<Element>();
		// 对引入文件做加载

		List<Element> coms = XConfigComponent.loadConfig(root, map);
		if (RList.isNotBlank(coms)) {
			comList.addAll(coms);
		}
		// 加载组件
		return comList;

	}

	public static Element loadFromPath(String path) {
		try {
			SAXBuilder builder = new SAXBuilder();
			Document document = builder.build(new FileInputStream(new File(path)));
			return document.getRootElement();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
