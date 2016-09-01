<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@ taglib uri="/struts-tags" prefix="s2"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>DAQI IPTV</title>
<link href="style/css/transdmin.css" rel="stylesheet" type="text/css" media="screen" />
<!-- JavaScripts-->
<script language="javascript" type="text/javascript">
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
    	<h1><a href="#"><span>Catalog</span></a></h1>
    	<!-- // #start mainNav -->
		<%@include file="headbar_media.jsp" %>
        <!-- // #end mainNav -->
        <div id="containerHolder">
			<div id="container">
			<!-- // #start sidebar -->
        		<div id="sidebar">
				<!--
                	<ul class="sideNav">
                    	<li><a href="precatalogman.action"  class="active">sd</a></li>
                    	<li><a href="premediasearch.action">ï¿½ï¿½Ä¿ï¿½ï¿½ï¿½Ý¹ï¿½ï¿½ï¿½</a></li>
                    	<li><a href="premediainsert.action">ï¿½ï¿½Ä¿ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½</a></li>
                    	<li><a href="premediabatchupload.action">ï¿½ï¿½Ä¿ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½Ï´ï¿½</a></li>
                    	<s2:if test='#session.admin.level.equals("1") || #session.admin.level.equals("2")'>
                    	<li><a href="premediaapprove.action">È·ï¿½Ï½ï¿½Ä¿ï¿½ï¿½ï¿½Í¨ï¿½ï¿½</a></li>
                    	</s2:if>
                    	<s2:if test='#session.admin.level.equals("1") '>
                    	<li><a href="premediadisapprove.action" >È·ï¿½Ï½ï¿½Ä¿ï¿½ï¿½ï¿½ï¿½</a></li>
                    	</s2:if>
                    </ul>
				-->
					<%@include file="menu_media.jsp" %>
                </div>    
                <!-- // #end sidebar -->
                
                <!-- main page -->
                <h2><a href="#">Catalog</a> &raquo; <a href="#" class="active">Management</a></h2>
                <div id="main1" class="main">
                <p align="left"><s2:fielderror cssStyle="font-size:15px; color:red; font-weight:bold "/></p>
                <s2:form action="procatalogman" theme="simple">
                <s2:hidden name="deleteId"/>
                <s2:hidden name="editId"/>
					<h3>ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½/ï¿½ï¿½Ä¿</h3>
						<table>
						<tr>
							<td>ï¿½ï¿½Ä¿ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½:</td>
							<td><s2:textfield name="catalog.catalogZhName"  size="10" maxlength="10" /></td>
							<td>ï¿½ï¿½Ä¿Ó¢ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½:</td>
							<td><s2:textfield name="catalog.catalogEnName"  size="10" maxlength="10"/></td>
						</tr>
						<tr>
							<td>ï¿½ï¿½Ê¾Ë³ï¿½ï¿½:</td>
							<td><s2:textfield name="catalog.order"  size="3" maxlength="3"/></td>
							<td>ï¿½Ï¼ï¿½ï¿½ï¿½Ä¿:</td>
							<td><s2:select list="catalog.firstLeveList" name="catalog.superId" listKey="value" listValue="label" headerKey="" headerValue="-">
								<s2:iterator value="catalog.secondLabel" var="sencondLable" status="status" >
								<s2:optgroup label="%{sencondLable}" list="catalog.sencondLeveList.get(#status.index)" listKey="value" listValue="label">
								</s2:optgroup>
								</s2:iterator>
								</s2:select>
							</td>
						</tr>
						<tr>
						<td colspan="4" align="center" >
							<s2:submit value="ï¿½á½»"></s2:submit>&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="button" value="ï¿½ï¿½ï¿½ï¿½" onClick="window.location.href='precatalogman.action'" />
						</td>
						</tr>
						</table>
						<s2:if test="catalog.resultFlag">
                        <h3>ï¿½ï¿½Ä¿ï¿½ï¿½ï¿½ï¿½</h3>
						<table>
							<tr>
						 	  <td >ID</td>
						      <td >catalogZhName</td>
						      <td >catalogEnName</td>
						 	  <td >order</td>
							  <td>operation</td>
	    					</tr>
	    				  <s2:iterator value="catalog.resultList" var="detil">
						  <tr>    
							  <td><s2:property value="catalogId"/> </td>       
						 	  <td><s2:property value="catalogZhName" escapeHtml="false" /></td>    
						 	  <td><s2:property value="catalogEnName"/></td>   
						      <td><s2:property value="order"/></td>
						      <td>
					          <s2:submit action="precatalogedit" value="Update" onclick="edit('%{catalogId}')"> </s2:submit>
					          <s2:submit action="precatalogdelete" value="Remove" onclick="del('%{catalogId}')">  </s2:submit> </td> 
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