<%@ include file="../init.jsp"%>
<%@include file="/navigation.jsp" %>

<div class="container">
	<h1>Create Receipt</h1>

	<div class="row">
		<div class="col-6 border">
			<h1>PDF VIEW</h1>
		</div>
	 	<div class="col-6 border ">
			<aui:fieldset-group markupView="lexicon">
				<h4>Diary Details</h4>
				<aui:fieldset>
					<aui:input label="Created On" name="createdOn" id="createdOn" />
					<aui:select label="Type" name="typeId" id="typeId">
						<aui:option value="">Type</aui:option>
					</aui:select>
					<aui:select label="Delivery Mode" name="deliveryModeId"
						id="deliveryModeId">
						<aui:option value="">Delivery Mode</aui:option>
					</aui:select>
					<aui:input type="date" label="Received on" name="receivedOn"
						id="receivedOn" />
					<aui:input type="date" label="Letter Date" name="letterDate"
						id="letterDate" />
					<aui:input label="Reference Number" name="referenceNumber"
						id="referenceNumber" />
					<aui:input label="Mode Number" name="modeNumber" id="modeNumber" />

				</aui:fieldset>
			</aui:fieldset-group>
			<aui:fieldset-group markupView="lexicon">
				<h4>Sender Details</h4>
				<aui:fieldset>
					<aui:select label="Organization" name="organization"
						id="organization">
						<aui:option value="">Organization</aui:option>
					</aui:select>
					<aui:select label="Sub Organization" name="subOrganization"
						id="subOrganization">
						<aui:option value="">Sub Organization</aui:option>
					</aui:select>
					<aui:input label="Name" name="name" id="name" />
					<aui:input label="Designation" name="designation" id="designation" />
					<aui:input label="Mobile" name="mobile" id="mobile" />
					<aui:input label="Email" name="email" id="email" />
					<aui:input type="textarea" label="Address" name="address"
						id="address" />
					<aui:select label="Country" name="country" id="country">
						<aui:option value="">Country</aui:option>
					</aui:select>
					<aui:select label="State" name="state" id="state">
						<aui:option value="">State</aui:option>
					</aui:select>
					<aui:input label="City" name="city" id="city" />
					<aui:input label="Pin Code" name="pinCode" id="pinCode" />


				</aui:fieldset>
			</aui:fieldset-group>
			<aui:fieldset-group markupView="lexicon">
				<h4>Receipt Details</h4>
				<aui:fieldset>
					<aui:select label="Category" name="category" id="category">
						<aui:option value="">Category</aui:option>
					</aui:select>
					<aui:select label="Sub Category" name="subCategory"
						id="subCategory">
						<aui:option value="">Sub Category</aui:option>
					</aui:select>
					<aui:input label="Subject" name="subject" id="subject" />
					<aui:input label="Remarks" name="remarks" id="remarks" />
				</aui:fieldset>
			</aui:fieldset-group>
		<%--	Action Buttons--%>
			<aui:button-row>
				<aui:button cssClass="btn btn-primary" type="submit" />
				<aui:button cssClass="btn btn-secondary" type="cancel" />
			</aui:button-row>
		</div>
	</div> 

</div>
