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
        Ball b = new Ball(5,2);
        System.out.println(b.toString());
    }
}

