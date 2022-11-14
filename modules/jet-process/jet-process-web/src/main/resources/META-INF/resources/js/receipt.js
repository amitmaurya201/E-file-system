<!-- 	masterdata call -->
	<aui:script>
	 AUI().use('aui-base', function(A){
	        Liferay.Service(
	        		'/masterdata.masterdata/get-receipt-category-masterdata',
	            function(obj) {
	                try{
	                	console.log(obj);
	                }catch(e){
	                	console.log("error");
	                	}
	                }
	            }
</aui:script>
<aui:script>
$("#<portlet:namespace />receiptCategoryId").on('change', function(){
	
	var receiptCategoryId = $("#<portlet:namespace />receiptCategoryId").val();
		console.log(receiptCategoryId);
		$.ajax({
				 type : "GET",
				 url : "${setURL}/api/jsonws/masterdata.masterdata/get-receipt-sub-category-masterdata/receipt-category-id/"+receiptCategoryId+"?p_auth="+ Liferay.authToken,
				cache : false,
				processData : false,
				contentType : false,
			}).done(function(response) {
				console.log("tresatsrta");
				console.log(response);
				$.each(response, function(key, value) {
					optionText = value.value;
					optionValue = value.masterdataId;
					$("#<portlet:namespace />receiptSubCategoryId").append(new Option(optionText,optionValue));

					});
				}).fail(function(e) {
							alert(" ReceiptSubCategoryList is not available for this receiptCategory!!");
						});

	});
</aui:script>	
	<!-- file upload  -->
<aui:script>
$("#<portlet:namespace />document").on('change', function(){
	 var myFile = $("#<portlet:namespace />document").prop("files")[0];
	 var dmFileId=0;
	 console.log(myFile);
     var groupId = Liferay.ThemeDisplay.getScopeGroupId();
     console.log(groupId);
     var formData = new FormData();
   	 formData.append('document', myFile);
	 formData.append('groupId', groupId);
	 $.ajax({
		    type: "POST",
		    url: "${setURL}/o/jet-process-docs/v1.0/tempFileUpload?p_auth=" + Liferay.authToken,
		    data: formData,
		    cache : false,
		    processData: false,
	        contentType : false,
		  }).done(function(response) {
			  console.log(response.id);
             $("#<portlet:namespace />tempFileId").val(response.id);
			
		  }).fail(function(e) {
		     console.log(e);
		  }); 
	
});
</aui:script>
