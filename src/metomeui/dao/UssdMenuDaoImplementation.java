package metomeui.dao;

import java.util.List;

import metomeui.model.UssdKeywordStep;
import metomeui.model.UssdMenuItem;
import metomeui.model.UssdPredefInput;
import metomeui.model.UssdPredefInputItem;
import metomeui.model.UssdRequest;
import metomeui.model.UssdTransactionKeyword;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * This is the implementation class of UssdDao interface.
 * 
 * @Repository("ussdDao") declares that the annotated class is a "DAO".
 * @Autowired is being used to make the SessionFactory instance available
 *            automatically by spring. Now, define the methods declared in
 *            UssdDao interface using hibernate.
 */

@Repository("ussdMenuDao")
public class UssdMenuDaoImplementation implements UssdMenuDao {

	@Autowired
	private SessionFactory sessionFactory;

	// To save the new predefined input items
	public void addUssdPredefInputItem(UssdPredefInputItem ussdPredefInputItem) {
		sessionFactory.getCurrentSession().saveOrUpdate(ussdPredefInputItem);
	}

	// To get list of all predefined input items
	@SuppressWarnings("unchecked")
	public List<UssdPredefInputItem> listUssdPredefInputItems() {
		return (List<UssdPredefInputItem>) sessionFactory.getCurrentSession()
				.createCriteria(UssdPredefInputItem.class).list();
	}

	@Override
	public void removeUssdPredefInputItem(Integer inputItemId) {
		UssdPredefInputItem ussdPredefInputItem = (UssdPredefInputItem) sessionFactory
				.getCurrentSession().load(UssdPredefInputItem.class,
						inputItemId);
		if (null != ussdPredefInputItem) {
			sessionFactory.getCurrentSession().delete(ussdPredefInputItem);
		}
	}

	public void addUssdPredefInput(UssdPredefInput ussdPredefInput) {
		sessionFactory.getCurrentSession().saveOrUpdate(ussdPredefInput);
	}

	// To get list of all predefined input items
	@SuppressWarnings("unchecked")
	public List<UssdPredefInput> listUssdPredefInputs() {
		return (List<UssdPredefInput>) sessionFactory.getCurrentSession()
				.createCriteria(UssdPredefInput.class).list();
	}

	@Override
	public void removeUssdPredefInput(Integer predefInputId) {
		UssdPredefInput ussdPredefInput = (UssdPredefInput) sessionFactory
				.getCurrentSession().load(UssdPredefInput.class, predefInputId);
		if (null != ussdPredefInput) {
			sessionFactory.getCurrentSession().delete(ussdPredefInput);
		}
	}

	/**
	 * Retrieves a single entry
	 */
	@Override
	public UssdPredefInput retrieveSinglePredefInputEntry(Integer predefInputId) {
		return (UssdPredefInput) sessionFactory.getCurrentSession().get(
				UssdPredefInput.class, predefInputId);
	}

	/**
	 * Edits an existing predefined input
	 */
	@Override
	public void updatePredefInput(UssdPredefInput ussdPredefInput,
			Integer predefInputId) {
		Session session = sessionFactory.getCurrentSession();

		UssdPredefInput existingUssdPredefInput = (UssdPredefInput) session
				.get(UssdPredefInput.class, predefInputId);

		// Assign updated values to this entry
		existingUssdPredefInput.setPredefInputName(ussdPredefInput
				.getPredefInputName());
		existingUssdPredefInput.setPredefInputDescription(ussdPredefInput
				.getPredefInputDescription());

		// Save updates
		session.save(existingUssdPredefInput);
	}

	@SuppressWarnings("unchecked")
	public List<UssdTransactionKeyword> listUssdTransactionKeywords() {
		return (List<UssdTransactionKeyword>) sessionFactory
				.getCurrentSession()
				.createCriteria(UssdTransactionKeyword.class).list();
	}

	public void addUssdTransactionKeyword(
			UssdTransactionKeyword ussdTransactionKeyword) {
		sessionFactory.getCurrentSession().saveOrUpdate(ussdTransactionKeyword);
	}

	@Override
	public void removeUssdTransactionKeyword(Integer keywordId) {
		UssdTransactionKeyword ussdTransactionKeyword = (UssdTransactionKeyword) sessionFactory
				.getCurrentSession().load(UssdTransactionKeyword.class,
						keywordId);
		if (null != ussdTransactionKeyword) {
			sessionFactory.getCurrentSession().delete(ussdTransactionKeyword);
		}
	}

	@SuppressWarnings("unchecked")
	public List<UssdKeywordStep> listUssdKeywordSteps() {
		return (List<UssdKeywordStep>) sessionFactory.getCurrentSession()
				.createCriteria(UssdKeywordStep.class).list();
	}

	public void addUssdKeywordStep(UssdKeywordStep ussdKeywordStep) {
		sessionFactory.getCurrentSession().saveOrUpdate(ussdKeywordStep);

	}

	@Override
	public void removeUssdKeywordStep(Integer keywordStepId) {
		UssdKeywordStep ussdKeywordStep = (UssdKeywordStep) sessionFactory
				.getCurrentSession().load(UssdKeywordStep.class, keywordStepId);
		if (null != ussdKeywordStep) {
			sessionFactory.getCurrentSession().delete(ussdKeywordStep);
		}
	}

	@SuppressWarnings("unchecked")
	public List<UssdMenuItem> listUssdMenuItems() {
		return (List<UssdMenuItem>) sessionFactory.getCurrentSession()
				.createCriteria(UssdMenuItem.class).list();
	}

	public void addUssdMenuItem(UssdMenuItem ussdMenuItem) {
		sessionFactory.getCurrentSession().saveOrUpdate(ussdMenuItem);
	}

	@Override
	public void removeUssdMenuItem(Integer menuItemId) {
		UssdMenuItem ussdMenuItem = (UssdMenuItem) sessionFactory
				.getCurrentSession().load(UssdMenuItem.class, menuItemId);
		if (null != ussdMenuItem) {
			sessionFactory.getCurrentSession().delete(ussdMenuItem);
		}
	}

	@SuppressWarnings("unchecked")
	public List<UssdRequest> listUssdRequests() {
		return (List<UssdRequest>) sessionFactory.getCurrentSession()
				.createCriteria(UssdRequest.class).list();
	}

}