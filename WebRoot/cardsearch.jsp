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
document.getElementsByName("card.currentPage")[0].value="";
document.getElementsByName("card.pageCount")[0].value="";
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
                    	<li><a href="precardsearch.action" class="active">充值卡查询</a></li>
                    	<li><a href="precardbatchedit.action">充值卡批量修改</a></li>
                    	<li><a href="precardbatchdelete.action">充值卡批量删除</a></li>
                    	<s2:if test='#session.admin.level.equals("1") || #session.admin.level.equals("2")'>
                    	<li><a href="preserviceinsert.action" >添加服务套餐</a></li>
                    	<li><a href="preservicesearch.action" >服务套餐管理</a></li>
                    	</s2:if>
                    </ul>
                </div>    
                <!-- // #end sidebar -->
                
                <!-- main page -->
                <h2><a href="#">充值卡管理</a> &raquo; <a href="#" class="active">充值卡查询</a></h2>
                <div id="main1" class="main">
                <p align="left"><s2:fielderror cssStyle="font-size:15px; color:red; font-weight:bold "/></p>
                <s2:form action="procardsearch" theme="simple">
                <s2:hidden name="pageString"/>
                <s2:hidden name="card.currentPage"/>
                <s2:hidden name="card.pageCount"/>
                <s2:hidden name="deleteId"/>
                <s2:hidden name="editId"/>
					<h3>查询条件</h3>
                    	<table border="1">	
							<tr>
							  <td>充值卡ID</td>
							  <td><s2:textfield name="card.id" size="10" maxlength="5"/></td>
							  <td>用户姓名</td>
							  <td><s2:textfield name="card.userName" size="10" maxlength="10"/></td>
							</tr>
							<tr>
							  <td>充值卡状态</td>
							  <td>
								<s2:select list="card.stateList" name="card.state" listKey="value" listValue="label" headerKey="" headerValue="-"></s2:select>
							  </td>
							  <td>充值时长</td>
							  <td>
								<s2:textfield name="card.day1" size="10" maxlength="10"/>&nbsp;&nbsp;—&nbsp;&nbsp;<s2:textfield name="card.day2" size="10" maxlength="10" />
							  </td>
							</tr>
							<tr>
							  <td>充值日期</td>
							  <td><s2:textfield name="card.chargedate1" size="10" maxlength="8" onclick="JTC.setday({format: 'yyyyMMdd'})"/>&nbsp;&nbsp;—&nbsp;&nbsp;<s2:textfield name="card.chargedate2" size="10" maxlength="8" onclick="JTC.setday({format: 'yyyyMMdd'})"/></td>
							  <td>截止日期</td>
							  <td><s2:textfield name="card.enddate1" size="10" maxlength="8" onclick="JTC.setday({format: 'yyyyMMdd'})"/>&nbsp;&nbsp;—&nbsp;&nbsp;<s2:textfield name="card.enddate2" size="10" maxlength="8" onclick="JTC.setday({format: 'yyyyMMdd'})"/></td>
							</tr>
							<tr>
							  <td>批次</td>
							  <td><s2:textfield name="card.batchNum" size="10" maxlength="5" /></td>
							  <td></td>
							  <td></td>
							</tr>
							<tr align="center">
								<td colspan="4" >
									<s2:submit value="查询" onclick="resetPage()"/>&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="重置" onclick="window.location.href='precardsearch.action'" />
								</td>
							</tr>
                        </table>
                        <s2:if test="card.resultFlag">
                        <h3>查询结果</h3>
						<table>
							<tr>
						 	  <td >充值卡id</td>
						      <td >充值卡状态</td>
						 	  <td >充值时长</td>
							  <td >截止日期</td>
							  <td >充值时期 </td>
							  <td>操作</td>
	    					</tr>
	    				  <s2:iterator value="card.resultList" var="detil">
						  <tr>    
							  <td><s2:property value="id"/> </td>       
						 	  <td><s2:property value="state"/></td>    
						      <td><s2:property value="day"/></td>    
						      <td><s2:property value="enddate"/></td>
						      <td><s2:property value="chargedate"/></td>
						      <td>
					          <s2:submit action="precardedit" value="修改" onclick="edit(%{id})"> </s2:submit>
					          <s2:submit action="precarddelete" value="删除" onclick="del(%{id})">  </s2:submit> </td> 
					      </tr>
					      </s2:iterator>
					      <tr>
					      	<td colspan="7" align="right">
					      	共<s2:property value="card.resultCount"/>条结果，当前第<s2:property value="card.currentPage"/>/<s2:property value="card.pageCount"/>页
					        <s2:if test="card.currentPage!=1">
					        <s2:submit action="procardsearch" value="上一页" onclick="priv()"/>
					        </s2:if>
					        <s2:if test="card.currentPage<card.pageCount">
					        <s2:submit action="procardsearch" value="下一页" onclick="next()"/>
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