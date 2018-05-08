<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<title>字段模板列表</title>
	<%@include file="/head.jsp" %>
	<script type="text/javascript" src="js/pages/formatter.js"></script>
</head>
<body class="easyui-layout" style="margin:2px">
	<!-- multiple: true, 多选-->
	<div data-options="region:'center'" style="border:0px;">
	<table id="tempdg" class="easyui-datagrid" title="字段模板列表"
			data-options="rownumbers:true,
			fit:true,
			border:true,
			pagination:true,
			fitColumns: true,
			toolbar:toolbar,
			pageSize: 20,
			iconCls:'form-list',
			onClickRow: onClickRow,
			onLoadSuccess: deleteRows,
			singleSelect:false,
			url:'ds/column/findPageList.do?tableId=${tempId}'">
		<thead>
			<tr>
				<th data-options="field:'id',checkbox:true"></th>
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
var saveBtn = {text:'保存', iconCls:'icon-save', id:'saveBtn'};
var toolbar = [saveBtn];
$(function(){
	tab_mask_hide();
	grid_save_batch($('#saveBtn'), 'ds/column/doSaveBatch.do?tableId=${tableId}', 'tempdg', 1);
});
function deleteRows() {
	var rows = $('#tempdg').datagrid('getRows');
	var pRows = parent[1].$('#dsColumnDg').datagrid('getRows');
	grid_delrows_compare_impl('tempdg', rows, pRows, 'code');
}
</script>
</body>
</html>