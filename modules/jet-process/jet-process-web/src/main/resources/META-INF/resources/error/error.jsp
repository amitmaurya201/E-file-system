<%@ include file="../init.jsp"%>
<%
String errorMessage = ParamUtil.getString(request, "noUserPostErrMsg");
%>
<h1><%=errorMessage != null ? errorMessage : ""%></h1>