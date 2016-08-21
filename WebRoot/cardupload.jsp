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
		<%@include file="headbar_card.jsp" %>
        <!-- // #end mainNav -->
        <div id="containerHolder">
			<div id="container">
			<!-- // #start sidebar -->
        		<div id="sidebar">
                	<ul class="sideNav">
                	    <li><a href="precardbatchinsert.action" >��ֵ����������</a></li>
                	    <li><a href="precarddownload.action">��ֵ����Ϣ����</a></li>
                    	<li><a href="precardsearch.action" >��ֵ����ѯ</a></li>
                    	<li><a href="precardupload.action" class="active">��ֵ����������</a></li>
                    	<li><a href="precardbatchedit.action">��ֵ�������޸�</a></li>
                    	<li><a href="precardbatchdelete.action">��ֵ������ɾ��</a></li>
                    	<li><a href="preserviceinsert.action" >��ӷ����ײ�</a></li>
                    	<li><a href="preservicesearch.action" >�����ײ͹���</a></li>
                    </ul>
                </div>    
                <!-- // #end sidebar -->
                
                <!-- main page -->
                <h2><a href="#">��ֵ������</a> &raquo; <a href="#" class="active">��ֵ����������</a></h2>
                <div id="main1" class="main">
                <p align="left"><s2:fielderror cssStyle="font-size:15px; color:red; font-weight:bold "/></p>
                <s2:form action="procardupload" theme="simple" method="post" enctype="multipart/form-data">
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
						  <s2:iterator value="cardErrorList" var="detil">
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
							<td align="center" valign="middle">�û�ID</td>
							<td align="center" valign="middle">��ֵ������</td>
							<td align="center" valign="middle">��ֵ��״̬</td>
							<td align="center" valign="middle">��ֵʱ��</td>
							<td align="center" valign="middle">��ֹ����</td>
							<td align="center" valign="middle">��ֵ����</td>
						  </tr>
						  <s2:iterator value="cardList" var="detil">
						  <tr>
							<td align="center" valign="middle"><s2:property value="user.id"/></td>
							<td align="center" valign="middle"><s2:property value="pwd"/></td>
							<td align="center" valign="middle">
							<s2:if test="state==1">δ��</s2:if>
							<s2:if test="state==2">����</s2:if>
							<s2:if test="state==3">ʧЧ</s2:if>
							</td>
							<td align="center" valign="middle"><s2:property value="day"/></td>
							<td align="center" valign="middle"><s2:property value="enddate"/></td>
							<td align="center" valign="middle"><s2:property value="chargedate"/></td>
						  </tr>
						  </s2:iterator>
						  <tr>
						  <td colspan="6" align="center">
						  <s2:submit value="ȷ���ϴ�" action="procarduploadconfirm" />&nbsp;&nbsp;&nbsp;&nbsp;<s2:submit value="ȡ��" action="precardupload" />
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