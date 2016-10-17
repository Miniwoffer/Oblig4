package geometric;
import java.text.DecimalFormat;


public abstract class GeometricObject {
	//Variables
	protected static double density = 7.8;
	//Constructor
	GeometricObject() {};
	//Abstract methods
	public abstract double findArea();
	public abstract double findVolume();
	public abstract double findCircumference();
	public abstract double findSurfaceArea();
	public abstract double findWeight();
}