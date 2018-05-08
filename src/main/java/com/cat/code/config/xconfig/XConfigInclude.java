package com.cat.code.config.xconfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jdom2.Element;

import com.cat.code.config.FConfigConsole;
import com.cat.common.lang.RList;

public class XConfigInclude extends XBaseConfig{

   // Include标签
   public final static String NAME = "Include";

	public static List<Element> loadConfig(Element root,
							String filePath,
                          Map<String, Object> map){
      List<Element> inEleList = root.getChildren(NAME);
	   if(RList.isBlank(inEleList)){
		   return null;
	   }
	   
	  List<Element> list = new ArrayList<Element>(); 
      // 查找include文件，并加载
      for(Element inEle : inEleList){
         String fileName = XConfigDefine.formatDisplay(inEle.getTextTrim(),map);
         Element xml = FConfigConsole.loadFromPath(filePath + fileName);
         if(null == xml){
            continue;
         }
         list.add(xml);
      }
      return list;
   }
}
