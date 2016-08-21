<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@ taglib uri="/struts-tags" prefix="s2"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>���IPTV����ƽ̨</title>
<link href="style/css/transdmin.css" rel="stylesheet" type="text/css" media="screen" />
<!-- JavaScripts-->
<script language="javascript" type="text/javascript">
function priv(){
document.getElementsByName("pageString")[0].value="priv";
}
function next(){
document.getElementsByName("pageString")[0].value="next";
}
function resetPage(){
document.getElementsByName("pageString")[0].value="";
document.getElementsByName("user.currentPage")[0].value="";
document.getElementsByName("user.pageCount")[0].value="";
}
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
    	<h1><a href="#"><span>����ϵͳ</span></a></h1>
    	<!-- // #start mainNav -->
    	<%@include file="headbar_user.jsp" %>
        <!-- // #end mainNav -->
        <div id="containerHolder">
			<div id="container">
			<!-- // #start sidebar -->
        		<div id="sidebar">
        			<%@include file="menu.jsp" %>                	
                </div>    
                <!-- // #end sidebar -->
                
                <!-- main page -->
                <h2><a href="#">�˻�����</a> &raquo; <a href="#" class="active">�˻���ѯ</a></h2>
                <div id="main1" class="main">
                <p align="left"><s2:fielderror cssStyle="font-size:15px; color:red; font-weight:bold "/></p>
                <s2:form action="prousersearch" theme="simple">
                <s2:hidden name="pageString"/>
                <s2:hidden name="user.currentPage"/>
                <s2:hidden name="user.pageCount"/>
                <s2:hidden name="deleteId"/>
                <s2:hidden name="editId"/>
					<h3>��ѯ����</h3>
                    	<table border="1">	
							<tr>
							  <td>�˻�ID</td>
							  <td><s2:textfield name="user.id" size="20" maxlength="20"/></td>
							  <td>�û�����</td>
							  <td><s2:textfield name="user.name" size="10" maxlength="10"/></td>
							</tr>
							<tr>
							  <td>�˻�����</td>
							  <td>
								<s2:select list="user.typeList"  name="user.type" listKey="value" listValue="label" headerKey="" headerValue="-"></s2:select>
							  </td>
							  <td>�˻�״̬</td>
							  <td>
								<s2:select list="user.stateList" name="user.state" listKey="value" listValue="label" headerKey="" headerValue="-"></s2:select>
							  </td>
							</tr>
							<tr>
							  <td>�绰</td>
							  <td><s2:textfield name="user.phone" size="15" maxlength="15"/></td>
							  <td>סַ</td>
							  <td><s2:textfield name="user.address" size="20" maxlength="20"/></td>
							</tr>
							<tr>
							  <td>����ʣ������</td>
							  <td><s2:textfield name="user.restDay1" size="10" maxlength="5" />&nbsp;&nbsp;��&nbsp;&nbsp;<s2:textfield name="user.restDay2" size="10" maxlength="5" /></td>
							  <td>��������</td>
							  <td><s2:textfield name="user.group" size="10" /></td>
							</tr>
							<tr align="center">
								<td colspan="4" >
									<s2:submit value="��ѯ" onclick="resetPage()"/>&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="����" onclick="window.location.href='preusersearch.action'" />
								</td>
							</tr>
                        </table>
                        <s2:if test="user.resultFlag">
                        <h3>��ѯ���</h3>
						<table>
							<tr>
						 	  <td >�˻�ID</td>
						 	  <td >�˻�״̬</td>
							  <td>����</td>
	    					</tr>
	    				  <s2:iterator value="user.accountList" var="detil">
						  <tr>    
							  <td><s2:property value="accountId"/> </td>       
						      <td><s2:property value="state"/></td>    
						      <td>
					          <s2:submit action="preuseredit" value="�޸�" onclick="edit(%{id})"> </s2:submit>
					          <s2:submit action="preuserdelete" value="ɾ��" onclick="del(%{id})">  </s2:submit> </td> 
					      </tr>
					      </s2:iterator>
					      <tr>
					      	<td colspan="7" align="right">
					      	��<s2:property value="user.resultCount"/>���������ǰ��<s2:property value="user.currentPage"/>/<s2:property value="user.pageCount"/>ҳ
					        <s2:if test="user.currentPage!=1">
					        <s2:submit action="prousersearch" value="��һҳ" onclick="priv()"/>
					        </s2:if>
					        <s2:if test="user.currentPage<user.pageCount">
					        <s2:submit action="prousersearch" value="��һҳ" onclick="next()"/>
					        </s2:if>
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