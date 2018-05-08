<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>表表单</title>
	<%@include file="/head.jsp" %>
</head>
<body class="easyui-layout" style="margin:2px">
	<div class="easyui-panel" data-options="region:'north'" style="padding:2px;border:1px solid:#95b8e7;height:30px; background-color:#e6f0ff">
		<span class="form-tool-title">表单</span>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-save'" id="submitButton">保存</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-cancel'" id="clearButton">清除</a>
	</div>
	
	<div class="easyui-panel" data-options="region:'center',border:true,fit:false" style="padding:2px 0 10px 10px">
	<form id="dsTableForm" method="post">
		<input name="id" type="hidden"/>
		<input name="isValid" type="hidden" value="Y"/>
		<input type="hidden" name="datasourceId" value="${datasourceId}" />
		<table class="form-table">
			<tr>
				<td>
					<div>类型：</div>
					<select class="easyui-combobox" name="typeCd" style="width:224px;">
						<option value="S">单体表</option>
						<option value="N">虚拟表</option>
						<option value="W">工作表</option>
					</select>
				</td>
				<td><div>表名：</div><input class="easyui-validatebox" type="text" name="code" data-options="required:true" /></td>
			</tr>
			<tr>
				<td><div>英文名称：</div><input class="easyui-validatebox" type="text" name="name" data-options="required:true" /></td>
				<td><div>中文名字：</div><input class="easyui-validatebox" type="text" name="label" data-options="required:true" /></td>
			</tr>
			<tr>
				<td><div>表空间：</div><input type="text" name="tablespaceName"></input></td>
				<td><div>序列名：</div><input type="text" name="sequenceName"/></td>
			</tr>
			<tr>
				<td colspan="2"><div>联合主键：</div><input type="text" name="linkUnique" style="width:526px;"/></td>
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
	//对象{'url':访问地址,'gridId':列表对象ID,'pKey':记录主键字段, 'toTabIndex':转向至tabs索引数的页面（从0开始)}
	var params = {'url':"code/ds/table/load.do", 'gridId':'dg'};
	if('H' == operate) {
		params = {'url':"code/ds/table/loadHs.do", 'gridId':'hsdg', 'toTabIndex':1};
	}
	if('U' == operate || 'V' == operate || 'H' == operate) {
		$('#hideCreateLine').show();
		$('#hideUpdateLine').show();
	}
	if('V' == operate || 'H' == operate) {
		var permissionObj = ['submitButton', 'clearButton'];
		form_toolbar_control(permissionObj, 'disable');
	}
	form_load('dsTableForm', operate, params);
	tab_mask_hide();
	form_submit($("#submitButton"), 'dsTableForm', 'code/ds/table/doSave.do');
	form_clear($("#clearButton"), 'dsTableForm');
});
</script>
</body>
</html>