package metomeui.service;
/**
 * This is the interface which declares methods which will be used in controller class.
 */
import java.util.List;

import metomeui.model.UssdKeywordStep;
import metomeui.model.UssdMenuItem;
import metomeui.model.UssdPredefInput;
import metomeui.model.UssdPredefInputItem;
import metomeui.model.UssdRequest;
import metomeui.model.UssdTransactionKeyword;

public interface UssdMenuService {

	public void addUssdPredefInputItem(UssdPredefInputItem ussdPredefInputItem);

	public List<UssdPredefInputItem> listUssdPredefInputItems();
	
	public void removeUssdPredefInputItem(Integer inputItemId);
	
	public void addUssdPredefInput(UssdPredefInput ussdPredefInput);

	public List<UssdPredefInput> listUssdPredefInputs();
	
	public UssdPredefInput retrieveSinglePredefInputEntry(Integer predefInputId);

	public void updatePredefInput(UssdPredefInput ussdPredefInput, Integer predefInputId);
	
	public void removeUssdPredefInput(Integer predefInputId);

	public void addUssdTransactionKeyword(
			UssdTransactionKeyword ussdTransactionKeyword);
	
	public List<UssdTransactionKeyword> listUssdTransactionKeywords();

	public void removeUssdTransactionKeyword(Integer keywordId);

	public void addUssdKeywordStep(UssdKeywordStep ussdKeywordStep);
	
	public List<UssdKeywordStep> listUssdKeywordSteps();

	public void removeUssdKeywordStep(Integer keywordStepId);

	public List<UssdMenuItem> listUssdMenuItems();

	public void addUssdMenuItem(UssdMenuItem ussdMenuItem);

	public void removeUssdMenuItem(Integer menuItemId);

	public List<UssdRequest> listUssdRequests();
	
	

	

	

	
}