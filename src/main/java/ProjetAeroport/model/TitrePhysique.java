package ProjetAeroport.model;

public enum TitrePhysique {
	
	M("Monsieur"), MME("Madame"), MLLE("Mademoiselle");
	
	private String titre;
	
	TitrePhysique(String titre) {
		this.titre = titre;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

}
