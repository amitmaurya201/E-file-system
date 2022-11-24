<script >
   function bindFormDataJson(formObj){
	   var formdata = new FormData(formObj);
	   var portletnamespace = '<portlet:namespace/>';
	   console.log(portletnamespace);
	   var object = {};
  	 formdata.forEach(function(value, key){
  	  var keySpace = key.trim();
      console.log(keySpace);
  	  var splitnamespace = keySpace.split(portletnamespace)[1];
  	  console.log(splitnamespace);
  	 var test = splitnamespace;
	   if (test=="formDate" || test == ""){
		   delete object[test] ;   
	   }else{
		 object[test] = value;
		 console.log(object);
		
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
 
