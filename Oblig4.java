import geometric.*;

public class Oblig4 {
	public static void main(String[] args) {
		Debug.status = true;
		//test object
		Cylinder c = new Cylinder(2, 2, 0.5);
		Cone cone = new Cone(2, 2, 0.5);
		Ball ball = new Ball(2, 0.5);
        Box box = new Box(5,5,5,2);

		String[] functions = {"toString"};
		Object[] obs = {c, cone, ball, box};

		for(Object o : obs) {
			Debug.runArr(functions, o);	
		}
		

	}

	public static void log(String msg) {
		System.out.println(msg);
	}
	public static void log(int msg) {
		System.out.println(msg);
	}
}
