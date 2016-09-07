<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@ taglib uri="/struts-tags" prefix="s2"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>宽宏IPTV播控平台</title>
<link href="style/css/transdmin.css" rel="stylesheet" type="text/css" media="screen" />
<!-- JavaScripts-->
<script language="javascript" type="text/javascript">
function priv(){
document.getElementsByName("pageString")[0].value="priv";
}
function next(){
document.getElementsByName("pageString")[0].value="next";
}
function resetPage(){
document.getElementsByName("account.currentPage")[0].value="";
document.getElementsByName("account.pageCount")[0].value="";
}
function edit(parm){
	var url = "accountUpdate?itemId=" + parm;
	window.open(url,'','height=400,width=720, toolbar=no, menubar=no, scrollbars=yes, resizable=no,location=no, status=no');
	return false;
}
function del(parm){
	if (confirm("Will you delete Account: " + parm + "?")) {
        document.getElementsByName("itemId")[0].value=parm;
        return true;
    } else {
		return false;
    }	
}
function assignProduct(opType){
	var inputs = document.getElementsByName("checkSign");
	var accIds = "";
	for(var i=0; i< inputs.length; i++) {
		if (inputs[i].checked){
			accIds = accIds + ";" + inputs[i].value;
		}
	}
	if (accIds.length > 1){
		accIds = accIds.substring(1);
		var url = "accountProduct?accIds=" + accIds + "&type=" + opType;
		alert(url);
		window.open(url,'','height=400,width=720, toolbar=no, menubar=no, scrollbars=yes, resizable=no,location=no, status=no');
	} else {
		alert("Please select account first.");
	}
	
	return false;
}

function select_all(state) 
{
 var inputs = document.getElementsByName("checkSign");

 for(var i=0; i< inputs.length; i++)
 {
  if(inputs[i].type == "checkbox")
  {
   inputs[i].checked =state; 
  }
 }
}

function select_inverse() {
 var inputs = document.getElementsByName("checkSign");
 for(var i=0; i< inputs.length; i++) {
  if(inputs[i].type == "checkbox"){
	if (inputs[i].checked == true){
	  inputs[i].checked = false; 
	}else{
		inputs[i].checked = true;
	}
  }
 }
}

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
                    	<li><a href="preusersearch.action" class="active" >STB Management</a></li>
                    	<li><a href="preuserupload.action" >Import STBs</a></li>
                    	<li><a href="userinsert.jsp">New a STB</a></li>
                    </ul>
                </div>    
                <!-- // #end sidebar -->
                
                <!-- main page -->
                <h2><a href="#">STB</a> &raquo; <a href="#" class="active"> Management</a></h2>
                <div id="main1" class="main">
                <p align="left"><s2:fielderror cssStyle="font-size:15px; color:red; font-weight:bold "/></p>
                <s2:form action="prousersearch" theme="simple">
                <s2:hidden name="pageString" value=""/>
                <s2:hidden name="account.currentPage"/>
                <s2:hidden name="account.pageCount"/>
                <s2:hidden name="itemId" value=""/>
					<h3>Query</h3>
                    	<table border="1">	
							<tr>
							  <td>STB ID:</td>
							  <td><s2:textfield name="account.account.accountId" size="20" maxlength="20"/></td>
							</tr>
							<tr>
							  <td>Product Sets:</td>
							  <td>
								<s2:select list="products"  name="productId" listKey="productId" listValue="productName" headerKey="" headerValue="-"></s2:select>
							  </td>
							</tr>
							<tr>
							  <td>State:</td>
							  <td>
							    <s2:select list="account.accountStatus"  name="account.account.state" listKey="value" listValue="value" headerKey="" headerValue="-"></s2:select>
							  </td>
							</tr>
							<tr align="center">
								<td colspan="2" >
									<s2:submit value="Search" onclick="resetPage()"/>&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="button" value="Reset" onclick="window.location.href='preusersearch.action'" />
								</td>
							</tr>
                        </table>
                        <s2:if test="account.resultFlag">
                        <h3>Result</h3>
						<table>
							<tr >
								<td>&nbsp; </td>
						 	  <td >STB ID</td>
						 	  <td >State</td>
							  <td>Operation</td>
	    					</tr>
	    				  <s2:iterator value="account.accountList" var="detil">
						  <tr>
						  	<td><s2:checkbox name="checkSign" value="false" fieldValue="%{accountId}"/> </td>    
							  <td><s2:property value="accountId"/> </td>       
						      <td><s2:property value="state"/></td>    
						      <td>
					          <s2:submit value="Update" onclick="edit('%{accountId}')" />
					          <s2:submit action="accountDelete" value="Delete" onclick="del('%{accountId}')">  </s2:submit> </td> 
					      </tr>
					      </s2:iterator>
					      <tr>
					      	<td colspan="7" align="right">
						      	<s2:property value="user.resultCount"/>records, <s2:property value="account.currentPage"/>/<s2:property value="account.pageCount"/>
						        <s2:if test="account.currentPage!=1">
						        <s2:submit action="prousersearch" value="上一页" onclick="priv()"/>
						        </s2:if>
						        <s2:if test="account.currentPage<account.pageCount">
						        <s2:submit action="prousersearch" value="下一页" onclick="next()"/>
						        </s2:if>
					        </td>
					      </tr>
						</table>
						
						<h3>Operations</h3>
                    	<table border="1">	
							<tr align="center">
								<td >
									<input type="button" value="Assign Product" onclick="assignProduct('Add');"/>
									&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="button" value="Remove Product" onclick="assignProduct('Del');" />
									&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="button" value=" Select All" onclick="select_all(true);" />
									&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="button" value=" Select None" onclick="select_all(false);" />
									&nbsp;&nbsp;&nbsp;&nbsp;
									<input type="button" value=" Inverse " onclick="select_inverse();" />
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