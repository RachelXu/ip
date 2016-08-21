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
function checkAll( ){
chkList = document.getElementsByName("deleteCkeck");
for(i=0;i<chkList.length;i++){
	chkList[i].checked=true;
}
return false;
}
function checkNone(){
chkList = document.getElementsByName("deleteCkeck");
for(i=0;i<chkList.length;i++){
	chkList[i].checked=false;
}
return false;
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
                    	<li><a href="precardsearch.action"  >��ֵ����ѯ</a></li>
                    	<li><a href="precardbatchedit.action">��ֵ�������޸�</a></li>
                    	<li><a href="precardbatchdelete.action" class="active">��ֵ������ɾ��</a></li>
                    	<s2:if test='#session.admin.level.equals("1") || #session.admin.level.equals("2")'>
                    	<li><a href="preserviceinsert.action" >��ӷ����ײ�</a></li>
                    	<li><a href="preservicesearch.action" >�����ײ͹���</a></li>
                    	</s2:if>
                    </ul>
                </div>    
                <!-- // #end sidebar -->
                
                <!-- main page -->
                <h2><a href="#">��ֵ������</a> &raquo; <a href="#" class="active">��ֵ������ɾ��</a></h2>
                <div id="main1" class="main">
                <p align="left"><s2:fielderror cssStyle="font-size:15px; color:red; font-weight:bold "/></p>
                <s2:form action="procardbatchdelete" theme="simple">
					<h3>��ѯ����</h3>
                    	<table border="1">	
							<tr>
							  <td>��ֵ��ID</td>
							  <td><s2:textfield name="card.id1" size="10" maxlength="5"/>&nbsp;&nbsp;��&nbsp;&nbsp;<s2:textfield name="card.id2" size="10" maxlength="5"/></td>
							  <td>�û�����</td>
							  <td><s2:textfield name="card.userName" size="10" maxlength="10"/></td>
							</tr>
							<tr>
							  <td>��ֵ��״̬</td>
							  <td>
								<s2:select list="card.stateList" name="card.state" listKey="value" listValue="label" headerKey="" headerValue="-"></s2:select>
							  </td>
							  <td>��ֵʱ��</td>
							  <td>
								<s2:textfield name="card.day1" size="10" maxlength="10"/>&nbsp;&nbsp;��&nbsp;&nbsp;<s2:textfield name="card.day2" size="10" maxlength="10" />
							  </td>
							</tr>
							<tr>
							  <td>��ֵ����</td>
							  <td><s2:textfield name="card.chargedate1" size="10" maxlength="8" onclick="JTC.setday({format: 'yyyyMMdd'})" />&nbsp;&nbsp;��&nbsp;&nbsp;<s2:textfield name="card.chargedate2" size="10" maxlength="8" onclick="JTC.setday({format: 'yyyyMMdd'})" /></td>
							  <td>��ֹ����</td>
							  <td><s2:textfield name="card.enddate1" size="10" maxlength="8" onclick="JTC.setday({format: 'yyyyMMdd'})"/>&nbsp;&nbsp;��&nbsp;&nbsp;<s2:textfield name="card.enddate2" size="10" maxlength="8" onclick="JTC.setday({format: 'yyyyMMdd'})"/></td>
							</tr>
							<tr>
							  <td>����</td>
							  <td><s2:textfield name="card.batchNum" size="10" maxlength="5" /></td>
							  <td></td>
							  <td></td>
							</tr>
							<tr align="center">
								<td colspan="4" >
									<s2:submit value="��ѯ" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="����" onclick="window.location.href='precardbatchdelete.action'" />
								</td>
							</tr>
                        </table>
                        <s2:if test="card.resultFlag">
                        <h3>��ѯ���</h3>
						<table>
							<tr>
						 	  <td >ѡ��</td>
						 	  <td >��ֵ��id</td>
						      <td >��ֵ��״̬</td>
						 	  <td >��ֵʱ��</td>
							  <td >��ֹ����</td>
							  <td >��ֵʱ�� </td>
	    					</tr>
	    				  <s2:iterator value="card.resultList" var="detil">
						  <tr>    
							  <td><s2:checkbox name="deleteCkeck" fieldValue="%{id}" ></s2:checkbox></td>  
							  <td><s2:property value="id"/> </td>       
						 	  <td><s2:property value="state"/></td>    
						      <td><s2:property value="day"/></td>    
						      <td><s2:property value="enddate"/></td>
						      <td><s2:property value="chargedate"/></td>
					      </tr>
					      </s2:iterator>
					      <tr>
							  <td colspan="6" align="center" ><input type="button" value="ȫѡ" onclick="checkAll();"/><input type="button" value="ȡ��ȫѡ" onclick="checkNone();"/><s2:submit value="ȷ��ɾ��" action="procardbatchdeleteexec" /> </td>
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