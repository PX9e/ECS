import java.util.ArrayList;


public class Cuisine {

	private ArrayList<AppareilElectrique> AppareilsElectriques;
	
	public void AjouterAppareil(AppareilElectrique MonAppareil)
	{
		AppareilsElectriques.add(MonAppareil);
	}
	
	
	public AppareilElectrique ObtenirAppareil(int i)
	{
		if(i > AppareilsElectriques.size())
		{
			return AppareilsElectriques.get(i);
		}
		else
		{
			return null;
		}
	}
	
	public ArrayList<AppareilElectrique> ObtenirAppareils(int i)
	{
		return AppareilsElectriques;
	}
	
	Cuisine()
	{
		AppareilsElectriques = new ArrayList<AppareilElectrique>();
	}
	
	Cuisine( ArrayList<AppareilElectrique> MesAppareils)
	{
		this.AppareilsElectriques = MesAppareils;
	}
	
	
	
}
