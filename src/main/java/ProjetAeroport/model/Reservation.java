package ProjetAeroport.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

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

	// Association

	@ManyToOne
	@JoinColumn(name = "id_passager")
	private Passager passager;

	@ManyToOne
	@JoinColumn(name = "reservation_vol")
	private Vol vol;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

	public Long getId() {
		return Id;
	}

	public Reservation(Date date, Integer numero) {
		super();

		this.date = date;
		this.numero = numero;

	}

	public Reservation() {

	}

	public Reservation(Long id, Date date, Integer numero, int version, Passager passager, Client client) {
		super();
		Id = id;
		this.date = date;
		this.numero = numero;
		this.version = version;
		this.passager = passager;
		this.client = client;
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

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Client getClient() {
		return client;
	}

	public Passager getPassager() {
		return passager;
	}

	public void setPassager(Passager passager) {
		this.passager = passager;
	}

	public void setClient(Client client) {
		this.client = client;
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

}
