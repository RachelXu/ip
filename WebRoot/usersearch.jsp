<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@ taglib uri="/struts-tags" prefix="s2"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>宽宏IPTV播控平台</title>
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
    	<h1><a href="#"><span>管理系统</span></a></h1>
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
                <h2><a href="#">账户管理</a> &raquo; <a href="#" class="active">账户查询</a></h2>
                <div id="main1" class="main">
                <p align="left"><s2:fielderror cssStyle="font-size:15px; color:red; font-weight:bold "/></p>
                <s2:form action="prousersearch" theme="simple">
                <s2:hidden name="pageString"/>
                <s2:hidden name="user.currentPage"/>
                <s2:hidden name="user.pageCount"/>
                <s2:hidden name="deleteId"/>
                <s2:hidden name="editId"/>
					<h3>查询条件</h3>
                    	<table border="1">	
							<tr>
							  <td>账户ID</td>
							  <td><s2:textfield name="user.id" size="20" maxlength="20"/></td>
							  <td>用户姓名</td>
							  <td><s2:textfield name="user.name" size="10" maxlength="10"/></td>
							</tr>
							<tr>
							  <td>账户类型</td>
							  <td>
								<s2:select list="user.typeList"  name="user.type" listKey="value" listValue="label" headerKey="" headerValue="-"></s2:select>
							  </td>
							  <td>账户状态</td>
							  <td>
								<s2:select list="user.stateList" name="user.state" listKey="value" listValue="label" headerKey="" headerValue="-"></s2:select>
							  </td>
							</tr>
							<tr>
							  <td>电话</td>
							  <td><s2:textfield name="user.phone" size="15" maxlength="15"/></td>
							  <td>住址</td>
							  <td><s2:textfield name="user.address" size="20" maxlength="20"/></td>
							</tr>
							<tr>
							  <td>服务剩余天数</td>
							  <td><s2:textfield name="user.restDay1" size="10" maxlength="5" />&nbsp;&nbsp;—&nbsp;&nbsp;<s2:textfield name="user.restDay2" size="10" maxlength="5" /></td>
							  <td>所属批次</td>
							  <td><s2:textfield name="user.group" size="10" /></td>
							</tr>
							<tr align="center">
								<td colspan="4" >
									<s2:submit value="查询" onclick="resetPage()"/>&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="重置" onclick="window.location.href='preusersearch.action'" />
								</td>
							</tr>
                        </table>
                        <s2:if test="user.resultFlag">
                        <h3>查询结果</h3>
						<table>
							<tr>
						 	  <td >账户ID</td>
						 	  <td >账户状态</td>
							  <td>操作</td>
	    					</tr>
	    				  <s2:iterator value="user.accountList" var="detil">
						  <tr>    
							  <td><s2:property value="accountId"/> </td>       
						      <td><s2:property value="state"/></td>    
						      <td>
					          <s2:submit action="preuseredit" value="修改" onclick="edit(%{id})"> </s2:submit>
					          <s2:submit action="preuserdelete" value="删除" onclick="del(%{id})">  </s2:submit> </td> 
					      </tr>
					      </s2:iterator>
					      <tr>
					      	<td colspan="7" align="right">
					      	共<s2:property value="user.resultCount"/>条结果，当前第<s2:property value="user.currentPage"/>/<s2:property value="user.pageCount"/>页
					        <s2:if test="user.currentPage!=1">
					        <s2:submit action="prousersearch" value="上一页" onclick="priv()"/>
					        </s2:if>
					        <s2:if test="user.currentPage<user.pageCount">
					        <s2:submit action="prousersearch" value="下一页" onclick="next()"/>
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