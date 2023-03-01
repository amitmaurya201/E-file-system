<%@ include file="../init.jsp"%>

<%
DocFile docFile = (DocFile)renderRequest.getAttribute("docFile");
String type = (String) docFile.getNature();
char firstChar = type.charAt(0);
%>

<div class="container-fluid" style="background-color: #E8E8E8;">
			<div class="hover-tips"><%=firstChar%> | <%=docFile.getFileNumber()%> | <%=docFile.getSubject()%></div>
		</div>


<div class="row mt-2 p-2 border border-dark">
			<div class="col-6">
				<table class="mt-2 file-dtls">
					<tr>
						<th class=""><liferay-ui:message key="label-file-fileno" />:</th>
						<td class=""><%=docFile.getFileNumber()%></td>
					</tr>
					<tr>
						<th><liferay-ui:message key="label-file-reference" />:</th>
						<td><%=docFile.getReference()%></td>
					</tr>
					<tr>
						<th><liferay-ui:message key="label-file-subject" />:</th>
						<td><%=docFile.getSubject()%></td>
					</tr>
					<tr>
						<th><liferay-ui:message key="label-file-remark" />:</th>
						<td><%=docFile.getRemarks()%></td>
					</tr>
				</table>
			</div>

			<%-- <div class="col-6">
				<table class="mt-2 file-dtls">
					<tr>
						<th class="category"><liferay-ui:message
								key="label-file-categoryid" />:</th>
						<td><%=categoryValue%></td>
					</tr>
					<tr>
						<th><liferay-ui:message key="label-file-nature" />:</th>
						<td><%=docFile.getNature()%></td>
					</tr>
					<tr>
						<th><liferay-ui:message key="label-file-sub-categoryid" />:</th>
						<td><%=subCategoryValue != null ? subCategoryValue : ""%></td>
					</tr>
					<tr>
						<th><liferay-ui:message key="label-file-nature-type" />:</th>
						<td><%=docFile.getType()%></td>
					</tr>
				</table>
			</div> --%>
		</div>