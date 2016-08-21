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
                    	<li><a href="precardsearch.action" class="active">��ֵ����ѯ</a></li>
                    	<li><a href="precardbatchedit.action">��ֵ�������޸�</a></li>
                    	<li><a href="precardbatchdelete.action">��ֵ������ɾ��</a></li>
                    	<s2:if test='#session.admin.level.equals("1") || #session.admin.level.equals("2")'>
                    	<li><a href="preserviceinsert.action" >��ӷ����ײ�</a></li>
                    	<li><a href="preservicesearch.action" >�����ײ͹���</a></li>
                    	</s2:if>
                    </ul>
                </div>    
                <!-- // #end sidebar -->
                
                <!-- main page -->
                <h2><a href="#">��ֵ������</a> &raquo; <a href="#" class="active">��ֵ����ѯ</a></h2>
                <div id="main1" class="main">
                <p align="left"><s2:fielderror cssStyle="font-size:15px; color:red; font-weight:bold "/></p>
                <s2:form action="procardedit" theme="simple">
                <s2:hidden name="editId"/>
					<h3>�޸���Ϣ</h3>
                    	<table border="1">	
							<tr>
							  <td>��ֵ��ID</td>
							  <td><s2:textfield name="cardEdit.id" size="10" maxlength="5" readonly="true" /></td>
							  <td>��ֵ������</td>
							  <td><s2:textfield name="cardEdit.pwd" size="10" maxlength="10"/></td>
							</tr>
							<tr>
							  <td>��ֵ��״̬</td>
							  <td>
								<s2:select list="cardEdit.stateList" name="cardEdit.state" listKey="value" listValue="label" headerKey="" headerValue="-"></s2:select>
							  </td>
							  <td>��ֵʱ��</td>
							  <td>
								<s2:textfield name="cardEdit.day" size="10" maxlength="10"/>
							  </td>
							</tr>
							<tr>
							  <td>��ֵ����</td>
							  <td><s2:textfield name="cardEdit.chargedate" size="10" maxlength="8" onclick="JTC.setday({format: 'yyyyMMdd'})"/></td>
							  <td>��ֹ����</td>
							  <td><s2:textfield name="cardEdit.enddate" size="10" maxlength="8" onclick="JTC.setday({format: 'yyyyMMdd'})"/></td>
							</tr>
							<tr align="center">
								<td colspan="4" >
									<s2:submit value="ȷ���޸�"/>&nbsp;&nbsp;&nbsp;&nbsp;<s2:submit value="ȡ��" onclick="history.back();return false; " />
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