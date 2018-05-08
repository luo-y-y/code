package com.cat.code.service.build;

import java.util.List;

import com.cat.code.bean.ds.DsTable;

public interface TablesService{

   /**
    * Mysql数据源获取所有表名
    * @return List<String>
    */
   List<String> findAllList();
   
   /**
    * Mysql数据源
    * @return
    */
   List<DsTable> findAllListForMysql();
   
   /**
    * 根据数据源查找表
    * @param datasource
    * @return 
    */
   List<DsTable> findAllList(String datasource);
}
