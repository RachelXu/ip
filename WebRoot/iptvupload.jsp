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
		<%@include file="headbar_iptv.jsp" %>
        <!-- // #end mainNav -->
        <div id="containerHolder">
			<div id="container">
			<!-- // #start sidebar -->
        		<div id="sidebar">
                	<ul class="sideNav">
                    	<li><a href="preiptvupload.action" class="active" >新增版本信息</a></li>
                    	<li><a href="preiptvhistoryaction.action" >历史版本信息</a></li>
                    </ul>
                </div>    
                <!-- // #end sidebar -->
                
                <!-- main page -->
                <h2><a href="#">机顶盒管理</a> &raquo; <a href="#" class="active">新增版本信息</a></h2>
                <div id="main1" class="main">
                <p align="left"><s2:fielderror cssStyle="font-size:15px; color:red; font-weight:bold "/></p>
                <s2:form action="proiptvupload" theme="simple" method="post" enctype="multipart/form-data">
					<h3>新增版本信息</h3>
                    	<table border="1">	
						<tr><td>
						说明:可以添加新的版本信息<br/>
						版本号:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s2:textfield name="version" size="10" maxlength="5"/><br/>
						更新日期:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s2:textfield name="update" size="10" maxlength="8" onclick="JTC.setday({format: 'yyyyMMdd'})"/><br/>
						预计使用时间:<s2:textfield name="usedate" size="10" maxlength="8" onclick="JTC.setday({format: 'yyyyMMdd'})"/><br/>
						上传更新:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s2:file name="upload"/><br/>
						更新内容:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s2:textfield name="content" size="30" maxlength="100"/><br/>
						<s2:submit value="确认上传" /><input type="button" value="重置" onclick="window.location.href='preiptvupload.action'" />
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