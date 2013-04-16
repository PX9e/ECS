
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class AppCore  {
	
	private AppCore(){}
	
	
	private static Forfait THEFORFAIT;
	private static ArrayList<Restaurant> Restaurants = new ArrayList<Restaurant>();;
	private static ArrayList<Cuisine> Cuisines = new ArrayList<Cuisine>();
	private static ArrayList<AppareilElectrique> AppareilsElectriques = new ArrayList<AppareilElectrique>();
	private static ArrayList<Forfait> Forfaits = new ArrayList<Forfait>();
	private static ArrayList<PlanAllumage> PlanAllumages = new ArrayList<PlanAllumage>();
	 
	
	private static void SaveForfait() {
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("forfait.save");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
			writer.println(THEFORFAIT.getName());
			writer.println(THEFORFAIT.getCreuseH().getDebut().getHeures());
			writer.println(THEFORFAIT.getCreuseH().getDebut().getMinutes());
			writer.println(THEFORFAIT.getCreuseH().getFin().getHeures());
			writer.println(THEFORFAIT.getCreuseH().getFin().getMinutes());
			writer.println(THEFORFAIT.getPleineH().getDebut().getHeures());
			writer.println(THEFORFAIT.getPleineH().getDebut().getMinutes());
			writer.println(THEFORFAIT.getPleineH().getFin().getHeures());
			writer.println(THEFORFAIT.getPleineH().getFin().getMinutes());
			
			writer.println(THEFORFAIT.getCreuse());
			writer.println(THEFORFAIT.getPleine());
			writer.println(THEFORFAIT.getPic());
			
			
			writer.close();

		}
		static public void  LoadForfait()
		 {
			String myfile = readdatafromtextfile("forfait.save");
			String[] MyLines = myfile.split("\n");
			System.out.println(MyLines[0]);

			//try{
			THEFORFAIT =  new Forfait(MyLines[0], Double.parseDouble(MyLines[10]), Double.parseDouble(MyLines[9]),  new PlageHoraire(Integer.parseInt(MyLines[5]),Integer.parseInt(MyLines[6]),Integer.parseInt(MyLines[7]),Integer.parseInt(MyLines[8])),new PlageHoraire(Integer.parseInt(MyLines[1]), Integer.parseInt(MyLines[2]), Integer.parseInt(MyLines[3]), Integer.parseInt(MyLines[4])), Double.parseDouble(MyLines[11]));
		 
			//}
			//catch(Exception E)
			//{
			// THEFORFAIT = 	null;
			//}
		 }
	
	public static ArrayList<Restaurant> getListeRestaurants() {
		return Restaurants;
	}
	
	public static void SaveRestaurant()
	{
		////System.out.println("Sauvegarde Restaurant");
			PrintWriter writer = null;
			try {
				writer = new PrintWriter("restaurant.save");
			} catch (FileNotFoundException e) {

				
			}
			
			for(int i = 0 ; i < Restaurants.size(); i++)
			{
				writer.println("NewRestaurant");
				writer.println("Name:"+Restaurants.get(i).getNom().trim());
				writer.println("Cuisine:"+Restaurants.get(i).getCuisine().getNom().trim());
				writer.println("Forfait:"+Restaurants.get(i).getForfait().getNom().trim());
			}
			writer.close();	
	}
	public static void SaveCuisine()
	{
		////System.out.println("Sauvegarde Cuisine");
		PrintWriter writer = null;
		try {
			writer = new PrintWriter("cuisine.save");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
			for(int i = 0 ; i < Cuisines.size(); i++)
			{
				writer.println("NewCuisine");
				writer.println("Name:"+Cuisines.get(i).getNom().trim());
				writer.println("MesAppareils");
				for(int y = 0 ; y < Cuisines.get(i).ObtenirAppareils().size();y++)
				{
					writer.println(Cuisines.get(i).ObtenirAppareils().get(y).getNom().trim());
				}
			}
			writer.close();
	}
	
	public static void SaveAppareilElectrique()
	{
		////System.out.println("Sauvegarde AppareilElectrique");
		PrintWriter writer =null;
			 try {
				writer= new PrintWriter("appareil.save");
			} catch (FileNotFoundException e) {
			
			}
			for(int i = 0 ; i < AppareilsElectriques.size(); i++)
			{
				writer.println("NewAppareilElectrique");
				writer.println("Name:"+AppareilsElectriques.get(i).getNom().trim());		
				
				
				for(int z = 0 ; z < AppareilsElectriques.get(i).getModes().size();z++)
				{
					writer.println("Mode:"+AppareilsElectriques.get(i).getModes().get(z).getName());
				
					writer.println("Up");
					for(int u=0;u<AppareilsElectriques.get(i).getModes().get(z).getUp().size();u++)
					{
						writer.println(AppareilsElectriques.get(i).getModes().get(z).getUp().get(u).toString());
					}
					writer.println("Down");
					for(int u=0;u<AppareilsElectriques.get(i).getModes().get(z).getDown().size();u++)
					{
						writer.println(AppareilsElectriques.get(i).getModes().get(z).getDown().get(u).toString());
					}
				}
				writer.println("Coup:");
				for(int z = 0 ; z < AppareilsElectriques.get(i).getCouples().size();z++)
				{
					writer.println(AppareilsElectriques.get(i).getCouples().get(z).toString());

				}
			}
			writer.close();
	}
	
	public static void LoadAppareilElectrique()
	{
		AppareilsElectriques.clear();
		////System.out.println("Chargement AppareilElectrique");
		String myfile = readdatafromtextfile("appareil.save");
		String[] MyAppareils = myfile.split("NewAppareilElectrique");
		String[] MyParameters;
	
		String StateA ="";
		String State = "";
		Mode MyMode=null;
		AppareilElectrique MonAppareil=null;
		for(int i=0;i<MyAppareils.length;i++)
		{
			StateA="";
			State="";
			MonAppareil = new AppareilElectrique("");
			//System.out.println(MyAppareils[i]);
			MyParameters = MyAppareils[i].split("\n");
			MyMode = null;
			for(int z = 0 ; z < MyParameters.length;z++)
			{
				if(MyParameters[z].trim().startsWith("Name:"))
				{
					MonAppareil.setNom(MyParameters[z].substring(5));
				}
				else if(MyParameters[z].trim().startsWith("Mode:"))
				{
					if(MyMode!=null)
					{
						MonAppareil.AddModes(MyMode);
					}
					MyMode = new Mode(MyParameters[z].substring(5).toString());
					StateA = "Mode";
				}
				else if(MyParameters[z].trim().startsWith("Down"))
				{
					State="Down";
				}
				else if(MyParameters[z].trim().startsWith("Up"))
				{
					State="Up";
				}
				else if(MyParameters[z].trim().startsWith("Coup:"))
				{
					StateA = "Coup";
				}
				else
				{
					if(StateA=="Mode"){
						if(State=="Up")
						{
							try
							{
							MyMode.AddUp(Double.parseDouble(MyParameters[z].trim()));
							}
							catch(Exception E)
							{
								
							}
						}
						if(State=="Down")
						{
							//System.out.println("d" + MyParameters[z].trim());
							try
							{
							MyMode.AddDown(Double.parseDouble(MyParameters[z].trim()));
							}
							catch(Exception E)
							{
								
							}
						}
					}
					if(StateA=="Plan")
					{
						MonAppareil.getPlanAllumage().add(AppCore.getPlanAllumage(MyParameters[z].trim()));
					}
					if(StateA=="Coup")
					{
						if(MyParameters[z]!="")
						{
							try
							{
								//System.out.println("Start");
								MonAppareil.getCouples().add(MyParameters[z].trim());

								//System.out.println("End");
							}
							catch(Exception E)
							{
								
							}
							
						}
					}
				}
			}
			if(MyMode!=null)
			{
				MonAppareil.AddModes(MyMode);
			}
			
			if(MonAppareil.getNom()!="")
			{
				AppareilsElectriques.add(MonAppareil);
			}
		
		}
		
		for(int u = 0; u < AppareilsElectriques.size();u++)
		{
			//System.out.println(AppareilsElectriques.get(u).getNom());
		}
	}
	
	public static void LoadRestaurant()
	{
		Restaurants.clear();
		////System.out.println("Chargement Restaurant");
		String myfile = readdatafromtextfile("restaurant.save");
		String[] MyAppareils = myfile.split("NewRestaurant");
		String[] MyParameters;
		////System.out.println(myfile);
		String Name ;
		String CuisineName = "";
		String ForfaitName= "";
		for(int i=0;i<MyAppareils.length;i++)
		{
			Name="";
			MyParameters = MyAppareils[i].split("\n");
			////System.out.println("start");
			for(int e=0;e<MyParameters.length;e++)
			{
				if(MyParameters[e].startsWith("Name:"))
				{
					Name = MyParameters[e].substring(5).toString();
				}
				if(MyParameters[e].startsWith("Cuisine:"))
				{
					CuisineName = MyParameters[e].substring(8).toString();
				}
				if(MyParameters[e].startsWith("Forfait:"))
				{
					ForfaitName = MyParameters[e].substring(8).toString();
				}		
			}
			Name = Name.trim();
			CuisineName = CuisineName.trim();
			ForfaitName = ForfaitName.trim();
			Cuisine MyUberCuisine = getCuisineFromName(CuisineName);
			if(Name!=""){	
				Restaurants.add(new Restaurant(MyUberCuisine, Name, getForfaitFromName(ForfaitName)));
			}		
		}
	}
	

	public static void LoadCuisine()
	{
		Cuisines.clear();
		////System.out.println("Chargement Cuisine");
		String myfile = readdatafromtextfile("cuisine.save");
		String[] MyCuisines = myfile.split("NewCuisine");
		String[] MyParameters;
		String[] MyAppareils;
		String NameCuisine ;
		for(int i=0;i<MyCuisines.length;i++)
		{
			NameCuisine = "";
			
			try
			{
				MyParameters = MyCuisines[i].split("MesAppareils");
				for(int z=0;z<MyParameters.length;z++)
				{
					if(MyParameters[z].trim().startsWith("Name:"))
					{
						NameCuisine = MyParameters[z].substring(6).toString();
						Cuisines.add(new Cuisine(MyParameters[z].substring(6).toString().trim()));
					}
				}
				if(NameCuisine!=""){
				Cuisine MyCuisine = getCuisineFromName(NameCuisine);
				MyAppareils = MyParameters[1].split("\n");
				//System.out.println(MyParameters[1]);
				for(int y=0;y<MyAppareils.length;y++)
				{
					//System.out.println(AppareilsElectriques);
					if(MyAppareils[y].toString() !="")
					{
						
						AppareilElectrique MonAppareil = getAppareilFromName(MyAppareils[y]);
						if(MonAppareil!=null)
						{
							MyCuisine.AjouterAppareil(MonAppareil);
						}
					}
				}			
			}
			}
			catch(Exception e)
			{
				////System.out.println(e.getMessage());
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
	    	br.close();
	    	} catch (IOException e) {
			
				e.printStackTrace();
	    } finally {
	     
	    }
	    return everything;
	}
	public static ArrayList<AppareilElectrique> getListeAppareilsElectriques() {
		return AppareilsElectriques;
	}
	public static ArrayList<PlanAllumage> getListePlansAllumages() {
		return PlanAllumages;
	}
	
	public static void AjouterRestaurantToList(Restaurant MonRestaurant) {
		
		Restaurants.add(MonRestaurant);
		SaveRestaurant();	
	}
	
	public static void AjouterPlanAllumage(PlanAllumage MonPlan) {
		
		PlanAllumages.add(MonPlan);
		SavePlanAllumage();
	}
	
	public static void RetirerPlanAllumage(PlanAllumage MonPlan) {
		
		PlanAllumages.remove(MonPlan);
		SavePlanAllumage();
	}
	
	public static void RetirerRestaurantFromList(Restaurant MonRestaurant) {
		Restaurants.remove(MonRestaurant);
		SaveRestaurant();	
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
		SaveCuisine();
	}
	
	public static void AjouterAppareilToList(AppareilElectrique MonAppareil) {
		AppareilsElectriques.add(MonAppareil);
		SaveAppareilElectrique();
	}
	
	public static void RetirerAppareilFromList(AppareilElectrique MonAppareil) {
		AppareilsElectriques.remove(MonAppareil);
		SaveAppareilElectrique();
	}
	
	public static void RetirerAppareilFromList(String Name) {
		for(int i=0;i<AppareilsElectriques.size();i++)
		{
			if(AppareilsElectriques.get(i).getNom()==Name)
			{
				AppareilsElectriques.remove(i);
				break;
			}
		}
		SaveAppareilElectrique();
	}
	public static void RetirerCuisineFromList(String Name) {
		for(int i=0;i<Cuisines.size();i++)
		{
			if(Cuisines.get(i).getNom()==Name)
			{
				Cuisines.remove(i);
				break;
			}
		}
		SaveCuisine();
	}
	public static void RetirerRestaurantFromList(String Name) {
		for(int i=0;i<Restaurants.size();i++)
		{
			if(Restaurants.get(i).getNom()==Name)
			{
				Restaurants.remove(i);
				break;
			}
		}
		SaveCuisine();
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
			if(Cuisines.get(i).getNom().trim().compareTo(Name.trim()) == 0)
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
	
	public static Forfait getTHEFORFAIT() {
		return THEFORFAIT;
	}

	public static void setTHEFORFAIT(Forfait tHEFORFAIT) {
		
		THEFORFAIT = tHEFORFAIT;
		SaveForfait();
	}

	public static PlanAllumage getPlanAllumage(String Name)
	{
		for(int i=0; i < PlanAllumages.size(); i++)
		{
			if(PlanAllumages.get(i).getName().compareTo(Name) == 0)
				{
					return PlanAllumages.get(i);
				}
		}
		return null;
	}
	public static void SavePlanAllumage()
	{
		////System.out.println("Sauvegarde AppareilElectrique");
		
		PrintWriter writer =null;
			 try {
				writer= new PrintWriter("planallumages.save");
			} catch (FileNotFoundException e) {
			
			}
			for(int i = 0 ; i < PlanAllumages.size(); i++)
			{
				writer.println("NewPlanAllumage");
				writer.println("Name:"+PlanAllumages.get(i).getName().trim());		
				writer.println("Lundi");
				for(int a=0 ; a<PlanAllumages.get(i).getPlageHoraire("Lundi").size();a++)
				{
					writer.println(PlanAllumages.get(i).getPlageHoraire("Lundi").get(a).toString());
				}
				writer.println("Mardi");
				for(int a=0 ; a<PlanAllumages.get(i).getPlageHoraire("Mardi").size();a++)
				{
					writer.println(PlanAllumages.get(i).getPlageHoraire("Mardi").get(a).toString());
				}
				writer.println("Mercredi");
				for(int a=0 ; a<PlanAllumages.get(i).getPlageHoraire("Mercredi").size();a++)
				{
					writer.println(PlanAllumages.get(i).getPlageHoraire("Mercredi").get(a).toString());
				}
				writer.println("Jeudi");
				for(int a=0 ; a<PlanAllumages.get(i).getPlageHoraire("Jeudi").size();a++)
				{
					writer.println(PlanAllumages.get(i).getPlageHoraire("Jeudi").get(a).toString());
				}
				writer.println("Vendredi");
				for(int a=0 ; a<PlanAllumages.get(i).getPlageHoraire("Vendredi").size();a++)
				{
					writer.println(PlanAllumages.get(i).getPlageHoraire("Vendredi").get(a).toString());
				}
				writer.println("Samedi");
				for(int a=0 ; a<PlanAllumages.get(i).getPlageHoraire("Samedi").size();a++)
				{
					writer.println(PlanAllumages.get(i).getPlageHoraire("Samedi").get(a).toString());
				}
				writer.println("Dimanche");
				for(int a=0 ; a<PlanAllumages.get(i).getPlageHoraire("Dimanche").size();a++)
				{
					writer.println(PlanAllumages.get(i).getPlageHoraire("Dimanche").get(a).toString());
				}
			}
			writer.close();
	}



public static void LoadPlanAllumage()
{
	PlanAllumages.clear();
	////System.out.println("Chargement Restaurant");
	String myfile = readdatafromtextfile("planallumages.save");
	String[] MyPlanAllumages = myfile.split("NewPlanAllumage");
	String[] MyParameters;
	String Jour="Lundi";
	for(int i=0;i<MyPlanAllumages.length;i++)
	{
		PlanAllumage Temp = new PlanAllumage();
		MyParameters = MyPlanAllumages[i].split("\n");
		////System.out.println("start");
		for(int e=0;e<MyParameters.length;e++)
		{
			//System.out.println(MyParameters[e]);
			if(MyParameters[e].startsWith("Name:"))
			{
				Temp.setName( MyParameters[e].trim().substring(5).toString());
			}
			if(MyParameters[e].startsWith("Lundi"))
			{
			
				Jour="Lundi";
			}
			if(MyParameters[e].startsWith("Mardi"))
			{
				Jour="Madi";
			}
			if(MyParameters[e].startsWith("Mercredi"))
			{
				Jour="Mercredi";
			}
			if(MyParameters[e].startsWith("Jeudi"))
			{
				Jour="Jeudi";
			}
			if(MyParameters[e].startsWith("Vendredi"))
			{
				Jour="Vendredi";
			}
			if(MyParameters[e].startsWith("Samedi"))
			{
				Jour="Samedi";
			}
			if(MyParameters[e].startsWith("Dimanche"))
			{
				Jour="Dimanche";
			}
			if(MyParameters[e].contains("-"))
			{
				int HeureDebut;
				int HeureFin;
				int MinuteDebut;
				int MinuteFin;
				String temp;
				String[] times;
				String[] times2;
 				temp = MyParameters[e].trim();
				times = temp.split("-");
				times2 = times[0].split(":");
				HeureDebut = Integer.parseInt(times2[0].trim());
				MinuteDebut = Integer.parseInt(times2[1].trim());
				times2 = times[1].split(":");
				HeureFin = Integer.parseInt(times2[0].trim());
				MinuteFin = Integer.parseInt(times2[1].trim());
				//System.out.println(HeureDebut);
				//System.out.println(MinuteDebut);
				//System.out.println(HeureFin);
				//System.out.println(MinuteFin);

				Temp.addPlageHoraire(Jour, new Heure(HeureDebut,MinuteDebut), new Heure(HeureFin,MinuteFin));
				//System.out.println(Temp.getPlageHoraire("Lundi").size());
			}
			
			
		}
	
		if(Temp.getName()!=""){	
			PlanAllumages.add(Temp);
		}		
}
}


}