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
		if(cuisine!=null)
		{
			this.cuisine = cuisine;
		}
		else
		{
			this.cuisine =new Cuisine();
		}
		forfait = new Forfait();
		nom = "Nouveau restaurant";
	}
	
	Restaurant(String nomRestaurant)
	{
		if(cuisine==null)
		{
			this.cuisine =new Cuisine();
		}
		forfait = new Forfait();
		nom = nomRestaurant;
	}
	
	Restaurant(Cuisine cuisine, String nomRestaurant)
	{
		if(cuisine!=null)
		{
			this.cuisine = cuisine;
		}
		else
		{
			this.cuisine =new Cuisine();
		}
		forfait = new Forfait();
		nom = nomRestaurant;
	}
	
	Restaurant(Cuisine cuisine, String nomRestaurant, Forfait forfait)
	{
		if(cuisine!=null)
		{
			this.cuisine = cuisine;
		}
		else
		{
			this.cuisine =new Cuisine();
		}
		if(forfait != null){
		this.forfait = forfait;
		}
		else
		{
			this.forfait = new Forfait();
		}
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
	
	/*public Restaurant getRestaurantFromName(String nom)
	{
		
	}*/
	
	@Override
	public String toString()
	{
		return nom;
	}
	
}
