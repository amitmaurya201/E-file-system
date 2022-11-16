<%@ include file="../init.jsp"%>
<div class="row">
	<div class="col-2">
		<%@ include file="/navigation.jsp"%>
	</div>
	<div class="col mr-5">
		<aui:script>

	$("#value").change(function (e) {
	        console.log("Jquery ......" + $("#value").val());
	        });
	
	
	Liferay.Service(
	'/masterdata.masterdata/get-receipt-list-masterdata',
	{
	   
	    userPostId: 1
	},
	function(obj) {
	      $.each(obj, function(key, value) {
	      dataValue = value.value;
	       $("#myTable").append('<tr><td>' + (key+1) + '</td><td>' + value.receiptNumber+ '</td><td>'+value.subject+ '</td><td>'
                        +value.category+'</td><td>'+value.createDate+'</td><td>'+value.remark+ '</td></tr>'
                        );
                        });
	
	    console.log(obj);
	}
	); 
</aui:script>
		<div>

			<h1 class=" text-center">File Created List</h1>
			<table class="table" id="myTable">
				<thead>
					<tr class='table-blue'>
						<th>S.No</th>
						<th>Receipt No.</th>
						<th>Subject</th>
						<th>Category</th>
						<th>Created On</th>
						<th>Remark</th>

					</tr>
				</thead>
				<portlet:renderURL var="createReceiptUrl">
					<portlet:param name="mvcRenderCommandName" value="/createReceipt" />
					<portlet:param name="receiptId" value="1801" />
				</portlet:renderURL>
				<portlet:renderURL var="createReceiptUrl">
					<portlet:param name="mvcRenderCommandName" value="/createReceipt" />
					<portlet:param name="receiptId" value="1801" />
				</portlet:renderURL>
				<tbody>
					<tr>
						<td><aui:button href="${createReceiptUrl }"
								cssClass='btn btn-success' value="Update" /></td>
					</tr>
				</tbody>
			</table>


		</div>
	</div>
</div>