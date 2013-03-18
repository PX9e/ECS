import java.util.ArrayList;


public class Cuisine {

	private ArrayList<AppareilElectrique> AppareilsElectriques;
	private String Nom;
	
	public void AjouterAppareil(AppareilElectrique MonAppareil)
	{
		AppareilsElectriques.add(MonAppareil);
	}
	
	public void RetirerAppareil(AppareilElectrique MonAppareil)
	{
		AppareilsElectriques.remove(MonAppareil);
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
	
	public ArrayList<AppareilElectrique> ObtenirAppareils()
	{
		return AppareilsElectriques;
	}
	
	Cuisine()
	{
		AppareilsElectriques = new ArrayList<AppareilElectrique>();
	}
	
	Cuisine(String nom)
	{
		Nom = nom;
	}
	
	Cuisine( ArrayList<AppareilElectrique> MesAppareils)
	{
		this.AppareilsElectriques = MesAppareils;
	}


	public String getNom() {
		return Nom;
	}


	public void setNom(String nom) {
		Nom = nom;
	}
	
	@Override
	public String toString()
	{
		return Nom;
	}
	
	
	
}
