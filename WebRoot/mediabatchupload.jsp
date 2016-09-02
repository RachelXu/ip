<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@ taglib uri="/struts-tags" prefix="s2"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>���IPTV����ƽ̨</title>
<link href="style/css/transdmin.css" rel="stylesheet" type="text/css" media="screen" />
<!-- JavaScripts-->
<script language="javascript" type="text/javascript">

</script>
</head>
<body>
	<div id="wrapper">
    	<!-- h1 tag stays for the logo, you can use the a tag for linking the index page -->
    	<h1><a href="#"><span>����ϵͳ</span></a></h1>
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
                    	<li><a href="premediaapprove.action">ȷ�Ͻ�Ŀ���ͨ��</a></li>
                    	</s2:if>
                    	<s2:if test='#session.admin.level.equals("1") '>
                    	<li><a href="premediadisapprove.action" >ȷ�Ͻ�Ŀ����</a></li>
                    	</s2:if>
                    </ul>
                </div>    
                <!-- // #end sidebar -->
                
                <!-- main page -->
                <h2><a href="#">��Ŀ��Ϣ����</a> &raquo; <a href="#" class="active">��Ŀ���������ϴ�</a></h2>
                <div id="main1" class="main">
                <p align="left"><s2:fielderror cssStyle="font-size:15px; color:red; font-weight:bold "/></p>
                <s2:form action="promediabatchupload" theme="simple" method="post" enctype="multipart/form-data">
 					<h3>��������</h3>
						 <table width="80%" border="0" cellspacing="1" cellpadding="1" align="center">
							  <tr>
								<td width="92" align="center" valign="middle">&nbsp;</td>
								<td width="138" align="center" valign="middle">ѡ���ϴ����ļ�</td>
								<td width="200" align="center" valign="middle"><s2:file name="upload"/> </td>
								<td width="123" align="center" valign="middle"></td>
								<td width="129" align="center" valign="middle"><s2:submit value="�ϴ��ļ�" /> </td>
							  </tr>
							</table>
					<s2:if test="showError">
					<h3>�ļ��еĴ�����Ϣ</h3>
						 <table width="80%" border="0" align="center" cellpadding="1" cellspacing="1">
						  <tr>
							<td align="center" valign="middle">�к�</td>
							<td align="center" valign="middle">������Ϣ</td>
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
					<h3>�ļ��е���Ϣ</h3>
						 <table width="80%" border="0" align="center" cellpadding="1" cellspacing="1">
						  <tr>
							<td align="center" valign="middle">��Ŀ��������</td>
							<td align="center" valign="middle">��ĿӢ������</td>
							<td align="center" valign="middle">��ĿĿ¼ID</td>
							<td align="center" valign="middle">����</td>
							<td align="center" valign="middle">����</td>
							<td align="center" valign="middle">Դ����</td>
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
						  <s2:submit value="ȷ���ϴ�" action="promediabatchuploadconfirm" />&nbsp;&nbsp;&nbsp;&nbsp;<s2:submit value="ȡ��" action="premediabatchupload" />
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