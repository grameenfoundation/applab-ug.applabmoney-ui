package metomeui.dao;

import java.util.List;

import metomeui.model.MeToMeGoalType;
import metomeui.model.MeToMeRewardType;

import org.apache.log4j.Logger;
import org.hibernate.classic.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Repository("productsDao") declares that the annotated class is a "DAO".
 * @Autowired is being used to make the SessionFactory instance available
 *            automatically by spring.
 */
@Repository("productsDao")
@Transactional
public class ProductsDaoImplementation implements ProductsDao {

	private static Logger logger = Logger
			.getLogger(SystemSettingsDaoImplementation.class);

	private HibernateUtil hibernateUtil = new HibernateUtil();

	private Session currentSession() {

		return hibernateUtil.getSessionFactory().getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MeToMeGoalType> listMeToMeGoalTypes() {
		currentSession().beginTransaction();
		return (List<MeToMeGoalType>) currentSession().createCriteria(
				MeToMeGoalType.class).list();
	}

	@Override
	public void addMeToMeGoalType(MeToMeGoalType meToMeGoalType) {
		try {
			currentSession().beginTransaction();
			logger.debug("Saving meToMeGoalType");
			currentSession().save(meToMeGoalType);
			currentSession().getTransaction().commit();
		} catch (RuntimeException e) {
			currentSession().getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public void deleteMeToMeGoalType(Long meToMeGoalTypeId) {
		try {
			currentSession().beginTransaction();
			MeToMeGoalType meToMeGoalType = (MeToMeGoalType) currentSession()
					.get(MeToMeGoalType.class, meToMeGoalTypeId);
			if (null != meToMeGoalType) {
				currentSession().delete(meToMeGoalType);
				currentSession().getTransaction().commit();
			}
		} catch (RuntimeException e) {
			currentSession().getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public void editMeToMeGoalType(MeToMeGoalType meToMeGoalType) {
		currentSession().beginTransaction();
		MeToMeGoalType existingMeToMeGoalType = (MeToMeGoalType) currentSession()
				.load(MeToMeGoalType.class, meToMeGoalType.getGoalTypeId());

		if (null != existingMeToMeGoalType) {

			// Assign updated values to this existing Transaction Keyword
			existingMeToMeGoalType.setGoalTypeName(meToMeGoalType
					.getGoalTypeName());
			existingMeToMeGoalType.setGoalTypeDescription(meToMeGoalType
					.getGoalTypeDescription());
			existingMeToMeGoalType.setGoalTypeCode(meToMeGoalType
					.getGoalTypeCode());
			try {

				// Save updates
				currentSession().update(existingMeToMeGoalType);
				currentSession().getTransaction().commit();
			} catch (Exception e) {
				currentSession().getTransaction().rollback();
				e.printStackTrace();
			}
		}

	}

	@Override
	public MeToMeGoalType getExistingMeToMeGoalType(Long meToMeGoalTypeId) {
		currentSession().beginTransaction();
		MeToMeGoalType existingMeToMeGoalType = (MeToMeGoalType) currentSession()
				.load(MeToMeGoalType.class, meToMeGoalTypeId);
		return existingMeToMeGoalType;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean checkIfDuplicateMeToMeGoalTypeName(
			String meToMeGoalTypeName, Long meToMeGoalTypeId) {
		currentSession().beginTransaction();
		List<MeToMeGoalType> meToMeGoalType = (List<MeToMeGoalType>) currentSession()
				.createQuery(
						"from MeToMeGoalType meToMeGoalType "
								+ "where meToMeGoalType.meToMeGoalTypeId = :meToMeGoalTypeId and meToMeGoalType.meToMeGoalTypeName = :meToMeGoalTypeName")
				.setParameter("meToMeGoalTypeId", meToMeGoalTypeId)
				.setParameter("meToMeGoalTypeName", meToMeGoalTypeName).list();
		if (meToMeGoalType.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean checkIfDuplicateMeToMeGoalTypeCode(
			String meToMeGoalTypeCode, Long meToMeGoalTypeId) {
		currentSession().beginTransaction();
		List<MeToMeGoalType> meToMeGoalType = (List<MeToMeGoalType>) currentSession()
				.createQuery(
						"from MeToMeGoalType meToMeGoalType "
								+ "where meToMeGoalType.goalTypeId = :meToMeGoalTypeId and meToMeGoalType.goalTypeCode = :meToMeGoalTypeCode")
				.setParameter("meToMeGoalTypeId", meToMeGoalTypeId)
				.setParameter("meToMeGoalTypeCode", meToMeGoalTypeCode).list();
		if (meToMeGoalType.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<MeToMeRewardType> listMeToMeRewardTypes() {
		currentSession().beginTransaction();
		return (List<MeToMeRewardType>) currentSession().createCriteria(
				MeToMeRewardType.class).list();
	}

	@Override
	public void addMeToMeRewardType(MeToMeRewardType meToMeRewardType) {
		try {
			currentSession().beginTransaction();
			logger.debug("Saving meToMeRewardType");
			currentSession().save(meToMeRewardType);
			currentSession().getTransaction().commit();
		} catch (RuntimeException e) {
			currentSession().getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public void deleteMeToMeRewardType(Long meToMeRewardTypeId) {
		try {
			currentSession().beginTransaction();
			MeToMeRewardType meToMeRewardType = (MeToMeRewardType) currentSession()
					.get(MeToMeRewardType.class, meToMeRewardTypeId);
			if (null != meToMeRewardType) {
				currentSession().delete(meToMeRewardType);
				currentSession().getTransaction().commit();
			}
		} catch (RuntimeException e) {
			currentSession().getTransaction().rollback();
			throw e;
		}

	}

	@Override
	public void editMeToMeRewardType(MeToMeRewardType meToMeRewardType) {
		currentSession().beginTransaction();

		MeToMeRewardType existingMeToMeRewardType = (MeToMeRewardType) currentSession()
				.load(MeToMeRewardType.class,
						meToMeRewardType.getRewardTypeId());

		if (null != existingMeToMeRewardType) {

			// Assign updated values to this existing Transaction Keyword
			existingMeToMeRewardType.setRewardTypeName(meToMeRewardType
					.getRewardTypeName());
			existingMeToMeRewardType.setRewardTypeDescription(meToMeRewardType
					.getRewardTypeDescription());
			existingMeToMeRewardType.setRewardTypeCode(meToMeRewardType
					.getRewardTypeCode());
			existingMeToMeRewardType.setCashRewardFlag(meToMeRewardType
					.getCashRewardFlag());
			try {

				// Save updates
				currentSession().update(existingMeToMeRewardType);
				currentSession().getTransaction().commit();
			} catch (Exception e) {
				currentSession().getTransaction().rollback();
				e.printStackTrace();
			}
		}
	}

	@Override
	public MeToMeRewardType getExistingMeToMeRewardType(Long meToMeRewardTypeId) {
		currentSession().beginTransaction();
		MeToMeRewardType existingMeToMeRewardType = (MeToMeRewardType) currentSession()
				.load(MeToMeRewardType.class, meToMeRewardTypeId);
		return existingMeToMeRewardType;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean checkIfDuplicateMeToMeRewardTypeCode(
			String meToMeRewardTypeCode, Long meToMeRewardTypeId) {
		currentSession().beginTransaction();
		List<MeToMeRewardType> meToMeRewardType = (List<MeToMeRewardType>) currentSession()
				.createQuery(
						"from MeToMeRewardType meToMeRewardType "
								+ "where meToMeRewardType.rewardTypeId = :meToMeRewardTypeId and meToMeRewardType.rewardTypeCode = :meToMeGoalTypeCode")
				.setParameter("meToMeRewardTypeId", meToMeRewardTypeId)
				.setParameter("meToMeRewardTypeCode", meToMeRewardTypeCode)
				.list();
		if (meToMeRewardType.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean checkIfDuplicateMeToMeRewardTypeName(
			String meToMeRewardTypeName, Long meToMeRewardTypeId) {
		currentSession().beginTransaction();
		List<MeToMeRewardType> meToMeRewardType = (List<MeToMeRewardType>) currentSession()
				.createQuery(
						"from MeToMeRewardType meToMeRewardType "
								+ "where meToMeRewardType.rewardTypeId = :meToMeRewardTypeId and meToMeRewardType.rewardTypeName = :meToMeRewardTypeName")
				.setParameter("meToMeRewardTypeId", meToMeRewardTypeId)
				.setParameter("meToMeRewardTypeName", meToMeRewardTypeName)
				.list();
		if (meToMeRewardType.isEmpty()) {
			return false;
		} else {
			return true;
		}
	}
}