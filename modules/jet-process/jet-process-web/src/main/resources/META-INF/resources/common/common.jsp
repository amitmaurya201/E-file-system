<aui:script>

 function bindFormDataJson(formObj){
	 //  var list= $('#<portlet:namespace/>formName')[0];
	   var formdata = new FormData(formObj);
	   var portletnamespace = '<portlet:namespace/>';
	   var object = {};
  	 formdata.forEach(function(value, key){
  	  var keySpace = key.trim();
  
  	  var splitnamespace = keySpace.split(portletnamespace)[1];
  	 var test = splitnamespace;
  	
  	 
	   if (test=="formDate" || test == ""){
		   delete object[test] ;   
	   }else{
		 object[test] = value;
		 console.log("object"+object);
		
	   } 	  
	 });
	 
	 return object;
	   
   }
   
   function getUserPostId(){
		var userPostId = $("#value").val();
		 console.log(userPostId);
		 
	     return userPostId;	 
   }


 function setUserPostId(){
	 var userPostId = $('#value').find(":selected").val();
	 $('#value').on('change', function() {
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

 }
 
 
 	
 </aui:script>