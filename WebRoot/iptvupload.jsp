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
		<%@include file="headbar_iptv.jsp" %>
        <!-- // #end mainNav -->
        <div id="containerHolder">
			<div id="container">
			<!-- // #start sidebar -->
        		<div id="sidebar">
                	<ul class="sideNav">
                    	<li><a href="preiptvupload.action" class="active" >�����汾��Ϣ</a></li>
                    	<li><a href="preiptvhistoryaction.action" >��ʷ�汾��Ϣ</a></li>
                    </ul>
                </div>    
                <!-- // #end sidebar -->
                
                <!-- main page -->
                <h2><a href="#">�����й���</a> &raquo; <a href="#" class="active">�����汾��Ϣ</a></h2>
                <div id="main1" class="main">
                <p align="left"><s2:fielderror cssStyle="font-size:15px; color:red; font-weight:bold "/></p>
                <s2:form action="proiptvupload" theme="simple" method="post" enctype="multipart/form-data">
					<h3>�����汾��Ϣ</h3>
                    	<table border="1">	
						<tr><td>
						˵��:��������µİ汾��Ϣ<br/>
						�汾��:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s2:textfield name="version" size="10" maxlength="5"/><br/>
						��������:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s2:textfield name="update" size="10" maxlength="8" onclick="JTC.setday({format: 'yyyyMMdd'})"/><br/>
						Ԥ��ʹ��ʱ��:<s2:textfield name="usedate" size="10" maxlength="8" onclick="JTC.setday({format: 'yyyyMMdd'})"/><br/>
						�ϴ�����:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s2:file name="upload"/><br/>
						��������:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<s2:textfield name="content" size="30" maxlength="100"/><br/>
						<s2:submit value="ȷ���ϴ�" /><input type="button" value="����" onclick="window.location.href='preiptvupload.action'" />
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