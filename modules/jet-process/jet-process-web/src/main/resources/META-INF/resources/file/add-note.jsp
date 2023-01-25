<script src="https://cdn.ckeditor.com/4.20.1/standard/ckeditor.js"></script>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<style>
 textarea {
  background-color : #bef8c7;
  

}
.saveButton{
background-color: DodgerBlue;
  border: none;
  color: white;
  padding: 2px 6px;
  font-size: 16px;
  cursor: pointer;
  border-radius: 50%;
}
.deleteButton{
background-color: DodgerBlue;
  border: none;
  color: white;
  padding: 2px 6px;
  font-size: 16px;
  cursor: pointer;
  border-radius: 50%;
}


</style>

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
			<button  id="removeNote" type="button" class="deleteButton" data-toggle="modal" data-target="#exampleModal">
			<i class="fa fa-trash"></i>
			</button>
			<button type="button" id= "addNoteButton" class="saveButton" >
		<i class="fa fa-save"></i>
			</button>
			</div>	
         	<input name = "noteId" id = "noteId" value = "0" type= "hidden"/>
         	<c:set var ="note" scope ="session" value = "${noteObj}" />
         	<c:if test = "${ empty note.noteId }">
         	<textarea id = "content" name="content"></textarea>
         	</c:if>
         	<c:if test ="${not empty note }">
         	<textarea id = "content" name="content">${note.content}</textarea>
         	</c:if>
			
		</div>
	</aui:form>
	
</div>

<br>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
      <p>Are you sure you want to delete ?</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" id = "cancel" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary" id = "deleteNote" onClick ="removeNote()" >Ok</button>
      </div>
    </div>
  </div>
</div>



<script>
var viewMode = "${param.viewMode}";
if (viewMode == 'ViewModeFromSentRecipt') {
	$('#note').css("display", "none");
}
</script>