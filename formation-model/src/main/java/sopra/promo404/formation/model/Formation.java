package sopra.promo404.formation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "formation")
public class Formation {
	@EmbeddedId
	private FormationId id;
	
	@Column(name="Duree")
	private int duree;
	
	@ManyToMany
	@JoinTable(name="formation_matière",
			   joinColumns = {
				   @JoinColumn(name = "client"),
				   @JoinColumn(name = "promotion")
				   },
			   inverseJoinColumns =@JoinColumn(name = "matiere_id") ,
			   uniqueConstraints = @UniqueConstraint(columnNames = {"client","promotion","matiere_id"}))
	private List<Matiere> matieres = new ArrayList<>();

	public Formation() {
		super();
	}

	public Formation(String client, String promotion) {
		super();
		this.id = new FormationId(client, promotion);
	}

	public FormationId getId() {
		return id;
	}

	public void setId(FormationId id) {
		this.id = id;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public List<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}

}
