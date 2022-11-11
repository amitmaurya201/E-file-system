<%@ include file="../init.jsp"%>
<%@include file="/navigation.jsp"%>

<aui:container fluid="1250">
	<h1>Create Receipt</h1>
	<aui:form name="receiptForm">
		<aui:row>
			<aui:col lg="6" cssClass="border">
				<div class="pdf-container">
					<aui:input id="file" name="file" type="file" />
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
							<aui:option value="1">Type</aui:option>
						</aui:select>
					</aui:col>
					<aui:col md="4" cssClass="mt-3">
						<aui:select label="Delivery Mode" name="deliveryModeId"
							id="deliveryModeId">
							<aui:option value="1">Delivery Mode</aui:option>
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
							<aui:option value="1">Organization</aui:option>
						</aui:select>
					</aui:col>
					<aui:col md="6" cssClass="mt-3">
						<aui:select label="Sub Organization" name="subOrganizationId"
							id="subOrganizationId">
							<aui:option value="1">Sub Organization</aui:option>
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
							<aui:option value="1">Country</aui:option>
						</aui:select>
						</aui:col>
					<aui:col md="6" cssClass="mt-3">
						<aui:select label="State" name="stateId" id="stateId">
							<aui:option value="1">State</aui:option>
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
							<aui:option value="1">Category</aui:option>
						</aui:select>
					</aui:col>
					<aui:col md="6" cssClass="mt-3">
						<aui:select label="Sub Category" name="receiptSubCategoryId"
							id="receiptSubCategoryId">
							<aui:option value="1">Sub Category</aui:option>
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
					<aui:button cssClass="btn btn-primary" type="submit" 
						name="generate" value="Generate" />
				</aui:button-row>
			</aui:col>
		</aui:row>
	</aui:form>
</aui:container>
<!-- file upload  -->

<aui:script use="aui-base">
AUI().use('aui-base', 'io', 'aui-io-request', function(A){

	 var btnUploadFile = A.one("#<portlet:namespace />file");
	btnUploadFile.on("change", uploadFile);
	function uploadFile(event){
            event.preventDefault();
            
            
           console.log("--------"+event.target.files);
        }
        });
</aui:script>
<!-- 	receipt generate  -->
<aui:script use="aui-base">
	AUI().use('aui-base', 'io', 'aui-io-request', function(A){
		var btngenerate = A.one("#<portlet:namespace />generate");
		btngenerate.on("click", onSubmitGenerate);
		function onSubmitGenerate(event){
	            event.preventDefault();
				var myForm = A.one("#<portlet:namespace />receiptForm");
	  		 	var ajaxURL = ("http://localhost:8080/api/jsonws/jet_process.receipt/create-receipt?p_auth=" + Liferay.authToken);
	 			var configs = {
	                method:'POST',
	                dataType: 'json',
	               	form: {
	                    id:myForm,
	                   upload:true
	                },
	                on:{
							complete:function(){
							alert("Uploaded successfully !");
							}
					}
	            };
	            
	            A.io.request(ajaxURL, configs);    
	        }
		});
	
	
	
	
	</aui:script>