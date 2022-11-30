
<%@page import="io.jetprocess.model.DocFile"%>
<%@page import="com.liferay.portal.kernel.service.ServiceContextThreadLocal"%>
<%@page import="com.liferay.portal.kernel.service.ServiceContext"%>
<%@ include file="../navigation.jsp" %>


<liferay-util:include page="/file/file-view-nav.jsp" servletContext="<%= application %>">
	<liferay-util:param name="selectedNav" value="edit" />
</liferay-util:include>
<%@ include file="/js/file.js" %>
<%@ include file="/js/common.js" %> 
<div class="row">
<div class="col-2">
	<%@ include file="/navigation.jsp" %>																										
	
</div>
<%
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		String setURl = serviceContext.getPortalURL();
		
		
		
	     DocFile docFile = (DocFile) session.getAttribute("DocFile");
		
	    String basicHeadValue = (String) session.getAttribute("BasicHeadValue");
	    String primaryHeadValue = (String) session.getAttribute("PrimaryHeadValue");
	    String secondaryHeadValue = (String) session.getAttribute("SecondaryHeadValue");
	    String tertiaryHeadValue = (String) session.getAttribute("TertiaryHeadValue");
	    String fileCodeValue = (String) session.getAttribute("FileCodeValue");
	    String categoryValue = (String) session.getAttribute("CategoryVaue");
	    String subcategoryValue = (String) session.getAttribute("SubCategoryValue");
		
%>

