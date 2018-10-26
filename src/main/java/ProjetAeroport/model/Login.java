package ProjetAeroport.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "login_projet_aeroport")
@SequenceGenerator(name="seqLogin", sequenceName="seq_login", initialValue = 1, allocationSize=1)
public class Login {
	
	//Attributs
	@Id
	@Column(name = "id_login", length = 12)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqLogin")
	private Long id;
	@Column(name = "login_login", length = 100)
	private String login;
	@Column(name = "mot_de_passe_login", length = 100)
	private String motDePasse;
	@Column(name = "admin_login", length = 4)
	private Boolean admin;
	
	//Association
	@OneToOne(mappedBy = "login")
	private Client client;
	
	//Version
	@Version
	int version;
	
	public Login() {
	}

	public Login(String login) {
		this.login = login;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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
		Login other = (Login) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
