<%@page import="javax.portlet.RenderResponse"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.CookieKeys"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Session"%>
<%@page import="javax.portlet.PortletSession"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="io.jetprocess.masterdata.model.UserPost"%>
<%@page import="java.util.List"%>
<%@include file="init.jsp"%>

<%
	List<UserPost> userPostList = (List<UserPost>) request.getAttribute("userPostList");

	HttpSession sessionUserPost = themeDisplay.getRequest().getSession();
	String userPosts = (String) sessionUserPost.getAttribute("userPostId");
	System.out.println("in masterdata view-jsp sessionUserPost --->" + userPosts);
%>

<%-- <portlet:resourceURL var="postUrl" id="/userPostURL" /> --%>

<label for="post">Select Post:</label>
<select name="userPost" id="userPostOption">
	<c:forEach items="${userPostList}" var="post">
		<option value="${post.userPostId}">${post.shortName}</option>
	</c:forEach>
</select>

<script>

$(document).ready(()=>{
   /* if(document.cookie.length != 0){
	var cookieArray = document.cookie.split('=');
	if(cookieArray[0]=="currentUserPost" && cookieArray[1]!=null ){
		var value = cookieArray[1].split(';');
		$('#userPostOption').val(value[0]);
	} else {
		$('#userPostOption').val(1);
	}
   }  */
   
   
   var post = '<%=userPosts%>';
  // alert("post"+post);
   if(post != null){
   	$('#userPostOption').val(post);
   }else{
   		$('#userPostOption').val(1);
   }
   //alert("userPostOption"+$('#userPostOption').val());
});






$('#userPostOption').on('change', function() { 
  	var userPost = $('#userPostOption').val();
 	var url = new URLSearchParams();
 	url = url + "?userPost=" + userPost;
	window.location.href = url;
	//window.location.reload();
	
	//document.cookie =  "currentUserPost=" + userPost ;
	
	/*  var _url= '${postUrl}';
	console.warn(_url);
	AUI().use('aui-io-request', function(A){
		A.io.request(_url, {
			method: 'get',
			dataType: 'json',
			on: {
				success: function(data) {
				
				}
			}
		
		});
	}); */
	
	
	
	
	
	
	/* 
	$.ajax({
        	url: _url,
            method: 'get',
	            on: {
	                    success: function(data) {
	                     alert(data);
	                 }
	           }
			});*/

 }); 
	 
</script>
