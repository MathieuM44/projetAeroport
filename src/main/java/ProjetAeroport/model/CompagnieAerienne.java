package ProjetAeroport.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "Compagnie_Aerienne")
@SequenceGenerator(name = "seqCompagnieAerienne", sequenceName = "seq_compagnies_aeriennes", initialValue = 1, allocationSize = 1)
@NamedQueries({
	@NamedQuery(name = "CA.findAllCompagnieAerienneVol" , 
			query = "select distinct ca from CompagnieAerienne ca left join fetch ca.compagnieAerienneVol"),
	@NamedQuery(name = "CA.findAllVol", 
			query = "select distinct ca from CompagnieAerienne ca left join fetch ca.compagnieAerienneVol cav left join fetch cav.key.vol")
})
public class CompagnieAerienne {

	@Id
	@Column(name = "id_compagnie_aerienne", length = 10)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCompagnieAerienne")
	private Long id;
	
	@Column(name = "nom_compagnie_aerienne", length = 50)
	private String nom;
	
	@OneToMany(mappedBy = "key.compagnieAerienne")		// erreur à ignorer si clé composée
	private List<CompagnieAerienneVol> compagnieAerienneVol;
	
	@Version
	private int version;
	
	public CompagnieAerienne() {
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

	public List<CompagnieAerienneVol> getCompagnieAerienneVol() {
		return compagnieAerienneVol;
	}

	public void setCompagnieAerienneVol(List<CompagnieAerienneVol> compagnieAerienneVol) {
		this.compagnieAerienneVol = compagnieAerienneVol;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
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
		CompagnieAerienne other = (CompagnieAerienne) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
