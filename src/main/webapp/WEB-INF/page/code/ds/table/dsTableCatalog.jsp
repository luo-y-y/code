<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
	<title>数据表列表</title>
	<%@include file="/head.jsp" %>
	<script type="text/javascript" src="js/pages/formatter.js"></script>
</head>
<body class="easyui-layout" style="margin:2px" >
	<div data-options="region:'west',split:true,iconCls:'catalog-module'"  style="width:260px; font-size:10px;">
		<table id="dg" class="easyui-datagrid"
				data-options="
				fit:true,
				border:false,
				pagination:true,
				fitColumns: true,
				pageSize: 20,
				iconCls:'form-list',
				onClickRow: onClickRow,
				singleSelect:true,
				url:'ds/table/findPageList.do?datasourceId=${datasourceId}'">
			<thead>
				<tr>
					<th data-options="field:'code',width:120" >表名：
						<input class="easyui-validatebox" type="text" id="code" style="margin:2px 2px 2px 2px;width:120px;"/>
						<a href="javascript:void(0);" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-search'" id="searchBtn">搜索</a>
					</th>
				</tr>
			</thead>
		</table>
	</div>
	<div data-options="region:'center'">
		<div id="tableTabPanel" class="easyui-tabs" data-options="fit:true,border:false"></div>
	</div>
<script type="text/javascript">

$(function(){
	var pager = $('#dg').datagrid('getPager');
	pager.pagination({
		pageSize: 20,
		beforePageText:'',
		afterPageText:'',
		displayMsg:'',
		showPageList:false,
		showRefresh:true	
	});
	
	tab_mask_hide();
	var navigate = {"iconCls":'com-help',"url":'ds/table/goAdd.do',"text":'表'};
	//addTab(navigate, 'tableTabPanel');
	$('#tableTabPanel').tabs('addTab', navigate);
	$('#searchBtn').click(function(){
		var codeVal = $('#code').val();
		$('#dg').datagrid('reload',{code: codeVal});
		tab_mask_hide();
	});
});
function bsMainLoad() {
	$("#dg").datagrid('reload');
	tab_mask_hide();
}
</script>
</body>
</html>