<%@ include file="../init.jsp"%>
<%@ page import="com.liferay.portal.kernel.service.ServiceContext"%>
<%@ page import="com.liferay.portal.kernel.service.ServiceContextThreadLocal"%>
<%@ include file = "/js/receipt.js" %>
<div class="row">
<div class="col-2">
	<%@ include file="/navigation.jsp" %>
</div>
<% ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		String setURl = serviceContext.getPortalURL();
	
	%>

<div class="col mr-5">
<aui:container fluid="1250">
	<h1>Create Receipt</h1>
	<aui:form name="receiptForm">
	<aui:input name="userPostId" id="userPostId" value="1" />
		<aui:row>
			<aui:col lg="6" cssClass="border">
				<div class="pdf-container">
				 <aui:input id = "document" name="document" type="file"  />
				  <aui:input id = "tempFileId" name="tempFileId" type = "hidden"/>
				 
				</div>
			</aui:col>
			<aui:col lg="6" cssClass="border">

				<h4>Diary Details</h4>
				<aui:row>
					<aui:col md="4" cssClass="mt-3">

						<aui:input label="Created On" name="createdOn" id="createdOn" />
					</aui:col>
					<aui:col md="4" cssClass="mt-3">
						<aui:select label="Type" name="typeId" id="typeId">
							<aui:option value="0">Type</aui:option>
						</aui:select>
					</aui:col>
					<aui:col md="4" cssClass="mt-3">
						<aui:select label="Delivery Mode" name="deliveryModeId"
							id="deliveryModeId">
							<aui:option value="0">Delivery Mode</aui:option>
						</aui:select>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col md="6" cssClass="mt-3">
						<aui:input type="date" label="Received on" name="receivedOn"
							id="receivedOn" />
					</aui:col>
					<aui:col md="6" cssClass="mt-3">
						<aui:input type="date" label="Letter Date" name="letterDate"
							id="letterDate" />
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col md="6" cssClass="mt-3">
						<aui:input label="Reference Number" name="referenceNumber"
							id="referenceNumber" />
					</aui:col>
					<aui:col md="6" cssClass="mt-3">
						<aui:input label="Mode Number" name="modeNumber" id="modeNumber" />
					</aui:col>
				</aui:row>

				<hr>

				<h4>Sender Details</h4>
				<aui:row>
					<aui:col md="6" cssClass="mt-3">
						<aui:select label="Organization" name="organizationId"
							id="organizationId">
							<aui:option value="0">Organization</aui:option>
						</aui:select>
					</aui:col>
					<aui:col md="6" cssClass="mt-3">
						<aui:select label="Sub Organization" name="subOrganizationId"
							id="subOrganizationId">
							<aui:option value="0">Sub Organization</aui:option>
						</aui:select>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col md="6" cssClass="mt-3">
						<aui:input label="Name" name="name" id="name" />
					</aui:col>
					<aui:col md="6" cssClass="mt-3">
						<aui:input label="Designation" name="designation" id="designation" />
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col md="6" cssClass="mt-3">
						<aui:input label="Mobile" name="mobile" id="mobile" />
					</aui:col>
					<aui:col md="6" cssClass="mt-3">
						<aui:input label="Email" name="email" id="email" />
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col cssClass="mt-3">
						<aui:input type="textarea" label="Address" name="address"
							id="address" />
					</aui:col>
				</aui:row>
				<aui:row>
				<aui:col md="6" cssClass="mt-3">
					<aui:select label="Country" name="countryId" id="countryId">
							<aui:option value="0">Country</aui:option>
						</aui:select>
						</aui:col>
					<aui:col md="6" cssClass="mt-3">
						<aui:select label="State" name="stateId" id="stateId">
							<aui:option value="0">State</aui:option>
						</aui:select>
					</aui:col>
				</aui:row>
				<aui:row>
				<aui:col md="6" cssClass="mt-3">
					<aui:input label="City" name="city" id="city" />
					</aui:col>
					<aui:col md="6" cssClass="mt-3">
						<aui:input label="Pin Code" name="pinCode" id="pinCode" />
					</aui:col>
				</aui:row>
				
				
				<hr>
				
					<h4>Receipt Details</h4>
					<aui:row>
					<aui:col md="6" cssClass="mt-3">
						<aui:select label="Category" name="receiptCategoryId"
							id="receiptCategoryId">
						<aui:option value="0">Category</aui:option>
						</aui:select>
					</aui:col>
					<aui:col md="6" cssClass="mt-3">
						<aui:select label="Sub Category" name="receiptSubCategoryId"
							id="receiptSubCategoryId" >
							<aui:option value="0">Subcategory</aui:option>
						</aui:select>
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col cssClass="mt-3">
						<aui:input type="textarea" label="Subject" name="subject"
							id="subject" />
					</aui:col>
				</aui:row>
				<aui:row>
					<aui:col cssClass="mt-3">
						<aui:input  label="Remarks" name="remarks" id="remarks" />
					</aui:col>
				</aui:row>
				<%--	Action Buttons--%>
				<aui:button-row >
					<aui:button cssClass="btn btn-primary" type="submit" onClick="receiptGenerate()" 
						name="generate" value="Generate" />
				</aui:button-row>
			</aui:col>
		</aui:row>
	</aui:form>
