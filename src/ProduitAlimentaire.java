import java.util.ArrayList;


public class ProduitAlimentaire {

	
	public ProduitAlimentaire(String pName)
	{
		Name = pName;
	}
	
	
	public void setAppareilsNecessaires(AppareilElectrique MonAppareil)
	{
		if(!AppareilsNecessaires.contains(MonAppareil))
		{
			AppareilsNecessaires.add(MonAppareil);
		}
	}
	String Name; 
	
	ArrayList<AppareilElectrique> AppareilsNecessaires;
	
	public void deleteAppareilsNecessaires(AppareilElectrique MonAppareil)
	{
		if(AppareilsNecessaires.contains(MonAppareil))
		{
			AppareilsNecessaires.remove(MonAppareil);
		}
	}
	
	public ArrayList<AppareilElectrique> getAppareilsNecessaires(){
		return AppareilsNecessaires;
	}
	
	public void deleteAppareilsNecessaires(int Indice)
	{
		if(AppareilsNecessaires.size()-1 >Indice)
		{
			AppareilsNecessaires.remove(Indice);
		}
	}
	

}
