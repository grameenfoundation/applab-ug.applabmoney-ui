package metomeui.service;

import java.util.List;

import metomeui.model.MeToMeGoalType;
import metomeui.model.MeToMeRewardType;

public interface ProductsService {

	public List<MeToMeGoalType> listMeToMeGoalTypes();

	public void addMeToMeGoalType(MeToMeGoalType meToMeGoalType);

	public MeToMeGoalType getExistingMeToMeGoalType(Long meToMeGoalTypeId);

	boolean checkIfDuplicateMeToMeGoalTypeName(String meToMeGoalTypeName,
			Long meToMeGoalTypeId);

	boolean checkIfDuplicateMeToMeGoalTypeCode(String meToMeGoalTypeCode,
			Long meToMeGoalTypeId);

	public void deleteExistingMeToMeGoalType(Long meToMeGoalTypeId);

	public void editExistingMeToMeGoalType(MeToMeGoalType meToMeGoalType);

	public List<MeToMeRewardType> listMeToMeRewardTypes();

	public void addMeToMeRewardType(MeToMeRewardType meToMeRewardType);

	public MeToMeRewardType getExistingMeToMeRewardType(Long meToMeRewardTypeId);

	public boolean checkIfDuplicateMeToMeRewardTypeName(String meToMeRewardTypeName,
			Long meToMeRewardTypeId);

	public boolean checkIfDuplicateMeToMeRewardTypeCode(String meToMeRewardTypeCode,
			Long meToMeRewardTypeId);

	public void deleteExistingMeToMeRewardType(Long meToMeRewardTypeId);

	public void editExistingMeToMeRewardType(MeToMeRewardType meToMeRewardType);

}
