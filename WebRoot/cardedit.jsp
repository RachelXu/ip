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
                <s2:form action="procardedit" theme="simple">
                <s2:hidden name="editId"/>
					<h3>修改信息</h3>
                    	<table border="1">	
							<tr>
							  <td>充值卡ID</td>
							  <td><s2:textfield name="cardEdit.id" size="10" maxlength="5" readonly="true" /></td>
							  <td>充值卡密码</td>
							  <td><s2:textfield name="cardEdit.pwd" size="10" maxlength="10"/></td>
							</tr>
							<tr>
							  <td>充值卡状态</td>
							  <td>
								<s2:select list="cardEdit.stateList" name="cardEdit.state" listKey="value" listValue="label" headerKey="" headerValue="-"></s2:select>
							  </td>
							  <td>充值时长</td>
							  <td>
								<s2:textfield name="cardEdit.day" size="10" maxlength="10"/>
							  </td>
							</tr>
							<tr>
							  <td>充值日期</td>
							  <td><s2:textfield name="cardEdit.chargedate" size="10" maxlength="8" onclick="JTC.setday({format: 'yyyyMMdd'})"/></td>
							  <td>截止日期</td>
							  <td><s2:textfield name="cardEdit.enddate" size="10" maxlength="8" onclick="JTC.setday({format: 'yyyyMMdd'})"/></td>
							</tr>
							<tr align="center">
								<td colspan="4" >
									<s2:submit value="确认修改"/>&nbsp;&nbsp;&nbsp;&nbsp;<s2:submit value="取消" onclick="history.back();return false; " />
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