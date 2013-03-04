import java.util.ArrayList;



public class PlanAllumage {

	
    
	private ArrayList<ArrayList<Heure>> PlageHoraire ;

	public ArrayList<ArrayList<Heure>> getPlageHoraire() {
		return PlageHoraire;
	}

	public void setPlageHoraire(ArrayList<ArrayList<Heure>> plageHoraire) {
		PlageHoraire = plageHoraire;
	}
	
	public void AddPlageHoraire(Heure Debut,Heure Fin)
	{
		PlageHoraire.add(new ArrayList<Heure>());
		PlageHoraire.get(PlageHoraire.size()).add(Debut);
		PlageHoraire.get(PlageHoraire.size()).add(Fin);
	}
	
	
	
	
	
	
	
	
}
