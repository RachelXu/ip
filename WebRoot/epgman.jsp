<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@ taglib uri="/struts-tags" prefix="s2"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>���IPTV����ƽ̨</title>
<link href="style/css/transdmin.css" rel="stylesheet" type="text/css" media="screen" />
<!-- JavaScripts-->
<script language="javascript" type="text/javascript">

</script>
</head>
<body>
	<div id="wrapper">
    	<!-- h1 tag stays for the logo, you can use the a tag for linking the index page -->
    	<h1><a href="#"><span>����ϵͳ</span></a></h1>
    	<!-- // #start mainNav -->
		<%@include file="headbar_epg.jsp" %>
        <!-- // #end mainNav -->
        <div id="containerHolder">
			<div id="container">
			<!-- // #start sidebar -->
        		<div id="sidebar">
                	<ul class="sideNav">
                		<li><a href="preadminpassword.action"  >�޸�����</a></li>
                    	<s2:if test='#session.admin.level.equals("1") '>
                    	<li><a href="preepgman.action" class="active" >EPG����������</a></li>
                    	</s2:if>
                    	<s2:if test='#session.admin.level.equals("1") || #session.admin.level.equals("2")'>
                    	<li><a href="preadmininsert.action" >��ӹ���Ա</a></li>
                    	</s2:if>
                    </ul>
                </div>    
                <!-- // #end sidebar -->
                
                <!-- main page -->
                <h2><a href="#">��ά����</a> &raquo; <a href="#" class="active">EPG����������</a></h2>
                <div id="main1" class="main">
                <p align="left"><s2:fielderror cssStyle="font-size:15px; color:red; font-weight:bold "/></p>
                <s2:form action="preepgman" theme="simple">
					<h3>EPG��������Ϣ</h3>
						<table>
							<tr>
						 	  <td >����������</td>
						      <td >������С�˿ں�</td>
						 	  <td >�������˿ں�</td>
							  <td >״̬</td>
							  <td>����</td>
	    					</tr>
						  <tr>    
							  <td><s2:property value="epg.name"/> </td>       
						 	  <td><s2:property value="epg.minPort"/></td>    
						      <td><s2:property value="epg.maxPort"/></td>    
						      <td><s2:property value="epg.state"/></td>
						      <td>
						      <s2:if test="!epg.stateFlag">
					          <s2:submit action="proepgstart" value="����"> </s2:submit>
					          <s2:submit action="proepgstop" value="�ر�" disabled="true"> </s2:submit>
					          </s2:if>
					          <s2:if test="epg.stateFlag">
					          <s2:submit action="proepgstart" value="����" disabled="true"> </s2:submit>
					          <s2:submit action="proepgstop" value="�ر�"> </s2:submit>
					          </s2:if>
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