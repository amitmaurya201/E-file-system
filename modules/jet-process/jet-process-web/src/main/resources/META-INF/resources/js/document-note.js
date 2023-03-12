<aui:script>


// --- master data category ---
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


</aui:script>