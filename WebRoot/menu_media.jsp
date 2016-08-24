<%@ page language="java" contentType="text/html; charset=GBK"%>
<%@ taglib uri="/struts-tags" prefix="s2"%>
<script type="text/javascript">

function moveMenu(id){
	alert(id);
	alert(document.all.itema.length);
	var state = document.all.itema[id].style.display;
    for(i=0;i<document.all.itema.length;i++){
        document.all.itema[i].style.display="none";  
        document.all.bar[i].style.display="none";  
    }
    
    if (state=="none")
    {
    	document.all.itema[id].style.display="";  
        document.all.bar[id].style.display="";  
    }    
}
function initDisplay()
{
	document.all.itema[0].style.display="";
	document.all.bar[0].style.display="";
}

function moveSubMenu(id){
    for(i=0;i<document.all.subitem.length;i++){
        document.all.subitem[i].style.display="none";  
    }
    document.all.subitem[id].style.display="";
}


function switchSysBar(){

    if (switchPoint.innerText=="<<"){
        switchPoint.innerText=">>"
        document.all("mnuList").style.display="none"
        top.content.cols="12,*"
    }
    else{
        switchPoint.innerText="<<"
        document.all("mnuList").style.display=""
        top.content.cols="196,*"
    }
}


</script>



					<ul class="sideNav">
                    	<li><a href="premediasearch.action"  class="active">Media Management</a></li>
                    	<li><a href="precatalogman.action" >Directory Management</a></li>
                    	<li><a href="premediainsert.action" >New Media</a></li>
                    	<li><a href="premediabatchupload.action">Import Medias</a></li>
                    	<s2:if test='#session.admin.level.equals("1") || #session.admin.level.equals("2")'>
                    	<li><a href="premediaapprove.action">确认节目审核通过</a></li>
                    	</s2:if>
                    	<s2:if test='#session.admin.level.equals("1") '>
                    	<li><a href="premediadisapprove.action" >确认节目发布</a></li>
                    	</s2:if>
                    </ul>
                    
                    
        