


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
	
	public float calculerConsommationJournaliere()
	{
		
		return 159;
	}
	

}
