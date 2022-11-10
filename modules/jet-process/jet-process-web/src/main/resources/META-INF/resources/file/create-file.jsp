<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
	<%@ include file="/navigation.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create File</title>
</head>
<body>
<%
boolean type = true;

%>
	<div class="container m-3">
		<div class="card">
			<aui:form>
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
																<aui:select cssClass="form-select form-control" id="type"
																	name="type" label="Type" >
																	<option value="NON-SFS">NON SFS</option>
																	<option value="SFS">SFS</option>
																</aui:select>
															</div>
														</div>

													</div>
												</div>
											</div>
											<div class="container">
												<div class="row">

													<div class="col-md-12">
							                        <% if(type ==true) {     %> 
                                                                 
														<div class="row mt-3 ">
															<aui:fieldset class="col-md-12 p-0 child-scheduler-border">
																<legend class="child-scheduler-border">File No.</legend>
																<div class="row">
																	<div class="col-md-2 col-sm-6 mt-2">
																		<select class="form-select form-control"
																			 name="basicHeadId" id="basicHead">
																			<option value=''>Basic Head</option> 
																			</select>
																	</div>
																	<div class="col-md-2 col-sm-6 mt-2">
																		<select class="form-select form-control"
																			 name="primaryHeadId" id="primaryHead">
																			<option value=''>Primary Head Code</option>
																			</select></div>
																	<div class="col-md-2 col-sm-6 mt-2">
																		<select class="form-select form-control"
																			 name="secondaryHeadId" id="secondaryHead">
																			
																			<option value=''>Secondary Head Code</option>
																			</select>
																	</div>
																	<div class="col-md-2 col-sm-6 mt-2">
																		<select class="form-select form-control"
																			 name="tertiaryHeadId" id="tertiaryHead">
																			
																			<option value=''>Tertiary Head Code</option> 
																	</select>
																	</div>
																	<div class="col-md-2 col-sm-6 mt-2">
																		<input type="text" class="form-control" 
																			name="year"></input>
																			
																	</div>
																	<div class="col-md-2 col-sm-6 mt-2">
																		<select class="form-select form-control" 
																			name="fileCodeId" id="fileCode">
																			<option value="">File-Code</option> 
																			</select>
																	</div>
																</div>

															</aui:fieldset>
														</div>
														<%
														}else{
														%>
														 <div className="row">
                                                                            <fieldset className="col-md-12 child-scheduler-border">
                                                                                <legend className="child-scheduler-border">File No.</legend>
                                                                                <input className="form-control" type="text" name="fileNumber" id="fileNumber" onChange={onchange} ref={register({ required: { value: true, message: 'File number is required' } })} value={docFile.fileNumber} />
                                                                                {errors.fileNumber && <span className="errors">{errors.fileNumber.message}</span>}
                                                                            </fieldset>
                                                                        </div>
														<% } %>
													</div>
												</div>
											</div>
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
											id="subject" />

									</aui:fieldset>
								</div>
								<div class="row">
									<aui:fieldset cssClass="child-scheduler-border col-md-6">
									<!-- 	<legend class="child-scheduler-border">Category</legend> -->
										<div cssClass="input-group">
											<aui:select cssClass="form-select form-control" id="category"
												name="category" >
												<option value=''>Choose...</option> 
											</aui:select>
										</div>
									</aui:fieldset>
									<aui:fieldset cssClass="child-scheduler-border col-md-6">
										<!-- <legend class="child-scheduler-border">Sub Category</legend> -->
										<div cssClass="input-group">
											<aui:select cssClass="form-select form-control" id="subCategory"
												name="subCategory" >
												<option value=''>Choose...</option> 
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
											name="remarks" id="remark" ></aui:input>
									</aui:fieldset>
								</div>
								<div class="row">
									<aui:fieldset cssClass="child-scheduler-border col-md-12">
										<!-- <legend class="child-scheduler-border">
											Reference<span class='text-danger'>*</span>
										</legend> -->
										<aui:input  cssClass="form-control col-md-12 " type="text"
											name="reference" id="reference"  />
									</aui:fieldset>
								</div>
							</aui:fieldset>
						</div>
					</div>
					<div class="text-center">
						<aui:button type="submit" cssClass="btn btn-danger"  value="Create File"></aui:button>
					</div>
				</div>
			</aui:form>
		</div>
	</div>
</body>
</html>