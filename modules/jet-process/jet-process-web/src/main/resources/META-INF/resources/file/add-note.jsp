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

	<div id="editor" style="display: none;">
		<div style="background-color:green;">
		<button type="button" class="btn-close" aria-label="Close"></button>
		</div>
		<textarea name="editor-textarea"></textarea>
	</div>

</div>
<script>
	const notes = document.getElementById("notes");
	const note = document.getElementById("note");
	const editor = document.getElementById("editor");
	function openNote() {
		notes.style.display = "block";
	}

	function openGreenNote() {
		notes.style.display = "none";
		note.style.display = "none";
		editor.style.display = "block";
		CKEDITOR.replace('editor-textarea');
	}
</script>