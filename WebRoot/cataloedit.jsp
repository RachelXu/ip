<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@ taglib uri="/struts-tags" prefix="s2"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>宽宏IPTV播控平台</title>
<link href="style/css/transdmin.css" rel="stylesheet" type="text/css" media="screen" />
<!-- JavaScripts-->
<script language="javascript" type="text/javascript">
function edit(parm){
document.getElementsByName("editId")[0].value=parm;
return true;
}
function del(parm){
document.getElementsByName("deleteId")[0].value=parm;
return true;
}
</script>
</head>
<body>
	<div id="wrapper">
    	<!-- h1 tag stays for the logo, you can use the a tag for linking the index page -->
    	<h1><a href="#"><span>管理系统</span></a></h1>
    	<!-- // #start mainNav -->
		<%@include file="headbar_media.jsp" %>
        <!-- // #end mainNav -->
        <div id="containerHolder">
			<div id="container">
			<!-- // #start sidebar -->
        		<div id="sidebar">
                	<ul class="sideNav">
                    	<li><a href="precatalogman.action"  class="active">目录管理</a></li>
                    	<li><a href="premediasearch.action">节目内容管理</a></li>
                    	<li><a href="premediainsert.action">节目内容添加</a></li>
                    	<li><a href="premediabatchupload.action">节目内容批量上传</a></li>
                    	<s2:if test='#session.admin.level.equals("1") || #session.admin.level.equals("2")'>
                    	<li><a href="premediaapprove.action">确认节目审核通过</a></li>
                    	</s2:if>
                    	<s2:if test='#session.admin.level.equals("1") '>
                    	<li><a href="premediadisapprove.action" >确认节目发布</a></li>
                    	</s2:if>
                    </ul>
                </div>    
                <!-- // #end sidebar -->
                
                <!-- main page -->
                <h2><a href="#">节目信息管理</a> &raquo; <a href="#" class="active">目录管理</a></h2>
                <div id="main1" class="main">
                <p align="left"><s2:fielderror cssStyle="font-size:15px; color:red; font-weight:bold "/></p>
                <s2:form action="procatalogedit" theme="simple">
                <s2:hidden name="deleteId"/>
                <s2:hidden name="editId"/>
					<h3>修改栏目信息</h3>
						<table>
						<tr>
							<td>栏目ID:</td>
							<td><s2:textfield name="catalogEdit.catalogId" size="10" maxlength="5" readonly="true" /></td>
							<td></td>
							<td></td>
						</tr>
						<tr>
							<td>栏目中文名称:</td>
							<td><s2:textfield name="catalogEdit.catalogZhName"  size="10" maxlength="10" /></td>
							<td>栏目英文名称:</td>
							<td><s2:textfield name="catalogEdit.catalogEnName"  size="10" maxlength="10"/></td>
						</tr>
						<tr>
							<td>显示顺序:</td>
							<td><s2:textfield name="catalogEdit.order"  size="3" maxlength="3"/></td>
							<td>上级栏目:</td>
							<td><s2:select list="catalogEdit.firstLeveList" name="catalogEdit.superId" listKey="value" listValue="label" headerKey="" headerValue="-">
								<s2:iterator value="catalogEdit.secondLabel" var="sencondLable" status="status" >
								<s2:optgroup label="%{sencondLable}" list="catalogEdit.sencondLeveList.get(#status.index)" listKey="value" listValue="label">
								</s2:optgroup>
								</s2:iterator>
								</s2:select>
							</td>
						</tr>
						<tr>
						<td colspan="4" align="center" >
							<s2:submit value="确认修改"/>&nbsp;&nbsp;&nbsp;&nbsp;
							<s2:submit value="取消" onclick="history.back();return false; " />
						</td>
						</tr>
						</table>
                   </s2:form>
                </div>
              
				<div class="clear"></div>
            </div>
            <!-- // #container -->
        </div>	
        <!-- // #containerHolder -->
        
        <p id="footer">Feel free to use and customize it. <a href="#">Credit is appreciated.</a></p>
    </div>
    <!-- // #wrapper -->
</body>
</html>