package io.jetprocess.masterdata.service.persistence.impl;

import com.liferay.portal.dao.orm.custom.sql.CustomSQL;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.math.BigInteger;
import java.util.Collections;
import java.util.List;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import io.jetprocess.masterdata.model.FileCorrespondenceReceiptDTO;
import io.jetprocess.masterdata.model.FileListViewDto;
import io.jetprocess.masterdata.model.FileMovementDTO;
import io.jetprocess.masterdata.model.GenericModelMapper;
import io.jetprocess.masterdata.model.Masterdata;
import io.jetprocess.masterdata.model.ReceiptListViewDto;
import io.jetprocess.masterdata.model.ReceiptMovementDTO;
import io.jetprocess.masterdata.model.impl.MasterdataImpl;
import io.jetprocess.masterdata.service.persistence.MasterdataFinder;

@Component(service = MasterdataFinder.class)
public class MasterdataFinderImpl extends MasterdataFinderBaseImpl implements MasterdataFinder {

	@Reference
	private CustomSQL customSQL;
	
	public List<ReceiptMovementDTO> getReceiptInboxList(long userPostId) {

		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getReceiptInboxList");
			logger.info("Get Receipt Inbox List Query: "+sql);
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(userPostId);
			return  GenericModelMapper.map(ReceiptMovementDTO.class, sqlQuery.list());

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	public List<Masterdata> getCategories() {
		List<Masterdata> masterdataList = Collections.EMPTY_LIST;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getCategories");
			SQLQuery sqlQuery = session.createSQLQuery(sql);

			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			masterdataList = (List<Masterdata>) sqlQuery.list();
			return masterdataList;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return masterdataList;

	}

	public List<Masterdata> getSubCategories(long categoryId) {

		List<Masterdata> subCategoryList = Collections.EMPTY_LIST;
		Session session = null;

		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getSubCategories");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(categoryId);
			subCategoryList = (List<Masterdata>) sqlQuery.list();
			return subCategoryList;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return subCategoryList;

	}
	public List<Masterdata> getType() {

		List<Masterdata> typeList = Collections.EMPTY_LIST;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getType");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			typeList = (List<Masterdata>) sqlQuery.list();
			return typeList;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return typeList;

	}

	public List<Masterdata> getDeliveryMode() {

		List<Masterdata> deliveryModeList = Collections.EMPTY_LIST;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getDeliveryMode");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			deliveryModeList = (List<Masterdata>) sqlQuery.list();
			return deliveryModeList;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return deliveryModeList;
	}

	public List<Masterdata> getFileCode() {

		List<Masterdata> fileCodeList = Collections.EMPTY_LIST;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getFileCode");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			fileCodeList = (List<Masterdata>) sqlQuery.list();
			return fileCodeList;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return fileCodeList;

	}

	public List<Masterdata> getBasicHeads() {
		List<Masterdata> basicHeadList = Collections.EMPTY_LIST;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getBasicHeads");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			basicHeadList = (List<Masterdata>) sqlQuery.list();
			return basicHeadList;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return basicHeadList;
	}

	public List<Masterdata> getPrimaryHeads(long basicHeadId) {

		List<Masterdata> primaryHeadList = Collections.EMPTY_LIST;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getPrimaryHeads");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(basicHeadId);

			primaryHeadList = (List<Masterdata>) sqlQuery.list();
			return primaryHeadList;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}

		return primaryHeadList;
	}

	public List<Masterdata> getSecondaryHeads(long primaryHeadId) {

		List<Masterdata> secondaryHeadList = Collections.EMPTY_LIST;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getSecondaryHeads");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(primaryHeadId);
			secondaryHeadList = (List<Masterdata>) sqlQuery.list();
			return secondaryHeadList;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return secondaryHeadList;
	}

	public List<Masterdata> getTeritaryHeads(long secondaryHeadsId) {

		List<Masterdata> teritaryHeadList = Collections.EMPTY_LIST;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getTeritaryHeads");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(secondaryHeadsId);
			teritaryHeadList = (List<Masterdata>) sqlQuery.list();
			return teritaryHeadList;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return teritaryHeadList;
	}

	public List<Masterdata> getOrganization() {

		List<Masterdata> organizationList = Collections.EMPTY_LIST;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getOrganizations");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			organizationList = (List<Masterdata>) sqlQuery.list();
			return organizationList;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return organizationList;
	}

	public List<Masterdata> getSubOrganization(long organizationId) {

		List<Masterdata> subOrganizationList = Collections.EMPTY_LIST;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getSubOrganizations");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(organizationId);
			subOrganizationList = (List<Masterdata>) sqlQuery.list();
			return subOrganizationList;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return subOrganizationList;
	}

