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

import javax.swing.text.StyledEditorKit.BoldAction;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.core.util.FileStatus;
import io.jetprocess.masterdata.model.ReceiptMovementDTO;
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

	public void saveSendReceipt(long receiverId, long senderId, long receiptId, String priority, String dueDate,
			String remark) {

		List<ReceiptMovement> receiptMovementList = receiptMovementLocalService.getReceiptMovements(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);

		ReceiptMovement receiptMovement = receiptMovementList.stream()
				.filter(receipt -> receipt.getReceiptId() == receiptId).findAny().orElse(null);

		if (receiptMovement == null) {

			saveReceiptMovement(receiverId, senderId, receiptId, priority, dueDate, remark);

		} else {

			Long rmId = masterdataLocalService.getMaximumRmIdByReceiptId(receiptId);

			try {
				ReceiptMovement rm;
				try {
					rm = receiptMovementLocalService.getReceiptMovement(rmId);
					if (rm.getReceivedOn().isEmpty() || rm.getReadOn().isEmpty()) {

						Receipt receipt;
						try {
							receipt = receiptLocalService.getReceipt(receiptId);
							if (receipt.getNature().equals("Electronic")) {

								if (!rm.getReceivedOn().isEmpty() || !rm.getReadOn().isEmpty()) {

									saveReceiptMovement(receiverId, senderId, receiptId, priority, dueDate, remark);

								} else {

									rm.setReadOn("read");
									receiptMovementLocalService.updateReceiptMovement(rm);
									saveReceiptMovement(receiverId, senderId, receiptId, priority, dueDate, remark);

								}

							} else if (receipt.getNature().equals("Physical")) {

								if (!rm.getReceivedOn().isEmpty() || !rm.getReadOn().isEmpty()) {

									saveReceiptMovement(receiverId, senderId, receiptId, priority, dueDate, remark);

								} else {

									rm.setReceivedOn("receive");
									receiptMovementLocalService.updateReceiptMovement(rm);
									saveReceiptMovement(receiverId, senderId, receiptId, priority, dueDate, remark);

								}
							}
						} catch (PortalException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

					}
				} catch (PortalException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			finally {

			}

		}

	}

	void saveReceiptMovement(long receiverId, long senderId, long receiptId, String priority, String dueDate,
			String remark) {

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
			}
		} catch (PortalException e) {
			logger.info(e.getMessage());
		}
		receiptMovementLocalService.addReceiptMovement(receiptMovement);
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
			List<ReceiptMovement> receiptMovementByReceiptIdList = receiptMovementLocalService
					.getReceiptMovementByReceiptId(receiptId);
			for (ReceiptMovement receiptMovementByReceiptId : receiptMovementByReceiptIdList) {
				if (receiptMovement.getRmId() == receiptMovementByReceiptId.getRmId()) {
					receiptMovement.setActive(false);
					receiptMovement.setPullBackRemark(remarks);
					receiptMovementLocalService.updateReceiptMovement(receiptMovement);
				}
			}

			// for set current state as 1 in receipt
			Receipt receipt = receiptLocalService.getReceiptByReceiptId(receiptId);
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
		List<ReceiptMovement> receiptMovementByReceiptIdList = receiptMovementLocalService
				.getReceiptMovementByReceiptId(receiptId);
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
		List<ReceiptMovement> receiptMovementList = receiptMovementLocalService.getReceiptMovements(QueryUtil.ALL_POS,
				QueryUtil.ALL_POS);
		for (ReceiptMovement receiptMovement : receiptMovementList) {
			if (fileMovementId == receiptMovement.getFileInMovementId()) {
				return receiptMovementList;
			}
		}
		return receiptMovementList;
	}

	public boolean saveReadAction(long receiptId, long rmId) {
		boolean state = false;
		try {
			state = receiptMovementLocalService.pullBackedAlready(rmId);
			if (state == true) {
				List<ReceiptMovement> receiptMovement = receiptMovementLocalService
						.getReceiptMovementByReceiptId(receiptId);
				for (ReceiptMovement receiptMovement2 : receiptMovement) {
					if (receiptMovement2.getReceiptId() == receiptId) {
						receiptMovement2.setReadOn("read");
						receiptMovementLocalService.updateReceiptMovement(receiptMovement2);
					}
				}
			}
		} catch (PortalException e) {
			logger.info(e.getMessage());
		}
		return state;
	}

	public boolean saveReceiveAction(long receiptId, long rmId) {
		boolean state = false;
		try {
			state = receiptMovementLocalService.pullBackedAlready(rmId);
			if (state == true) {
				List<ReceiptMovement> receiptMovement = receiptMovementLocalService
						.getReceiptMovementByReceiptId(receiptId);
				for (ReceiptMovement receiptMovement2 : receiptMovement) {
					if (receiptMovement2.getReceiptId() == receiptId) {
						receiptMovement2.setReceivedOn("receive");
						receiptMovementLocalService.updateReceiptMovement(receiptMovement2);
					}
				}
			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return state;
	}

	@Reference
	ReceiptLocalService receiptLocalService;

	@Reference
	MasterdataLocalService masterdataLocalService;

	private Log logger = LogFactoryUtil.getLog(this.getClass());
}