package sopra.promo404.formation.model;

import java.util.Date;

public class Eleve extends Personne {
	private Civilite civilite;
	private Date dtNaissance;
	private Formateur formateur;
	private Ordinateur ordinateur;

	public Eleve() {
		super();
	}

	public Eleve(Civilite civilite, String nom, String prenom, Date dtNaissance) {
		super(nom, prenom);
		this.civilite = civilite;
		this.dtNaissance = dtNaissance;
	}

	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	public Date getDtNaissance() {
		return dtNaissance;
	}

	public void setDtNaissance(Date dtNaissance) {
		this.dtNaissance = dtNaissance;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}

	public Ordinateur getOrdinateur() {
		return ordinateur;
	}

	public void setOrdinateur(Ordinateur ordinateur) {
		this.ordinateur = ordinateur;
	}

}
