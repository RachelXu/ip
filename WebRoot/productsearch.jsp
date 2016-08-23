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
document.getElementsByName("product.currentPage")[0].value="";
document.getElementsByName("product.pageCount")[0].value="";
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
		<%@include file="headbar_media.jsp" %>
        <!-- // #end mainNav -->
        <div id="containerHolder">
			<div id="container">
			<!-- // #start sidebar -->
        		<div id="sidebar">
                	<ul class="sideNav">
                    	<li><a href="precatalogman.action" >目录管理</a></li>
                    	<li><a href="premediasearch.action"  class="active">节目内容管理</a></li>
                    	<li><a href="premediainsert.action" >节目内容添加</a></li>
                    	<li><a href="premediabatchupload.action">节目内容批量上传</a></li>
                    	<s2:if test='#session.admin.level.equals("1") || #session.admin.level.equals("2")'>
                    	<li><a href="premediaapprove.action">确认节目审核通过</a></li>
                    	</s2:if>
                    	<s2:if test='#session.admin.level.equals("1") '>
                    	<li><a href="premediadisapprove.action" >确认节目发布</a></li>
                    	</s2:if>
                    </ul>
                </div>    
                <!-- // #end sidebar -->
                
                <!-- main page -->
                <h2><a href="#">Product Management</a> &raquo; <a href="#" class="active">Product Management</a></h2>
                <div id="main1" class="main">
                <p align="left"><s2:fielderror cssStyle="font-size:15px; color:red; font-weight:bold "/></p>
                <s2:form action="proproductsearch" theme="simple">
                <s2:hidden name="pageString"/>
                <s2:hidden name="product.currentPage"/>
                <s2:hidden name="product.pageCount"/>
                <s2:hidden name="deleteId"/>
                <s2:hidden name="editId"/>
					<h3>查询条件</h3>
                    	<table border="1">	
							<tr>
							  <td>节目ID</td>
							  <td><s2:textfield name="product.product.productId" size="10" maxlength="50"/></td>
							  <td>节目名称</td>
							  <td><s2:textfield name="product.product.productName" size="10" maxlength="50"/></td>
							</tr>
							<tr align="center">
								<td colspan="4" >
									<s2:submit value="查询" onclick="resetPage()"/>&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="重置" onclick="window.location.href='premediasearch.action'" />
								</td>
							</tr>
                        </table>
                        <s2:if test="product.resultFlag">
                        <h3>Products:</h3>
						<table>
							<tr>
						 	  <td >ID</td>
						      <td >Name</td>
							  <td >操作</td>
	    					</tr>
	    				  <s2:iterator value="product.products" var="detil">
						  <tr>    
						 	  <td ><s2:property value="productId"/></td>
						      <td ><s2:property value="productName"/></td>
						      <td>
					          <s2:submit action="premediaedit" value="Modify" onclick="edit(%{mediaId})"> </s2:submit>
					          <s2:submit action="premediadelete" value="Remove" onclick="del(%{mediaId})">  </s2:submit> </td> 
					      </tr>
					      </s2:iterator>
					      <tr>
					      	<td colspan="9" align="right">
					      	共<s2:property value="product.resultCount"/>条结果，当前第<s2:property value="product.currentPage"/>/<s2:property value="media.pageCount"/>页
					        <s2:if test="product.currentPage!=1">
					        <s2:submit action="proproductsearch" value="上一页" onclick="priv()"/>
					        </s2:if>
					        <s2:if test="product.currentPage<product.pageCount">
					        <s2:submit action="proproductsearch" value="下一页" onclick="next()"/>
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