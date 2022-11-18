<%@ include file="../init.jsp" %>
<%@ include file="../navigation.jsp"%>

<style>

.border a{
	border-right: 1px solid #a19c9c;
	
}


/* @media all and (min-width: 992px) {
	.navbar .nav-item .dropdown-menu{ display: none; }
	.navbar .nav-item:hover .nav-link{   }
	.navbar .nav-item:hover .dropdown-menu{ display: block; }
	.navbar .nav-item .dropdown-menu{ margin-top:0; }
} */
</style>



<portlet:renderURL var="movement">
    <portlet:param name="jspPage" value="/list/movement.jsp"/>
</portlet:renderURL>

<nav class="navbar navbar-expand-lg navbar-light  mt-3 mb-3 " style=" background-color: #ede8e8;
  border-top: 2px solid #a19c9c;
  border-top-left-radius:5px;
  border-top-right-radius:5px;
  margin-left: -85px;">
  
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item border " >
        <a class="nav-link" href="#"><i class="fa fa-tasks"></i></a>
      </li>
      <li class="nav-item border ">
        <a class="nav-link" href="<%= movement %>">Movement</a>
      </li>
      <li class="nav-item border ">
        <a class="nav-link" href="#">Details</a>
      </li>
      <li class="nav-item dropdown border ">
        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
          Draft <i class="fa fa-caret-down"></i>
        </a>
        <div class="dropdown-menu ">
          <a class="dropdown-item" href="#">Option1</a>
          <a class="dropdown-item" href="#">Option2</a>
          <a class="dropdown-item" href="#">Option3</a>
        </div>
      </li>
      <li class="nav-item border">
        <a class="nav-link" href="#">Edit</a>
      </li>
      <li class="nav-item dropdown border">
        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
          Link <i class="fa fa-caret-down"></i>
        </a>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="#">Option1</a>
          <a class="dropdown-item" href="#">Option2</a>
          <a class="dropdown-item" href="#">Option3</a>
        </div>
      </li>
      <li class="nav-item dropdown border">
        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
          Attach <i class="fa fa-caret-down"></i>
        </a>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="#">Option1</a>
          <a class="dropdown-item" href="#">Option2</a>
          <a class="dropdown-item" href="#">Option3</a>
        </div>
      </li>
      <li class="nav-item dropdown border">
        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
          Park <i class="fa fa-caret-down"></i>
        </a>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="#">Option1</a>
          <a class="dropdown-item" href="#">Option2</a>
          <a class="dropdown-item" href="#">Option3</a>
        </div>
      </li>
      <li class="nav-item dropdown border">
        <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-expanded="false">
          Close <i class="fa fa-caret-down"></i>
        </a>
        <div class="dropdown-menu">
          <a class="dropdown-item" href="#">Option1</a>
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


