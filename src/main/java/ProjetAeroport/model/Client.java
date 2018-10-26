package ProjetAeroport.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table (name = "client_projet_aeroport")
@NamedQuery(name = "Client.clientAvecReservation", query = "select c from Client c left join fetch c.reservations")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name="statut_juridique", discriminatorType = DiscriminatorType.STRING,length = 2)
@SequenceGenerator(name="seqClient", sequenceName="seq_client", initialValue = 1, allocationSize=1)
public abstract class Client {
	
	//Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqClient")
	@Column(name = "id_client", length = 10)
	private Long id;
	@Column(name = "nom_client", length = 100)
	private String nom;
	@Column(name = "numero_tel_client", length = 12)
	private Integer numeroTel;
	@Column(name = "numero_fax_client", length = 12)
	private Integer numeroFax;
	@Column(name = "email_client", length = 100)
	private String email;
	@Embedded
	private Adresse adresse;

	
	//joindre adresse
	
	//association
	
	@OneToOne
	private Login login;
	
	@OneToMany(mappedBy = "client")
	private List<Reservation> reservations = new ArrayList<>();
	
	//version
	@Version
	int version;
	
	public Client() {
		
	}

	public Client(String nom, Integer numeroTel, Integer numeroFax, String email) {
		this.nom = nom;
		this.numeroTel = numeroTel;
		this.numeroFax = numeroFax;
		this.email = email;
	}

	public Client(String nom) {
		this.nom = nom;
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

	public Integer getNumeroTel() {
		return numeroTel;
	}

	public void setNumeroTel(Integer numeroTel) {
		this.numeroTel = numeroTel;
	}

	public Integer getNumeroFax() {
		return numeroFax;
	}

	public void setNumeroFax(Integer numeroFax) {
		this.numeroFax = numeroFax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}
	

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	

	public List<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Client other = (Client) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
}
