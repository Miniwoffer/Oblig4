public abstract class Circle extends Geometricobject {
	//Variables
	private double radius;

	//Constructors:
	//Default
	Circle() {
		this.radius = 1.0;
	}
	//Defined Radius
	Circle( double r ) {
		this.radius = r;
	}

	//get + set
	public void setRadius( double r ) {
		this.radius = r;
	}
	public double getRadius() {
		return ( this.radius );
	}
	
	//Find
	public double findArea() {
		return ( this.radius * this.radius * Math.PI );
	}
	public double findCircumference() {
		return ( this.radius * 2 * Math.PI );
	}
	private String toString() {
		return ( " Density: " + super.density + " Radius: " + this.radius );
	}
}