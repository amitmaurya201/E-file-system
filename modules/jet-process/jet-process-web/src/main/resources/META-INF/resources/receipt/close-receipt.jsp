<%@ include file="../init.jsp"%>

<%
   

long receiptId = (long) renderRequest.getAttribute("receiptId");
long rmId = (long) renderRequest.getAttribute("rmId");


%>

<portlet:actionURL var="closeReceiptURL" name="<%=MVCCommandNames.CLOSE_RECEIPT_ACTION_COMMAND%>">


</portlet:actionURL>

     <aui:form action="${closeReceiptURL}" method="post" name="fm">
			<div style="text-align: left; height: 100px;">
			<aui:input name="receiptId" value="<%=receiptId %>" type="hidden"/>
			<aui:input name="rmId" value="<%=rmId %>" type="hidden"/>
			
				<aui:input label="label-closereceipt-remark" name="closingRemarks" id="closingRemarks"
					type="textarea" style="height:70px;">
					<aui:validator name="required"></aui:validator>
					<aui:validator name="maxLength">
						<liferay-ui:message key="receipt-sent-remarks-maxlength" />
					</aui:validator>
				</aui:input>
			</div>
			<hr style="margin: 2rem -1rem 1rem -1rem;" />
			<div style="text-align: right; padding-bottom: 10px;">
				<button type="submit" class="btn btn-primary" id="submit_pull_back">
					<liferay-ui:message key="label-closereceipt-button-submit" />
				</button>
				<button type="button" class="btn btn-primary" id="close">
					<liferay-ui:message key="label-closereceipt-button-cancel" />
				</button>
			</div>
		</aui:form>

		<script>
		
		
		
		
		
		
		
		</script>