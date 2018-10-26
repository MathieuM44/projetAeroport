package ProjetAeroport.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name = "Vol")
@SequenceGenerator(name = "seqVol", sequenceName = "seq_vols", initialValue = 1, allocationSize = 1)
public class Vol {

	@Id
	@Column(name = "id_vol", length = 10)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqVol")
	private Long id;
	
	@Column(name = "date_depart_vol")
	@Temporal(TemporalType.DATE)
	private Date dateDepart;
	
	@Column(name = "date_arrivee_vol")
	@Temporal(TemporalType.DATE)
	private Date dateArrivee;
	
	@Column(name = "heure_depart_vol")
	@Temporal(TemporalType.TIME)
	private Date heureDepart;
	
	@Column(name = "heure_arrivee_vol")
	@Temporal(TemporalType.TIME)
	private Date heureArrivee;
	
	@ManyToOne
	@JoinColumn(name = "aeroport_depart_id")
	private Aeroport aeroportDepart;
	
	@ManyToOne
	@JoinColumn(name = "aeroport_arrivee_id")
	private Aeroport aeroportArrivee;
	
	@OneToMany(mappedBy = "key.vol")		// erreur à ignorer si clé composée
	private List<CompagnieAerienneVol> compagnieAerienneVol;
	
	@OneToMany(mappedBy = "key.vol")		// erreur à ignorer si clé composée
	private List<Escale> escale;
	
	@Version
	private int version;
	
	public Vol() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Date getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public List<CompagnieAerienneVol> getCompagnieAerienneVol() {
		return compagnieAerienneVol;
	}

	public void setCompagnieAerienneVol(List<CompagnieAerienneVol> compagnieAerienneVol) {
		this.compagnieAerienneVol = compagnieAerienneVol;
	}

	public List<Escale> getEscale() {
		return escale;
	}

	public void setEscale(List<Escale> escale) {
		this.escale = escale;
	}

	public Aeroport getAeroportDepart() {
		return aeroportDepart;
	}

	public void setAeroportDepart(Aeroport aeroportDepart) {
		this.aeroportDepart = aeroportDepart;
	}

	public Aeroport getAeroportArrivee() {
		return aeroportArrivee;
	}

	public void setAeroportArrivee(Aeroport aeroportArrivee) {
		this.aeroportArrivee = aeroportArrivee;
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
		Vol other = (Vol) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
