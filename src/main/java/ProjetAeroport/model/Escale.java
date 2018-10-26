package ProjetAeroport.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Escale {
	
	@Column(name= "heure_depart_escale")
	@Temporal(TemporalType.TIME)
	private Date heureDepart;
	@Column(name= "heure_arrivee_escale")
	@Temporal(TemporalType.TIME)
	private Date heureArrivee;
	@EmbeddedId
	private EscaleKey key;
	
	
	public Escale() {
		super();
	}

	public Date getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(Date heureDepart) {
		this.heureDepart = heureDepart;
	}

	public Date getHeureArrivee() {
		return heureArrivee;
	}

	public void setHeureArrivee(Date heureArrivee) {
		this.heureArrivee = heureArrivee;
	}

	public EscaleKey getKey() {
		return key;
	}

	public void setKey(EscaleKey key) {
		this.key = key;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
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
		Escale other = (Escale) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}		
}
