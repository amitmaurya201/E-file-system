
	<div id="yellow-editor" style="display: none;">
		<div id="yellow-note-header">
			<button id="removeYellowNote" type="button" class="deleteButton"
				data-toggle="modal" data-target="#exampleModal">
				<i class="fa fa-trash"></i>
			</button>
			<c:set var = "yellowFileNote" scope = "session" value = "${yellowFileNoteObj}"/>
		<c:if test="${not empty yellowFileNote}">
			<span style="padding: 0 19%;"><liferay-ui:message
				key="label-add-note-last-saved" /> :<fmt:formatDate type="both"
				pattern="dd/MM/yyyy  hh:mm aa" timeZone="Asia/Calcutta"
				value="${yellowNoteModifiedDate}" /> </span>
		</c:if>
		</div>
		<c:if test="${empty yellowFileNote}">
			<input name="yellowNoteId" id="yellowNoteId" value="0" type="hidden" />
			<liferay-editor:editor contents="" editorName="ckeditor"
				name="yellow-note-content" onChangeMethod= "yellowClickHandler" onInitMethod= "yellowBackgroundEditor"/>
		</c:if>
		<c:if test="${not empty yellowFileNote}">
			<input name="yellowNoteId" id="yellowNoteId" value="${yellowFileNote.noteId }"
				type="hidden" />
			<liferay-editor:editor contents="${yellowNoteContent}"
				editorName="ckeditor" name="yellow-note-content" onChangeMethod= "yellowClickHandler" onInitMethod= "yellowBackgroundEditor" />
		</c:if>
	</div>
