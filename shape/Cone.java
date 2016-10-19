import javafx.scene.shape.TriangleMesh;
import javafx.scene.shape.MeshView;


public class Cone extends MeshView {
	private double height;
	private double radius;
	private double change = (Math.PI * 2) / 20;

	private float[] points = new float[66];
	private int[] faces = new int[252];

	TriangleMesh triMesh = new TriangleMesh();

	Cone(double r, double h) {
		super();
		//System.out.println("Something:" + this.toString()); //// runtime error, ClassNotFound;
		this.radius = r;
		this.height = h;
		this.draw();
	}

	public void draw() {
		this.triMesh.getTexCoords().clear();
		this.triMesh.getPoints().clear();
		this.triMesh.getFaces().clear();
		this.triMesh.getTexCoords().addAll(0,0);
		this.setPoints();
		this.setFaces();
	}
	protected void setPoints() {
		points[0] = 0;
		points[1] = 0;
		points[2] = (float)-this.height;
		points[3] = 0;
		points[4] = 0;
		points[5] = 0;
		//points 0-2 = top point, 3-5 = bottom center;
		int d = 6;
		for(int i=0; i < 20; i++) {
			//x
			points[d] = ( float ) Math.cos( i * this.change ) * (float) this.radius;
			d++;
			//y
			points[d] = ( float ) Math.sin( i * this.change ) * (float) this.radius;
			d++;
			//z
			points[d] = 0;
			d++;
		}
		this.triMesh.getPoints().addAll(this.points);
	}
	protected void setFaces() {
		int d = 0;
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
		this.triMesh.getFaces().addAll(this.faces);
	}


	public void setHeight( double h ) {
		this.height = h;
		this.draw();
	}
	public double getHeight() {
		return this.height;
	}
	public void setRadius( double r ) {
		this.radius = r;
		this.draw();
	}
	public double getRadius() {
		return this.radius;
	}
}