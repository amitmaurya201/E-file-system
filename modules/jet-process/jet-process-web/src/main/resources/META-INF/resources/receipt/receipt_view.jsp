<%@page import="com.liferay.portal.kernel.util.SessionParamUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@ include file="../init.jsp" %>
 

<%--  <%
 if(themeDisplay.isSignedIn()){
 List<UserPost> userPostList =UserPostLocalServiceUtil.getUserPostList(user.getUserId());
 for(UserPost userPosts:userPostList){
 long id=userPosts.getUserPostId();
 /* String name=userPosts.getShortName(); */
  out.println("userPostId--> "+id);
  /* out.println("userPostName--> "+name); */

 %> --%>

 
 
<liferay-util:include page="/receipt/receipt-view-nav.jsp" servletContext="<%= application %>">
<liferay-util:param name="selectedNav" value="home" />
<%-- <liferay-util:param name="userPostId" value="${id}" /> --%>
</liferay-util:include>
<%-- <%}

}%>
 --%>
<%-- <%@ include file="receipt-view-nav.jsp"%> --%>

<h1>home receipt view</h1>



