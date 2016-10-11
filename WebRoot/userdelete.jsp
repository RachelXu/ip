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
                    	<li><a href="search_account_accountsearch.action" class="active" >�˻���ѯ</a></li>
                    	<li><a href="preuserupload.action" >�˻���������</a></li>
                    	<li><a href="preuserbatchedit.action">�˻������޸�</a></li>
                    	<li><a href="preuserbatchdelete.action">�˻�����ɾ��</a></li>
                    </ul>
                </div>    
                <!-- // #end sidebar -->
                
                <!-- main page -->
                <h2><a href="#">�˻�����</a> &raquo; <a href="#" class="active">�˻���ѯ</a></h2>
                <div id="main1" class="main">
                <p align="left"><s2:fielderror cssStyle="font-size:15px; color:red; font-weight:bold "/></p>
                <s2:form action="prouserdelete" theme="simple">
                <s2:hidden name="deleteId"/>
					<h3>ɾ����Ϣ</h3>
                    	<table border="1">	
							<tr>
							  <td>�˻�ID</td>
							  <td><s2:textfield name="userDelete.id" size="10" maxlength="5" readonly="true" /></td>
							  <td>�û�����</td>
							  <td><s2:textfield name="userDelete.name" size="10" maxlength="10" readonly="true"/></td>
							</tr>
							<tr>
							  <td>����</td>
							  <td><s2:textfield name="userDelete.age" size="10" maxlength="5" readonly="true" /></td>
							  <td>����</td>
							  <td><s2:textfield name="userDelete.pwd" size="10" maxlength="10" readonly="true"/></td>
							</tr>
							<tr>
							  <td>�˻�����</td>
							  <td>
							  <s2:select list="userDelete.typeList" name="userDelete.type" listKey="value" listValue="label" headerKey="" headerValue="-" disabled="true" ></s2:select>
							  </td>
							  <td>�˻�״̬</td>
							  <td>
							  <s2:select list="userDelete.stateList" name="userDelete.state" listKey="value" listValue="label" headerKey="" headerValue="-" disabled="true" ></s2:select>
							  </td>
							</tr>
							<tr>
							  <td>�绰</td>
							  <td><s2:textfield name="userDelete.phone" size="15" maxlength="15" readonly="true" /></td>
							  <td>סַ</td>
							  <td><s2:textfield name="userDelete.address" size="20" maxlength="20" readonly="true"/></td>
							</tr>
							<tr>
							  <td>ʣ������</td>
							  <td><s2:textfield name="userDelete.restDay" size="10" maxlength="10" readonly="true" /></td>
							  <td>��������</td>
							  <td><s2:textfield name="userDelete.group" size="10" readonly="true"/></td>
							</tr>
							<tr valign="top">
							  <td >����</td>
							  <td colspan="3"><s2:textarea name="userDelete.comment" rows="2" cols="50" readonly="true"/></td>
							</tr>
							<tr align="center">
								<td colspan="4" >
									<s2:submit value="ȷ��ɾ��"/>
									<s2:submit value="ȡ��" onclick="history.back();return false; " />
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