package metomeui.dao;

import java.util.List;

import metomeui.model.UssdKeywordStep;
import metomeui.model.UssdMenuItem;
import metomeui.model.UssdPredefInput;
import metomeui.model.UssdPredefInputItem;
import metomeui.model.UssdTransactionKeyword;

public interface UssdMenuDao {

	public List<UssdTransactionKeyword> listTransactionKeywords();

	public void addTransactionKeyword(
			UssdTransactionKeyword transactionKeyword);

	public void deleteTransactionKeyword(Long keywordId);

	public void editTransactionKeyword(UssdTransactionKeyword transactionKeyword);
	
	public UssdTransactionKeyword getExistingTransactionKeyword(long keywordId);
	
	public List<UssdKeywordStep> listKeywordSteps();

	public void addKeywordStep(UssdKeywordStep ussdKeywordStep);

	public void deleteExistingKeywordStep(Long keywordStepId);
	
	public void editKeywordStep(UssdKeywordStep keywordStep);
	
	public UssdKeywordStep getExistingKeywordStep(long keywordStepId);
	
	public List<UssdMenuItem> listMenuItems();

	public void addMenuItem(UssdMenuItem ussdMenuItem);

	public void deleteMenuItem(Long menuItemId);
	public void editMenuItem(UssdMenuItem menuItem);
	
	public UssdMenuItem getExistingMenuItem(long menuItemId);
	
	public void addPredefInput(UssdPredefInput predefInput);

	public List<UssdPredefInput> listPredefInputs();
	public List<UssdPredefInputItem> listPredefInputItemsByPredefInputId(long predefInputId);

	public void editPredefInput(UssdPredefInput predefInput);

	public UssdPredefInput getExistingPredefInput(Long predefInputId);

	public void deleteExistingPredefInput(Long predefInputId);

	public List<UssdKeywordStep> listKeywordStepByKeywordId(long keywordId);

	public void activateExistingMenuItem(Long menuItemId);

	public void deactivateExistingMenuItem(Long menuItemId);

	public void activateExistingPredefInputItem(Long predefInputItemId);

	public void deactivateExistingPredefInputItem(Long predefInputItemId);

	public void deactivateExistingKeyword(Long keywordId);

	public void activateExistingKeyword(Long keywordId);

	public boolean checkIfDuplicateStepMenuNumber(Integer stepMenuNumber, Long keywordId);

	boolean checkIfDuplicateStepMenuName(String stepMenuName, Long keywordId);

	public void deleteExistingPredefInputItem(Long inputItemId);

	public UssdPredefInputItem getExistingPredefInputItem(Long predefInputItemId);

	public List<UssdKeywordStep> getKeywordsLinkedToThisPredefInput(
			Long predefInputId);

	public List<UssdMenuItem> getChildMenuItemsForParentMenuItem(Long menuItemId);

	public boolean checkIfDuplicateInputItemName(String predefInputItemName,
			Long predefInputId);

	public boolean checkIfDuplicateInputItemCode(String predefInputItemCode,
			Long predefInputId);

	public boolean checkIfDuplicateInputItemOrder(Integer predefInputItemOrder,
			Long predefInputId);

	boolean checkIfDuplicatePredefInputName(String predefInputName,
			Long predefInputId);

	boolean checkIfDuplicateMenuName(String menuItemName, Long menuItemId);

	boolean checkIfDuplicateKeywordName(String keywordName, Long keywordId);

	boolean checkIfDuplicateKeywordCode(String keywordCode, Long keywordId);
}
