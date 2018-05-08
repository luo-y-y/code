package com.cat.code.service.ds;
/// ***********************import begin***********************
import java.util.List;
import java.util.Map;

import com.cat.code.bean.ds.DsTable;
import com.cat.common.bean.PageControlInfo;
import com.cat.common.bean.RResult;


/// ***********************import end*************************

public interface DsTableService{

   /**
    * 保存返回主键
    * @param dsTable 实体
    * @return Integer
    */
   Integer save(DsTable dsTable);

   /**
    * 删除
    * @param id 主键
    * @return boolean(true:成功, false:失败)
    */
   boolean delete(Integer id);

   /**
    * 删除多条数据
    * @param idList	主键列表
    * @return boolean(true:成功, false:失败)
    */
   boolean deleteByIds(String ids);

   /**
    * 修改
    * @param dsTable	实体
    * @return boolean(true:成功, false:失败)
    */
   boolean update(DsTable dsTable);
   
   /**
    * 修改
    * @param oldEntity     旧实体
    * @param newEntity     新实体
    * @param isCheckOver   是否检查版本(Y是，N否)
    * @return FResult
    */
   RResult update(DsTable oldEntity, DsTable newEntity);
   
   /**
    * 根据主键获取实体
    * @param id	主键
    * @return DsTable
    */
   DsTable load(Integer id);

   /**
    * 根据条件获取实体
    * @param dsTable   实体
    * @return DsTable
    */
   DsTable load(DsTable dsTable);
   
   /**
    * 根据条件获取数量
    * @param dsTable	实体
    * @return Integer
    */
   Integer loadCount(DsTable dsTable);

   /**
    * 根据条件检查是否存在
    * @param dsTable	实体
    * @return boolean(true:存在; false:不存在)
    */
   boolean isExist(DsTable dsTable);

   /**
    * 根据条件获取实体列表,当skip、max均等于null获取全部)
    * @param dsTable	实体
    * @param skip	当前页数
    * @param max	页记录数
    * @param params	其他参数
    * @return List<DsTable>
    */
   List<DsTable> findList(DsTable dsTable, Integer skip, Integer max, Map<String, Object> params);
   
   /**
    * 根据条件获取实体分页列表
    * @param dsTable	实体
    * @param skip	        当前页数(当等于null时,返回null)
    * @param max	        页记录数(默认为20)
    * @param params	        其他参数
    * @return PageControlInfo
    */
   PageControlInfo findPageList(DsTable dsTable, Integer skip, Integer max, Map<String, Object> params);
   /**
    * 根据条件获取实体历史操作分页列表
    * @param dsTable	实体
    * @param skip	        当前页数(当等于null时,返回null)
    * @param max	        页记录数(默认为20)
    * @param params	        其他参数
    * @return PageControlInfo
    */
   PageControlInfo findPageHsList(DsTable dsTable, Integer skip, Integer max, Map<String, Object> params);
   /**
    * 根据历史记录ID，获取历史记录
    * @param id      历史表主键
    * @return  DsDatasource
    */
   DsTable loadHs(Integer id);
   /// ***********************method begin***********************

   /// ***********************method end*************************
}
