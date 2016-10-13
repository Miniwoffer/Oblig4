abstract class GeometricObject {
	//Variables
	protected static double density = 7.8;
	//Constructor
	GeometricObject() {};
	//Abstract methods
	abstract double findArea();
	abstract double findVolume();
	abstract double findCircumference();
	abstract double findSurfaceArea();
	abstract double findWeight();
}
