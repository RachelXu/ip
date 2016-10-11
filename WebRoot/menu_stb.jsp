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
                    	<li><a href="search_account_accountsearch.action" class="active" >STB Management</a></li>
                    	<li><a href="preuserupload.action" >Import STBs</a></li>
                    	<li><a href="preuserbatchedit.action">New STB</a></li>
                    </ul>
                    
                    
        