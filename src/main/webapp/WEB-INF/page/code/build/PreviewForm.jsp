<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<title>代码预览表单</title>
	<%@include file="/head.jsp" %>
</head>
<body class="easyui-layout" style="margin:2px;">
	<div id="copy_panel" class="easyui-panel" data-options="region:'north'" style="padding:2px;border:1px solid:#95b8e7;height:30px; background-color:#e6f0ff">
		<a href="javascript:void(0)" class="easyui-linkbutton" data-options="plain:true,iconCls:'icon-cancel'" id="closeButton">关闭</a>
 	</div>
	<div class="easyui-panel" data-options="region:'center',border:true,fit:false" style="width:100%;padding:2px;">
	<form id="buildForm" method="post">
		<div class="easyui-panel" data-options="iconCls:'icon-ok',border:false" style="height:450px;">
			<table style="width:100%">
			<tr>
				<td><div>${context}</div></td>
			</tr>
			</table>
		</div>
	</form>
	</div>
	<div id="copydiv" class="easyui-dialog" title="生成代码" data-options="modal:true,minimizable:false,closed:true,iconCls:'icon-edit'" 
		style="width:400px;height:440px;padding:0px;">
		<iframe id="copydivform" scrolling="no" frameborder="0" style="width:100%;height:99%"></iframe>
	</div>
<script type="text/javascript">

$(function(){
	form_close_tab($('#closeButton'));
	jk();
	tab_mask_hide();
});

function jk(){
	document.onkeydown=function(event){   
	    var e = event || window.event || arguments.callee.caller.arguments[0];   
	    if (e.keyCode == 65 && e.ctrlKey) {    
	    	$("#copy_panel").hide();
	    }else if (e.keyCode == 67 || e.ctrlKey) {    
	    	$("#copy_panel").hide();
	    }else{
	    	$("#copy_panel").show();
	    }
	    
	    //$("#copy_panel").show();
	 };  
	 
	 document.onmousedown=function(event){ 
		 var buttonInt =  event.button;
		 if("2" != buttonInt){
			$("#copy_panel").show();
		 }
	 }
}

 
</script>
</body>
</html>