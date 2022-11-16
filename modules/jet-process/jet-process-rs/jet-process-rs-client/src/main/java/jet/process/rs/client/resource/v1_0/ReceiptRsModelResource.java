package jet.process.rs.client.resource.v1_0;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Generated;

import jet.process.rs.client.dto.v1_0.ReceiptRsModel;
import jet.process.rs.client.http.HttpInvoker;
import jet.process.rs.client.pagination.Page;
import jet.process.rs.client.problem.Problem;
import jet.process.rs.client.serdes.v1_0.ReceiptRsModelSerDes;

/**
 * @author Admin
 * @generated
 */
@Generated("")
public interface ReceiptRsModelResource {

	public static Builder builder() {
		return new Builder();
	}

	public Page<ReceiptRsModel> createReceipt(
			Integer groupId, Integer typeId, Integer tempfileEntryId,
			Integer deliveryModeId, String receivedOn, String letterDate,
			String referenceNumber, String modeNumber,
			Integer receiptCategoryId, Integer receiptSubCategoryId,
			String subject, String remarks, String name, String designation,
			String mobile, String email, String address, Integer countryId,
			Integer stateId, String pinCode, Integer organizationId,
			Integer subOrganizationId, String city, Integer userPostId)
		throws Exception;

	public HttpInvoker.HttpResponse createReceiptHttpResponse(
			Integer groupId, Integer typeId, Integer tempfileEntryId,
			Integer deliveryModeId, String receivedOn, String letterDate,
			String referenceNumber, String modeNumber,
			Integer receiptCategoryId, Integer receiptSubCategoryId,
			String subject, String remarks, String name, String designation,
			String mobile, String email, String address, Integer countryId,
			Integer stateId, String pinCode, Integer organizationId,
			Integer subOrganizationId, String city, Integer userPostId)
		throws Exception;

	public static class Builder {

		public Builder authentication(String login, String password) {
			_login = login;
			_password = password;

			return this;
		}

		public ReceiptRsModelResource build() {
			return new ReceiptRsModelResourceImpl(this);
		}

		public Builder contextPath(String contextPath) {
			_contextPath = contextPath;

			return this;
		}

		public Builder endpoint(String host, int port, String scheme) {
			_host = host;
			_port = port;
			_scheme = scheme;

			return this;
		}

		public Builder header(String key, String value) {
			_headers.put(key, value);

			return this;
		}

		public Builder locale(Locale locale) {
			_locale = locale;

			return this;
		}

		public Builder parameter(String key, String value) {
			_parameters.put(key, value);

			return this;
		}

		public Builder parameters(String... parameters) {
			if ((parameters.length % 2) != 0) {
				throw new IllegalArgumentException(
					"Parameters length is not an even number");
			}

			for (int i = 0; i < parameters.length; i += 2) {
				String parameterName = String.valueOf(parameters[i]);
				String parameterValue = String.valueOf(parameters[i + 1]);

				_parameters.put(parameterName, parameterValue);
			}

			return this;
		}

		private Builder() {
		}

		private String _contextPath = "";
		private Map<String, String> _headers = new LinkedHashMap<>();
		private String _host = "localhost";
		private Locale _locale;
		private String _login = "";
		private String _password = "";
		private Map<String, String> _parameters = new LinkedHashMap<>();
		private int _port = 8080;
		private String _scheme = "http";

	}

	public static class ReceiptRsModelResourceImpl
		implements ReceiptRsModelResource {

		public Page<ReceiptRsModel> createReceipt(
				Integer groupId, Integer typeId, Integer tempfileEntryId,
				Integer deliveryModeId, String receivedOn, String letterDate,
				String referenceNumber, String modeNumber,
				Integer receiptCategoryId, Integer receiptSubCategoryId,
				String subject, String remarks, String name, String designation,
				String mobile, String email, String address, Integer countryId,
				Integer stateId, String pinCode, Integer organizationId,
				Integer subOrganizationId, String city, Integer userPostId)
			throws Exception {

			HttpInvoker.HttpResponse httpResponse = createReceiptHttpResponse(
				groupId, typeId, tempfileEntryId, deliveryModeId, receivedOn,
				letterDate, referenceNumber, modeNumber, receiptCategoryId,
				receiptSubCategoryId, subject, remarks, name, designation,
				mobile, email, address, countryId, stateId, pinCode,
				organizationId, subOrganizationId, city, userPostId);

			String content = httpResponse.getContent();

			if ((httpResponse.getStatusCode() / 100) != 2) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response content: " + content);
				_logger.log(
					Level.WARNING,
					"HTTP response message: " + httpResponse.getMessage());
				_logger.log(
					Level.WARNING,
					"HTTP response status code: " +
						httpResponse.getStatusCode());

				throw new Problem.ProblemException(Problem.toDTO(content));
			}
			else {
				_logger.fine("HTTP response content: " + content);
				_logger.fine(
					"HTTP response message: " + httpResponse.getMessage());
				_logger.fine(
					"HTTP response status code: " +
						httpResponse.getStatusCode());
			}

			try {
				return Page.of(content, ReceiptRsModelSerDes::toDTO);
			}
			catch (Exception e) {
				_logger.log(
					Level.WARNING,
					"Unable to process HTTP response: " + content, e);

				throw new Problem.ProblemException(Problem.toDTO(content));
			}
		}

