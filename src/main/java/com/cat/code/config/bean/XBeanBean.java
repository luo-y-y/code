package com.cat.code.config.bean;

import java.io.Serializable;

import org.jdom2.Element;

public class XBeanBean
      extends XBaseConfigBean
      implements
         Serializable{

   private static final long serialVersionUID = 1L;

   public XBeanBean(Element node){
      super(node);
   }
}
