import java.util.ArrayList;


public class AppareilElectrique {


	private String nom;
	private PlanAllumage planAllumage;
	private ArrayList<Mode> Modes;
	
	AppareilElectrique(String Nom)
	{
		nom = Nom;
		planAllumage = new PlanAllumage();
		
	}
	
	public ArrayList<Mode> getModes() {
		return Modes;
	}
	
	public void AddModes(Mode pMode)
	{
		Modes.add(pMode);
	}
	
	public void remModes(String Name)
	{
		for(int i = 0 ;i < Modes.size(); i ++ )
		{
			if(Modes.get(i).getName()==Name)
			{
				Modes.remove(i);
				break;
			}
		}
	}
	
	public void setModes(ArrayList<Mode> modes) {
		Modes = modes;
	}

	AppareilElectrique(String Nom, float Consommation)
	{
		nom = Nom;
		
	}
	
	AppareilElectrique(String pNom,float pconsommationMax,PlanAllumage pplanAllumage)
	{
		nom = pNom;
		
		
		if(pplanAllumage==null)
		{
			planAllumage = new PlanAllumage();
		}
		else
		{	
			planAllumage =pplanAllumage;
		}
	}
	

	public String getNom()
	{
		return nom;
	}
	public void setNom(String nom) 
	{
		this.nom = nom;
	}
	public PlanAllumage getPlanAllumage() 
	{
		return planAllumage;
	}
	
	public void setPlanAllumage(PlanAllumage planAllumage) 
	{
		this.planAllumage = planAllumage;
	}
	
	//TODO
	public float consommationPonctuelle(Heure heure)
	{
			return 0;
	}
	
	@Override
	public String toString()
	{
		return nom;		
	}
	
}
