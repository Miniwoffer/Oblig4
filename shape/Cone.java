import import javafx.scene.shape.TriangleMesh;


public class Cone extends TriangleMesh {
	public double height;
	public double radius;

	private double[] points = new float[66];
	private int[] faces = new int[252];

	Cone(double r, double h) {
		super();
		this.radius = r;
		this.height = h;
	}

	public void draw() {
		this.setPoints();
	}
	protected void setPoints() {
		points[0] = 0;
		points[1] = 0;
		points[2] = -this.height;
		points[3] = 0;
		points[4] = 0;
		points[5] = 0;
		//points 0-2 = top point, 3-5 = bottom center;
		int d = 6;
		for(int i=0; i < 20; i++) {
			//x
			points[d] = (float)Math.cos( i*change )*r;
			d++;
			//y
			points[d] = (float)Math.sin( i*change )*r;
			d++;
			//z
			points[d] = 0;
			d++;
		}
	}
	protected void setFaces() {
		d = 0;
		for( int i=0; i < 21; i++) {
			System.out.println(d);
			if(i == 20) {
				faces[d] = 0; d++; 	//top
				faces[d] = 0; d++;	//tex

				faces[d] = 21; d++;
				faces[d] = 0; d++;
				
				faces[d] = 2; d++;
				faces[d] = 0; d++;
				break;
			}
			faces[d] = 0;
			d++;
			faces[d] = 0;
			d++;
			faces[d] = i+1;
			d++;
			faces[d] = 0;
			d++;
			faces[d] = i+2;
			d++;
			faces[d] = 0;
			d++;
		}
		for(int i = 0; i < 21; i++) {
			System.out.println(d);
			if(i == 20) {
				faces[d] = 1; d++; 	//top
				faces[d] = 0; d++;	//tex

				faces[d] = 2; d++;
				faces[d] = 0; d++;
				
				faces[d] = 21; d++;
				faces[d] = 0; d++;
				break;
			}
			faces[d] = 1;
			d++;
			faces[d] = 0;
			d++;
			faces[d] = i+2;
			d++;
			faces[d] = 0;
			d++;
			faces[d] = i+1;
			d++;
			faces[d] = 0;
			d++;
		}
	}


	public void setHeight( double h ) {

	}
	public double getHeight() {
		return this.height;
	}
	public void setRadius( double r ) {

	}
	public double getRadius() {
		return this.radius;
	}


}