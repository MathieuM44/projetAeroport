package ProjetAeroport.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import ProjetAeroport.model.Aeroport;
import ProjetAeroport.model.Escale;
import ProjetAeroport.model.Ville;
import ProjetAeroport.model.VilleAeroport;
import ProjetAeroport.model.Vol;
import ProjetAeroport.util.Context;


public class DaoAeroportJpaImpl implements DaoAeroport {
	
	@Override
	public void create(Aeroport obj) {
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
	public Aeroport findByKey(Long key) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Aeroport f=null;
		f=em.find(Aeroport.class, key);
		em.close();
		return f;
	}

	@Override
	public Aeroport update(Aeroport obj) {
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
	public void delete(Aeroport obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			obj=em.merge(obj);		
			for(Escale e : obj.getEscale()) {
				em.remove(e);
			}
			for(VilleAeroport va: obj.getVilleAeroports()) {
				em.remove(va);
			}
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
	public void deleteByKey(Long key) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.find(Aeroport.class, key));
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
	public List<Aeroport> findAll() {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("from Aeroport f"); 
		List<Aeroport> Aeroports=null;
		Aeroports=query.getResultList();
		em.close();
		return Aeroports;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Escale> findAllEscale() {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Query query = em.createNamedQuery("Aeroport.findAllEscale");
		List<Escale> escale = query.getResultList();
		em.close();
		return escale;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vol> findAllVols() {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Query query1 = em.createNamedQuery("Aeroport.findAllVolDepart");
		List<Vol> volDepart = query1.getResultList();
		Query query2 = em.createNamedQuery("Aeroport.findAllVolArrivee");
		List<Vol> volArrivee = query2.getResultList();
		em.close();
		List<Vol> vols = new ArrayList<>();
		vols.addAll(volDepart);
		vols.addAll(volArrivee);
		return vols;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ville> findAllVille() {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Query query = em.createNamedQuery("Aeroport.findAllVille");
		List<Ville> villes = query.getResultList();
		em.close();
		return villes;
	}
}

