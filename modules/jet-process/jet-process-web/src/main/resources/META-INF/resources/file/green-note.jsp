
<!-- <style>
	.editor-background{
		background-color: red !important;
	}
</style> -->
	
	<div id="green-editor" style="display: none;" >
		<div id="green-note-header">
			<button id="removeGreenNote" type="button" class="deleteButton"
				data-toggle="modal" data-target="#exampleModal">
				<i class="fa fa-trash"></i>
			</button>
		<c:set var = "greenFileNote" scope = "session" value = "${greenFileNoteObj}"/>
		<c:if test="${not empty greenFileNote }">
			<span style="padding: 0 19%;"><liferay-ui:message
				key="label-add-note-last-saved" /> :<fmt:formatDate type="both"
				pattern="dd/MM/yyyy  hh:mm aa" timeZone="Asia/Calcutta"
				value="${greenFileNote.modifiedDate}" /> </span>
		</c:if>
		</div>
		<c:if test="${ empty greenFileNote}">
			<input name="greenNoteId" id="greenNoteId" value="0" type="hidden" />
			<liferay-editor:editor contents="" editorName="ckeditor" 
				name="green-note-content" onChangeMethod="greenClickHandler" onInitMethod = "greenBackgroundEditor"/>
		</c:if>
		<c:if test="${not empty greenFileNote }">
			<input name="greenNoteId" id="greenNoteId" value="${greenFileNote.noteId }"
				type="hidden" />
			<liferay-editor:editor contents="${greenNoteContent}" 
				editorName="ckeditor" name="green-note-content" onChangeMethod="greenClickHandler" onInitMethod="greenBackgroundEditor"/>
		</c:if>
	</div>
