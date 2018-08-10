package formation.test;


import formation.dao.jpa.DAOFormationJPA;
import formation.dao.jpa.DAOMatiereJPA;
import sopra.promo404.formation.model.Difficulte;
import sopra.promo404.formation.model.Formation;
import sopra.promo404.formation.model.FormationId;
import sopra.promo404.formation.model.Matiere;
import java.util.ArrayList;
import formation.dao.IDAOFormation;
import formation.dao.IDAOMatiere;

public class TestDaoFormation {

	public static void main(String[] args) {
		
        IDAOFormation daoFormation = new DAOFormationJPA();
		
		Formation form1 = new Formation();
		FormationId id1 = new FormationId();
		id1.setClient("Sopra");
		id1.setPromotion("404");
		form1.setDuree(3);
		form1.setId(id1);
		
		Formation form2 = new Formation();
		FormationId id2 = new FormationId();
		id2.setClient("Steria");
		id2.setPromotion("La Mexicaine");
		form2.setDuree(5);
		form2.setId(id2);
		
		
		
		IDAOMatiere daoMatiere = new DAOMatiereJPA();
		
		Matiere Math = new Matiere();
		Math.setNom("Mathématiques");
		Math.setDifficulte(Difficulte.IMPOSSIBLE);
		Math.setDuree(3);
		
		Matiere Info = new Matiere();
		Info.setNom("Informatique");
		Info.setDifficulte(Difficulte.MOYEN);
		Info.setDuree(1);
		
		Matiere Geol = new Matiere();
		Geol.setNom("Géologie");
		Geol.setDifficulte(Difficulte.FACILE);
		Geol.setDuree(4);
		
		form1.setMatieres(new ArrayList<Matiere>());
		form1.getMatieres().add(Math);
		form2.setMatieres(new ArrayList<Matiere>());
		form2.getMatieres().add(Info);
		form2.getMatieres().add(Geol);
		
		
		
		daoMatiere.save(Math);
		daoMatiere.save(Info);
		daoMatiere.save(Geol);
		daoFormation.save(form1);
		daoFormation.save(form2);
	}

}
