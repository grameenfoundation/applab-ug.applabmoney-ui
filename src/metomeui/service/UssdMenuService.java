package metomeui.service;
/**
 * This is the interface which declares methods which will be used in controller class.
 */
import java.util.List;

import metomeui.model.UssdKeywordStep;
import metomeui.model.UssdMenuItem;
import metomeui.model.UssdPredefInput;
import metomeui.model.UssdPredefInputItem;
import metomeui.model.UssdTransactionKeyword;

public interface UssdMenuService {
	
	public List<UssdTransactionKeyword> listTransactionKeywords();

	public void addTransactionKeyword(
			UssdTransactionKeyword transactionKeyword);

	public void deleteTransactionKeyword(Long keywordId);

	public void editExistingTransactionKeyword(UssdTransactionKeyword transactionKeyword);
	
	public List<UssdKeywordStep> listKeywordSteps();

	public void addKeywordStep(UssdKeywordStep ussdKeywordStep);

	public void deleteExistingKeywordStep(Long keywordStepId);
	
	public void editExistingKeywordStep(UssdKeywordStep keywordStep);
	
	public List<UssdMenuItem> listMenuItems();

	public void addMenuItem(UssdMenuItem ussdMenuItem);

	public void deleteMenuItem(Long menuItemId);
	public void editExistingMenuItem(UssdMenuItem menuItem);

	public void addPredefInput(UssdPredefInput predefInput);

	public List<UssdPredefInput> listPredefInputs();
	public List<UssdPredefInputItem> listPredefInputItemsByPredefInputId(long predefInputId);

	public void editPredefInput(UssdPredefInput predefInput);

	public UssdPredefInput getExistingPredefInput(Long predefInputId);
	
	public void deleteExistingPredefInput(Long predefInputId);

	public UssdTransactionKeyword getExistingTransactionKeyword(Long keywordId);

	public UssdKeywordStep getExistingKeywordStep(Long keywordStepId);

	public UssdMenuItem getExistingMenuItem(Long menuItemId);

	public List<UssdKeywordStep> listKeywordStepByKeywordId(Long keywordId);

	public void activateExistingMenuItem(Long menuItemId);

	public void deactivateExistingMenuItem(Long menuItemId);

	public void activateExistingKeyword(Long keywordId);

	public void deactivateExistingKeyword(Long keywordId);
	
	public void activateExistingPredefInputItem(Long predefInputItemId);

	public void deactivateExistingPredefInputItem(Long predefInputItemId);

	public void deleteExistingPredefInputItem(Long inputItemId);

	public UssdPredefInputItem getExistingPredefInputItem(Long predefInputItemId);

	public List<UssdMenuItem> getChildMenuItemsForParentMenuItem(Long menuItemId);

	public boolean checkIfDuplicateStepMenuName(String stepMenuName, Long keywordId);

	public boolean checkIfDuplicateInputItemName(String predefInputItemName,
			Long predefInputId);
	
	boolean checkIfDuplicateMenuName(String menuItemName, Long menuItemId);

	boolean checkIfDuplicateKeywordName(String keywordName, Long keywordId);

	boolean checkIfDuplicateKeywordCode(String keywordCode, Long keywordId);

	public boolean checkIfDuplicateInputItemCode(String predefInputItemCode,
			Long predefInputId);

	public boolean checkIfDuplicateInputItemOrder(Integer predefInputItemOrder,
			Long predefInputId);

	boolean checkIfDuplicatePredefInputName(String predefInputName, Long predefInputId);

	public List<UssdKeywordStep> getKeywordsLinkedToThisPredefInput(
			Long predefInputId);

	public List<UssdMenuItem> getChildMenuItemsForParentMenuItem(
			UssdMenuItem rootMenuItem);
}