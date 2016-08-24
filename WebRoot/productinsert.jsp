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
		<%@include file="headbar_media.jsp" %>
        <!-- // #end mainNav -->
        <div id="containerHolder">
			<div id="container">
			<!-- // #start sidebar -->
        		<div id="sidebar">
					<%@include file="menu_product.jsp" %>
                </div>    
                <!-- // #end sidebar -->
                
                <!-- main page -->
                <h2><a href="#">节目信息管理</a> &raquo; <a href="#" class="active">节目内容添加</a></h2>
                <div id="main1" class="main">
                <p align="left"><s2:fielderror cssStyle="font-size:15px; color:red; font-weight:bold "/></p>
                <s2:form action="proproductinsert" theme="simple" method="post" enctype="multipart/form-data">
                <s2:hidden name="pageString"/>
                <s2:hidden name="product.currentPage"/>
                <s2:hidden name="product.pageCount"/>
                <s2:hidden name="deleteId"/>
                <s2:hidden name="editId"/>
					<h3>添加信息</h3>
                    	<table border="1">	
							<tr>
							  <td>ProductID</td>
							  <td><s2:textfield name="product.productId" size="10" maxlength="50"/></td>
						  </tr>
						  <tr>
							  <td>ProductName</td>
							  <td><s2:textfield name="product.productName" size="10" maxlength="50"/></td>
							</tr>
							<tr align="center">
								<td colspan="4" >
									<s2:submit value="确认提交"/>&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="重置" onclick="window.location.href='premediainsert.action'" />
								</td>
							</tr>
                        </table>
                        <s2:if test="showError">
                        <h3>文件错误信息</h3>
						<table>
							<tr>
						 	  <td >行号</td>
						      <td >错误内容</td>
	    					</tr>
	    				  <s2:iterator value="sourceErrorList" var="detil">
						  <tr>    
						 	  <td ><s2:property value="row"/></td>
						      <td ><s2:property value="errorMessage"/></td> 
					      </tr>
					      </s2:iterator>
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