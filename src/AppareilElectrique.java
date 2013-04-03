
public class AppareilElectrique {

	private float consommationMax;
	private String nom;
	private PlanAllumage planAllumage;
	
	AppareilElectrique(String Nom)
	{
		nom = Nom;
		planAllumage = new PlanAllumage();
		consommationMax = 0;
	}
	
	AppareilElectrique(String Nom, float Consommation)
	{
		nom = Nom;
		consommationMax = Consommation;
	}
	
	AppareilElectrique(String pNom,float pconsommationMax,PlanAllumage pplanAllumage)
	{
		nom = pNom;
		
		consommationMax = pconsommationMax;
		if(pplanAllumage==null)
		{
			planAllumage = new PlanAllumage();
		}
		else
		{	
			planAllumage =pplanAllumage;
		}
	}
	
	public float getConsommationMax() 
	{
		return consommationMax;
	}
	public void setConsommationMax(float consommationMax) 
	{
		this.consommationMax = consommationMax;
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
