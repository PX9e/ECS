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
		//System.out.println("jour "+ jour);
		switch (jour) {
		case "Lundi":
			//System.out.println("p" + Debut.toString());

			//System.out.println("p" + Fin.toString());
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
		
	}public void remPlageHoraire(String jour, Heure pDebut,Heure pFin) {

		switch (jour) {
		case "Lundi":
			for(int i= 0;i<PlageHoraireLundi.size();i++)
			{
				if((PlageHoraireLundi.get(i).getDebut()==pDebut)&&(PlageHoraireLundi.get(i).getFin()==pFin))
				{
					PlageHoraireLundi.remove(i);
					break;
				}
			}
			
			break;
		case "Mardi":
			for(int i= 0;i<PlageHoraireMardi.size();i++)
			{
				if((PlageHoraireMardi.get(i).getDebut()==pDebut)&&(PlageHoraireMardi.get(i).getFin()==pFin))
				{
					PlageHoraireMardi.remove(i);
					break;
				}
			}
		case "Mercredi":
			for(int i= 0;i<PlageHoraireMercredi.size();i++)
			{
				if((PlageHoraireMercredi.get(i).getDebut()==pDebut)&&(PlageHoraireMercredi.get(i).getFin()==pFin))
				{
					PlageHoraireMercredi.remove(i);
					break;
				}
			}
		case "Jeudi":
			for(int i= 0;i<PlageHoraireJeudi.size();i++)
			{
				if((PlageHoraireJeudi.get(i).getDebut()==pDebut)&&(PlageHoraireJeudi.get(i).getFin()==pFin))
				{
					PlageHoraireJeudi.remove(i);
					break;
				}
			}
			break;
		case "Vendredi":
			for(int i= 0;i<PlageHoraireVendredi.size();i++)
			{
				if((PlageHoraireVendredi.get(i).getDebut()==pDebut)&&(PlageHoraireVendredi.get(i).getFin()==pFin))
				{
					PlageHoraireVendredi.remove(i);
					break;
				}
			}
			break;
		case "Samedi":
			for(int i= 0;i<PlageHoraireSamedi.size();i++)
			{
				if((PlageHoraireSamedi.get(i).getDebut()==pDebut)&&(PlageHoraireSamedi.get(i).getFin()==pFin))
				{
					PlageHoraireSamedi.remove(i);
					break;
				}
			}
			break;
		case "Dimanche":
			for(int i= 0;i<PlageHoraireDimanche.size();i++)
			{
				if((PlageHoraireDimanche.get(i).getDebut()==pDebut)&&(PlageHoraireDimanche.get(i).getFin()==pFin))
				{
					PlageHoraireDimanche.remove(i);
					break;
				}
			}
		}
	}
	public String toString()
	{
		return Name;
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
