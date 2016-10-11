<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@ taglib uri="/struts-tags" prefix="s2"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>宽宏IPTV播控平台</title>
<link href="style/css/transdmin.css" rel="stylesheet" type="text/css" media="screen" />
<!-- JavaScripts-->
<script language="javascript" type="text/javascript">
</script>
</head>
<body>
	<div id="wrapper">
    	<!-- h1 tag stays for the logo, you can use the a tag for linking the index page -->
    	<h1><a href="#"><span>管理系统</span></a></h1>
    	<!-- // #start mainNav -->
    	<%@include file="headbar_user.jsp" %>
        <!-- // #end mainNav -->
        <div id="containerHolder">
			<div id="container">
			<!-- // #start sidebar -->
        		<div id="sidebar">
					<ul class="sideNav">
                    	<li><a href="search_account_accountsearch.action">STB Management</a></li>
                    	<li><a href="preuserupload.action" >Import STBs</a></li>
                    	<li><a href="add_account_accountadd.action"  class="active" >New a STB</a></li>
                    </ul>
                </div>    
                <!-- // #end sidebar -->
                
                <!-- main page -->
                <h2><a href="#">STB</a> &raquo; <a href="#" class="active"> Management</a></h2>
                <div id="main1" class="main">
                <p align="left"><s2:fielderror cssStyle="font-size:15px; color:red; font-weight:bold "/><s2:actionmessage cssStyle="font-size:15px; font-weight:bold "/></p>
                <s2:form action="add_account_accountadd.action" theme="simple">
                    	<table border="1">	
							<tr>
							  <td>STB ID:</td>
							  <td><s2:textfield name="account.account.accountId" size="20" maxlength="20"/></td>
							</tr>
							<tr>
							  <td>State:</td>
							  <td>
							    <s2:select list="account.accountStatus"  name="account.account.state" listKey="value" listValue="value" headerKey="" headerValue="-"></s2:select>
							  </td>
							</tr>
							<tr align="center">
								<td colspan="2" >
									<s2:submit value="Submit"/>
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