import java.util.ArrayList;


public class Mode {

	String Name;
	
	ArrayList<Double> Up;
	ArrayList<Double> Down;
	

	Mode()
	{
		Name = "";
		Up=new ArrayList<Double>();
		Down=new ArrayList<Double>();
	}
	Mode(String pName)
	{
		Name = pName;
		Up=new ArrayList<Double>();
		Down=new ArrayList<Double>();
	}

	public void AddUp(double i)
	{
	
		Up.add(i);
	}
	
	public void AddDown(double i)
	{
	
		Down.add(i);
	}
	public String toString()
	{
		return Name;
	}
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public ArrayList<Double> getUp() {
		return Up;
	}

	public void setUp(ArrayList<Double> up) {
		Up = up;
	}

	public ArrayList<Double> getDown() {
		return Down;
	}

	public void setDown(ArrayList<Double> down) {
		Down = down;
	}
	
	
	
}
