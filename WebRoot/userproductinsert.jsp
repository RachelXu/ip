<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@ taglib uri="/struts-tags" prefix="s2"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>¿íºêIPTV²¥¿ØÆ½Ì¨</title>
<link href="style/css/transdmin.css" rel="stylesheet" type="text/css" media="screen" />
<!-- JavaScripts-->
<script language="javascript" type="text/javascript">

</script>
</head>
<body>
                <!-- main page -->
                <h2><a href="#">STB Management</a> &raquo; <a href="#" class="active">Assign a Product</a></h2>
                <div id="main1" class="main">
                <p align="left"><s2:fielderror cssStyle="font-size:15px; color:red; font-weight:bold "/></p>
                <s2:form action="prouseredit" theme="simple">
                <s2:hidden name="editId"/>
					<h3>Assign Product</h3>
                    	<table border="1"  style="width:450px;" align="center">	
							<tr  >
							  <td align="right">   Products:</td>
								<td align="center"><s2:select name="productId" style="width:200px;" label="select a product" list="products" listKey="productId" listValue="productName"/> </td>								
 							</tr>
							<tr align="center">
								<td colspan="2" >
									<s2:submit value="OK"/>&nbsp;&nbsp;&nbsp;&nbsp;
									<s2:submit value="Cancel" onclick="history.back();return false; " />
								</td>
							</tr>
                        </table>
                        
                   </s2:form>
                </div>
              
        
    <!-- // #wrapper -->
</body>
</html>