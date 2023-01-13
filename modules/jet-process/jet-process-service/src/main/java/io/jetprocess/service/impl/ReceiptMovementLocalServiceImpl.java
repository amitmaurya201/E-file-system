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
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.List;

import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.core.util.FileStatus;
import io.jetprocess.core.constant.util.FileConstants;

import io.jetprocess.masterdata.service.MasterdataLocalService;
import io.jetprocess.model.FileMovement;
import io.jetprocess.model.Receipt;
import io.jetprocess.model.ReceiptMovement;
import io.jetprocess.service.ReceiptLocalService;
import io.jetprocess.service.base.ReceiptMovementLocalServiceBaseImpl;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=io.jetprocess.model.ReceiptMovement", service = AopService.class)
public class ReceiptMovementLocalServiceImpl extends ReceiptMovementLocalServiceBaseImpl {

	public void saveSendReceipt(long receiverId, long senderId, long receiptId, String priority, String dueDate,
			String remark) throws PortalException {
		boolean state = isReceiptMovementAvailable(receiptId);
		if (state == true) {
			saveReceiptMovement(receiverId, senderId, receiptId, priority, dueDate, remark);
		} else {
			Long rmId = masterdataLocalService.getMaximumRmIdByReceiptId(receiptId);
			ReceiptMovement rm;
			rm = receiptMovementLocalService.getReceiptMovement(rmId);
			if (rm.getReceivedOn().isEmpty() || rm.getReadOn().isEmpty()) {
				Receipt receipt;
				receipt = receiptLocalService.getReceipt(receiptId);
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
				saveReceiptMovement(receiverId, senderId, receiptId, priority, dueDate, remark);
			}
		}
	}

	void saveReceiptMovement(long receiverId, long senderId, long receiptId, String priority, String dueDate,
			String remark) {
		long rmId = counterLocalService.increment(ReceiptMovement.class.getName());
		ReceiptMovement receiptMovement = createReceiptMovement(rmId);
		receiptMovement.setRmId(rmId);
		receiptMovement.setReceiverId(receiverId);
		receiptMovement.setSenderId(senderId);
		receiptMovement.setReceiptId(receiptId);
		receiptMovement.setRemark(remark);
		receiptMovement.setPriority(priority);
		receiptMovement.setDueDate(dueDate);
		receiptMovement.setActive(true);
		try {
			Receipt receipt = receiptLocalService.getReceipt(receiptId);
			if (receiptId == receipt.getReceiptId()) {
				receipt.setCurrentlyWith(receiverId);
				receiptLocalService.updateReceipt(receipt);
				if (Validator.isNotNull(receipt.getCurrentState())) {
					receipt.setCurrentState(FileStatus.IN_MOVEMENT);
					receiptLocalService.updateReceipt(receipt);
				}
			}
		} catch (PortalException e) {
			logger.info(e.getMessage());
		}
		addReceiptMovement(receiptMovement);
	}

	public List<ReceiptMovement> getReceiptMovementByReceiptId(long receiptId) {
		return receiptMovementPersistence.findByreceiptId(receiptId);
	}

	public Boolean isPullBackAvailable(long rmId) {
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
			Boolean active = isActive(receiptId);
			if (!active) {
				receipt.setCurrentState(FileStatus.CREADTED);
			}
			receipt.setCurrentlyWith(userPostId);
			receiptLocalService.updateReceipt(receipt);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
	}

	public Boolean isActive(long receiptId) {
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

	public List<ReceiptMovement> getReceiptMovementByFileMovementId(long fileMovementId) {
		List<ReceiptMovement> receiptMovementList = receiptMovementPersistence
				.findBygetReceiptMovementsByfileMovementId(fileMovementId);
		return receiptMovementList;
	}

	private boolean isReceiptMovementAvailable(long receiptId) {
		List<ReceiptMovement> findByreceiptId = receiptMovementPersistence.findByreceiptId(receiptId);
		if (findByreceiptId.isEmpty()) {
			return true;
		}
		return false;
	}

	public boolean saveReadMovement(long receiptId, long rmId) {
		boolean state = false;
		try {
			state = pullBackedAlready(rmId);
			if (state == true) {
				List<ReceiptMovement> receiptMovement = receiptMovementLocalService
						.getReceiptMovementByReceiptId(receiptId);
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

	public void pullBackReceiptsAttatchWithFile(List<ReceiptMovement> receiptMovementList, long fileMovementId) {

		if (receiptMovementList != null) {
			// Iterate list of receipt
			for (ReceiptMovement receiptMovement : receiptMovementList) {
				if (fileMovementId == receiptMovement.getFileInMovementId()) {
					receiptMovement.setActive(false);
					receiptMovementLocalService.updateReceiptMovement(receiptMovement);
				}

			}
		}
	}

	@Reference
	ReceiptLocalService receiptLocalService;

	@Reference
	MasterdataLocalService masterdataLocalService;

	private Log logger = LogFactoryUtil.getLog(this.getClass());
}