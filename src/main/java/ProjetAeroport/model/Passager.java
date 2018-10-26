package ProjetAeroport.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "passager")
@SequenceGenerator(name = "seqPassager", sequenceName = "pass_seq_id", initialValue = 50, allocationSize = 1)
public class Passager {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPassager")
	@Column(name = "id_passager")
	private Long id;
	@Column(name = "nom_passager", length = 100, nullable = false)
	private String nom;
	@Column(name = "prenom_passager", length = 100, nullable = false)
	private String prenom;
	@Version
	private int version;
	@Embedded
	private Adresse adresse;

	@OneToMany(mappedBy = "passager")
	private List<Reservation> reservations = new ArrayList<>();

	public Passager(Long id, String nom, String prenom, int version, Adresse adresse, List<Reservation> reservations) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.version = version;
		this.adresse = adresse;
		this.reservations = reservations;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Passager(long id, String nom, String prenom) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
	}

	public Passager(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}

	public Passager() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Passager other = (Passager) obj;
		if (id != other.id)
			return false;
		return true;
	}

}