package formation.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import formation.dao.FormationEMF;
import formation.dao.IDAOFormation;
import sopra.promo404.formation.model.Formation;
import sopra.promo404.formation.model.FormationId;

public class DAOFormationJPA implements IDAOFormation {
	
	public List<Formation> findAll() {
		List<Formation> liste = new ArrayList<>();
		
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try {
			em = FormationEMF.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			Query query = em.createQuery("from Formation", Formation.class);
			liste = query.getResultList();
			
			tx.commit(); 
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
		
		return liste;
	}

	
	public Formation findById(FormationId formationId) {
		Formation entity = null;
		
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try {
			em = FormationEMF.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			entity = em.find(Formation.class, formationId);
			
			tx.commit(); 
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
		
		return entity;
	}

	
	public Formation save(Formation entity) {
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try {
			em = FormationEMF.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			if(entity.getId() == null) {
				em.persist(entity);
			} else {
				entity = em.merge(entity);
			}
			
			tx.commit(); 
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
		
		return entity;
	}

	
	public void delete(Formation entity) {
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try {
			em = FormationEMF.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			em.remove(em.merge(entity));
			
			tx.commit(); 
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}

	
	public void deleteById(FormationId formationId) {
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try {
			em = FormationEMF.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			em.remove(em.find(Formation.class, formationId));
			
			tx.commit(); 
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();
			}
		} finally {
			if (em != null) {
				em.close();
			}
		}
	}


	

	
}
