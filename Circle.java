public abstract class Circle extends GeometricObject {
	//Variables
	protected double radius;

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
	public double findArea(double t) {
		return ( ( this.radius - t ) * ( this.radius - t ) * Math.PI );
	}
	public double findCircumference() {
		return ( this.radius * 2 * Math.PI );
	}
	public String toString() {
		return ( " Density: " + super.density + "\n Radius: " + this.radius );
	}
}