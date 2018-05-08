package com.cat.code.action.build;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cat.code.bean.build.BuildBean;
import com.cat.code.service.build.BuildService;
import com.cat.common.bean.RResult;
import com.cat.common.lang.RString;
import com.cat.common.reflect.RReflectUtils;
import com.config.action.WebBaseAction;

@RequestMapping("build")
@Controller
@Scope("prototype")
public class BuildAction extends WebBaseAction {

	@Autowired
	private BuildService buildService;

	/**
	 * 请求访问路径
	 */
	private static final String requestPath = "code/build/";

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
	@RequestMapping("goForm")
	public String goForm() {
		setAttributes();
		return requestPath + "buildForm";
	}
	
	/**
    * 主页面
    */
   @RequestMapping("goCopy")
   public String goCopy() {
      setAttributes();
      return requestPath + "copydiv";
   }
   
	@RequestMapping("goPreview")
	public String goPreview() {
		setAttributes();
		BuildBean entity = new BuildBean();
		entity.setDatasourceId(Integer.parseInt(getRequestParameter("datasourceId")));
		entity.setTableId(Integer.parseInt(getRequestParameter("id")));
		entity.setTableCode(RString.toString(getRequestParameter("code")));
		entity.setTableType(RString.toString(getRequestParameter("typeCd")));
		entity.setTypes(RString.toString(getRequestParameter("types")));
		entity.setPageSqlType(RString.toString(getRequestParameter("pageSqlType")));
		entity.setTemplateUrl(getRequestParameter("templateUrl"));
		entity.setDbSource("ds");
		entity.setBulidTypeCd("P");
		String context = buildService.preview(entity);
		request.setAttribute("context", context);
		return requestPath + "PreviewForm";
	}

	/**
	 * 生成执行
	 */
	@RequestMapping("doBuild")
	public void doBuild() {
		Map<String, String[]> map = getRequestParameterMap();
		BuildBean entity = new BuildBean();
		RReflectUtils.getObjectListForMap(entity, map);
		entity.setDbSource("ds");
		entity.setBulidTypeCd("B");
		boolean isSuccess = buildService.build(entity);
		if (isSuccess) {
			printWriterJson(new RResult(RResult.MSG_SUCCESS));
		} else {
			printWriterJson(new RResult(RResult.MSG_FAIL));
		}
	}

}
