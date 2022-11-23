<aui:script use= "aui-base">
	
	/* get the receipt id  */
/* getByReceiptId */
var receiptId = $("#<portlet:namespace />receiptId").val();

$.ajax({
	type: "GET",
    url: "${setURL}/o/jet-process-rs/v1.0/receiptId/"+receiptId+"/?p_auth=" + Liferay.authToken,
	success: function(data){
	    console.log(data);
	    $("#<portlet:namespace />typeId").val(data.typevalue);
	    $("#<portlet:namespace />deliveryModeId").val(data.deliverymodevalue);
	    $("#<portlet:namespace />receivedOn").val(data.receivedOn);
	    $("#<portlet:namespace />letterDate").val(data.letterDate);
	    $("#<portlet:namespace />referenceNumber").val(data.referenceNumber);
	    $("#<portlet:namespace />modeNumber").val(data.modeNumber);
	    $("#<portlet:namespace />organizationId").val(data.organizationvalue);
	    $("#<portlet:namespace />subOrganizationId").val(data.suborganizationvalue);
	    $("#<portlet:namespace />name").val(data.name);
	    $("#<portlet:namespace />designation").val(data.designation);
	    $("#<portlet:namespace />mobile").val(data.mobile);
	    $("#<portlet:namespace />email").val(data.email);
	    $("#<portlet:namespace />address").val(data.address);
	    $("#<portlet:namespace />countryId").val(data.countryvalue);
	    $("#<portlet:namespace />stateId").val(data.statevalue);
	    $("#<portlet:namespace />city").val(data.city);
	    $("#<portlet:namespace />pinCode").val(data.pinCode);
	    $("#<portlet:namespace />receiptCategoryId").val(data.receiptcategoryvalue);
	    $("#<portlet:namespace />receiptSubCategoryId").val(data.receiptsubcategoryvalue);
	    $("#<portlet:namespace />subject").val(data.subject);
	    $("#<portlet:namespace />remarks").val(data.remarks);
	    
	    
	    $("#<portlet:namespace />receiptNumber").val(data.receiptNumber);
	    
	}
});











</aui:script>