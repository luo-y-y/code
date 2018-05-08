package com.cat.code.action.ds;
/// ***********************import begin***********************
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cat.code.bean.ds.DsTable;
import com.cat.code.service.ds.DsTableService;
import com.cat.common.bean.EOperation;
import com.cat.common.bean.PageControlInfo;
import com.cat.common.bean.RResult;
import com.cat.common.bean.tree.Node;
import com.cat.common.json.RJson;
import com.cat.common.lang.RString;
import com.cat.common.reflect.RReflectUtils;
import com.cat.sy.bean.SyUser;
import com.config.action.WebBaseAction;

/// ***********************import end*************************
@RequestMapping("code/ds/table")
@Controller
@Scope("prototype")
public class DsTableAction
      extends WebBaseAction{
   
   @Autowired
   private DsTableService dsTableService;
   /**
    * 请求访问路径
    */
   private static final String requestPath = "code/ds/table/";
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
      return requestPath+"dsTableList";
   }
   
   /**
    * 新增页面
    */
   @RequestMapping("goAdd")
   public String goAdd(){
      setAttributes();
      request.setAttribute("operate", EOperation.Add.value());
      return requestPath+"dsTableForm";
   }

   /**
    * 查看页面
    */
   @RequestMapping("goView")
   public String goView(){
      setAttributes();
      request.setAttribute("operate", EOperation.View.value());
      return requestPath+"dsTableForm";
   }

   /**
    * 编辑页面
    */
   @RequestMapping("goEdit")
   public String goEdit(){
      setAttributes();
      request.setAttribute("operate", EOperation.Update.value());
      return requestPath+"dsTableForm";
   }

   /**
    * 历史列表页面
    * @return
    */
   @RequestMapping("goViewHistory")
   public String goViewHistory(){
      setAttributes();
      return requestPath+"dsTableHsList";
   }
   
   /**
    * 历史页面
    * @return
    */
   @RequestMapping("goViewHistoryForm")
   public String goViewHistoryForm(){
      setAttributes();
      request.setAttribute("operate", EOperation.History.value());
      return requestPath+"dsTableForm";
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
            DsTable entity = new DsTable();
            RReflectUtils.getObjectListForMap(entity, map);
            entity.setCreateUserId(syUser.getId());
            save(entity);
            return;
         }
         update(id, syUser);
      } catch (Exception e) {
         printWriterJson(new RResult(RResult.MSG_FAIL));
         _logger.error("doSave", e);
      }
   }

   /**
    * 保存逻辑
    */
   private void save(DsTable entity){
      Integer id = dsTableService.save(entity);
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
      DsTable oldEntity = dsTableService.load(Integer.parseInt(id));
      if(null == oldEntity) {
         printWriterJson(new RResult(RResult.MSG_FAIL,RResult.recordNotExist));
         return;
      }
      DsTable newEntity = new DsTable();
      RReflectUtils.getObjectForObject(newEntity, oldEntity);
      Map<String, String[]> map = getRequestParameterMap();
      RReflectUtils.getObjectListForMap(newEntity, map);
      newEntity.setUpdateUserId(syUser.getId());
      RResult info = dsTableService.update(oldEntity, newEntity);
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
            bool = dsTableService.deleteByIds(ids);
         } else {
            bool = dsTableService.delete(Integer.parseInt(ids));
         }
         if(bool){
            printWriterJson(new RResult(RResult.MSG_SUCCESS));
         }else{
            printWriterJson(new RResult(RResult.MSG_FAIL));
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
      DsTable entity = dsTableService.load(Integer.parseInt(id));
      getPrintWriter().write(RJson.getJsonStr(entity));
   }
   
   /**
    * 列表查询
    */
   @RequestMapping("findPageList")
   public void findPageList(){
      try {
         Map<String,String[]> map = getRequestParameterMap();
         DsTable entity = new DsTable();
         RReflectUtils.getObjectListForMap(entity, map);
         PageControlInfo pageInfo = dsTableService.findPageList(entity, getPage(), getEnd(), loadOsearch());
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
         DsTable entity = new DsTable();
         PageControlInfo pageInfo = dsTableService.findPageHsList(entity, getPage(), getEnd(), null);
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
      DsTable entity = dsTableService.loadHs(Integer.parseInt(id));
      getPrintWriter().write(RJson.getJsonStr(entity));
   }
   /// ***********************method begin***********************
   /**
    * 目录树
    */
   @RequestMapping("goTableCatalog")
   public String goTableCatalog(){
      setAttributes();
      return requestPath+"dsTableCatalog";
   }
   /**
    * 列表查询
    */
   @RequestMapping("findCatalog")
   public void findCatalog(){
      try {
         Map<String,String[]> map = getRequestParameterMap();
         DsTable entity = new DsTable();
         RReflectUtils.getObjectListForMap(entity, map);
         List<DsTable> dsTableList = dsTableService.findList(entity, getPage(), getEnd(), loadOsearch());
         List<Node> list = new ArrayList<Node>();
         for(DsTable node : dsTableList){
            Node n = new Node();
            RReflectUtils.getObjectForObject(n, node);
            list.add(n);
         }
         getTreeJson(list);
      } catch (Exception e) {
         _logger.error("findPageList", e);
      }
   }

   /// ***********************method end*************************

}
