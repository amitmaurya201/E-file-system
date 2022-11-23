<aui:script use= "aui-base">
// getting current userPostId .....................

var tempFileId=0;

/* masterdata call */
AUI().use('aui-base', function(A){
	 Liferay.Service(
			 '/masterdata.masterdata/get-receipt-category-masterdata',
			 function(response) {
			     $.each(response, function(key, value) {
						optionText = value.value;
						optionValue = value.masterdataId;
						$("#<portlet:namespace />receiptCategoryId").append(new Option(optionText,optionValue));
			});
	});
});	

/* receipt subcategory masterdata */
$("#<portlet:namespace />receiptCategoryId").on('change', function(){
	var receiptCategoryId = $("#<portlet:namespace />receiptCategoryId").val();
		console.log(receiptCategoryId);
		 AUI().use('aui-base', function(A){
			 $("#<portlet:namespace />receiptSubCategoryId").empty();
			 Liferay.Service(
					 '/masterdata.masterdata/get-receipt-sub-category-masterdata',
					 {
					     receiptCategoryId: receiptCategoryId
					 },
					 function(response) {
					     $.each(response, function(key, value) {
					     optionText = value.value;
					     optionValue = value.masterdataId;
					     $("#<portlet:namespace />receiptSubCategoryId").append(new Option(optionText,optionValue));
					 });
		 });
	});
});
/* type masterdata */
AUI().use('aui-base', function(A){
	 Liferay.Service(
			 '/masterdata.masterdata/get-type-masterdata',
			 function(response) {
			     $.each(response, function(key, value) {
						optionText = value.value;
						optionValue = value.masterdataId;
						$("#<portlet:namespace />typeId").append(new Option(optionText,optionValue));
			});
	});
});

/* delivery mode masterdata */
AUI().use('aui-base', function(A){
	 Liferay.Service(
			 '/masterdata.masterdata/get-delivery-mode-masterdata',
			 function(response) {
			     $.each(response, function(key, value) {
						optionText = value.value;
						optionValue = value.masterdataId;
						$("#<portlet:namespace />deliveryModeId").append(new Option(optionText,optionValue));

			 });
	 });
});

/* Country Masterdata */
AUI().use('aui-base', function(A){
	 Liferay.Service(
			 '/masterdata.masterdata/get-countries-masterdata',
			 function(response) {
			     $.each(response, function(key, value) {
						optionText = value.value;
						optionValue = value.masterdataId;
						$("#<portlet:namespace />countryId").append(new Option(optionText,optionValue));

			});
	});
});

/* State Masterdata */
$("#<portlet:namespace />countryId").on('change', function(){
	var countryId = $("#<portlet:namespace />countryId").val();
		console.log(countryId);
		 AUI().use('aui-base', function(A){
			 $("#<portlet:namespace />stateId").empty();
			 Liferay.Service(
					 '/masterdata.masterdata/get-states-masterdata',
					 {
						 countryId: countryId
					 },
					 function(response) {
					     $.each(response, function(key, value) {
					     optionText = value.value;
					     optionValue = value.masterdataId;
					     $("#<portlet:namespace />stateId").append(new Option(optionText,optionValue));
					 });
		 });

	});
});

/* Organization Masterdata */
AUI().use('aui-base', function(A){
	 Liferay.Service(
			 '/masterdata.masterdata/get-organization-masterdata',
			 function(response) {
			     $.each(response, function(key, value) {
						optionText = value.value;
						optionValue = value.masterdataId;
						$("#<portlet:namespace />organizationId").append(new Option(optionText,optionValue));
			});
	});
});

/* Suborganization Masterdata */
$("#<portlet:namespace />organizationId").on('change', function(){
	var organizationId = $("#<portlet:namespace />organizationId").val();
		console.log(organizationId);
		 AUI().use('aui-base', function(A){
			 $("#<portlet:namespace />subOrganizationId").empty();
			 Liferay.Service(
					 '/masterdata.masterdata/get-sub-organization-masterdata',
					 {
						 organizationId: organizationId
					 },
					 function(response) {
					     $.each(response, function(key, value) {
					     optionText = value.value;
					     optionValue = value.masterdataId;
					     if(response !=null){
					    	 
					    	 $("#<portlet:namespace />subOrganizationId").append(new Option(optionText,optionValue));
					     }
					     });
					 });
		 	});
});
var groupId = Liferay.ThemeDisplay.getScopeGroupId();
/* file upload */	
$("#<portlet:namespace />document").on('change', function(){
	 var myFile = $("#<portlet:namespace />document").prop("files")[0];
	 var dmFileId=0;
	 console.log(myFile);
     console.log(groupId);
     var formData = new FormData();
   	 formData.append('document', myFile);
	 formData.append('groupId', groupId);
	 var extension = $("#<portlet:namespace />document").val().split('.').pop().toLowerCase();
	 if(myFile.size > 26,214,400 && extension == 'pdf'){ 
	 $.ajax({
		    type: "POST",
		    url: "${setURL}/o/jet-process-docs/v1.0/tempFileUpload?p_auth=" + Liferay.authToken,
		    data: formData,
		    cache : false,
		    processData: false,
	        contentType : false,
		  }).done(function(response) {
			  viewPdfUrl=response.description;
			  tempFileId=response.id;
			  console.log(viewPdfUrl);
			  console.log(tempFileId);
             var embed = $('<embed id="pdfurl" type="application/pdf"  width="100%" height="450">');
             embed.attr('src',viewPdfUrl);
             $('#targetDiv').append(embed);
		  }).fail(function(e) {
		     console.log(e);
		  }); 
	 }
});

/* create receipt */


$("#<portlet:namespace />generate").on('click', function(e){
	 e.preventDefault();
	 var formObj= $('#<portlet:namespace/>receiptForm')[0];
     var jsonData = bindFormDataJson(formObj);
     console.log(jsonData);
     console.log(tempFileId);
     var userPostId=  getUserPostId();
     jsonData["userPostId"] = userPostId;
     jsonData["tempFileId"] = tempFileId; 
    
     var jsonObj = JSON.stringify(jsonData);  
	 $.ajax({
		    type: "POST",
		    url: "${setURL}/o/jet-process-rs/v1.0/createReceipt?p_auth=" + Liferay.authToken,
		    data: jsonObj,
		    dataType: 'json',
		    cache : false,
		    processData: false,
	        contentType : 'application/json'
		  }).done(function(response) {
			  console.log(response);
			
           
	 })
	 
	 
});



</aui:script>
