package com.cat.code.service.build;

public interface SyncService{
   /**
    * 同步数据源中的所有表
    * @param datasourceId     数据源ID
    * @return  boolean(true:成功，false:失败)
    */
   boolean syncTable(Integer datasourceId);
   /**
    * 同步数据源中的所有表中的字段
    * @param datasourceId     数据源ID
    * @param tableId          表名
    * @return  boolean(true:成功，false:失败)
    */
   boolean syncTableColumn(Integer datasourceId, Integer tableId);
   /**
    * 同步数据源中的所有表中的字段
    * @param datasourceCode   数据源代码
    * @param tableId          表名
    * @return  boolean(true:成功，false:失败)
    */
   boolean syncTableColumn(Integer datasourceId, String datasourceCode, Integer tableId);
   /**
    * 同步所有表的表字段
    * @return  boolean(true:成功，false:失败)
    */
   boolean syncAllTableColumn(Integer datasourceId);
   
}
