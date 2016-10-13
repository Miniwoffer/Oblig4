import java.util.concurrent.Callable;
import java.util.List;
import java.util.ArrayList;
class UnitTest
{
    
    public static void main(String[] args)
    {
        testBall();
    }
    
    static void testBall()
    {
        TestSet<Double> ts = new TestSet<>("Ball get/set test");
        Ball b = new Ball(5,2);
        ts.addTest((Double)(b.getThickness()),2);
        System.println(ts.toString());
        
    }
}

class Test<T>
{
    Test(Callable<T> func,T expectedvalue)
    {
        expected = expectedvalue;
        name = func.toString();
        try
        {
            value = func.call();
            if(expected.equals(value))
                status = "passed";
            else
                status = "not equals";
        }
        catch (Exception e)
        {
            status = e.getMessage();
        }

    }
    String name;
    T expected;
    T value;
    String status;
}
class TestSet<T>
{
    private String name;
    private List<Test<T>> tests;
    private int testspassed;
    TestSet(String name)
    {
        name = name;
        tests = new ArrayList<Test<T>>();
    }
    public String toString()
    {
        String ret = "----------"+name+"----------\n";
        for(int i = 0; i < tests.size();i++)
        {
            ret += tests.get(i).name + " :";

            switch(tests.get(i).status)
            {
                case "passed":
                    testspassed++;
                    ret+= " passed";
                break;
                case "not equals":
                    ret += " failed got " + tests.get(i).value 
                        + " expected " + tests.get(i).expected;
                break;
                default:
                    ret += " unexpected status.";
                break;
            }        
            ret += '\n';
        }
        return ret + testspassed+"/"+tests.size() + " passed.";
    }
    public void addTest(Callable<T> f, T t)
    {
        tests.add(new Test<T>(f,t));
    }
}
