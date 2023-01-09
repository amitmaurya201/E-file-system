<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>

<%
   HttpSession userPostIdValue = themeDisplay.getRequest().getSession();
   long userPostsVal = (long) userPostIdValue.getAttribute("userPostId"); 	
%> 
<aui:input name = "userPostsVal" value= "<%=userPostsVal %>" type = "hidden"></aui:input>

<aui:script>
 <%
String char_width = PropsUtil.get("max.width");
 
%>

 function bindFormDataJson(formObj){
	 //  var list= $('#<portlet:namespace/>formName')[0];
	   var formdata = new FormData(formObj);
	   var portletnamespace = '<portlet:namespace/>';
	   var object = {};
  	 formdata.forEach(function(value, key){
  	  var keySpace = key.trim();
  
  	  var splitnamespace = keySpace.split(portletnamespace)[1];
  	 var splitkey = splitnamespace;
  	
  	 
	   if (splitkey=="formDate" || splitkey == ""){
		   delete object[splitkey] ;   
	   }else{
		 object[splitkey] = value;
		 console.log("object"+object);
		
	   } 	  
	 });
	 
	 return object;
	   
   }
   
   function getUserPostId(){
		var userPostId = $("#userPostOption").val();
		 console.log(userPostId);
		 
	     return userPostId;	 
   }


 <%-- function setUserPostId(){
	 var userPostId = $('#userPostOption').find(":selected").val();
	 $('#userPostOption').on('change', function() {
	 	userPostId = this.value;
		
		AUI().use('liferay-portlet-url', function(A) {
	 		var actionURL = Liferay.PortletURL.createActionURL();
	 		actionURL.setWindowState("<%=LiferayWindowState.NORMAL.toString() %>");
	 		actionURL.setPortletMode("<%=LiferayPortletMode.VIEW %>");
	 		actionURL.setParameter("javax.portlet.action","/set/user/post/action/url");
	 		actionURL.setPortletId("<%= themeDisplay.getPortletDisplay().getId() %>");
	 		 
	 		console.log(actionURL.toString());
		 	 AUI().use('aui-io-request', function(A){
		         A.io.request(actionURL.toString(), {
		             method: 'post',
		             dataType: 'application/json',
		             data: {
		 	            <portlet:namespace/>userPostId : userPostId 
		 	         }, 
		 	            on : { 
		 	                success : function(data) { 
		 	                	location.reload();                   
		 	                } 
		 	            } 
		         });
		     });
	 		
 		});
	 	
	 });

 } --%>
 
 
 <!-- var char_width="<liferay-ui:message key='max-width-tooltip'/>"; -->
 $(".hover-tips").css("max-width", "<%=char_width %>");
 $(".hover-tips").hover(function() {
	    $(this).attr('title', $(this).text());	
	    
	});
 
 
 	
 </aui:script>