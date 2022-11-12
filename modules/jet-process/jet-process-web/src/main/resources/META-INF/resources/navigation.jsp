<%@ include file="init.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css">
    <style>
        body {font-family: "Lato", sans-serif;}
        
        .sidebar {
          height: 100%;
          width: 160px;
          position: fixed;
          z-index: 1;
          top: 0;
          left: 0;
          background-color: #111;
          overflow-x: hidden;
          padding-top: 16px;
        }
        
        .sidebar a {
          padding: 6px 8px 6px 16px;
          text-decoration: none;
          font-size: 20px;
          color: #1378D1;
          display: block;
        }
        
        .sidebar a:hover {
          color: #f1f1f1;
        }
        
        .main {
          margin-left: 160px; /* Same as the width of the sidenav */
          padding: 0px 10px;
        }
        
        @media screen and (max-height: 450px) {
          .sidebar {padding-top: 15px;}
          .sidebar a {font-size: 18px;}
        }
        </style>
</head>

<portlet:renderURL var="createFile">
    <portlet:param name="mvcRenderCommandName" value="/createFile1"/>
</portlet:renderURL>
<portlet:renderURL var="createdFileList">
    <portlet:param name="mvcRenderCommandName" value="/createdFileList"/>
</portlet:renderURL>
<portlet:renderURL var="createReceipt">
    <portlet:param name="mvcRenderCommandName" value="/createReceipt"/>
</portlet:renderURL>
<portlet:renderURL var="createdListReceipt">
    <portlet:param name="mvcRenderCommandName" value="/createdListReceipt"/>
</portlet:renderURL>

<body>
    <div class="sidebar">
         <a href="#home"><i class="fa fa-fw fa-home"></i> Home</a>
        <a class="dropdown-btn"><i class="fa fa-file" aria-hidden="true"></i>File
            <i class="fa fa-caret-down"></i>
        </a>
          <div class="dropdown-container">
            <a href="<%= createFile %>">Create File</a>
            <a href="<%= createdFileList %>">Created  List</a>
            
          </div>
          <a class="dropdown-btn"><i class='fas fa-receipt' style='font-size:24px'></i>
Receipt
            <i class="fa fa-caret-down"></i>
        </a>
          <div class="dropdown-container">
            <a href="<%=createReceipt  %>">Create Receipt</a>
            <a href="<%= createdListReceipt %>">Created  List</a>
            
          </div>
       
        <a href="#contact"><i class="fa fa-fw fa-envelope"></i> Contact</a>
    </div>

        
              
        <script>
            /* Loop through all dropdown buttons to toggle between hiding and showing its dropdown content - This allows the user to have multiple dropdowns without any conflict */
            var dropdown = document.getElementsByClassName("dropdown-btn");
            var i;
            
            for (i = 0; i < dropdown.length; i++) {
              dropdown[i].addEventListener("click", function() {
                this.classList.toggle("active");
                var dropdownContent = this.nextElementSibling;
                if (dropdownContent.style.display === "block") {
                  dropdownContent.style.display = "none";
                } else {
                  dropdownContent.style.display = "block";
                }
              });
            }
            </script>
    
</body>
</html>