	public List<Masterdata> getReceiptCategory() {

		List<Masterdata> receiptCategoryList = Collections.EMPTY_LIST;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getReceiptCategory");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			receiptCategoryList = (List<Masterdata>) sqlQuery.list();
			return receiptCategoryList;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return receiptCategoryList;
	}

	public List<Masterdata> getReceiptSubCategory(long receiptCategoryId) {

		List<Masterdata> receiptSubCategoryList = Collections.EMPTY_LIST;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getReceiptSubCategory");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(receiptCategoryId);
			receiptSubCategoryList = (List<Masterdata>) sqlQuery.list();
			return receiptSubCategoryList;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return receiptSubCategoryList;
	}

	public List<Masterdata> getCountries() {

		List<Masterdata> countryList = Collections.EMPTY_LIST;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getCountries");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);

			countryList = (List<Masterdata>) sqlQuery.list();
			return countryList;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return countryList;
	}

	public List<Masterdata> getStates(long countryId) {

		List<Masterdata> stateList = Collections.EMPTY_LIST;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getStates");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(countryId);
			stateList = (List<Masterdata>) sqlQuery.list();
			return stateList;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return stateList;
	}

	public Masterdata getBasicHeadById(long basicHeadId) {
		Object obj = null;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getBasicHeadById");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(basicHeadId);
			obj = sqlQuery.uniqueResult();
			return (Masterdata) obj;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return (Masterdata) obj;
	}

	public Masterdata getPrimaryHeadById(long primaryHeadId) {
		Object obj = null;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getPrimaryHeadById");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(primaryHeadId);
			obj = sqlQuery.uniqueResult();
			return (Masterdata) obj;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return (Masterdata) obj;
	}

	public Masterdata getSecondaryHeadById(long secondaryHeadId) {
		Object obj = null;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getSecondaryHeadById");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(secondaryHeadId);
			obj = sqlQuery.uniqueResult();
			return (Masterdata) obj;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return (Masterdata) obj;
	}

	public Masterdata getTertiaryHeadById(long tertiaryHeadId) {
		Object obj = null;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getTertiaryHeadById");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(tertiaryHeadId);
			obj = sqlQuery.uniqueResult();
			return (Masterdata) obj;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return (Masterdata) obj;
	}

