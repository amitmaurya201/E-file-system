
<aui:script>

$("#ShowAndHideDetachModalPopup").hide();
$("#detach-conformation").on('click', function(){
	$("#ShowAndHideDetachModalPopup").show();
});
var intervalID;
$( ".control-label" ).remove();
var greenNoteContentOnchange= " ";
var yellowNoteContentOnchange = " ";
var greenNoteContent = `${greenNoteContent}`;
console.log("greenNoteContent"+greenNoteContent);
var yellowNoteContent = `${yellowNoteContent}`;
console.log("yellowNoteContent"+yellowNoteContent);
if(greenNoteContent==''){
	$("#green-note-header").css("background-color","#960018");	
}
else{
	$("#green-note-header").css("background-color","green");
}
if(yellowNoteContent==''){
	$("#yellow-note-header").css("background-color","#960018");	
}
else{
	$("#yellow-note-header").css("background-color","green");
}
function openNote() {
	const notes = document.getElementById("notes");
	notes.style.display = "block";
}
function openGreenNote() {
	console.log("greenintervalID"+intervalID);
	clearInterval(intervalID);
	const notes = document.getElementById("notes");
	const note = document.getElementById("note");
	const greenEditor = document.getElementById("green-editor");
	const yellowEditor = document.getElementById("yellow-editor");
	notes.style.display = "block";
	note.style.display = "none";
	yellowEditor.style.display = "none";
	greenEditor.style.display = "block";
	intervalID=setInterval(saveGreenNoteContent, 10000);
	console.log("intervalID"+intervalID);	
	
	}

function openYellowNote() {
	console.log("yellowintervalID"+intervalID);
	clearInterval(intervalID);
	const notes = document.getElementById("notes");
	const note = document.getElementById("note");
	const greenEditor = document.getElementById("green-editor");
	const yellowEditor = document.getElementById("yellow-editor");
	note.style.display = "none";
	greenEditor.style.display = "none";
	/* editor.style.display = "block"; */
	yellowEditor.style.display = "block";
	/* intervalID=setInterval(); */
	intervalID=setInterval(saveYellowNoteContent, 10000);
	console.log("intervalID"+intervalID);
	
	
}

function <portlet:namespace/>greenBackgroundEditor(){
	var editor = CKEDITOR.instances["<portlet:namespace/>green-note-content"];
	var iframeBody=editor.document.$.body;
	$(iframeBody).attr("style", "background-color:#bef8c7 !important");	
}
function <portlet:namespace/>yellowBackgroundEditor(){
	var editor = CKEDITOR.instances["<portlet:namespace/>yellow-note-content"];
	var iframeBody=editor.document.$.body;
	$(iframeBody).attr("style", "background-color:#fcffa4 !important");	
}

 function <portlet:namespace/>yellowClickHandler() {
	 yellowNoteContentOnchange = CKEDITOR.instances["<portlet:namespace/>yellow-note-content"].getData();
	 if(yellowNoteContent!=yellowNoteContentOnchange){
	$("#yellow-note-header").css("background-color","#960018");
	 }
}
 function <portlet:namespace/>greenClickHandler() {
	 greenNoteContentOnchange = CKEDITOR.instances["<portlet:namespace/>green-note-content"].getData();
	 console.log("greenNoteContentOnchange"+greenNoteContentOnchange);
	 if(greenNoteContent!=greenNoteContentOnchange){
	$("#green-note-header").css("background-color","#960018");
	 }
}
 function deleteNote(noteId){
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
	 
 }
 $("#removeGreenNote").on('click',function(){
	 console.log("green note test");
	 document.getElementById("deleteGreenNote").style.display="block";
	 document.getElementById("deleteYellowNote").style.display="none";
	 
 })
 $("#removeYellowNote").on('click', function(){
	 console.log("yellow note test");
	 document.getElementById("deleteGreenNote").style.display="none";
	 document.getElementById("deleteYellowNote").style.display="block";
 })

 var userPostId = $('#<portlet:namespace />userPostsVal').val();
 $("#deleteGreenNote").on('click', function(e){
	 console.log("delete green note");
	 var noteId = $('#greenNoteId').val();
	 console.log("noteId G" +noteId);
	 deleteNote(noteId);
	
});
 $("#deleteYellowNote").on('click', function(e){
	 console.log("delete yellow note");
	 var noteId = $('#yellowNoteId').val();
	 console.log("noteId y "+noteId);
	 deleteNote(noteId);
	
});
	
var noteId = '${greenFileNote.noteId }';
if(noteId>0 && viewMode != 'ViewModeFromSentFile'){
	openGreenNote();
}

 function saveGreenNoteContent() {
	 if(greenNoteContent!=greenNoteContentOnchange ){
	var greenNoteData = CKEDITOR.instances["<portlet:namespace/>green-note-content"].getData();
	 if(greenNoteData==''){
		 $("#green-note-header").css("background-color","#960018");
	 }
	 var fileId = $('#docFileId').val();
	 console.log(fileId);
	 var fileMovementId = $('#fileMovementId').val();
	 var noteId = $('#greenNoteId').val();
	 console.log("green noteId"+noteId);
	 var object = {};
	 var jsonData = object;
	 jsonData["createdBy"]=userPostId;
	 jsonData["fileId"] = fileId;
	 jsonData["content"] = greenNoteData;
	 jsonData["noteId"] =noteId;
	 jsonData["hasYellowNote"] = false;
	 jsonData["fileMovementId"] =fileMovementId;
	 var jsonObj = JSON.stringify(jsonData);
	 console.log("test");
	 $.ajax({
		 type:"POST",
		 url:"${portalURL}/o/jet-process-rs/v1.0/createNote?p_auth=" + Liferay.authToken,
		 data:jsonObj,
		 dataType: 'json',
		 cache : false,
		 processData: false,
	     contentType : 'application/json'
	 }).done(function(response){
		 console.log("greenresult"+response);
		 greenNoteContent=greenNoteContentOnchange;
		var noteId = response.noteId;
		 $("#green-note-header").css("background-color","green");
		 $('#green-note-header').load(' #green-note-header');
		 $( "#greenNoteId" ).val(noteId);	
		
	 })
	}
 }

 function saveYellowNoteContent() {
	 if(yellowNoteContent!=yellowNoteContentOnchange ){
	 var yellowNoteData = CKEDITOR.instances["<portlet:namespace/>yellow-note-content"].getData();
	 if(yellowNoteData==''){
		 $("#yellow-note-header").css("background-color","#960018");
	 }
	 var fileId = $('#docFileId').val();
	 console.log(fileId);
	 var fileMovementId = $('#fileMovementId').val();
	 var noteId = $('#yellowNoteId').val();
	 console.log("yellow noteId"+noteId);
	 var object = {};
	 var jsonData = object;
	 jsonData["createdBy"]=userPostId;
	 jsonData["fileId"] = fileId;
	 jsonData["content"] = yellowNoteData;
	 jsonData["noteId"] =noteId;
	 jsonData["hasYellowNote"] = true;
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
		 console.log("yellowresult"+response);
		 yellowNoteContent=yellowNoteContentOnchange;
		var noteId = response.noteId;
		 $("#yellow-note-header").css("background-color","green");
		 $('#yellow-note-header').load(' #yellow-note-header');
		 $( "#yellowNoteId").val(noteId);	
		
	 })
	}
	
}
</aui:script>