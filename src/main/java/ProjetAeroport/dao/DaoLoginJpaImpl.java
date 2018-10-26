package ProjetAeroport.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import ProjetAeroport.model.Login;
import ProjetAeroport.util.Context;

public class DaoLoginJpaImpl implements DaoLogin {

	@Override
	public void create(Login obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
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
	public Login findByKey(Long Key) {

		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Login a = null;
		a= em.find(Login.class, Key);
		em.close();
		return a;
	}

	@Override
	public Login update(Login obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		Login a = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			a = em.merge(obj);
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
		return a;
	}

	
	public void delete(Login obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			obj = em.merge(obj);
			if(obj.getClient()!=null) {
				obj.getClient().setLogin(null);;
			}
			em.remove(em.merge(obj));
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

	
	public void deleteByKey(Long Key) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			Login obj = em.find(Login.class,Key);
			if(obj.getClient()!=null) {
				obj.getClient().setLogin(null);
			}
			em.remove(em.find(Login.class, Key));
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
	public List<Login> findAll() {
		List<Login> logins = null;
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("from login_projet_aeroport");
		logins = query.getResultList();
		em.close();
		return logins;
	}

}
