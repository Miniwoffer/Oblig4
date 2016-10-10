public class Cylinder extends Circle {
	private double length;
	private double thickness;

	//constructors:
	//default
	Cylinder() {
		super();
		this.length = 1.0;
	}
	//Defined Radius
	Cylinder(double r) {
		super(r);
		this.length = 1.0;
	}
	//Defined Radius and Length
	Cylinder(double r, double l) {
		super(r);
		this.length = l;
	}
	//Defined Radius, length and Thickness
	Cylinder(double r, double l, double t) {
		super(r);
		this.length = l;
		this.thickness = t;
	}

	//findVolume, findSurfaceAre, findWeight;
	public double findVolume() {
		return ( super.findArea() * this.length );
	}
	public double findIVolume() {
		return ( super.finnerArea(this.thickness) * this.length );
	}
	public double findWeight() {
		return ( this.findVolume() - (new Cylinder(this.radius - this.thickness).findVolume());
	}
}

/*
this.radius * this.radius * Math.PI  - (this.radius -this.thickness) * (this.radius - this.thickness) * Math.PI)





*/