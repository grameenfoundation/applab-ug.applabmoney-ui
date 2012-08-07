package metomeui.dao;

import java.util.List;

import metomeui.model.MeToMeGoalType;
import metomeui.model.MeToMeRewardType;

public interface ProductsDao {

	public List<MeToMeGoalType> listMeToMeGoalTypes();

	public void addMeToMeGoalType(MeToMeGoalType meToMeGoalType);

	public void deleteMeToMeGoalType(Long meToMeGoalTypeId);

	public void editMeToMeGoalType(MeToMeGoalType meToMeGoalType);

	public MeToMeGoalType getExistingMeToMeGoalType(Long meToMeGoalTypeId);

	boolean checkIfDuplicateMeToMeGoalTypeName(String meToMeGoalTypeName,
			Long meToMeGoalTypeId);

	boolean checkIfDuplicateMeToMeGoalTypeCode(String meToMeGoalTypeCode,
			Long meToMeGoalTypeId);

	public void addMeToMeRewardType(MeToMeRewardType meToMeRewardType);

	public boolean checkIfDuplicateMeToMeRewardTypeCode(
			String meToMeRewardTypeCode, Long meToMeRewardTypeId);

	public boolean checkIfDuplicateMeToMeRewardTypeName(
			String meToMeRewardTypeName, Long meToMeRewardTypeId);

	public MeToMeRewardType getExistingMeToMeRewardType(Long meToMeRewardTypeId);

	public List<MeToMeRewardType> listMeToMeRewardTypes();

	public void editMeToMeRewardType(MeToMeRewardType meToMeRewardType);

	public void deleteMeToMeRewardType(Long meToMeRewardTypeId);
}
