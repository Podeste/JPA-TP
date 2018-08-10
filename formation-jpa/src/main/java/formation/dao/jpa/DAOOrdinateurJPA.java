package formation.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import formation.dao.FormationEMF;
import formation.dao.IDAOOrdinateur;
import sopra.promo404.formation.model.Ordinateur;

public class DAOOrdinateurJPA implements IDAOOrdinateur {
	
	@Override
	public List<Ordinateur> findAll() {
		List<Ordinateur> liste = new ArrayList<>();
		
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try {
			em = FormationEMF.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			Query query = em.createQuery("from Ordinateur", Ordinateur.class);
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
	public Ordinateur findById(Long id) {
		Ordinateur entity = null;
		
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try {
			em = FormationEMF.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			entity = em.find(Ordinateur.class, id);
			
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
	public Ordinateur save(Ordinateur entity) {
		EntityManager em = null;
		EntityTransaction tx = null;
		
		try {
			em = FormationEMF.getInstance().getEmf().createEntityManager();
			tx = em.getTransaction();
			tx.begin();
			
			if(entity.getCode() == null) {
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
	public void delete(Ordinateur entity) {
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
			
			em.remove(em.find(Ordinateur.class, id));
			
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

