import java.util.ArrayList;



public class PlanAllumage {

	private String Name;
	private ArrayList<PlageHoraire> PlageHoraireLundi;
	private ArrayList<PlageHoraire> PlageHoraireMardi;
	private ArrayList<PlageHoraire> PlageHoraireMercredi;
	private ArrayList<PlageHoraire> PlageHoraireJeudi;
	private ArrayList<PlageHoraire> PlageHoraireVendredi;
	private ArrayList<PlageHoraire> PlageHoraireSamedi;
	private ArrayList<PlageHoraire> PlageHoraireDimanche;

	

	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public void addPlageHoraire(String jour, Heure Debut, Heure Fin) {

		switch (jour) {
		case "Lundi":
			PlageHoraireLundi.add(new PlageHoraire(Debut, Fin));
			break;
		case "Mardi":
			PlageHoraireMardi.add(new PlageHoraire(Debut, Fin));
			break;
		case "Mercredi":
			PlageHoraireMercredi.add(new PlageHoraire(Debut, Fin));
			break;
		case "Jeudi":
			PlageHoraireJeudi.add(new PlageHoraire(Debut, Fin));
			break;
		case "Vendredi":
			PlageHoraireVendredi.add(new PlageHoraire(Debut, Fin));
			break;
		case "Samedi":
			PlageHoraireSamedi.add(new PlageHoraire(Debut, Fin));
			break;
		case "Dimanche":
			PlageHoraireDimanche.add(new PlageHoraire(Debut, Fin));
			break;
		}
	}

	public void remPlageHoraire(String jour, int i) {

		switch (jour) {
		case "Lundi":
			PlageHoraireLundi.remove(i);
			break;
		case "Mardi":
			PlageHoraireMardi.remove(i);
			break;
		case "Mercredi":
			PlageHoraireMercredi.remove(i);
			break;
		case "Jeudi":
			PlageHoraireJeudi.remove(i);
			break;
		case "Vendredi":
			PlageHoraireVendredi.remove(i);
			break;
		case "Samedi":
			PlageHoraireSamedi.remove(i);
			break;
		case "Dimanche":
			PlageHoraireDimanche.remove(i);
			break;
		}
	}

	public ArrayList<PlageHoraire> getPlageHoraire(String jour) {

		switch (jour) {
		case "Lundi":
			return PlageHoraireLundi;
		case "Mardi":
			return PlageHoraireMardi;
		case "Mercredi":
			return PlageHoraireMercredi;
		case "Jeudi":
			return PlageHoraireJeudi;
		case "Vendredi":
			return PlageHoraireVendredi;
		case "Samedi":
			return PlageHoraireSamedi;
		case "Dimanche":
			return PlageHoraireDimanche;
		}
		return null;

	}

	public PlanAllumage() {
		Name="";
		
		 PlageHoraireLundi = new ArrayList<PlageHoraire>();
		 PlageHoraireMardi = new ArrayList<PlageHoraire>();
		 PlageHoraireMercredi = new ArrayList<PlageHoraire>();
		 PlageHoraireJeudi = new ArrayList<PlageHoraire>();
		 PlageHoraireVendredi = new ArrayList<PlageHoraire>();
		 PlageHoraireSamedi = new ArrayList<PlageHoraire>();
		 PlageHoraireDimanche = new ArrayList<PlageHoraire>();
	}
}
