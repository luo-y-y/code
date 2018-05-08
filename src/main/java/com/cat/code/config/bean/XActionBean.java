package com.cat.code.config.bean;

import java.io.Serializable;

import org.jdom2.Element;

public class XActionBean
      extends XBaseConfigBean
      implements
         Serializable{

   private static final long serialVersionUID = 1L;

   public static final String PTY_SERVICE_PACKAGE = "servicePackage";

   public XActionBean(Element node){
      super(node);
     
   }

}
