package ProjetAeroport.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import ProjetAeroport.model.CompagnieAerienneVol;
import ProjetAeroport.model.CompagnieAerienneVolKey;
import ProjetAeroport.util.Context;

class DaoCompagnieAerienneVolJpaImpl implements DaoCompagnieAerienneVol {

	@Override
	public void create(CompagnieAerienneVol obj) {
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
	public CompagnieAerienneVol findByKey(CompagnieAerienneVolKey key) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		CompagnieAerienneVol r = null;
		r = em.find(CompagnieAerienneVol.class, key);
		em.close();
		return r;
	}

	@Override
	public CompagnieAerienneVol update(CompagnieAerienneVol obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();		
		EntityTransaction tx = null;
		CompagnieAerienneVol r = new CompagnieAerienneVol();
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
	public void delete(CompagnieAerienneVol obj) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();		
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.merge(obj));				// a besoin d'un objet rattach� � la base
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
	public void deleteByKey(CompagnieAerienneVolKey key) {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();		
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.find(CompagnieAerienneVol.class , key));		// enleve la personne trouv�e par la cl� donn�e
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
	public List<CompagnieAerienneVol> findAll() {
		EntityManager em = Context.getInstance().getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("from CompagnieAerienneVol r");		// soit p.nomAttribut soit p pour tout de la table + select p non oblig� si tout
		List<CompagnieAerienneVol> compagnieAeriennesVol = null;
		compagnieAeriennesVol = query.getResultList();
		em.close();
		return compagnieAeriennesVol;
	}
}
