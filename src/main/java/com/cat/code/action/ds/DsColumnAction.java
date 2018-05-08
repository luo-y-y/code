package com.cat.code.action.ds;

/// ***********************import begin***********************
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cat.code.bean.ds.DsColumn;
import com.cat.code.service.ds.DsColumnService;
import com.cat.common.bean.EOperation;
import com.cat.common.bean.PageControlInfo;
import com.cat.common.bean.RResult;
import com.cat.common.json.RJson;
import com.cat.common.lang.RString;
import com.cat.common.reflect.RReflectUtils;
import com.cat.sy.bean.SyUser;
import com.config.action.WebBaseAction;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;

/// ***********************import end*************************
@RequestMapping("code/ds/column")
@Controller
@Scope("prototype")
public class DsColumnAction extends WebBaseAction {

	@Autowired
	private DsColumnService dsColumnService;
	/**
	 * 请求访问路径
	 */
	private static final String requestPath = "code/ds/column/";

	// / ***********************define begin***********************
	/**
	 * 跳转模板页面
	 */
	@RequestMapping("goTemp")
	public String goTemp() {
		setAttributes();
		return requestPath + "dsColumnTempList";
	}

	// / ***********************define end*************************
	/**
	 * 介绍页面
	 */
	@RequestMapping("goIntroduce")
	public String goIntroduce() {
		setAttributes();
		return requestPath + "introduce";
	}

	/**
	 * 主页面
	 */
	@RequestMapping("goMain")
	public String goMain() {
		setAttributes();
		return requestPath + "dsColumnList";
	}

	/**
	 * 新增页面
	 */
	@RequestMapping("goAdd")
	public String goAdd() {
		setAttributes();
		request.setAttribute("operate", EOperation.Add.value());
		return requestPath + "dsColumnForm";
	}

	/**
	 * 查看页面
	 */
	@RequestMapping("goView")
	public String goView() {
		setAttributes();
		request.setAttribute("operate", EOperation.View.value());
		return requestPath + "dsColumnForm";
	}

	/**
	 * 编辑页面
	 */
	@RequestMapping("goEdit")
	public String goEdit() {
		setAttributes();
		request.setAttribute("operate", EOperation.Update.value());
		return requestPath + "dsColumnForm";
	}

	/**
	 * 历史列表页面
	 * 
	 * @return
	 */
	@RequestMapping("goViewHistory")
	public String goViewHistory() {
		setAttributes();
		return requestPath + "dsColumnHsList";
	}

	/**
	 * 历史页面
	 * 
	 * @return
	 */
	@RequestMapping("goViewHistoryForm")
	public String goViewHistoryForm() {
		setAttributes();
		request.setAttribute("operate", EOperation.History.value());
		return requestPath + "dsColumnForm";
	}

	/**
	 * 保存/更新
	 */
	@RequestMapping("doSave")
	public void doSave() {
		try {
			SyUser syUser = getSessionUser();
			String id = getRequestParameter("id");
			if (RString.isBlank(id) || id.equals("0")) {
				Map<String, String[]> map = getRequestParameterMap();
				DsColumn entity = new DsColumn();
				RReflectUtils.getObjectListForMap(entity, map);
				entity.setCreateUserId(syUser.getId());
				save(entity);
				return;
			}
			update(id, syUser);
		} catch (Exception e) {
			_logger.error("doSave", e);
		}
	}

	/**
	 * 保存逻辑
	 */
	private void save(DsColumn entity) {
		Integer id = dsColumnService.save(entity);
		if (id > 0) {
			printWriterJson(new RResult(RResult.MSG_SUCCESS));
			return;
		}
		printWriterJson(new RResult(RResult.MSG_FAIL));
	}

	/**
	 * 修改逻辑
	 */
	private void update(String id, SyUser syUser) {
		DsColumn oldEntity = dsColumnService.load(Integer.parseInt(id));
		if (null == oldEntity) {
			_logger.info("update update fail record not exist, param[id={0}]" + id);
			printWriterJson(new RResult(RResult.MSG_FAIL, RResult.recordNotExist));
			return;
		}
		DsColumn newEntity = new DsColumn();
		RReflectUtils.getObjectForObject(newEntity, oldEntity);
		Map<String, String[]> map = getRequestParameterMap();
		RReflectUtils.getObjectListForMap(newEntity, map);
		newEntity.setUpdateUserId(syUser.getId());
		String isCheckOver = "Y";
		if (null != map.get(ISCHECKOVER)) {
			isCheckOver = map.get(ISCHECKOVER).toString();
		}
		RResult info = dsColumnService.update(oldEntity, newEntity, isCheckOver);
		printWriterJson(info);
	}

	/**
	 * 删除
	 */
	@RequestMapping("doDelete")
	public void doDelete() {
		try {
			String ids = getRequestParameter("ids");
			if (RString.isBlank(ids)) {
				printWriterJson(new RResult(RResult.MSG_FAIL, RResult.recordNotExist));
				return;
			}
			String[] values = RString.split(ids, ",");
			boolean bool = false;
			if (values.length > 1) {
				bool = dsColumnService.deleteByIds(ids);
			} else {
				bool = dsColumnService.delete(Integer.parseInt(ids));
			}
			if (bool) {
				printWriterJson(new RResult(RResult.MSG_SUCCESS));
			} else {
				printWriterJson(new RResult(RResult.MSG_FAIL));
			}
		} catch (Exception e) {
			_logger.error("doDelete", e);
		}
	}

	/**
	 * 根据ID加载记录
	 */
	@RequestMapping("load")
	public void load() {
		String id = getRequestParameter("id");
		if (RString.isBlank(id)) {
			printWriterJson(new RResult(RResult.MSG_FAIL, RResult.recordNotExist));
			return;
		}
		DsColumn entity = dsColumnService.load(Integer.parseInt(id));
		getPrintWriter().write(RJson.getJsonStr(entity));
	}

	/**
	 * 列表查询
	 */
	@RequestMapping("findPageList")
	public void findPageList() {
		try {
			Map<String, String[]> map = getRequestParameterMap();
			DsColumn entity = new DsColumn();
			RReflectUtils.getObjectListForMap(entity, map);
			PageControlInfo pageInfo = dsColumnService.findPageList(entity, getPage(), getEnd(), loadOsearch());
			printWriterJson(pageInfo);
		} catch (Exception e) {
			_logger.error("findPageList", e);
		}
	}

	// / ***********************method begin***********************
	// 批量保存
	@RequestMapping("doSaveBatch")
	public void doSaveBatch() {
		String data = getRequestParameter("data");
		String tableId = getRequestParameter("tableId");
		try {
			if (RString.isBlank(tableId) || RString.isBlank(data)) {
				printWriterJson(new RResult(RResult.MSG_FAIL));
				return;
			}
			SyUser syUser = getSessionUser();
			List<DsColumn> list = getDsColumnListForPage(data);
			RResult result = dsColumnService.saveBatch(syUser.getId(), Integer.parseInt(tableId), list);
			printWriterJson(result);
		} catch (Exception e) {
			_logger.error("doSaveBatch", e);
			printWriterJson(new RResult(RResult.MSG_FAIL));
		}
	}

	/**
	 * 页面
	 * 
	 * @param data
	 *            JSON字符串
	 * @return List<DsColumn>
	 */
	private List<DsColumn> getDsColumnListForPage(String data) {
		List<DsColumn> list = new ArrayList<DsColumn>();
		try {
			list = RJson.parseJSON2ListBean(data, DsColumn.class);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	// / ***********************method end*************************

}
