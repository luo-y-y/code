package com.cat.code.service.ds.impl;

/// ***********************import begin***********************
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cat.code.bean.ds.DsTable;
import com.cat.code.dao.ds.DsTableDao;
import com.cat.code.service.ds.DsTableService;
import com.cat.common.bean.PageControlInfo;
import com.cat.common.bean.RResult;
import com.cat.common.lang.RDate;
import com.cat.common.lang.RString;
import com.cat.common.lang.RUuid;

/// ***********************import end*************************
@Service("dsTableService")
public class DsTableServiceImpl implements DsTableService {

	private Logger _logger = Logger.getLogger(this.getClass());
	@Autowired
	private DsTableDao dsTableDao;

	// / ***********************define begin***********************
	/**
	 * 保存前处理
	 * 
	 * @param dsTable
	 */
	private void saveBefore(DsTable dsTable) {
		dsTable.setCode(RString.toLower(dsTable.getCode()));
	}

	// / ***********************define end*************************
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer save(DsTable dsTable) {
		if (null == dsTable) {
			_logger.info("save{0} is emptydsTable");
			return null;
		}
		saveBefore(dsTable);
		dsTable.setOgid(RUuid.makeUuid());
		dsTable.setCreateDate(RDate.getCurrentTime());
		dsTable.setUpdateDate(RDate.getCurrentTime());
		Map<String, Object> map = dsTableDao.save(dsTable);
		Integer id = Integer.parseInt(map.get("id").toString());
		return id;
	}

	@Override
	public boolean delete(Integer id) {
		if (null == id) {
			_logger.info("delete{0} is emptyid");
			return false;
		}
		DsTable entity = load(id);
		if (null == entity) {
			_logger.info("deleterecord not exist. id={0}id");
			return false;
		}
		Integer result = dsTableDao.delete(id);
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
		Integer result = dsTableDao.deleteByIds(list);
		return result > 0;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean update(DsTable dsTable) {
		if (null == dsTable) {
			_logger.info("update{0} is emptydsTable");
			return false;
		}
		Integer id = dsTable.getId();
		if (null == id) {
			_logger.info("update{0} is emptydsTable.id");
			return false;
		}
		dsTable.setUpdateDate(RDate.getCurrentTime());
		Integer result = dsTableDao.update(dsTable);
		
		return result > 0;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public RResult update(DsTable oldEntity, DsTable newEntity) {
		if (null == newEntity) {
			_logger.info("updateparam is empty");
			return new RResult(RResult.MSG_FAIL, RResult.paramNull, "entity");
		}
		newEntity.setUpdateDate(RDate.getCurrentTime());
		Integer result = dsTableDao.update(newEntity);
		if (result > 0) {
			return new RResult(RResult.MSG_SUCCESS);
		}else{
			return new RResult(RResult.MSG_FAIL);
		}
	}

	@Override
	public DsTable load(Integer id) {
		if (null == id) {
			_logger.info("load{0} is emptyid");
			return null;
		}
		DsTable dsTable = new DsTable();
		dsTable.setId(id);
		return dsTableDao.load(dsTable);
	}

	@Override
	public DsTable load(DsTable dsTable) {
		if (null == dsTable) {
			_logger.info("load{0} is emptydsTable");
			return null;
		}
		return dsTableDao.load(dsTable);
	}

	@Override
	public Integer loadCount(DsTable dsTable) {
		return dsTableDao.loadCount(dsTable);
	}

	@Override
	public boolean isExist(DsTable dsTable) {
		Integer count = loadCount(dsTable);
		if (null == count) {
			return false;
		}
		return count.intValue() > 0;
	}

	@Override
	public List<DsTable> findList(DsTable dsTable, Integer skip, Integer max, Map<String, Object> params) {
		return dsTableDao.findList(dsTable, skip, max, params);
	}

	@Override
	public PageControlInfo findPageList(DsTable dsTable, Integer skip, Integer max, Map<String, Object> params) {
		return dsTableDao.findPageList(dsTable, skip, max, params);
	}

	@Override
	public PageControlInfo findPageHsList(DsTable dsTable, Integer skip, Integer max, Map<String, Object> params) {
		return dsTableDao.findPageHsList(dsTable, skip, max, params);
	}

	@Override
	public DsTable loadHs(Integer id) {
		if (null == id) {
			_logger.info("load{0} is emptyid");
			return null;
		}
		DsTable entity = new DsTable();
		entity.setId(id);
		return dsTableDao.loadHs(entity);
	}
	// / ***********************method begin***********************

	// / ***********************method end*************************

}
