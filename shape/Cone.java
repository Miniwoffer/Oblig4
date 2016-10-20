package shape;
import javafx.scene.shape.TriangleMesh;
import javafx.scene.shape.MeshView;


public class Cone extends MeshView {
	private double height;
	private double radius;
	private double change = (Math.PI * 2) / 20;

	private float[] points = new float[66];
	private int[] faces = new int[252];

	//new trimesh for mesh defining
	TriangleMesh triMesh = new TriangleMesh();
	public MeshView mesh;

	public Cone(double r, double h) {
		super();
		this.radius = r;
		this.height = h;
		this.draw();
	}

	public void draw() {
		//reset mesh (clear)
		this.triMesh.getTexCoords().clear();
		this.triMesh.getPoints().clear();
		this.triMesh.getFaces().clear();
		//set new tex, points and faces to mesh;
		this.triMesh.getTexCoords().addAll(0,0);
		this.setPoints();
		this.setFaces();
		//set mesh to MeshVeiw of trimesh for usage in Group.
		this.mesh = new MeshView(this.triMesh);
	}
	protected void setPoints() {
		//set top and bottom-center point
		points[0] = 0;
		points[1] = 0;
		points[2] = (float)this.height;
		points[3] = 0;
		points[4] = 0;
		points[5] = 0;
		//points 0-2 = top point, 3-5 = bottom center;
		int pointsIndex = 6;
		//Set points
		for( int i = 0; i < 20; i++ ) {
			//x
			points[pointsIndex] = ( float ) Math.cos( i * this.change ) * (float) this.radius;
			pointsIndex++;
			//y
			points[pointsIndex] = ( float ) Math.sin( i * this.change ) * (float) this.radius;
			pointsIndex++;
			//z
			points[pointsIndex] = 0;
			pointsIndex++;
		}
		//add points to trimesh.
		this.triMesh.getPoints().addAll(this.points);
	}
	protected void setFaces() {
		int facesIndex = 0;
		for( int i = 1; i < 21; i++) {
			if(i == 20) {
				faces[facesIndex] = 0; facesIndex++; 	//top
				faces[facesIndex] = 0; facesIndex++;	//tex

				faces[facesIndex] = 21; facesIndex++;
				faces[facesIndex] = 0;  facesIndex++;
				
				faces[facesIndex] = 2; facesIndex++;
				faces[facesIndex] = 0; facesIndex++;
			}
            else{
			    faces[facesIndex] = 0;
			    facesIndex++;
			    faces[facesIndex] = 0;
			    facesIndex++;
			    faces[facesIndex] = i+1;
			    facesIndex++;
			    faces[facesIndex] = 0;
			    facesIndex++;
			    faces[facesIndex] = i+2;
			    facesIndex++;
			    faces[facesIndex] = 0;
			    facesIndex++;
            }
		}
		for(int i = 1; i < 21; i++) {
			if(i == 20) {
				faces[facesIndex] = 1; facesIndex++; 	//bottom
				faces[facesIndex] = 0; facesIndex++;	//tex

				faces[facesIndex] = 2; facesIndex++;
				faces[facesIndex] = 0; facesIndex++;
				
				faces[facesIndex] = 21; facesIndex++;
				faces[facesIndex] = 0;  facesIndex++;
			}
            else
            {
			    faces[facesIndex] = 1; facesIndex++;
			    faces[facesIndex] = 0; facesIndex++;

			    faces[facesIndex] = i+2; facesIndex++;
			    faces[facesIndex] = 0;   facesIndex++;

			    faces[facesIndex] = i+1; facesIndex++;
			    faces[facesIndex] = 0;   facesIndex++;
            }
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
