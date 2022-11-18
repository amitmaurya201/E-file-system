<aui:script use= "aui-base">
	
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
			  pdfurl = response.description;
			  console.log(response.id);
			  console.log(response.description);
             $("#<portlet:namespace />tempFileId").val(response.id);
             var embed = $('<embed id="pdfurl" type="application/pdf"  width="450" height="450">');
             embed.attr('src',pdfurl);
             $('#targetDiv').append(embed);
		  }).fail(function(e) {
		     console.log(e);
		  }); 
	 }
});

/* getByReceiptId */
var receiptId = $("#<portlet:namespace />receiptId").val();
AUI().use('aui-base', function(A){
Liferay.Service(
		'/jet_process.receipt/get-receipt-by-receipt-id',
		{
		    receiptId: receiptId
		},
		function(obj) {
		    console.log(obj);
		});
});

/* userPostId */
$("#value").change(function (e) {
  var userPostId=($("#value").val());
  console.log('--  '+ userPostId);
  $("#<portlet:namespace />userPostId").val(userPostId);
});

/* create receipt */

$("#<portlet:namespace />generate").on('click', function(e){
	 e.preventDefault();
	 	var typeId = $('#<portlet:namespace />typeId').val();
		var deliveryModeId =$('#<portlet:namespace />deliveryModeId').val();
		var receivedOn =$('#<portlet:namespace />receivedOn').val();
		var letterDate = $('#<portlet:namespace />letterDate').val();
		var referenceNumber = $('#<portlet:namespace />referenceNumber').val();
		var modeNumber = $('#<portlet:namespace />modeNumber').val();
		var organizationId = $('#<portlet:namespace />organizationId').val();
		var subOrganizationId = $('#<portlet:namespace />subOrganizationId').val();
		var name = $('#<portlet:namespace />name').val();
		var designation = $('#<portlet:namespace />designation').val();
		var mobile = $('#<portlet:namespace />mobile').val();
		var email = $('#<portlet:namespace />email').val();
		var address = $('#<portlet:namespace />address').val();
		var countryId =$('#<portlet:namespace />countryId').val();
		var stateId = $('#<portlet:namespace />stateId').val();
		var city = $('#<portlet:namespace />city').val();
		var pinCode = $('#<portlet:namespace />pinCode').val();
		var receiptCategoryId = $('#<portlet:namespace />receiptCategoryId').val();
		var receiptSubCategoryId = $('#<portlet:namespace />receiptSubCategoryId').val();
		var subject = $('#<portlet:namespace />subject').val();
		var remarks = $('#<portlet:namespace />remarks').val();
		var userPostId = $('#<portlet:namespace />userPostId').val();
		var tempFileId = $('#<portlet:namespace />tempFileId').val();
		console.log("receiptCategoryId"+receiptCategoryId);
	 
	 
	 
	 var receiptFormData = new FormData();
	 receiptFormData.append('address',address );
	 receiptFormData.append('city', city); 
	 receiptFormData.append('countryId',countryId );
	 receiptFormData.append('deliveryModeId',deliveryModeId);
	 receiptFormData.append('designation',designation);
	 receiptFormData.append('email',email);
	 receiptFormData.append('groupId',groupId);
	 receiptFormData.append('letterDate',letterDate);
	 receiptFormData.append('mobile',mobile);
	 receiptFormData.append('modeNumber',modeNumber);
	 receiptFormData.append('name',name);
	 receiptFormData.append('organizationId',organizationId );
	 receiptFormData.append('pinCode',pinCode);
	 receiptFormData.append('receiptCategoryId',receiptCategoryId);
	 receiptFormData.append('receiptSubCategoryId',receiptSubCategoryId);
	 receiptFormData.append('receivedOn',receivedOn );
	 receiptFormData.append('referenceNumber',referenceNumber);
	 receiptFormData.append('remarks',remarks );
	 receiptFormData.append('stateId',stateId);
	 receiptFormData.append('subOrganizationId',subOrganizationId);
	 receiptFormData.append('subject', subject);
	 receiptFormData.append('tempfileId', tempFileId );
	 receiptFormData.append('typeId',typeId);
	 receiptFormData.append('userPostId',userPostId );
	 
	 
	 var object = {};
	 receiptFormData.forEach(function(value, key){
	    
		 object[key] = value;
	 });
	 var json = JSON.stringify(object);
	 console.log(json);
	 $.ajax({
		    type: "POST",
		    url: "${setURL}/o/jet-process-rs/v1.0/createReceipt?p_auth=" + Liferay.authToken,
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
