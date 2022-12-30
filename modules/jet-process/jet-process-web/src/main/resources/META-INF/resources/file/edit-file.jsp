
<%@page import="io.jetprocess.model.DocFile"%>
<%@page
	import="com.liferay.portal.kernel.service.ServiceContextThreadLocal"%>
<%@page import="com.liferay.portal.kernel.service.ServiceContext"%>

<%@ include file="../init.jsp"%>


<%@ include file="/common/common.jsp"%>

<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">
		<liferay-util:include page="/file/file-view-nav.jsp"
			servletContext="<%=application%>">
			<liferay-util:param name="selectedNav" value="edit" />
		</liferay-util:include>

		<%
			ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
			String setURl = serviceContext.getPortalURL();
			DocFile docFile = (DocFile) session.getAttribute("DocFile");

			String   basicHeadValue = (String) session.getAttribute("BasicHeadValue");
        	  String primaryHeadValue	 = (String) session.getAttribute("PrimaryHeadValue");
        	 String  secondaryHeadValue = (String) session.getAttribute("SecondaryHeadValue");
        	  String tertiaryHeadValue  = (String) session.getAttribute("TertiaryHeadValue");
        	  String fileCodeValue	 = (String) session.getAttribute("FileCodeValue");
        	  String categoryValue 	= (String) session.getAttribute("CategoryVaue");
        	  String subcategoryValue = (String) session.getAttribute("SubCategoryValue");
        	  
        	  String sfsCategoryValue =  (String) session.getAttribute("SfsCategoryValue");
        	  String sfsSubCategoryValue =  (String) session.getAttribute("SfsSubCategoryValue");
        	 
        	   %>
     	<div class="container">
			<div class="card">

				<aui:form name="updateformId" onSubmit="editFile(event)">
					<div class="card-body">
						<div class="row">
							<div class="col-md-12 col-sm-12">
								<div class="card mt-3">
									<div class="card-body">
										<div class="row mt-2">
											<div class="col-md-12 col-sm-12">
												<div class="text-center">
														<h1>
														<liferay-ui:message key="label-file-hin-bharat-sarkar" />
													</h1>
													<h4>
														<liferay-ui:message key="label-file-govt-of-india" />
													</h4>
													<h4>
														<liferay-ui:message key="label-file-mha" />
													</h4>
												</div>
												<div class="container">
													<div class="row">
														<div class="col-md-12 d-flex justify-content-between">
															<div class="row">
																<div class="col-auto">
																	<!-- <label><b>Nature</b></label> -->
																</div>
																<div class="col-auto">
																	<aui:select label="label-file-nature"
																		cssClass="form-select form-control" id="nature"
																		name="nature" disabled="true">

																		<option value="Electronic"><%=docFile.getNature()%></option>

																	</aui:select>
																	<aui:input name="docFileId" label=""
																	value="<%=docFile.getDocFileId()%>"  type="hidden"/>
																</div>
															</div>
															<div class="row">
																<div class="col-auto">
																	<!-- <label><b>Type</b></label> -->
																</div>
																<div class="col-auto">
																	<aui:select class="form-select form-control" id="type"
																		name="type" label="label-file-nature-type" disabled="true">
																		<option value="NON-SFS"><%=docFile.getType()%></option>
																	</aui:select>
																</div>
															</div>

														</div>
													</div>
												</div>
												<aui:container>
													<aui:row>

														<aui:col md="12">

                                                          <% if(docFile.getType().equalsIgnoreCase("NON-SFS")) { %>
															<div class="row mt-3 " id="non-sfs">
																
																<legend class="child-scheduler-border"><liferay-ui:message key="label-file-fileno" /></legend>
																<aui:fieldset
																	cssClass="col-md-12 p-0 child-scheduler-border">
																	<aui:row>
																		<div class="col-md-2 col-sm-6 mt-2">
																		
																	
																			<aui:select cssClass="form-select form-control"
																				name="basicHeadId" id="basicHeadId" label="label-file-basic-head-id" disabled="true">
																				<option value="<%=docFile.getBasicHeadId()%>"><%=basicHeadValue%></option>
																				<aui:validator name="required" />
																			</aui:select> 
																		</div>
																		<div class="col-md-2 col-sm-6 mt-2">
																			<aui:select cssClass="form-select form-control"
																				name="primaryHeadId" id="primaryHeadId" label="label-file-primary-head-id" disabled="true">
																				<option value="<%=docFile.getPrimaryHeadId()%>"><%=primaryHeadValue%></option>
																				<aui:validator name="required" />
																			</aui:select>

																		</div>
																		<div class="col-md-2 col-sm-6 mt-2">
																			<aui:select cssClass="form-select form-control"
																				name="secondaryHeadId" id="secondaryHeadId" label="label-file-secondary-head-id" disabled="true">
																				<option value="<%=docFile.getSecondaryHeadId()%>"><%=secondaryHeadValue%></option>
																				<aui:validator name="required" />
																			</aui:select>
																		</div>
																		<div class="col-md-2 col-sm-6 mt-2">
																			 <aui:select cssClass="form-select form-control"
																				name="tertiaryHeadId" id="tertiaryHeadId" label="label-file-tertiary-head-id"  disabled="true">
																				<option value="<%=docFile.getTertiaryHeadId()%>"><%=tertiaryHeadValue%></option>
																				<aui:validator name="required" />
																			</aui:select> 
																		</div>
																		<div class="col-md-2 col-sm-6 mt-2">
																			<aui:input type="text" cssClass="form-control"
																				id="year" name="year"
																				value="<%=docFile.getYear()%>" readonly="true" label="label-file-year" disabled="true">
																			</aui:input>
																		</div>
																		<div class="col-md-2 col-sm-6 mt-2">
																			<aui:select cssClass="form-select form-control"
																				name="fileCodeId" id="fileCodeId" label="label-file-filecode-id" disabled="true">
																				<option value="<%=docFile.getFileCodeId()%>"><%=fileCodeValue%>
																				</option>
																				<aui:validator name="required" />
																			</aui:select>
																		</div>

																	</aui:row>
																</aui:fieldset>

															</div>
															<% } else if(docFile.getType().equalsIgnoreCase("SFS")) { %>
                                                            <div class="row" id="sfs">
																<aui:fieldset
																	cssClass="col-md-12 child-scheduler-border">
																	<legend cssClass="child-scheduler-border"><liferay-ui:message key="label-file-fileno" /></legend>
																	<aui:input class="form-control" type="text"
																		name="fileNumber" id="fileNumber"
																		value="<%=docFile.getFileNumber()%>"
																		label="label-file-fileno"  disabled="true">
																		<aui:validator name="required" />
																	</aui:input>
																</aui:fieldset>
															</div>
                                                           <% } %>

														</aui:col>

													</aui:row>
												</aui:container>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>


						<div class="row">
							<div class="container">
								<aui:fieldset cssClass="scheduler-border col-md-12">
									<div class="row">
										<aui:fieldset cssClass="scheduler-border col-md-12">
											<!-- <legend class="child-scheduler-border">
											Subject<span class='text-danger'>*</span>
										</legend> -->


											<aui:input cssClass="form-control" type="text" name="subject"
												value="<%=docFile.getSubject()%>" id="subject"
												label="label-file-subject">
												<aui:validator name="required" />
												<aui:validator name="maxLength"><liferay-ui:message key="file-subject-maxlength" /></aui:validator>
											</aui:input>
										</aui:fieldset>
									</div>
									<div class="row">
										<aui:fieldset cssClass="child-scheduler-border col-md-6">
											<!-- 	<legend class="child-scheduler-border">Category</legend> -->
											<div cssClass="input-group">
											      <% if(docFile.getType().equalsIgnoreCase("NON-SFS")) { %>
												<aui:select cssClass="form-select form-control master_drop_category"
													id="categoryId" name="categoryId" label="label-file-categoryid">
													<option value="<%= docFile.getCategoryId() %>"><%=categoryValue%></option>
														<aui:validator name="required" />
													</aui:select>
													<% } else if(docFile.getType().equalsIgnoreCase("SFS")) { %>
													<aui:select cssClass="form-select form-control master_drop_category"
													id="categoryId" name="categoryId" label="label-file-categoryid">
													<option value="<%= docFile.getCategoryId() %>"><%= sfsCategoryValue %></option>
														<aui:validator name="required" />
													</aui:select>
												<% } %>
											</div>
										</aui:fieldset>
										
										<aui:fieldset cssClass="child-scheduler-border col-md-6">
											<!-- <legend class="child-scheduler-border">Sub Category</legend> -->
											<div cssClass="input-group">
											
											<% if(docFile.getType().equalsIgnoreCase("NON-SFS")) { %>
										
												<aui:select cssClass="form-select form-control"
													id="subCategoryId" name="subCategoryId" label="label-file-sub-categoryid">
												
												</aui:select>
												<% } else if(docFile.getType().equalsIgnoreCase("SFS")) { %>
												
												<aui:select cssClass="form-select form-control"
													id="subCategoryId" name="subCategoryId" label="label-file-sub-categoryid">
													
												</aui:select>
													
													<% } %>
											</div>
										</aui:fieldset>
									</div>
								</aui:fieldset>
							</div>
							<div class="container">
								<aui:fieldset cssClass="scheduler-border col-md-12">
									<div class="row">
										<aui:fieldset cssClass="col-md-12 child-scheduler-border">
											<!-- <legend class="child-scheduler-border">
											Remark<span class='text-danger'>*</span>
										</legend>-->
											<aui:input cssClass="form-control col-md-12" rows="3"
												type="textarea" name="remarks" id="remarks"
												value="<%=docFile.getRemarks()%>" label="label-file-remark">
												<aui:validator name="maxLength"><liferay-ui:message key="file-remark-maxlength" /></aui:validator>
											</aui:input>

										</aui:fieldset>
									</div>
									<div class="row">
										<aui:fieldset cssClass="child-scheduler-border col-md-12">
											<!-- <legend class="child-scheduler-border">
											Reference<span class='text-danger'>*</span>
										</legend> -->
											<aui:input cssClass="form-control col-md-12 " type="text"
												name="reference" id="reference"
												value="<%=docFile.getReference()%>" label="label-file-reference">
												<aui:validator name="maxLength"><liferay-ui:message key="file-reference-maxlength" /></aui:validator>
											</aui:input>


										</aui:fieldset>
									</div>
								</aui:fieldset>
							</div>
						</div>
						<div class="text-center">
							<aui:button type="submit" cssClass="btn btn-danger"
								value="file-edit-button" id="update-docfile"></aui:button>
						</div>
					</div>
				</aui:form>
			<aui:input name="inputSubCategoryId" value = "<%= docFile.getSubCategoryId() %>" id = "inputSubCategoryId" type = "hidden"></aui:input>
			</div>
		</div>
	</div>
</div>
<script type="text/javascript">
$(".master_drop_category").on("click",function(){
	
	$(".master_drop_category").find("option").eq(0).hide();
})

</script>

 <%@ include file="/js/file.js"%>


