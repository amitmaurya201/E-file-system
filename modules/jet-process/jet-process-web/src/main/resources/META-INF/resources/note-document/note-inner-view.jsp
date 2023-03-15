<%@ include file="../init.jsp"%>


<%
	Note note = (Note) renderRequest.getAttribute("noteObj");
	NoteDocument noteDocument = (NoteDocument) renderRequest.getAttribute("noteDocumentObj");
	String subjectcategoryValue = (String) renderRequest.getAttribute("subjectCategoryValue");
	long noteDocumentId = (long) renderRequest.getAttribute("noteDocumentId");
%>

<portlet:resourceURL
	id="<%=MVCCommandNames.NOTE_DOCUMENT_UPDATE_RESOURCE_COMMAND%>"
	var="updateNoteContent">
</portlet:resourceURL>
<style>
p.ex1 {
	margin-top: 40px;
}
</style>

<div class="row ">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>

	<div class="col-10 ">

		<liferay-util:include
			page="/note-document/note-document-navigation.jsp"
			servletContext="<%=application%>">
			<liferay-util:param name="selectedNav" value="navhome" />
		</liferay-util:include>

		<div class=" noteDocument ext1">
			<aui:row cssClass="mt-4 ">
				<aui:col md="3" cssClass="col-md-3	">
					<div class="textOnInput">
						<label><liferay-ui:message key="label-note-subject" /></label>
						<aui:input label="" name="" id=""
							value="<%=noteDocument.getSubject()%>" readOnly="true"
							data-toggle="tooltip" data-placement="Bottom" title="<%=noteDocument.getSubject()%>"  >

						</aui:input>
					</div>
				</aui:col>
				<aui:col md="3" cssClass="col-md-3">
					<div class="textOnInput">
						<label><liferay-ui:message
								key="label-note-subject-category" /></label>
						<aui:input label="" name="" id=""
							value="<%=subjectcategoryValue%>" readOnly="true"
						data-toggle="tooltip" data-placement="Bottom" title="<%=subjectcategoryValue%>" >

						</aui:input>
					</div>
				</aui:col>
				<aui:col md="3" cssClass="col-md-3">
					<div class="textOnInput">
						<label><liferay-ui:message key="label-note-created-on" /></label>
						<aui:input label="" name="" id=""
							value="<%=simpleFormat.format(noteDocument.getCreateDate())%>"
							readOnly="true" data-toggle="tooltip" data-placement="Bottom" title="<%=simpleFormat.format(noteDocument.getCreateDate())%>" >

						</aui:input>
					</div>
				</aui:col>
				<aui:col md="3" cssClass="col-md-3">
					<div class="textOnInput">
						<label><liferay-ui:message key="label-note-document-no" /></label>
						<aui:input label="" name="" id=""
							value="<%=noteDocument.getNoteDocumentNumber()%>" readOnly="true"
							data-placement="Bottom" title="<%=noteDocument.getNoteDocumentNumber()%>" >

						</aui:input>
					</div>
				</aui:col>

			</aui:row>
		</div>

		<div class="m-3">
			<aui:form name="addNoteDocument">
					<div id="editor-head">

						<span  style="padding: 0 19%;"><liferay-ui:message
								key="label-add-note-last-saved" /> <fmt:formatDate type="both"
								pattern="dd/MM/yyyy  hh:mm aa" timeZone="Asia/Calcutta"
								value="<%=note.getModifiedDate()%>" /> </span>

					</div>
				<div id="editor">
					<aui:input name="noteId" value="<%=note.getNoteId()%>"
						type="hidden"></aui:input>
					<liferay-editor:editor contents="<%=note.getContent()%>"
						editorName="ckeditor" onChangeMethod="clickHandler" name="content" />
				</div>
			</aui:form>

		</div>

	</div>
</div>

<aui:script>

$( ".control-label" ).remove();
var contentOnchange=" ";
var noteContent = '<%=note.getContent()%>';

if(noteContent===''){
	$("#editor-head").css("background-color","#960018");	
}



 function <portlet:namespace />clickHandler() {
	 contentOnchange = CKEDITOR.instances["<portlet:namespace />content"].getData();
	 if(noteContent!=contentOnchange){
	$("#editor-head").css("background-color","#960018");
	 }
}



 function saveNoteDocument() {
	 var content = CKEDITOR.instances["<portlet:namespace />content"].getData();
	 
	 if(noteContent!=content ){
		AUI().use('aui-io-request','aui-base','io', function(A){
			var form = A.one("#<portlet:namespace />addNoteDocument");
			let data = CKEDITOR.instances["<portlet:namespace />content"].getData();
			
			$(form._node[2]).val(data);
				  A.io.request('<%=updateNoteContent.toString()%>', {
					method : 'post',
					form : {
					  id : form
					},
					on : {
					success : function() { 
					$("#editor-head").css("background-color","green");
					$("#editor-head").load(location.href + " #editor-head"); 
					
					   	       	 } 
							}
						});
					});
				}
}
 setInterval(saveNoteDocument, 10000);
 
 
</aui:script>


