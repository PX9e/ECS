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
		Nom = "";
		AppareilsElectriques = new ArrayList<AppareilElectrique>();
	}
	
	Cuisine(String nom)
	{
		Nom = nom;
		AppareilsElectriques = new ArrayList<AppareilElectrique>();
	}
	
	Cuisine( ArrayList<AppareilElectrique> MesAppareils)
	{
		this.AppareilsElectriques = MesAppareils;
	}
	
	Cuisine (String nom, ArrayList<AppareilElectrique> MesAppareils)
	{
		Nom = nom;
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
