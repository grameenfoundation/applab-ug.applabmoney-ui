package metomeui.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import metomeui.dao.ProductsDao;
import metomeui.dao.ProductsDaoImplementation;
import metomeui.dao.SystemSettingsDao;
import metomeui.dao.SystemSettingsDaoImplementation;
import metomeui.model.MeToMeGoalType;
import metomeui.model.MeToMeRewardType;

@Service("productsService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProductsServiceImplementation implements ProductsService {

	@Autowired
	private ProductsDao productsDao = new ProductsDaoImplementation();

	public ProductsServiceImplementation() {

	}

	public List<MeToMeGoalType> listMeToMeGoalTypes() {
		return productsDao.listMeToMeGoalTypes();
	}

	public void addMeToMeGoalType(MeToMeGoalType meToMeGoalType) {
		productsDao.addMeToMeGoalType(meToMeGoalType);
	}

	public void editMeToMeGoalType(MeToMeGoalType meToMeGoalType) {
		productsDao.editMeToMeGoalType(meToMeGoalType);
	}

	public MeToMeGoalType getExistingMeToMeGoalType(Long meToMeGoalTypeId) {
		return productsDao.getExistingMeToMeGoalType(meToMeGoalTypeId);
	}

	public boolean checkIfDuplicateMeToMeGoalTypeName(
			String meToMeGoalTypeName, Long meToMeGoalTypeId) {
		return productsDao.checkIfDuplicateMeToMeGoalTypeName(
				meToMeGoalTypeName, meToMeGoalTypeId);

	}

	public boolean checkIfDuplicateMeToMeGoalTypeCode(
			String meToMeGoalTypeCode, Long meToMeGoalTypeId) {
		return productsDao.checkIfDuplicateMeToMeGoalTypeCode(
				meToMeGoalTypeCode, meToMeGoalTypeId);
	}

	@Override
	public void deleteExistingMeToMeGoalType(Long meToMeGoalTypeId) {
		productsDao.deleteMeToMeGoalType(meToMeGoalTypeId);

	}

	@Override
	public void editExistingMeToMeGoalType(MeToMeGoalType meToMeGoalType) {
		productsDao.editMeToMeGoalType(meToMeGoalType);

	}

	@Override
	public List<MeToMeRewardType> listMeToMeRewardTypes() {
		return productsDao.listMeToMeRewardTypes();
	}

	@Override
	public void addMeToMeRewardType(MeToMeRewardType meToMeRewardType) {
		productsDao.addMeToMeRewardType(meToMeRewardType);

	}

	@Override
	public MeToMeRewardType getExistingMeToMeRewardType(Long meToMeRewardTypeId) {
		return productsDao.getExistingMeToMeRewardType(meToMeRewardTypeId);
	}

	@Override
	public boolean checkIfDuplicateMeToMeRewardTypeName(
			String meToMeRewardTypeName, Long meToMeRewardTypeId) {
		return productsDao.checkIfDuplicateMeToMeRewardTypeName(
				meToMeRewardTypeName, meToMeRewardTypeId);
	}

	@Override
	public boolean checkIfDuplicateMeToMeRewardTypeCode(
			String meToMeRewardTypeCode, Long meToMeRewardTypeId) {
		return productsDao.checkIfDuplicateMeToMeRewardTypeCode(
				meToMeRewardTypeCode, meToMeRewardTypeId);
	}

	@Override
	public void deleteExistingMeToMeRewardType(Long meToMeRewardTypeId) {
		productsDao.deleteMeToMeRewardType(meToMeRewardTypeId);

	}

	@Override
	public void editExistingMeToMeRewardType(MeToMeRewardType meToMeRewardType) {
		productsDao.editMeToMeRewardType(meToMeRewardType);

	}
}
