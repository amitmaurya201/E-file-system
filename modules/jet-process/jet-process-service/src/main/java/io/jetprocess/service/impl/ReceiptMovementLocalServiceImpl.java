/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package io.jetprocess.service.impl;

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.core.constant.util.FileConstants;
import io.jetprocess.core.util.FileStatus;
import io.jetprocess.masterdata.service.MasterdataLocalService;
import io.jetprocess.model.Receipt;
import io.jetprocess.model.ReceiptMovement;
import io.jetprocess.service.ReceiptLocalService;
import io.jetprocess.service.base.ReceiptMovementLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=io.jetprocess.model.ReceiptMovement", service = AopService.class)
public class ReceiptMovementLocalServiceImpl extends ReceiptMovementLocalServiceBaseImpl {

	public void saveSendReceipt(long receiverId, long senderId, long receiptId, String priority, Date dueDate,
			String remark, boolean active, int currentState, long movementType) throws PortalException {
		long rmId = masterdataLocalService.getMaximumRmIdByReceiptId(receiptId);
		ReceiptMovement rm = receiptMovementLocalService.getReceiptMovement(rmId);
		if (rm.getReceivedOn().isEmpty() || rm.getReadOn().isEmpty()) {
			Receipt receipt = receiptLocalService.getReceipt(receiptId);
			if (receipt.getNature().equals(FileConstants.ELECTRONIC_NATURE)) {
				if (rm.getActive() == false) {
					rm.setReadOn("");
				} else {
					rm.setReadOn(FileConstants.READ);
				}
			} else if (receipt.getNature().equals(FileConstants.PHYSICAL_NATURE)) {
				if (rm.getActive() == false) {
					rm.setReadOn("");
				} else {
					rm.setReceivedOn(FileConstants.RECEIVE);
				}
			}
			updateReceiptMovement(rm);

		}
		saveReceiptMovement(receiverId, senderId, receiptId, priority, dueDate, remark, active, currentState,
				movementType);
	}

	public void saveReceiptMovement(long receiverId, long senderId, long receiptId, String priority, Date dueDate,
			String remark, boolean active, int currentState, long movementType) {
		long rmId = counterLocalService.increment(ReceiptMovement.class.getName());
		ReceiptMovement receiptMovement;
		try {
			receiptMovement = createReceiptMovement(rmId);
			receiptMovement.setRmId(rmId);
			receiptMovement.setReceiverId(receiverId);
			receiptMovement.setSenderId(senderId);
			receiptMovement.setReceiptId(receiptId);
			receiptMovement.setRemark(remark);
			receiptMovement.setPriority(priority);
			receiptMovement.setDueDate(dueDate);
			receiptMovement.setActive(active);
			receiptMovement.setMovementType(movementType);
			addReceiptMovement(receiptMovement);
			Receipt receipt = receiptLocalService.getReceipt(receiptId);
			receipt.setCurrentlyWith(receiverId);
			receipt.setCurrentState(currentState);
			receiptLocalService.updateReceipt(receipt);
		} catch (PortalException e) {
			logger.info(e.getMessage());
		}
	}

	public List<ReceiptMovement> getReceiptMovementByReceiptId(long receiptId) {
		return receiptMovementPersistence.findByreceiptId(receiptId);
	}

	public boolean isPullBackAvailable(long rmId) {
		boolean pullable = false;
		ReceiptMovement receiptMovement;
		try {
			receiptMovement = getReceiptMovement(rmId);
			if ((receiptMovement.getReceivedOn().isEmpty()) && (receiptMovement.getReadOn().isEmpty())) {
				pullable = true;
			}
		} catch (PortalException e) {
			logger.info(e.getMessage());
		}
		return pullable;
	}

