package com.cat.code.service.build.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cat.code.bean.ds.DsColumn;
import com.cat.code.bean.ds.DsDatasource;
import com.cat.code.bean.ds.DsTable;
import com.cat.code.service.build.ColumnsService;
import com.cat.code.service.build.SyncService;
import com.cat.code.service.build.TablesService;
import com.cat.code.service.ds.DsColumnService;
import com.cat.code.service.ds.DsDatasourceService;
import com.cat.code.service.ds.DsTableService;
import com.cat.common.lang.RList;
import com.cat.common.lang.RString;

@Service("syncService")
public class SyncServiceImpl implements SyncService {

	private  Logger _logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private TablesService tablesService;

	@Autowired
	private ColumnsService columnsService;

	@Autowired
	private DsTableService dsTableService;

	@Autowired
	private DsColumnService dsColumnService;

	@Autowired
	private DsDatasourceService dsDatasourceService;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean syncTable(Integer datasourceId) {
		_logger.info("syncTableColumnparams[datasourceId=]" +datasourceId);
		if (null == datasourceId) {
			_logger.info("syncTableColumnparams is error.");
			return false;
		}
		DsDatasource dsDatasource = dsDatasourceService.load(datasourceId);
		if (null == dsDatasource) {
			_logger.info("syncTable{0} is empty. [dataSourceId="+ datasourceId);
			return false;
		}
		List<DsTable> tables = tablesService.findAllList(dsDatasource.getCode());
		if (RList.isBlank(tables)) {
			_logger.info("syncTable{0} is empty. [dataSource="+ dsDatasource.getCode());
			return false;
		}
		for (int i = 0; i < tables.size(); i++) {
			DsTable dsTable = tables.get(i);
			dsTable.setName(dsTable.getCode());
			dsTable.setDatasourceId(datasourceId);
			if (!dsTableService.isExist(dsTable)) {
				dsTable.setIsValid("Y");
				dsTableService.save(dsTable);
			}
		}
		return true;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean syncTableColumn(Integer datasourceId, Integer tableId) {
		_logger.info("syncTableColumnparams[datasourceId="+datasourceId+"; tableId="+tableId+"]");
		if (null == datasourceId || null == tableId) {
			_logger.info("syncTableColumnparams is error.");
			return false;
		}
		DsDatasource dsDatasource = dsDatasourceService.load(datasourceId);
		if (null == dsDatasource) {
			_logger.info("syncTableColumn{0} is empty. [dataSourceId="+datasourceId);
			return false;
		}
		boolean result = syncTableColumn(datasourceId, dsDatasource.getCode(), tableId);
		return result;
	}

	public boolean syncTableColumn(Integer datasourceId, String datasourceCode, Integer tableId) {
		_logger.info("syncTableColumnparams[datasourceCode="+tableId+"; tableId="+datasourceCode );
		if (RString.isBlank(datasourceCode) || null == tableId) {
			_logger.info("syncTableColumnparams is error.");
			return false;
		}
		DsTable dsTable = dsTableService.load(tableId);
		if (null == dsTable) {
			_logger.info("syncTableColumn{0} is empty. [tableId="+ tableId);
			return false;
		}
		List<DsColumn> list = columnsService.findList(datasourceCode, dsTable.getCode());
		if (RList.isBlank(list)) {
			_logger.info("syncTableColumn{0} is empty. [dataSource="+datasourceCode);
			return false;
		}
		DsColumn dsColumnSearch = new DsColumn();
		dsColumnSearch.setTableId(tableId);
		dsColumnSearch.setDatasourceId(datasourceId);
		List<DsColumn> dsColumnList = dsColumnService.findList(dsColumnSearch, null, null, null);
		for (int i = 0; i < list.size(); i++) {
			DsColumn dsColumn = list.get(i);
			dsColumn.setTableId(tableId);
			boolean flag = false;
			for (int j = 0; j < dsColumnList.size(); j++) {
				DsColumn localDsColumn = dsColumnList.get(j);
				if (dsColumn.getCode().equals(localDsColumn.getCode())) {
					flag = true;
					localDsColumn.setDatasourceId(datasourceId);
					localDsColumn.setDataType(dsColumn.getDataType());
					localDsColumn.setLabel(dsColumn.getLabel());
					localDsColumn.setSortNum(dsColumn.getSortNum());
					localDsColumn.setName(dsColumn.getCode());
					localDsColumn.setCode(dsColumn.getCode());
					localDsColumn.setDataLength(dsColumn.getDataLength());
					dsColumnService.update(localDsColumn);
					break;
				}
			}
			// 不存在
			if (!flag) {
				dsColumn.setIsValid("Y");
				dsColumn.setName(dsColumn.getCode());
				dsColumn.setDatasourceId(datasourceId);
				dsColumn.setSortNum(i * 5);
				dsColumnService.save(dsColumn);
			}
		}
		return true;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean syncAllTableColumn(Integer datasourceId) {
		_logger.info("syncAllTableColumnparams[datasourceId="+datasourceId+"]" );
		if (null == datasourceId) {
			_logger.info("syncAllTableColumnparams is error.");
			return false;
		}
		DsDatasource dsDatasource = dsDatasourceService.load(datasourceId);
		if (null == dsDatasource) {
			_logger.info("syncAllTableColumn{0} is empty. [dataSourceId="+datasourceId+"]");
			return false;
		}
		DsTable dsTableSearch = new DsTable();
		dsTableSearch.setDatasourceId(datasourceId);
		List<DsTable> tableList = dsTableService.findList(dsTableSearch, null, null, null);
		if (RList.isBlank(tableList)) {
			_logger.info("syncAllTableColumntablsList is empty.");
			return false;
		}
		for (int i = 0; i < tableList.size(); i++) {
			DsTable dsTable = (DsTable) tableList.get(i);
			boolean sync = syncTableColumn(datasourceId, dsDatasource.getCode(), dsTable.getId());
			_logger.info("syncAllTableColumnSync table["+ dsTable.getCode()+"] is "+sync);
		}
		return true;
	}
}
