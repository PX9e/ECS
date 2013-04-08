
public class PlageHoraire {

	private Heure Debut;
	private Heure Fin;
	public Heure getDebut() {
		return Debut;
	}
	public void setDebut(Heure debut) {
		Debut = debut;
	}
	public Heure getFin() {
		return Fin;
	}
	public void setFin(Heure fin) {
		Fin = fin;
	}
	PlageHoraire()
	{
		Debut = new Heure();
		Fin =new Heure();
	}
	
	PlageHoraire(Heure pDebut, Heure pFin)
	{
		
		//System.out.println("f" + pDebut.toString());

		//System.out.println("f" + pFin.toString());
		Debut = pDebut;
		Fin = pFin;
		
	}
	
	PlageHoraire(int HD,int MD,int HF,int MF)
	{
		Debut = new Heure(HD,MD);
		Fin = new Heure(HF,MF);
		
	}
	
	public Heure GetTime(){ 
		return Fin.substract(Debut);
		
	}
	
	public String toString(){
		return Debut.toString() + " - " + Fin.toString();
	}
}
