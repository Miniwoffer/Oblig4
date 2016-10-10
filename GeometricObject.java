abstract class GeometricObject {
	//Variables
	private double density;
	//Constructor
	GeometricObject() {
		this.density = 7.8;
	}
	//Abstract methods
	abstract double findArea();
	abstract double findVolume();
	abstract double findCircumference();
	abstract double findSurfaceArea();
	abstract double findWeight();
}