<%@page import="io.jetprocess.web.constants.MVCCommandNames"%>
<%@ include file="../init.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="/common/common.jsp"%>

<style>
@media all and (min-width: 992px) {
	.navbar .nav-item .dropdown-menu {
		display: none;
	}
	.navbar .nav-item:hover .nav-link {
		
	}
	.navbar .nav-item:hover .dropdown-menu {
		display: block;
	}
	.navbar .nav-item .dropdown-menu {
		margin-top: 0;
	}
}

.border li a {
	border-right: 1px solid #a19c9c;
	font-weight: 700;
}
</style>

<%
	String receiptId = renderRequest.getParameter("receiptId");
String curr = (String)session.getAttribute("currentURL");


%>
<portlet:renderURL var="details">
	<portlet:param name="mvcRenderCommandName" value="/receiptView" />
	<portlet:param name="receiptId" value="<%=receiptId%>" />
		        <portlet:param name="backPageURL" value="<%= curr %>"/>
	
</portlet:renderURL>

<portlet:renderURL var="movementRenderURL">
	<%-- 	<portlet:param name="mvcPath" value="/receipt/movement.jsp" /> --%>
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommandNames.RECEIPT_MOVEMENT_RENDER_COMMAND%>" />
	<portlet:param name="receiptId" value="<%=receiptId%>" />
		        <portlet:param name="backPageURL" value="<%= curr %>"/>
	
</portlet:renderURL>

<portlet:renderURL var="send">
	<portlet:param name="mvcRenderCommandName"
		value="<%=MVCCommandNames.RECEIPT_SEND_RENDER_COMMAND%>" />
	<portlet:param name="receiptId" value="<%=receiptId%>" />
		        <portlet:param name="backPageURL" value="<%= curr %>"/>
	
</portlet:renderURL>
<portlet:renderURL var="sendBack">
	<portlet:param name="mvcPath" value="/receipt/send_back.jsp" />
</portlet:renderURL>
<portlet:renderURL var="putFile">
	<portlet:param name="mvcPath" value="/receipt/put_in_a_file.jsp" />
</portlet:renderURL>
<portlet:renderURL var="edit">
	<portlet:param name="mvcRenderCommandName" value="/editReceipt" />
	<portlet:param name="receiptId" value="<%=receiptId%>" />
		        <portlet:param name="backPageURL" value="<%= curr %>"/>
	
</portlet:renderURL>
<portlet:renderURL var="dispatch">
	<portlet:param name="mvcPath" value="/receipt/dispatch.jsp" />
</portlet:renderURL>
<portlet:renderURL var="actionDetails">
	<portlet:param name="mvcPath" value="/receipt/action_details.jsp" />
</portlet:renderURL>
<portlet:renderURL var="attach">
	<portlet:param name="mvcPath" value="/receipt/attach.jsp" />
</portlet:renderURL>

<nav class="navbar navbar-expand-lg navbar-light mt-1"
	style="background-color: #ddd; border-top: 2px solid #a19c9c; border-top-left-radius: 5px; border-top-right-radius: 5px;">
	<!-- <div class="container-fluid"> -->
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#main_nav" aria-controls="main_nav" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>
	<div class=" navbar-collapse" id="main_nav">
		<ul class="navbar-nav border">
			<li class="nav-item "><a id="details" class="nav-link "
				href="<%=details%>">Details </a></li>
			<li class="nav-item"><a id="movement" class="nav-link "
				href="<%=movementRenderURL%>"> Movement </a></li>
			<li class="nav-item"><a id="send" class="nav-link "
				href="<%=send%>"> Send </a></li>
			<li class="nav-item"><a id="sendback" class="nav-link "
				href="<%=sendBack%>"> Send Back </a></li>
			<li class="nav-item"><a id="putFile" class="nav-link "
				href="<%=putFile%>"> Put in a file </a></li>
			<li class="nav-item"><a id="dispatch" class="nav-link "
				href="<%=dispatch%>">Dispatch</a></li>
			<li class="nav-item"><a id="edit" class="nav-link "
				href="<%=edit%>"> Edit </a></li>
			<li class="nav-item"><a id="actionDetails" class="nav-link "
				href="<%=actionDetails%>"> Action Details </a></li>
			<li class="nav-item dropdown"><a
				class="nav-link  dropdown-toggle" href="#" data-bs-toggle="dropdown">Attach<i
					class="fa fa-caret-down"></i>

			</a>
				<ul class="dropdown-menu">
					<li><a class="dropdown-item" href="<%=attach%>"> Submenu
							item 1</a></li>
					<li><a class="dropdown-item" href="#"> Submenu item 2 </a></li>
					<li><a class="dropdown-item" href="#"> Submenu item 3 </a></li>
				</ul></li>

		</ul>
		<div class="nav-item d-flex ">
			<a class="nav-link  align-end bg-primary" Style="border-radius: 5px;"
				href="#"><i class="fa fa-print" style="color: white;"
				aria-hidden="true"></i></a>
		</div>
	</div>
	<!-- </div> -->
</nav>

<script>
	var navId = "${param.selectedNav}";
	var nav = document.getElementById(navId);

	nav.style.color = 'blue';
</script>
