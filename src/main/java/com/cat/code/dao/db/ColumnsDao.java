package com.cat.code.dao.db;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cat.code.bean.db.TableColumn;

public interface ColumnsDao{

   /**
    * 根据表名获取字段列表
    * @param tableName     表名
    * @return  List<TableColumn>
    */
   List<TableColumn> findListByTableName(@Param("tableName") String tableName);
}
