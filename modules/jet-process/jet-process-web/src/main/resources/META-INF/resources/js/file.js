<aui:script use= "aui-base">

// jquery for getting userpost id from theme 
$("#value").change(function(e){
    console.log("Jquery ......"+$("#value").val());
    userPostId = ($("#value").val());
  $('#<portlet:namespace/>userPostId').val(userPostId);

 });
    

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
	                   
	         $("#<portlet:namespace />add-docfile").on('click', function(e){
	        	 e.preventDefault();
	        	/* var myForm = document.getElementById("<portlet:namespace />filecreate");
	        	 cosole.log(myForm);*/
	        	 var subject  = $('#<portlet:namespace/>subject').val();
	        	 var  userPostId = $('#<portlet:namespace/>userPostId').val()
	        	 console.log(subject);
	        	 console.log("userPostId"+userPostId);
	        	 var basicHeadId  = $('#<portlet:namespace/>basicHeadId').val();
	        	 var primaryHeadId  = $('#<portlet:namespace/>primaryHeadId').val();
	        	 var secondaryHeadId  = $('#<portlet:namespace/>secondaryHeadId').val();
	        	 var tertiaryHeadId  = $('#<portlet:namespace/>tertiaryHeadId').val();
	        	 var nature  = $('#<portlet:namespace/>nature').val();
	        	 var type  = $('#<portlet:namespace/>type').val();
	        	 var categoryId  = $('#<portlet:namespace/>categoryId').val();
	        	 var subCategoryId  = $('#<portlet:namespace/>subCategoryId').val();
	        	 var fileCodeId  = $('#<portlet:namespace/>fileCodeId').val();
	        	 var year = $('#<portlet:namespace/>year').val();
	        	 var remarks  = $('#<portlet:namespace/>remarks').val();
	        	 var reference = $('#<portlet:namespace/>reference').val();
	        	
	        	 console.log("----basichead"+basicHeadId+"priary-------"+primaryHeadId+"---second----"+secondaryHeadId+"--tertiary---"+tertiaryHeadId+"---nature--"+nature+"---categoryId---"+categoryId+"---subCategoryId---"+subCategoryId+"---fileCodeId---"+fileCodeId+"---year--"+year+"--remarks---"+remarks+"--reference--"+reference+"---type-"+type);
	        	 
	        	 var formdata = new FormData();
	        	 formdata.append('subject',subject);
	        	 formdata.append('primaryHeadId',primaryHeadId);
	        	 formdata.append('basicHeadId',basicHeadId);
	        	 formdata.append('secondaryHeadId',secondaryHeadId);
	        	 formdata.append('tertiaryHeadId',tertiaryHeadId);
	        	 formdata.append('nature',nature);
	        	 formdata.append('categoryId',categoryId);
	        	 formdata.append('subCategoryId',subCategoryId);
	        	 formdata.append('fileCodeId',fileCodeId);
	        	 formdata.append('year',year);
	        	 formdata.append('remarks',remarks);
	        	 formdata.append('reference',reference);
	        	 formdata.append('type',type);
	        	 formdata.append('userPostId',userPostId);
	        	 
	        	 var object = {};
	        	 formdata.forEach(function(value, key){
	        	    
	        		 object[key] = value;
	        	 });
	        	 var json = JSON.stringify(object);
	        	/* formdata.append('nature','natureValue');*/
	        	/* console.log(formdata.get("BasicHeadId"));*/
	        	 $.ajax({
	        		    type: "POST",
	        		    url: "${setURL}/o/jet-process-rs/v1.0/createFile?p_auth=" + Liferay.authToken,
	        		    data: json,
	        		    dataType: 'json',
	        		    cache : false,
	        		    processData: false,
	        	        contentType : 'application/json'
	        		  }).done(function(response) {
	        			  console.log(response);
	        			
	                    
	        	 })
	        });
	        
	     	
	         
	         
	         
</aui:script>
