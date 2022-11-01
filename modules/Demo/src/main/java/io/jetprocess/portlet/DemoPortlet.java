package io.jetprocess.portlet;

import io.jetprocess.constants.DemoPortletKeys;
import io.jetprocess.masterdata.model.FileListViewDto;
import io.jetprocess.masterdata.model.Masterdata;
import io.jetprocess.masterdata.model.ReceiptListViewDto;
import io.jetprocess.masterdata.service.MasterdataLocalService;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Admin
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css", "com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=Demo", "javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp", "javax.portlet.name=" + DemoPortletKeys.DEMO,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class DemoPortlet extends MVCPortlet {

	@Reference
	MasterdataLocalService masterdataLocalService;

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		System.out.println("----------------");

		List<ReceiptListViewDto> list = masterdataLocalService.getReceiptList();
		for (ReceiptListViewDto receiptListViewDto : list) {
			System.out.println("data --" + receiptListViewDto.getReceiptNumber());
			System.out.println("data --" + receiptListViewDto.getSubject());
			System.out.println("data --" + receiptListViewDto.getCategory());
			System.out.println("data --" + receiptListViewDto.getCreateDate());
			System.out.println("data --" + receiptListViewDto.getRemark());

		}

		/*
		 * List<FileListViewDto> list = masterdataLocalService.getFileList(); for
		 * (FileListViewDto fileListViewDto : list) {
		 * System.out.println(fileListViewDto.getFileNumber());
		 * System.out.println(fileListViewDto.getSubject());
		 * System.out.println(fileListViewDto.getCategory());
		 * System.out.println(fileListViewDto.getCreateDate());
		 * System.out.println(fileListViewDto.getRemark());
		 * 
		 * }
		 * 
		 * List<ReceiptListViewDto> list1 = masterdataLocalService.getReceiptList(); for
		 * (ReceiptListViewDto fileListViewDto : list1) {
		 * System.out.println(fileListViewDto.getReceiptNumber());
		 * System.out.println(fileListViewDto.getSubject());
		 * System.out.println(fileListViewDto.getCategory());
		 * System.out.println(fileListViewDto.getCreateDate());
		 * System.out.println(fileListViewDto.getRemark());
		 * 
		 * }
		 */ super.doView(renderRequest, renderResponse);
	}

}