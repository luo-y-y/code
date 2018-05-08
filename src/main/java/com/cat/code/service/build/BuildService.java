package com.cat.code.service.build;

import com.cat.code.bean.build.BuildBean;

public interface BuildService{
   /**
    * 生成全部(数据库系统表)
    * @param pageSqlType      分页SQL类型(mysql, oracle)
    */
   public void buildAllForDb(String datasourceCode, String pageSqlType);
   
   /**
    * 生成全部(自定义表)
    * @param datasourceId     数据源ID
    * @param pageSqlType      分页SQL类型(mysql, oracle)
    */
   public boolean buildAll(String datasourceCode, String pageSqlType);
   
   /**
    * 生成
    * @param bulidBean  生成实体
    * @return boolean
    */
   public boolean build(BuildBean bulidBean);
   
   /**
    * 预览
    * @param bulidBean  生成实体
    * @return boolean
    */
   public String preview(BuildBean bulidBean);
   
}
