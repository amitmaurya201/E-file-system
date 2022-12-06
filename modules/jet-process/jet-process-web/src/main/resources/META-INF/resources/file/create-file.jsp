<%@ include file="../init.jsp"%>
<%@ include file="/common/common.jsp"%>
<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page import="com.liferay.portal.kernel.service.ServiceContext"%>
<%@ page
	import="com.liferay.portal.kernel.service.ServiceContextThreadLocal"%>
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.4/css/all.css">
<script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">
		<%
			ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
			String setURl = serviceContext.getPortalURL();
		%>
		<portlet:renderURL var="FileList">
			<portlet:param name="mvcRenderCommandName" value="/createdFileList" />
		</portlet:renderURL>

		<div class="container">
			<div class="card">
				<aui:form name="formId">
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
																	<aui:select label="label-file-nature"
																		cssClass="form-select form-control" id="nature"
																		name="nature">
																		<option value="Electronic"><liferay-ui:message
																				key="label-file-nature-option1" /></option>
																		<option value="Physical"><liferay-ui:message
																				key="label-file-nature-option2" /></option>
																	</aui:select>
																</div>
															</div>
															<div class="row">
																<div class="col-auto">
																	<aui:select class="form-select form-control" id="type"
																		label="label-file-nature-type" name="type">
																		<option value="NON-SFS"><liferay-ui:message
																				key="label-file-nature-type-option1-nonsfs" /></option>
																		<option value="SFS"><liferay-ui:message
																				key="label-file-nature-type-option2-sfs" /></option>
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
																<%--  <aui:input name="userPostId" label="" value = "1" id= "userPostId" />  --%>
																<legend class="child-scheduler-border">
																	<liferay-ui:message key="label-file-fileno" />
																	<span class='text-danger'>*</span>
																</legend>
																<aui:fieldset
																	cssClass="col-md-12 p-0 child-scheduler-border">
																	<aui:row>
																		<div class="col-md-2 col-sm-6 mt-2">
																			<aui:select cssClass="form-select form-control"
																				name="basicHeadId" id="basicHeadId"
																				label="label-file-basic-head-id">
																				<option value=""><liferay-ui:message
																						key="file-default-option" /></option>
																				<aui:validator name="required" />
																			</aui:select>
																		</div>
																		<div class="col-md-2 col-sm-6 mt-2">
																			<aui:select cssClass="form-select form-control"
																				name="primaryHeadId" id="primaryHeadId"
																				label="label-file-primary-head-id">
																				<option value=""><liferay-ui:message
																						key="file-default-option" /></option>
																				<aui:validator name="required" />
																			</aui:select>

																		</div>
																		<div class="col-md-2 col-sm-6 mt-2">
																			<aui:select cssClass="form-select form-control"
																				name="secondaryHeadId" id="secondaryHeadId"
																				label="label-file-secondary-head-id">
																				<option value=""><liferay-ui:message
																						key="file-default-option" /></option>
																				<aui:validator name="required" />
																			</aui:select>
																		</div>
																		<div class="col-md-2 col-sm-6 mt-2">
																			<aui:select cssClass="form-select form-control"
																				name="tertiaryHeadId" id="tertiaryHeadId"
																				label="label-file-tertiary-head-id">
																				<option value=""><liferay-ui:message
																						key="file-default-option" /></option>
																				<aui:validator name="required" />
																			</aui:select>
																		</div>
																		<div class="col-md-2 col-sm-6 mt-2">
																			<aui:input type="text" cssClass="form-control"
																				id="year" name="year" value=""
																				label="label-file-year">
																			</aui:input>
																		</div>
																		<div class="col-md-2 col-sm-6 mt-2">
																			<aui:select cssClass="form-select form-control"
																				name="fileCodeId" id="fileCodeId"
																				label="label-file-filecode-id">
																				<option value=""><liferay-ui:message
																						key="file-default-option" /></option>
																				<aui:validator name="required" />
																			</aui:select>
																		</div>

																	</aui:row>
																</aui:fieldset>

															</div>

															<div class="row" id="sfs" style="display: none">
																<aui:fieldset
																	cssClass="col-md-12 child-scheduler-border">
																	<legend cssClass="child-scheduler-border">
																		<liferay-ui:message key="label-file-fileno" />
																		<span class='text-danger'>*</span>
																	</legend>
																	<aui:input class="form-control" type="text"
																		name="fileNumber" id="fileNumber" value=""
																		label="">
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

											<h5 style="font-weight: bold;">
												<liferay-ui:message key="label-file-subject" />
												<span class='text-danger'>*</span>
											</h5>
											<aui:input cssClass="form-control" type="text" name="subject"
												value="" id="subject" label="">
												<aui:validator name="maxLength">
													<liferay-ui:message key="file-subject-maxlength" />
												</aui:validator>
												<aui:validator name="required" />
											</aui:input>
										</aui:fieldset>
									</div>
									<div class="row">
										<aui:fieldset cssClass="child-scheduler-border col-md-6">
											<!-- 	<legend class="child-scheduler-border">Category</legend> -->
											<div cssClass="input-group">
												<aui:select cssClass="form-select form-control"
													id="categoryId" name="categoryId"
													label="label-file-categoryid">

													<option value='0'><liferay-ui:message
															key="file-default-option" /></option>
												</aui:select>
											</div>
										</aui:fieldset>
										<aui:fieldset cssClass="child-scheduler-border col-md-6">
											<!-- <legend class="child-scheduler-border">Sub Category</legend> -->
											<div cssClass="input-group">
												<aui:select cssClass="form-select form-control"
													id="subCategoryId" name="subCategoryId"
													label="label-file-sub-categoryid">
													<option value='0'><liferay-ui:message
															key="file-default-option" /></option>


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
											<aui:input cssClass="form-control col-md-12" rows="3"
												type="textarea" name="remarks" id="remarks" value=""
												label="label-file-remark">

												<aui:validator name="maxLength">
													<liferay-ui:message key="file-remark-maxlength" />
												</aui:validator>
											</aui:input>

										</aui:fieldset>
									</div>
									<div class="row">
										<aui:fieldset cssClass="child-scheduler-border col-md-12">
											<!-- <legend class="child-scheduler-border">
											Reference<span class='text-danger'>*</span>
										</legend> -->
											<aui:input cssClass="form-control col-md-12 " type="text"
												name="reference" id="reference" value=""
												label="label-file-reference">

												<aui:validator name="maxLength">
													<liferay-ui:message key="file-reference-maxlength" />
												</aui:validator>
											</aui:input>


										</aui:fieldset>
									</div>
								</aui:fieldset>
							</div>
						</div>
						<div class="text-center">
							<aui:button type="submit" cssClass="btn btn-danger"
								value="file-submit-button" id="add-docfile"></aui:button>
						</div>
					</div>
				</aui:form>
			</div>
		</div>
	</div>
