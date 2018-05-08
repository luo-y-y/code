package com.cat.code.dao.ds;
/// ***********************import begin***********************
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.cat.code.bean.ds.DsTable;
import com.cat.common.bean.PageControlInfo;


/// ***********************import end*************************
/**
 * 表名：ds_table
 * @author Administrator
 */
public interface DsTableDao{
   /**
    * 保存并返回主键
    * @param dsTable 实体
    */
   Map<String, Object> save(@Param("entity") DsTable dsTable);

   /**
    * 删除
    * @param dsTable	实体
    */
   Integer delete(@Param("id") Integer id);

   /**
    * 删除多条数据
    * @param idList	主键列表
    */
   Integer deleteByIds(@Param("idList") List<Integer> idList);

   /**
    * 修改
    * @param dsTable	实体
    */
   Integer update(@Param("entity") DsTable dsTable);
   
   /**
    * 根据主键获取实体
    * @param dsTable	实体
    * @return DsTable
    */
   DsTable load(@Param("entity") DsTable dsTable);

   /**
    * 根据主键获取实体
    * @param id	主键
    * @return DsTable
    */
   Integer loadCount(@Param("entity") DsTable dsTable);

   /**
    * 根据条件获取实体列表,当skip、max均等于null获取全部)
    * @param dsTable	实体
    * @param skip	        当前页数
    * @param max	        页记录数
    * @param params	        其他参数
    * @return List<DsTable>
    */
   List<DsTable> findList(@Param("entity") DsTable dsTable, @Param("skip") Integer start, @Param("max") Integer max, @Param("params") Map<String, Object> params);
   
   /**
    * 根据条件获取实体分页列表
    * @param dsTable	实体
    * @param skip	        当前页数(当等于null时,返回null)
    * @param max	        页记录数(默认为20)
    * @param params	        其他参数
    * @return PageControlInfo
    */
   PageControlInfo findPageList(@Param("entity") DsTable dsTable, @Param("skip") Integer skip, @Param("max") Integer max, @Param("params") Map<String, Object> params);
   /**
    * 保存操作历史
    * @param dsTable 实体
    */
   void insertHs(@Param("entity") DsTable dsTable);
   /**
    * 根据条件获取实体历史操作分页列表
    * @param dsTable	实体
    * @param skip	        当前页数(当等于null时,返回null)
    * @param max	        页记录数(默认为20)
    * @param params	        其他参数
    * @return PageControlInfo
    */
   PageControlInfo findPageHsList(@Param("entity") DsTable dsTable, @Param("skip") Integer skip, @Param("max") Integer max, @Param("params") Map<String, Object> params);
   /**
    * 根据主键获取历史实体
    * @param dsTable	实体
    * @return DsTable
    */
   DsTable loadHs(@Param("entity") DsTable dsTable);
   /// ***********************method begin***********************

   /// ***********************method end*************************
}
