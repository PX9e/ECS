import java.util.ArrayList;


public class AppareilElectrique {


	private String nom;
	private ArrayList<PlanAllumage> planAllumage;
	private ArrayList<Mode> Modes;
	private ArrayList<Integer> Couples;
	
	public ArrayList<Integer> getCouples() {
		return Couples;
	}

	public void setCouples(ArrayList<Integer> couples) {
		Couples = couples;
	}

	
	
	AppareilElectrique()
	{
		nom ="";
		planAllumage = new ArrayList<PlanAllumage>();
		Modes = new ArrayList<Mode>();
		Couples = new ArrayList<Integer>();
	}
	
	public ArrayList<Mode> getModes() {
		return Modes;
	}
	
	public void AddModes(Mode pMode)
	{
		Modes.add(pMode);
	}
	public void AddCouple(int a,int b)
	{
		Couples.add(a);
		Couples.add(b);
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

	AppareilElectrique(String Nom)
	{
		nom = Nom;
		planAllumage = new ArrayList<PlanAllumage>();
		Modes = new ArrayList<Mode>();
		Couples = new ArrayList<Integer>();
	}
	
	
	
	public String getNom()
	{
		return nom;
	}
	public void setNom(String nom) 
	{
		this.nom = nom;
	}
	public ArrayList<PlanAllumage> getPlanAllumage() 
	{
		return planAllumage;
	}
	
	public void setPlanAllumage(ArrayList<PlanAllumage> planAllumage) 
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
