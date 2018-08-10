package formation.dao;


import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;



public class Formation {
	private static Formation instance = null;

	private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("eshop");

	private Formation() {

	}

	public static Formation getInstance() {
		if (instance == null) {
			instance = new Formation();
		}

		return instance;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

}