		public HttpInvoker.HttpResponse createReceiptHttpResponse(
				Integer groupId, Integer typeId, Integer tempfileEntryId,
				Integer deliveryModeId, String receivedOn, String letterDate,
				String referenceNumber, String modeNumber,
				Integer receiptCategoryId, Integer receiptSubCategoryId,
				String subject, String remarks, String name, String designation,
				String mobile, String email, String address, Integer countryId,
				Integer stateId, String pinCode, Integer organizationId,
				Integer subOrganizationId, String city, Integer userPostId)
			throws Exception {

			HttpInvoker httpInvoker = HttpInvoker.newHttpInvoker();

			httpInvoker.body(userPostId.toString(), "application/json");

			if (_builder._locale != null) {
				httpInvoker.header(
					"Accept-Language", _builder._locale.toLanguageTag());
			}

			for (Map.Entry<String, String> entry :
					_builder._headers.entrySet()) {

				httpInvoker.header(entry.getKey(), entry.getValue());
			}

			for (Map.Entry<String, String> entry :
					_builder._parameters.entrySet()) {

				httpInvoker.parameter(entry.getKey(), entry.getValue());
			}

			httpInvoker.httpMethod(HttpInvoker.HttpMethod.POST);

			if (groupId != null) {
				httpInvoker.parameter("groupId", String.valueOf(groupId));
			}

			if (typeId != null) {
				httpInvoker.parameter("typeId", String.valueOf(typeId));
			}

			if (tempfileEntryId != null) {
				httpInvoker.parameter(
					"tempfileEntryId", String.valueOf(tempfileEntryId));
			}

			if (deliveryModeId != null) {
				httpInvoker.parameter(
					"deliveryModeId", String.valueOf(deliveryModeId));
			}

			if (receivedOn != null) {
				httpInvoker.parameter("receivedOn", String.valueOf(receivedOn));
			}

			if (letterDate != null) {
				httpInvoker.parameter("letterDate", String.valueOf(letterDate));
			}

			if (referenceNumber != null) {
				httpInvoker.parameter(
					"referenceNumber", String.valueOf(referenceNumber));
			}

			if (modeNumber != null) {
				httpInvoker.parameter("modeNumber", String.valueOf(modeNumber));
			}

			if (receiptCategoryId != null) {
				httpInvoker.parameter(
					"receiptCategoryId", String.valueOf(receiptCategoryId));
			}

			if (receiptSubCategoryId != null) {
				httpInvoker.parameter(
					"receiptSubCategoryId",
					String.valueOf(receiptSubCategoryId));
			}

			if (subject != null) {
				httpInvoker.parameter("subject", String.valueOf(subject));
			}

			if (remarks != null) {
				httpInvoker.parameter("remarks", String.valueOf(remarks));
			}

			if (name != null) {
				httpInvoker.parameter("name", String.valueOf(name));
			}

			if (designation != null) {
				httpInvoker.parameter(
					"designation", String.valueOf(designation));
			}

			if (mobile != null) {
				httpInvoker.parameter("mobile", String.valueOf(mobile));
			}

			if (email != null) {
				httpInvoker.parameter("email", String.valueOf(email));
			}

			if (address != null) {
				httpInvoker.parameter("address", String.valueOf(address));
			}

			if (countryId != null) {
				httpInvoker.parameter("countryId", String.valueOf(countryId));
			}

			if (stateId != null) {
				httpInvoker.parameter("stateId", String.valueOf(stateId));
			}

			if (pinCode != null) {
				httpInvoker.parameter("pinCode", String.valueOf(pinCode));
			}

			if (organizationId != null) {
				httpInvoker.parameter(
					"organizationId", String.valueOf(organizationId));
			}

			if (subOrganizationId != null) {
				httpInvoker.parameter(
					"subOrganizationId", String.valueOf(subOrganizationId));
			}

			if (city != null) {
				httpInvoker.parameter("city", String.valueOf(city));
			}

			if (userPostId != null) {
				httpInvoker.parameter("userPostId", String.valueOf(userPostId));
			}

			httpInvoker.path(
				_builder._scheme + "://" + _builder._host + ":" +
					_builder._port + _builder._contextPath +
						"/o/jet-process-rs/v1.0/createReceipt");

			httpInvoker.userNameAndPassword(
				_builder._login + ":" + _builder._password);

			return httpInvoker.invoke();
		}

		private ReceiptRsModelResourceImpl(Builder builder) {
			_builder = builder;
		}

		private static final Logger _logger = Logger.getLogger(
			ReceiptRsModelResource.class.getName());

		private Builder _builder;

	}

}