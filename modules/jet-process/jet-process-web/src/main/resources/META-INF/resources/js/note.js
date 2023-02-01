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
	
	 console.log("userPostId"+userPostId);
	 var fileId = $('#docFileId').val();
	 console.log("fileId"+fileId);
	 var content = CKEDITOR.instances.content.document.getBody().getText();
	 console.log("content"+content);
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
		 if(response==null){
			 swal({
					title: "Oops!",
		             text: "Note can't be empty!",
		             icon: "Fail",
					}) 
		}
		/* noteId=response.noteId;
		 $("#noteId").val(noteId).trigger('change');*/
		 swal({
				title: "Successfull!",
	             text: `Note is created successfully!`,
	             icon: "success",
				}).then(function(){
					window.location.reload(true);
				})
		
	 }).fail(function(error){
		 swal({  
				title: " Oops!",  
			  	text: "Something went wrong!",  
			  	icon: "error",
			})
		 
	 }) 
 })

 function removeNote(){
	 var noteId = $('#noteId').val();
	 console.log("noteId"+noteId);
	 $.ajax({
		 type:"POST",
		 url:"${setURL}/o/jet-process-rs/v1.0/deleteNote/"+noteId+"?p_auth=" + Liferay.authToken,
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


</script>
