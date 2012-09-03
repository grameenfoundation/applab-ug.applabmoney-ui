package applabmoneyaui.dao;

import java.util.List;

import applabmoneyaui.model.MeToMeGoalType;
import applabmoneyaui.model.MeToMeRewardType;
import applabmoneyaui.model.ZimbaConfiguration;


public interface ProductsDao {

	public List<MeToMeGoalType> listMeToMeGoalTypes();

	public void addMeToMeGoalType(MeToMeGoalType meToMeGoalType);

	public void deleteMeToMeGoalType(Long meToMeGoalTypeId);

	public void editMeToMeGoalType(MeToMeGoalType meToMeGoalType);

	public MeToMeGoalType getExistingMeToMeGoalType(Long meToMeGoalTypeId);

	boolean checkIfDuplicateMeToMeGoalTypeName(String meToMeGoalTypeName);

	boolean checkIfDuplicateMeToMeGoalTypeCode(String meToMeGoalTypeCode);

	public void addMeToMeRewardType(MeToMeRewardType meToMeRewardType);

	public boolean checkIfDuplicateMeToMeRewardTypeCode(
			String meToMeRewardTypeCode);

	public boolean checkIfDuplicateMeToMeRewardTypeName(
			String meToMeRewardTypeName);

	public MeToMeRewardType getExistingMeToMeRewardType(Long meToMeRewardTypeId);

	public List<MeToMeRewardType> listMeToMeRewardTypes();

	public void editMeToMeRewardType(MeToMeRewardType meToMeRewardType);

	public void deleteMeToMeRewardType(Long meToMeRewardTypeId);

	public void addZimbaConfiguration(ZimbaConfiguration zimbaConfiguration);

	public void editZimbaConfiguration(ZimbaConfiguration zimbaConfiguration);

	public ZimbaConfiguration getZimbaConfiguration();
}
