<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<title>数据源历史列表</title>
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
			url:'ds/table/findPageHsList.do?recordId=${id}'">
		<thead>
			<tr>
				<th data-options="field:'id',checkbox:true"></th>
				<th data-options="field:'historyCd',width:40,align:'right', formatter:getHistorylabel">操作状态</th>
				<th data-options="field:'typeCd',width:40, formatter:getTableTypelabel">表类型</th>
				<th data-options="field:'code',width:120" >表名</th>
				<th data-options="field:'label',width:80">中文名</th>
				<th data-options="field:'tablespaceName',width:80">表空间</th>
				<th data-options="field:'sequenceName',width:80">序列名</th>
				<th data-options="field:'updateDate',width:110">更新时间</th>
			</tr>
		</thead>
	</table>
	</div>	
<script type="text/javascript">
var viewHistoryDetailBtn = {text:'查看历史详情', iconCls:'form-view', id:'viewHistoryDetailBtn'};
var toolbar = [viewHistoryDetailBtn];
$(function(){
	tab_mask_hide();
	form_view($("#viewHistoryDetailBtn"), 'ds/table/goViewHistoryForm.do', 'hsdg', null, 2);
});
</script>
</body>
</html>