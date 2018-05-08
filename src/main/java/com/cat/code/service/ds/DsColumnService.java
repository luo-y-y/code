package com.cat.code.service.ds;
/// ***********************import begin***********************
import java.util.List;
import java.util.Map;

import com.cat.code.bean.ds.DsColumn;
import com.cat.common.bean.PageControlInfo;
import com.cat.common.bean.RResult;

/// ***********************import end*************************

public interface DsColumnService{

   /**
    * 保存返回主键
    * @param dsColumn 实体
    * @return Integer
    */
   Integer save(DsColumn dsColumn);

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
    * @param dsColumn	实体
    * @return boolean(true:成功, false:失败)
    */
   boolean update(DsColumn dsColumn);
   
   /**
    * 修改
    * @param oldEntity     旧实体
    * @param newEntity     新实体
    * @param isCheckOver   是否检查版本(Y是，N否)
    * @return FResult
    */
   RResult update(DsColumn oldEntity, DsColumn newEntity, String isCheckOver);
   
   /**
    * 根据主键获取实体
    * @param id	主键
    * @return DsColumn
    */
   DsColumn load(Integer id);

   /**
    * 根据条件获取实体
    * @param dsColumn   实体
    * @return DsColumn
    */
   DsColumn load(DsColumn dsColumn);
   
   /**
    * 根据条件获取数量
    * @param dsColumn	实体
    * @return Integer
    */
   Integer loadCount(DsColumn dsColumn);

   /**
    * 根据条件检查是否存在
    * @param dsColumn	实体
    * @return boolean(true:存在; false:不存在)
    */
   boolean isExist(DsColumn dsColumn);

   /**
    * 根据条件获取实体列表,当skip、max均等于null获取全部)
    * @param dsColumn	实体
    * @param skip	当前页数
    * @param max	页记录数
    * @param params	其他参数
    * @return List<DsColumn>
    */
   List<DsColumn> findList(DsColumn dsColumn, Integer skip, Integer max, Map<String, Object> params);
   
   /**
    * 根据条件获取实体分页列表
    * @param dsColumn	实体
    * @param skip	        当前页数(当等于null时,返回null)
    * @param max	        页记录数(默认为20)
    * @param params	        其他参数
    * @return PageControlInfo
    */
   PageControlInfo findPageList(DsColumn dsColumn, Integer skip, Integer max, Map<String, Object> params);
   /**
    * 根据条件获取实体历史操作分页列表
    * @param dsColumn	实体
    * @param skip	        当前页数(当等于null时,返回null)
    * @param max	        页记录数(默认为20)
    * @param params	        其他参数
    * @return PageControlInfo
    */
   PageControlInfo findPageHsList(DsColumn dsColumn, Integer skip, Integer max, Map<String, Object> params);
   /**
    * 根据历史记录ID，获取历史记录
    * @param id      历史表主键
    * @return  DsDatasource
    */
   DsColumn loadHs(Integer id);
   /// ***********************method begin***********************
   /**
    * 获取表字段主键
    * @param datasourceId     数据源编号
    * @param tableId          表编号
    * @return  String
    */
   String getPrimarykey(Integer datasourceId, Integer tableId);
   /**
    * 获取字段列表
    * @param datasourceId     数据源编号
    * @param tableId          表编号
    * @return
    */
   List<DsColumn> findColumnList(Integer datasourceId, Integer tableId);
   /**
    * 批量保存
    * @param userId     创建者
    * @param tableId    表编号
    * @param list       字段列表
    * @return  FResult
    */
   RResult saveBatch(Integer userId, Integer tableId, List<DsColumn> list);
   /// ***********************method end*************************
}
