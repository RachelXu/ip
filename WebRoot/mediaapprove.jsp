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
chkList = document.getElementsByName("approveCkeck");
for(i=0;i<chkList.length;i++){
	chkList[i].checked=true;
}
return false;
}
function checkNone(){
chkList = document.getElementsByName("approveCkeck");
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
		<%@include file="headbar_media.jsp" %>
        <!-- // #end mainNav -->
        <div id="containerHolder">
			<div id="container">
			<!-- // #start sidebar -->
        		<div id="sidebar">
                	<ul class="sideNav">
                		<s2:if test='#session.admin.level.equals("1") || #session.admin.level.equals("2")'>
                    	<li><a href="precatalogman.action" >Ŀ¼����</a></li>
                    	</s2:if>
                    	<li><a href="premediasearch.action" >��Ŀ���ݹ���</a></li>
                    	<li><a href="premediainsert.action">��Ŀ�������</a></li>
                    	<li><a href="premediabatchupload.action">��Ŀ���������ϴ�</a></li>
                    	<s2:if test='#session.admin.level.equals("1") || #session.admin.level.equals("2")'>
                    	<li><a href="premediaapprove.action"   class="active">ȷ�Ͻ�Ŀ���ͨ��</a></li>
                    	</s2:if>
                    	<s2:if test='#session.admin.level.equals("1") '>
                    	<li><a href="premediadisapprove.action" >ȷ�Ͻ�Ŀ����</a></li>
                    	</s2:if>
                    </ul>
                </div>    
                <!-- // #end sidebar -->
                
                <!-- main page -->
                <h2><a href="#">��Ŀ��Ϣ����</a> &raquo; <a href="#" class="active">ȷ�Ͻ�Ŀ���ͨ��</a></h2>
                <div id="main1" class="main">
                <p align="left"><s2:fielderror cssStyle="font-size:15px; color:red; font-weight:bold "/></p>
                <s2:form action="promediasearch" theme="simple">
                <s2:hidden name="pageString"/>
                <s2:hidden name="media.currentPage"/>
                <s2:hidden name="media.pageCount"/>
                <s2:hidden name="deleteId"/>
                <s2:hidden name="editId"/>
                        <s2:if test="media.resultFlag">
                        <h3>����˽�Ŀ�б�</h3>
						<table>
							<tr>
							  <td >ѡ��</td>
						 	  <td >��ĿID</td>
						      <td >��Ŀ����</td>
						 	  <td >����</td>
							  <td >����</td>
							  <td >���</td>
							  <td >����</td>
							  <td >����</td>
	    					</tr>
	    				  <s2:iterator value="media.resultList" var="detil">
						  <tr>    
						 	  <td><s2:checkbox name="approveCkeck" fieldValue="%{mediaId}" ></s2:checkbox></td>  
						 	  <td ><s2:property value="mediaId"/></td>
						      <td ><s2:property value="mediaName"/></td>
						 	  <td ><s2:property value="language"/></td>
							  <td ><s2:property value="area"/></td>
							  <td ><s2:property value="year"/></td>
							  <td ><s2:property value="director"/></td>
							  <td ><s2:property value="grade"/></td>
					      </tr>
					      </s2:iterator>
					      <tr>
							  <td colspan="8" align="center" >��Ч��ֹ����
								<s2:textfield name="media.endDate" size="10" maxlength="8" onclick="JTC.setday({format: 'yyyyMMdd'})"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							  <s2:set name="consequence" value="# {'1':'��ͨ��Ŀ','2':'VIP��Ŀ'}"></s2:set>
							  ��Ŀ��������<s2:select list="#consequence" listKey="key" listValue="value" name="media.serviceType" headerKey="" headerValue="-"></s2:select>
							  </td>
					      </tr>
					      <tr>
							  <td colspan="8" align="center" ><input type="button" value="ȫѡ" onclick="checkAll();"/>&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="ȡ��ȫѡ" onclick="checkNone();"/>&nbsp;&nbsp;&nbsp;&nbsp;<s2:submit value="ȷ�����ͨ��" action="promediaapprove" /> </td>
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