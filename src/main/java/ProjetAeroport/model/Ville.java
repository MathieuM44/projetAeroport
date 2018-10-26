package ProjetAeroport.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

@Entity
@SequenceGenerator (name="seqVille",sequenceName="seq_ville", initialValue = 1 , allocationSize=1)
@NamedQuery(name = "Ville.findAllAeroport", 
	query = "select distinct v from Ville v left join fetch v.villeAeroports va left join fetch va.key.aeroport")
// attention jpql n'aime pas cette ecriture de requete multiple
public class Ville {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "seqVille")
	private Long Id;
	@Column(name="nom_city",length = 30)
	private String nom;
	
	@Version
	private int version;

	@OneToMany(mappedBy = "key.ville")		// erreur à ignorer si clé composée
	private List<VilleAeroport> villeAeroports;
	
	public Ville() {
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public List<VilleAeroport> getVilleAeroports() {
		return villeAeroports;
	}

	public void setVilleAeroports(List<VilleAeroport> villeAeroports) {
		this.villeAeroports = villeAeroports;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Id == null) ? 0 : Id.hashCode());
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
		Ville other = (Ville) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}	
}
