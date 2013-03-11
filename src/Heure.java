
public class Heure 
{

	private int heures;
	private int minutes;
	
	
	
	public int getHeures() {
		return heures;
	}
	public void setHeures(int heures) {
		this.heures = heures;
	}
	public int getMinutes() {
		return minutes;
	}
	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}
	
	public void add(Heure MonHeure)
	{
		minutes = minutes + MonHeure.minutes;
		
		if(minutes>60)
		{
			minutes = minutes - 60; 
		    heures = heures + 1;
		}
		if(heures>23)
		{
			heures = 0 ;
			
		}
	}
	
	
}
