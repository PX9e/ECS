import java.util.ArrayList;


public class AppCore {
	
	private AppCore(){}
	
	private static ArrayList<Restaurant> Restaurants = new ArrayList<Restaurant>();;
	private static ArrayList<Cuisine> Cuisines = new ArrayList<Cuisine>();
	
	
	public static ArrayList<Restaurant> getListeRestaurants() {
		return Restaurants;
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
