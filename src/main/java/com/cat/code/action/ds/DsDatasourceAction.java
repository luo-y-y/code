package com.cat.code.action.ds;
/// ***********************import begin***********************
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cat.code.bean.ds.DsDatasource;
import com.cat.code.service.ds.DsDatasourceService;
import com.cat.common.bean.EOperation;
import com.cat.common.bean.PageControlInfo;
import com.cat.common.bean.RResult;
import com.cat.common.json.RJson;
import com.cat.common.lang.RString;
import com.cat.common.reflect.RReflectUtils;
import com.cat.sy.bean.SyUser;
import com.config.action.WebBaseAction;

/// ***********************import end*************************
@RequestMapping("code/ds/datasource")
@Controller
@Scope("prototype")
public class DsDatasourceAction
      extends WebBaseAction{
   
   @Autowired
   private DsDatasourceService dsDatasourceService;
   /**
    * 请求访问路径
    */
   private static final String requestPath = "code/ds/datasource/";
   /// ***********************define begin***********************

   /// ***********************define end*************************
   /**
    * 介绍页面
    */
   @RequestMapping("goIntroduce")
   public String goIntroduce(){
      setAttributes();
      return requestPath+"introduce";
   }

   /**
    * 主页面
    */
   @RequestMapping("goMain")
   public String goMain(){
      setAttributes();
      return requestPath+"dsDatasourceList";
   }
   
   /**
    * 新增页面
    */
   @RequestMapping("goAdd")
   public String goAdd(){
      setAttributes();
      request.setAttribute("operate", EOperation.Add.value());
      return requestPath+"dsDatasourceForm";
   }

   /**
    * 查看页面
    */
   @RequestMapping("goView")
   public String goView(){
      setAttributes();
      request.setAttribute("operate", EOperation.View.value());
      return requestPath+"dsDatasourceForm";
   }

   /**
    * 编辑页面
    */
   @RequestMapping("goEdit")
   public String goEdit(){
      setAttributes();
      request.setAttribute("operate", EOperation.Update.value());
      return requestPath+"dsDatasourceForm";
   }

   /**
    * 历史列表页面
    * @return
    */
   @RequestMapping("goViewHistory")
   public String goViewHistory(){
      setAttributes();
      return requestPath+"dsDatasourceHsList";
   }
   
   /**
    * 历史页面
    * @return
    */
   @RequestMapping("goViewHistoryForm")
   public String goViewHistoryForm(){
      setAttributes();
      request.setAttribute("operate", EOperation.History.value());
      return requestPath+"dsDatasourceForm";
   }
   
   /**
    * 保存/更新
    */
   @RequestMapping("doSave")
   public void doSave(){
      try {
         SyUser syUser = getSessionUser();
         String id = getRequestParameter("id");
         if(RString.isBlank(id) || id.equals("0")){
            Map<String, String[]> map = getRequestParameterMap();
            DsDatasource entity = new DsDatasource();
            RReflectUtils.getObjectListForMap(entity, map);
            entity.setCreateUserId(syUser.getId());
            save(entity);
            return;
         }
         update(id, syUser);
      } catch (Exception e) {
         _logger.error("doSave", e);
      }
   }

   /**
    * 保存逻辑
    */
   private void save(DsDatasource entity){
      Integer id = dsDatasourceService.save(entity);
      if(id >0){
         printWriterJson(new RResult(RResult.MSG_SUCCESS));
         return;
      }
      printWriterJson(new RResult(RResult.MSG_FAIL));
   }

   /**
    * 修改逻辑
    */
   private void update(String id, SyUser syUser){
      DsDatasource oldEntity = dsDatasourceService.load(Integer.parseInt(id));
      if(null == oldEntity) {
         _logger.info("updateupdate fail record not exist, param[id={0}]"+id);
         printWriterJson(new RResult(RResult.MSG_FAIL,RResult.recordNotExist));
         return;
      }
      DsDatasource newEntity = new DsDatasource();
      RReflectUtils.getObjectForObject(newEntity, oldEntity);
      Map<String, String[]> map = getRequestParameterMap();
      RReflectUtils.getObjectListForMap(newEntity, map);
      newEntity.setUpdateUserId(syUser.getId());
      String isCheckOver = "Y";
      if(null != map.get(ISCHECKOVER)) {
         isCheckOver = map.get(ISCHECKOVER).toString();
      }
      RResult info = dsDatasourceService.update(oldEntity, newEntity, isCheckOver);
      printWriterJson(info);
   }

   /**
    * 删除
    */
   @RequestMapping("doDelete")
   public void doDelete(){
      try {
         String ids = getRequestParameter("ids");
         if(RString.isBlank(ids)){
	        printWriterJson(new RResult(RResult.MSG_FAIL,RResult.paramNull));
	        return;
         }
         String[] values = RString.split(ids, ",");
         boolean bool = false;
         if(values.length > 1) {
            bool = dsDatasourceService.deleteByIds(ids);
         } else {
            bool = dsDatasourceService.delete(Integer.parseInt(ids));
         }
         if(bool){
            printWriterJson(new RResult(RResult.MSG_SUCCESS));
         }else{
            printWriterJson(new RResult(RResult.MSG_FAIL));
            _logger.info( "delete fail, param[ids={0}] ids");
         }
      } catch (Exception e) {
         _logger.error("doDelete", e);
      }
   }

   /**
    * 根据ID加载记录
    */
   @RequestMapping("load")
   public void load(){
      String id = getRequestParameter("id");
      if(RString.isBlank(id)){
         printWriterJson(new RResult(RResult.MSG_FAIL,RResult.paramNull));
         return;
      }
      DsDatasource entity = dsDatasourceService.load(Integer.parseInt(id));
      getPrintWriter().write(RJson.getJsonStr(entity));
   }
   
   /**
    * 列表查询
    */
   @RequestMapping("findPageList")
   public void findPageList(){
      try {
         Map<String,String[]> map = getRequestParameterMap();
         DsDatasource entity = new DsDatasource();
         RReflectUtils.getObjectListForMap(entity, map);
         PageControlInfo pageInfo = dsDatasourceService.findPageList(entity, getPage(), getEnd(), loadOsearch());
         printWriterJson(pageInfo);
      } catch (Exception e) {
         _logger.error("findPageList", e);
      }
   }
   /**
    * 历史列表查询
    */
   @RequestMapping("findPageHsList")
   public void findPageHsList(){
      try {
         String recordId = getRequestParameter("recordId");
         if(RString.isBlank(recordId)){
            printWriterJson(new RResult(RResult.MSG_FAIL,RResult.paramNull));
            return;
         }
         DsDatasource entity = new DsDatasource();
         PageControlInfo pageInfo = dsDatasourceService.findPageHsList(entity, getPage(), getEnd(), null);
         printWriterJson(pageInfo);
      } catch (Exception e) {
         _logger.error("findPageHsList", e);
      }
   }
   
   /**
    * 根据ID加载历史记录
    */
   @RequestMapping("loadHs")
   public void loadHs(){
      String id = getRequestParameter("id");
      if(RString.isBlank(id)){
         printWriterJson(new RResult(RResult.MSG_FAIL,RResult.paramNull));
         return;
      }
      DsDatasource entity = dsDatasourceService.loadHs(Integer.parseInt(id));
      getPrintWriter().write(RJson.getJsonStr(entity));
   }
   /// ***********************method begin***********************

   /// ***********************method end*************************

}
