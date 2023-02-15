<script>

function openNote() {
	const notes = document.getElementById("notes");
	notes.style.display = "block";
}

function openGreenNote() {
	const notes = document.getElementById("notes");
	const note = document.getElementById("note");
	const editor = document.getElementById("editor");
	notes.style.display = "none";
	note.style.display = "none";
	editor.style.display = "block";
	CKEDITOR.replace('content');
}

var userPostId = $('#<portlet:namespace />userPostsVal').val();
	$('#addNoteButton').on('click',function(e){
	 event.preventDefault();
	 var fileId = $('#docFileId').val();
	 var fileMovementId = $('#fileMovementId').val();
	 var content = CKEDITOR.instances["content"].getData();
	 var noteId = $('#noteId').val();
	 var object = {};
	 var jsonData = object;
	 jsonData["createdBy"]=userPostId;
	 jsonData["fileId"] = fileId;
	 jsonData["content"] = content;
	 jsonData["noteId"] =noteId;
	 jsonData["fileMovementId"] =fileMovementId;
	 var jsonObj = JSON.stringify(jsonData);
	 $.ajax({
		 type:"POST",
		 url:"${portalURL}/o/jet-process-rs/v1.0/createNote?p_auth=" + Liferay.authToken,
		 data:jsonObj,
		 dataType: 'json',
		 cache : false,
		 processData: false,
	     contentType : 'application/json'
	 }).done(function(response){
		 if(response==null){
			 swal({
				 title: "Oops!",
		         text: "Note can't be empty!",
		         icon: "Fail",
			}) 
		}else{
			swal({
				text: `Note is created successfully!`,
			})
				window.location.reload(true);
		 }
	 }).fail(function(error){
		 swal({  
		  	text: "Note can't be empty!",  
		}).then(function(){
			window.location.reload(true);
		})	 
	 }) 
 })

function removeNote(){
		var noteId = $('#noteId').val();
		$.ajax({
			type:"POST",
			url:"${portalURL}/o/jet-process-rs/v1.0/deleteNote/"+noteId+"?p_auth=" + Liferay.authToken,
			data:noteId,
			cache : false,
			processData: false,
			contentType : 'text/plain'
		}).done(function(response){
		$('#exampleModal').hide();
			swal( {
				title: "Successfull!",
				text: `You have successfully deleted your note!`,
				icon: "success",
			}).then(function(){
				window.location.reload(true);
			})
		}).fail(function(error){
		$('#exampleModal').hide();
		swal({  
			title: " Oops!",  
			text: "Something went wrong!",  
			icon: "error",
		})
	 })
}
	
var noteId = '${note.noteId }';
if(noteId>0 && viewMode != 'ViewModeFromSentFile'){
	openGreenNote();
}
</script>