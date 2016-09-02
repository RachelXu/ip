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
		<%@include file="headbar_media.jsp" %>
        <!-- // #end mainNav -->
        <div id="containerHolder">
			<div id="container">
			<!-- // #start sidebar -->
        		<div id="sidebar">
                	<ul class="sideNav">
                    	<li><a href="premediasearch.action">Media Management</a></li>
                    	<li><a href="precatalogman.action" >Directory Management</a></li>
                    	<li><a href="premediainsert.action" >New Media</a></li>
                    	<li><a href="premediabatchupload.action"   class="active">Import Medias</a></li>
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
                <h2><a href="#">节目信息管理</a> &raquo; <a href="#" class="active">节目内容批量上传</a></h2>
                <div id="main1" class="main">
                <p align="left"><s2:fielderror cssStyle="font-size:15px; color:red; font-weight:bold "/></p>
                <s2:form action="promediabatchupload" theme="simple" method="post" enctype="multipart/form-data">
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
						  <s2:iterator value="mediaErrorList" var="detil">
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
							<td align="center" valign="middle">节目中文名称</td>
							<td align="center" valign="middle">节目英文名称</td>
							<td align="center" valign="middle">节目目录ID</td>
							<td align="center" valign="middle">语言</td>
							<td align="center" valign="middle">地区</td>
							<td align="center" valign="middle">源链接</td>
						  </tr>
						  <s2:iterator value="viewMediaList" var="detil">
						  <tr>
							<td align="center" valign="middle"><s2:property value="mediaName"/></td>
							<td align="center" valign="middle"><s2:property value="mediaNameEn"/></td>
							<td align="center" valign="middle"><s2:property value="catalogId"/></td>
							<td align="center" valign="middle"><s2:property value="language"/></td>
							<td align="center" valign="middle"><s2:property value="area"/></td>
							<td align="center" valign="middle"><s2:property value="link"/></td>
						  </s2:iterator>
						  <tr>
						  <td colspan="6" align="center">
						  <s2:submit value="确认上传" action="promediabatchuploadconfirm" />&nbsp;&nbsp;&nbsp;&nbsp;<s2:submit value="取消" action="premediabatchupload" />
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