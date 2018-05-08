package com.cat.code.dao.db;

import java.util.List;

public interface TablesDao{

	/**
	 * 获取所有表名
	 * 
	 * @return List<String>
	 */
	List<String> findAllList();
}
