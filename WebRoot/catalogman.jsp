<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@ taglib uri="/struts-tags" prefix="s2"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>DAQI IPTV</title>
<link href="style/css/transdmin.css" rel="stylesheet" type="text/css" media="screen" />
<!-- JavaScripts-->
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
                    	<li><a href="premediasearch.action">Media Management</a></li>
                    	<li><a href="precatalogman.action"    class="active">Directory Management</a></li>
                    	<li><a href="premediainsert.action">New Media</a></li>
                    	<li><a href="premediabatchupload.action">Import Medias</a></li>
                    	<s2:if test='#session.admin.level.equals("1") || #session.admin.level.equals("2")'>
                    	<li><a href="premediaapprove.action">确认节目审核通过</a></li>
                    	</s2:if>
                    	<s2:if test='#session.admin.level.equals("1") '>
                    	<li><a href="premediadisapprove.action" >确认节目发布</a></li>
                    	</s2:if>
                    </ul>
                </div>    
                <!-- // #end sidebar -->
                
                <!-- main page -->
                <h2><a href="#">Media</a> &raquo; <a href="#" class="active">Directory Management</a></h2>
                <div id="main1" class="main">
                <p align="left"><s2:fielderror cssStyle="font-size:15px; color:red; font-weight:bold "/></p>
                <s2:form action="procatalogman" theme="simple">
                <s2:hidden name="deleteId"/>
                <s2:hidden name="editId"/>
						<table>
						<tr>
							<td>Name:</td>
							<td><s2:textfield name="catalog.catalogZhName"  size="10" maxlength="10" /></td>
							<td>Name(En):</td>
							<td><s2:textfield name="catalog.catalogEnName"  size="10" maxlength="10"/></td>
						</tr>
						<tr>
							<td>��ʾ˳��:</td>
							<td><s2:textfield name="catalog.order"  size="3" maxlength="3"/></td>
							<td>�ϼ���Ŀ:</td>
							<td><s2:select list="catalog.firstLeveList" name="catalog.superId" listKey="value" listValue="label" headerKey="" headerValue="-">
								<s2:iterator value="catalog.secondLabel" var="sencondLable" status="status" >
								<s2:optgroup label="%{sencondLable}" list="catalog.sencondLeveList.get(#status.index)" listKey="value" listValue="label">
								</s2:optgroup>
								</s2:iterator>
								</s2:select>
							</td>
						</tr>
						<tr>
						<td colspan="4" align="center" >
							<s2:submit value="�ύ"></s2:submit>&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="button" value="����" onclick="window.location.href='precatalogman.action'" />
						</td>
						</tr>
						</table>
						<s2:if test="catalog.resultFlag">
                        <h3>��Ŀ����</h3>
						<table>
							<tr>
						 	  <td >Ŀ¼ID</td>
						      <td >Ŀ¼�������</td>
						      <td >Ŀ¼Ӣ�����</td>
						 	  <td >��ʾ˳��</td>
							  <td>����</td>
	    					</tr>
	    				  <s2:iterator value="catalog.resultList" var="detil">
						  <tr>    
							  <td><s2:property value="catalogId"/> </td>       
						 	  <td><s2:property value="catalogZhName" escapeHtml="false" /></td>    
						 	  <td><s2:property value="catalogEnName"/></td>   
						      <td><s2:property value="order"/></td>
						      <td>
					          <s2:submit action="precatalogedit" value="�޸�" onclick="edit('%{catalogId}')"> </s2:submit>
					          <s2:submit action="precatalogdelete" value="ɾ��" onclick="del('%{catalogId}')">  </s2:submit> </td> 
					      </tr>
					      </s2:iterator>
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