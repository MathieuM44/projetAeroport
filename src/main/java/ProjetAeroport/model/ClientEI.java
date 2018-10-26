package ProjetAeroport.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("EI")
public class ClientEI extends Client {
	
	private TitrePhysique titre;
	private String prenom;
	
	
	public ClientEI() {
		
	}
	
	
	public ClientEI(TitrePhysique titre, String prenom) {
		super();
		this.titre = titre;
		this.prenom = prenom;
	}


	public TitrePhysique getTitre() {
		return titre;
	}
	public void setTitre(TitrePhysique titre) {
		this.titre = titre;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	
	
}
