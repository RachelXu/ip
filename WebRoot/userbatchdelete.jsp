<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@ taglib uri="/struts-tags" prefix="s2"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>宽宏IPTV播控平台</title>
<link href="style/css/transdmin.css" rel="stylesheet" type="text/css" media="screen" />
<!-- JavaScripts-->
<script language="javascript" type="text/javascript">
function checkAll( ){
chkList = document.getElementsByName("deleteCkeck");
for(i=0;i<chkList.length;i++){
	chkList[i].checked=true;
}
return false;
}
function checkNone(){
chkList = document.getElementsByName("deleteCkeck");
for(i=0;i<chkList.length;i++){
	chkList[i].checked=false;
}
return false;
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
                	<ul class="sideNav">
                    	<li><a href="preusersearch.action"  >账户查询</a></li>
                    	<li><a href="preuserupload.action" >账户批量导入</a></li>
                    	<li><a href="preuserbatchedit.action">账户批量修改</a></li>
                    	<li><a href="preuserbatchdelete.action"  class="active">账户批量删除</a></li>
                    </ul>
                </div>    
                <!-- // #end sidebar -->
                
                <!-- main page -->
                <h2><a href="#">账户管理</a> &raquo; <a href="#" class="active">账户批量删除</a></h2>
                <div id="main1" class="main">
                <p align="left"><s2:fielderror cssStyle="font-size:15px; color:red; font-weight:bold "/></p>
                <s2:form action="prouserbatchdelete" theme="simple">
					<h3>查询条件</h3>
                    	<table border="1">	
							<tr>
							  <td>账户ID</td>
							  <td><s2:textfield name="user.id1" size="10" maxlength="5"/>&nbsp;&nbsp;—&nbsp;&nbsp;<s2:textfield name="user.id2" size="10" maxlength="5"/></td>
							  <td>所属批次</td>
							  <td><s2:textfield name="user.group1" size="10" />&nbsp;&nbsp;—&nbsp;&nbsp;<s2:textfield name="user.group2" size="10" /></td>
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
							  <td>服务剩余天数</td>
							  <td><s2:textfield name="user.restDay1" size="10" maxlength="5"/>&nbsp;&nbsp;—&nbsp;&nbsp;<s2:textfield name="user.restDay2" size="10" maxlength="5" /></td>
							  <td></td>
							  <td></td>
							</tr>
							<tr align="center">
								<td colspan="4" >
									<s2:submit value="查询" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="重置" onclick="window.location.href='preuserbatchdelete.action'" />
								</td>
							</tr>
                        </table>
                        <s2:if test="user.resultFlag">
                        <h3>查询结果</h3>
						<table>
							<tr>
							  <td >选择</td>
						 	  <td >账户ID</td>
						      <td >用户姓名</td>
						 	  <td >账户状态</td>
						 	  <td >账户类型</td>
							  <td >剩余天数</td>
							  <td >所属批次</td>
	    					</tr>
	    				  <s2:iterator value="user.resultList" var="detil">
						  <tr>    
						  	  <td><s2:checkbox name="deleteCkeck" fieldValue="%{id}" ></s2:checkbox></td>  
							  <td><s2:property value="id"/> </td>       
						 	  <td><s2:property value="name"/></td>    
						      <td><s2:property value="state"/></td>   
						      <td><s2:property value="type"/></td>  
						      <td><s2:property value="restday"/></td>
						      <td><s2:property value="group"/></td>
					      </tr>
					      </s2:iterator>
					      <tr>    
							  <td colspan="7" align="center" ><input type="button" value="全选" onclick="checkAll();"/><input type="button" value="取消全选" onclick="checkNone();"/><s2:submit value="确认删除" action="prouserbatchdeleteexec" /> </td>       
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