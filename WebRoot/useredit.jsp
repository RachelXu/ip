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
    	<%@include file="headbar_user.jsp" %>
        <!-- // #end mainNav -->
        <div id="containerHolder">
			<div id="container">
			<!-- // #start sidebar -->
        		<div id="sidebar">
                	<ul class="sideNav">
                    	<li><a href="search_account_accountsearch.action" class="active" >账户查询</a></li>
                    	<li><a href="preuserupload.action" >账户批量导入</a></li>
                    	<li><a href="preuserbatchedit.action">账户批量修改</a></li>
                    	<li><a href="preuserbatchdelete.action">账户批量删除</a></li>
                    </ul>
                </div>    
                <!-- // #end sidebar -->
                
                <!-- main page -->
                <h2><a href="#">账户管理</a> &raquo; <a href="#" class="active">账户查询</a></h2>
                <div id="main1" class="main">
                <p align="left"><s2:fielderror cssStyle="font-size:15px; color:red; font-weight:bold "/></p>
                <s2:form action="prouseredit" theme="simple">
                <s2:hidden name="editId"/>
					<h3>修改信息</h3>
                    	<table border="1">	
							<tr>
							  <td>账户ID</td>
							  <td><s2:textfield name="userEdit.id" size="10" maxlength="5" readonly="true" /></td>
							  <td>用户姓名</td>
							  <td><s2:textfield name="userEdit.name" size="10" maxlength="10"/></td>
							</tr>
							<tr>
							  <td>年龄</td>
							  <td><s2:textfield name="userEdit.age" size="10" maxlength="5" /></td>
							  <td>密码</td>
							  <td><s2:textfield name="userEdit.pwd" size="10" maxlength="10"/></td>
							</tr>
							<tr>
							  <td>账户类型</td>
							  <td>
							  <s2:select list="userEdit.typeList" name="userEdit.type" listKey="value" listValue="label" headerKey="" headerValue="-"></s2:select>
							  </td>
							  <td>账户状态</td>
							  <td>
							  <s2:select list="userEdit.stateList" name="userEdit.state" listKey="value" listValue="label" headerKey="" headerValue="-"></s2:select>
							  </td>
							</tr>
							<tr>
							  <td>电话</td>
							  <td><s2:textfield name="userEdit.phone" size="15" maxlength="15"/></td>
							  <td>住址</td>
							  <td><s2:textfield name="userEdit.address" size="20" maxlength="20"/></td>
							</tr>
							<tr>
							  <td>服务剩余时间</td>
							  <td><s2:textfield name="userEdit.restDay" size="10" maxlength="5" /></td>
							  <td>所属批次</td>
							  <td><s2:textfield name="userEdit.group" size="10" /></td>
							</tr>
							<tr valign="top">
							  <td >备考</td>
							  <td colspan="3"><s2:textarea name="userEdit.comment" rows="2" cols="50" /></td>
							</tr>
							<tr align="center">
								<td colspan="4" >
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