</div>
<aui:script>

$('#<portlet:namespace />type').change(function(){
	console.log("--------------");
  let value =  $('#<portlet:namespace />type').val();
	if(value === "NON-SFS"){
	$('#non-sfs').show();
	$('#sfs').hide();
	}else{
	$('#non-sfs').hide();
	$('#sfs').show();
	
	}
	});
	
<%-- 	
   $("#<portlet:namespace />basicHeadId").attr('required','');
   $("#<portlet:namespace />primaryHeadId").attr('required', ''); 
   $("#<portlet:namespace />secondaryHeadId").attr('required', ''); 
   $("#<portlet:namespace />tertiaryHeadId").attr('required', ''); 
   $("#<portlet:namespace />fileCodeId").attr('required', '');   --%>



	<%-- 
AUI().use('aui-io-request', function(A){


A.io.request(url, {
			url: "${setURL}/o/jet-process-rs/v1.0/createFile?p_auth=" + Liferay.authToken,
	        		    processData: false,
		      			type: 'POST',
		      			data: formdata,
		      			contentType: false,
	        		  }).on(function(response) {
	        			  console.log(response);
	        			  
	        			
	                    
	        	 })

}); --%>

$(document).ready(function(){
	setUserPostId();
});

</aui:script>
<%@ include file="/js/file.js"%>




