import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;

public class AppCore {
	
	private AppCore(){}
	
	private static ArrayList<Restaurant> Restaurants = new ArrayList<Restaurant>();;
	private static ArrayList<Cuisine> Cuisines = new ArrayList<Cuisine>();
	private static ArrayList<AppareilElectrique> AppareilsElectriques = new ArrayList<AppareilElectrique>();
	private static ArrayList<Forfait> Forfaits = new ArrayList<Forfait>();
	
	public static ArrayList<Restaurant> getListeRestaurants() {
		return Restaurants;
	}
	
	
	
	public static void SaveRestaurant()
	{
		System.out.println("Sauvegarde Restaurant");
		try {
			PrintWriter writer = new PrintWriter("restaurant.save");
			
			for(int i = 0 ; i < Restaurants.size(); i++)
			{
				writer.println("NewRestaurant");
				writer.println("Name:"+Restaurants.get(i).getNom());
				writer.println("Cuisine:"+Restaurants.get(i).getCuisine().getNom());
				writer.println("Forfait:"+Restaurants.get(i).getForfait().getNom());
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		}
	}
	public static void SaveCuisine()
	{
		System.out.println("Sauvegarde Cuisine");
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
		System.out.println("Sauvegarde AppareilElectrique");
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
	
	public static void LoadAppareilElectrique()
	{
		System.out.println("Chargement AppareilElectrique");
		String myfile = readdatafromtextfile("appareil.save");
		String[] MyAppareils = myfile.split("NewAppareilEletrique");
		String[] MyParameters;
		for(int i=0;i<MyAppareils.length;i++)
		{
			MyParameters = MyAppareils[i].split("\n");
			AppareilsElectriques.add(new AppareilElectrique(MyParameters[1].substring(5),Float.parseFloat(MyParameters[2].substring(13)),null));
			
			
		}
	}
	
	public static void LoadRestaurant()
	{
		System.out.println("Chargement Restaurant");
		String myfile = readdatafromtextfile("restaurant.save");
		String[] MyAppareils = myfile.split("NewRestaurant");
		String[] MyParameters;
		for(int i=0;i<MyAppareils.length;i++)
		{
			try{
			
			MyParameters = MyAppareils[i].split("\n");
			System.out.println(MyParameters[2].substring(8).toString());
			System.out.println(MyParameters[1].substring(5).toString());
			System.out.println(MyParameters[3].substring(8).toString());
			Restaurants.add(new Restaurant(getCuisineFromName(MyParameters[2].substring(8)), MyParameters[1].substring(5), getForfaitFromName(MyParameters[3].substring(8))));
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	

	public static void LoadCuisine()
	{
		System.out.println("Chargement Cuisine");
		String myfile = readdatafromtextfile("cuisine.save");
		String[] MyAppareils = myfile.split("NewCuisine");
		String[] MyParameters;
		System.out.println(MyAppareils.length);
		for(int i=0;i<MyAppareils.length;i++)
		{
			System.out.println(i +" eme cuisine");
			System.out.println(MyAppareils[i]);
			try{
			MyParameters = MyAppareils[i].split("MesAppareils");
			System.out.println(MyParameters[0]);
			System.out.println(MyParameters[1]);
			System.out.println(MyParameters[2]);
			Cuisines.add(new Cuisine(MyParameters[2].substring(8).toString()));
		
			}
			catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		}
	}
	
	
	public static String readdatafromtextfile(String filename)
	{
		BufferedReader br = null;
		String everything = "";
	    try {
	    	
			br = new BufferedReader(new FileReader(filename));
			
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        everything = sb.toString();
	    	} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
	    } finally {
	        try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	    }
	    return everything;
	}
	
		
	public static ArrayList<AppareilElectrique> getListeAppareilsElectriques() {
		return AppareilsElectriques;
	}
	
	public static void AjouterRestaurantToList(Restaurant MonRestaurant) {
		
		Restaurants.add(MonRestaurant);
<<<<<<< HEAD
		
		SaveRestaurant();	
		
=======
>>>>>>> 379487cb532e346a34451f555048d9737f94c8f3
	}
	
	public static void RetirerRestaurantFromList(Restaurant MonRestaurant) {
		Restaurants.remove(MonRestaurant);
	}
	
	public static ArrayList<Cuisine> getListeCuisines() {
		return Cuisines;
	}
	
	public static void AjouterCuisineToList(Cuisine MaCuisine) {
		Cuisines.add(MaCuisine);
		SaveCuisine();
	}
	
	public static void RetirerCuisineFromList(Cuisine MaCuisine) {
		Cuisines.remove(MaCuisine);
	}
	
	public static void AjouterAppareilToList(AppareilElectrique MonAppareil) {
		AppareilsElectriques.add(MonAppareil);
	}
	
	public static void RetirerAppareilFromList(Cuisine MonAppareil) {
		AppareilsElectriques.remove(MonAppareil);
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
	
	
	public static Forfait getForfaitFromName(String Name)
	{
		for(int i=0; i < Forfaits.size(); i++)
		{
			if(Forfaits.get(i).getNom().compareTo(Name) == 0)
				{
				return Forfaits.get(i);
				}
		}
		return null;
	}
	
	/**
	 * Penser a gérer les exceptions (si return null)
	 * @param Name
	 * @return
	 */
	public static AppareilElectrique getAppareilFromName(String Name)
	{
		for(int i=0; i < AppareilsElectriques.size(); i++)
		{
			if(AppareilsElectriques.get(i).getNom().compareTo(Name) == 0)
				{
				return AppareilsElectriques.get(i);
				}
		}
		return null;
	}
	
}
