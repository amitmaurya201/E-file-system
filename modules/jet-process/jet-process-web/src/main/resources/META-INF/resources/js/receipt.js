<aui:script use= "aui-base">

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
		 AUI().use('aui-base', function(A){
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
		 AUI().use('aui-base', function(A){
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
		 AUI().use('aui-base', function(A){
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
var receiptId= $('#<portlet:namespace/>receiptId').val();
var viewPdf='<%=request.getAttribute("viewPdfUrl")%>';

/* for if nature is elcetronic*/
var errorLabel= false;
$("#<portlet:namespace />nature").on('change',mySeletedNature);
	function mySeletedNature(){
	 var nature= $('#<portlet:namespace/>nature').val(); 
     if(nature == 'Electronic' && tempFileId == 0 ){
    	 if(($("#error").length) == 0){
    		 $('.dropzone-wrapper').append('<p id="error" class="text-danger">This field is required.<p>');
    		 errorLabel=true;
    		 return true;
    	 }
    	 return true;
     }else{
    	 errorLabel=false;    		
    	 $("#error ").remove();
     }
}

/* create receipt */
$("#<portlet:namespace />receiptForm").on('submit', function(e){
	 e.preventDefault();
	 var formObj= $('#<portlet:namespace/>receiptForm')[0];
     var jsonData = bindFormDataJson(formObj);
     var userPostId=  getUserPostId();
     jsonData["userPostId"] = userPostId;
     if(!mySeletedNature()){
    	 
     jsonData["tempFileId"] = tempFileId; 
     jsonData["groupId"] = groupId; 
     var jsonObj = JSON.stringify(jsonData);  
		 $.ajax({
			    type: "POST",
			    url: "${setURL}/o/jet-process-rs/v1.0/createReceipt?p_auth=" + Liferay.authToken,
			    data: jsonObj,
			    dataType: 'json',
			    cache : false,
			    processData: false,
		        contentType : 'application/json'
		 }) .done(function(response) {
			  console.log("response : - "+response);
			  var receiptNumber =response.receiptNumber;
			if(receiptNumber!=null){
			  swal( {
                 title: "successfull !",
                 text: `You Have successfully created Your Receipt!And Your Receipt Number is `+receiptNumber,
                 icon: "success",
                 button: "ok"
             }).then(function() {
           	    window.location.href = '<%= createdListReceipt.toString() %>';
             });
			}else{
				swal({  
					  title: " Oops!",  
					  text: " Something went wrong, you should choose again!",  
					  icon: "error",  
					}); 
				
			}
	 }).fail(function(error){
			 swal({  
				  title: " Oops!",  
				  text: " Something went wrong, you should choose again!",  
				  icon: "error",  
				});  
		 })
     }
});

/* update receipt*/
$("#<portlet:namespace />receiptForm").on('submit', function(e){
	 e.preventDefault();
	 var dmFileId = $('#<portlet:namespace/>dmFileId').val();
	 var formObj= $('#<portlet:namespace/>receiptForm')[0];
    var jsonData = bindFormDataJson(formObj);
    var userPostId= getUserPostId();
    jsonData["userPostId"] = userPostId;
    if(tempFileId!=0){
    	 jsonData["tempFileId"] = tempFileId; 
    }
    else{
    	jsonData["tempFileId"] = 0;
    }
    jsonData["groupId"] = groupId; 
    var jsonObj = JSON.stringify(jsonData);  
	 if(receiptId != null){
		  $.ajax({
			    type: "PUT",
			    url: "${setURL}/o/jet-process-rs/v1.0/updateReceipt?p_auth=" + Liferay.authToken,
			    data: jsonObj,
			    dataType: 'json',
			    cache : false,
			    processData: false,
		        contentType : 'application/json'
			  }).done(function(response) {
				  console.log("------------------------33-------------------------");
				  console.log(response);
				  swal( {
                      title: "successfull !",
                      text: `You Have successfully created Your Receipt! `,
                      icon: "success",
                      button: "ok"
                  })

		 })
		 .fail(function(error){
			 swal({  
				  title: " Oops!",  
				  text: " Something went wrong, you should choose again!",  
				  icon: "error",  
				});  
		 })
	 }
});


$('#removeFileUpload').on('click',function(e){	
	e.preventDefault();
 $('.dropzone-wrapper').css("display", "block");
 $('#removeFileUpload').css("display", "none");
	console.log("if ------>>>>>");
	$("#editpdfurl").remove();

	
});




$('#doc-select-btn').on('click',function(){	
		 $("#doc-input").trigger('click');
	});


$('#doc-input').on('change',function(e){	
	console.log("doc input field...")
	var file = e.target.files[0];
	console.log(file.size);
	if(file.size > 26,214,400){
	displayPreview(file);
	}else{
		 $('.dropzone-wrapper').append('<p class="text-danger">File size could be max then 25MB.<p>');
	}
});

	$('.dropzone-wrapper').on('dragover', function(e) {
		console.log("inside drag area..")
		e.preventDefault();
		e.stopPropagation();
	});

	$('.dropzone-wrapper').on('dragleave', function(e) {
		console.log("leave drag area..")
	});
	
	$('.dropzone-wrapper').on('drop', function(e) {
		
	  e.preventDefault();
	  e.stopPropagation();
	  
	  
	  console.log("drop drag area.."+e.originalEvent.dataTransfer.files[0].name)
		displayPreview(e.originalEvent.dataTransfer.files[0]);
	});
	
function displayPreview(file){
	var embed = $('<embed id="pdfurl" type="application/pdf"  width="100%" height="450">');
	var myFile = file;
	 var dmFileId=0;
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
			  tempFileId=response.id;
            	 viewPdfUrl=response.description;
            	var parent = $('#editpdfurl').parent();
            	if(parent!=undefined){
            		$("#editpdfurl").remove();
            		 var embed = $('<embed id="editpdfurl" type="application/pdf"  width="100%" height="450">');
            		 embed.attr('src',viewPdfUrl);
 	            	$('#targetDiv').append(embed);
            	}
            	 embed.attr('src',viewPdfUrl);
            	 $('.dropzone-wrapper').css("display", "none");
            	 $('#removeFileUpload').css("display", "block");
            	$('#targetDiv').append(embed);
            	
		  }).fail(function(e) {
		     console.log(e);
		  }); 
}





</aui:script>
