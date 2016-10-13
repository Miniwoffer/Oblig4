public class Oblig4 {
	public static void main(String[] args) {
		//test object
		Cylinder c = new Cylinder(2, 2, 0.5);
		log(c.toString());

		Cone cone = new Cone(1, 1, 0.5);
		log(cone.toString());
	}


	public static void log(String msg) {
		System.out.println(msg);
	}
	public static void log(int msg) {
		System.out.println(msg);
	}
}
