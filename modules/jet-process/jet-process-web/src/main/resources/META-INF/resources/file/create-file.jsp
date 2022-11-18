<%@ include file="../init.jsp"%>
<%@ page import="java.util.Date" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"pageEncoding="UTF-8"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@ page import="com.liferay.portal.kernel.service.ServiceContext"%>
<%@ page
	import="com.liferay.portal.kernel.service.ServiceContextThreadLocal"%>
<%@ include file="/js/file.js" %>

<div class="row">
<div class="col-2">
	<%@ include file="/navigation.jsp" %>
	
</div>
<%
		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();
		String setURl = serviceContext.getPortalURL();
%>

<div class="col mr-5">


	<div class="container m-3">
		<div class="card">
			<aui:form id="formId">
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
																	name="nature" >
																	<option value="Electronic">Electronic</option>
																	<option value="Physical">Physical</option>
																</aui:select>
															</div>
														</div>
														<div class="row">
															<div class="col-auto">
																<!-- <label><b>Type</b></label> -->
															</div>
															<div class="col-auto">
																<aui:select class="form-select form-control" id="type"
																	name="type"  >
																	<option value="NON-SFS">NON SFS</option>
																	<option value="SFS">SFS</option>
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
															<aui:input name="userPostId" label="" id="userPostId" type="hidden"/>
																<legend class="child-scheduler-border">File No.</legend>
																<aui:fieldset cssClass="col-md-12 p-0 child-scheduler-border">
																<aui:row>
																	<div class="col-md-2 col-sm-6 mt-2">
																		<aui:select cssClass="form-select form-control"
																			 name="basicHeadId" id="basicHeadId" label="">
																			 <option value="">Basic Head</option>																			
																			</aui:select>
																			
																	</div>
																	<div class="col-md-2 col-sm-6 mt-2">
																		<aui:select cssClass="form-select form-control"
																			 name="primaryHeadId" id="primaryHeadId" label="">
																			<option value="">Primary Head Code</option>
																			</aui:select>
																			
																			</div>
																	<div class="col-md-2 col-sm-6 mt-2">
																		<aui:select cssClass="form-select form-control"
																			 name="secondaryHeadId" id="secondaryHeadId" label="">
																			<option value=''>Secondary Head Code</option>
																			</aui:select>
																	</div>
																	<div class="col-md-2 col-sm-6 mt-2">
																		<aui:select cssClass="form-select form-control"
																			 name="tertiaryHeadId" id="tertiaryHeadId" label="">
																			<option value=''>Tertiary Head Code</option> 
																	</aui:select>
																	</div>
																	<div class="col-md-2 col-sm-6 mt-2">
																		<aui:input type="text" cssClass="form-control" id="year"
																			name="year" value="" label="">
																			</aui:input>
																	</div>
																	<div class="col-md-2 col-sm-6 mt-2">
																		<aui:select cssClass="form-select form-control" 
																			name="fileCodeId" id="fileCodeId" label="">
																			<option value="">File-Code</option> 
																		</aui:select>
																	</div>
																	
															</aui:row>
                                                               </aui:fieldset>
														
														</div>
														
														 <div class="row" id="sfs" style="display:none" >
                                                                            <aui:fieldset cssClass="col-md-12 child-scheduler-border">
                                                                                <legend cssClass="child-scheduler-border">File No.</legend>
                                                                                <aui:input class="form-control" type="text" name="" id="fileNumber" >
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
										<aui:input cssClass="form-control" type="text" name="subject"
											id="subject">
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
												name="categoryId" >
												<option value=''>Choose...</option> 
											 <aui:validator name="required" /> 
											</aui:select>
										</div>
									</aui:fieldset>
									<aui:fieldset cssClass="child-scheduler-border col-md-6">
										<!-- <legend class="child-scheduler-border">Sub Category</legend> -->
										<div cssClass="input-group">
											<aui:select cssClass="form-select form-control" id="subCategoryId"
												name="subCategoryId" >
												<option value=''>Choose...</option>
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
											name="remarks" id="remarks" >
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
											name="reference" id="reference"  >
										 	<aui:validator name="required" />
											<aui:validator name="maxLength">250</aui:validator>
											</aui:input>
									</aui:fieldset>
								</div>
							</aui:fieldset>
						</div>
					</div>
					<div class="text-center">
						<aui:button type="button" cssClass="btn btn-danger"  value="Create File"  id="add-docfile"></aui:button>
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
	
	
  $("#<portlet:namespace/>basicHeadId").attr('required','');
   $("#<portlet:namespace />primaryHeadId").attr('required', ''); 
   $("#<portlet:namespace />secondaryHeadId").attr('required', ''); 
   $("#<portlet:namespace />tertiaryHeadId").attr('required', ''); 
   $("#<portlet:namespace />fileCodeId").attr('required', ''); 

	



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



</aui:script>