	public void pullBackReceiptMovement(long receiptId, long receiptMovementId, String remarks, long userPostId)
			throws PortalException {
		try {
			// for the set pull back remark in receipt movement
			ReceiptMovement receiptMovement = getReceiptMovement(receiptMovementId);
			List<ReceiptMovement> receiptMovementByReceiptIdList = getReceiptMovementByReceiptId(receiptId);
			for (ReceiptMovement receiptMovementByReceiptId : receiptMovementByReceiptIdList) {
				if (receiptMovement.getRmId() == receiptMovementByReceiptId.getRmId()) {
					receiptMovement.setActive(false);
					receiptMovement.setPullBackRemark(remarks);
					updateReceiptMovement(receiptMovement);
				}
			}
			// for set current state as 1 in receipt
			Receipt receipt = receiptLocalService.getReceipt(receiptId);
			boolean active = isActive(receiptId);
			if (!active) {
				receipt.setCurrentState(FileStatus.CREADTED);
			}
			receipt.setCurrentlyWith(userPostId);
			receiptLocalService.updateReceipt(receipt);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}

	public boolean isActive(long receiptId) {
		boolean state = false;
		List<ReceiptMovement> receiptMovementByReceiptIdList = getReceiptMovementByReceiptId(receiptId);
		for (ReceiptMovement receiptMovementByReceiptId : receiptMovementByReceiptIdList) {
			if (!receiptMovementByReceiptId.getActive()) {
				state = false;
			} else {
				state = true;
				break;
			}
		}
		return state;
	}

	public boolean pullBackedAlready(long rmId) throws PortalException {
		logger.info("pull back already");
		boolean state = false;
		ReceiptMovement receiptMovement = getReceiptMovement(rmId);
		if (receiptMovement.getPullBackRemark().isEmpty()) {
			state = true;
		}
		return state;
	}

	// Create method for getReceiptMovementByFileMovementId 
	public List<ReceiptMovement> getReceiptMovementByFileMovementId(long fileMovementId) {
		List<ReceiptMovement> receiptMovementList = receiptMovementPersistence
				.findByReceiptMovementsByfileMovementId(fileMovementId);
		return receiptMovementList;
	}

	public boolean saveReadMovement(long receiptId, long rmId) {
		boolean state = false;
		try {
			state = pullBackedAlready(rmId);
			if (state == true) {
				List<ReceiptMovement> receiptMovement = getReceiptMovementByReceiptId(receiptId);
				for (ReceiptMovement receiptMovement2 : receiptMovement) {
					if (receiptMovement2.getReceiptId() == receiptId) {
						receiptMovement2.setReadOn("read");
						updateReceiptMovement(receiptMovement2);
					}
				}
			}
		} catch (PortalException e) {
			logger.info(e.getMessage());
		}
		return state;
	}

	public boolean saveReceiveMovement(long receiptId, long rmId) {
		boolean state = false;
		try {
			state = pullBackedAlready(rmId);
			if (state == true) {
				List<ReceiptMovement> receiptMovement = getReceiptMovementByReceiptId(receiptId);
				for (ReceiptMovement receiptMovement2 : receiptMovement) {
					if (receiptMovement2.getReceiptId() == receiptId) {
						receiptMovement2.setReceivedOn("receive");
						updateReceiptMovement(receiptMovement2);
					}
				}
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return state;
	}

// pull back those receipts which has been attached with file when file will be pull back
	public void pullBackReceiptsAttatchWithFile(List<ReceiptMovement> receiptMovementList, long fileMovementId) {
		if (receiptMovementList != null) {
			// Iterate list of receipt
			for (ReceiptMovement receiptMovement : receiptMovementList) {
				if (fileMovementId == receiptMovement.getFileInMovementId()) {
					receiptMovement.setPullBackRemark("pull-backed with file");
					receiptMovement.setActive(false);
					updateReceiptMovement(receiptMovement);
				}
			}
		}
	}

	public boolean isCreatedReceiptAttachable(long receiptId, long receiptMovementId) throws PortalException {
		boolean attachable = false;
		Receipt receipt = receiptLocalService.getReceipt(receiptId);
		ReceiptMovement receiptMovement = getReceiptMovement(receiptMovementId);
		if ((receipt.getAttachStatus().isEmpty() || receipt.getAttachStatus() == null)
				&& !receiptMovement.getActive()) {
			logger.info("isCreatedList attachable true");
			attachable = true;
		}

		return attachable;
	}

	// method for isReceiptAttachable
	public boolean isInboxReceiptAttachable(long receiptId, long receiptMovementId) throws PortalException {
		logger.info("isInboxReceiptAttachable..........." + " receiptId : " + receiptId + ", movement id : "
				+ receiptMovementId);
		boolean attachable = false;
		Receipt receipt = receiptLocalService.getReceipt(receiptId);
		ReceiptMovement receiptMovement = getReceiptMovement(receiptMovementId);
		if ((receipt.getAttachStatus().isEmpty() || receipt.getAttachStatus() == null) && receiptMovement.getActive()) {
			logger.info("attachable true");
			attachable = true;
		}
		return attachable;
	}

	@Reference
	private ReceiptLocalService receiptLocalService;

	@Reference
	private MasterdataLocalService masterdataLocalService;

	private Log logger = LogFactoryUtil.getLog(this.getClass());
}
