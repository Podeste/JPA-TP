package sopra.promo404.formation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Table;


@Entity
@Table(name = "matiere")
public class Matiere {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "duree")
	private int duree;
	
	@Column(name = "difficulte")
	private Difficulte difficulte;
	
	
	private List<Formateur> formateurs = new ArrayList<>();

	public Matiere() {
		super();
	}

	public Matiere(Long id, String nom, int duree, Difficulte difficulte) {
		super();
		this.id = id;
		this.nom = nom;
		this.duree = duree;
		this.difficulte = difficulte;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public Difficulte getDifficulte() {
		return difficulte;
	}

	public void setDifficulte(Difficulte difficulte) {
		this.difficulte = difficulte;
	}

	public List<Formateur> getFormateurs() {
		return formateurs;
	}

	public void setFormateurs(List<Formateur> formateurs) {
		this.formateurs = formateurs;
	}

}
