<aui:script use= "aui-base">
	
	/* get the receipt id  */
/* getByReceiptId */
var receiptId = $("#<portlet:namespace />receiptId").val();

$.ajax({
	type: "GET",
    url: "${setURL}/o/jet-process-rs/v1.0/receiptId/"+receiptId+"/?p_auth=" + Liferay.authToken,
	success: function(data){
	    console.log(data.id);
//	    $("#<portlet:namespace />typeId").val(data.typeId);
//	    $("#<portlet:namespace />deliveryModeId").val(data.deliveryModeId);
	    $("#<portlet:namespace />receivedOn").val(data.receivedOn);
	    $("#<portlet:namespace />letterDate").val(data.letterDate);
	    $("#<portlet:namespace />referenceNumber").val(data.referenceNumber);
	    $("#<portlet:namespace />modeNumber").val(data.modeNumber);
//	    $("#<portlet:namespace />organizationId").val(data.organizationId);
//	    $("#<portlet:namespace />subOrganizationId").val(data.subOrganizationId);
	    $("#<portlet:namespace />name").val(data.name);
	    $("#<portlet:namespace />designation").val(data.designation);
	    $("#<portlet:namespace />mobile").val(data.mobile);
	    $("#<portlet:namespace />email").val(data.email);
	    $("#<portlet:namespace />address").val(data.address);
//	    $("#<portlet:namespace />countryId").val(data.countryId);
//	    $("#<portlet:namespace />stateId").val(data.stateId);
	    $("#<portlet:namespace />city").val(data.city);
	    $("#<portlet:namespace />pinCode").val(data.pinCode);
//	    $("#<portlet:namespace />receiptCategoryId").val(data.receiptCategoryId);
//	    $("#<portlet:namespace />receiptSubCategoryId").val(data.receiptSubCategoryId);
	    $("#<portlet:namespace />subject").val(data.subject);
	    $("#<portlet:namespace />remarks").val(data.remarks);
	    
	    
//	    $("#<portlet:namespace />receiptNumber").val(data.receiptNumber);
	    
	}
});











</aui:script>