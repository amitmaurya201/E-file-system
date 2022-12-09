
<%@page import="io.jetprocess.masterdata.model.ReceiptMovementListDTO"%>
<%@ include file="../init.jsp"%>

<%
List<ReceiptMovementListDTO> receiptInboxList = MasterdataLocalServiceUtil.getReceiptInboxList(selectedUserPostId != null ? Integer.parseInt(selectedUserPostId) : 1);
int count = receiptInboxList.size();
%>

<div class="row">
	<div class="body-side-nav col-2">
		<%@ include file="../navigation.jsp"%>
	</div>
	<div class="col-10">
		<h1 class=" text-center">Receipt InBox </h1>
		
	<liferay-ui:search-container total="<%= count %>">
		<liferay-ui:search-container-results results="<%=receiptInboxList %>"  />
		<liferay-ui:search-container-row className="io.jetprocess.masterdata.model.ReceiptMovementListDTO" modelVar="aReceiptMovementListDTO" >
			<liferay-ui:search-container-column-text property="createdDate" />
			<liferay-ui:search-container-column-text property="dueDate" />
			<liferay-ui:search-container-column-text property="readOn" />
			<liferay-ui:search-container-column-text property="receiptID" />
			<liferay-ui:search-container-column-text property="receivedOn" />
			<liferay-ui:search-container-column-text property="receiverId" />
			<liferay-ui:search-container-column-text property="remark" />
			<liferay-ui:search-container-column-text property="senderID" />
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator />
	</liferay-ui:search-container>
		
	

		
		<%-- <liferay-portlet:actionURL name="inboxSearch" var="formAction">
		</liferay-portlet:actionURL>
		<%
			String keyword = "";
			try {
				System.out.println("On Jsp ");
				keyword = (String) request.getAttribute("keywords");
				System.out.println("On Jsp : " + keyword);
			} catch (Exception ex) {
				System.out.println("Error in jsp : " + ex.getMessage());
			}
		%>
		<br>
		<br>
		<aui:form action="<%=formAction%>" method="post" name="fm">
			<div class="search-form">
				<span class="aui-search-bar"> <aui:input label=""
						name="keywords" class="keywords" size="30" title="search-entries"
						type="text" /> <aui:button type="submit" value="search" />
				</span>
			</div>
		</aui:form>

		<%
			//orderByCol is the column name passed in the request while sorting
			String orderByCol = ParamUtil.getString(request, "orderByCol");

			//orderByType is passed in the request while sorting. It can be either asc or desc
			String orderByType = ParamUtil.getString(request, "orderByType");
			String sortingOrder = orderByType;
			//Logic for toggle asc and desc
			if (orderByType.equals("desc")) {
				orderByType = "asc";
			} else {
				orderByType = "desc";
			}

			if (Validator.isNull(orderByType)) {
				orderByType = "desc";
			}
		%>
		<h1 class=" text-center">Receipt Created List</h1>
		<%
			int count = MasterdataLocalServiceUtil
					.getReceiptListCount(selectedUserPostId != null ? Integer.parseInt(selectedUserPostId) : 1);
		%>


		<liferay-ui:search-container orderByType="<%=orderByType%>" delta="2"
			total="<%=count%>" iteratorURL="">

			<liferay-ui:search-container-results>
				<%
					//Get all the results  from file created list
							List<ReceiptMovementListDTO> inboxPerList = null;
							String data = "%" + keyword + "%";
							System.out.println("After data assigning :- " + data);
							if (data.equalsIgnoreCase("%%") || data.equalsIgnoreCase("%null%")) {
								List<ReceiptMovementListDTO> inboxList = MasterdataLocalServiceUtil
										.getReceiptInboxList(selectedUserPostId != null ? Integer.parseInt(selectedUserPostId) : 1);
								inboxPerList = ListUtil.subList(inboxList, SearchContainer.getStart(),
										searchContainer.getEnd());
								System.out.println("After data fetching inside if :- " + inboxPerList);
							} else {
								List<ReceiptMovementListDTO> inboxList = MasterdataLocalServiceUtil.getReceiptInboxListSearchedData(
												selectedUserPostId != null ? Integer.parseInt(selectedUserPostId) : 1, data);
								inboxPerList = ListUtil.subList(inboxList, searchContainer.getStart(),
										searchContainer.getEnd());
								System.out.println("After data fetching inside else :- " + inboxPerList);
							}
							List<ReceiptMovementListDTO> sortableList = new ArrayList<ReceiptMovementListDTO>(inboxPerList);
							if (Validator.isNotNull(orderByCol)) {
								//Pass the column name to BeanComparator to get comparator object
								BeanComparator comparator = new BeanComparator(orderByCol);
								if (sortingOrder.equalsIgnoreCase("asc")) {

									//It will sort in ascending order
									Collections.sort(sortableList, comparator);
								} else {
									//It will sort in descending order
									Collections.reverse(sortableList);
								}

							}

							pageContext.setAttribute("results", sortableList);
				%>
			</liferay-ui:search-container-results>


			<liferay-ui:search-container-row
				className="io.jetprocess.masterdata.model.ReceiptMovementListDTO"
				keyProperty="receiptNumber" modelVar="receipt" >


				<liferay-ui:search-container-column-text property="receiptID"
					name="Receipt ID" orderable="true" />

				<liferay-ui:search-container-column-text cssClass="hover-tips"
					property="senderID" name="Sender ID" />

				<liferay-ui:search-container-column-text property="createDate"
					cssClass="hover-tips" name="Create Date" />
				


				<liferay-ui:search-container-column-text property="remark"
					cssClass="remark" name="Remark" />

				<liferay-ui:search-container-column-text property="receivedOn"
					cssClass="remark" name="Received On" />
					

			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator markupView="lexicon" />
		</liferay-ui:search-container> --%>
		
	</div>
</div>
