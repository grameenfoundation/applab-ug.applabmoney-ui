package metomeui.service;

/**
 * This is the implementation class of the UssdMenuService Interface. 
 * It defines all the methods declared in UssdMenuService interface. 
 * These methods uses Dao classes to interact with the database.
 * @Service("ussdMenuService") annotation is used to declare it as service bean 
 * and its name ussdMenuService will be used to auto wire its instance in controller class.
 * @Transactional annotation is used to declare the method transactional. 
 * You can also use this at the class level to declare all methods transactional.
 */
import java.util.List;

import metomeui.dao.UssdMenuDao;
import metomeui.model.UssdKeywordStep;
import metomeui.model.UssdMenuItem;
import metomeui.model.UssdPredefInput;
import metomeui.model.UssdPredefInputItem;
import metomeui.model.UssdRequest;
import metomeui.model.UssdTransactionKeyword;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("ussdMenuService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UssdMenuServiceImplementation implements UssdMenuService {

	@Autowired
	private UssdMenuDao ussdMenuDao;

	public UssdMenuServiceImplementation() {
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addUssdPredefInputItem(UssdPredefInputItem ussdPredefInputItem) {
		ussdMenuDao.addUssdPredefInputItem(ussdPredefInputItem);
	}

	@Transactional
	public List<UssdPredefInputItem> listUssdPredefInputItems() {
		return ussdMenuDao.listUssdPredefInputItems();
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void removeUssdPredefInputItem(Integer inputItemId) {
		ussdMenuDao.removeUssdPredefInputItem(inputItemId);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addUssdPredefInput(UssdPredefInput ussdPredefInput) {
		ussdMenuDao.addUssdPredefInput(ussdPredefInput);
	}

	@Transactional
	public List<UssdPredefInput> listUssdPredefInputs() {
		return ussdMenuDao.listUssdPredefInputs();
	}

	@Transactional
	public UssdPredefInput retrieveSinglePredefInputEntry(Integer predefInputId) {
		return ussdMenuDao.retrieveSinglePredefInputEntry(predefInputId);
	}

	@Transactional
	public void updatePredefInput(UssdPredefInput ussdPredefInput,
			Integer predefInputId) {
		ussdMenuDao.updatePredefInput(ussdPredefInput, predefInputId);
	}

	@Transactional
	public void removeUssdPredefInput(Integer predefInputId) {
		ussdMenuDao.removeUssdPredefInput(predefInputId);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addUssdTransactionKeyword(
			UssdTransactionKeyword ussdTransactionKeyword) {
		ussdMenuDao.addUssdTransactionKeyword(ussdTransactionKeyword);
	}

	@Transactional
	public List<UssdTransactionKeyword> listUssdTransactionKeywords() {
		return ussdMenuDao.listUssdTransactionKeywords();
	}

	@Transactional
	public void removeUssdTransactionKeyword(Integer keywordId) {
		ussdMenuDao.removeUssdTransactionKeyword(keywordId);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addUssdKeywordStep(UssdKeywordStep ussdKeywordStep) {
		ussdMenuDao.addUssdKeywordStep(ussdKeywordStep);
	}

	@Transactional
	public List<UssdKeywordStep> listUssdKeywordSteps() {
		return ussdMenuDao.listUssdKeywordSteps();
	}

	@Transactional
	public void removeUssdKeywordStep(Integer keywordStepId) {
		ussdMenuDao.removeUssdKeywordStep(keywordStepId);
	}

	@Transactional
	public List<UssdMenuItem> listUssdMenuItems() {
		return ussdMenuDao.listUssdMenuItems();
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addUssdMenuItem(UssdMenuItem ussdMenuItem) {
		ussdMenuDao.addUssdMenuItem(ussdMenuItem);
	}

	@Transactional
	public void removeUssdMenuItem(Integer menuItemId) {
		ussdMenuDao.removeUssdMenuItem(menuItemId);
	}

	@Transactional
	public List<UssdRequest> listUssdRequests() {
		return ussdMenuDao.listUssdRequests();
	}

}