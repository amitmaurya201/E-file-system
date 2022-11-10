<%@ include file="/init.jsp" %>

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

<a href="<%= createFile %>" >
        Create File
    </a>
    <br>
    <br>
    <a href="<%= createdFileList %>" >
      Created File List
    </a>
    <br>
    <br>
    <a href="<%= createReceipt %>" >
       Create Receipt
    </a>
    <br>
    <br>
    <a href="<%= createdListReceipt %>" >
     Create Receipt List
    </a>
  