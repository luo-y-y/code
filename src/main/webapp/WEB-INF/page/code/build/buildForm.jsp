<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>生成表单</title>
	<%@include file="/head.jsp" %>
</head>
<body class="easyui-layout" style="margin:2px">
	<div class="easyui-panel" data-options="region:'north'" style="padding:2px;border:1px solid:#95b8e7;height:30px; background-color:#e6f0ff">
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'form-lov'" id="previewButton">预览</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'form-exe'" id="submitButton">执行</a>
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-cancel'" id="closeButton">关闭</a>
	</div>
	<div class="easyui-panel" data-options="region:'center',border:true,fit:true" style="width:100%;padding:2px;">
	<form id="buildForm" method="post">
		<div title="基础" class="easyui-panel" data-options="iconCls:'form-config',border:false">
			<table>
			<tr>
				<td style="width:80px;">表名：</td>
				<td>
					<input type="text" id="tableCode" name="tableCode" style="width:234px;" readonly/>
					<input type="hidden" id="types" name="types">
					<input type="hidden" id="datasourceId" name="datasourceId">
					<input type="hidden" id="tableId" name="tableId">
					<input type="hidden" id="tableType" name="tableType">
				</td>
			</tr>
			<tr>
				<td style="width:80px;">工程：</td>
				<td>
					<input class="easyui-combobox" id="templateUrl" name="templateUrl" style="width:240px;"
							data-options="valueField:'templateUrl',textField:'label',url:'dp/project/findList.do?projectId=${projectId}'"/>
				</td>
			</tr>
			</table>
		</div>
		<div title="Spring" class="easyui-panel" data-options="iconCls:'icon-ok',border:false" style="overflow:auto;">
			<table>
			<tr>
				<td style="width:80px;">Action：</td>
				<td>
					<input type="checkbox" name="type" value="Action" onclick="setTypesVal();">
					<input class="easyui-validatebox" style="width:220px;" type="text" name="actionName" />
				</td>
			</tr>
			<tr>
				<td>Bean：</td>
				<td>
					<input type="checkbox" id="bean" name="type" value="Bean" onclick="setTypesVal();">
					<input class="easyui-validatebox" style="width:220px;" type="text" name="beanName" />
				</td>
			</tr>
			<tr>
				<td>Service：</td>
				<td>
					<input type="checkbox" name="type" value="Service" onclick="setTypesVal();">
					<input class="easyui-validatebox" style="width:220px;" type="text" name="serviceName" />
				</td>
			</tr>
			<tr>
				<td>ServiceImpl：</td>
				<td>
					<input type="checkbox" id="serviceImpl" name="type" value="ServiceImpl" onclick="setTypesVal();">
					<input class="easyui-validatebox" style="width:220px;" type="text" name="serviceImplName" />
				</td>
			</tr>
			<tr>
				<td>Dao：</td>
				<td>
					<input type="checkbox" id="dao" name="type" value="Dao" onclick="setTypesVal();">
					<input class="easyui-validatebox" style="width:220px;" type="text" name="daoName" />
				</td>
			</tr>
			</table>
		</div>
		<div title="Mybatis" class="easyui-panel" data-options="iconCls:'db-database',border:false">
			<table>
			<tr>
				<td style="width:80px;">PageSql：</td>
				<td>
					<select class="easyui-combobox" id="pageSqlType" name="pageSqlType" style="width:240px;">
						<option value="mysql">Mysql</option>
						<option value="oracle">Oracle</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>Mapper：</td>
				<td>
					<input type="checkbox" id="mybatis" name="type" value="Mybatis" onclick="setTypesVal();">
					<input class="easyui-validatebox" style="width:220px;" type="text" name="mapperName" />
				</td>
			</tr>
			</table>
		</div>
		<div id="winContext"></div>
	</form>
	</div>
<script type="text/javascript">
$(function(){
	var row = grid_select_record('dg', parent);
	$('#datasourceId').val(row['datasourceId']);
	$('#tableId').val(row['id']);
	$('#tableCode').val(row['code']);
	$('#tableType').val(row['typeCd']);
	win_submit($('#submitButton'), 'buildForm', 'build/doBuild.do', 'win', 'N');
	win_close($('#closeButton'), parent.$('#win'));
	$('#previewButton').click(function(){
		var typesVal = $('#types').val();
		var t = typesVal.split(',');
		if (null ==t || "" ==t || t.length < 1) {
			$.messager.alert('提示信息', '请选择要预览的类型.');
			return;
		}else if(t.length>1) {
			$.messager.alert('提示信息', '只能选择一个类型预览.');
			return;
		}
		var templateUrl = $('#templateUrl').combobox('getValue');
		templateUrl = "tom_develop.xml";
		if(null == templateUrl || '' == templateUrl) {
			$.messager.alert('提示信息', '请选择工程.');
			return;
		}
		var pageSqlType = $('#pageSqlType').combobox('getValue');
		parent.preView(typesVal, templateUrl, pageSqlType);
	});
});
function setTypesVal() {
	var typesVal = ctl_checkbox_value('type');
	$('#types').val(typesVal);
}
</script>
</body>
</html>