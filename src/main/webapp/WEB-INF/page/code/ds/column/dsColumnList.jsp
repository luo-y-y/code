<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<title>数据表列表</title>
	<%@include file="/head.jsp" %>
	<script type="text/javascript" src="js/pages/formatter.js"></script>
</head>
<body class="easyui-layout" style="margin:2px">
	<!-- multiple: true, 多选-->
	<div data-options="region:'center'" style="border:0px;">
	<table id="dsColumnDg" class="easyui-datagrid" title="表：[${id}]  -  [${code}]"
			data-options="rownumbers:true,
			fit:true,
			border:true,
			toolbar:toolbar,
			fitColumns: true,
			pagination:true,
			pageSize: 50,
			onClickRow: onClickRow,
			onClickCell: onClickCell,
			iconCls:'form-list',
			singleSelect:true,
			url:'code/ds/column/findPageList.do?tableId=${id}'">
		<thead>
			<tr>
				<th data-options="field:'id',checkbox:true"></th>
				<th data-options="field:'typeCd',width:20, formatter:getColumnTypelabel" >类型</th>
				<th data-options="field:'sortNum',width:20, editor:{type:'numberbox'}">排序</th>
				<th data-options="field:'code',width:120,editor:'text'" >字段名</th>
				<th data-options="field:'label',width:80,editor:'text'">中文名</th>
				<th data-options="field:'isNull',width:30,editor:'text'">允许为空</th>
				<th data-options="field:'isPk',width:30, formatter:getColumnPkImage">是否主键</th>
				<th data-options="field:'dataType',width:50,editor:'text'">数据类型</th>
				<th data-options="field:'dataLength',width:30,editor:{type:'numberbox'}">长度</th>
				<th data-options="field:'isUnique',width:30,editor:'text'">是否唯一</th>
				<th data-options="field:'defaultValue',width:30,editor:'text'">默认值</th>
				<th data-options="field:'foreignKey',width:30,editor:'text'">外键</th>
			</tr>
		</thead>
	</table>
	</div>
<script type="text/javascript">
var saveBtn = {text:'保存', iconCls:'icon-save', id:'saveBtn'};
var tempBtn = {text:'字段模板', iconCls:'icon-add', id:'tempBtn'};
var buttons = [tempBtn, saveBtn];
//var permissionObj = [];
// 构造工具栏
var toolbar = form_toolbar(buttons);
$(function(){
	// 控件工具栏按键
	//form_toolbar_control(permissionObj, 'disable');
	tab_mask_hide();
	form_add($("#addBtn"), 'code/ds/column/goAdd.do', 2);
	form_update($("#updateBtn"), 'code/ds/column/goEdit.do', 'dsColumnDg', 2);
	form_delete($("#deleteBtn"), 'code/ds/column/doDelete.do', 'dsColumnDg');
	form_view($("#viewBtn"), 'code/ds/column/goView.do', 'dsColumnDg', null, 2);
	
	grid_save_single($('#saveBtn'), 'code/ds/column/doSave.do', 'dsColumnDg');
	form_simple_view($("#tempBtn"), 'code/ds/column/goTemp.do?&tableId=${id}&tempId=1864', 'icon-add', 2, null);

});

function bsMainLoad() {
	$("#dsColumnDg").datagrid('reload');
	tab_mask_hide();
}
function onClickCell(index, field){
	if (grid_endEditing('dsColumnDg')){
		$('#dsColumnDg').datagrid('selectRow', index).datagrid('editCell', {index:index,field:field});
		editIndex = index;
	}
}
</script>
</body>
</html>