import java.util.ArrayList;
import java.util.HashMap;


public class Sequence {
	String Name; 
	
	ArrayList<AppareilElectrique> AppareilsConcernes;
	HashMap<ProduitAlimentaire,Integer> ProduitsAProduire;
	
	public void SetAppareil(AppareilElectrique MonAppareil)
	{
		if(!AppareilsConcernes.contains(MonAppareil))
		{
			AppareilsConcernes.add(MonAppareil);
		}
	}
	
	public Sequence(String pName){ 
		Name = pName;
	}
	
	public void deleteAppareil(AppareilElectrique MonAppareil)
	{
		if(AppareilsConcernes.contains(MonAppareil))
		{
			AppareilsConcernes.remove(MonAppareil);
		}
	}
	
	public void deleteAppareil(int Indice)
	{
		if(AppareilsConcernes.size() - 1 <Indice)
		{
			AppareilsConcernes.remove(Indice);
		}
	}
	
	public HashMap<ProduitAlimentaire, Integer> GetProduitsAlimentaires(){
		return ProduitsAProduire;
	}
	
	public void SetProduitsAlimentaires(ProduitAlimentaire MonProduit,int Nombre)
	{
		
		if(ProduitsAProduire.containsKey(MonProduit))
		{
			ProduitsAProduire.remove(MonProduit);
			ProduitsAProduire.put(MonProduit, Nombre);
		}
		else
		{
			ProduitsAProduire.put(MonProduit, Nombre);
		}
	}
	
	public String GetName()
	{
		return Name;
	}
	
	public ArrayList<AppareilElectrique> GetAppareilsFromProducts()
	{
		return AppareilsConcernes;
	}
	
	public void GetAppareilFromProduit(){
		
		for(int i = 0; i<ProduitsAProduire.size();i++)
		{
			for(int y = 0 ; y <ProduitsAProduire.keySet().size();y++)
			{
				ProduitsAProduire.keySet()
			}
		}
	}
}