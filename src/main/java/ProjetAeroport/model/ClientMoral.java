package ProjetAeroport.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CM")
public class ClientMoral extends Client {
	
	private TitreMoral titre;
	private String siret;
	
	
	public ClientMoral() {

	}
	public ClientMoral(TitreMoral titre, String siret) {
		super();
		this.titre = titre;
		this.siret = siret;
	}
	public TitreMoral getTitre() {
		return titre;
	}
	public void setTitre(TitreMoral titre) {
		this.titre = titre;
	}
	public String getSiret() {
		return siret;
	}
	public void setSiret(String siret) {
		this.siret = siret;
	}
	
	
	
	
	

}
