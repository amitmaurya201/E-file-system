<script src="https://cdn.ckeditor.com/4.20.1/standard/ckeditor.js"></script>


<div style="background-color: #bef8c7; height: 400px">
	<img src='<%=request.getContextPath() + "/image/note.png"%>' width="8%"
		id="note" height="30" class="shadow m-1 bg-white rounded-circle"
		onclick="openNote()" />

	<div id="notes" style="display: none;">
		<img src='<%=request.getContextPath() + "/image/green-note.jpg"%>'
			width="8%" height="30" class="shadow m-1 bg-white rounded-circle"
			onclick="openGreenNote()" /> <br /> <img
			src='<%=request.getContextPath() + "/image/yellow-note.jpg"%>'
			width="8%" height="30" class="shadow m-1 bg-white rounded-circle"
			onclick="openYellowNote()" />
	</div>
	<aui:form name="addNote" >
		<div id="editor" style="display: none;">
			<div style="background-color:green;">
			<button type="button" id="removeNote">
			<i class="bi bi-clipboard-x-fill"></i>
			</button>
			<button type="button" id= "addNoteButton" >
			<i class="bi bi-clipboard-minus-fill"></i>
			</button>
			</div>	
         	<input name = "noteId" id = "noteId" value = "0" type= "hidden"/>
			<textarea id = "content" name="content"></textarea>
		</div>
	</aui:form>
	
</div>

<br>
<div id="my-content-div">
	<div>
	<p>Are you sure you want to delete note ?</p>
		<button type = "button" id = "remove">Ok</button>
		<button type = "button" id = "cancel">Cancel</button>
	</div>
</div>

<!-- AUI Script For Modal Dialog POPUP -->
