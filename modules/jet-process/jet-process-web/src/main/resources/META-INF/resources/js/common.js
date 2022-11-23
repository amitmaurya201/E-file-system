<script >
   function bindFormDataJson(formObj){
	 //  var list= $('#<portlet:namespace/>formName')[0];
	   var formdata = new FormData(formObj);
	   
	   var object = {};
  	 formdata.forEach(function(value, key){
  	  var keySpace = key.trim();
  
  	  var splitnamespace = keySpace.split("_io_jetprocess_web_JetProcessWebPortlet_INSTANCE_kapw_")[1];
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
 </script>
 
