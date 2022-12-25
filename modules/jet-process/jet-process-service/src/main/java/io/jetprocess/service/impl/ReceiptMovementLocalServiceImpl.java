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
import com.liferay.portal.kernel.util.Validator;

import java.util.List;
import java.util.logging.Logger;

import io.jetprocess.core.util.FileStatus;
import io.jetprocess.masterdata.model.ReceiptMovementDTO;
import io.jetprocess.masterdata.service.MasterdataLocalService;
import io.jetprocess.model.Receipt;
import io.jetprocess.model.ReceiptMovement;
import io.jetprocess.service.ReceiptLocalService;
import io.jetprocess.service.base.ReceiptMovementLocalServiceBaseImpl;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * @author Brian Wing Shun Chan
 */
@Component(property = "model.class.name=io.jetprocess.model.ReceiptMovement", service = AopService.class)
public class ReceiptMovementLocalServiceImpl extends ReceiptMovementLocalServiceBaseImpl {

	public void saveSendReceipt(long receiverId, long senderId, long receiptId, String priority, String dueDate,
			String remark) {
		logger.info("save send receipt");
		long rmId = counterLocalService.increment(ReceiptMovement.class.getName());
		ReceiptMovement receiptMovement = receiptMovementLocalService.createReceiptMovement(rmId);
		receiptMovement.setRmId(rmId);
		receiptMovement.setReceiverId(receiverId);
		receiptMovement.setSenderId(senderId);
		receiptMovement.setReceiptId(receiptId);
		receiptMovement.setRemark(remark);
		receiptMovement.setPriority(priority);
		receiptMovement.setDueDate(dueDate);
		receiptMovement.setActive(true);
		
		try {
			Receipt receipt = receiptLocalService.getReceiptByReceiptId(receiptId);
			if (receiptId == receipt.getReceiptId()) {
				receipt.setCurrentlyWith(receiverId);
				receiptLocalService.updateReceipt(receipt);
				if (Validator.isNotNull(receipt.getCurrentState())) {
					receipt.setCurrentState(FileStatus.IN_MOVEMENT);
					receiptLocalService.updateReceipt(receipt);
				}
			} else {
				logger.info( "ReceiptId not valid");
			}
		} catch (PortalException e) {
			e.printStackTrace();
		}
		logger.info( "ReceiptId  valid");
		receiptMovementLocalService.addReceiptMovement(receiptMovement);
		logger.info( "ReceiptId ");
	}

	public List<ReceiptMovement> getReceiptMovementByReceiptId(long receiptId) {
		return receiptMovementPersistence.findByreceiptId(receiptId);
	}

	public ReceiptMovement pullBackReceiptMovement(long receiptId, long receiptMovementId, String remarks)
			throws PortalException {
		ReceiptMovement receiptMovement = getReceiptMovement(receiptMovementId);
		Receipt receipt = receiptLocalService.getReceiptByReceiptId(receiptId);
		List<ReceiptMovementDTO> receiptMovementList = masterdataLocalService
				.getReceiptMovementListByReceiptId(receiptId);
		for (ReceiptMovementDTO receiptMovementDTO : receiptMovementList) {
			if (receiptMovement.getRmId() == receiptMovementDTO.getReceiptMovementId()) {
				logger.info(receipt.getCurrentlyWith());
				logger.info(receiptMovement.getSenderId());
				if(receipt.getCurrentlyWith() == receiptMovement.getSenderId()) {
					logger.info("receiptMovement");
					receipt.setCurrentState(FileStatus.CREADTED);
				}
				receiptMovement.setActive(false);
				receiptLocalService.updateReceipt(receipt);
			}
		}
		receiptMovement.setPullBackRemark(remarks);
		receiptMovementLocalService.updateReceiptMovement(receiptMovement);

		return receiptMovement;

	}

	@Reference
	ReceiptLocalService receiptLocalService;

	@Reference
	MasterdataLocalService masterdataLocalService;
	
	private Log logger = LogFactoryUtil.getLog(this.getClass());

}