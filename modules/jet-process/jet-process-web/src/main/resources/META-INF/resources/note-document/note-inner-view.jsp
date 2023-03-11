<%@ include file="../init.jsp"%>


<% 
Note note = (Note)renderRequest.getAttribute("noteObj");
NoteDocument noteDocument = (NoteDocument)renderRequest.getAttribute("noteDocumentObj");
String subjectcategoryValue = (String)renderRequest.getAttribute("subjectCategoryValue");
%>

 <portlet:resourceURL id="<%=MVCCommandNames.NOTE_DOCUMENT_UPDATE_RESOURCE_COMMAND %>" var="updateNoteContent">
</portlet:resourceURL>
<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">
	<liferay-util:include page="/note-document/note-document-navigation.jsp"
			servletContext="<%=application%>">
			<liferay-util:param name="selectedNav" value="navhome" />
		</liferay-util:include>
		
<aui:row>
		<aui:col md="2" cssClass="col-md-2	">
								<div class="textOnInput">
									<label><liferay-ui:message
											key="label-note-subject" /></label>
									<aui:input label="" name="" id="" value="<%=noteDocument.getSubject()%>" disabled="true" cssClass="hover-tips" >
										
									</aui:input>
								</div>
							</aui:col>
							<aui:col md="2" cssClass="col-md-2">
								<div class="textOnInput">
									<label><liferay-ui:message
											key="label-note-subject-category" /></label>
									<aui:input label="" name="" id="" value="<%=subjectcategoryValue%>"  disabled="true" cssClass="hover-tips">
										
									</aui:input>
								</div>
							</aui:col>
							<aui:col md="2" cssClass="col-md-2">
								<div class="textOnInput">
									<label><liferay-ui:message
											key="label-note-created-on" /></label>
									<aui:input label="" name="" id="" value="<%=noteDocument.getCreateDate()%>" disabled="true" cssClass="hover-tips">
										
									</aui:input>
								</div>
							</aui:col>
							<aui:col md="2" cssClass="col-md-2">
								<div class="textOnInput">
									<label><liferay-ui:message
											key="label-note-document-no" /></label>
									<aui:input label="" name="" id="" value="<%=noteDocument.getNoteDocumentNumber()%>" disabled="true" cssClass="hover-tips">
										
									</aui:input>
								</div>
							</aui:col>
							
							</aui:row>
						

	<div class="m-3">
	<aui:form name = "addNoteDocument">	
	<div id="editor">
			<div id = "editor-head">
			
					<span style="padding: 0 19%;"><liferay-ui:message key="label-add-note-last-saved" /> 
					</span>
				
			</div>	
			   <aui:input name="noteId" value="<%=note.getNoteId() %>"   type="hidden"></aui:input>
				<liferay-editor:editor contents="<%=note.getContent() %>"  editorName="ckeditor"
					name="content"   />
			</div>
			</aui:form>
			
	 </div>
	 
</div>


<aui:script>
$( ".control-label" ).remove();
var contentOnchange=" ";
var noteContent = `${content}`;
console.log("noteContent"+noteContent);
if(noteContent==''){
	$("#editor-head").css("background-color","#960018");	
}
else{
	$("#editor-head").css("background-color","green");
}


 function <portlet:namespace/>clickHandler() {

	 contentOnchange = CKEDITOR.instances["<portlet:namespace/>content"].getData();
	  console.log("onchange"+contentOnchange);
	 if(noteContent!=contentOnchange){
	$("#editor-head").css("background-color","#960018");
	 }
}



 function saveNoteDocument() {
	 console.log("save note");
	 var content = CKEDITOR.instances["<portlet:namespace/>content"].getData();
	 if(content==''){
		 $("#editor-head").css("background-color","#960018");
	 }
	
	 if(noteContent!=contentOnchange ){
	 console.log("--=-=-=--=-==-");
		AUI().use('aui-io-request','aui-base','io', function(A){
			var form = A.one("#<portlet:namespace/>addNoteDocument");
			console.log(form);
			let data = CKEDITOR.instances["<portlet:namespace/>content"].getData();
			console.log('data:: '+data);
			
			$(form._node[2]).val(data);
				  A.io.request('<%=updateNoteContent.toString()%>', {
					method : 'post',
					form : {
					  id : form
					},
					on : {
					success : function() { 
				            console.log("--=-=-=--=-==- 1");
					   	       	 } 
							}
						});
					});
				}
	
	
	
	
}
 setInterval(saveNoteDocument, 10000);
</aui:script>

 
