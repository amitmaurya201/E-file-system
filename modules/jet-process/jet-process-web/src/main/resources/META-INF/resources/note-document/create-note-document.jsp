<%@ include file="../init.jsp"%>
<style>
<!--
.control-label {
	display: none;
} 
-->
</style>

<<portlet:actionURL var="saveNoteDocument" name="<%=MVCCommandNames.NOTE_DOCUMENT_ACTION_COMMAND %>"></portlet:actionURL>


<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10 noteDocument">
		<h2 style="text-align: center; text-decoration: underline;">
			<liferay-ui:message key="label-create-note-document-heading" />
		</h2>
		<div class="border" style="border: 2px solid #a19c9c;">
		<aui:form action="<%=saveNoteDocument %>">
			<aui:row>
				<aui:col md="4" cssClass="mt-4">
					<div class="textOnInput">
						<label><liferay-ui:message
								key="label-create-note-document-subject" /></label>
						<aui:input label="" name="noteSubject" id="noteSubject">
						</aui:input>
					</div>
				</aui:col>
				<aui:col md="4" cssClass="mt-4">
					<div class="textOnInput">
						<label><liferay-ui:message
								key="label-create-note-document-subject-category" /></label>
						<aui:input label="" name="subjectCategory" id="subjectCategory">
						</aui:input>
					</div>
				</aui:col>
				<aui:col md="4" cssClass="mt-4">
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
				<aui:button cssClass="btn btn-primary" name="save" value="label-create-note-document-save-button"></aui:button>
			</div>
		</div>
</aui:form>
	</div>
</div>
