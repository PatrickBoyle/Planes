/*
 * Creates vectors for wind and plane measurements
 * 
 * @author Patrick Boyle
 * @date 4/22/2017
 * 
 */

public class flightVector
{
	//Variables
	
	private double speed, direction;
	
	//Constructor
	
	public flightVector(double s, double dir)
	{
		speed = s;
		direction = dir;
	}
	//Getters and Setters
	public double getSpeed()
	{
		return speed;
	}
	public void setSpeed(double s)
	{
		speed = s;
	}
	public double getDirection()
	{
		return direction;
	}
	public void setDirection(double dir)
	{
		direction = dir;
	}
	
	//Bearing to Unit Circle
	
	public double dirConvert()
	{
		return (-1)*direction+90;
	}
	public double dirConvert(double x)
	{
		return (-1)*x+90;
	}
	
	//Unit Circle to Bearing
	
	public double ucConvert()
	{
		return (direction-90)*(-1);
	}
	public double ucConvert(double x)
	{
		return (x-90)*(-1);
	}
	
	//Get X component of vector
	
	public double xComp()
	{
		return speed*Math.cos(this.dirConvert());
	}
	public double xComp(double spe, double dir)
	{
		return spe*Math.cos(dir);
	}
	
	//Get Y component of vector
	
	public double yComp()
	{
		return speed*Math.sin(this.dirConvert());
	}
	public double yComp(double spe, double dir)
	{
		return spe*Math.sin(dir);
	}	
	//Wind Triangle Calculations
	
	public flightVector deadReckoning(flightVector wind)
	{
		double x = (this.xComp() + wind.xComp())/(this.yComp() + wind.yComp());
		return new flightVector(Math.sqrt(Math.pow(this.xComp() + wind.xComp(), 2) + Math.pow(this.yComp() + wind.yComp(), 2)), ucConvert(Math.toDegrees(Math.atan(x))));
	}
	
	//To String
	
	public String toString()
	{
		return "Speed: " + speed + " knots\nDirection: " + direction + " degrees";
	}
}


