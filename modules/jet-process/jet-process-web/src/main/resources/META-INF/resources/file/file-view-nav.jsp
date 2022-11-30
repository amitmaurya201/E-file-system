<%@page import="java.util.List"%>
<%@ include file="../init.jsp" %>


<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import ="io.jetprocess.masterdata.service.UserPostLocalServiceUtil" %>
<%@ page import="io.jetprocess.masterdata.model.UserPost" %>

<style>

.border a{
	border-right: 1px solid #a19c9c;
	
}


 @media all and (min-width: 992px) {
	.navbar .nav-item .dropdown-menu{ display: none; }
	.navbar .nav-item:hover .nav-link{   }
	.navbar .nav-item:hover .dropdown-menu{ display: block; }
	.navbar .nav-item .dropdown-menu{ margin-top:0;}
}
</style>



<portlet:renderURL var="movement">
    <portlet:param name="mvcPath" value="/file/movement.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="details">
    <portlet:param name="mvcPath" value="/file/details.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="edit">
    <portlet:param name="mvcPath" value="/file/edit-file.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="send">
    <portlet:param name="mvcPath" value="/file/send.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="sendback">
    <portlet:param name="mvcPath" value="/file/sendback.jsp"/>
</portlet:renderURL>
<%-- <portlet:renderURL var="dispatch">
    <portlet:param name="mvcPath" value="/file/dispatch.jsp"/>
</portlet:renderURL>
<portlet:renderURL var="convert">
    <portlet:param name="mvcPath" value="/file/convert.jsp"/>
</portlet:renderURL> --%>
<portlet:renderURL var="option1">
    <portlet:param name="mvcPath" value="/file/option1.jsp"/>
</portlet:renderURL>





<nav class="navbar navbar-expand-lg navbar-light  mt-3 mb-3 " style=" background-color: #ede8e8;
  border-top: 2px solid #a19c9c;
  border-top-left-radius:5px;
  border-top-right-radius:5px;">
  
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item border " >
        <a class="nav-link" href="#"><i class="fa fa-tasks"></i></a>
      </li>
      <li class="nav-item border ">
        <a id="movement" class="nav-link" href="<%= movement %>">Movement</a>
      </li>
      <li class="nav-item border ">
        <a id="details" class="nav-link" href="<%= details %>">Details</a>
      </li>
      <li class="nav-item dropdown border ">
        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
          Draft <i class="fa fa-caret-down"></i>
        </a>
        <div class="dropdown-menu ">
          <a id="option1" class="dropdown-item" href="<%= option1 %>">Option1</a>
          <a class="dropdown-item" href="#">Option2</a>
          <a class="dropdown-item" href="#">Option3</a>
        </div>
      </li>
      <li class="nav-item border">
        <a id="edit" class="nav-link" href="<%= edit %>">Edit</a>
      </li>
      <li class="nav-item border">
        <a id="send" class="nav-link" href="<%= send %>">Send</a>
      </li>
      <li class="nav-item border">
        <a id="sendback" class="nav-link" href="<%= sendback %>">Send Back</a>
      </li>
      <li class="nav-item dropdown border">
        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
          Link <i class="fa fa-caret-down"></i>
        </a>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="<%= option1 %>">Option1</a>
          <a class="dropdown-item" href="#">Option2</a>
          <a class="dropdown-item" href="#">Option3</a>
        </div>
      </li>
      <li class="nav-item dropdown border">
        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
          Attach <i class="fa fa-caret-down"></i>
        </a>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="<%= option1 %>">Option1</a>
          <a class="dropdown-item" href="#">Option2</a>
          <a class="dropdown-item" href="#">Option3</a>
        </div>
      </li>
      <li class="nav-item dropdown border">
        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
          Park <i class="fa fa-caret-down"></i>
        </a>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="<%= option1 %>">Option1</a>
          <a class="dropdown-item" href="#">Option2</a>
          <a class="dropdown-item" href="#">Option3</a>
        </div>
      </li>
      <li class="nav-item dropdown border">
        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
          Close <i class="fa fa-caret-down"></i>
        </a>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="<%= option1 %>">Option1</a>
          <a class="dropdown-item" href="#">Option2</a>
          <a class="dropdown-item" href="#">Option3</a>
        </div>
      </li>
      <%-- <li class="nav-item border">
        <a class="nav-link" href="<%= dispatch %>">Dispatch</a>
      </li>
      <li class="nav-item border">
        <a class="nav-link" href="<%= convert %>">Convert</a>
      </li> --%>
      <li class="nav-item dropdown border">
        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
          More <i class="fa fa-caret-down"></i>
        </a>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="<%= option1 %>">Option1</a>
          <a class="dropdown-item" href="#">Option2</a>
          <a class="dropdown-item" href="#">Option3</a>
        </div>
      </li>
      
      
    </ul>
    <div class="nav-item d-flex " >
        <a class="nav-link  align-end bg-primary" Style="border-radius:5px;margin-right:5px;" href="#" ><i class="fa fa-print" style="color:white;" aria-hidden="true"></i></a>
      </div>
    
  </div>
</nav>


<%-- <%

 if(themeDisplay.isSignedIn()){
 List<UserPost> userPostList =UserPostLocalServiceUtil.getUserPostList(user.getUserId());
 for(UserPost userPosts:userPostList){
 long id=userPosts.getUserPostId();
 String name=userPosts.getShortName();
  out.println("userPostId--> "+id);
  out.println("userPostName--> "+name);
 %> 


<form action="">  
	<input type="text" name="uname" value="<%= id%>">  
	<input type="text" value="${userPostId}"><br/>  
</form>  

<% }}%>
 --%>



<script>
var navId = "${param.selectedNav}";
var nav = document.getElementById(navId);

nav.style.color = 'blue';


</script>


