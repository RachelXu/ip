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
    	<%@include file="headbar_user.jsp" %>
        <!-- // #end mainNav -->
        <div id="containerHolder">
			<div id="container">
			<!-- // #start sidebar -->
        		<div id="sidebar">
                	<ul class="sideNav">
                    	<li><a href="search_account_accountsearch.action">STB Management</a></li>
                    	<li><a href="preuserupload.action" class="active" >Import STBs</a></li>
                    	<li><a href="add_account_accountadd.action">New a STB</a></li>
                    </ul>
                </div>    
                <!-- // #end sidebar -->
                
                <!-- main page -->
                <h2><a href="#">STB</a> &raquo; <a href="#" class="active"> Import STBs</a></h2>
                <div id="main1" class="main">
                <p align="left"><s2:fielderror cssStyle="font-size:15px; color:red; font-weight:bold "/></p>
                <s2:form action="prouserupload" theme="simple" method="post" enctype="multipart/form-data">
						 <table width="80%" border="0" cellspacing="1" cellpadding="1" align="center">
							  <tr>
								<td width="92" align="center" valign="middle">&nbsp;</td>
								<td width="138" align="center" valign="middle">STB file for importing:</td>
								<td width="200" align="center" valign="middle"><s2:file name="upload"/> </td>
								<td width="123" align="center" valign="middle"></td>
								<td width="129" align="center" valign="middle"><s2:submit value="Import" /> </td>
							  </tr>
							</table>
					<s2:if test="showError">
					<h3>�ļ��еĴ�����Ϣ</h3>
						 <table width="80%" border="0" align="center" cellpadding="1" cellspacing="1">
						  <tr>
							<td align="center" valign="middle">�к�</td>
							<td align="center" valign="middle">������Ϣ</td>
						  </tr>
						  <s2:iterator value="userErrorList" var="detil">
						  <tr>
						  	<td align="center" valign="middle"><s2:property value="row"/></td>
							<td align="center" valign="middle"><s2:property value="errorMessage"/></td>
						  </tr>
						  </s2:iterator>
						  </table>
					</s2:if>
					<s2:if test="showNomal">
					<h3>STB file for importing:</h3>
						 <table width="80%" border="0" align="center" cellpadding="1" cellspacing="1">
						  <tr>
							<td align="center" valign="middle">�û�����</td>
							<td align="center" valign="middle">�û�����</td>
							<td align="center" valign="middle">����</td>
							<td align="center" valign="middle">�绰</td>
							<td align="center" valign="middle">סַ</td>
							<td align="center" valign="middle">�ʻ�״̬</td>
							<td align="center" valign="middle">�ʻ�����</td>
							<td align="center" valign="middle">ʣ������</td>
							<td align="center" valign="middle">����</td>
							<td align="center" valign="middle">��ע</td>
						  </tr>
						  <s2:iterator value="userList" var="detil">
						  <tr>
							<td align="center" valign="middle"><s2:property value="name"/></td>
							<td align="center" valign="middle"><s2:property value="pwd"/></td>
							<td align="center" valign="middle"><s2:property value="age"/></td>
							<td align="center" valign="middle"><s2:property value="phone"/></td>
							<td align="center" valign="middle"><s2:property value="address"/></td>
							<td align="center" valign="middle">
							<s2:if test="state==1">��������</s2:if>
							<s2:if test="state==2">ֹͣ����</s2:if>
							</td>
							<td align="center" valign="middle">
							<s2:if test="type==1">��ͨ�û�</s2:if>
							<s2:if test="type==2">VIP�û�</s2:if>
							</td>
							<td align="center" valign="middle"><s2:property value="restDay"/></td>
							<td align="center" valign="middle"><s2:property value="pici"/></td>
							<td align="center" valign="middle"><s2:property value="comment"/></td>
						  </tr>
						  </s2:iterator>
						  <tr>
						  <td colspan="10" align="center">
						  <s2:submit value="ȷ���ϴ�" action="prouseruploadconfirm" />&nbsp;&nbsp;&nbsp;&nbsp;<s2:submit value="ȡ��" action="preuserupload" />
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