<%@ include file="../init.jsp" %>
<%@ include file="../navigation.jsp" %>
<%@ page isELIgnored = "false" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inner Receipt View</title>
<style>
 @media all and (min-width: 992px) {
	.navbar .nav-item .dropdown-menu{ display: none; }
	.navbar .nav-item:hover .nav-link{   }
	.navbar .nav-item:hover .dropdown-menu{ display: block; }
	.navbar .nav-item .dropdown-menu{ margin-top:0; }
} 
</style>
</head>
<body>
<portlet:renderURL var="home">
<portlet:param name="mvcPath" value="/receipt/receipt_view.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="movementRenderURL">
<portlet:param name="mvcPath" value="/receipt/movement.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="copy">
<portlet:param name="mvcPath" value="/receipt/copy.jsp"/>
</portlet:renderURL>

<portlet:renderURL var="send">
	<portlet:param name="mvcPath" value="/receipt/send.jsp" />
</portlet:renderURL>
<portlet:renderURL var="sendBack">
	<portlet:param name="mvcPath" value="/receipt/send_back.jsp" />
</portlet:renderURL>
<portlet:renderURL var="putFile">
	<portlet:param name="mvcPath" value="/receipt/put_in_a_file.jsp" />
</portlet:renderURL>
<portlet:renderURL var="draft">
	<portlet:param name="mvcPath" value="/receipt/draft.jsp" />
</portlet:renderURL>
<portlet:renderURL var="edit">
    <portlet:param name="mvcRenderCommandName" value="/createReceipt"/>
</portlet:renderURL>

<portlet:renderURL var="actionDetails">
	<portlet:param name="mvcPath" value="/receipt/action_details.jsp" />
</portlet:renderURL>
<portlet:renderURL var="attach">
	<portlet:param name="mvcPath" value="/receipt/attach.jsp" />
</portlet:renderURL>
<portlet:renderURL var="close">
	<portlet:param name="mvcPath" value="/receipt/close.jsp" />
</portlet:renderURL>

<nav class="navbar navbar-expand-lg navbar-light mt-1" style=" background-color: #ddd;
 
  border-top: 2px solid #a19c9c;
  border-top-left-radius:5px;
  border-top-right-radius:5px;
  margin-left: -85px;">
 <div class="container-fluid">
  <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#main_nav"  aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="main_nav">
	<ul class="navbar-nav">
		<li class="nav-item"> <a class="nav-link text-black" style="font-weight: 700; border-right: 1px solid #a19c9c;" href="<%= home %>"><span id="home"><b>Home </b></span></a> </li>
		<li class="nav-item"><a class="nav-link text-black" style="font-weight: 700; border-right: 1px solid #a19c9c;"  href="<%= movementRenderURL %>"><span id="movement"><b> Movement </b></span></a></li>
		<li class="nav-item"><a class="nav-link text-black" style="font-weight: 700; border-right: 1px solid #a19c9c;"  href="<%= copy %>"><span id="copy"><b> Copy </b></span></a></li>
		<li class="nav-item"><a class="nav-link text-black"  style="font-weight: 700; border-right: 1px solid #a19c9c;" href="<%=send%>"><span id="send"><b> Send </b></span></a></li>
		<li class="nav-item"><a class="nav-link text-black" style="font-weight: 700; border-right: 1px solid #a19c9c;"  href="<%=sendBack%>"><span id="sendBack"><b> Send Back</b></span> </a></li>
		<li class="nav-item"><a class="nav-link text-black" style="font-weight: 700; border-right: 1px solid #a19c9c;"  href="<%=putFile%>"><span id="putFile"><b> Put in a file</b></span> </a></li>
		<li class="nav-item dropdown">
		   <a class="nav-link  dropdown-toggle" href="#" data-bs-toggle="dropdown" style="font-weight: 700; border-right: 1px solid #a19c9c;"><span id="draft"><b>  Draft  <i class="fa fa-caret-down"></i></b></span>
		   	</a>
		    <ul class="dropdown-menu">
			  <li><a class="dropdown-item" href="<%=draft%>"> Submenu item 1</a></li>
			  <li><a class="dropdown-item" href="#"> Submenu item 2 </a></li>
			  <li><a class="dropdown-item" href="#"> Submenu item 3 </a></li>
		    </ul>
		</li>
		<li class="nav-item"><a class="nav-link text-black" style="font-weight: 700; border-right: 1px solid #a19c9c;"  href="<%=edit %>"><span id="edit"><b> Edit </b></span></a></li>
		<li class="nav-item"><a class="nav-link text-black" style="font-weight: 700; border-right: 1px solid #a19c9c;"  href="<%=actionDetails%>"><span id="actionDetails"><b> Action Details </b></span></a></li>
		<li class="nav-item dropdown">
		   <a class="nav-link  dropdown-toggle" href="#" data-bs-toggle="dropdown" style="font-weight: 700; border-right: 1px solid #a19c9c;"><span id="attach"><b>  Attach  <i class="fa fa-caret-down"></i></b></span>
		   	</a>
		    <ul class="dropdown-menu">
			  <li><a class="dropdown-item" href="<%=attach%>"> Submenu item 1</a></li>
			  <li><a class="dropdown-item" href="#"> Submenu item 2 </a></li>
			  <li><a class="dropdown-item" href="#"> Submenu item 3 </a></li>
		    </ul>
		</li>
		
		<li class="nav-item"><a class="nav-link text-black" style="font-weight: 700; border-right: 1px solid #a19c9c;"  href="<%=close%>"><span id="close"><b> close </b></span></a></li>
	</ul>
	<div class="nav-item d-flex " >
        <a class="nav-link  align-end bg-primary" Style="border-radius:5px;" href="#" ><i class="fa fa-print" style="color:white;" aria-hidden="true"></i></a>
      </div>
  </div>
 </div> 
</nav>

<script>
/*  var uId = "${userPostId}";
console.log("userpostId ----> "+ uId); */ 
var navId = "${param.selectedNav}";
var nav = document.getElementById(navId);
nav.style.color = 'black';


</script>

</body>
</html>