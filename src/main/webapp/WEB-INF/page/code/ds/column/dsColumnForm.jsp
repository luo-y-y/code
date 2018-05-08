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
	<form id="dsColumnForm" method="post">
		<input type="hidden" name="id" />
		<input type="hidden" name="isValid" value="Y"/>
		<input type="hidden" id="datasourceId" name="datasourceId"/>
		<input type="hidden" id="tableId" name="tableId" />
		<table class="form-table">
			<tr>
				<td><div>表代码：</div><input class="easyui-validatebox" type="text" id="tableCode" disabled/></td>
				<td><div>表中文名：</div><input class="easyui-validatebox" type="text" id="tableLabel" disabled /></td>
			</tr>
			<tr>
				<td><div>字段代码：</div><input class="easyui-validatebox" type="text" id="code" name="code" data-options="required:true" /></td>
				<td><div>英文名称：</div><input class="easyui-validatebox" type="text" name="name" data-options="required:true"/></td>
			</tr>
			<tr>
				<td><div>中文名称：</div><input type="text" name="label" data-options="required:true" /></td>
				<td><div>数据类型：</div>
					<select class="easyui-combobox" id="dataType" name="dataType" style="width:224px;">
						<option value="varchar">varchar</option>
						<option value="bigint">bigint</option>
						<option value="char">char</option>
						<option value="int">int</option>
						<option value="integer">integer</option>
						<option value="date">date</option>
						<option value="timestamp">timestamp</option>
						<option value="double">double</option>
						<option value="float">float</option>
						<option value="text">text</option>
						<option value="longtext">longtext</option>
						<option value="blob">blob-65K</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><div>是否主键：</div>
					<select class="easyui-combobox" id="isPk" name="isPk" style="width:224px;">
						<option value="Y">是</option>
						<option value="N" selected="selected">否</option>
					</select>
				</td>
				<td><div>是否为空：</div>
					<select class="easyui-combobox" id="isNull" name="isNull" style="width:224px;">
						<option value="Y" selected="selected">为空</option>
						<option value="N">不为空</option>
					</select>
				</td>
			</tr>
			<tr>
				<td><div>字段类型：</div>
					<select class="easyui-combobox" id="typeCd" name="typeCd" style="width:224px;">
						<option value="R" selected="selected">实</option>
						<option value="V">虚</option>
					</select>
				</td>
				<td><div>数据长度：</div><input type="text" id="dataLength" name="dataLength"/></td>
			</tr>
			<tr>
				<td colspan="2"><div>默认值：</div><input type="text" name="defaultValue" style="width:526px;"/></td>
			</tr>
			<tr>
				<td><div>是否唯一：</div>
					<select class="easyui-combobox" name="isUnique" style="width:224px;">
						<option value="N" selected="selected">非唯一</option>
						<option value="Y">唯一</option>
					</select>
				</td>
				<td><div>排序：</div><input type="text" name="sortNum" data-options="required:true"/></td>
			</tr>
			<tr>
				<td colspan="2"><div>外键：</div><input type="text" name="foreignKey" style="width:526px;"/></td>
			</tr>
			<tr style="display: none;" id="hideCreateLine">
				<td><div>创建者：</div><input type="text" name="createUserLabel" disabled/></td>
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
	var params = {'url':"code/ds/column/load.do", 'gridId':'dsColumnDg', 'pKey':null, 'toTabIndex':1};
	var row = grid_select_record('dg', parent[0]);
	$('#datasourceId').val(row.datasourceId);
	$('#tableId').val(row.id);
	$('#tableCode').val(row.code);
	$('#tableLabel').val(row.label);
	if('H' == operate) {
		params = {'url':"code/ds/column/loadHs.do", 'gridId':'hsdg', 'pKey':null, 'toTabIndex':1};
	}
	form_load('dsColumnForm', operate, params);
	tab_mask_hide();
	$("#submitButton").click(function(){
		if(this.disabled == true) {return;}
		var typeCdVal = $('#typeCd').combobox('getValue');
		var isPkVal = $('#isPk').combobox('getValue');
		var codeVal = $('#code').val();
		var pRows = parent[1].$('#dsColumnDg').datagrid('getRows');
		var codeCount = 0;
		var pkCount = 0;
		for (var j= 0; j < pRows.length; j++) {
			if(codeVal == pRows[j]['code']) {
				codeCount++;
			}
			if('Y'== isPkVal && 'Y' == pRows[j]['isPk']) {
				pkCount++;
			}
		}
		if(pkCount > 2) {
			$.messager.alert('提示信息', '主键已经存在!');
			return;
		}
		if(codeCount > 2) {
			$.messager.alert('提示信息', '字段['+codeVal+']已经存在!');
			return;
		}
		if('Y' == isPkVal && 'V'==typeCdVal) {
			$.messager.alert('提示信息', '当字段类型为虚字段时，是否主键选项不能选择为是!');
			return;
		}
		var dataTypeVal = $('#dataType').combobox('getValue');
		var dataLengthVal = $('#dataLength').val();
		if('R'==dataTypeVal && ('varchar' == dataTypeVal || 'char' == dataTypeVal || 'text' == dataTypeVal)) {
			if(null == dataLengthVal || "" == dataLengthVal) {
				$.messager.alert('提示信息', '数据长度必须填写');
				return;
			}
		}
		form_submit_impl('dsColumnForm', 'code/ds/column/doSave.do', parent[1]);
	});
	//form_submit($("#submitButton"), 'dsColumnForm', 'code/ds/column/doSave.do', 1);
	form_clear($("#clearButton"), 'dsColumnForm');
	
});
</script>
</body>
</html>