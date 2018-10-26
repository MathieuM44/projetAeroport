package ProjetAeroport.model;

public enum TitreMoral {

	SASU("Sasu"), EI("EI"), SA("SA"), SAS("SAS"), SARL("SARL"), SCI("SCI");

	private String titre;

	 TitreMoral(String titre) {
		this.titre = titre;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

}