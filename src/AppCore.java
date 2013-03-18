import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;

public class AppCore {
	
	private AppCore(){}
	
	private static ArrayList<Restaurant> Restaurants = new ArrayList<Restaurant>();;
	private static ArrayList<Cuisine> Cuisines = new ArrayList<Cuisine>();
	private static ArrayList<AppareilElectrique> AppareilsElectriques = new ArrayList<AppareilElectrique>();
	
	public static ArrayList<Restaurant> getListeRestaurants() {
		return Restaurants;
	}
	
	public static void OpenAppareilsElectrique()
	{
		try{
			  // Open the file that is the first 
			  // command line parameter
			  FileInputStream fstream = new FileInputStream("appareil.save");
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			   String strLine;
			  //Read File Line By Line
			  while ((strLine = br.readLine()) != null)   {
			  // Print the content on the console
			  System.out.println (strLine);
			  }
			  //Close the input stream
			  in.close();
			    }catch (Exception e){//Catch exception if any
			  System.err.println("Error: " + e.getMessage());
		   }
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
	}
	public static void SaveCuisine()
	{
		try {
			PrintWriter writer = new PrintWriter("cuisine.save");
			for(int i = 0 ; i < Cuisines.size(); i++)
			{
				writer.println("NewCuisine");
				writer.println("Name:"+Cuisines.get(i).getNom());
				writer.println("MesAppareils");
				
				for(int y = 0 ; y < Cuisines.get(i).ObtenirAppareils().size();y++)
				{
					writer.println(Cuisines.get(i).ObtenirAppareils().get(y).getNom());
				}
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static void SaveAppareilElectrique()
	{
		try {
			PrintWriter writer = new PrintWriter("appareil.save");
			for(int i = 0 ; i < AppareilsElectriques.size(); i++)
			{
				writer.println("NewAppareilElectrique");
				writer.println("Name:"+AppareilsElectriques.get(i).getNom());		
				writer.println("planAllumage:"+AppareilsElectriques.get(i).getPlanAllumage().getName());
				writer.println("consommationMax:"+AppareilsElectriques.get(i).getConsommationMax());
			}
			writer.close();
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
