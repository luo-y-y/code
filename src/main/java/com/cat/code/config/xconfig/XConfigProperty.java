package com.cat.code.config.xconfig;

import java.util.List;
import java.util.Map;

import org.jdom2.Element;

import com.cat.common.lang.RList;
import com.cat.common.lang.RString;

public class XConfigProperty
      extends XBaseConfig{

   public static final String NAME = "Property";

  

   public static void loadConfig(Element root,Map<String, Object> defineMap){
	   List<Element> inEleList = root.getChildren(NAME);
	   if(RList.isBlank(inEleList)){
		   return ;
	   }
	   
      // 查找include文件，并加载
      for(Element inEle : inEleList){
    	  String v = inEle.getAttributeValue(PTY_VALUE);
    	  if(RString.isNotBlank(v)){
    		  v = XConfigDefine.formatDisplay(v,defineMap);
    		  inEle.setAttribute(PTY_VALUE, v);
    	  }
      }
      
   }


}
