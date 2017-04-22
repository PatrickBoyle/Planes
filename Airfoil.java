/*
 * creates an airfoil
 * 
 * @author Patrick Boyle
 * @date 4/22/2017
 * 
 */
public class Airfoil
{
	//Variables
	
	private double airDensity, surfaceArea, coLift; 
	//coLift is the Coefficient of Lift which is made up of Angle of Attack and wing shape
	
	//Constructor
	
	public Airfoil(double aD, double sA, double cL)
	{
		airDensity = aD;
		surfaceArea = sA;
		coLift = cL; 
	}
	
	//Getters and Setters
	
	public double getAirDensity()
	{
		return airDensity;
	}
	public void setAirDensity(double aD)
	{
		airDensity = aD;
	}
	public double getSurfaceArea()
	{
		return surfaceArea;
	}
	public void setSurfaceArea(double sA)
	{
		surfaceArea = sA;
	}
	public double getCoLift()
	{
		return coLift;
	}
	public void setCoLift(double cL)
	{
		coLift = cL;
	}
	
	//To String
	
	public String toString()
	{
		return "Air Density: " + airDensity + " atm\nSurface Area: " + surfaceArea + " square feet\nCoefficient of Lift: " + coLift;
	}
}