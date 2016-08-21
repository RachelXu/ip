<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@ taglib uri="/struts-tags" prefix="s2"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>宽宏IPTV播控平台</title>
<link href="style/css/transdmin.css" rel="stylesheet" type="text/css" media="screen" />
<!-- JavaScripts-->
<script type="text/javascript" src="style/js/Calendar.js" ></script>
<script language="javascript" type="text/javascript">
function priv(){
document.getElementsByName("pageString")[0].value="priv";
}
function next(){
document.getElementsByName("pageString")[0].value="next";
}
function resetPage(){
document.getElementsByName("pageString")[0].value="";
document.getElementsByName("service.currentPage")[0].value="";
document.getElementsByName("service.pageCount")[0].value="";
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
                    	<li><a href="precardbatchedit.action">充值卡批量修改</a></li>
                    	<li><a href="precardbatchdelete.action">充值卡批量删除</a></li>
                    	<s2:if test='#session.admin.level.equals("1") || #session.admin.level.equals("2")'>
                    	<li><a href="preserviceinsert.action">添加服务套餐</a></li>
                    	<li><a href="preservicesearch.action" class="active">服务套餐管理</a></li>
                    	</s2:if>
                    </ul>
                </div>    
                <!-- // #end sidebar -->
                
                <!-- main page -->
                <h2><a href="#">充值卡管理</a> &raquo; <a href="#" class="active">服务套餐管理</a></h2>
                <div id="main1" class="main">
                <p align="left"><s2:fielderror cssStyle="font-size:15px; color:red; font-weight:bold "/></p>
                <s2:form action="proservicesearch" theme="simple">
                <s2:hidden name="pageString"/>
                <s2:hidden name="service.currentPage"/>
                <s2:hidden name="service.pageCount"/>
                <s2:hidden name="deleteId"/>
                <s2:hidden name="editId"/>
					<h3>查询条件</h3>
                    	<table border="1">	
							<tr>
							  <td>服务套餐名称&nbsp;&nbsp;&nbsp;&nbsp;<s2:textfield name="service.serviceName" size="10" maxlength="10"/></td>
							  <td></td>
							  <td></td>
							  <td></td>
							</tr>
							<tr>
							  <td>服务天数&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s2:textfield name="service.serviceDay" size="10" maxlength="10"/></td>
							  <td>
							  </td>
							  <td></td>
							  <td></td>
							</tr>
							<tr align="center">
								<td colspan="4" >
									<s2:submit value="查询" onclick="resetPage()"/>&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="重置" onclick="window.location.href='preservicesearch.action'" />
								</td>
							</tr>
                        </table>
                        <s2:if test="service.resultFlag">
                        <h3>查询结果</h3>
						<table>
							<tr>
						 	  <td >服务套餐id</td>
						      <td >服务套餐名称</td>
						 	  <td >服务天数</td>
							  <td>操作</td>
	    					</tr>
	    				  <s2:iterator value="service.resultList" var="detil">
						  <tr>    
							  <td><s2:property value="serviceId"/> </td>       
						 	  <td><s2:property value="serviceName"/></td>    
						      <td><s2:property value="serviceDay"/></td>    
						      <td>
					          <s2:submit action="preserviceedit" value="修改" onclick="edit(%{serviceId})"> </s2:submit>
					          <s2:submit action="preservicedelete" value="删除" onclick="del(%{serviceId})">  </s2:submit> </td> 
					      </tr>
					      </s2:iterator>
					      <tr>
					      	<td colspan="7" align="right">
					      	共<s2:property value="service.resultCount"/>条结果，当前第<s2:property value="service.currentPage"/>/<s2:property value="service.pageCount"/>页
					        <s2:if test="service.currentPage!=1">
					        <s2:submit action="proservicesearch" value="上一页" onclick="priv()"/>
					        </s2:if>
					        <s2:if test="service.currentPage<service.pageCount">
					        <s2:submit action="proservicesearch" value="下一页" onclick="next()"/>
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