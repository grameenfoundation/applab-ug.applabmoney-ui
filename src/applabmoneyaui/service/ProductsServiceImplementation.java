package applabmoneyaui.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import applabmoneyaui.dao.ProductsDao;
import applabmoneyaui.dao.ProductsDaoImplementation;

import applabmoneyaui.service.ProductsService;

import applabmoneyaui.model.MeToMeGoalType;
import applabmoneyaui.model.MeToMeRewardType;
import applabmoneyaui.model.ZimbaConfiguration;

@Service("productsService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProductsServiceImplementation implements ProductsService {

	@Autowired
	private ProductsDao productsDao = new ProductsDaoImplementation();

	public ProductsServiceImplementation() {

	}

	@Transactional
	public List<MeToMeGoalType> listMeToMeGoalTypes() {
		return productsDao.listMeToMeGoalTypes();
	}

	@Transactional
	public void addMeToMeGoalType(MeToMeGoalType meToMeGoalType) {
		productsDao.addMeToMeGoalType(meToMeGoalType);
	}

	@Transactional
	public void editMeToMeGoalType(MeToMeGoalType meToMeGoalType) {
		productsDao.editMeToMeGoalType(meToMeGoalType);
	}

	@Transactional
	public MeToMeGoalType getExistingMeToMeGoalType(Long meToMeGoalTypeId) {
		return productsDao.getExistingMeToMeGoalType(meToMeGoalTypeId);
	}

	@Transactional
	public boolean checkIfDuplicateMeToMeGoalTypeName(String meToMeGoalTypeName) {
		return productsDao
				.checkIfDuplicateMeToMeGoalTypeName(meToMeGoalTypeName);
	}

	@Transactional
	public boolean checkIfDuplicateMeToMeGoalTypeCode(String meToMeGoalTypeCode) {
		return productsDao
				.checkIfDuplicateMeToMeGoalTypeCode(meToMeGoalTypeCode);
	}

	@Transactional
	public void deleteExistingMeToMeGoalType(Long meToMeGoalTypeId) {
		productsDao.deleteMeToMeGoalType(meToMeGoalTypeId);

	}

	@Transactional
	public void editExistingMeToMeGoalType(MeToMeGoalType meToMeGoalType) {
		productsDao.editMeToMeGoalType(meToMeGoalType);

	}

	@Transactional
	public List<MeToMeRewardType> listMeToMeRewardTypes() {
		return productsDao.listMeToMeRewardTypes();
	}

	@Transactional
	public void addMeToMeRewardType(MeToMeRewardType meToMeRewardType) {
		productsDao.addMeToMeRewardType(meToMeRewardType);

	}

	@Transactional
	public MeToMeRewardType getExistingMeToMeRewardType(Long meToMeRewardTypeId) {
		return productsDao.getExistingMeToMeRewardType(meToMeRewardTypeId);
	}

	@Transactional
	public boolean checkIfDuplicateMeToMeRewardTypeName(
			String meToMeRewardTypeName) {
		return productsDao
				.checkIfDuplicateMeToMeRewardTypeName(meToMeRewardTypeName);
	}

	@Transactional
	public boolean checkIfDuplicateMeToMeRewardTypeCode(
			String meToMeRewardTypeCode) {
		return productsDao
				.checkIfDuplicateMeToMeRewardTypeCode(meToMeRewardTypeCode);
	}

	@Transactional
	public void deleteExistingMeToMeRewardType(Long meToMeRewardTypeId) {
		productsDao.deleteMeToMeRewardType(meToMeRewardTypeId);

	}

	@Transactional
	public void editExistingMeToMeRewardType(MeToMeRewardType meToMeRewardType) {
		productsDao.editMeToMeRewardType(meToMeRewardType);

	}

	@Transactional
	public void addZimbaConfiguration(ZimbaConfiguration zimbaConfiguration) {
		productsDao.addZimbaConfiguration(zimbaConfiguration);
	}

	@Transactional
	public void editExistingZimbaConfiguration(
			ZimbaConfiguration zimbaConfiguration) {
		productsDao.editZimbaConfiguration(zimbaConfiguration);
	}

	@Transactional
	public ZimbaConfiguration getZimbaConfiguration() {
		return productsDao.getZimbaConfiguration();
	}
}
