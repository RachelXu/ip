<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@ taglib uri="/struts-tags" prefix="s2"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>���IPTV����ƽ̨</title>
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
document.getElementsByName("service.currentPage")[0].value="";
document.getElementsByName("service.pageCount")[0].value="";
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
                	    <li><a href="precardbatchinsert.action" >��ֵ����������</a></li>
                	    <li><a href="precarddownload.action">��ֵ����Ϣ����</a></li>
                    	<li><a href="precardsearch.action" >��ֵ����ѯ</a></li>
                    	<li><a href="precardbatchedit.action">��ֵ�������޸�</a></li>
                    	<li><a href="precardbatchdelete.action">��ֵ������ɾ��</a></li>
                    	<s2:if test='#session.admin.level.equals("1") || #session.admin.level.equals("2")'>
                    	<li><a href="preserviceinsert.action">��ӷ����ײ�</a></li>
                    	<li><a href="preservicesearch.action" class="active">�����ײ͹���</a></li>
                    	</s2:if>
                    </ul>
                </div>    
                <!-- // #end sidebar -->
                
                <!-- main page -->
                <h2><a href="#">��ֵ������</a> &raquo; <a href="#" class="active">�����ײ͹���</a></h2>
                <div id="main1" class="main">
                <p align="left"><s2:fielderror cssStyle="font-size:15px; color:red; font-weight:bold "/></p>
                <s2:form action="proservicesearch" theme="simple">
                <s2:hidden name="pageString"/>
                <s2:hidden name="service.currentPage"/>
                <s2:hidden name="service.pageCount"/>
                <s2:hidden name="deleteId"/>
                <s2:hidden name="editId"/>
					<h3>��ѯ����</h3>
                    	<table border="1">	
							<tr>
							  <td>�����ײ�����&nbsp;&nbsp;&nbsp;&nbsp;<s2:textfield name="service.serviceName" size="10" maxlength="10"/></td>
							  <td></td>
							  <td></td>
							  <td></td>
							</tr>
							<tr>
							  <td>��������&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s2:textfield name="service.serviceDay" size="10" maxlength="10"/></td>
							  <td>
							  </td>
							  <td></td>
							  <td></td>
							</tr>
							<tr align="center">
								<td colspan="4" >
									<s2:submit value="��ѯ" onclick="resetPage()"/>&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="����" onclick="window.location.href='preservicesearch.action'" />
								</td>
							</tr>
                        </table>
                        <s2:if test="service.resultFlag">
                        <h3>��ѯ���</h3>
						<table>
							<tr>
						 	  <td >�����ײ�id</td>
						      <td >�����ײ�����</td>
						 	  <td >��������</td>
							  <td>����</td>
	    					</tr>
	    				  <s2:iterator value="service.resultList" var="detil">
						  <tr>    
							  <td><s2:property value="serviceId"/> </td>       
						 	  <td><s2:property value="serviceName"/></td>    
						      <td><s2:property value="serviceDay"/></td>    
						      <td>
					          <s2:submit action="preserviceedit" value="�޸�" onclick="edit(%{serviceId})"> </s2:submit>
					          <s2:submit action="preservicedelete" value="ɾ��" onclick="del(%{serviceId})">  </s2:submit> </td> 
					      </tr>
					      </s2:iterator>
					      <tr>
					      	<td colspan="7" align="right">
					      	��<s2:property value="service.resultCount"/>���������ǰ��<s2:property value="service.currentPage"/>/<s2:property value="service.pageCount"/>ҳ
					        <s2:if test="service.currentPage!=1">
					        <s2:submit action="proservicesearch" value="��һҳ" onclick="priv()"/>
					        </s2:if>
					        <s2:if test="service.currentPage<service.pageCount">
					        <s2:submit action="proservicesearch" value="��һҳ" onclick="next()"/>
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