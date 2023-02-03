<%@page import="java.util.Date"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.TimeZone"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="io.jetprocess.list.model.NoteDTO"%>
<%@page import="java.util.List"%>
<script src="https://cdn.ckeditor.com/4.20.1/standard/ckeditor.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<style>
textarea {
	background-color: #bef8c7;
}

.saveButton {
	background-color: DodgerBlue;
	border: none;
	color: white;
	padding: 2px 6px;
	font-size: 16px;
	cursor: pointer;
	border-radius: 50%;
}

.deleteButton {
	background-color: DodgerBlue;
	border: none;
	color: white;
	padding: 2px 6px;
	font-size: 16px;
	cursor: pointer;
	border-radius: 50%;
}
</style>


<div style="background-color: #bef8c7; height: 400px" id="mydiv">
	<img src='<%=request.getContextPath() + "/image/note.png"%>' width="8%"
		id="note" height="30"
		class="shadow m-1 bg-white rounded-circle addtoggle " />
	<!-- onclick="openNote()" -->
	<div id="notes" class="g" style="display: none;">
		<img src='<%=request.getContextPath() + "/image/green-note.jpg"%>'
			width="8%" height="30" class="shadow m-1 bg-white rounded-circle"
			onclick="openGreenNote()" /> <br /> <img
			src='<%=request.getContextPath() + "/image/yellow-note.jpg"%>'
			width="8%" height="30" class="shadow m-1 bg-white rounded-circle"
			onclick="openYellowNote()" />
	</div>
	<aui:form name="addNote">
		<%-- <aui:input name="fileMovementId" type="hidden" value="<%= movementId%>"/>
	 --%>
		<div id="editor" style="display: none;">
			<div style="background-color: green;">
				<button id="removeNote" type="button" class="deleteButton"
					data-toggle="modal" data-target="#exampleModal">
					<i class="fa fa-trash"></i>
				</button>
				<button type="button" id="addNoteButton" class="saveButton">
					<i class="fa fa-save"></i>
				</button>
			</div>

			<c:set var="note" scope="session" value="${noteObj}" />
			<c:if test="${ empty note.noteId }">
				<input name="noteId" id="noteId" value="0" type="hidden" />
				<textarea id="content" name="content"></textarea>
			</c:if>
			<c:if test="${not empty note }">
				<input name="noteId" id="noteId" value="${note.noteId }"
					type="hidden">
				<textarea id="content" name="content">${noteContent}</textarea>
			</c:if>

		</div>

	</aui:form>
	<%-- <c:forEach items = "${noteList}" var ="name" varStatus="theCount" >
			<div style="height:auto; border-color: gray;  box-shadow: 0 4px 4px 0 rgba(0, 0, 0, 0.1), 0 2px 0px 0 rgba(0, 0, 0, 0.10);">
		 Note #<c:out value = "${theCount.count }"></c:out>
		 <br>
		 <c:out value = "${name.createDate }"></c:out>
		<c:out value = "${name.signature}"></c:out>
		 <c:forEach items = "${name.signature }" var = "signature">
		 <c:out value = "${signature}"></c:out>
		 </c:forEach>
	</div>
			</c:forEach> --%>


	<% List<NoteDTO> note =(List <NoteDTO>)request.getAttribute("noteList");
		System.out.println("noteist"+note);
		if(note!=null){
			int i = 1;
			for(NoteDTO noteDTO : note){
				JSONObject object = JSONFactoryUtil.createJSONObject(noteDTO.getSignature());
				System.out.println("note------"+object);
				%>
	<div
		style="height: auto;  padding :0px 10px; border-color: gray; box-shadow: 0 4px 4px 0 rgba(0, 0, 0, 0.1), 0 2px 0px 0 rgba(0, 0, 0, 0.10);">
		<b>Note # <%=i %></b> <br>
		<div class="container">
			<%=noteDTO.getContent() %>
		</div>

		<div>
			<c:set var="now" value="<%= noteDTO.getCreateDate() %>" />
			<fmt:formatDate type="both" dateStyle="short" timeStyle="short"
				value="${now}" />
			<span style="float: right;"> <%=object.get("userName")%></span>

			<p style="text-align: right;">

				<span><%= object.get("departmentName")%></span> <span><%= object.get("postMarking") %></span>
			</p>
		</div>




	</div>
	<%
			  i++;
			} 
			
		}
		%>
</div>

<br>


<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog"
	aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog" role="document">
		<div class="modal-content">
			<div class="modal-header">
				<h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
				<button type="button" class="close" data-dismiss="modal"
					aria-label="Close">
					<span aria-hidden="true">&times;</span>
				</button>
			</div>
			<div class="modal-body">
				<p>Are you sure you want to delete ?</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-secondary" id="cancel"
					data-dismiss="modal">Close</button>
				<button type="button" class="btn btn-primary" id="deleteNote"
					onClick="removeNote()">Ok</button>
			</div>
		</div>
	</div>
</div>



<script>
var viewMode = "${param.viewMode}";
if (viewMode == 'ViewModeFromSentFile') {
	$('#note').removeClass("addtoggle");
}
jQuery('#mydiv').css("overflow-y", "scroll");

/* for toggle note icon  */
$(document).ready(function(){
	$(".addtoggle").click(function(){
	   $("#notes").toggle();
	 });
	});

</script>