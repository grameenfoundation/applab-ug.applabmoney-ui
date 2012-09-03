package applabmoneyaui.service;

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


import applabmoneyaui.service.UssdMenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import applabmoneyaui.dao.UssdMenuDao;
import applabmoneyaui.model.UssdKeywordStep;
import applabmoneyaui.model.UssdMenuItem;
import applabmoneyaui.model.UssdPredefInput;
import applabmoneyaui.model.UssdPredefInputItem;
import applabmoneyaui.model.UssdTransactionKeyword;

@Service("ussdMenuService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class UssdMenuServiceImplementation implements UssdMenuService {

	@Autowired
	private UssdMenuDao ussdMenuDao;

	public UssdMenuServiceImplementation() {

	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addTransactionKeyword(
			UssdTransactionKeyword ussdTransactionKeyword) {
		ussdMenuDao.addTransactionKeyword(ussdTransactionKeyword);
	}

	@Transactional
	public List<UssdTransactionKeyword> listTransactionKeywords() {
		return ussdMenuDao.listTransactionKeywords();
	}

	@Transactional
	public void deleteTransactionKeyword(Long keywordId) {
		ussdMenuDao.deleteTransactionKeyword(keywordId);
	}

	@Transactional
	public void editExistingTransactionKeyword(
			UssdTransactionKeyword transactionKeyword) {
		ussdMenuDao.editTransactionKeyword(transactionKeyword);
	}

	@Transactional
	public UssdTransactionKeyword getExistingTransactionKeyword(Long keywordId) {
		return ussdMenuDao.getExistingTransactionKeyword(keywordId);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addKeywordStep(UssdKeywordStep ussdKeywordStep) {
		ussdMenuDao.addKeywordStep(ussdKeywordStep);
	}

	@Transactional
	public List<UssdKeywordStep> listKeywordSteps() {
		return ussdMenuDao.listKeywordSteps();
	}

	@Transactional
	public void deleteExistingKeywordStep(Long keywordStepId) {
		ussdMenuDao.deleteExistingKeywordStep(keywordStepId);
	}

	@Transactional
	public void editExistingKeywordStep(UssdKeywordStep keywordStep) {
		ussdMenuDao.editKeywordStep(keywordStep);
	}

	@Transactional
	public UssdKeywordStep getExistingKeywordStep(Long keywordStepId) {
		return ussdMenuDao.getExistingKeywordStep(keywordStepId);
	}

	@Transactional
	public List<UssdMenuItem> listMenuItems() {
		return ussdMenuDao.listMenuItems();
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addMenuItem(UssdMenuItem ussdMenuItem) {
		ussdMenuDao.addMenuItem(ussdMenuItem);
	}

	@Transactional
	public void deleteMenuItem(Long menuItemId) {
		ussdMenuDao.deleteMenuItem(menuItemId);
	}

	@Transactional
	public void editExistingMenuItem(UssdMenuItem menuItem) {
		ussdMenuDao.editMenuItem(menuItem);
	}

	@Transactional
	public UssdMenuItem getExistingMenuItem(Long menuItemId) {
		return ussdMenuDao.getExistingMenuItem(menuItemId);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addPredefInput(UssdPredefInput predefInput) {
		ussdMenuDao.addPredefInput(predefInput);
	}

	@Transactional
	public List<UssdPredefInput> listPredefInputs() {
		return ussdMenuDao.listPredefInputs();
	}

	@Transactional
	public List<UssdPredefInputItem> listPredefInputItemsByPredefInputId(
			long predefInputId) {
		return ussdMenuDao.listPredefInputItemsByPredefInputId(predefInputId);
	}

	@Transactional
	public void editPredefInput(UssdPredefInput predefInput) {
		ussdMenuDao.editPredefInput(predefInput);
	}

	@Transactional
	public UssdPredefInput getExistingPredefInput(Long predefInputId) {
		return ussdMenuDao.getExistingPredefInput(predefInputId);
	}

	@Transactional
	// (propagation = Propagation.REQUIRED, readOnly = false)
	public void deleteExistingPredefInput(Long predefInputId) {
		ussdMenuDao.deleteExistingPredefInput(predefInputId);

	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void addPredefInputItem(UssdPredefInputItem predefInputItem) {
		ussdMenuDao.addPredefInputItem(predefInputItem);
	}

	@Transactional
	public void editPredefInputItem(UssdPredefInputItem predefInputItem) {
		ussdMenuDao.editPredefInputItem(predefInputItem);
	}

	@Transactional
	public List<UssdKeywordStep> listKeywordStepByKeywordId(Long keywordId) {
		return ussdMenuDao.listKeywordStepByKeywordId(keywordId);
	}

	@Transactional
	public void activateExistingMenuItem(Long menuItemId) {
		ussdMenuDao.activateExistingMenuItem(menuItemId);

	}

	@Transactional
	public void deactivateExistingMenuItem(Long menuItemId) {
		ussdMenuDao.deactivateExistingMenuItem(menuItemId);

	}

	@Transactional
	public void activateExistingKeyword(Long keywordId) {
		ussdMenuDao.activateExistingKeyword(keywordId);

	}

	@Transactional
	public void deactivateExistingKeyword(Long keywordId) {
		ussdMenuDao.deactivateExistingKeyword(keywordId);

	}

	@Transactional
	public void activateExistingPredefInputItem(Long predefInputItemId) {
		ussdMenuDao.activateExistingPredefInputItem(predefInputItemId);

	}

	@Transactional
	public void deactivateExistingPredefInputItem(Long predefInputItemId) {
		ussdMenuDao.deactivateExistingPredefInputItem(predefInputItemId);

	}

	@Override
	public void deleteExistingPredefInputItem(Long inputItemId) {
		ussdMenuDao.deleteExistingPredefInputItem(inputItemId);

	}

	@Override
	public UssdPredefInputItem getExistingPredefInputItem(Long predefInputItemId) {
		return ussdMenuDao.getExistingPredefInputItem(predefInputItemId);
	}

	@Override
	public List<UssdMenuItem> getChildMenuItemsForParentMenuItem(Long menuItemId) {
		return ussdMenuDao.getChildMenuItemsForParentMenuItem(menuItemId);
	}

	@Override
	public boolean checkIfDuplicateStepMenuName(String stepMenuName,
			Long keywordId) {
		return ussdMenuDao
				.checkIfDuplicateStepMenuName(stepMenuName, keywordId);
	}

	@Override
	public boolean checkIfDuplicateStepMenuNumber(Integer stepMenuNumber,
			Long keywordId) {
		return ussdMenuDao.checkIfDuplicateStepMenuNumber(stepMenuNumber,
				keywordId);
	}

	@Override
	public boolean checkIfDuplicateInputItemName(String predefInputItemName,
			Long predefInputId) {
		return ussdMenuDao.checkIfDuplicateInputItemName(predefInputItemName,
				predefInputId);
	}

	@Override
	public boolean checkIfDuplicateInputItemCode(String predefInputItemCode,
			Long predefInputId) {
		return ussdMenuDao.checkIfDuplicateInputItemCode(predefInputItemCode,
				predefInputId);
	}

	@Override
	public boolean checkIfDuplicateInputItemOrder(Integer predefInputItemOrder,
			Long predefInputId) {
		return ussdMenuDao.checkIfDuplicateInputItemOrder(predefInputItemOrder,
				predefInputId);
	}

	@Override
	public boolean checkIfDuplicatePredefInputName(String predefInputName,
			Long predefInputId) {
		return ussdMenuDao.checkIfDuplicatePredefInputName(predefInputName,
				predefInputId);
	}

	@Override
	public boolean checkIfDuplicateMenuName(String menuItemName, Long menuItemId) {
		return ussdMenuDao.checkIfDuplicateMenuName(menuItemName, menuItemId);
	}

	@Override
	public boolean checkIfDuplicateKeywordName(String keywordName,
			Long keywordId) {
		return ussdMenuDao.checkIfDuplicateKeywordName(keywordName, keywordId);
	}

	@Override
	public boolean checkIfDuplicateKeywordCode(String keywordCode,
			Long keywordId) {
		return ussdMenuDao.checkIfDuplicateKeywordName(keywordCode, keywordId);
	}

	@Override
	public List<UssdKeywordStep> getKeywordsLinkedToThisPredefInput(
			Long predefInputId) {
		return ussdMenuDao.getKeywordsLinkedToThisPredefInput(predefInputId);
	}

	@Override
	public List<UssdMenuItem> getChildMenuItemsForParentMenuItem(
			UssdMenuItem rootMenuItem) {
		return ussdMenuDao.getChildMenuItemsForParentMenuItem(rootMenuItem);
	}
}