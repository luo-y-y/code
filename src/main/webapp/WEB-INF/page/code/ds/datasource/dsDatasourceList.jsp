<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<title>数据源列表</title>
	<%@include file="/head.jsp" %>
</head>
<body class="easyui-layout" style="margin:2px">
	<!-- multiple: true, 多选-->
	<div data-options="region:'center'" style="border:0px;">
	<table id="dg" class="easyui-datagrid" title="业务"
			data-options="rownumbers:true,
			fit:true,
			border:true,
			pagination:true,
			toolbar:toolbar,
			fitColumns: true,
			pageSize: 20,
			iconCls:'form-list',
			onClickRow: onClickRow,
			singleSelect:true,
			url:'code/ds/datasource/findPageList.do'">
		<thead>
			<tr>
				<th data-options="field:'id',checkbox:true"></th>
				<th data-options="field:'projectId',width:40" >项目编号</th>
				<th data-options="field:'projectLabel',width:60" >项目名称</th>
				<th data-options="field:'typeCd',width:40" >类型</th>
				<th data-options="field:'code',width:80" >代码</th>
				<th data-options="field:'label',width:80">中文名字</th>
				<th data-options="field:'userName',width:60">账号</th>
				<th data-options="field:'userPassword',width:60">密码</th>
				<th data-options="field:'updateDate',width:110">更新时间</th>
			</tr>
		</thead>
	</table>
	</div>
<script type="text/javascript">
// 构造工具栏
var toolbar = form_toolbar();
$(function(){
	tab_mask_hide();
	form_add($("#addBtn"), 'code/ds/datasource/goAdd.do');
	form_update($("#updateBtn"), 'code/ds/datasource/goEdit.do', 'dg');
	form_delete($("#deleteBtn"), 'code/ds/datasource/doDelete.do', 'dg');
	form_view($("#viewBtn"), 'code/ds/datasource/goView.do', 'dg');
});
function bsMainLoad() {
	$("#dg").datagrid('reload');
	tab_mask_hide();
}
</script>
</body>
</html>