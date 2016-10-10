public class Cylinder extends Circle {
	private double length;
	private double thickness;

	//constructors:
	//default
	Cylinder() {
		super();
		this.length = 1.0;
		this.thickness = 1.0;
	}
	//Defined Radius
	Cylinder( double r ) {
		super( r );
		this.length = 1.0;
		this.thickness = 1.0;
	}
	//Defined Radius and Length
	Cylinder( double r, double l ) {
		super( r );
		this.length = l;
		this.thickness = 1.0;
	}
	//Defined Radius, length and Thickness
	Cylinder( double r, double l, double t ) {
		super( r );
		this.length = l;
		this.thickness = t;
	}
	//Get + set
	public double getThickness() {
		return this.thickness;
	}
	public void setThickness( double t ) {
		//Lager ikke input handler ettersom det skal brukes GUI;
		this.thickness = t;
	}
	//findVolume, findSurfaceAre, findWeight;
	public double findVolume() {
		return ( super.findArea() * this.length );
	}
	public double findIVolume() {
		return ( super.findArea( this.thickness ) * this.length );
	}
	public double findWeight() {
		return ( ( this.findVolume() - this.findIVolume() ) * super.density );
	}
	public double findSurfaceArea() {
		return ( super.findArea() * 2 + super.findCircumference() * this.length );
	}
	public String toString() {
		return "Cylinder: \n" + super.toString() + "\n Length: " + this.length + "\n Thickness: " + this.thickness + "\n TotVolume: " + this.findVolume()
		+ "\n InnerVolume: " + this.findIVolume() + "\n SurfaceArea: " + this.findSurfaceArea();
	}
}