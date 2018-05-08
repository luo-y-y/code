<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<title>数据表列表</title>
	<%@include file="/head.jsp" %>
	<script type="text/javascript" src="js/pages/formatter.js"></script>
</head>
<body class="easyui-layout" style="margin:2px">
	<div class="easyui-panel" title="查询" data-options="region:'north',iconCls:'form-zoom'" style="height:60px; padding:0 0 0 10px;">
		<form id="searchForm" method="post">
			<table class="form-search">
				<tr>
					<td>表英文名：</td>
					<td><input class="easyui-validatebox" type="text" name="code" ></input></td>
					<td>表中文名：</td>
					<td><input class="easyui-validatebox" type="text" name="label" ></input></td>
					<td>
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search',toggle:true" id="searchBtn">查询</a>
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-cancel',toggle:true" id="clearBtn">清除</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
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
			url:'code/ds/table/findPageList.do?datasourceId=${datasourceId}'">
		<thead>
			<tr>
				<th data-options="field:'id',checkbox:true"></th>
				<th data-options="field:'typeCd',width:40, formatter:getTableTypelabel">表类型</th>
				<th data-options="field:'code',width:120,editor:'text'" >表名</th>
				<th data-options="field:'label',width:80,editor:'text'">中文名</th>
				<th data-options="field:'tablespaceName',width:80">表空间</th>
				<th data-options="field:'sequenceName',width:80">序列名</th>
				<th data-options="field:'linkUnique',width:120">联合主键</th>
				<th data-options="field:'updateDate',width:110">更新时间</th>
			</tr>
		</thead>
	</table>
	</div>
	<div id="exeMySqlMenu" style="width:120px;">
		<div data-options="iconCls:'db-tab'" id="viewMySqlTableBtn">MySql-表</div>
		<div data-options="iconCls:'form-history'" id="viewMySqlFieldBtn">MySql-表字段</div>
	</div>
	<div id="exeOracleSqlMenu">
		<div data-options="iconCls:'db-tab'">Oracle-表</div>
		<div data-options="iconCls:'db-col'" id="viewOracleFieldBtn">Oracle-表字段</div>
		<div data-options="iconCls:'form-history'">Oracle-历史</div>
		<div data-options="iconCls:'db-seq'">Oracle-序列</div>
		<div data-options="iconCls:'db-view'">Oracle-视图</div>
		<div data-options="iconCls:'db-pkg'">Oracle-存储过程</div>
	</div>
	<div id="win" class="easyui-dialog" title="生成代码" data-options="modal:true,minimizable:false,closed:true,iconCls:'icon-edit'" 
		style="width:400px;height:440px;padding:0px;">
		<iframe id="buildWinForm" scrolling="no" frameborder="0" style="width:100%;height:99%"></iframe>
	</div>
<script type="text/javascript">
var viewColunmBtn = {text:'表字段', iconCls:'db-col', id:'viewColunmBtn'};
var exeJavaBtn = {text:'生成代码', iconCls:'form-exe', id:'exeJavaBtn'};
var exeMySqlBtn = {text:'预览MySql', iconCls:'form-lov', id:'exeMySqlBtn'};
var exeOraleSqlBtn = {text:'预览Oracle', iconCls:'form-lov', id:'exeOraleSqlBtn'};

var buttons = [viewColunmBtn, exeJavaBtn, exeMySqlBtn, exeOraleSqlBtn];
var permissionObj = '${formGrantData}';
// 构造工具栏
var toolbar = form_toolbar(buttons);
// 生成页面工具栏
var buildButton = {id:'buildButton', text:'执行',iconCls:'form-exe'};
var cannelButton = {id:'cannelButton',text:'取消',iconCls:'icon-cancel'};
var winToolbar = [buildButton,'-',cannelButton];
$(function(){
	$('#exeMySqlBtn .l-btn-text').attr("class","splitbutton").menubutton({menu: '#exeMySqlMenu'});
	$('#exeOraleSqlBtn .l-btn-text').attr("class","splitbutton").menubutton({menu: '#exeOracleSqlMenu'});
	// 表单控件权限
	 //form_obj_control(permissionObj, 'disable');
	tab_mask_hide();
	form_search($('#searchBtn'), 'searchForm', 'dg');
	form_clear($('#clearBtn'), 'searchForm');
	form_add($("#addBtn"), 'code/ds/table/goAdd.do?datasourceId=${datasourceId}');
	form_update($("#updateBtn"), 'code/ds/table/goEdit.do', 'dg');
	form_delete($("#deleteBtn"), 'code/ds/table/doDelete.do', 'dg');
	form_view($("#viewBtn"), 'code/ds/table/goView.do', 'dg');
	form_view($("#viewColunmBtn"), 'code/ds/column/goMain.do', 'dg', 'db-col', null, "id,code,datasourceId");
	form_view($("#viewHistoryBtn"), 'code/ds/table/goViewHistory.do', 'dg', 'form-history');
	//win_ifm_open($("#extJavaBtn"), 'win', 'buildWinForm', 'build/goForm.do', 'dg');
	$("#exeJavaBtn").click(function(){
		if(this.disabled == true) {return;}
		var row = grid_select_record('dg');
		if(undefined == row || null == row) {
			$.messager.alert('提示信息', '请选择需要生成的记录');
			return;
		}
		if(row.typeCd == 'T') {
			$.messager.alert('提示信息', '模板不提供生成功能.');
			return;
		}
		win_ifm_open_impl('win', 'buildWinForm', 'build/goForm.do?projectId=${projectId}', null);
	});
	var templateUrl ="tom_develop.xml";
	$('#viewMySqlTableBtn').click(function(){
		var row = grid_select_record('dg');
		if(undefined == row || null == row) {
			$.messager.alert('提示信息', '请选择需查看的记录');
			return;
		}
		form_view_impl('MySql-表','build/goPreview.do?types=MySqlTable&templateUrl='+templateUrl, row, 'db-tab', null, 'id,code,typeCd,datasourceId');
	});
	$('#viewMySqlTableHsBtn').click(function(){
		var row = grid_select_record('dg');
		if(undefined == row || null == row) {
			$.messager.alert('提示信息', '请选择需查看的记录');
			return;
		}
		form_view_impl('MySql-历史表','build/goPreview.do?types=MySqlTableHs&templateUrl='+templateUrl, row, 'form-history', null, 'id,code,typeCd,datasourceId');
	});
	$('#viewMySqlFieldBtn').click(function(){
		var row = grid_select_record('dg');
		if(undefined == row || null == row) {
			$.messager.alert('提示信息', '请选择需查看的记录');
			return;
		}
		form_view_impl('MySql-表字段','build/goPreview.do?types=MySqlField&templateUrl='+templateUrl, row, 'db-col', null, 'id,code,typeCd,datasourceId');
	});

});
function bsMainLoad() {
	$("#dg").datagrid('reload');
	tab_mask_hide();
}

function preView(types, templateUrl, pageSqlType) {
	var p = 'types='+types+'&templateUrl='+templateUrl+'&pageSqlType='+pageSqlType;
	var row = grid_select_record('dg');
	if(undefined == row || null == row) {
		$.messager.alert('提示信息', '请选择需查看的记录');
		return;
	}
	form_view_impl('预览代码','build/goPreview.do?'+p, row, 'form-lov', null , 'id,code,typeCd,datasourceId');
}
</script>
</body>
</html>