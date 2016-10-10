import java.util.Scanner;

public class Oblig4v2 {
	public static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		log("Radius:");
		double r = scanner.nextDouble();
		log("Height:");
		double h = scanner.nextDouble();
		log("Thickness:");
		double t = scanner.nextDouble();
		Cylinder cylinder = new Cylinder(r, h, t);

		log("Cylinder:");
		log("Area:\t\t" + cylinder.findArea());
		log("Circumference:\t" + cylinder.findCircumference());
		log("Volume:\t\t" + cylinder.findInnerVolume());
		log("Weight \t\t" + cylinder.findWeight() + "KG");
		log("SurfaceArea:\t" + Math.round(cylinder.findSurfaceArea() * 100)/100); 
		log("thickness:\t" + cylinder.thickness);
		log("CenterRadius: \t" + cylinder.centerRadius);
	}
	public static void log(String msg) {
		System.out.println(msg);
	}
	public static void log(int msg) {
		System.out.println(msg);
	}
	public static void log(double msg) {
		System.out.println(msg);
	}
	public static Double inputThickness(String prompt, double min, double max) {
		String inp;
		Double number;
		log(prompt);
		scanner.nextLine();
		do {
			inp = scanner.nextLine();
			try {
				number = Double.parseDouble(inp);
				if(number < min) {
					log( "Input must be more than " + min );
				}
				else if(number > max) {
					log( "Input can not be more than " + max );
				}
				else {
					return number;
				}
			}
			catch( NumberFormatException e) {
				log( "You may only enter a number! try again:" );
			}
		} while(true);
	}
}


abstract class GeometricObject {
	protected double density = 7.8; //in dm, *1000 for cm;
	protected double thickness;

	GeometricObject() {
		this.thickness = 0;
	}
	GeometricObject(double t) {
		this.thickness = t;
	}

	public double getThickness() {
		return this.thickness;
	}
	public void setThickness(double t) {
		this.thickness = t;
	}

	abstract double findArea();
	abstract double findVolume();
	abstract double findCircumference();
	abstract double findSurfaceArea();
	abstract double findWeight();
}

abstract class Circle extends GeometricObject {
	protected double radius;
	protected double centerRadius;
	Circle() {
		super();
		this.radius = 1.0;
		this.setCenterRadius();
	}
	Circle(double r) {
		super();
		this.radius = r;
		this.setCenterRadius();
	}
	Circle(double r, double t) {
		super(t);
		this.radius = r;
		this.setCenterRadius();
	}

	public double getRadius() {
		return this.radius;
	}
	public double getCenterRadius() {
		return this.centerRadius;
	}
	public void setRadius(double r) {
		this.radius = r;
	}
	private void setCenterRadius() {
		System.out.println("Setting center radius");
		if(this.radius > this.thickness) {
			this.centerRadius = this.radius - this.thickness;	
		}
		else {
			//Prompt new thinkness input;
			Oblig4v2.log( "Bitch please" );
			this.thickness = Oblig4v2.inputThickness( "Thickness can not be more than radius! try again:", 0, this.radius );
			this.centerRadius = this.radius - this.thickness;

		}
		
	}
	public double findArea() {
		return ( this.radius * this.radius ) * Math.PI;
	}
	public double findCenterArea() {
		return ( this.centerRadius * this.centerRadius ) * Math.PI;	
	}
	public double findCircumference() {
		return ( this.radius * 2 ) * Math.PI;
	}
}


class Cylinder extends Circle{
	private double height;
	private double innerHeight;

	Cylinder() {
		super();
	}
	Cylinder(double r) {
		super(r);
	}
	Cylinder(double r, double h) {
		super(r);
		this.height = h;
	}
	Cylinder(double r, double h, double t) {
		super(r, t);
		this.height = h;
	}

	public double findSurfaceArea() {
		return (2 * super.findArea()) + (2 * Math.PI * this.getRadius() * this.height); 
	}
	//Checked, working
	public double findVolume() {
		return super.findArea() * this.height;
	}
	public double findInnerVolume() {
		return super.findCenterArea() * this.height;
	}
	public double findWeight() {
		return (this.findVolume() - this.findInnerVolume()) * this.density;
	}
}