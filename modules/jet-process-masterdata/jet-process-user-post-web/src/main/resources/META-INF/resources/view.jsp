<%@page import="javax.portlet.RenderResponse"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.CookieKeys"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Session"%>
<%@page import="javax.portlet.PortletSession"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="io.jetprocess.masterdata.model.UserPost"%>
<%@page import="java.util.List"%>
<%@include file="init.jsp"%>

<style>
@media screen and (max-width: 785px) {
	.user_post{
		display: flex;
   		flex-direction: column;
   		line-height: 5px;
	}
}
</style>

<%
	List<UserPost> userPostList = (List<UserPost>) request.getAttribute("userPostList");
	HttpSession sessionUserPost = themeDisplay.getRequest().getSession();
	String userPosts = (String) sessionUserPost.getAttribute("userPostId");
	System.out.println("in masterdata view-jsp sessionUserPost --->" + userPosts);
%>
<div class="user_post">
	<label for="post" style="cursor: auto !important;">Select Post:</label>
	<select name="userPost" id="userPostOption"
		style="cursor: pointer !important;">
		<c:forEach items="${userPostList}" var="post">
			<option value="${post.userPostId}">${post.shortName}</option>
		</c:forEach>
	</select>
</div>
<script>

$(document).ready(()=>{
   var post = '<%=userPosts%>';
   if(post != null){
   	$('#userPostOption').val(post);
   }else{
   		$('#userPostOption').val(1);
   }
});

$('#userPostOption').on('change', function() { 
  	var userPost = $('#userPostOption').val();
 	var url = new URLSearchParams();
 	url = url + "?userPost=" + userPost;
	window.location.href = url;

 }); 
	 
</script>
