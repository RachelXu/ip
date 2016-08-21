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
		<%@include file="headbar_media.jsp" %>
        <!-- // #end mainNav -->
        <div id="containerHolder">
			<div id="container">
			<!-- // #start sidebar -->
        		<div id="sidebar">
                	<ul class="sideNav">
                    	<li><a href="precatalogman.action" >Ŀ¼����</a></li>
                    	<li><a href="premediasearch.action"  class="active">��Ŀ���ݹ���</a></li>
                    	<li><a href="premediainsert.action">��Ŀ�������</a></li>
                    	<li><a href="premediabatchupload.action">��Ŀ���������ϴ�</a></li>
                    	<s2:if test='#session.admin.level.equals("1") || #session.admin.level.equals("2")'>
                    	<li><a href="premediaapprove.action">ȷ�Ͻ�Ŀ���ͨ��</a></li>
                    	</s2:if>
                    	<s2:if test='#session.admin.level.equals("1") '>
                    	<li><a href="premediadisapprove.action" >ȷ�Ͻ�Ŀ����</a></li>
                    	</s2:if>
                    </ul>
                </div>    
                <!-- // #end sidebar -->
                
                <!-- main page -->
                <h2><a href="#">��Ŀ��Ϣ����</a> &raquo; <a href="#" class="active">��Ŀ���ݹ���</a></h2>
                <div id="main1" class="main">
                <p align="left"><s2:fielderror cssStyle="font-size:15px; color:red; font-weight:bold "/></p>
                <s2:form action="promediaedit" theme="simple">
                <s2:hidden name="deleteId"/>
                <s2:hidden name="editId"/>
					<h3>�޸���Ϣ</h3>
                    	<table border="1">	
							<tr>
							  <td>��ĿID</td>
							  <td><s2:textfield name="media.mediaId" size="10" maxlength="5" readonly="true"/></td>
							  <td></td>
							  <td></td>
							</tr>
							<tr>
							  <td>��Ŀ��������</td>
							  <td><s2:textfield name="media.mediaName" size="10" maxlength="10"/></td>
							  <td>��ĿӢ������</td>
							  <td><s2:textfield name="media.mediaNameEn" size="10" maxlength="10"/></td>
							</tr>
							<tr>
							  <td>����</td>
							  <td>
								<s2:select list="media.languageList"  name="media.languageId" listKey="value" listValue="label" headerKey="" headerValue="-" ></s2:select>
							  </td>
							  <td>����</td>
							  <td>
								<s2:select list="media.areaList" name="media.areaId" listKey="value" listValue="label" headerKey="" headerValue="-"></s2:select>
							  </td>
							</tr>
							<tr>
							  <td>���</td>
							  <td><s2:textfield name="media.year" size="10" maxlength="8" onclick="JTC.setday({format: 'yyyyMMdd'})"/></td>
							  <td>����</td>
							  <td><s2:textfield name="media.director" size="20" maxlength="20"/></td>
							</tr>
							<tr>
							  <td>��Ա</td>
							  <td><s2:textfield name="media.actor" size="20" maxlength="20"/></td>
							  <td>����</td>
							  <td><s2:textfield name="media.grade" size="5" maxlength="5"/></td>
							</tr>
							<tr>
							  <td>����Ŀ¼</td>
							  <td>
							  <s2:select list="media.catalogList" name="media.mediaCatalogId" listKey="value" listValue="label" headerKey="" headerValue="-" multiple="true" size="5"></s2:select>
							  </td>
							  <td>
							  </td>
							  <td></td>
							</tr>
							<tr align="center">
								<td colspan="4" >
									<s2:submit value="ȷ���޸�"/>
									<s2:submit value="ȡ��" onclick="history.back();return false; " />
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