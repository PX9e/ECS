public class Restaurant {
	
	/*Attributs*/
	
	private Cuisine cuisine;
	private Forfait forfait;
	private String nom;
	
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
	
	Restaurant()
	{
		cuisine = new Cuisine();
		forfait = new Forfait();
		nom = "Nouveau restaurant";
	}
	
	Restaurant(Cuisine cuisine)
	{
		this.cuisine = cuisine;
		forfait = new Forfait();
		nom = "Nouveau restaurant";
	}
	
	Restaurant(String nomRestaurant)
	{
		this.cuisine = new Cuisine();
		forfait = new Forfait();
		nom = nomRestaurant;
	}
	
	Restaurant(Cuisine cuisine, String nomRestaurant)
	{
		this.cuisine = cuisine;
		forfait = new Forfait();
		nom = nomRestaurant;
	}
	
	Restaurant(Cuisine cuisine, String nomRestaurant, Forfait forfait)
	{
		this.cuisine = cuisine;
		this.forfait = forfait;
		nom = nomRestaurant;
	}
	
	
	public float consommationPonctuelle(Heure heure)
	{
		float consommation = 0;
		for(int i=0; i<(cuisine.ObtenirAppareils().size()); i++)
		{
			consommation += cuisine.ObtenirAppareil(i).consommationPonctuelle(heure);
		}
		return consommation;
	}
	


}
