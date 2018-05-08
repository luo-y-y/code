package com.cat.code.service.build.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cat.code.bean.ds.DsTable;
import com.cat.code.dao.db.TablesDao;
import com.cat.code.service.build.TablesService;
import com.cat.common.lang.RString;

@Service("tablesService")
public class TablesServiceImpl implements TablesService {

	@Autowired
	private TablesDao tablesDao;

	// @Autowired
	// private UserTablesDao userTablesDao;

	@Override
	public List<String> findAllList() {
		return tablesDao.findAllList();
	}

	@Override
	public List<DsTable> findAllListForMysql() {
		List<String> list = findAllList();
		if (null == list || list.isEmpty()) {
			return null;
		}
		List<DsTable> tList = new ArrayList<DsTable>();
		for (int i = 0; i < list.size(); i++) {
			// 排除历史表
			if (!RString.endsWith(RString.toLower(list.get(i)), "_hs")) {
				DsTable t = new DsTable();
				t.setCode(list.get(i));
				tList.add(t);
			}
		}
		return tList;
	}

	@Override
	public List<DsTable> findAllList(String datasource) {
		if (RString.isBlank(datasource)) {
			return null;
		}
		if (RString.toLower(datasource).equals("tom_develop")) {
			return findAllListForMysql();
		}
		// RDataSourceContextHolder.setDbType(datasource);
		// return userTablesDao.findList(null, null, null);
		return null;
	}

}
