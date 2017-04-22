/*
 * Runner class creates an airplane
 * 
 * @author Patrick Boyle
 * @date 4/22/2017
 * 
 */
import java.util.*;
public class Plane
{
	public static void main(String[] args)
	{
		flightVector course = new flightVector(564, 45);
		flightVector wind = new flightVector(20, 200);
		Airfoil wings = new Airfoil(0.6415, 5825, .80);
		PlaneFlight plane1 = new PlaneFlight(course, wind, wings, 735000, "Boeing 747");
		System.out.print(plane1);
	}
}
