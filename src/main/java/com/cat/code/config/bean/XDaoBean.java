package com.cat.code.config.bean;

import java.io.Serializable;

import org.jdom2.Element;

/**
 * 解析xml中DAO数据
 * @author ZengDeGuan
 */
public class XDaoBean
      extends XBaseConfigBean
      implements
         Serializable{

   private static final long serialVersionUID = 1L;

   public XDaoBean(Element node){
      super(node);
   }

}
