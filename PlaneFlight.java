/*
 * Takes two vectors and an airfoil and determines equations such as lift and 
 * 
 * @author Patrick Boyle
 * @date 4/22/2017
 */
public class PlaneFlight
{
	//Variables
	
	private flightVector planeVector, windVector;
	private Airfoil wings;
	private double weight;
	private String name;
	
	//Constructor
	
	public PlaneFlight(flightVector p, flightVector wind, Airfoil wing, double wei, String n)
	{
		planeVector = p;
		windVector = wind;
		wings = wing;
		weight = wei;
		name = n;
	}
	
	//Getters and Setters
	
	public flightVector getPlaneVector()
	{
		return planeVector;
	}
	public void setPlaneVector(flightVector p)
	{
		planeVector = p;
	}
	public flightVector getWindVector()
	{
		return windVector;
	}
	public void setWindVector(flightVector w)
	{
		windVector = w;
	}
	public Airfoil getWings()
	{
		return wings;
	}
	public void setWings(Airfoil w)
	{
		wings = w;
	}
	public double getWeight()
	{
		return weight;
	}
	public void setWeight(double w)
	{
		weight = w;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String n)
	{
		name = n;
	}
	
	//Groundspeed of plane
	
	public double groundspeed()
	{
		return planeVector.deadReckoning(windVector).getSpeed();
	}
	
	//True Heading of plane
	
	public double trueHeading()
	{
		return planeVector.deadReckoning(windVector).getDirection();
	}
	
	public double getRelativeWind()
	{
	    flightVector temp = new flightVector(windVector.getSpeed(), windVector.dirConvert()-planeVector.dirConvert());
		return planeVector.getSpeed() - temp.xComp();
	}
	public double getLift()
	{
		return wings.getAirDensity()*Math.pow(this.getRelativeWind(), 2)*wings.getSurfaceArea()*wings.getCoLift();
	}
	public Boolean canFly()
	{
		if(this.getLift() >= weight)
			return true;
		else
			return false;
	}
	public String toString()
	{
		return name + "\n------------------\n" + planeVector.toString() + "\n------------------\n\nWind\n------------------\n" + windVector.toString() + "\n------------------\n\nWing and Air\n------------------\n" + wings + "\nWeight: " + weight + " lbs\n\nWill it fly: " + canFly();
	}
}