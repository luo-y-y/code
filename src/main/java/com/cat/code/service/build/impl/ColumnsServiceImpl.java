package com.cat.code.service.build.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cat.code.bean.db.TableColumn;
import com.cat.code.bean.ds.DsColumn;
import com.cat.code.dao.db.ColumnsDao;
import com.cat.code.service.build.ColumnsService;
import com.cat.common.lang.RString;

@Service("columnsService")
public class ColumnsServiceImpl implements ColumnsService {

	@Autowired
	private ColumnsDao columnsDao;

	// @Autowired
	// private UserTabColumnsDao userTabColumnsDao;

	@Override
	public List<TableColumn> findListByTableName(String tableName) {
		return columnsDao.findListByTableName(tableName);
	}

	public List<DsColumn> findListForMysql(String tableName) {
		List<TableColumn> list = findListByTableName(tableName);
		if (null == list || list.isEmpty()) {
			return null;
		}
		List<DsColumn> dsColumnList = new ArrayList<DsColumn>();
		for (int i = 0; i < list.size(); i++) {
			TableColumn tc = list.get(i);
			DsColumn dsColumn = new DsColumn();
			dsColumn.setCode(tc.getColumnName());
			dsColumn.setDataType(tc.getDataType());
			dsColumn.setLabel(tc.getColumnComment());
			String length = "";
			if (RString.contains(tc.getColumnType(), '(')) {
				length = RString.subString(tc.getColumnType(), "(", ")");
			}
			dsColumn.setDataLength(length);
			dsColumnList.add(dsColumn);
		}
		return dsColumnList;
	}

	@Override
	public List<DsColumn> findList(String datasource, String tableName) {
		if (RString.isBlank(datasource) || RString.isBlank(tableName)) {
			return null;
		}
		if (RString.toLower(datasource).equals("tom_develop")) {
			return findListForMysql(tableName);
		}
		// DsColumn dsColumn = new DsColumn();
		// dsColumn.setCode(tableName);
		// RDataSourceContextHolder.setDbType(datasource);
		// return userTabColumnsDao.findList(dsColumn, null, null, null);
		return null;
	}
}
