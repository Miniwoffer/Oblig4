/*
	Bare for moroskyld!
*/
import java.lang.reflect.*;
public class Debug {
	public static boolean status = false;
	public static void run() {
		Thread thread = Thread.currentThread();
		StackTraceElement[] traces = thread.getStackTrace();
		if(status) {
			for( int i = 1 ; i < traces.length; i++ ) {
				System.out.print("-");
			}
			String[] m = dumpClass(StackTraceElement.class);
		
						
			System.out.print("" + traces[2].getClassName());
			// System.out.println("FileName: " + traces[2].getFileName() + " Line: " + traces[2].getLineNumber() 
			// 	+ " Native: " + traces[2].isNativeMethod() + " Hash: " + traces[2].hashCode());

			System.out.println("-" 
			+ traces[3].getClassName() + "." 
			+ traces[3].getMethodName() + "( <- " 
			+ traces[4].getClassName() + "." 
			+ traces[4].getMethodName() + " )" );
		}
	}
	public static void runArr(String[] funcs, Object obj) {
		System.out.println("Debug runArr");
		String[] declared = dumpObj(obj);
		for(String func : funcs) {
			for(String dec : declared) {
				String t = dec.substring(dec.lastIndexOf(".") + 1, dec.indexOf("("));
				//System.out.printf("declared: %-20s function: %-15s Matches: %-15s\n" , t, func, func.equals(t));
				if(func.equals(t)) {
					try {
						System.out.println(func + ": " + obj.getClass().getDeclaredMethod(func).invoke(obj));
					}
					catch(Exception e) {
						System.out.println(e.getStackTrace());
					}
				}
			}
		}
	}
	//returns array with all methods of class as strings.
	public static String[] dumpClass(Class c) {
		Method[] m = c.getDeclaredMethods();
		String[] ret = new String[m.length];
		for(int i = 0; i < m.length; i++) {
			ret[i] = m[i].toString();
		}
		return ret;
	}
	public static String[] dumpObj(Object obj) {
		Method[] m = obj.getClass().getDeclaredMethods();
		String[] ret = new String[m.length];
		for(int i = 0; i < m.length; i++) {
			ret[i] = m[i].toString();
		}
		return ret;
	}

}