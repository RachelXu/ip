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
                <p align="left"><s2:fielderror cssStyle="font-size:15px; color:red; font-weight:bold "/><s2:actionmessage cssStyle="font-size:15px; font-weight:bold "/></p>
                <s2:form action="accountProduct" theme="simple">
                <s2:hidden name="opType"/>
                <s2:hidden name="itemIds"/>
                    <s2:if test="opType=='Add'">
					<h3>Assign Products to <s2:property value="itemIds"/>:</h3>
					</s2:if>
					<s2:if test="opType=='Del'">
					<h3>Remove Products from <s2:property value="itemIds"/>:</h3>
					</s2:if>
                    	<table border="1"  style="width:450px;" align="center">	
							<tr  >
								<td align="center">
								<s2:select multiple="true" size="10" list="products"  name="productId" listKey="productId" listValue="productName"></s2:select><br/>
								<br/>
								</td>								
 							</tr>
							<tr align="center">
								<td>
									<s2:submit value="OK"/>&nbsp;&nbsp;&nbsp;&nbsp;
									<s2:submit value="Close" onclick="history.back();return false; " />
								</td>
							</tr>
                        </table>
                        
                   </s2:form>
                </div>
              
        
    <!-- // #wrapper -->
</body>
</html>