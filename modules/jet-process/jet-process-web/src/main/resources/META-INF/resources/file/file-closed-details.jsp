<%@ include file="../init.jsp"%>

<%
DocFile docFile = (DocFile)renderRequest.getAttribute("docFile");
String type = (String) docFile.getNature();
char firstChar = type.charAt(0);

String categoryValue;
String subCategoryValue;

categoryValue = (String) request.getAttribute("CategoryValue");
subCategoryValue = (String) request.getAttribute("SubCategoryValue");

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

			 <div class="col-6">
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
			</div> 
		</div>
		
		<div class="col-md-12 details-color">
					<nav class="navbar navbar-expand-lg navbar-light  mt-1 "
						style="background-color: #ddd; border-top: 2px solid #a19c9c; border-top-left-radius: 5px; border-top-right-radius: 5px;">

						<button class="navbar-toggler" type="button"
							data-toggle="collapse" data-target="#navbarSupportedContent"
							aria-controls="navbarSupportedContent" aria-expanded="false"
							aria-label="Toggle navigation">
							<span class="navbar-toggler-icon"></span>
						</button>
						<div class="navbar-collapse" id="navbarSupportedContent">
							<ul class="navbar-nav">
								<li class="nav-item border"><a id="movement"
									class="nav-link" href="#" style="color: black;">Movement</a></li>
								<li class="nav-item border "><a id="attached-detached"
									class="nav-link" href="#">Attached/Detached</a></li>
								<li class="nav-item border "><a id="dispatch"
									class="nav-link" href="#">Dispatch</a></li>
								<li class="nav-item border "><a id="close" class="nav-link"
									href="#">Close</a></li>
							</ul>
						</div>
					</nav>
				</div>
		