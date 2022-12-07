<%@ include file="../init.jsp"%>


<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">
	
	
		
		<h1 class=" text-center">Receipt Sent List</h1>
		
		<%-- 
		<%
		List<ReceiptMovementListDTO> receiptSentList =MasterdataLocalServiceUtil.getReceiptSendList();
		
		%>
	<c:forEach var="receiptSent" items="${receiptSentList }">
			
				
<h1>receiptSent.dueDate</h1><br>
<h1>receiptSent.remark</h1><br>
<h1>receiptSent.receiptId</h1><br>
<h1>receiptSent.senderId</h1><br>
<h1>receiptSent.receiverId</h1><br>
<h1>receiptSent.sendOn</h1><br>
					
			
		</c:forEach>
		 --%>
	</div>
</div>
