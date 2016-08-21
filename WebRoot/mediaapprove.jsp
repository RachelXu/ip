<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@ taglib uri="/struts-tags" prefix="s2"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>宽宏IPTV播控平台</title>
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
    	<h1><a href="#"><span>管理系统</span></a></h1>
    	<!-- // #start mainNav -->
		<%@include file="headbar_media.jsp" %>
        <!-- // #end mainNav -->
        <div id="containerHolder">
			<div id="container">
			<!-- // #start sidebar -->
        		<div id="sidebar">
                	<ul class="sideNav">
                		<s2:if test='#session.admin.level.equals("1") || #session.admin.level.equals("2")'>
                    	<li><a href="precatalogman.action" >目录管理</a></li>
                    	</s2:if>
                    	<li><a href="premediasearch.action" >节目内容管理</a></li>
                    	<li><a href="premediainsert.action">节目内容添加</a></li>
                    	<li><a href="premediabatchupload.action">节目内容批量上传</a></li>
                    	<s2:if test='#session.admin.level.equals("1") || #session.admin.level.equals("2")'>
                    	<li><a href="premediaapprove.action"   class="active">确认节目审核通过</a></li>
                    	</s2:if>
                    	<s2:if test='#session.admin.level.equals("1") '>
                    	<li><a href="premediadisapprove.action" >确认节目发布</a></li>
                    	</s2:if>
                    </ul>
                </div>    
                <!-- // #end sidebar -->
                
                <!-- main page -->
                <h2><a href="#">节目信息管理</a> &raquo; <a href="#" class="active">确认节目审核通过</a></h2>
                <div id="main1" class="main">
                <p align="left"><s2:fielderror cssStyle="font-size:15px; color:red; font-weight:bold "/></p>
                <s2:form action="promediasearch" theme="simple">
                <s2:hidden name="pageString"/>
                <s2:hidden name="media.currentPage"/>
                <s2:hidden name="media.pageCount"/>
                <s2:hidden name="deleteId"/>
                <s2:hidden name="editId"/>
                        <s2:if test="media.resultFlag">
                        <h3>待审核节目列表</h3>
						<table>
							<tr>
							  <td >选择</td>
						 	  <td >节目ID</td>
						      <td >节目名称</td>
						 	  <td >语言</td>
							  <td >地区</td>
							  <td >年代</td>
							  <td >导演</td>
							  <td >评分</td>
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
							  <td colspan="8" align="center" >有效截止日期
								<s2:textfield name="media.endDate" size="10" maxlength="8" onclick="JTC.setday({format: 'yyyyMMdd'})"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							  <s2:set name="consequence" value="# {'1':'普通节目','2':'VIP节目'}"></s2:set>
							  节目服务类型<s2:select list="#consequence" listKey="key" listValue="value" name="media.serviceType" headerKey="" headerValue="-"></s2:select>
							  </td>
					      </tr>
					      <tr>
							  <td colspan="8" align="center" ><input type="button" value="全选" onclick="checkAll();"/>&nbsp;&nbsp;&nbsp;&nbsp;<input type="button" value="取消全选" onclick="checkNone();"/>&nbsp;&nbsp;&nbsp;&nbsp;<s2:submit value="确认审核通过" action="promediaapprove" /> </td>
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