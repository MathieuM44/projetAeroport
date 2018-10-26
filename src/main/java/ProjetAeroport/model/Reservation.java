package ProjetAeroport.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import antlr.collections.List;

@Entity
@Table(name = "Reservation")
@SequenceGenerator(name = "seqReservation", sequenceName = "Reser_seq_id", initialValue = 1000, allocationSize = 1)

public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqReservation")
	@Column(name = "id_reservation")
	private Long Id;
	@Temporal(TemporalType.DATE)
	@Column(name = "date_reservation", length = 400, nullable = false)
	private Date date;
	@Column(name = "numero_reservation", length = 400, nullable = false)
	private Integer numero;
	
	@Version
	@Column(name = "version_reservation")
	private int version;
	
	@OneToMany(mappedBy="Reservation")
	private Set<Passager> passagers = new HashSet(); 
	

	public Reservation() {
		
	}
	
	public Reservation(Date date, Integer numero) {
		super();
		this.date = date;
		this.numero = numero;
	}
	
	public Reservation(Integer numero) {
		super();
		this.numero = numero;
	}
	public Reservation(Long id, Date date, Integer numero) {
		super();
		Id = id;
		this.date = date;
		this.numero = numero;
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
		Reservation other = (Reservation) obj;
		if (Id == null) {
			if (other.Id != null)
				return false;
		} else if (!Id.equals(other.Id))
			return false;
		return true;
	}
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	

}
