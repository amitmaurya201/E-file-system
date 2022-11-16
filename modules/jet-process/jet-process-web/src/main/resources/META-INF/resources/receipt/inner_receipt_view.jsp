<%@ include file="../init.jsp" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inner Receipt View</title>
<style>
.navbar-nav .nav-item .nav-link ul li a {
  color:black;
  border-right: 1px solid #a19c9c;
}

@media all and (min-width: 992px) {
	.navbar .nav-item .dropdown-menu{ display: none; }
	.navbar .nav-item:hover .nav-link{   }
	.navbar .nav-item:hover .dropdown-menu{ display: block; }
	.navbar .nav-item .dropdown-menu{ margin-top:0; }
}
</style>
</head>
<body>
<portlet:renderURL var="createReceipt">
    <portlet:param name="mvcRenderCommandName" value="/createReceipt"/>
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
		<li class="nav-item active"> <a class="nav-link text-black" style="font-weight: 700; border-right: 1px solid #a19c9c;" href="#">Home </a> </li>
		<li class="nav-item"><a class="nav-link text-black" style="font-weight: 700; border-right: 1px solid #a19c9c;"  href="#"> Movement </a></li>
		<li class="nav-item"><a class="nav-link text-black"  style="font-weight: 700; border-right: 1px solid #a19c9c;" href="#"> Send </a></li>
		<li class="nav-item"><a class="nav-link text-black" style="font-weight: 700; border-right: 1px solid #a19c9c;"  href="#"> Send Back </a></li>
		<li class="nav-item"><a class="nav-link text-black" style="font-weight: 700; border-right: 1px solid #a19c9c;"  href="#"> Put in a fil </a></li>
		<li class="nav-item"><a class="nav-link text-black" style="font-weight: 700; border-right: 1px solid #a19c9c;"  href="#">Dispatch</a></li>
		<li class="nav-item"><a class="nav-link text-black" style="font-weight: 700; border-right: 1px solid #a19c9c;"  href="<%=createReceipt %>"> Edit </a></li>
		<li class="nav-item"><a class="nav-link text-black" style="font-weight: 700; border-right: 1px solid #a19c9c;"  href="#"> Action Details </a></li>
		<li class="nav-item dropdown">
		   <a class="nav-link  dropdown-toggle" href="#" data-bs-toggle="dropdown" style="font-weight: 700; border-right: 1px solid #a19c9c;">  Attach
		   
  			</a>
		    <ul class="dropdown-menu">
			  <li><a class="dropdown-item" href="#"> Submenu item 1</a></li>
			  <li><a class="dropdown-item" href="#"> Submenu item 2 </a></li>
			  <li><a class="dropdown-item" href="#"> Submenu item 3 </a></li>
		    </ul>
		</li>
	</ul>
  </div>
 </div> 
</nav>

</body>
</html>