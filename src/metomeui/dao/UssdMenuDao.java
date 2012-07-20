package metomeui.dao;

import java.util.List;

import metomeui.model.UssdKeywordStep;
import metomeui.model.UssdMenuItem;
import metomeui.model.UssdPredefInput;
import metomeui.model.UssdPredefInputItem;
import metomeui.model.UssdTransactionKeyword;

public interface UssdMenuDao {

	public boolean isSuccess();

	public void setSuccess(boolean success);

	public List<UssdTransactionKeyword> listTransactionKeywords();

	public void addTransactionKeyword(UssdTransactionKeyword transactionKeyword);

	public void deleteTransactionKeyword(Long keywordId);

	public void editTransactionKeyword(UssdTransactionKeyword transactionKeyword);

	public UssdTransactionKeyword getExistingTransactionKeyword(Long keywordId);

	public void deactivateExistingKeyword(Long keywordId);

	public void activateExistingKeyword(Long keywordId);

	boolean checkIfDuplicateKeywordName(String keywordName, Long keywordId);

	boolean checkIfDuplicateKeywordCode(String keywordCode, Long keywordId);

	public List<UssdKeywordStep> listKeywordSteps();

	public void addKeywordStep(UssdKeywordStep ussdKeywordStep);

	public void deleteExistingKeywordStep(Long keywordStepId);

	public void editKeywordStep(UssdKeywordStep keywordStep);

	public UssdKeywordStep getExistingKeywordStep(Long keywordStepId);

	public List<UssdKeywordStep> listKeywordStepByKeywordId(Long keywordId);

	public boolean checkIfDuplicateStepMenuNumber(Integer stepMenuNumber,
			Long keywordId);

	boolean checkIfDuplicateStepMenuName(String stepMenuName, Long keywordId);

	public List<UssdMenuItem> listMenuItems();

	public void addMenuItem(UssdMenuItem ussdMenuItem);

	public void deleteMenuItem(Long menuItemId);

	public void editMenuItem(UssdMenuItem menuItem);

	public UssdMenuItem getExistingMenuItem(Long menuItemId);

	public void activateExistingMenuItem(Long menuItemId);

	public void deactivateExistingMenuItem(Long menuItemId);

	boolean checkIfDuplicateMenuName(String menuItemName, Long menuItemId);

	public void addPredefInput(UssdPredefInput predefInput);

	public List<UssdPredefInput> listPredefInputs();

	public void editPredefInput(UssdPredefInput predefInput);

	public UssdPredefInput getExistingPredefInput(Long predefInputId);

	public void deleteExistingPredefInput(Long predefInputId);

	public List<UssdKeywordStep> getKeywordsLinkedToThisPredefInput(
			Long predefInputId);

	boolean checkIfDuplicatePredefInputName(String predefInputName,
			Long predefInputId);

	public void deleteExistingPredefInputItem(Long inputItemId);

	public void activateExistingPredefInputItem(Long predefInputItemId);

	public List<UssdPredefInputItem> listPredefInputItemsByPredefInputId(
			Long predefInputId);

	public void deactivateExistingPredefInputItem(Long predefInputItemId);

	public UssdPredefInputItem getExistingPredefInputItem(Long predefInputItemId);

	public boolean checkIfDuplicateInputItemName(String predefInputItemName,
			Long predefInputId);

	public boolean checkIfDuplicateInputItemCode(String predefInputItemCode,
			Long predefInputId);

	public boolean checkIfDuplicateInputItemOrder(Integer predefInputItemOrder,
			Long predefInputId);

	public List<UssdMenuItem> getChildMenuItemsForParentMenuItem(Long menuItemId);

	public List<UssdMenuItem> getChildMenuItemsForParentMenuItem(
			UssdMenuItem rootMenuItem);
}