<div class="col mr-5">

	<div class="container m-3">
		<div class="card">
		
			<aui:form name="updateformId">
	             <div class="card-body">
					<div class="row">
						<div class="col-md-12 col-sm-12">
							<div class="card mt-3">
								<div class="card-body">
									<div class="row mt-2">
										<div class="col-md-12 col-sm-12">
											<div class="text-center">
												<h1>भारत सरकार</h1>
												<h4>GOVERNMENT OF INDIA</h4>
												<h4>Ministry of Home Affairs ( MHA )</h4>
											</div>
											<div class="container">
												<div class="row">
													<div class="col-md-12 d-flex justify-content-between">
														<div class="row">
															<div class="col-auto">
																<!-- <label><b>Nature</b></label> -->
															</div>
															<div class="col-auto">
																<aui:select label="Nature" cssClass="form-select form-control" id="nature"
																	name="nature" readonly="true" >
																	
																	<option value="Electronic"><%= docFile.getNature() %></option>
																
																</aui:select>
															</div>
														</div>
														<div class="row">
															<div class="col-auto">
																<!-- <label><b>Type</b></label> -->
															</div>
															<div class="col-auto">
																<aui:select class="form-select form-control" id="type"
																	name="type" readonly="true" >
																<option value="NON-SFS"><%= docFile.getType() %></option>
																</aui:select>
															</div>
														</div>

													</div>
												</div>
											</div>
											<aui:container>
												<aui:row>

													<aui:col md="12">
							                        
                                                                 
														<div class="row mt-3 " id="non-sfs">
														  <aui:input name="docFileId" label="" value = "<%= docFile.getDocFileId() %>" type="hidden" /> 
																<legend class="child-scheduler-border">File No.</legend>
																<aui:fieldset cssClass="col-md-12 p-0 child-scheduler-border">
																<aui:row>
																	<div class="col-md-2 col-sm-6 mt-2">
																			<aui:select cssClass="form-select form-control"
																			 name="basicHeadId" id="basicHeadId" label="">
																		<option value="<%= docFile.getBasicHeadId() %>"><%= basicHeadValue %></option>
																		<aui:validator name="required" />
																			</aui:select>
																	</div>
																	<div class="col-md-2 col-sm-6 mt-2">
																		<aui:select cssClass="form-select form-control"
																			 name="primaryHeadId" id="primaryHeadId" label="">
																			<option value="<%= docFile.getPrimaryHeadId() %>"><%= primaryHeadValue%></option>
																			<aui:validator name="required" />
																			</aui:select>
																			
																			</div>
																	<div class="col-md-2 col-sm-6 mt-2">
																		<aui:select cssClass="form-select form-control"
																			 name="secondaryHeadId" id="secondaryHeadId" label="">
																			<option value="<%= docFile.getSecondaryHeadId() %>"><%= secondaryHeadValue  %></option>
																			<aui:validator name="required" />
																			</aui:select>
																	</div>
																	<div class="col-md-2 col-sm-6 mt-2">
																		<aui:select cssClass="form-select form-control"
																			 name="tertiaryHeadId" id="tertiaryHeadId" label="">
																			<option value="<%= docFile.getTertiaryHeadId()%>"><%= tertiaryHeadValue %></option> 
																			<aui:validator name="required" />
																	</aui:select>
																	</div>
																	<div class="col-md-2 col-sm-6 mt-2">
																			<aui:input type="text" cssClass="form-control" id="year"
																			name="year" value="<%= docFile.getYear() %>" label="">
																			</aui:input>
																	</div>
																	<div class="col-md-2 col-sm-6 mt-2">
																		<aui:select cssClass="form-select form-control" 
																			name="fileCodeId" id="fileCodeId" label="">
																			<option value="<%= docFile.getFileCodeId()%>"><%= fileCodeValue  %> </option>
																			<aui:validator name="required" />
																		</aui:select>
																	</div>
																	
															</aui:row>
                                                               </aui:fieldset>
														
														</div>
														
													  <div class="row" id="sfs" style="display:none" >
                                                                            <aui:fieldset cssClass="col-md-12 child-scheduler-border">
                                                                                <legend cssClass="child-scheduler-border">File No.</legend>
                                                                                <aui:input class="form-control" type="text" name="fileNumber" id="fileNumber" value="<%=docFile.getFileNumber() %>" label="fileNumber">
                                                                                <aui:validator name="required" />
                                                                                </aui:input>
                                                                            </aui:fieldset>
                                                                        </div>
													
													
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
									
                                           
                                           <aui:input cssClass="form-control" type="text" name="subject" value="<%= docFile.getSubject() %>"
											id="subject" label="Subject">
										 <aui:validator name="required"/>
										<aui:validator name="alpha" errorMessage="alphabet-characters" /> 
											</aui:input>
									</aui:fieldset>
								</div>
								<div class="row">
									<aui:fieldset cssClass="child-scheduler-border col-md-6">
									<!-- 	<legend class="child-scheduler-border">Category</legend> -->
										<div cssClass="input-group">
											 <aui:select cssClass="form-select form-control" id="categoryId"
												name="categoryId"  label="CategoryId">
												<option value="<%= docFile.getCategoryId() %>"><%= categoryValue  %></option>
												 <aui:validator name="required" /> 
											</aui:select>
										</div>
									</aui:fieldset>
									<aui:fieldset cssClass="child-scheduler-border col-md-6">
										<!-- <legend class="child-scheduler-border">Sub Category</legend> -->
										<div cssClass="input-group">
											<aui:select cssClass="form-select form-control" id="subCategoryId"
												name="subCategoryId" label="SubCategory" >
												<option value=""><%= subcategoryValue %></option>
												 <aui:validator name="required" /> 
											</aui:select>
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
											<aui:input cssClass="form-control col-md-12" rows="3" type="textarea"
											name="remarks" id="remarks" value="<%= docFile.getRemarks() %>" label="Remarks">
											 <aui:validator name="required"/>
											<aui:validator name="maxLength">1000</aui:validator> 
											</aui:input>
											 
									</aui:fieldset>
								</div>
								<div class="row">
									<aui:fieldset cssClass="child-scheduler-border col-md-12">
										<!-- <legend class="child-scheduler-border">
											Reference<span class='text-danger'>*</span>
										</legend> -->
											<aui:input  cssClass="form-control col-md-12 " type="text"
											name="reference" id="reference" value="<%= docFile.getReference() %>" label="Reference">
										 	<aui:validator name="required" />
											<aui:validator name="maxLength">250</aui:validator>
											</aui:input>
										    	
											
									</aui:fieldset>
								</div>
							</aui:fieldset>
						</div>
					</div>
					<div class="text-center">
						<aui:button type="button" cssClass="btn btn-danger"  value="Update File"  id="update-docfile"></aui:button>
					</div>
				</div>
			</aui:form>
		</div>
	</div>
	</div>
</div>


