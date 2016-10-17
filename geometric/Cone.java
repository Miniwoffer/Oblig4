package geometric;

public class Cone extends Circle {
	private double length;
	private double thickness;

	public Cone() {
		super();
		this.length = 1.0;
		this.thickness = 1.0;
	}
	public Cone( double r ) {
		super( r );
		this.length = 1.0;
		this.thickness = 1.0;
	}
	public Cone( double r, double l ) {
		super( r );
		this.length = l;
		this.thickness = 1.0;
	}
	public Cone( double r, double l, double t) {
		super( r );
		this.length = l;
		this.thickness = t;
	}




	public double getThickness() {
		return this.thickness;
	}
	public void setThickness( double t ) {
		//Lager ikke input handler ettersom det skal brukes GUI;
		this.thickness = t;
	}

	//findVolume, findSurfaceAre, findWeight;
	public double findVolume() {
		return ( (1 / 3.0) * super.findArea() * this.length );
	}
	public double findIVolume() {
		//Tavle:
        double l = length - thickness - thickness*Math.sqrt(4*Math.pow(length/(radius*2),2) + 1);
        double r = l*radius/length;
        return (1/3.0) * Math.PI * Math.pow(r,2) * l;
		//return ( super.findArea( this.thickness ) * (this.length - this.thickness * 2) );
	}
	public double findWeight() {
		return ( ( this.findVolume() - this.findIVolume() ) * super.density );
	}
	public double findSurfaceArea() {
		return ( super.findArea() * 2 + super.findCircumference() * this.length );
	}
	public String toString() {
		return "Cone: \n" + super.toString() 
		+ "\n Length: " + this.length  
		+ "\n Thickness: " + this.thickness 
		+ "\n TotVolume: " + this.findVolume()
		+ "\n InnerVolume: " + this.findIVolume() 
		+ "\n SurfaceArea: " + this.findSurfaceArea();
    }
   
}
