<aui:script use= "aui-base">
     /* get current year */
	    var currentTime = new Date();
		var year = currentTime.getFullYear();
        if(document.getElementById("<portlet:namespace/>year")!= null)
        {
            currentYear = document.getElementById("<portlet:namespace/>year").value=year;
        }

     	
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
			$("#<portlet:namespace/>primaryHeadId").empty();
			  $("#<portlet:namespace />primaryHeadId").append(new Option("Choose One",0)); 
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
	 $("#<portlet:namespace/>secondaryHeadId").empty();
	  $("#<portlet:namespace />secondaryHeadId").append(new Option("Choose One",0)); 
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
	 $("#<portlet:namespace/>tertiaryHeadId").empty();
	 $("#<portlet:namespace />tertiaryHeadId").append(new Option("Choose One",0)); 
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
    $("#<portlet:namespace />subCategoryId").empty();
    $("#<portlet:namespace />subCategoryId").append(new Option("Choose One",""));
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
          	var basicHeadId= $('#<portlet:namespace/>basicHeadId').val().length;
        	var primaryHeadId=$('#<portlet:namespace/>primaryHeadId').val().length;
        	var secondaryHeadId=$('#<portlet:namespace/>secondaryHeadId').val().length;
        	var tertiaryHeadId=$('#<portlet:namespace/>tertiaryHeadId').val().length;
        	var fileCodeId=$('#<portlet:namespace/>fileCodeId').val().length;
        	var fileNumber=$('#<portlet:namespace/>fileNumber').val().length;
        	var subject=$('#<portlet:namespace/>subject').val().length;
        	var categoryId=$('#<portlet:namespace/>categoryId').val().length;	
        	 if(basicHeadId!=0 && primaryHeadId!=0 && secondaryHeadId!=0 && tertiaryHeadId!=0 && fileCodeId!=0 && subject!=0 && categoryId !=0 || fileNumber!=0 && categoryId!=0){
        	  
        	 $.ajax({
        		    type: "POST",
        		    url: "${setURL}/o/jet-process-rs/v1.0/createFile?p_auth=" + Liferay.authToken,
        		    data: jsonObj,
        		    dataType: 'json',
        		    cache : false,
        		    processData: false,
        	        contentType : 'application/json'
        		  }).done(function(response, status, xhr) {
        			  console.log("response-->"+response);
        			  console.log(xhr.getResponseHeader("status"));
        			  console.log(xhr.getResponseHeader("result"));
        			  if(xhr.getResponseHeader("status") === "success"){
        			  swal( {
                          title: "Successful!",
                          text: xhr.getResponseHeader("result")+" "+response.fileNumber,
                          icon: "success",
                          button: "Ok"
                      }).then(function() {
                    	    window.location.href = "<%=createdFileList.toString()%>";
                      });
        			  }if(xhr.getResponseHeader("status") === "error"){
        				  swal({  
    	    				  title: " Oops!",  
    	    				  text: xhr.getResponseHeader("result"),  
    	    				  icon: "error",  
    	    				});  	  
        			  }		  
    		 })
    		 .fail(function(error){
    			 swal({  
    				  title: " Oops!",  
    				  text: " Something went wrong, you should choose again!",  
    				  icon: "error",  
    				});  
    		 })
        
        	}else{
        		swal({  
        			title: " Oops!",  
        			  	text: "Required fields should not be empty!",  
        			  	icon: "error",
        		}); 
        		
        	}
        });
             


	
	/* update docFile */
/*Liferay.provide(window,'editFile',function(event) {*/
$("#<portlet:namespace />update-docfile").on('click', function(e){

		event.preventDefault();
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
   			  if(response==null){
   				swal({  
        			title: " Oops!",  
        			  	text: "Required fields should not be empty!",  
        			  	icon: "error",
        		}); 
   				  
   			  }else{
   			  swal( {
                  title: "Successful!",
                  text: `You have successfully updated your file! `,
                  icon: "success",
                  button: "Ok"
              })
   			  }
   	 })
   	 
	});
$(document).ready(function(e){

	var editCategoryId = $('#<portlet:namespace />categoryId').val();
	var sCategoryId = $('#<portlet:namespace />inputSubCategoryId').val();
	console.log("sCategoryId"+sCategoryId);
	 $("#<portlet:namespace />subCategoryId").append(new Option("Select","0"));
	
	  AUI().use('aui-base', function(A){
	       Liferay.Service(
	        		`/masterdata.masterdata/get-sub-category-masterdata`,
	        		{
	        		categoryId: editCategoryId
	        		},
               function(obj) {
              console.log(obj);
           $.each(obj,function(key,value){
          subCategoryText = value.value;
           subCategoryValue = value.masterdataId;
           if(subCategoryValue==sCategoryId){  
        	   $("#<portlet:namespace />subCategoryId").append(new Option( subCategoryText, subCategoryValue));
        	   $("select option").each(function(){
		    		  if ($(this).text() == subCategoryText)
		    		    $(this).attr("selected","selected");
		    		});  
        	   
           }else{
        	
        	   $("#<portlet:namespace />subCategoryId").append(new Option( subCategoryText, subCategoryValue));
        	   
           }
         
           });          
    })
}); 
	
});

</aui:script>
