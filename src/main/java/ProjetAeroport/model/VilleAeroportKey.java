package ProjetAeroport.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Embeddable
public class VilleAeroportKey implements Serializable{
	
	@ManyToOne
	@JoinColumn(name="ville_id")
	private Ville ville; 
	@ManyToOne
	@JoinColumn(name="aeroport_id")
	private Aeroport aeroport;
	
	public VilleAeroportKey() {
	}

	public VilleAeroportKey(Ville ville, Aeroport aeroport) {
		this.ville = ville;
		this.aeroport = aeroport;
	}

	public Ville getville() {
		return ville;
	}

	public void setville(Ville ville) {
		this.ville = ville;
	}

	public Aeroport getAeroport() {
		return aeroport;
	}

	public void setAeroport(Aeroport aeroport) {
		this.aeroport = aeroport;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aeroport == null) ? 0 : aeroport.hashCode());
		result = prime * result + ((ville == null) ? 0 : ville.hashCode());
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
		VilleAeroportKey other = (VilleAeroportKey) obj;
		if (aeroport == null) {
			if (other.aeroport != null)
				return false;
		} else if (!aeroport.equals(other.aeroport))
			return false;
		if (ville == null) {
			if (other.ville != null)
				return false;
		} else if (!ville.equals(other.ville))
			return false;
		return true;
	}	
}
