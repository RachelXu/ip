<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@ taglib uri="/struts-tags" prefix="s2"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>宽宏IPTV播控平台</title>
<link href="style/css/transdmin.css" rel="stylesheet" type="text/css" media="screen" />
<!-- JavaScripts-->
<script type="text/javascript" src="style/js/Calendar.js" ></script>
</head>
<body>
	<div id="wrapper">
    	<!-- h1 tag stays for the logo, you can use the a tag for linking the index page -->
    	<h1><a href="#"><span>管理系统</span></a></h1>
    	<!-- // #start mainNav -->
		<%@include file="headbar_epg.jsp" %>
        <!-- // #end mainNav -->
        <div id="containerHolder">
			<div id="container">
			<!-- // #start sidebar -->
        		<div id="sidebar">
        		<ul class="sideNav">
        				<li><a href="preadminpassword.action" class="active" >修改密码</a></li>
                    	<s2:if test='#session.admin.level.equals("1") '>
                    	<li><a href="preepgman.action" >EPG服务器管理</a></li>
                    	</s2:if>
                    	<s2:if test='#session.admin.level.equals("1") || #session.admin.level.equals("2")'>
                    	<li><a href="preadmininsert.action">添加管理员</a></li>
                    	</s2:if>
                    </ul>
                </div>   
                <!-- // #end sidebar -->
                
                <!-- main page -->
                <h2><a href="#">运维管理</a> &raquo; <a href="#" class="active">修改密码</a></h2>
                <div id="main1" class="main">
                <p align="left"><s2:fielderror cssStyle="font-size:15px; color:red; font-weight:bold "/></p>
                <s2:form action="proadminpassword" theme="simple">
                <s2:hidden name="editId"/>
					<h3>管理员信息</h3>
                    	<table border="1">	
							<tr>
							  <td>管理员密码</td>
							  <td><s2:password name="admin1.password1" size="20" maxlength="20"/></td>
							  <td></td>
							  <td></td>
							</tr>
							<tr>
							  <td>管理员密码确认</td>
							  <td><s2:password name="admin1.password2" size="20" maxlength="20"/></td>
							  <td></td>
							  <td></td>
							</tr>
							<tr align="center">
								<td colspan="4" >
									<s2:submit value="确认"/>&nbsp;&nbsp;&nbsp;&nbsp;
									<s2:reset value="重置"/>
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