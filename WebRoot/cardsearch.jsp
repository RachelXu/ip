<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@ taglib uri="/struts-tags" prefix="s2"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>DAQI IPTV</title>
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
document.getElementsByName("card.currentPage")[0].value="";
document.getElementsByName("card.pageCount")[0].value="";
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
    	<h1><a href="#"><span>����ϵͳ</span></a></h1>
    	<!-- // #start mainNav -->
		<%@include file="headbar_card.jsp" %>
        <!-- // #end mainNav -->
        <div id="containerHolder">
			<div id="container">
			<!-- // #start sidebar -->
        		<div id="sidebar">
                	<ul class="sideNav">
                    	<li><a href="precardsearch.action" class="active">Card Management</a></li>
                	    <li><a href="precardbatchinsert.action" >Imports Prepay Cards</a></li>
                	    <li><a href="precardbatchinsert.action" >Create Prepay Cards</a></li>
                	    <li><a href="precardbatchinsert.action" >New a Prepay Card</a></li>
                    </ul>
                </div>    
                <!-- // #end sidebar -->
                
                <!-- main page -->
                <h2><a href="#">��ֵ������</a> &raquo; <a href="#" class="active">��ֵ����ѯ</a></h2>
                <div id="main1" class="main">
                <p align="left"><s2:fielderror cssStyle="font-size:15px; color:red; font-weight:bold "/></p>
                <s2:form action="procardsearch" theme="simple">
                <s2:hidden name="pageString"/>
                <s2:hidden name="card.currentPage"/>
                <s2:hidden name="card.pageCount"/>
                <s2:hidden name="deleteId"/>
                <s2:hidden name="editId"/>
					<h3>��ѯ����</h3>
                    	<table border="1">	
							<tr>
							  <td>��ֵ��ID</td>
							  <td><s2:textfield name="card.productCard.cardNumber" size="10" maxlength="5"/></td>
							  <td>�û�����</td>
							  <td></td>
							</tr>
							<tr>
							  <td>��ֵ��״̬</td>
							  <td>
							  </td>
							  <td>��ֵʱ��</td>
							  <td>
							  </td>
							</tr>
							<tr>
							  <td>��ֵ����</td>
							  <td>
							  </td>
							  <td>��ֹ����</td>
							  <td>
							  </td>
							</tr>

							<tr align="center">
								<td colspan="4" >
									<s2:submit value="��ѯ" onclick="resetPage()"/>&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="����" onclick="window.location.href='precardsearch.action'" />
								</td>
							</tr>
                        </table>
                        <s2:if test="card.resultFlag">
                        <h3>��ѯ���</h3>
						<table>
							<tr>
						 	  <td >��ֵ��id</td>
						 	  <td >��ֵ��id</td>
						      <td >��ֵ��״̬</td>
						 	  <td >��ֵʱ��</td>
							  <td >��ֹ����</td>
							  <td >��ֵʱ�� </td>
							  <td>����</td>
	    					</tr>
	    				  <s2:iterator value="card.productCardSet" var="detil">
						  <tr>    
							  <td><s2:property value="cardNumber"/> </td>       
						 	  <td><s2:property value="cardValue"/></td>    
						      <td><s2:property value="productID"/></td>    
						      <td><s2:property value="cardState"/></td>    
						      <td><s2:property value="useDate"/></td>
						      <td><s2:property value="accountID"/></td>
						      <td>
					          <s2:submit action="precardedit" value="�޸�" onclick="edit(%{id})"> </s2:submit>
					          <s2:submit action="precarddelete" value="ɾ��" onclick="del(%{id})">  </s2:submit> </td> 
					      </tr>
					      </s2:iterator>
					      <tr>
					      	<td colspan="7" align="right">
					      	��<s2:property value="card.resultCount"/>���������ǰ��<s2:property value="card.currentPage"/>/<s2:property value="card.pageCount"/>ҳ
					        <s2:if test="card.currentPage!=1">
					        <s2:submit action="procardsearch" value="��һҳ" onclick="priv()"/>
					        </s2:if>
					        <s2:if test="card.currentPage<card.pageCount">
					        <s2:submit action="procardsearch" value="��һҳ" onclick="next()"/>
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