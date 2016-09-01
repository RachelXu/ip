<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@ taglib uri="/struts-tags" prefix="s2"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>IPTV</title>
<link href="style/css/transdmin.css" rel="stylesheet" type="text/css" media="screen" />
<!-- JavaScripts-->
<script language='javascript'>
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
	return true;
}
function resetCondition(){
	document.getElementsByName("product.product.productId")[0].value="";
	document.getElementsByName("product.product.productName")[0].value="";
	return true;
}
function update(parm){	
	document.getElementsByName("itemId")[0].value=parm;
	return true;
}
function del(parm){	
    if (confirm("Will you delete product: " + parm + "?")) {
        document.getElementsByName("itemId")[0].value=parm;
        return true;
    } else {
		return false;
    }	
}
function channel(parm){	
	document.getElementsByName("itemId")[0].value=parm;
	return true;
}

</script>
</head>
<body>
	<div id="wrapper">
    	<!-- h1 tag stays for the logo, you can use the a tag for linking the index page -->
    	<h1><a href="#"><span>管理系统</span></a></h1>
    	<!-- // #start mainNav -->
		<%@include file="headbar_product.jsp" %>
        <!-- // #end mainNav -->
        <div id="containerHolder">
			<div id="container">
			<!-- // #start sidebar -->
        		<div id="sidebar">
        			<ul class="sideNav">
                    	<li><a href="preSearch_product_productsearch.action"  class="active">Product Management</a></li>
                    	<li><a href="preAdd_product_productinsert.action">New Product</a></li>
                    </ul>
                </div>    
                <!-- // #end sidebar -->
                
                <!-- main page -->
                <h2><a href="#">Product Management</a> &raquo; <a href="#" class="active">Product Management</a></h2>
                <div id="main1" class="main">
                <p align="left"><s2:fielderror cssStyle="font-size:15px; color:red; font-weight:bold "/><s2:actionmessage cssStyle="font-size:15px; font-weight:bold "/></p>
                <s2:form action="assignChannel_product_productsearch" theme="simple" method="post">
                	<s2:hidden name="pageString" value=""/>
                	<s2:hidden name="itemId"/>
						
                    <table border="1">	
						<tr>
						  <td>ProductID: <s2:property value="product.product.productId"/></td>							  
						  <td>ProductName: <s2:property value="product.product.productName"/></td>
						</tr>
                    </table>
                    
                    <h3>Current Channels:</h3>
					<table width="50%" align="left">
						<tr>
						  <td ></td>
					 	  <td >ProductID</td>
					      <td >ProductName</td>
						  <td >channelType</td>
	    				</tr>
	    			    <s2:iterator value="product.product.channels" var="detil">
						<tr>
						  <td><s2:checkbox id="curChannels" name="curChannels" fieldValue="channelId"/></td>
						  <td ><s2:property value="channelId"/></td>
						  <td ><s2:property value="channelName"/></td>
						  <td ><s2:property value="channelType"/></td>
					    </tr>
					    </s2:iterator>			
					    <tr><td colspan="4"><s2:submit action="" value="Remove" onclick="priv()"/></td></tr>		      	
					</table>
					<h3>Available Channels To Add:</h3>	
					<table width="40%" align="right">
						<tr>
							  <td ></td>
						 	  <td >ProductID</td>
						      <td >ProductName</td>
							  <td >channelType</td>
	    				</tr>
	    			    <s2:iterator value="product.channels" var="detil">
					  	<tr>    
						  	  <td><s2:checkbox id="newChannels" name="newChannels" fieldValue="channelId"/></td>
						 	  <td ><s2:property value="channelId"/></td>
						      <td ><s2:property value="channelName"/></td>
						      <td ><s2:property value="channelType"/></td>
					   	</tr>
					    </s2:iterator>
					    <tr><td colspan="4"><s2:submit action="" value="Add" onclick="priv()"/></td></tr>					      	
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