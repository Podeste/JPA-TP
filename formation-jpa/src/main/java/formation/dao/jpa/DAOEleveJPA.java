package formation.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;


import formation.dao.FormationEMF;
import formation.dao.IDAOEleve;
import sopra.promo404.formation.model.Eleve;

public class DAOEleveJPA implements IDAOEleve {

	@Override
	public List<Eleve> findAll() {
		List<Eleve> liste = new ArrayList<>();
		
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try {
			em = FormationEMF.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			Query query = em.createQuery("from Eleve", Eleve.class);
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

	@Override
	public Eleve findById(Long id) {
		Eleve entity = null;
		
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try {
			em = FormationEMF.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			entity = em.find(Eleve.class, id);
			
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

	@Override
	public Eleve save(Eleve entity) {
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

	@Override
	public void delete(Eleve entity) {
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

	@Override
	public void deleteById(Long id) {
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try {
			em = FormationEMF.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			em.remove(em.find(Eleve.class, id));
			
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

