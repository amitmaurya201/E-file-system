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
	CKEDITOR.replace('content');
}

var userPostId = $('#<portlet:namespace />userPostsVal').val();
	$('#addNoteButton').on('click',function(e){
	 event.preventDefault();
	 var fileId = $('#docFileId').val();
	 var content = CKEDITOR.instances.content.document.getBody().getText();
	 var noteId = $('#noteId').val();
	 console.log(noteId);
	var object = {};
	 var jsonData = object;
	 jsonData["createdBy"]=userPostId;
	 jsonData["fileId"] = fileId;
	 jsonData["content"] = content;
	 jsonData["noteId"] =noteId;
	 var jsonObj = JSON.stringify(jsonData);
	 $.ajax({
		 type:"POST",
		 url:"${setURL}/o/jet-process-rs/v1.0/createNote?p_auth=" + Liferay.authToken,
		 data:jsonObj,
		 dataType: 'json',
		    cache : false,
		    processData: false,
	        contentType : 'application/json'
	 }).done(function(response){
		 console.log(response);
		noteId=response.noteId;
		 $("#noteId").val(noteId).trigger('change');
		 console.log("noteId"+noteId);
	 }).fail(function(error){
		 console.log(error);
		 
	 }) 
 })

</script>
 <aui:script use="aui-modal,aui-overlay-manager">
	 A.one("#removeNote").on('click',function(event){
	 	var dialog = new A.Modal({
	 		title: "AUI Modal Popup Title",
	 		bodyContent: A.one("#my-content-div").html(),
	 		headerContent: 'Delete Note',
	 		centered: true,
	 		modal: true,
	 		height: 200,
	 		width:300,
	 		render: '#my-content-div',
	 		close: true
	 	});
	 	dialog.render();
	 	$("#remove").on('click', function(e){
	 		alert("teshhhhhhhh");
	 });


	
})
	 </aui:script>