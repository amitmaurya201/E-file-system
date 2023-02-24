
<aui:script>

$("#ShowAndHideDetachModalPopup").hide();
$("#detach-conformation").on('click', function(){
	$("#ShowAndHideDetachModalPopup").show();
});
$( ".control-label" ).remove();
var contentOnchange=" ";
var noteContent = `${noteContent}`;
if(noteContent==''){
	$("#editor-head").css("background-color","red");	
}
else{
	$("#editor-head").css("background-color","green");
}
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


}

 function <portlet:namespace/>ClickHandler() {
	 contentOnchange = CKEDITOR.instances["<portlet:namespace/>content"].getData();
	 if(noteContent!=contentOnchange){
	$("#editor-head").css("background-color","red");
	 }
}
 
 var userPostId = $('#<portlet:namespace />userPostsVal').val();
 $("#deleteNote").on('click', function(e){

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
		}).then(function(){
			window.location.reload(true);
		})
	 })
});
	
var noteId = '${note.noteId }';
if(noteId>0 && viewMode != 'ViewModeFromSentFile'){
	openGreenNote();
}

 function SaveNoteContent() {
	 var content = CKEDITOR.instances["<portlet:namespace/>content"].getData();
	 if(content==''){
		 $("#editor-head").css("background-color","red");
	 }
	 var fileId = $('#docFileId').val();
	 var fileMovementId = $('#fileMovementId').val();
	 var noteId = $('#noteId').val();
	 var object = {};
	 var jsonData = object;
	 jsonData["createdBy"]=userPostId;
	 jsonData["fileId"] = fileId;
	 jsonData["content"] = content;
	 jsonData["noteId"] =noteId;
	 jsonData["fileMovementId"] =fileMovementId;
	 var jsonObj = JSON.stringify(jsonData);
	 if(content.length!=0 && noteContent!=contentOnchange ){
	 $.ajax({
		 type:"POST",
		 url:"${portalURL}/o/jet-process-rs/v1.0/createNote?p_auth=" + Liferay.authToken,
		 data:jsonObj,
		 dataType: 'json',
		 cache : false,
		 processData: false,
	     contentType : 'application/json'
	 }).done(function(response){
		console.log("response"+response);
		noteContent=contentOnchange;
		 $("#editor-head").css("background-color","green");
		 $('#editor-head').load(' #editor-head')
	 })
	}
}
 setInterval(SaveNoteContent, 20000);
</aui:script>