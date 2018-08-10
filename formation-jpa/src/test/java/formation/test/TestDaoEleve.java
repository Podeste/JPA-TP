package formation.test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import eshop.dao.IDAOEleve;
import formation.dao.jpa.DAOEleveJPA;
import sopra.promo404.formation.model.Eleve;
import formation.dao.IDAOEleve;
public class TestDaoEleve {

	public static void main(String[] args) {
		DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        IDAOEleve daoEleve = new DAOEleveJPA();
		
		
	  
		Date anniversairejeanpierre=null;
		try
		{
			anniversairejeanpierre= df.parse("12-03-2002");
		} catch (ParseException e){
			e.printstacktrace();
		}// new ou transient
		
		Eleve jeanpierre = new Eleve("cluclu", "JeanPierre", "M", anniversairejeanpierre) 
		daoEleve.save(jeanpierre); // managed
		
		Eleve juju = daoEleve.findById(1L);
		
		
		daoEleve.delete(jeanpierre);
		
	}

}
