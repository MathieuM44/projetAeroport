package ProjetAeroport.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

@Entity
@SequenceGenerator(name = "seqAeroport", sequenceName="seq_aeroport", initialValue=1, allocationSize=1)
@NamedQueries({
	@NamedQuery(name = "Aeroport.findAllEscale", 
			query = "select distinct a from Aeroport a left join fetch a.escale"),
	@NamedQuery(name = "Aeroport.findAllVolDepart", 
			query = "select distinct a from Aeroport a left join fetch a.volsDepart"),
	@NamedQuery(name = "Aeroport.findAllVolArrivee", 
			query = "select distinct a from Aeroport a left join fetch a.volsArrivee"),
	@NamedQuery(name = "Aeroport.findAllVille", 
			query = "select distinct a from Aeroport a left join fetch a.villeAeroports va left join fetch va.key.ville")
})
public class Aeroport {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqAeroport")
	private Long Id;
	@Column(name="nom_aeroport",length=50) 
	private String nom;
	
	@OneToMany(mappedBy = "aeroportDepart")
	private List<Vol> volsDepart;
	
	@OneToMany(mappedBy = "aeroportArrivee")
	private Set<Vol> volsArrivee;
	
	@OneToMany(mappedBy = "key.aeroport")		// erreur à ignorer si clé composée
	private Set<Escale> escale;
	
	@OneToMany(mappedBy = "key.aeroport")		// erreur à ignorer si clé composée
	private Set<VilleAeroport> villeAeroports;
	
	@Version
	private int version;
	
	public Aeroport() {
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

	public List<Vol> getVolsDepart() {
		return volsDepart;
	}

	public void setVolsDepart(List<Vol> volsDepart) {
		this.volsDepart = volsDepart;
	}

	public Set<Vol> getVolsArrivee() {
		return volsArrivee;
	}

	public void setVolsArrivee(Set<Vol> volsArrivee) {
		this.volsArrivee = volsArrivee;
	}

	public Set<Escale> getEscale() {
		return escale;
	}

	public void setEscale(Set<Escale> escale) {
		this.escale = escale;
	}

	public Set<VilleAeroport> getVilleAeroports() {
		return villeAeroports;
	}

	public void setVilleAeroports(Set<VilleAeroport> villeAeroports) {
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
		Aeroport other = (Aeroport) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}	
}
