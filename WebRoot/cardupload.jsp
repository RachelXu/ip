<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@ taglib uri="/struts-tags" prefix="s2"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>宽宏IPTV播控平台</title>
<link href="style/css/transdmin.css" rel="stylesheet" type="text/css" media="screen" />
<!-- JavaScripts-->
<script language="javascript" type="text/javascript">

</script>
</head>
<body>
	<div id="wrapper">
    	<!-- h1 tag stays for the logo, you can use the a tag for linking the index page -->
    	<h1><a href="#"><span>管理系统</span></a></h1>
    	<!-- // #start mainNav -->
		<%@include file="headbar_card.jsp" %>
        <!-- // #end mainNav -->
        <div id="containerHolder">
			<div id="container">
			<!-- // #start sidebar -->
        		<div id="sidebar">
                	<ul class="sideNav">
                	    <li><a href="precardbatchinsert.action" >充值卡批量生成</a></li>
                	    <li><a href="precarddownload.action">充值卡信息下载</a></li>
                    	<li><a href="precardsearch.action" >充值卡查询</a></li>
                    	<li><a href="precardupload.action" class="active">充值卡批量导入</a></li>
                    	<li><a href="precardbatchedit.action">充值卡批量修改</a></li>
                    	<li><a href="precardbatchdelete.action">充值卡批量删除</a></li>
                    	<li><a href="preserviceinsert.action" >添加服务套餐</a></li>
                    	<li><a href="preservicesearch.action" >服务套餐管理</a></li>
                    </ul>
                </div>    
                <!-- // #end sidebar -->
                
                <!-- main page -->
                <h2><a href="#">充值卡管理</a> &raquo; <a href="#" class="active">充值卡批量导入</a></h2>
                <div id="main1" class="main">
                <p align="left"><s2:fielderror cssStyle="font-size:15px; color:red; font-weight:bold "/></p>
                <s2:form action="procardupload" theme="simple" method="post" enctype="multipart/form-data">
					<h3>批量导入</h3>
						<table width="80%" border="0" cellspacing="1" cellpadding="1" align="center">
							  <tr>
								<td width="92" align="center" valign="middle">&nbsp;</td>
								<td width="138" align="center" valign="middle">选择上传的文件</td>
								<td width="200" align="center" valign="middle"><s2:file name="upload"/> </td>
								<td width="123" align="center" valign="middle"></td>
								<td width="129" align="center" valign="middle"><s2:submit value="上传文件" /> </td>
							  </tr>
						</table>
					<s2:if test="showError">
					<h3>文件中的错误信息</h3>
						 <table width="80%" border="0" align="center" cellpadding="1" cellspacing="1">
						  <tr>
							<td align="center" valign="middle">行号</td>
							<td align="center" valign="middle">错误信息</td>
						  </tr>
						  <s2:iterator value="cardErrorList" var="detil">
						  <tr>
						  	<td align="center" valign="middle"><s2:property value="row"/></td>
							<td align="center" valign="middle"><s2:property value="errorMessage"/></td>
						  </tr>
						  </s2:iterator>
						  </table>
					</s2:if>
					<s2:if test="showNomal">
					<h3>文件中的信息</h3>
						 <table width="80%" border="0" align="center" cellpadding="1" cellspacing="1">
						  <tr>
							<td align="center" valign="middle">用户ID</td>
							<td align="center" valign="middle">充值卡密码</td>
							<td align="center" valign="middle">充值卡状态</td>
							<td align="center" valign="middle">充值时长</td>
							<td align="center" valign="middle">截止日期</td>
							<td align="center" valign="middle">充值日期</td>
						  </tr>
						  <s2:iterator value="cardList" var="detil">
						  <tr>
							<td align="center" valign="middle"><s2:property value="user.id"/></td>
							<td align="center" valign="middle"><s2:property value="pwd"/></td>
							<td align="center" valign="middle">
							<s2:if test="state==1">未用</s2:if>
							<s2:if test="state==2">已用</s2:if>
							<s2:if test="state==3">失效</s2:if>
							</td>
							<td align="center" valign="middle"><s2:property value="day"/></td>
							<td align="center" valign="middle"><s2:property value="enddate"/></td>
							<td align="center" valign="middle"><s2:property value="chargedate"/></td>
						  </tr>
						  </s2:iterator>
						  <tr>
						  <td colspan="6" align="center">
						  <s2:submit value="确认上传" action="procarduploadconfirm" />&nbsp;&nbsp;&nbsp;&nbsp;<s2:submit value="取消" action="precardupload" />
						  </td>
						  </tr>
						  </table>
					</s2:if>
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