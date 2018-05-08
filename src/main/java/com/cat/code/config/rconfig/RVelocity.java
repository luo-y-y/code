package com.cat.code.config.rconfig;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.jdom2.Document;
import org.jdom2.input.SAXBuilder;

import com.cat.common.lang.RString;
import com.cat.common.listener.RSystemConfig;


public class RVelocity{

   // key中存在xml_前缀，value值则是xml文件路径
   public static final String KEY_PREFIX_XMLFILE = "xmlFile_";
   public static final String TYPE_BUILD ="B";
   public static final String TYPE_PREVIEW ="P";
   // 模板数据的KEY
   public static final String KEY_DATA = "data";
   // 合并后的内容
   public static String mergeContext = null;
   
   public static  Logger _logger = Logger.getLogger(RVelocity.class);
   
   /**
    * 预览内容
    * 支持List, Object进行解析
    * @param resourcePath     资源路径（模板路径）
    * @param templateName     模板名称（name.vm）
    * @param buildFileName    生成全路径下的文件名称
    * @param parameterMap     参数集
    * @param encoding         编码方式（默认为UTF-8)
    */
   public static String preview(String resourcePath,
                              String templateName,
                              String buildFileName,
                              Map<String, Object> parameterMap,
                              String encoding) {
      exe(TYPE_PREVIEW, resourcePath, templateName, buildFileName, parameterMap, encoding);
      return mergeContext;
   }
   /**
    * 依据模板生成代码及文件
    * 支持List, Object进行解析
    * @param resourcePath     资源路径（模板路径）
    * @param templateName     模板名称（name.vm）
    * @param buildFileName    生成全路径下的文件名称
    * @param parameterMap     参数集
    * @param encoding         编码方式（默认为UTF-8)
    */
   public static void bulid(String resourcePath,
                            String templateName,
                            String buildFileName,
                            Map<String, Object> parameterMap,
                            String encoding){
      exe(TYPE_BUILD, resourcePath, templateName, buildFileName, parameterMap, encoding);
   }
   /**
    * 依据模板生成代码及文件
    * 支持List, Object进行解析
    * @param resourcePath     资源路径（模板路径）
    * @param templateName     模板名称（name.vm）
    * @param buildFileName    生成全路径下的文件名称
    * @param parameterMap     参数集
    * @param encoding         编码方式（默认为UTF-8)
    * 
    */
   private static void exe(String typeCd,
                          String resourcePath,
                          String templateName,
                          String buildFileName,
                          Map<String, Object> parameterMap,
                          String encoding){
      if(parameterMap.isEmpty()){
         _logger.info("bulidparameterMap is null");
         return;
      }
      resourcePath = RSystemConfig.Class_Path+resourcePath;
      BufferedWriter writer = null;
      Template template = null;
      try{
         Velocity.init();
         VelocityContext context = new VelocityContext();
         try{
            VelocityEngine velocityEngine = new VelocityEngine();
            velocityEngine.init(getProperties(resourcePath, encoding));
            template = velocityEngine.getTemplate(templateName);
            context = getVelocityContext(context, parameterMap);
            if(RString.equals(typeCd, TYPE_BUILD)) {
               OutputStreamWriter writerStream = new OutputStreamWriter(new FileOutputStream(buildFileName), encoding);
               writer = new BufferedWriter(writerStream);
               if(null != template){
                  template.merge(context, writer);
               }
               _logger.info("bulid = "+buildFileName+" writerFile success.");
            } else {
               previewContext(template, context, encoding);
               _logger.info("bulid="+buildFileName+" previewContext success." );
            }
         }catch(ResourceNotFoundException e){
            _logger.error("bulidResourceNotFoundException cannot find template={0}{1}:"+resourcePath+templateName,  e);
         }catch(ParseErrorException e){
            _logger.error("bulidParseErrorException Syntax error in template :{0}{1}"+resourcePath+templateName, e);
         }
      }catch(Exception e){
         _logger.error("bulid exception：", e);
      }finally{
         if(writer != null){
            try{
               writer.flush();
               writer.close();
            }catch(Exception e){
               _logger.error("bulid finally exception：", e);
            }
         }
      }
   }
   /**
    * 设置合并后的内容
    * @param template
    * @param context
    * @param buildFileName
    * @param encoding
    */
   private static void previewContext(Template template, VelocityContext context, String encoding) {
      StringWriter writer = new StringWriter();
      template.merge(context, writer);
      if(null != template){
         mergeContext = writer.toString();
      }
   }
   
   
   /**
    * 获取内容
    * @param context       VelocityContext对象
    * @param parameterMap  参数集
    * @return
    */
   @SuppressWarnings({ "rawtypes" })
   private static VelocityContext getVelocityContext(VelocityContext context,
                                                     Map<String, Object> parameterMap){
      Iterator itr = parameterMap.entrySet().iterator();
      while(itr.hasNext()){
         Map.Entry entry = (Map.Entry) itr.next();
         String key = entry.getKey().toString();
         if(RString.startsWith(key, KEY_PREFIX_XMLFILE)){
            key = RString.replace(key, KEY_PREFIX_XMLFILE, "");
            context.put(key, buildDocumentByXmlFileName(entry.getValue().toString()));
         }else{
            context.put(key, entry.getValue());
         }
      }
      return context;
   }

   /**
    * 生成Document
    * @param xmlFileName xml文件
    * @return
    */
   private static Document buildDocumentByXmlFileName(String xmlFileName){
      SAXBuilder builder = null;
      Document root = null;
      try{
         builder = new SAXBuilder();
         root = builder.build(xmlFileName);
      }catch(Exception e){
         e.printStackTrace();
         _logger.error("buildDocument exception：", e);
      }
      return root;
   }

   /**
    * 初始化Velocity配置
    * @param resourcePath  资源路径（模板存放路径）
    * @param encoding      编码
    * @return
    */
   private static Properties getProperties(String resourcePath,
                                           String encoding){
      Properties properties = new Properties();
      properties.setProperty(Velocity.INPUT_ENCODING, encoding);
      properties.setProperty(Velocity.OUTPUT_ENCODING, encoding);
      properties.setProperty(Velocity.FILE_RESOURCE_LOADER_PATH, resourcePath);
      return properties;
   }

}
