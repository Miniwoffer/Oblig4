public class Oblig4 {
	public static void main(String[] args) {
		Debug.status = true;
		//test object
		Cylinder c = new Cylinder(2, 2, 0.5);
		log(c.toString());

		Cone cone = new Cone(2, 2, 0.5);
		log(cone.toString());

		Ball ball = new Ball(2, 0.5);
		//log(ball.toString());

		String[] functions = {"findArea", "findVolume"};

		Debug.runArr(functions, cone);

		//cone.getClass().getDeclaredMethod("findVolume").invoke(cone);
	}

	public static void log(String msg) {
		System.out.println(msg);
	}
	public static void log(int msg) {
		System.out.println(msg);
	}
}
