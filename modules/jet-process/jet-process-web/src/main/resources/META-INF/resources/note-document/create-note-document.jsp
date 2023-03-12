<%@page import="io.jetprocess.masterdata.model.Masterdata"%>
<%@ include file="../init.jsp"%>
<style>
<!--
.control-label {
	display: none;
} 
-->
</style>

<portlet:actionURL var="saveNoteDocument" name="<%=MVCCommandNames.NOTE_DOCUMENT_ACTION_COMMAND %>"></portlet:actionURL>

<%
List<Masterdata> subCategory=(List<Masterdata>)request.getAttribute("subjectCategoryList");
%>
<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10 noteDocument">
		<h2 style="text-align: center; text-decoration: underline;">
			<liferay-ui:message key="label-create-note-document-heading" />
		</h2>
		<div class="border" style="border: 2px solid #a19c9c;">
		<aui:form action="<%=saveNoteDocument %>" method="post">
			<aui:row cssClass="mt-4">
				<aui:input name="CreatedBy" value="<%=selectedUserPostId %>" type="hidden"></aui:input>
				<aui:col md="4" cssClass="col-md-4">
					<div class="textOnInput">
						<label><liferay-ui:message
								key="label-create-note-document-subject" /></label>
						<aui:input label="" name="noteSubject" id="noteSubject">
						</aui:input>
					</div>
				</aui:col>
				<aui:col md="4" cssClass="">
					<div cssClass="input-group">
									<aui:select cssClass="form-select form-control"
													 name="categoryId" >
													<%
														for(Masterdata subCategoryvalue:subCategory){
													%>
												<option value="<%= subCategoryvalue.getMasterdataId() %>"><%=subCategoryvalue.getValue() %></option>
												<aui:validator name="required" />
												<%} %>
									</aui:select>
						</div>
				</aui:col>
				<aui:col md="4" cssClass="col-md-4">
					<div class="textOnInput">
						<label><liferay-ui:message
								key="label-create-note-document-createdOn" /></label>
						<aui:input label="" name="createdOn" id="createdOn" value="<%=simpleFormat.format(new Date()) %>">
						</aui:input>
					</div>
				</aui:col>
			</aui:row>
			<div class="m-3">
				<liferay-editor:editor contents="" editorName="ckeditor"
					name="content" />
			</div>
			<div style="text-align: right; padding: 10px 20px;">
				<aui:button cssClass="btn btn-primary" name="save" type="submit" value="label-create-note-document-save-button"></aui:button>
			</div>
			</aui:form>
			
		</div>
	</div>
</div>
<%@ include file="/js/file.js"%>