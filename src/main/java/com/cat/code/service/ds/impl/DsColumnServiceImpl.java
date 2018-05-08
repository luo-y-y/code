package com.cat.code.service.ds.impl;

/// ***********************import begin***********************
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cat.code.bean.ds.DsColumn;
import com.cat.code.bean.ds.DsTable;
import com.cat.code.dao.ds.DsColumnDao;
import com.cat.code.service.ds.DsColumnService;
import com.cat.code.service.ds.DsTableService;
import com.cat.common.bean.PageControlInfo;
import com.cat.common.bean.RResult;
import com.cat.common.lang.RDate;
import com.cat.common.lang.RList;
import com.cat.common.lang.RObject;
import com.cat.common.lang.RString;
import com.cat.common.lang.RUuid;

/// ***********************import end*************************
@Service("dsColumnService")
public class DsColumnServiceImpl implements DsColumnService {

	private  Logger _logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private DsColumnDao dsColumnDao;

	// / ***********************define begin***********************
	@Autowired
	private DsTableService dsTableService;

	/**
	 * 保存前处理
	 * 
	 * @param dsTable
	 */
	private void saveBefore(DsColumn dsColumn) {
		dsColumn.setCode(RString.toUpper(dsColumn.getCode()));
	}

	// / ***********************define end*************************
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer save(DsColumn dsColumn) {
		if (null == dsColumn) {
			_logger.info("save{0} is emptydsColumn");
			return null;
		}
		saveBefore(dsColumn);
		dsColumn.setOgid(RUuid.makeUuid());
		dsColumn.setCreateDate(RDate.getCurrentTime());
		dsColumn.setUpdateDate(RDate.getCurrentTime());
		Map<String, Object> map = dsColumnDao.save(dsColumn);
		Integer id = Integer.parseInt(map.get("id").toString());
		return id;
	}

	@Override
	public boolean delete(Integer id) {
		if (null == id) {
			_logger.info("delete{0} is emptyid");
			return false;
		}
		DsColumn entity = load(id);
		if (null == entity) {
			_logger.info("deleterecord not exist. id={0}id");
			return false;
		}
		Integer result = dsColumnDao.delete(id);
		return result > 0;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean deleteByIds(String ids) {
		if (RString.isBlank(ids)) {
			_logger.info("deleteByIds{0} is emptyids");
			return false;
		}
		String[] array = ids.split(",");
		List<Integer> list = new ArrayList<Integer>();
		for (String id : array) {
			list.add(Integer.valueOf(id));
		}
		Integer result = dsColumnDao.deleteByIds(list);
		return result > 0;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean update(DsColumn dsColumn) {
		if (null == dsColumn) {
			_logger.info("update{0} is emptydsColumn");
			return false;
		}
		Integer id = dsColumn.getId();
		if (null == id) {
			_logger.info("update{0} is emptydsColumn.id");
			return false;
		}
		dsColumn.setUpdateDate(RDate.getCurrentTime());
		Integer result = dsColumnDao.update(dsColumn);
		return result > 0;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public RResult update(DsColumn oldEntity, DsColumn newEntity, String isCheckOver) {
		if (null == newEntity) {
			_logger.info("updateparam is empty");
			return new RResult(RResult.MSG_FAIL, RResult.paramNull, "entity");
		}
		newEntity.setUpdateDate(RDate.getCurrentTime());
		Integer result = dsColumnDao.update(newEntity);
		if(result>0){
			return new RResult(RResult.MSG_SUCCESS);
		}else{
			return new RResult(RResult.MSG_FAIL);
		}
	}

	@Override
	public DsColumn load(Integer id) {
		if (null == id) {
			_logger.info("load{0} is emptyid");
			return null;
		}
		DsColumn dsColumn = new DsColumn();
		dsColumn.setId(id);
		return dsColumnDao.load(dsColumn);
	}

	@Override
	public DsColumn load(DsColumn dsColumn) {
		if (null == dsColumn) {
			_logger.info("load{0} is emptydsColumn");
			return null;
		}
		return dsColumnDao.load(dsColumn);
	}

	@Override
	public Integer loadCount(DsColumn dsColumn) {
		return dsColumnDao.loadCount(dsColumn);
	}

	@Override
	public boolean isExist(DsColumn dsColumn) {
		Integer count = loadCount(dsColumn);
		if (null == count) {
			return false;
		}
		return count.intValue() > 0;
	}

	@Override
	public List<DsColumn> findList(DsColumn dsColumn, Integer skip, Integer max, Map<String, Object> params) {
		return dsColumnDao.findList(dsColumn, skip, max, params);
	}

	@Override
	public PageControlInfo findPageList(DsColumn dsColumn, Integer skip, Integer max, Map<String, Object> params) {
		return dsColumnDao.findPageList(dsColumn, skip, max, params);
	}


	@Override
	public PageControlInfo findPageHsList(DsColumn dsColumn, Integer skip, Integer max, Map<String, Object> params) {
		return dsColumnDao.findPageHsList(dsColumn, skip, max, params);
	}

	@Override
	public DsColumn loadHs(Integer id) {
		if (null == id) {
			_logger.info("load{0} is emptyid");
			return null;
		}
		DsColumn entity = new DsColumn();
		entity.setId(id);
		return dsColumnDao.loadHs(entity);
	}

	// / ***********************method begin***********************
	@Override
	public String getPrimarykey(Integer datasourceId, Integer tableId) {
		if (null == tableId) {
			_logger.info("getPrimarykeytableId is null, pkey default value is (id)");
			return "id";
		}
		DsColumn dsColumn = new DsColumn();
		dsColumn.setDatasourceId(datasourceId);
		dsColumn.setTableId(tableId);
		dsColumn.setIsPk("Y");
		List<DsColumn> list = findList(dsColumn, null, null, null);
		if (RObject.isEmpty(list)) {
			_logger.info("getPrimarykeylist is null, pkey default value is (id)");
			return "id";
		}
		DsColumn result = list.get(0);
		return result.getCode();
	}

	@Override
	public List<DsColumn> findColumnList(Integer datasourceId, Integer tableId) {
		if (null == tableId) {
			_logger.info("getPrimarykeytableId is null, pkey default value is (id)");
			return null;
		}
		DsColumn dsColumn = new DsColumn();
		dsColumn.setDatasourceId(datasourceId);
		dsColumn.setTableId(tableId);
		List<DsColumn> list = findList(dsColumn, null, null, null);
		if (RObject.isEmpty(list)) {
			_logger.info("getPrimarykeylist is null, pkey default value is (id)");
			return null;
		}
		return list;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public RResult saveBatch(Integer userId, Integer tableId, List<DsColumn> list) {
		if (RList.isBlank(list)) {
			return new RResult(RResult.MSG_FAIL, "参数：列表为空");
		}
		DsTable dsTable = dsTableService.load(tableId);
		if (null == dsTable) {
			return new RResult(RResult.MSG_FAIL, "表不存在, tableId={0}", tableId);
		}
		for (int i = 0; i < list.size(); i++) {
			DsColumn dsColumn = list.get(i);
			dsColumn.setId(null);
			dsColumn.setTableId(tableId);
			dsColumn.setDatasourceId(dsTable.getDatasourceId());
			dsColumn.setCreateUserId(userId);
			dsColumn.setUpdateUserId(null);
			save(dsColumn);
		}
		return new RResult(RResult.MSG_SUCCESS);
	}
	// / ***********************method end*************************

}
