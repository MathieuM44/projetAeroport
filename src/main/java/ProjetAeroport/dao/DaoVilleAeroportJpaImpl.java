package ProjetAeroport.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import ProjetAeroport.model.VilleAeroport;
import ProjetAeroport.model.VilleAeroportKey;
import ProjetAeroport.util.Context;



public class DaoVilleAeroportJpaImpl implements DaoVilleAeroport {
	
	@Override
	public void create(VilleAeroport obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public VilleAeroport findByKey(VilleAeroportKey key) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		VilleAeroport f=null;
		f=em.find(VilleAeroport.class, key);
		em.close();
		return f;
	}

	@Override
	public VilleAeroport update(VilleAeroport obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.merge(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
		return obj;
	}

	@Override
	public void delete(VilleAeroport obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			obj=em.merge(obj);
			em.remove(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
	}

	@Override
	public void deleteByKey(VilleAeroportKey key) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.find(VilleAeroport.class, key));
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<VilleAeroport> findAll() {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("from VilleAeroport f"); 
		List<VilleAeroport> VilleAeroports=null;
		VilleAeroports=query.getResultList();
		em.close();
		return VilleAeroports;
	}
}

