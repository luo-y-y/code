<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<title>字段历史操作列表</title>
	<%@include file="/head.jsp" %>
	<script type="text/javascript" src="js/pages/formatter.js"></script>
</head>
<body class="easyui-layout" style="margin:2px">
	<!-- multiple: true, 多选-->
	<div data-options="region:'center'" style="border:0px;">
	<table id="hsdg" class="easyui-datagrid" title="操作历史"
			data-options="rownumbers:true,
			fit:true,
			border:true,
			pagination:true,
			fitColumns: true,
			toolbar:toolbar,
			pageSize: 20,
			iconCls:'form-list',
			onClickRow: onClickRow,
			singleSelect:true,
			url:'ds/column/findPageHsList.do?recordId=${id}'">
		<thead>
			<tr>
				<th data-options="field:'id',checkbox:true"></th>
				<th data-options="field:'historyCd',width:40,align:'right', formatter:getHistorylabel">操作状态</th>
				<th data-options="field:'code',width:120" >字段名</th>
				<th data-options="field:'label',width:80">中文名</th>
				<th data-options="field:'isNull',width:40">允许为空</th>
				<th data-options="field:'isPk',width:40">是否主键</th>
				<th data-options="field:'dataType',width:40">数据类型</th>
				<th data-options="field:'dataLength',width:40">长度</th>
				<th data-options="field:'defaultValue',width:40">默认值</th>
				<th data-options="field:'foreignKey',width:40">外键</th>
				<th data-options="field:'sortNum',width:40">排序</th>
			</tr>
		</thead>
	</table>
	</div>	
<script type="text/javascript">
var viewHistoryDetailBtn = {text:'查看历史详情', iconCls:'form-view', id:'viewHistoryDetailBtn'};
var toolbar = [viewHistoryDetailBtn];
$(function(){
	tab_mask_hide();
	//var row = grid_select_record('dg', parent[0]);
	//$('#hsdg').datagrid('load',{recordId: row.id});
	form_view($("#viewHistoryDetailBtn"), 'ds/column/goViewHistoryForm.do', 'hsdg', null, 2);
});
</script>
</body>
</html>