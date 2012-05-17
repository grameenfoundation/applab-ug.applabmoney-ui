package metomeui.dao;

import java.util.List;

import metomeui.model.UssdKeywordStep;
import metomeui.model.UssdMenuItem;
import metomeui.model.UssdPredefInput;
import metomeui.model.UssdPredefInputItem;
import metomeui.model.UssdRequest;
import metomeui.model.UssdTransactionKeyword;

public interface UssdMenuDao {

	public List<UssdPredefInputItem> listUssdPredefInputItems();

	public void addUssdPredefInputItem(UssdPredefInputItem ussdPredefInputItem);

	public void removeUssdPredefInputItem(Integer inputItemId);

	public List<UssdPredefInput> listUssdPredefInputs();
	
	public UssdPredefInput retrieveSinglePredefInputEntry(Integer predefInputId);

	public void addUssdPredefInput(UssdPredefInput ussdPredefInput);
	
	public void updatePredefInput(UssdPredefInput ussdPredefInput, Integer predefInputId);

	public void removeUssdPredefInput(Integer predefInputId);

	public List<UssdTransactionKeyword> listUssdTransactionKeywords();

	public void addUssdTransactionKeyword(
			UssdTransactionKeyword ussdTransactionKeyword);

	public void removeUssdTransactionKeyword(Integer keywordId);

	public List<UssdKeywordStep> listUssdKeywordSteps();

	public void addUssdKeywordStep(UssdKeywordStep ussdKeywordStep);

	public void removeUssdKeywordStep(Integer keywordStepId);

	public List<UssdMenuItem> listUssdMenuItems();

	public void addUssdMenuItem(UssdMenuItem ussdMenuItem);

	public void removeUssdMenuItem(Integer menuItemId);

	public List<UssdRequest> listUssdRequests();

	
}
