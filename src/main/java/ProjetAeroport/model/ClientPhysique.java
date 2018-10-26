package ProjetAeroport.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CP")
public class ClientPhysique extends Client {
	
	private TitrePhysique titre;
	private String prenom;
	
	
	public ClientPhysique() {
		
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
