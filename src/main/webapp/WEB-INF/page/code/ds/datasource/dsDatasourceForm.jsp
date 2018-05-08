<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>数据源表单</title>
	<%@include file="/head.jsp" %>
</head>
<body class="easyui-layout" style="margin:2px">
	<div class="easyui-panel" data-options="region:'north'" style="padding:2px;border:1px solid:#95b8e7;height:30px; background-color:#e6f0ff">
		<span class="form-tool-title">表单</span>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-save'" id="submitButton">保存</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-cancel'" id="clearButton">清除</a>
	</div>
	
	<div class="easyui-panel" data-options="region:'center',border:true,fit:false" style="padding:2px 0 10px 10px">
	<form id="dsDatasourceForm" method="post">
		<input name="id" type="hidden"/>
		<input name="isValid" type="hidden" value="Y"/>
		<table class="form-table">
			<tr>
				<td>
					<div>项目编号：</div>
					<input class="easyui-validatebox" type="text" name="projectId" data-options="required:true" />
				</td>
				<td>
					<div>项目名称：</div>
					<input  class="easyui-validatebox" type="text" name="projectName" data-options="required:true"  /></td>
			</tr>
			<tr>
				<td>
					<div>类型：</div>
					<select class="easyui-combobox" name="typeCd" style="width:224px;">
						<option value="oracle">oracle</option>
						<option value="mysql">mysql</option>
					</select>
				</td>
				<td><div>代码：</div><input class="easyui-validatebox" type="text" name="code" data-options="required:true" /></td>
			</tr>
			<tr>
				<td><div>英文名称：</div><input class="easyui-validatebox" type="text" name="name" data-options="required:true" /></td>
				<td><div>中文名字：</div><input class="easyui-validatebox" type="text" name="label" data-options="required:true" /></td>
			</tr>
			<tr>
				<td colspan="2"><div>驱动类型：</div><textarea name="driverClass"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><div>JDBC-URL：</div><textarea name="jdbcUrl"></textarea></td>
			</tr>
			<tr>
				<td><div>账号：</div><input type="text" name="userName"></input></td>
				<td><div>密码：</div><input type="text" name="userPassword"/></td>
			</tr>
			<tr style="display: none;" id="hideCreateLine">
				<td><div>创建者：</div><input type="text" name="createUserLabel" disabled></input></td>
				<td><div>创建时间：</div><input class="easyui-datebox" name="createDate" disabled data-options="formatter:date_format,parser:date_parse" style="width:226px;"/></td>
			</tr>
			<tr style="display: none;" id="hideUpdateLine">
				<td><div>更新者：</div><input type="text"  name="updateUserLabel" disabled></input></td>
				<td><div>更新时间：</div><input class="easyui-datebox" name="updateDate" disabled data-options="formatter:date_format,parser:date_parse" style="width:226px;"/></td>
			</tr>
			<tr>
				<td colspan="2"><div>备注：</div><textarea name="note"></textarea></td>
			</tr>
		</table>
	</form>
	</div>
<script type="text/javascript">
$(function(){
	var operate = '${operate}';
	if('U' == operate || 'V' == operate || 'H' == operate) {
		$('#hideCreateLine').show();
		$('#hideUpdateLine').show();
	}
	if('V' == operate || 'H' == operate) {
		var permissionObj = ['submitButton', 'clearButton'];
		form_toolbar_control(permissionObj, 'disable');
	}
	//对象{'url':访问地址,'gridId':列表对象ID,'pKey':记录主键字段, 'toTabIndex':转向至tabs索引数的页面（从0开始)}
	var params = {'url':"code/ds/datasource/load.do", 'gridId':'dg'};

	form_load('dsDatasourceForm', operate, params);
	tab_mask_hide();
	form_submit($("#submitButton"), 'dsDatasourceForm', 'code/ds/datasource/doSave.do');
	form_clear($("#clearButton"), 'dsDatasourceForm');
	
});
</script>
</body>
</html>