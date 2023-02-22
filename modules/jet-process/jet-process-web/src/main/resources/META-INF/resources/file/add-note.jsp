<%@ taglib uri="http://liferay.com/tld/editor" prefix="liferay-editor" %>
<liferay-editor:resources editorName="ckeditor" />
<%@page import="com.liferay.portal.kernel.util.UnicodeFormatter"%>
<%-- <liferay-ui:input-editor  initMethod="initEditor" width="100" height="400" resizable="true" toolbarSet="liferay-article" editorImpl="<%=EDITOR_WYSIWYG_IMPL_KEY%>" />
<aui:input name="editorContent" type="text"> --%>

<style>
.saveButton {
	background-color: DodgerBlue;
	border: none;
	color: white;
	padding: 2px 6px;
	font-size: 16px;
	cursor: pointer;
	border-radius: 50%;
}

.deleteButton {
	background-color: DodgerBlue;
	border: none;
	color: white;
	padding: 2px 6px;
	font-size: 16px;
	cursor: pointer;
	border-radius: 50%;
}
</style>
<c:set var="note" scope="session" value="${noteObj}" />
<div style="background-color: #bef8c7; height: 400px" id="mydiv">
	<img src='<%=request.getContextPath() + "/image/note.png"%>' width="8%"
		id="note" height="30"
		class="shadow m-1 bg-white rounded-circle addtoggle " />
	<div id="notes" class="g" style="display: none;">
		<img src='<%=request.getContextPath() + "/image/green-note.jpg"%>'
			width="8%" height="30" class="shadow m-1 bg-white rounded-circle"
			onclick="openGreenNote()" /> <br /> <img
			src='<%=request.getContextPath() + "/image/yellow-note.jpg"%>'
			width="8%" height="30" class="shadow m-1 bg-white rounded-circle"
			onclick="openYellowNote()" />
	</div>
	<aui:form name="addNote">
		<div id="editor" style="display: none;">
			<div id = "editor-head">
				<button id="removeNote" type="button" class="deleteButton"
					data-toggle="modal" data-target="#exampleModal">
					<i class="fa fa-trash"></i>
				</button>
				<c:if test="${not empty note.noteId }">
					<span style="padding: 0 19%;"><liferay-ui:message key="label-add-note-last-saved" /> :<fmt:formatDate
							type="both" pattern="dd/MM/yyyy  hh:mm aa"
							timeZone="Asia/Calcutta" value="${modifiedDate}" />
					</span>
				</c:if>
			</div>
			<c:if test="${ empty note.noteId }">
				<input name="noteId" id="noteId" value="0" type="hidden" />
				<!-- <textarea id="content" name="content"></textarea> -->
				<liferay-editor:editor  contents="" editorName="ckeditor" name="content" onChangeMethod="ClickHandler" />
			</c:if>
			<c:if test="${not empty note }">
				<input name="noteId" id="noteId" value="${note.noteId }"
					type="hidden">
				<%-- <textarea id="content" name="content">${noteContent}</textarea> --%>
				<liferay-editor:editor contents="${noteContent}" editorName="ckeditor" name="content" onChangeMethod="ClickHandler" />
			</c:if>
		</div>
	</aui:form>
		<% List<NoteDTO> note =(List <NoteDTO>)request.getAttribute("noteList");
		if(note!=null){
			int i = 1;
			for(NoteDTO noteDTO : note){
				JSONObject object = JSONFactoryUtil.createJSONObject(noteDTO.getSignature());
				%>
		<div
		style="height: auto; padding: 0px 10px; border-color: gray; box-shadow: 0 4px 4px 0 rgba(0, 0, 0, 0.1), 0 2px 0px 0 rgba(0, 0, 0, 0.10);">
		<b><liferay-ui:message key="label-add-note-note" /> # <%=i%></b>
		<div class="container">
			<%=noteDTO.getContent()%>
		</div>
		<div class="mt-1">
			<c:set var="now" value="<%=noteDTO.getCreateDate()%>" />
			<fmt:formatDate type="both" pattern="dd/MM/yyyy  hh:mm aa"
				timeZone="Asia/Calcutta" value="${now}" />
			<span style="float: right;"> <%=object.get("userName")%></span>
			<p style="text-align: right;">
				<span><%=object.get("departmentName")%></span> <span><%=object.get("postMarking")%></span>
			</p>
		</div>
	</div>
	<%
	i++;
	} 
			
}
	%>
</div>	
	
<br>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header" style="background-color: #007bff";>
				<h5 class="modal-title" style="color: #FFFFFF"
					id="exampleModalLabel"><liferay-ui:message key="label-add-note-discard-title" /></h5>
				<button type="button" class="close" style="color: #FFFFFF"
					data-dismiss="modal" aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<p><liferay-ui:message key="label-add-note-discard-boday" /></p>
			</div>
			<div class="modal-footer" style="justify-content: end !important;">
				<div>
					<button type="button" class="btn btn-primary" id="deleteNote"
						onClick="removeNote()"><liferay-ui:message key="label-add-note-discard-ok-button" /></button>
					<button type="button" class="btn btn-primary mr-auto" id="cancel"
						data-dismiss="modal"><liferay-ui:message key="label-add-note-discard-close-button" /></button>
				</div>
			</div>
		</div>
	</div>
</div>
<%@ include file="/js/note.js"%>
<script>
	var viewMode = "${param.viewMode}";
	console.log("viewMode" + viewMode);
	if (viewMode == 'ViewModeFromSentFile') {
		$('#note').removeClass("addtoggle");
	}
	jQuery('#mydiv').css("overflow-y", "scroll");

	/* for toggle note icon  */
	$(document).ready(function() {
		$(".addtoggle").click(function() {
			$("#notes").toggle();
		});
	});
</script>