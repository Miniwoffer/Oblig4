package geometric;

public class Cylinder extends Circle {
	private double length;
	private double thickness;

	//constructors:
	//default
	public Cylinder() {
		super();
		this.length = 1.0;
		this.thickness = 1.0;
	}
	//Defined Radius
	public Cylinder( double r ) {
		super( r );
		this.length = 1.0;
		this.thickness = 1.0;
	}
	//Defined Radius and Length
	public Cylinder( double r, double l ) {
		super( r );
		this.length = l;
		this.thickness = 1.0;
	}
	//Defined Radius, length and Thickness
	public Cylinder( double r, double l, double t ) {
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
	public double getLength() {
		return this.length;
	}
	public void setLength( double l ) {
		this.length = l;
	}
	//findVolume, findSurfaceAre, findWeight;
	public double findVolume() {
		return ( super.findArea() * this.length );
	}
	public double findIVolume() {
		return ( super.findArea( this.thickness ) * ( this.length - this.thickness * 2 ) );
	}
	public double findWeight() {
		return ( ( this.findVolume() - this.findIVolume() ) * super.density );
	}
	public double findSurfaceArea() {
		return ( super.findArea() * 2 + super.findCircumference() * this.length );
	}
	public String toString() {
		return "Cylinder: \n" + super.toString() 
		+ "\n Length: " + this.getLength() 
		+ "\n Thickness: " + this.getThickness()
		+ "\n TotVolume: " + this.findVolume()
		+ "\n InnerVolume: " + this.findIVolume() 
		+ "\n SurfaceArea: " + this.findSurfaceArea();
	}
}
