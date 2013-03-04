import java.util.ArrayList;



public class PlanAllumage {

	private ArrayList<ArrayList<Heure>> PlageHoraireLundi;
	private ArrayList<ArrayList<Heure>> PlageHoraireMardi;
	private ArrayList<ArrayList<Heure>> PlageHoraireMercredi;
	private ArrayList<ArrayList<Heure>> PlageHoraireJeudi;
	private ArrayList<ArrayList<Heure>> PlageHoraireVendredi;
	private ArrayList<ArrayList<Heure>> PlageHoraireSamedi;
	private ArrayList<ArrayList<Heure>> PlageHoraireDimanche;

	public void addPlageHoraire(String jour, Heure Debut, Heure Fin) {

		switch (jour) {
		case "Lundi":
			PlageHoraireLundi.get(PlageHoraireLundi.size()).add(Debut);
			PlageHoraireLundi.get(PlageHoraireLundi.size()).add(Fin);
			break;
		case "Mardi":
			PlageHoraireMardi.get(PlageHoraireMardi.size()).add(Debut);
			PlageHoraireMardi.get(PlageHoraireMardi.size()).add(Fin);
			break;
		case "Mercredi":
			PlageHoraireMercredi.get(PlageHoraireMercredi.size()).add(Debut);
			PlageHoraireMercredi.get(PlageHoraireMercredi.size()).add(Fin);
			break;
		case "Jeudi":
			PlageHoraireJeudi.get(PlageHoraireJeudi.size()).add(Debut);
			PlageHoraireJeudi.get(PlageHoraireJeudi.size()).add(Fin);
			break;
		case "Vendredi":
			PlageHoraireVendredi.get(PlageHoraireVendredi.size()).add(Debut);
			PlageHoraireVendredi.get(PlageHoraireVendredi.size()).add(Fin);
			break;
		case "Samedi":
			PlageHoraireSamedi.get(PlageHoraireSamedi.size()).add(Debut);
			PlageHoraireSamedi.get(PlageHoraireSamedi.size()).add(Fin);
			break;
		case "Dimanche":
			PlageHoraireDimanche.get(PlageHoraireDimanche.size()).add(Debut);
			PlageHoraireDimanche.get(PlageHoraireDimanche.size()).add(Fin);
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

	public ArrayList<ArrayList<Heure>> getPlageHoraire(String jour) {

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

}
