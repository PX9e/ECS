


public class Restaurant {
	
	/*Attributs*/
	
	private Cuisine cuisine;
	private Forfait forfait;
	private String nom = "Nouveau restaurant";
	
	
	public Cuisine getCuisine() {
		return cuisine;
	}
	public void setCuisine(Cuisine cuisine) {
		this.cuisine = cuisine;
	}
	public Forfait getForfait() {
		return forfait;
	}
	public void setForfait(Forfait forfait) {
		this.forfait = forfait;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	public float consommationPonctuelle(Heure heure)
	{
		float consommation = 0;
		for(int i=0; i<(cuisine.ObtenirAppareils(0).size()); i++)
		{
			consommation += cuisine.ObtenirAppareil(i).consommationPonctuelle(heure);
		}
		return consommation;
	}
	


}