</aui:container>
</div>
</div>


<!-- 	receipt generate  -->

<script type="text/javascript">
	function receiptGenerate() {
		console.log('h');
		var groupId = Liferay.ThemeDisplay.getScopeGroupId();
		console.log(groupId);

		var receiptFormData = new FormData();
		   receiptFormData.append('groupId', groupId);
		   receiptFormData.append('typeId',  $("#<portlet:namespace />typeId"));
		   receiptFormData.append('tempfileEntryId', $("#<portlet:namespace />doucment") );
		   receiptFormData.append('deliveryModeId',  $("#<portlet:namespace />deliveryModeId"));
		   receiptFormData.append('receivedOn', $("#<portlet:namespace />receivedOn") );
		   receiptFormData.append('letterDate',$("#<portlet:namespace />letterDate") );
		   receiptFormData.append('referenceNumber',$("#<portlet:namespace />referenceNumber") );
		   receiptFormData.append('modeNumber',$("#<portlet:namespace />modeNumber") );
		   receiptFormData.append('receiptCategoryId ', $("#<portlet:namespace />receiptCategoryId"));
		   receiptFormData.append('receiptSubCategoryId ', $("#<portlet:namespace />receiptSubCategoryId"));
		   receiptFormData.append('subject', $("#<portlet:namespace />subject"));
		   receiptFormData.append('remarks',$("#<portlet:namespace />remarks") );
		   receiptFormData.append('name',$("#<portlet:namespace />name") );
		   receiptFormData.append('designation', $("#<portlet:namespace />designation"));
		   receiptFormData.append('mobile', $("#<portlet:namespace />mobile"));
		   receiptFormData.append('email', $("#<portlet:namespace />email"));
		   receiptFormData.append('address',$("#<portlet:namespace />address") );
		   receiptFormData.append('countryId',$("#<portlet:namespace />countryId") );
		   receiptFormData.append('stateId',$("#<portlet:namespace />stateId") );
		   receiptFormData.append('pinCode',$("#<portlet:namespace />pinCode") );
		   receiptFormData.append('organizationId',$("#<portlet:namespace />organizationId") );
		   receiptFormData.append('subOrganizationId',$("#<portlet:namespace />subOrganizationId") );
		   receiptFormData.append('city', $("#<portlet:namespace />city")); 
		   receiptFormData.append('userPostId',$("#<portlet:namespace />userPostId") ); 
		 	 $.ajax({
				    type: "POST",
				    url: "http://localhost:8080/api/jsonws/jet_process.receipt/create-receipt?p_auth=" + Liferay.authToken,
				    data: receiptFormData,
				    cache : false,
				    processData: false,
				    contentType: false,
				  }).done(function() {
					  alert('success')
				  }).fail(function() {
				     alert('An error occurred! Please try again later.')
				  }); 
	}
</script>

<aui:script>

$("#<portlet:namespace />click").on('change', function(){

	alert("calling onchange event");
});

</aui:script>


