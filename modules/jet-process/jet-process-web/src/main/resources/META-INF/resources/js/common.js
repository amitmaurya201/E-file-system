<script >
   function bindFormDataJson(formObj){
	 var formdata = new FormData(formObj);
	 var portletnamespace = '<portlet:namespace/>';
	 var object = {};
  	 formdata.forEach(function(value, key){
  	 var keySpace = key.trim();
  	 var splitnamespace = keySpace.split(portletnamespace)[1];
  	 var test = splitnamespace;
	  if (test=="formDate" || test == ""){
		   delete object[test] ;   
	   }
	  else{
		 object[test] = value;
	   } 	  
	 });
	  return object;   
   }
   function getUserPostId(){
		var userPostId = $("#value").val(); 
	    return userPostId;	 
   }
 </script>
 
