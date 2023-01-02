<aui:script use= "aui-base">

var tempFileId=0;

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


$("#<portlet:namespace />receiptCategoryId").on('change', function(){
	var receiptCategoryId = $("#<portlet:namespace />receiptCategoryId").val();
    $("#<portlet:namespace />receiptSubCategoryId").empty();
    $("#<portlet:namespace />receiptSubCategoryId").append(new Option("Select",0));

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

$('document').ready(function(e){
	var editCountryId =$("#<portlet:namespace />countryId").val();
	/* $("#<portlet:namespace />countryId").append(new Option("Select",0));*/
	AUI().use('aui-base', function(A){
		 Liferay.Service(
				 '/masterdata.masterdata/get-countries-masterdata',
				 function(response) {
				     $.each(response, function(key, value) {
							optionText = value.value;
							optionValue = value.masterdataId;
							 if(optionValue==editCountryId){
								
						    	 $('#<portlet:namespace />countryId').append(new Option(optionText,optionValue));
						 		
						    	 $("select option").each(function(){
						    		  if ($(this).text() == optionText)
						    		    $(this).attr("selected","selected");
						    		});  	
						    	 
						     		}
						     else{
						    	
						     $("#<portlet:namespace />countryId").append(new Option(optionText,optionValue));
						     }

				});
		});
	});
	
})

$("#<portlet:namespace />countryId").on('change', function(){
	var countryId = $("#<portlet:namespace />countryId").val();
    $("#<portlet:namespace />stateId").empty();
    $("#<portlet:namespace />stateId").append(new Option("Select",0));

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


$("#<portlet:namespace />organizationId").on('change', function(){
	var organizationId = $("#<portlet:namespace />organizationId").val();
    $("#<portlet:namespace />subOrganizationId").empty();
    $("#<portlet:namespace />subOrganizationId").append(new Option("Select",0));

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

/* if nature is elcetronic*/
var errorLabel= false;
$("#<portlet:namespace />nature").on('change',mySeletedNature);
	function mySeletedNature(){
	 var nature= $('#<portlet:namespace/>nature').val(); 
	 console.log('--   '+nature);
	 let url='${receipt.viewPdfUrl}';
	 
     if(nature == 'Electronic' && tempFileId == 0 ){
    	 if(($("#error").length) == 0){
    		 if(url != '' || url != null || url != undefined ){
    			 errorLabel=false;
        		 return false;
    			 
    		 }
    		 else{
    		 $('.dropzone-wrapper').append('<p id="error" class="text-danger">This field is required.<p>');
    		 errorLabel=true;
    		 return true;
    		 }
    	 }
    	 
    	 return true;
     }else{
    	 errorLabel=false;    		
    	 $("#error ").remove();
     }
}
	// for validation 
	function validateForm(receiptForm) {
		var liferayForm = Liferay.Form.get(receiptForm);
	    if (liferayForm) {
	        var validator = liferayForm.formValidator;
	        validator.validate();
	        var hasErrors = validator.hasErrors();
	        if (hasErrors) {
	        	validator.focusInvalidField();
	                return false;
	            }
	   	}
	    return true;
	}
	
$("#<portlet:namespace />generate").on('click', function(e){
	 e.preventDefault();
	 var formObj= $('#<portlet:namespace/>receiptForm')[0];
     var jsonData = bindFormDataJson(formObj);
     var userPostId=  getUserPostId();
     jsonData["userPostId"] = userPostId;
     jsonData["tempFileId"] = tempFileId; 
     jsonData["groupId"] = groupId; 
     var jsonObj = JSON.stringify(jsonData);  
     if(validateForm('<portlet:namespace/>receiptForm')){
    	 if(!mySeletedNature()){
		 $.ajax({
			    type: "POST",
			    url: "${setURL}/o/jet-process-rs/v1.0/createReceipt?p_auth=" + Liferay.authToken,
			    data: jsonObj,
			    dataType: 'json',
			    cache : false,
			    processData: false,
		        contentType : 'application/json'
		 }) .done(function(response) {
			  var receiptNumber =response.receiptNumber;
			  swal( {
                 title: "Successfull!",
                 text: `You have successfully created your receipt! and your receipt number is `+receiptNumber,
                 icon: "success",
                 button: "Ok"
             }).then(function() {
           	    window.location.href = '<%= createdListReceipt.toString() %>';
             });
	 }).fail(function(error){
			 swal({  
				  title: " Oops!",  
				  text: " Something went wrong, you should choose again!",  
				  icon: "error",  
				});  
		 })
		}else{
			 return false;
		}
		
     }else{
    	 return false;
     }
});

/* update receipt*/
$("#<portlet:namespace />update").on('click', function(e){
	e.preventDefault();
	var dmFileId = $('#<portlet:namespace/>dmFileId').val();
	console.log("dmFileId"+dmFileId);
	var formObj= $('#<portlet:namespace/>receiptForm')[0];
    var jsonData = bindFormDataJson(formObj);
    var userPostId= getUserPostId();
    jsonData["userPostId"] = userPostId;
    if(tempFileId!=0){
    	console.log("temp not eq 0 .........");
    	 jsonData["tempFileId"] = tempFileId; 
    }
    else{
    	console.log("temp 0 .........");
    	jsonData["tempFileId"] = 0;
    }
    jsonData["groupId"] = groupId; 
    var jsonObj = JSON.stringify(jsonData);  
    if(validateForm('<portlet:namespace/>receiptForm')){
    	console.log("form validate");
    	if(!mySeletedNature()){
    		console.log("myselectednature");
		  $.ajax({
			    type: "PUT",
			    url: "${setURL}/o/jet-process-rs/v1.0/updateReceipt?p_auth=" + Liferay.authToken,
			    data: jsonObj,
			    dataType: 'json',
			    cache : false,
			    processData: false,
		        contentType : 'application/json'
			  }).done(function(response) {
				  console.log(response);
				  swal( {
                      title: "Successfull!",
                      text: `You have successfully update your receipt! `,
                      icon: "success",
                      button: "Ok"
                  })

		 })
		 .fail(function(error){
			 swal({  
				  title: " Oops!",  
				  text: " Something went wrong, you should choose again!",  
				  icon: "error",  
				});  
		 })
    	}else{
    		console.log("=-   ");
	    	return false;
	    }
    }else{
    	return false;
    }
});

$('#removeFileUpload').on('click',function(e){	
	e.preventDefault();
 $('.dropzone-wrapper').css("display", "block");
 $('#removeFileUpload').css("display", "none");
	console.log("if ------>>>>>");
	
	$("#editpdfurl").remove();
	$("#doc-input").val('0');
	
	$(sizeValidation).css('display', 'none'); 
	
});

$('#doc-select-btn').on('click',function(){	
		 $("#doc-input").trigger('click');
	});


$('#doc-input').on('change',function(e){	
	console.log("doc input field...")
	var file = e.target.files[0];
//	displayPreview(file);
	validateSize(file);
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
//		displayPreview(e.originalEvent.dataTransfer.files[0]);
	  validateSize(e.originalEvent.dataTransfer.files[0])
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


function validateSize(file) {
	  const fileSize = file.size ;
	  if (fileSize > 1024*1024* 25) {
	     $(sizeValidation).css('display', 'block'); 
	  } else {
		  displayPreview(file);
	  }
	}

$(document).ready(function(){
	console.log(".................");
	console.log('${receipt.viewPdfUrl}');
	let url='${receipt.viewPdfUrl}';
	if(url == '' || url == null || url == undefined){
		$('.dropzone-wrapper').css('display', 'block');
		/*$(sizeValidation).css('display', 'block');*/
	}
	else{
		$('#editpdfurl').css('display', 'block');
		if($('#editpdfurl').css('display', 'block')){
			$('#removeFileUpload').css('display', 'block');
		}
		
	}
});

$(document).ready(function(e){
	var orgId = '${receipt.organizationId }';
	var subOrgId = '${receipt.subOrganizationId}';
	 $("#<portlet:namespace />subOrganizationId").append(new Option("Select",0));
	 AUI().use('aui-base', function(A){
		 Liferay.Service(
				 '/masterdata.masterdata/get-sub-organization-masterdata',
				 {
					 organizationId: orgId
				 },
				 function(response) {
				     $.each(response, function(key, value) {
				     optionText = value.value;
				     optionValue = value.masterdataId;
				     if(optionValue.toString() === subOrgId){
				    	  $('#<portlet:namespace />subOrganizationId').append(new Option(optionText,optionValue));
		
				    	 $("select option").each(function(){
				    		  if ($(this).text() == optionText)
				    		    $(this).attr("selected","selected");
				    		});  	
				     }
				     else{
				  
				    	 $("#<portlet:namespace />subOrganizationId").append(new Option(optionText,optionValue));
				    	 
				     }
				    
				     });
				 });
	 	});
	
})
$(document).ready(function(e){
	var receiptCategoryId = '${receipt.receiptCategoryId}';
	var receiptSubCategoryId = '${receipt.receiptSubCategoryId}';
	console.log("receiptCategoryId"+receiptCategoryId + "....."+receiptSubCategoryId);
	 $("#<portlet:namespace />receiptSubCategoryId").append(new Option("Select",0));
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
				     if(optionValue==receiptSubCategoryId){
				    	 $('#<portlet:namespace />receiptSubCategoryId').append(new Option(optionText,optionValue));
				 		
				    	 $("select option").each(function(){
				    		  if ($(this).text() == optionText)
				    		    $(this).attr("selected","selected");
				    		});  	
				    	 
				     		}
				     else{
				     $("#<portlet:namespace />receiptSubCategoryId").append(new Option(optionText,optionValue));
				     }
				 });	
	 });
});
});

$(document).ready(function(e){
	var countryId = '${receipt.countryId}';
	var stateId = '${receipt.stateId}';
	console.log("countryId"+countryId + "....."+stateId);
	 $("#<portlet:namespace />stateId").append(new Option("Select",0));
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
				     if(optionValue==stateId){
				    	 $('#<portlet:namespace />stateId').append(new Option(optionText,optionValue));
				 		
				    	 $("select option").each(function(){
				    		  if ($(this).text() == optionText)
				    		    $(this).attr("selected","selected");
				    		});  	
				    	 
				     		}
				     else{
				     $("#<portlet:namespace />stateId").append(new Option(optionText,optionValue));
				     }
				 });	
	 });
});
});

</aui:script>
