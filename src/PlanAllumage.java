import java.util.ArrayList;



public class PlanAllumage {

	private String Name;
	private ArrayList<ArrayList<PlageHoraire>> PlageHoraireLundi;
	private ArrayList<ArrayList<PlageHoraire>> PlageHoraireMardi;
	private ArrayList<ArrayList<PlageHoraire>> PlageHoraireMercredi;
	private ArrayList<ArrayList<PlageHoraire>> PlageHoraireJeudi;
	private ArrayList<ArrayList<PlageHoraire>> PlageHoraireVendredi;
	private ArrayList<ArrayList<PlageHoraire>> PlageHoraireSamedi;
	private ArrayList<ArrayList<PlageHoraire>> PlageHoraireDimanche;

	

	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public void addPlageHoraire(String jour, Heure Debut, Heure Fin) {

		switch (jour) {
		case "Lundi":
			PlageHoraireLundi.get(PlageHoraireLundi.size()).add(new PlageHoraire(Debut, Fin));
			break;
		case "Mardi":
			PlageHoraireMardi.get(PlageHoraireMardi.size()).add(new PlageHoraire(Debut, Fin));
			break;
		case "Mercredi":
			PlageHoraireMercredi.get(PlageHoraireMercredi.size()).add(new PlageHoraire(Debut, Fin));
			break;
		case "Jeudi":
			PlageHoraireJeudi.get(PlageHoraireJeudi.size()).add(new PlageHoraire(Debut, Fin));
			break;
		case "Vendredi":
			PlageHoraireVendredi.get(PlageHoraireVendredi.size()).add(new PlageHoraire(Debut, Fin));
			break;
		case "Samedi":
			PlageHoraireSamedi.get(PlageHoraireSamedi.size()).add(new PlageHoraire(Debut, Fin));
			break;
		case "Dimanche":
			PlageHoraireDimanche.get(PlageHoraireDimanche.size()).add(new PlageHoraire(Debut, Fin));
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

	public ArrayList<ArrayList<PlageHoraire>> getPlageHoraire(String jour) {

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
	}
}
