package com.cat.code.service.build;

import java.util.List;

import com.cat.code.bean.db.TableColumn;
import com.cat.code.bean.ds.DsColumn;


public interface ColumnsService{
   /**
    * 根据表名获取字段列表
    * @param tableName     表名
    * @return  List<TableColumn>
    */
   List<TableColumn> findListByTableName(String tableName);
   /**
    * MYSQL数据源，根据表名获取字段列表
    * @param tableName
    * @return
    */
   List<DsColumn> findListForMysql(String tableName);
   /**
    * 根据表名获取字段列表
    * @param tableName     表名
    * @return  List<TableColumn>
    */
   List<DsColumn> findList(String datasource, String tableName);
}
