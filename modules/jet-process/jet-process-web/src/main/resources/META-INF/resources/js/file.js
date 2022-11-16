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
            basicheadText = value.value;
            basicheadValue = value.masterdataId;
            $("#<portlet:namespace/>basicHead").append(new Option(basicheadText,basicheadValue));
            });          
     })
	            });

 	            
         /* get primaryHead data */ 	            
	  $("#<portlet:namespace />basicHead").on('change', function(){
	
			var basicHeadId = $("#<portlet:namespace />basicHead").val();
	       
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
            $("#<portlet:namespace/>primaryHead").append(new Option( primaryHeadText, primaryHeadValue));
            });          
     })
	            });   
	        });
	            
	            
	           /* get secondary head data */
	     
	  $("#<portlet:namespace />primaryHead").on('change', function(){
	 var primaryHeadId = $("#<portlet:namespace />primaryHead").val();
	        
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
            $("#<portlet:namespace/>secondaryHead").append(new Option( secondaryHeadText ,  secondaryHeadValue));
            });          
     })
	            });   
	       
	       
	       });
	           
	/* get tertiary head data */       
	  $("#<portlet:namespace />secondaryHead").on('change', function(){
			 var secondarHeadId = $("#<portlet:namespace />secondaryHead").val();
			   
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
            $("#<portlet:namespace/>tertiaryHead").append(new Option( secondaryHeadText ,  secondaryHeadValue));
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
            $("#<portlet:namespace/>category").append(new Option(categoryText,categoryValue));
            });          
     })
	            });
	            
/* get subcategory data */
	       $("#<portlet:namespace />category").on('change', function(){
	var categoryId = $("#<portlet:namespace />category").val();
	
	
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
            $("#<portlet:namespace />subCategory").append(new Option( subCategoryText, subCategoryValue));
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
            $("#<portlet:namespace/>fileCode").append(new Option(fileCodeText,fileCodeValue));
            });          
     });
	            });
	        
	        
	        
</aui:script>
