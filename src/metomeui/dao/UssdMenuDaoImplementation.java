package metomeui.dao;

import java.util.ArrayList;
import java.util.List;

import metomeui.model.UssdKeywordStep;
import metomeui.model.UssdMenuItem;
import metomeui.model.UssdPredefInput;
import metomeui.model.UssdPredefInputItem;
import metomeui.model.UssdTransactionKeyword;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * This is the implementation class of UssdMenuDao interface.
 * 
 * @Repository("ussdMenuDao") declares that the annotated class is a "DAO".
 * @Autowired is being used to make the SessionFactory instance available
 *            automatically by spring.
 */

@Repository("ussdMenuDao")
@Transactional
public class UssdMenuDaoImplementation implements UssdMenuDao {

	private static Logger logger = Logger
			.getLogger(SystemSettingsDaoImplementation.class);

	public Session currentSession() {
		return HibernateUtil.getSessionFactory().getCurrentSession();
	}

	public void addPredefInput(UssdPredefInput predefInput) {
		try {

			// Retrieve session from Hibernate
			currentSession().beginTransaction();
			currentSession().save(predefInput);
			currentSession().getTransaction().commit();

		} catch (Exception e) {
			currentSession().getTransaction().rollback();
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	public List<UssdPredefInput> listPredefInputs() {
		Transaction transaction = currentSession().beginTransaction();
		List<UssdPredefInput> listPredefInputs = (List<UssdPredefInput>) currentSession()
				.createCriteria(UssdPredefInput.class).list();
		transaction.commit();
		return listPredefInputs;
	}

	/**
	 * Edits existing UssdPredefInput
	 */
	public void editPredefInput(UssdPredefInput predefInput) {

		UssdPredefInput existingPredefInput = new UssdPredefInput();
		deleteExistingPredefInputItems(predefInput.getPredefInputId());
		currentSession().beginTransaction();
		existingPredefInput = (UssdPredefInput) currentSession().load(
				UssdPredefInput.class, predefInput.getPredefInputId());

		// Assign updated values to this existing PredefInput
		existingPredefInput
				.setPredefInputName(predefInput.getPredefInputName());
		existingPredefInput.setPredefInputDescription(predefInput
				.getPredefInputDescription());
		existingPredefInput.setPredefInputItems(predefInput
				.getPredefInputItems());
		try {

			// Save updates
			currentSession().update(existingPredefInput);
			currentSession().getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			currentSession().getTransaction().rollback();
		}
	}

	@SuppressWarnings("unchecked")
	public List<UssdPredefInputItem> listPredefInputItemsByPredefInputId(
			long predefInputId) {
		currentSession().beginTransaction();
		return (List<UssdPredefInputItem>) currentSession()
				.createQuery(
						"from UssdPredefInputItem predefInputItem "
								+ "where predefInputItem.predefInput.predefInputId = :predefInputId")
				.setParameter("predefInputId", predefInputId).list();
	}

	public UssdPredefInput getExistingPredefInput(Long predefInputId) {

		currentSession().beginTransaction();

		// Retrieve existing UssdPredefInput
		UssdPredefInput existingUssdPredefInput = (UssdPredefInput) currentSession()
				.load(UssdPredefInput.class, predefInputId);
		return existingUssdPredefInput;
	}

	public void deleteExistingPredefInputItems(Long predefInputId) {
		currentSession().beginTransaction();
		String hql = "delete from UssdPredefInputItem predefInputItem "
				+ "where predefInputItem.predefInput.predefInputId = :predefInputId";
		Query query = currentSession().createQuery(hql).setParameter(
				"predefInputId", predefInputId);
		query.executeUpdate();

	}

	@SuppressWarnings("unchecked")
	public List<UssdTransactionKeyword> listTransactionKeywords() {
		currentSession().beginTransaction();
		return (List<UssdTransactionKeyword>) currentSession().createCriteria(
				UssdTransactionKeyword.class).list();
	}

	public void addTransactionKeyword(
			UssdTransactionKeyword ussdTransactionKeyword) {
		try {
			currentSession().beginTransaction();
			currentSession().saveOrUpdate(ussdTransactionKeyword);
			currentSession().getTransaction().commit();
		} catch (Exception e) {
			currentSession().getTransaction().rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void deleteTransactionKeyword(Long keywordId) {
		try {
			currentSession().beginTransaction();
			UssdTransactionKeyword ussdTransactionKeyword = (UssdTransactionKeyword) currentSession()
					.get(UssdTransactionKeyword.class, keywordId);
			if (null != ussdTransactionKeyword) {
				currentSession().delete(ussdTransactionKeyword);
				currentSession().getTransaction().commit();
			}
		} catch (RuntimeException e) {
			currentSession().getTransaction().rollback();
			throw e;
		}
	}

	@SuppressWarnings("unchecked")
	public List<UssdKeywordStep> listKeywordStepByKeywordId(long keywordId) {
		currentSession().beginTransaction();
		return (List<UssdKeywordStep>) currentSession()
				.createQuery(
						"from UssdKeywordStep keywordStep "
								+ "where keywordStep.transactionKeyword.keywordId = :keywordId")
				.setParameter("keywordId", keywordId).list();
	}

	/**
	 * Edits existing Ussd Transaction Keyword
	 */
	public void editTransactionKeyword(UssdTransactionKeyword transactionKeyword) {
		logger.debug("Editing existing Ussd Transaction Keyword");
		currentSession().beginTransaction();
		UssdTransactionKeyword existingTransactionKeyword = (UssdTransactionKeyword) currentSession()
				.load(UssdTransactionKeyword.class,
						transactionKeyword.getKeywordId());

		if (null != existingTransactionKeyword) {

			// Assign updated values to this existing Transaction Keyword
			existingTransactionKeyword.setKeywordName(transactionKeyword
					.getKeywordName());
			existingTransactionKeyword.setKeywordDescription(transactionKeyword
					.getKeywordDescription());
			existingTransactionKeyword.setKeywordCode(transactionKeyword
					.getKeywordCode());
			existingTransactionKeyword.setKeywordStepsCount(transactionKeyword
					.getKeywordStepsCount());
			existingTransactionKeyword.setKeywordEnabledFlag(transactionKeyword
					.getKeywordEnabledFlag());
			try {

				// Save updates
				currentSession().update(existingTransactionKeyword);
				currentSession().getTransaction().commit();
			} catch (Exception e) {
				currentSession().getTransaction().rollback();
				e.printStackTrace();
			}
		}
	}

	public void deleteExistingKeywordSteps(Long keywordId) {
		currentSession().beginTransaction();
		String hql = "delete from UssdKeywordStep keywordStep "
				+ "where keywordStep.transactionKeyword.keywordId = :keywordId";
		Query query = currentSession().createQuery(hql).setParameter(
				"keywordId", keywordId);
		query.executeUpdate();

	}

	@SuppressWarnings("unchecked")
	public List<UssdKeywordStep> listKeywordSteps() {
		currentSession().beginTransaction();
		return (List<UssdKeywordStep>) currentSession().createCriteria(
				UssdKeywordStep.class).list();
	}

	public void addKeywordStep(UssdKeywordStep ussdKeywordStep) {
		try {
			currentSession().beginTransaction();
			currentSession().saveOrUpdate(ussdKeywordStep);
			currentSession().getTransaction().commit();
		} catch (Exception e) {
			currentSession().getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public void deleteExistingKeywordStep(Long keywordStepId) {
		try {
			currentSession().beginTransaction();
			UssdKeywordStep ussdKeywordStep = (UssdKeywordStep) currentSession()
					.get(UssdKeywordStep.class, keywordStepId);

			if (null != ussdKeywordStep) {
				currentSession().delete(ussdKeywordStep);
				currentSession().getTransaction().commit();
			}
		} catch (RuntimeException e) {
			currentSession().getTransaction().rollback();
			throw e;
		}
	}

	/**
	 * Edits existing Ussd Transaction Keyword Steps
	 */
	public void editKeywordStep(UssdKeywordStep keywordStep) {

		// Retrieve session from Hibernate
		currentSession().beginTransaction();
		UssdKeywordStep existingKeywordStep = new UssdKeywordStep();
		if (keywordStep.getKeywordStepId() != null) {
			existingKeywordStep = (UssdKeywordStep) currentSession().load(
					UssdKeywordStep.class, keywordStep.getKeywordStepId());

			// Assign updated values to this existing Keyword Step
			existingKeywordStep.setStepMenuName(keywordStep.getStepMenuName());
			existingKeywordStep.setStepMenuNumber(keywordStep
					.getStepMenuNumber());
			existingKeywordStep
					.setKeywordStepId(keywordStep.getKeywordStepId());
			existingKeywordStep.setUseFixedValueFlag(keywordStep
					.getUseFixedValueFlag());
			existingKeywordStep.setFixedValue(keywordStep.getFixedValue());
			existingKeywordStep.setHasPredefInputFlag(keywordStep
					.getHasPredefInputFlag());
			existingKeywordStep.setIsFirstStepFlag(keywordStep
					.getIsFirstStepFlag());
			existingKeywordStep.setIsLastStepFlag(keywordStep
					.getIsLastStepFlag());
			try {

				// Save updates
				currentSession().update(existingKeywordStep);
				currentSession().getTransaction().commit();
			} catch (Exception e) {
				currentSession().getTransaction().rollback();
				e.printStackTrace();
			}
		} else {

			try {
				currentSession().saveOrUpdate(keywordStep);
				currentSession().getTransaction().commit();
			} catch (Exception e) {
				currentSession().getTransaction().rollback();
				e.printStackTrace();
			}
		}

	}

	@SuppressWarnings("unchecked")
	public List<UssdMenuItem> listMenuItems() {
		currentSession().beginTransaction();
		return (List<UssdMenuItem>) currentSession().createCriteria(
				UssdMenuItem.class).list();
	}

	public void addMenuItem(UssdMenuItem ussdMenuItem) {
		try {
			currentSession().beginTransaction();
			currentSession().save(ussdMenuItem);
			currentSession().getTransaction().commit();
		} catch (Exception e) {
			currentSession().getTransaction().rollback();
			e.printStackTrace();
		}
	}

	public void deleteMenuItem(Long menuItemId) {
		try {
			currentSession().beginTransaction();

			UssdMenuItem ussdMenuItem = (UssdMenuItem) currentSession().get(
					UssdMenuItem.class, menuItemId);
			if (null != ussdMenuItem) {
				currentSession().delete(ussdMenuItem);
				currentSession().getTransaction().commit();
			}
		} catch (RuntimeException e) {
			currentSession().getTransaction().rollback();
			throw e;
		}
	}

	/**
	 * Edits existing Ussd Menu Item
	 */
	public void editMenuItem(UssdMenuItem menuItem) {

		UssdMenuItem existingMenuItem = new UssdMenuItem();
		currentSession().beginTransaction();
		existingMenuItem = (UssdMenuItem) currentSession().load(
				UssdMenuItem.class, menuItem.getMenuItemId());
		if (existingMenuItem != null) {

			// Assign updated values to this existing MenuItem
			existingMenuItem.setMenuItemName(menuItem.getMenuItemName());
			existingMenuItem.setMenuItemOrder(menuItem.getMenuItemOrder());
			existingMenuItem.setRootMenuItem(menuItem.getRootMenuItem());
			existingMenuItem.setMenuItemKeyword(menuItem.getMenuItemKeyword());
			existingMenuItem.setMenuItemEnabledFlag(menuItem
					.getMenuItemEnabledFlag());

			try {

				// Save updates
				currentSession().merge(existingMenuItem);
				currentSession().getTransaction().commit();
			} catch (Exception e) {
				currentSession().getTransaction().rollback();
				e.printStackTrace();
			}
		}
	}

	public UssdTransactionKeyword getExistingTransactionKeyword(long keywordId) {
		currentSession().beginTransaction();
		UssdTransactionKeyword existingTransactionKeyword = (UssdTransactionKeyword) currentSession()
				.load(UssdTransactionKeyword.class, keywordId);
		return existingTransactionKeyword;
	}

	public UssdKeywordStep getExistingKeywordStep(long keywordStepId) {
		currentSession().beginTransaction();
		UssdKeywordStep existingKeywordStep = (UssdKeywordStep) currentSession()
				.load(UssdKeywordStep.class, keywordStepId);
		return existingKeywordStep;
	}

	public UssdMenuItem getExistingMenuItem(long menuItemId) {
		currentSession().beginTransaction();
		UssdMenuItem existingMenuItem = (UssdMenuItem) currentSession().load(
				UssdMenuItem.class, menuItemId);
		return existingMenuItem;
	}

	@Override
	public void activateExistingMenuItem(Long menuItemId) {
		Integer onSwitch = 1;
		currentSession().beginTransaction();
		UssdMenuItem existingMenuItem = (UssdMenuItem) currentSession().load(
				UssdMenuItem.class, menuItemId);
		existingMenuItem.setMenuItemEnabledFlag(onSwitch);
		try {
			currentSession().update(existingMenuItem);
			currentSession().getTransaction().commit();
		} catch (Exception e) {
			currentSession().getTransaction().rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void deactivateExistingMenuItem(Long menuItemId) {
		Integer offSwitch = 0;
		currentSession().beginTransaction();
		UssdMenuItem existingMenuItem = (UssdMenuItem) currentSession().load(
				UssdMenuItem.class, menuItemId);
		existingMenuItem.setMenuItemEnabledFlag(offSwitch);
		try {
			currentSession().update(existingMenuItem);
			currentSession().getTransaction().commit();
		} catch (Exception e) {
			currentSession().getTransaction().rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void activateExistingPredefInputItem(Long predefInputItemId) {
		Integer onSwitch = 1;
		currentSession().beginTransaction();

		UssdPredefInputItem existingPredefInputItem = (UssdPredefInputItem) currentSession()
				.load(UssdPredefInputItem.class, predefInputItemId);
		existingPredefInputItem.setPredefInputItemEnabledFlag(onSwitch);
		try {
			currentSession().update(existingPredefInputItem);
			currentSession().getTransaction().commit();
		} catch (Exception e) {
			currentSession().getTransaction().rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void deactivateExistingPredefInputItem(Long predefInputItemId) {
		Integer offSwitch = 0;
		currentSession().beginTransaction();
		UssdPredefInputItem existingPredefInputItem = (UssdPredefInputItem) currentSession()
				.load(UssdPredefInputItem.class, predefInputItemId);
		existingPredefInputItem.setPredefInputItemEnabledFlag(offSwitch);
		try {
			currentSession().update(existingPredefInputItem);
			currentSession().getTransaction().commit();
		} catch (Exception e) {
			currentSession().getTransaction().rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void deactivateExistingKeyword(Long keywordId) {
		Integer offSwitch = 0;
		currentSession().beginTransaction();

		UssdTransactionKeyword existingTransactionKeyword = (UssdTransactionKeyword) currentSession()
				.load(UssdTransactionKeyword.class, keywordId);
		existingTransactionKeyword.setKeywordEnabledFlag(offSwitch);
		try {
			currentSession().update(existingTransactionKeyword);
			currentSession().getTransaction().commit();
		} catch (Exception e) {
			currentSession().getTransaction().rollback();
			e.printStackTrace();
		}

	}

	@Override
	public void activateExistingKeyword(Long keywordId) {
		Integer onSwitch = 1;
		currentSession().beginTransaction();

		UssdTransactionKeyword existingTransactionKeyword = (UssdTransactionKeyword) currentSession()
				.load(UssdTransactionKeyword.class, keywordId);
		existingTransactionKeyword.setKeywordEnabledFlag(onSwitch);
		try {
			currentSession().update(existingTransactionKeyword);
			currentSession().getTransaction().commit();
		} catch (Exception e) {
			currentSession().getTransaction().rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void deleteExistingPredefInput(Long predefInputId) {

		try {
			currentSession().beginTransaction();

			@SuppressWarnings("unchecked")
			List<UssdKeywordStep> keywordStepsList = (List<UssdKeywordStep>) currentSession()
					.createQuery(
							"from UssdKeywordStep keywordStep "
									+ "where keywordStep.predefInput.predefInputId = :predefInputId")
					.setParameter("predefInputId", predefInputId).list();

			if (!(keywordStepsList.isEmpty())) {
				for (UssdKeywordStep ussdKeywordStep : keywordStepsList) {
					currentSession().delete(ussdKeywordStep);
				}
			}

			UssdPredefInput ussdPredefInput = (UssdPredefInput) currentSession()
					.get(UssdPredefInput.class, predefInputId);
			if (null != ussdPredefInput) {
				currentSession().delete(ussdPredefInput);
				currentSession().getTransaction().commit();
			}
		} catch (RuntimeException e) {
			currentSession().getTransaction().rollback();
			throw e;
		}

	}

	@Override
	public void deleteExistingPredefInputItem(Long inputItemId) {

		try {
			currentSession().beginTransaction();
			UssdPredefInputItem ussdPredefInputItem = (UssdPredefInputItem) currentSession()
					.get(UssdPredefInputItem.class, inputItemId);
			if (null != ussdPredefInputItem) {
				currentSession().delete(ussdPredefInputItem);
				currentSession().getTransaction().commit();
			}
		} catch (RuntimeException e) {
			currentSession().getTransaction().rollback();
			throw e;
		}

	}

	@Override
	public UssdPredefInputItem getExistingPredefInputItem(Long predefInputItemId) {
		currentSession().beginTransaction();

		// Retrieve existing UssdPredefInputItem
		UssdPredefInputItem existingUssdPredefInputItem = (UssdPredefInputItem) currentSession()
				.load(UssdPredefInputItem.class, predefInputItemId);
		return existingUssdPredefInputItem;

	}

	@Override
	public List<UssdKeywordStep> getKeywordsLinkedToThisPredefInput(
			Long predefInputId) {
		@SuppressWarnings("unchecked")
		List<UssdKeywordStep> keywordStepsList = (List<UssdKeywordStep>) currentSession()
				.createQuery(
						"from UssdKeywordStep keywordStep "
								+ "where keywordStep.predefInput.predefInputId = :predefInputId")
				.setParameter("predefInputId", predefInputId).list();

		if (!(keywordStepsList.isEmpty())) {
			return keywordStepsList;
		} else {
			return new ArrayList<UssdKeywordStep>();
		}
	}

	@Override
	public List<UssdMenuItem> getChildMenuItemsForParentMenuItem(Long menuItemId) {
		@SuppressWarnings("unchecked")
		List<UssdMenuItem> childMenuItemsList = (List<UssdMenuItem>) currentSession()
				.createQuery(
						"from UssdMenuItem menuItem "
								+ "where menuItem.rootMenuItem.menuItemId = :menuItemId")
				.setParameter("menuItemId", menuItemId).list();

		if (!(childMenuItemsList.isEmpty())) {
			return childMenuItemsList;
		} else {
			return new ArrayList<UssdMenuItem>();
		}
	}

	/**
	 * Validation methods
	 */
	@SuppressWarnings("unchecked")
	@Override
	public boolean checkIfDuplicateStepMenuNumber(Integer stepMenuNumber,
			Long keywordId) {
		currentSession().beginTransaction();
		List<UssdKeywordStep> keywordSteps = (List<UssdKeywordStep>) currentSession()
				.createQuery(
						"from UssdKeywordStep keywordStep "
								+ "where keywordStep.transactionKeyword.keywordId = :keywordId and keywordStep.stepMenuNumber = :stepMenuNumber")
				.setParameter("keywordId", keywordId)
				.setParameter("stepMenuNumber", stepMenuNumber).list();
		if (keywordSteps.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean checkIfDuplicateStepMenuName(String stepMenuName,
			Long keywordId) {
		currentSession().beginTransaction();
		List<UssdKeywordStep> keywordSteps = (List<UssdKeywordStep>) currentSession()
				.createQuery(
						"from UssdKeywordStep keywordStep "
								+ "where keywordStep.transactionKeyword.keywordId = :keywordId and keywordStep.stepMenuName = :stepMenuName")
				.setParameter("keywordId", keywordId)
				.setParameter("stepMenuName", stepMenuName).list();
		if (keywordSteps.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean checkIfDuplicateInputItemName(String predefInputItemName,
			Long predefInputId) {
		currentSession().beginTransaction();
		List<UssdPredefInputItem> predefInputItems = (List<UssdPredefInputItem>) currentSession()
				.createQuery(
						"from UssdPredefInputItem predefInputItem "
								+ "where predefInputItem.predefInput.predefInputId = :predefInputId and predefInputItem.predefInputItemName = :predefInputItemName")
				.setParameter("predefInputId", predefInputId)
				.setParameter("predefInputItemName", predefInputItemName)
				.list();
		if (predefInputItems.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean checkIfDuplicateInputItemCode(String predefInputItemCode,
			Long predefInputId) {
		currentSession().beginTransaction();
		List<UssdPredefInputItem> predefInputItems = (List<UssdPredefInputItem>) currentSession()
				.createQuery(
						"from UssdPredefInputItem predefInputItem "
								+ "where predefInputItem.predefInput.predefInputId = :predefInputId and predefInputItem.predefInputItemCode = :predefInputItemCode")
				.setParameter("predefInputId", predefInputId)
				.setParameter("predefInputItemCode", predefInputItemCode)
				.list();
		if (predefInputItems.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean checkIfDuplicateInputItemOrder(Integer predefInputItemOrder,
			Long predefInputId) {
		currentSession().beginTransaction();
		List<UssdPredefInputItem> predefInputItems = (List<UssdPredefInputItem>) currentSession()
				.createQuery(
						"from UssdPredefInputItem predefInputItem "
								+ "where predefInputItem.predefInput.predefInputId = :predefInputId and predefInputItem.predefInputItemOrder = :predefInputItemOrder")
				.setParameter("predefInputId", predefInputId)
				.setParameter("predefInputItemOrder", predefInputItemOrder)
				.list();
		if (predefInputItems.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean checkIfDuplicatePredefInputName(String predefInputName,
			Long predefInputId) {
		currentSession().beginTransaction();
		List<UssdPredefInput> predefInputs = (List<UssdPredefInput>) currentSession()
				.createQuery(
						"from UssdPredefInput predefInput "
								+ "where predefInput.predefInputId = :predefInputId and predefInput.predefInputName = :predefInputName")
				.setParameter("predefInputId", predefInputId)
				.setParameter("predefInputName", predefInputName).list();
		if (predefInputs.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean checkIfDuplicateMenuName(String menuItemName, Long menuItemId) {
		currentSession().beginTransaction();
		List<UssdMenuItem> menuItems = (List<UssdMenuItem>) currentSession()
				.createQuery(
						"from UssdMenuItem menuItem "
								+ "where menuItem.menuItemId != :menuItemId and menuItem.menuItemName = :menuItemName")
				.setParameter("menuItemId", menuItemId)
				.setParameter("menuItemName", menuItemName).list();
		if (menuItems.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean checkIfDuplicateKeywordName(String keywordName,
			Long keywordId) {
		currentSession().beginTransaction();
		List<UssdTransactionKeyword> transactionKeywords = (List<UssdTransactionKeyword>) currentSession()
				.createQuery(
						"from UssdTransactionKeyword transactionKeyword "
								+ "where transactionKeyword.keywordId = :keywordId and transactionKeyword.keywordName = :keywordName")
				.setParameter("keywordId", keywordId)
				.setParameter("keywordName", keywordName).list();
		if (transactionKeywords.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean checkIfDuplicateKeywordCode(String keywordCode,
			Long keywordId) {
		currentSession().beginTransaction();
		List<UssdTransactionKeyword> transactionKeywords = (List<UssdTransactionKeyword>) currentSession()
				.createQuery(
						"from UssdTransactionKeyword transactionKeyword "
								+ "where transactionKeyword.keywordId = :keywordId and transactionKeyword.keywordCode = :keywordCode")
				.setParameter("keywordId", keywordId)
				.setParameter("keywordCode", keywordCode).list();
		if (transactionKeywords.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
}