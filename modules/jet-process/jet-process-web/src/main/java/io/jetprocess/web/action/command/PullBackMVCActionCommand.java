package io.jetprocess.web.action.command;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCResourceCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.core.util.FileStatus;
import io.jetprocess.masterdata.service.UserPostLocalService;
import io.jetprocess.model.DocFile;
import io.jetprocess.model.ReceiptMovement;
import io.jetprocess.service.DocFileLocalService;
import io.jetprocess.service.FileMovementLocalService;
import io.jetprocess.service.ReceiptMovementLocalService;
import io.jetprocess.web.constants.JetProcessWebPortletKeys;
import io.jetprocess.web.constants.MVCCommandNames;

@Component(immediate = true, property = { "javax.portlet.init-param.add-process-action-success-action=false",
		"javax.portlet.name=" + JetProcessWebPortletKeys.JETPROCESSWEB,
		"mvc.command.name=" + MVCCommandNames.PULL_BACK_FILE_ACTION_COMMAND }, service = MVCActionCommand.class)

public class PullBackMVCActionCommand extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		/*
		 * ThemeDisplay themeDisplay = (ThemeDisplay)
		 * actionRequest.getAttribute(WebKeys.THEME_DISPLAY); HttpSession
		 * sessionUserPost = themeDisplay.getRequest().getSession(); String userPosts =
		 * (String) sessionUserPost.getAttribute("userPostId"); long userpost =
		 * Long.parseLong(userPosts);
		 */
		long userpost = userPostLocalSerive.getUserPostId(actionRequest);
		long docFileId = ParamUtil.getLong(actionRequest, "docFileId");
		long fileMovementId = ParamUtil.getLong(actionRequest, "fileMovementId");
		String pullBackRemark = ParamUtil.getString(actionRequest, "pullBackRemark");
		Boolean pullBackAvailable = fileMovementLocalService.isPullBackAvailable(fileMovementId);
		if (pullBackAvailable) {
			DocFile docFile = docFileLocalService.getDocFileByDocFileId(docFileId);
			docFile.setCurrentlyWith(userpost);
			fileMovementLocalService.pullBackFileMovement(docFileId, fileMovementId, pullBackRemark);
			docFile.setCurrentState(FileStatus.CREADTED);
			docFileLocalService.updateDocFile(docFile);
			boolean active = fileMovementLocalService.isActive(docFileId);
			if (!active) {
				docFile.setCurrentState(FileStatus.CREADTED);
				docFileLocalService.updateDocFile(docFile);
			}
			SessionMessages.add(actionRequest, "pullback-available");
		} else {
			SessionErrors.add(actionRequest, "pullback-not-available");
			SessionMessages.add(actionRequest,
					PortalUtil.getPortletId(actionRequest) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
		}

		List<ReceiptMovement> receiptMovementList = receiptMovementLocalService.getReceiptMovementByFileMovementId(fileMovementId);
		if (receiptMovementList != null) {
			// Iterate list of receipt
			for (ReceiptMovement receiptMovement : receiptMovementList) {
				if (fileMovementId == receiptMovement.getFileInMovementId()) {
					receiptMovement.setActive(false);
					receiptMovementLocalService.updateReceiptMovement(receiptMovement);
				}

			}
		}
		actionResponse.setRenderParameter("mvcRenderCommandName", MVCCommandNames.FILE_SENT_RENDER_COMMAND);
	}

	@Reference
	FileMovementLocalService fileMovementLocalService;
	@Reference
	DocFileLocalService docFileLocalService;
	@Reference
	ReceiptMovementLocalService receiptMovementLocalService;
	@Reference
	UserPostLocalService userPostLocalSerive;
	

}
