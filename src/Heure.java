
public class  Heure
{

	private int heures;
	private int minutes;
	
	Heure()
	{
		heures = 0;
		minutes = 0;
	}
	
	public Heure(int pHeure,int pMinute)
	{
		heures = pHeure;
		minutes = pMinute;
	}
	
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
	
	/*public void add( Heure MonHeure)
	{
		minutes = minutes + MonHeure.minutes;
		
		if(minutes>60)
		{
			minutes = minutes - 60; 
		    heures = heures + 1;
		}
		heures = heures + MonHeure.heures;
		if(heures>23)
		{
			heures = 0 ;
			
		}
	}*/
	
	public Heure substract( Heure MonHeure)
	{
		Heure Temp = new Heure();
		Temp.setHeures( heures - MonHeure.heures);
		Temp.setMinutes( minutes - MonHeure.minutes);
		
		if(Temp.minutes<0)
		{
			Temp.minutes = Temp.minutes + 60; 
			
			Temp.heures = Temp.heures -1 ;
		}
		
		if(Temp.heures<0)
		{
			Temp.heures = 0 ;
			
		}
		return Temp;
	}
	
	public String toString()
	{
		String Heure = String.valueOf(heures);
		String Minute = String.valueOf(minutes);
		if(Heure.length()<2)
		{
			Heure = "0"+Heure;
		}
		if(Minute.length()<2)
		{
			Minute = Minute +"0";
		}
		
		return Heure+":"+ Minute;
	}
	public int toInt(){
		return heures*60+minutes;
	}
}