	public List<FileListViewDto> getFileCreatedList(long userPostId) {

		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "fileCreatedListQuery");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(userPostId);
			return  GenericModelMapper.map(FileListViewDto.class, sqlQuery.list());

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}
	public List<ReceiptListViewDto> getReceiptCreatedList(long userPostId) {

		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "receiptCreatedListQuery");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(userPostId);
			return  GenericModelMapper.map(ReceiptListViewDto.class, sqlQuery.list());

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}


	public int getFileCreatedListCount(long userPostId) {

		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "fileListCount");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			System.out.println("query---"+sql);
			sqlQuery.setCacheable(false);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(userPostId);
			List  count = sqlQuery.list();
			BigInteger b1 = null;
			for (Object object : count) {
				b1 = (BigInteger) object;
			}
			 int i1 = b1.intValue();
			 
			
			
			return i1;
			
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return (Integer)null;
	}

	public int getReceiptCreatedListCount(long userPostId) {

		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "receiptListCount");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			System.out.println("query---"+sql);
			sqlQuery.setCacheable(false);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(userPostId);
			List  count = sqlQuery.list();
			BigInteger b1 = null;
			for (Object object : count) {
				b1 = (BigInteger) object;
			}
			 int i1 = b1.intValue();
			 return i1;
			
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return (Integer) null;
	}

	public Masterdata getFileCodeValueById(long fileCodeId) {
		Object object = null;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getFileCodeValueById");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			System.out.println(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(fileCodeId);
			object = sqlQuery.uniqueResult();
			
			
			return (Masterdata)object;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}
	public Masterdata getCategoryValueById(long categoryId) {
		Object object = null;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getCategoryValueById");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			System.out.println(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(categoryId);
			object = sqlQuery.uniqueResult();
			
			return (Masterdata)object;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}
	public Masterdata getSubCategoryValueById(long subCategoryId) {
		Object object = null;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getSubCategoryValueById");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			System.out.println(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(subCategoryId);
			object = sqlQuery.uniqueResult();
			
			return (Masterdata)object;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	public Masterdata getTypeValueById(long typeId) {
		Object object = null;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getTypeValueById");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			System.out.println(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(typeId);
			object = sqlQuery.uniqueResult();
			
			return (Masterdata)object;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}
	public Masterdata getDeliveryModeValueById(long deliveryModeId) {
		Object object = null;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getDeliveryModeValueById");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			System.out.println(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(deliveryModeId);
			object = sqlQuery.uniqueResult();
			
			return (Masterdata)object;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	public Masterdata getOrganizationValueById(long organizationId) {
		Object object = null;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getOrganizationValueById");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			System.out.println(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(organizationId);
			object = sqlQuery.uniqueResult();
			
			return (Masterdata)object;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}
	public Masterdata getSubOrganizationValueById(long subOrganizationId) {
		Object object = null;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getSubOrganizationValueById");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			System.out.println(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(subOrganizationId);
			object = sqlQuery.uniqueResult();
			
			return (Masterdata)object;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	public Masterdata getCountryValueById(long countryId) {
		Object object = null;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getCountryValueById");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			System.out.println(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(countryId);
			object = sqlQuery.uniqueResult();
			
			return (Masterdata)object;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}
	public Masterdata getStateValueById(long stateId) {
		Object object = null;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getStateValueById");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			System.out.println(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(stateId);
			object = sqlQuery.uniqueResult();
			
			return (Masterdata)object;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}
	public Masterdata getReceiptCategoryValueById(long receiptCategoryId) {
		Object object = null;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getReceiptCategoryValueById");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			System.out.println(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(receiptCategoryId);
			object = sqlQuery.uniqueResult();
			
			return (Masterdata)object;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}


	public Masterdata getReceiptSubCategoryValueById(long receiptSubCategoryId) {
		Object object = null;
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getReceiptSubCategoryValueById");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			System.out.println(sql);
			sqlQuery.setCacheable(false);
			sqlQuery.addEntity("Masterdata", MasterdataImpl.class);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(receiptSubCategoryId);
			object = sqlQuery.uniqueResult();
			
			return (Masterdata)object;

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	public List<FileListViewDto> getFileCreatedListSearch(long userPostId, String data) {

		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getFileCreatedListData");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(userPostId);
			queryPos.add(data);
			return  GenericModelMapper.map(FileListViewDto.class, sqlQuery.list());

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}
	
	
	@SuppressWarnings("unchecked")
	public List<FileListViewDto> getFileCreatedListSearch1(long userPostId, String keyword , int start , int end ,  String orderBy ,  String order ) {

		System.out.println("userPostId: "+ userPostId+ ", keyword : "+ keyword + ", start:"+ start +", end : "+ end +", orderBy : "+ orderBy +", order : "+ order );
		Session session = null;
		try {
			session = openSession();
			
			String sql = "Select  docfileid , filenumber , subject , categoryvalue as category , remarks as remark , createDate as createdOn  ,  nature " + 
					"FROM jet_process_docfile  INNER JOIN " + 
					"md_category  ON categorydataid = categoryid where userpostid = ? And currentstate = 1";
			
		
			if(!keyword.isEmpty() && keyword != null ) {
				sql = sql+" AND (filenumber ilike ? OR subject ilike ? OR  categoryvalue ilike ?)";
			}
			
			if(orderBy!=null && !orderBy.isEmpty()) {
				sql = sql + " order by "+orderBy;
				sql = sql + " "+order;
				System.out.println("order by ---"+orderBy);			
			}

			sql = sql + " offset "+ start + " limit "+ end;
			System.out.println("final query--: "+sql);
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			logger.info("List Binded------------1");
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(userPostId);
			if(!keyword.isEmpty() && keyword != null) {
				queryPos.add("%"+keyword+"%");
				queryPos.add("%"+keyword+"%");
				queryPos.add("%"+keyword+"%");
			}
	
			return  GenericModelMapper.map(FileListViewDto.class, sqlQuery.list());

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}
	
	
	public List<ReceiptListViewDto> getReceiptListSearch(long userPostId, String keyword , int start , int end ,  String orderBy ,  String order ) {

		System.out.println("userPostId: "+ userPostId+ ", keyword : "+ keyword + ", start:"+ start +", end : "+ end +", orderBy : "+ orderBy +", order : "+ order );
		Session session = null;
		try {
			session = openSession();
	
			String sql = "SELECT receiptid as receiptId , receiptnumber as receiptnumber , subject as subject , categoryvalue as category , createDate as createDate ,  remarks as remark , viewpdfurl, nature " + 
					"			FROM jet_process_receipt INNER JOIN" + 
					"			md_category  ON categorydataid = receiptcategoryid where userpostid = ? AND  currentstate = 1 AND attachstatus IS NULL ";
			
		
			if(!keyword.isEmpty() && keyword != null ) {

				
				sql = sql+" AND (receiptnumber ilike ? OR subject ilike ? OR categoryvalue ilike ?)";
				
			}
			
			if(orderBy!=null && !orderBy.isEmpty()) {
				sql = sql + " order by "+orderBy;
				sql = sql + " "+order;
				System.out.println("order by ---"+orderBy);			
			}

			
			sql = sql + " offset "+ start + " limit "+ end;
			System.out.println("final query--: "+sql);
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(userPostId);
			if(!keyword.isEmpty() && keyword != null) {
				queryPos.add("%"+keyword+"%");
				queryPos.add("%"+keyword+"%");
				queryPos.add("%"+keyword+"%");
			}
	
			return  GenericModelMapper.map(ReceiptListViewDto.class, sqlQuery.list());

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}
	
	
	
	
	public List<FileListViewDto> getFileCreatedListSearchBykey(long userPostId, String keyword) {

		System.out.println("userPostId: "+ userPostId+ ", keyword : "+ keyword );
		Session session = null;
		try {
			session = openSession();
			//String sql = customSQL.get(getClass(), "getFileCreatedListData");
			
			String sql = "Select  docfileid , filenumber , subject , categoryvalue as category , remarks as remark , createDate as createdOn ,  nature " + 
					"FROM jet_process_docfile  INNER JOIN " + 
					"md_category  ON categorydataid = categoryid where userpostid = ?  AND  currentstate = 1";
			
		
			if(!keyword.isEmpty() && keyword != null ) {
				sql = sql+"AND (filenumber ilike ? OR subject ilike ? OR  categoryvalue ilike ?)";
			}
				
				
			System.out.println("final query--: "+sql);
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			logger.info("List Binded------------2");

			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(userPostId);
			if(!keyword.isEmpty() && keyword != null) {
				queryPos.add("%"+keyword+"%");
				queryPos.add("%"+keyword+"%");
				queryPos.add("%"+keyword+"%");
			}
	
			return  GenericModelMapper.map(FileListViewDto.class, sqlQuery.list());

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	
	

	public List<ReceiptListViewDto> getReceiptCreatedListSearch(long userPostId, String keyword) {

		Session session = null;
		try {
			session = openSession();
			String sql = "SELECT receiptid as receiptId , receiptnumber as receiptnumber , subject as subject , categoryvalue as category , createDate as createDate ,  remarks as remark , viewpdfurl, nature " + 
					"	nature FROM jet_process_receipt INNER JOIN " + 
					"	md_category  ON categorydataid = receiptcategoryid where userpostid = ? AND currentstate = 1 AND attachstatus IS NULL ";
			if(!keyword.isEmpty() && keyword != null ) {
				sql = sql+"AND (receiptnumber ilike ? OR subject ilike ? OR  categoryvalue ilike ?)";
			}
				
				
			System.out.println("final query--: "+sql);
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(userPostId);
			if(!keyword.isEmpty() && keyword != null) {
				queryPos.add("%"+keyword+"%");
				queryPos.add("%"+keyword+"%");
				queryPos.add("%"+keyword+"%");
			}
			return  GenericModelMapper.map(ReceiptListViewDto.class, sqlQuery.list());

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}
	
	public List<ReceiptMovementDTO> getReceiptSentListByFinder(long userPostId) {
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getReceiptSentList");
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(userPostId);
			return  GenericModelMapper.map(ReceiptMovementDTO.class, sqlQuery.list());

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}


public List<ReceiptMovementDTO> getReceiptMovementListByReceiptId(long receiptId){
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getReceiptMovementList");
			logger.info("Final Receipt Movement List Query : "+sql);
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(receiptId);
			return  GenericModelMapper.map(ReceiptMovementDTO.class, sqlQuery.list());

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

public List<FileMovementDTO> getFileInboxList(long userPostId) {

	Session session = null;
	try {
		session = openSession();
		String sql = customSQL.get(getClass(), "getFileInboxList");
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		sqlQuery.setCacheable(false);
		QueryPos queryPos = QueryPos.getInstance(sqlQuery);
		queryPos.add(userPostId);
		return  GenericModelMapper.map(FileMovementDTO.class, sqlQuery.list());

	} catch (Exception e) {
		try {
			throw new SystemException(e);
		} catch (SystemException se) {
			se.printStackTrace();
		}
	} finally {
		closeSession(session);
	}
	return null;
}


	
	
	public List<FileMovementDTO> getFileMovementListByFileId(long fileId){
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getFileMovementList");
			logger.info("Final File Movement List Query : "+sql);
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(fileId);
			return  GenericModelMapper.map(FileMovementDTO.class, sqlQuery.list());
			
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}
	
	
	public List<FileMovementDTO> getFileSentList(long userPostId){
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getSentFileList");
			logger.info("Final File Movement List Query : "+sql);
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(userPostId);
			return  GenericModelMapper.map(FileMovementDTO.class, sqlQuery.list());
			
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}


	

	// ---------------------------
	
	public List<FileMovementDTO> getFileSentList(long userPostId, String keyword){
		Session session = null;
		try {
			session = openSession();
//			String sql = customSQL.get(getClass(), "getSentFileList");
			
			
			
			String sql="SELECT fm.fmid as fileMovementId, f.filenumber , f.subject ," + 
					"		null as sendBy," + 
					"        (SELECT concat(up1.username,'( ' , up1.postmarking,') ' , up1.sectionname,', ' , up1.departmentname)) AS sentTo ," + 
					"		fm.createdate as SentOn, fm.readon as readOn, fm.duedate , null as remark, fm.receivedon as receivedOn , f.currentlywith as currentlyWith , f.nature as nature , f.docfileid as fileId , 0 as senderid , f.currentstate as currentState , f.docfileid as docFileId , fm.pullbackremark as pullBackRemark" + 
					"		FROM jet_process_filemovement as fm " + 
					"	      JOIN jet_process_docfile as f ON fm.fileId = f.docfileid        " + 
					"	      JOIN masterdata_userpost as up1 ON fm.receiverid = up1.userpostid " + 
					"		where fm.senderid = ? AND currentstate = 2  AND fm.active_ = true AND fm.pullbackremark is null ";
			
			logger.info("Final File Movement List Query : "+sql);
			
			if(!keyword.isEmpty() && keyword != null ) {
				sql = sql+"AND (f.filenumber ilike ? OR f.subject ilike ?)";
			}
				
				
			System.out.println("final query--: "+sql);
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(userPostId);
			if(!keyword.isEmpty() && keyword != null) {
				queryPos.add("%"+keyword+"%");
				queryPos.add("%"+keyword+"%");
			}
			return  GenericModelMapper.map(FileMovementDTO.class, sqlQuery.list());
			
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	
	
	public List<FileMovementDTO> getFileSentList(long userPostId, String keyword , int start , int end ,  String orderBy ,  String order ) {

		System.out.println("userPostId: "+ userPostId+ ", keyword : "+ keyword + ", start:"+ start +", end : "+ end +", orderBy : "+ orderBy +", order : "+ order );
		Session session = null;
		try {
			session = openSession();
	
			String sql="SELECT fm.fmid as fileMovementId, f.filenumber , f.subject ," + 
					"		null as sendBy," + 
					"        (SELECT concat(up1.username,'( ' , up1.postmarking,') ' , up1.sectionname,', ' , up1.departmentname)) AS sentTo ," + 
					"		fm.createdate as SentOn, fm.readon as readOn, fm.duedate , null as remark, fm.receivedon as receivedOn , f.currentlywith as currentlyWith , f.nature as nature , f.docfileid as fileId , 0 as senderid ,f.currentstate as currentState , f.docfileid as docFileId , null as pullBackRemark" + 
					"		FROM jet_process_filemovement as fm " + 
					"		  JOIN jet_process_docfile as f ON fm.fileId = f.docfileid        " + 
					"		  JOIN masterdata_userpost as up1 ON fm.receiverid = up1.userpostid " + 
					"		where fm.senderid = ? AND currentstate = 2  AND fm.active_ = true AND fm.pullbackremark is null ";
			
		
			if(!keyword.isEmpty() && keyword != null ) {

				
				sql = sql+"AND (f.filenumber ilike ? OR f.subject ilike ?)";
				
			}
			
			if(orderBy!=null && !orderBy.isEmpty()) {
				
				if(orderBy.equals("createdate")) {
					sql = sql + " order by "+"fm."+orderBy;
					}
				else {
					sql = sql + " order by "+"f."+orderBy;
					}
				
				sql = sql + " "+order;
				System.out.println("order by ---"+orderBy);			
			}

			
			sql = sql + " offset "+ start + " limit "+ end;
			System.out.println("final query--: "+sql);
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(userPostId);
			if(!keyword.isEmpty() && keyword != null) {
				queryPos.add("%"+keyword+"%");
				queryPos.add("%"+keyword+"%");
			}
	
			return  GenericModelMapper.map(FileMovementDTO.class, sqlQuery.list());

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}
	
	
	
	
	
	public List<FileMovementDTO> getFileInboxList(long userPostId, String keyword){
		Session session = null;
		try {
			session = openSession();
			
			
			
			String sql="SELECT fm.fmid as fileMovementId, f.filenumber as fileNumber ,f.subject as subject," + 
					"		(SELECT concat(up1.username,'( ' , up1.postmarking,') ', up1.sectionname,', ' , up1.departmentname)) as sentBy," + 
					"		(SELECT concat(up2.username,'( ' , up2.postmarking,') ' , up2.sectionname,', ' , up2.departmentname)) AS SentTo ," + 
					"		fm.createdate as sentOn, fm.readon as readOn, fm.duedate as dueDate, fm.remark as remark, fm.receivedon as receivedOn," + 
					"		 f.currentlywith as currentlyWith, f.nature as nature, f.docfileid as fileId, fm.senderid as senderId ,  f.currentstate as currentState , f.docfileid as docFileId , fm.pullbackremark as pullBackRemark" + 
					"		FROM jet_process_filemovement as fm " + 
					"        Join (select max(mov.fmid) as mfmId from jet_process_filemovement mov where mov.active_ = true group by mov.fileId) fmov on fmov.mfmId = fm.fmid  " + 
					"		  JOIN jet_process_docfile as f ON fm.fileId = f.docfileid        " + 
					"		 JOIN masterdata_userpost as up1 ON fm.senderid = up1.userpostid" + 
					"		 JOIN masterdata_userpost as up2" + 
					"		ON fm.receiverid = up2.userpostid " + 
					"	where fm.receiverid = ?";
			
			logger.info("Final File inbox List Query : "+sql);
			
			if(!keyword.isEmpty() && keyword != null ) {
				sql = sql+"AND (f.filenumber ilike ? OR f.subject ilike ?)";
			}
				
				
			System.out.println("final query--: "+sql);
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(userPostId);
			if(!keyword.isEmpty() && keyword != null) {
				queryPos.add("%"+keyword+"%");
				queryPos.add("%"+keyword+"%");
			}
			return  GenericModelMapper.map(FileMovementDTO.class, sqlQuery.list());
			
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}
	
	
	
	
	public List<FileMovementDTO> getFileInboxList(long userPostId, String keyword , int start , int end ,  String orderBy ,  String order ) {

		System.out.println("userPostId: "+ userPostId+ ", keyword : "+ keyword + ", start:"+ start +", end : "+ end +", orderBy : "+ orderBy +", order : "+ order );
		Session session = null;
		try {
			session = openSession();
	
			String sql="SELECT fm.fmid as fileMovementId, f.filenumber as fileNumber ,f.subject as subject," + 
					"		(SELECT concat(up1.username,'( ' , up1.postmarking,') ', up1.sectionname,', ' , up1.departmentname)) as sentBy," + 
					"		(SELECT concat(up2.username,'( ' , up2.postmarking,') ' , up2.sectionname,', ' , up2.departmentname)) AS SentTo ," + 
					"		fm.createdate as sentOn, fm.readon as readOn, fm.duedate as dueDate, fm.remark as remark, fm.receivedon as receivedOn," + 
					"		 f.currentlywith as currentlyWith, f.nature as nature, f.docfileid as fileId, fm.senderid as senderId ,  f.currentstate as currentState , f.docfileid as docFileId , fm.pullbackremark as pullBackRemark" + 
					"		FROM jet_process_filemovement as fm " + 
					"        Join (select max(mov.fmid) as mfmId from jet_process_filemovement mov where mov.active_ = true group by mov.fileId) fmov on fmov.mfmId = fm.fmid  " + 
					"		  JOIN jet_process_docfile as f ON fm.fileId = f.docfileid        " + 
					"		 JOIN masterdata_userpost as up1 ON fm.senderid = up1.userpostid" + 
					"		 JOIN masterdata_userpost as up2" + 
					"		ON fm.receiverid = up2.userpostid " + 
					"	where fm.receiverid = ? ";
			
		
			if(!keyword.isEmpty() && keyword != null ) {

				
				sql = sql+"AND (f.filenumber ilike ? OR f.subject ilike ?)";
				
			}
			
			if(orderBy!=null && !orderBy.isEmpty()) {
				
				if(orderBy.equals("createdate")) {
					sql = sql + " order by "+"fm."+orderBy;
					}
				else {
					sql = sql + " order by "+"f."+orderBy;
					}
				sql = sql + " "+order;
				
				System.out.println("order by ---"+orderBy);			
			}	

			
			sql = sql + " offset "+ start + " limit "+ end;
			System.out.println("final query--: "+sql);
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(userPostId);
			if(!keyword.isEmpty() && keyword != null) {
				queryPos.add("%"+keyword+"%");
				queryPos.add("%"+keyword+"%");
			}
	
			return  GenericModelMapper.map(FileMovementDTO.class, sqlQuery.list());

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}
	
	
	
	
	
	public List<ReceiptMovementDTO> getReceiptInboxList(long userPostId, String keyword){
		Session session = null;
		try {
			session = openSession();
			
			
			

			String sql="SELECT " + 
					"	rm.rmid AS receiptMovementId," + 
					"    r.receiptnumber AS receiptNumber," + 
					"	r.subject AS subject,	" + 
					"    null as sender,	" + 
					"    (SELECT concat(up1.username,'( ' , up1.postmarking,') ', up1.sectionname,', ' , up1.departmentname)) as sentBy," + 
					"	null AS sentTo ,	" + 
					"    rm.createdate AS sentOn,	" + 
					"    rm.readon AS readOn," + 
					"	rm.duedate AS dueDate,	" + 
					"    rm.remark AS remark,	" + 
					"    rm.receivedon as receiveOn,	" + 
					"    r.nature as nature," + 
					"	r.receiptid as receiptId," + 
					"	rm.pullbackremark as pullBackRemark" + 
					"	FROM jet_process_receiptmovement as rm " + 
					"    " + 
					"    Join (select max(mov.rmid) as mreceiptId from jet_process_receiptmovement mov where mov.active_ = true group by mov.receiptId) rmov on rmov.mreceiptId = rm.rmid  " + 
					"    " + 
					"	JOIN jet_process_receipt AS r ON rm.receiptId = r.receiptId" + 
					"	JOIN masterdata_userpost as up1 ON rm.senderid = up1.userpostid" + 
					"	JOIN masterdata_userpost as up2 ON rm.receiverid = up2.userpostid " + 
					"    where rm.receiverid = ? ";
			
			logger.info("Final Receipt Movement List Query : "+sql);
			
			if(!keyword.isEmpty() && keyword != null ) {
				sql = sql+" AND (r.receiptnumber ilike ? OR r.subject ilike ?)";
			}
				
				
			System.out.println("final query--: "+sql);
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(userPostId);
			if(!keyword.isEmpty() && keyword != null) {
				queryPos.add("%"+keyword+"%");
				queryPos.add("%"+keyword+"%");
			}
			return  GenericModelMapper.map(ReceiptMovementDTO.class, sqlQuery.list());
			
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}
	
	
	
	
	
	
	public List<ReceiptMovementDTO> getReceiptInboxList(long userPostId, String keyword , int start , int end ,  String orderBy ,  String order ) {

		Session session = null;
		try {
			session = openSession();
	
			String sql="SELECT " + 
					"	rm.rmid AS receiptMovementId," + 
					"    r.receiptnumber AS receiptNumber," + 
					"	r.subject AS subject,	" + 
					"    null as sender,	" + 
					"    (SELECT concat(up1.username,'( ' , up1.postmarking,') ', up1.sectionname,', ' , up1.departmentname)) as sentBy," + 
					"	null AS sentTo ,	" + 
					"    rm.createdate AS sentOn,	" + 
					"    rm.readon AS readOn," + 
					"	rm.duedate AS dueDate,	" + 
					"    rm.remark AS remark,	" + 
					"    rm.receivedon as receiveOn,	" + 
					"    r.nature as nature," + 
					"	r.receiptid as receiptId," + 
					"	rm.pullbackremark as pullBackRemark" + 
					"	FROM jet_process_receiptmovement as rm " + 
					"    " + 
					"    Join (select max(mov.rmid) as mreceiptId from jet_process_receiptmovement mov where mov.active_ = true group by mov.receiptId) rmov on rmov.mreceiptId = rm.rmid  " + 
					"    " + 
					"	JOIN jet_process_receipt AS r ON rm.receiptId = r.receiptId" + 
					"	JOIN masterdata_userpost as up1 ON rm.senderid = up1.userpostid" + 
					"	JOIN masterdata_userpost as up2 ON rm.receiverid = up2.userpostid " + 
					"    where rm.receiverid = ? ";
			
		
			if(!keyword.isEmpty() && keyword != null ) {

				
				sql = sql+" "+"AND (r.receiptnumber ilike ? OR r.subject ilike ?)";
				
			}
			
			if(orderBy!=null && !orderBy.isEmpty()) {
				if(orderBy.equals("createdate")) {
					sql = sql + " order by "+"rm."+orderBy;
					}
				else {
					sql = sql + " order by "+"r."+orderBy;
					}
				sql = sql + " "+order;
				System.out.println("order by ---"+orderBy);			
			}

			
			sql = sql + " offset "+ start + " limit "+ end;
			System.out.println("final query--: "+sql);
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(userPostId);
			if(!keyword.isEmpty() && keyword != null) {
				queryPos.add("%"+keyword+"%");
				queryPos.add("%"+keyword+"%");
			}
	
			return  GenericModelMapper.map(ReceiptMovementDTO.class, sqlQuery.list());

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}
	
	
	
	
	
	
	public List<ReceiptMovementDTO> getReceiptSendList(long userPostId, String keyword){
		Session session = null;
		try {
			session = openSession();
//			String sql = customSQL.get(getClass(), "getSentFileList");
			
			
			
			String sql="SELECT rm.rmid as receiptMovementId, r.receiptNumber ,r.subject , r.name as sender ," + 
					"		null as sentBy," + 
					"		(SELECT concat(up.username,'( ' , up.postmarking,') ' , up.sectionname,', ' , up.departmentname)) as sentTo ," + 
					"		rm.createdate as sentOn, rm.readOn , rm.dueDate , rm.remark , rm.receivedOn, r.nature ,r.receiptid , pullBackRemark" + 
					"		FROM jet_process_receiptmovement as rm " + 
					"		 JOIN jet_process_receipt as r ON rm.receiptId = r.receiptId" + 
					"		 JOIN masterdata_userpost as up ON rm.receiverid = up.userpostid" + 
					"	where rm.senderid = ? and rm.active_ = true and rm.pullbackremark is null ";
			
			logger.info("Final File Movement List Query : "+sql);
			
			if(!keyword.isEmpty() && keyword != null ) {
				sql = sql+" AND (r.receiptnumber ilike ? OR r.subject ilike ?)";
			}
				
				
			System.out.println("final query--: "+sql);
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(userPostId);
			if(!keyword.isEmpty() && keyword != null) {
				queryPos.add("%"+keyword+"%");
				queryPos.add("%"+keyword+"%");
			}
			return  GenericModelMapper.map(ReceiptMovementDTO.class, sqlQuery.list());
			
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}
	
	
	
	
	public List<ReceiptMovementDTO> getReceiptSendList(long userPostId, String keyword , int start , int end ,  String orderBy ,  String order ) {

		System.out.println("userPostId: "+ userPostId+ ", keyword : "+ keyword + ", start:"+ start +", end : "+ end +", orderBy : "+ orderBy +", order : "+ order );
		Session session = null;
		try {
			session = openSession();
			
			String sql="SELECT rm.rmid as receiptMovementId, r.receiptNumber ,r.subject , r.name as sender ," + 
					"		null as sentBy," + 
					"		(SELECT concat(up.username,'( ' , up.postmarking,') ' , up.sectionname,', ' , up.departmentname)) as sentTo ," + 
					"		rm.createdate as sentOn, rm.readOn , rm.dueDate , rm.remark , rm.receivedOn, r.nature ,r.receiptid , pullBackRemark" + 
					"		FROM jet_process_receiptmovement as rm " + 
					"		 JOIN jet_process_receipt as r ON rm.receiptId = r.receiptId" + 
					"		 JOIN masterdata_userpost as up ON rm.receiverid = up.userpostid" + 
					"	where rm.senderid = ? and rm.active_ = true and rm.pullbackremark is null ";
		
			
		
			if(!keyword.isEmpty() && keyword != null ) {

				
				sql = sql+" AND (r.receiptnumber ilike ? OR r.subject ilike ?)";
				
			}
			
			if(orderBy!=null && !orderBy.isEmpty()) {

				if(orderBy.equals("createdate")) {
					sql = sql + " order by "+"rm."+orderBy;
					}
				else {
					sql = sql + " order by "+"r."+orderBy;
					}
				sql = sql + " "+order;
				System.out.println("order by ---"+orderBy);			
			}

			
			sql = sql + " offset "+ start + " limit "+ end;
			System.out.println("final query--Receipt: "+sql);
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(userPostId);
			if(!keyword.isEmpty() && keyword != null) {
				queryPos.add("%"+keyword+"%");
				queryPos.add("%"+keyword+"%");
			}
	
			return  GenericModelMapper.map(ReceiptMovementDTO.class, sqlQuery.list());

		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}
	
	
	
	
	

	public List<FileCorrespondenceReceiptDTO> getFileCorrespondenceReceiptDetails(long fileId){
		Session session = null;
		try {
			session = openSession();
			String sql = customSQL.get(getClass(), "getFileCorrespondenceReceiptList");
			logger.info("Final File Movement List Query : "+sql);
			SQLQuery sqlQuery = session.createSQLQuery(sql);
			sqlQuery.setCacheable(false);
			QueryPos queryPos = QueryPos.getInstance(sqlQuery);
			queryPos.add(fileId);
			return  GenericModelMapper.map(FileCorrespondenceReceiptDTO.class, sqlQuery.list());
			
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				se.printStackTrace();
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	private Log logger = LogFactoryUtil.getLog(this.getClass());
	
}
