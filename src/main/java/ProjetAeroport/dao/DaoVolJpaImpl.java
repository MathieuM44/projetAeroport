package ProjetAeroport.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import ProjetAeroport.model.CompagnieAerienneVol;
import ProjetAeroport.model.Escale;
import ProjetAeroport.model.Vol;
import ProjetAeroport.util.Context;

class DaoVolJpaImpl implements DaoVol {

	@Override
	public void create(Vol obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();		// cr�e connexion, ouvre la factory puis cr�e l'entit�
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {		// v�rifie transaction ouverte et commit pass�
				tx.rollback();						// revient avant le commit
			}
		} finally {
			if(em != null && em.isOpen()) {			// v�rifie entit� cr��e et connexion ouverte
				em.close();							// ferme la connexion
			}
		}	
	}

	@Override
	public Vol findByKey(Long key) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Vol r = null;
		r = em.find(Vol.class, key);
		em.close();
		return r;
	}

	@Override
	public Vol update(Vol obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();		
		EntityTransaction tx = null;
		Vol r = new Vol();
		try {
			tx = em.getTransaction();
			tx.begin();
			r = em.merge(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {		
				tx.rollback();						
			}
		} finally {
			if(em != null && em.isOpen()) {			
				em.close();							
			}
		}
		return r;
	}

	@Override
	public void delete(Vol obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();		
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			obj = em.merge(obj);
			for(CompagnieAerienneVol cav : obj.getCompagnieAerienneVol()) {
				em.remove(cav);
			}
			for(Escale e : obj.getEscale()) {
				em.remove(e);
			}
			em.remove(obj);				// a besoin d'un objet rattach� � la base
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {		
				tx.rollback();						
			}
		} finally {
			if(em != null && em.isOpen()) {			
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
			em.remove(em.find(Vol.class , key));		// enleve la personne trouv�e par la cl� donn�e
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {		
				tx.rollback();						
			}
		} finally {
			if(em != null && em.isOpen()) {			
				em.close();							
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Vol> findAll() {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("from Vol r");		// soit p.nomAttribut soit p pour tout de la table + select p non oblig� si tout
		List<Vol> Vols = null;
		Vols = query.getResultList();
		em.close();
		return Vols;
	}

}
