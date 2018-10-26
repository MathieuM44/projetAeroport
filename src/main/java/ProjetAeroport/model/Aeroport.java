package ProjetAeroport.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.SequenceGenerator;
import javax.persistence.Version;

@Entity
@SequenceGenerator(name = "seqAeroport", sequenceName="seq_aeroport", initialValue=1, allocationSize=1)
public class Aeroport {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="seqAeroport")
	private Long Id;
	@Column(name="nom_aeroport",length=50) 
	private String nom;
	
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
