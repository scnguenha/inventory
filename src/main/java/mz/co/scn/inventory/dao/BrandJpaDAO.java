
package mz.co.scn.inventory.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import mz.co.scn.inventory.model.brand.Brand;

/**
 *
 * @author Sidónio Goenha on Aug 27, 2020
 *
 */
public class BrandJpaDAO {

	private static BrandJpaDAO instance;
	protected EntityManager entityManager;

	public static BrandJpaDAO getInstance() {
		if (instance == null) {
			instance = new BrandJpaDAO();
		}

		return instance;
	}

	private BrandJpaDAO() {
		entityManager = getEntityManager();
	}

	private EntityManager getEntityManager() {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("inventory");
		if (entityManager == null) {
			entityManager = factory.createEntityManager();
		}

		return entityManager;
	}

	public Brand getById(final int id) {
		return entityManager.find(Brand.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<Brand> findAll() {
		return entityManager.createQuery("FROM " + Brand.class.getName()).getResultList();
	}

	public void persist(Brand brand) {
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(brand);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void merge(Brand brand) {
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(brand);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void remove(Brand brand) {
		try {
			entityManager.getTransaction().begin();
			brand = entityManager.find(Brand.class, brand.getId());
			entityManager.remove(brand);
			entityManager.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			entityManager.getTransaction().rollback();
		}
	}

	public void removeById(final int id) {
		try {
			Brand brand = getById(id);
			remove(brand);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
