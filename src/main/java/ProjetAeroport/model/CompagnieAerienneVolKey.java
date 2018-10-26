package ProjetAeroport.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Embeddable
public class CompagnieAerienneVolKey implements Serializable{

	@ManyToOne
	@JoinColumn(name = "vol_id")
	private Vol vol;
	
	@ManyToOne
	@JoinColumn(name = "compagnie_aerienne_id")
	private CompagnieAerienne compagnieAerienne;
	
	public CompagnieAerienneVolKey() {
	}
	
	public CompagnieAerienneVolKey(Vol vol, CompagnieAerienne compagnieAerienne) {
		this.vol = vol;
		this.compagnieAerienne = compagnieAerienne;
	}

	public Vol getVol() {
		return vol;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
	}

	public CompagnieAerienne getCompagnieAerienne() {
		return compagnieAerienne;
	}

	public void setCompagnieAerienne(CompagnieAerienne compagnieAerienne) {
		this.compagnieAerienne = compagnieAerienne;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((vol == null) ? 0 : vol.hashCode());
		result = prime * result + ((compagnieAerienne == null) ? 0 : compagnieAerienne.hashCode());
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
		CompagnieAerienneVolKey other = (CompagnieAerienneVolKey) obj;
		if (vol == null) {
			if (other.vol != null)
				return false;
		} else if (!vol.equals(other.vol))
			return false;
		if (compagnieAerienne == null) {
			if (other.compagnieAerienne != null)
				return false;
		} else if (!compagnieAerienne.equals(other.compagnieAerienne))
			return false;
		return true;
	}
	
}
