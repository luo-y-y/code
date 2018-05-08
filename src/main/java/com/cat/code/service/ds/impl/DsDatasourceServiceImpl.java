package com.cat.code.service.ds.impl;

/// ***********************import begin***********************
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cat.code.bean.ds.DsDatasource;
import com.cat.code.dao.ds.DsDatasourceDao;
import com.cat.code.service.ds.DsDatasourceService;
import com.cat.common.bean.PageControlInfo;
import com.cat.common.bean.RResult;
import com.cat.common.lang.RDate;
import com.cat.common.lang.RString;
import com.cat.common.lang.RUuid;

/// ***********************import end*************************
@Service("dsDatasourceService")
public class DsDatasourceServiceImpl implements DsDatasourceService {
	private  Logger _logger = Logger.getLogger(this.getClass());
	
	@Autowired
	private DsDatasourceDao dsDatasourceDao;

	// / ***********************define begin***********************
	// / ***********************define end*************************
	@Override
	@Transactional(rollbackFor = Exception.class)
	public Integer save(DsDatasource dsDatasource) {
		if (null == dsDatasource) {
			_logger.info("save{0} is emptydsDatasource");
			return null;
		}
		dsDatasource.setOgid(RUuid.makeUuid());
		dsDatasource.setCreateDate(RDate.getCurrentTime());
		dsDatasource.setUpdateDate(RDate.getCurrentTime());
		Map<String, Object> map = dsDatasourceDao.save(dsDatasource);
		Integer id = Integer.parseInt(map.get("id").toString());
		return id;
	}

	@Override
	public boolean delete(Integer id) {
		if (null == id) {
			_logger.info("delete{0} is emptyid");
			return false;
		}
		DsDatasource entity = load(id);
		if (null == entity) {
			_logger.info("deleterecord not exist. id={0}id");
			return false;
		}
		Integer result = dsDatasourceDao.delete(id);
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
		Integer result = dsDatasourceDao.deleteByIds(list);
		return result > 0;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public boolean update(DsDatasource dsDatasource) {
		if (null == dsDatasource) {
			_logger.info("update{0} is emptydsDatasource");
			return false;
		}
		Integer id = dsDatasource.getId();
		if (null == id) {
			_logger.info("update{0} is emptydsDatasource.id");
			return false;
		}
		dsDatasource.setUpdateDate(RDate.getCurrentTime());
		Integer result = dsDatasourceDao.update(dsDatasource);
		return result > 0;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public RResult update(DsDatasource oldEntity, DsDatasource newEntity, String isCheckOver) {
		if (null == newEntity) {
			_logger.info("updateparam is empty");
			return new RResult(RResult.MSG_FAIL, RResult.paramNull, "entity");
		}
		newEntity.setUpdateDate(RDate.getCurrentTime());
		Integer result = dsDatasourceDao.update(newEntity);
		if (result > 0) {
			return new RResult(RResult.MSG_SUCCESS);
		}else{
			return new RResult(RResult.MSG_FAIL);
		}

	}

	@Override
	public DsDatasource load(Integer id) {
		if (null == id) {
			_logger.info("load{0} is emptyid");
			return null;
		}
		DsDatasource dsDatasource = new DsDatasource();
		dsDatasource.setId(id);
		return dsDatasourceDao.load(dsDatasource);
	}

	@Override
	public DsDatasource load(DsDatasource dsDatasource) {
		if (null == dsDatasource) {
			_logger.info("load{0} is emptydsDatasource");
			return null;
		}
		return dsDatasourceDao.load(dsDatasource);
	}

	@Override
	public Integer loadCount(DsDatasource dsDatasource) {
		return dsDatasourceDao.loadCount(dsDatasource);
	}

	@Override
	public boolean isExist(DsDatasource dsDatasource) {
		Integer count = loadCount(dsDatasource);
		if (null == count) {
			return false;
		}
		return count.intValue() > 0;
	}

	@Override
	public List<DsDatasource> findList(DsDatasource dsDatasource, Integer skip, Integer max, Map<String, Object> params) {
		return dsDatasourceDao.findList(dsDatasource, skip, max, params);
	}

	@Override
	public PageControlInfo findPageList(DsDatasource dsDatasource, Integer skip, Integer max, Map<String, Object> params) {
		return dsDatasourceDao.findPageList(dsDatasource, skip, max, params);
	}


	@Override
	public PageControlInfo findPageHsList(DsDatasource dsDatasource, Integer skip, Integer max, Map<String, Object> params) {
		return dsDatasourceDao.findPageHsList(dsDatasource, skip, max, params);
	}

	@Override
	public DsDatasource loadHs(Integer id) {
		if (null == id) {
			_logger.info("load{0} is emptyid");
			return null;
		}
		DsDatasource entity = new DsDatasource();
		entity.setId(id);
		return dsDatasourceDao.loadHs(entity);
	}

	// / ***********************method begin***********************
	@Override
	public DsDatasource load(String code) {
		if (RString.isBlank(code)) {
			_logger.info("load{0} is emptycode");
			return null;
		}
		DsDatasource dsDatasource = new DsDatasource();
		dsDatasource.setCode(code);
		return dsDatasourceDao.load(dsDatasource);
	}

	// / ***********************method end*************************

}
