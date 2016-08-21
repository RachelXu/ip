<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@ taglib uri="/struts-tags" prefix="s2"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>宽宏IPTV播控平台</title>
<link href="style/css/transdmin.css" rel="stylesheet" type="text/css" media="screen" />
<!-- JavaScripts-->
<script language="javascript" type="text/javascript">
function seldownload(parm){
document.getElementsByName("downId")[0].value=parm;
return true;
}
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
                    	<li><a href="preiptvupload.action"  >新增版本信息</a></li>
                    	<li><a href="preiptvhistoryaction.action" class="active">历史版本信息</a></li>
                    </ul>
                </div>    
                <!-- // #end sidebar -->
                
                <!-- main page -->
                <h2><a href="#">机顶盒管理</a> &raquo; <a href="#" class="active">历史版本信息</a></h2>
                <div id="main1" class="main">
                <p align="left"><s2:fielderror cssStyle="font-size:15px; color:red; font-weight:bold "/></p>
					<s2:form action="proiptvdownloadaction" theme="simple" method="post" enctype="multipart/form-data">
					<h3>历史版本信息</h3>
					<s2:hidden name="downId"/>
					<s2:if test="showResultFlag">
                    	<table border="1">	
						<tr>
							<td width="90px">版本号</td>
							<td >更新日期</td>
							<td >使用时间</td>
							<td width="410px">更新内容</td>
							<td >操作</td>
						</tr>
						<s2:iterator value="resultList" var="detil">
						<tr>
							<td ><s2:property value="version"/></td>
							<td ><s2:property value="upDate"/></td>
							<td ><s2:property value="usedate"/></td>
							<td ><s2:property value="content"/></td>
							<td ><s2:submit action="proiptvdownloadaction" value="下载" onclick="seldownload(%{id})" /> </td>
						</tr>
						</s2:iterator>
                        </table>
                    </s2:if>
                    <s2:else>
                    <h3>没有任何历史版本信息！</h3>
                    </s2:else>
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