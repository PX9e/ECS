import java.util.ArrayList;


public class Mode {

	String Name;
	
	ArrayList<Double> Up;
	ArrayList<Double> Down;
	
	Mode(String pName, ArrayList<Double> pUp, ArrayList<Double> pDown)
	{
		Name = pName;
		Up = pUp;
		Down = pDown;
	}

	public void AddUp(double i)
	{
		if(Up==null)
		{
			Up=new ArrayList<Double>();
		}
		Up.add(i);
	}
	
	public void AddDown(double i)
	{
		if(Down==null)
		{
			Down=new ArrayList<Double>();
		}
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
