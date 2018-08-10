package formation.dao;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class FormationEMF {
	private static FormationEMF instance = null;

	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("formation");

	private FormationEMF() {

	}

	public static FormationEMF getInstance() {
		if (instance == null) {
			instance = new FormationEMF();
		}

		return instance;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

}


