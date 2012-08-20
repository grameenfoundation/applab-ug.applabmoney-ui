package metomeui.service;

import java.util.List;

import metomeui.model.MeToMeGoalType;
import metomeui.model.MeToMeRewardType;
import metomeui.model.ZimbaConfiguration;

public interface ProductsService {

	public List<MeToMeGoalType> listMeToMeGoalTypes();

	public void addMeToMeGoalType(MeToMeGoalType meToMeGoalType);

	public MeToMeGoalType getExistingMeToMeGoalType(Long meToMeGoalTypeId);

	boolean checkIfDuplicateMeToMeGoalTypeName(String meToMeGoalTypeName);

	boolean checkIfDuplicateMeToMeGoalTypeCode(String meToMeGoalTypeCode);

	public void deleteExistingMeToMeGoalType(Long meToMeGoalTypeId);

	public void editExistingMeToMeGoalType(MeToMeGoalType meToMeGoalType);

	public List<MeToMeRewardType> listMeToMeRewardTypes();

	public void addMeToMeRewardType(MeToMeRewardType meToMeRewardType);

	public MeToMeRewardType getExistingMeToMeRewardType(Long meToMeRewardTypeId);

	public boolean checkIfDuplicateMeToMeRewardTypeName(
			String meToMeRewardTypeName);

	public boolean checkIfDuplicateMeToMeRewardTypeCode(
			String meToMeRewardTypeCode);

	public void deleteExistingMeToMeRewardType(Long meToMeRewardTypeId);

	public void editExistingMeToMeRewardType(MeToMeRewardType meToMeRewardType);

	public void addZimbaConfiguration(ZimbaConfiguration zimbaConfiguration);

	public void editExistingZimbaConfiguration(
			ZimbaConfiguration zimbaConfiguration);

	public ZimbaConfiguration getZimbaConfiguration();
}
