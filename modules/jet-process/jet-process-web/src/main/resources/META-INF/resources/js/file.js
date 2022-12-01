


<aui:script use= "aui-base">

     /* get current year */
	    var currentTime = new Date();
		var year = currentTime.getFullYear();
     	var currentYear = document.getElementById("<portlet:namespace/>year").value=year;
     	
      /* get basicHead data */
	 AUI().use('aui-base', function(A){
	        Liferay.Service(
	        		`/masterdata.masterdata/get-basic-head-masterdata`,
                function(obj) {
               console.log(obj);
            $.each(obj,function(key,value){
            	
            	console.log(key);
            basicheadText = value.value;
            basicheadValue = value.masterdataId;
            $("#<portlet:namespace/>basicHeadId").append(new Option(basicheadText,basicheadValue));
            });          
     })
	            });

 	            
         /* get primaryHead data */ 	            
	  $("#<portlet:namespace />basicHeadId").on('change', function(){
	
			var basicHeadId = $("#<portlet:namespace />basicHeadId").val();
	       
	       AUI().use('aui-base', function(A){
	       Liferay.Service(
	        		`/masterdata.masterdata/get-primary-head-masterdata`,
	        		{
	        			basicHeadId: basicHeadId
	        		},
                function(obj) {
               console.log(obj);
            $.each(obj,function(key,value){
            primaryHeadText = value.value;
            primaryHeadValue = value.masterdataId;
            $("#<portlet:namespace/>primaryHeadId").append(new Option( primaryHeadText, primaryHeadValue));
            });          
     })
	            });   
	        });
	            
	            
	           /* get secondary head data */
	     
	  $("#<portlet:namespace />primaryHeadId").on('change', function(){
	 var primaryHeadId = $("#<portlet:namespace />primaryHeadId").val();
	        
	      AUI().use('aui-base', function(A){
	       Liferay.Service(
	        		`/masterdata.masterdata/get-secondary-head-masterdata`,
	        		{
	        		 primaryHeadId: primaryHeadId
	        		},
                function(obj) {
               
               console.log(obj);
            $.each(obj,function(key,value){
           secondaryHeadText = value.value;
           secondaryHeadValue = value.masterdataId;
            $("#<portlet:namespace/>secondaryHeadId").append(new Option( secondaryHeadText ,  secondaryHeadValue));
            });          
     })
	            });   
	       
	       
	       });
	           
	/* get tertiary head data */       
	  $("#<portlet:namespace />secondaryHeadId").on('change', function(){
			 var secondarHeadId = $("#<portlet:namespace />secondaryHeadId").val();
			 console.log(secondarHeadId);
			   
	      AUI().use('aui-base', function(A){
	       Liferay.Service(
	        		`/masterdata.masterdata/get-teritary-head-masterdata`,
	        		{
	        		 secondaryHeadId: secondarHeadId
	        		},
                function(obj) {
               console.log(obj);
            $.each(obj,function(key,value){
           secondaryHeadText = value.value;
           secondaryHeadValue = value.masterdataId;
            $("#<portlet:namespace/>tertiaryHeadId").append(new Option( secondaryHeadText ,  secondaryHeadValue));
            });          
     })
	            });   
	      
	       });
/* get category data */
	       AUI().use('aui-base', function(A){
	        Liferay.Service(
	        		`/masterdata.masterdata/get-category-masterdata`,
                function(obj) {
               console.log(obj);
            $.each(obj,function(key,value){
           categoryText = value.value;
           categoryValue = value.masterdataId;
            $("#<portlet:namespace/>categoryId").append(new Option(categoryText,categoryValue));
            });          
     })
	            });
	            
/* get subcategory data */
	       $("#<portlet:namespace />categoryId").on('change', function(){
	var categoryId = $("#<portlet:namespace />categoryId").val();
	
	
	  AUI().use('aui-base', function(A){
	       Liferay.Service(
	        		`/masterdata.masterdata/get-sub-category-masterdata`,
	        		{
	        		categoryId: categoryId
	        		},
                function(obj) {
               console.log(obj);
            $.each(obj,function(key,value){
           subCategoryText = value.value;
            subCategoryValue = value.masterdataId;
            $("#<portlet:namespace />subCategoryId").append(new Option( subCategoryText, subCategoryValue));
            });          
     })
 });   
	});
	        
	        /* get filecode data */
	         AUI().use('aui-base', function(A){
	        Liferay.Service(
	        		`/masterdata.masterdata/get-file-code-masterdata`,
                function(obj) {
               console.log(obj);
            $.each(obj,function(key,value){
            fileCodeText = value.value;
            fileCodeValue = value.masterdataId;
            $("#<portlet:namespace/>fileCodeId").append(new Option(fileCodeText,fileCodeValue));
            });          
     });
});
	
	        /*   Add docFile   */
	                          
	$("#<portlet:namespace />add-docfile").on('click', function(e){
	        	 e.preventDefault();
	        	 var formObj= $('#<portlet:namespace/>formId')[0];
	             var jsonData = bindFormDataJson(formObj);
	             var userPostId=  getUserPostId();
	             jsonData["userPostId"] = userPostId;
	           
	          var jsonObj = JSON.stringify(jsonData);  
	        	 $.ajax({
	        		    type: "POST",
	        		    url: "${setURL}/o/jet-process-rs/v1.0/createFile?p_auth=" + Liferay.authToken,
	        		    data: jsonObj,
	        		    dataType: 'json',
	        		    cache : false,
	        		    processData: false,
	        	        contentType : 'application/json'
	        		  }).done(function(response) {
	        			  console.log(response);
	        			  swal( {
	                          title: "successfull !",
	                          text: `You Have successfully created Your File! And Your File Number is ${response.fileNumber} `,
	                          icon: "success",
	                          button: "ok"
	                      }).then(function() {
	                    	    window.location.href = "<%=createdFileList.toString()%>";
	                      });
	    		 })
	    		 .fail(function(error){
	    			 swal({  
	    				  title: " Oops!",  
	    				  text: " Something went wrong, you should choose again!",  
	    				  icon: "error",  
	    				});  
	    		 })
	        	
	        });
	             
	
	
	/* update docFile */
	
	$("#<portlet:namespace />update-docfile").on('click', function(e){
   	 e.preventDefault();
   	 var formObj= $('#<portlet:namespace/>updateformId')[0];
   	 console.log("formObj"+formObj);
        var jsonData = bindFormDataJson(formObj);
        console.log("jsonData"+jsonData);
        var userPostId=  getUserPostId();
        console.log("userPostId"+userPostId);
        jsonData["userPostId"] = userPostId;
     var jsonObj = JSON.stringify(jsonData);  
     console.log("jsonObj-->"+jsonObj);
   	 $.ajax({
   		    type: 'PUT',
   		    url: "${setURL}/o/jet-process-rs/v1.0/updateDocFile?p_auth=" + Liferay.authToken,
   		    data: jsonObj,
   		    dataType: 'json',
   		    cache : false,
   		    processData: false,
   	        contentType : 'application/json'
   		  }).done(function(response) {
   			  console.log(response);
   			  alert("File Updated Successfully For File Number "+response.fileNumber);
   			
   	 })
   });

</aui:script>