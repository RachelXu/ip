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
                <h2><a href="#">Account Management</a> &raquo; <a href="#" class="active">Update Account</a></h2>
                <div id="main1" class="main"><br/>
                <p align="left"><s2:fielderror cssStyle="font-size:15px; color:red; font-weight:bold "/>
                <s2:actionmessage cssStyle="font-size:15px; font-weight:bold "/></p>
                <s2:form action="update_account_accountupdate" theme="simple">
                <s2:hidden name="editId"/>
					<h3>Current Account:<br/></h3>
                    	<table border="1"  style="width:550px;" align="center">	
							<tr>
							  <td align="right">  AccountID:&nbsp;</td>
							  <td align="center"><s2:textfield name="account.account.accountId" size="30" readonly="true" /></td>
							</tr>							
							<tr>
							  <td align="right">Account State:&nbsp;</td>
							  <td align="center"><s2:textfield name="account.account.state" size="30" readonly="false" /></td>
							</tr>
							<tr align="center">
								<td colspan="2" >
									<s2:submit value="Save"/>&nbsp;&nbsp;&nbsp;&nbsp;
									<s2:submit value="Cancel" onclick="window.close()" />
								</td>
							</tr>
							
                        </table>
                        
                   </s2:form>
                </div>
              
        
    <!-- // #wrapper -->
</body>
</html>