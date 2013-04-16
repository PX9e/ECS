


public class Forfait {
	private String Name;
	private Double Pleine;
	private Double Creuse;
	private PlageHoraire PleineH;
	private PlageHoraire CreuseH;
	private double Pic;
	
	
	
	
	Forfait(String pName,Double pPleine,Double pCreuse, PlageHoraire pPleineH,PlageHoraire pCreuseH,Double pPic)
	{
		Name = pName;
		Pleine = pPleine;
		Creuse = pCreuse;
		PleineH = pPleineH;
		CreuseH = pCreuseH;
		Pic = pPic;
	}
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public Double getPleine() {
		return Pleine;
	}

	public void setPleine(Double pleine) {
		Pleine = pleine;
	}

	public Double getCreuse() {
		return Creuse;
	}

	public void setCreuse(Double creuse) {
		Creuse = creuse;
	}

	public PlageHoraire getPleineH() {
		return PleineH;
	}

	public void setPleineH(PlageHoraire pleineH) {
		PleineH = pleineH;
	}

	public PlageHoraire getCreuseH() {
		return CreuseH;
	}

	public void setCreuseH(PlageHoraire creuseH) {
		CreuseH = creuseH;
	}

	public double getPic() {
		return Pic;
	}

	public void setPic(double pic) {
		Pic = pic;
	}

	public String getNom() {
		return Name;
	}

	public void setNom(String name) {
		Name = name;
	}
	
	Forfait()
	{
		Name="";
		
	}
	
	
}
