<!DOCTYPE html>
<%@page import="io.jetprocess.web.constants.MVCCommandNames"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<link rel="stylesheet"
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
<style>
/* body {font-family: "Lato", sans-serif;} */

/* #side-nav{
	margin-right: -12px !important;
} */

.side-nav {
	padding: 5px;
	position: sticky;
	top: 0;
	/* width: 15%;
          position: fixed;
          z-index: 1;
          padding-top: 10%;
          left: 0; */
	background-color: #345686;
	/* overflow-x: hidden; */
	color: white;
}

.side-nav a {
	text-align: center;
	margin: 5px;
	text-decoration: none;
	font-size: 18px;
	color: white;
	display: block;
	line-height: 35px;
	border: 2px solid #819394;
	border-radius: 30px;
	background: #2f466e;
}

.side-nav a:hover {
	color: #f1f1f1;
}

.side-nav .dropdown-container {
	padding-left: 30px;
}

.side-nav .dropdown-container a {
	background: #1d4f3d;
}

/*         .main {
          margin-left: 160px; /* Same as the width of the sidenav */
/* padding: 0px 10px;
        }*/

/*@media screen and (max-height: 450px) {
          .sidebar {padding-top: 15px;}
          .sidebar a {font-size: 18px;}
        }
 */
</style>
</head>
<body id="side-nav">
	<portlet:renderURL var="view">
		<portlet:param name="mvcRenderCommandName" value="/home" />
		<portlet:param name="selectedNav" value="home" />
	</portlet:renderURL>
	<portlet:renderURL var="createFile">
		<portlet:param name="mvcRenderCommandName" value="/createFile1" />
		<portlet:param name="selectedNav" value="createFile" />
	</portlet:renderURL>
	<portlet:renderURL var="createdFileList">
		<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.VIEW_FILELIST %>" />
		<portlet:param name="selectedNav" value="fileList" />
	</portlet:renderURL>
	<portlet:renderURL var="createReceipt">
		<portlet:param name="mvcRenderCommandName" value="/createReceipt" />
		<portlet:param name="selectedNav" value="createReceipt" />
	</portlet:renderURL>
	<portlet:renderURL var="createdListReceipt">
		<portlet:param name="mvcRenderCommandName" value="/createdListReceipt" />
		<portlet:param name="selectedNav" value="receiptList" />
	</portlet:renderURL>
	
	<portlet:renderURL var="fileInbox">
		<portlet:param name="mvcRenderCommandName" value="/fileInBox" />
		<portlet:param name="selectedNav" value="fileInbox" />
	</portlet:renderURL>
	<portlet:renderURL var="receiptInbox">
		<portlet:param name="mvcRenderCommandName" value="/receiptInBox" />
		<portlet:param name="selectedNav" value="receiptInbox" />
	</portlet:renderURL>
	<portlet:renderURL var="fileSent">
		<portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.FILE_SEND_RENDER_COMMAND %>" />
		<portlet:param name="selectedNav" value="fileSent" />
	</portlet:renderURL>
	<portlet:renderURL var="receiptSent">
		  <portlet:param name="mvcRenderCommandName" value="<%=MVCCommandNames.RECEIPT_SENT_LIST %>" />
		<portlet:param name="selectedNav" value="receiptSent" />
	</portlet:renderURL>

	<div class="side-nav">
		<a id="home" href="<%=view%>"><i class="fa fa-fw fa-home"></i> Home</a> <a
			class="dropdown-btn"><i class="fa fa-file" aria-hidden="true"></i>File
			<i class="fa fa-caret-down"></i> </a>
		<div class="dropdown-container ">
			<a id="createFile" href="<%=createFile%>">Create File</a>
			<a id="fileList" href="<%=createdFileList%>">Created List</a>
			<a id="fileInbox" href="<%=fileInbox%>">Inbox</a>
			<a id="fileSent" href="<%=fileSent%>">Sent</a>

		</div>
		<a class="dropdown-btn"><i class='fas fa-receipt'
			style='font-size: 24px'></i> Receipt <i class="fa fa-caret-down"></i>
		</a>
		<div class="dropdown-container ">
			<a id="createReceipt" href="<%=createReceipt%>">Create Receipt</a>
			<a id="receiptList" href="<%=createdListReceipt%>">Created List</a>
			<a id="receiptInbox" href="<%=receiptInbox%>">Inbox</a>
			<a id="receiptSent" href="<%=receiptSent%>">Sent</a>

		</div>

	</div>



	<script>
		/* Loop through all dropdown buttons to toggle between hiding and showing its dropdown content - This allows the user to have multiple dropdowns without any conflict */
		var dropdown = document.getElementsByClassName("dropdown-btn");
		var i;

		for (i = 0; i < dropdown.length; i++) {
			dropdown[i].addEventListener("click", function() {
				this.classList.toggle("active");
				var dropdownContent = this.nextElementSibling;
				if (dropdownContent.style.display == "block") {
					dropdownContent.style.display = "none";
				} else {
					dropdownContent.style.display = "block";

				}
			});
		}
		
		/* var navId = "${param.selectedNav}";
		var nav = document.getElementById(navId);

		nav.style.color = 'blue'; */
	</script>

</body>
</html>