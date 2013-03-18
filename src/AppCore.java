import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;

public class AppCore {
	
	private AppCore(){}
	
	private static ArrayList<Restaurant> Restaurants = new ArrayList<Restaurant>();;
	private static ArrayList<Cuisine> Cuisines = new ArrayList<Cuisine>();
	private static ArrayList<AppareilElectrique> AppareilsElectriques = new ArrayList<AppareilElectrique>();
	
	public static ArrayList<Restaurant> getListeRestaurants() {
		return Restaurants;
	}
	
	
	
	public static void SaveRestaurant()
	{
		try {
			PrintWriter writer = new PrintWriter("restaurant.save");
			
			for(int i = 0 ; i < Restaurants.size(); i++)
			{
				writer.println("NewRestaurant");
				writer.println("Name:"+Restaurants.get(i).getNom());
				writer.println("Cuisine:"+Restaurants.get(i).getCuisine().getNom());
				writer.println("Forfait:"+Restaurants.get(i).getForfait().getName());
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		}
		
		public static void LoadRestaurant()
		{
			try {
				FileReader reader = new FileReader("restaurant.save");
				reader.read
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				
			}	
		
		
	}
	
	public static void AjouterRestaurantToList(Restaurant MonRestaurant) {
		Restaurants.add(MonRestaurant);
	}
	
	public static void RetirerRestaurantFromList(Restaurant MonRestaurant) {
		Restaurants.remove(MonRestaurant);
	}
	
	public static ArrayList<Cuisine> getListeCuisines() {
		return Cuisines;
	}
	
	public static void AjouterCuisineToList(Cuisine MaCuisine) {
		Cuisines.add(MaCuisine);
	}
	
	public static void RetirerCuisineFromList(Cuisine MaCuisine) {
		Cuisines.remove(MaCuisine);
	}

	/**
	 * Penser a gérer les exceptions (si return null)
	 * @param Name
	 * @return
	 */
	public static Restaurant getRestaurantFromName(String Name)
	{
		for(int i=0; i < Restaurants.size(); i++)
		{
			if(Restaurants.get(i).getNom().compareTo(Name) == 0)
				{
				return Restaurants.get(i);
				}
		}
		return null;
	}
	
	/**
	 * Penser a gérer les exceptions (si return null)
	 * @param Name
	 * @return
	 */
	public static Cuisine getCuisineFromName(String Name)
	{
		for(int i=0; i < Cuisines.size(); i++)
		{
			if(Cuisines.get(i).getNom().compareTo(Name) == 0)
				{
				return Cuisines.get(i);
				}
		}
		return null;
	}
	
}
