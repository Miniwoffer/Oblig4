package geometric;

public class Ball extends Circle 
{
    double thickness;
    public Ball()
    {
        this(5,2);
    }
    public Ball(double r,double t)
    {
        super(r);
        setThickness(t);
    }
    public double findVolume()
    {
        return 4/3*Math.PI*Math.pow(radius,3);
    }
    double findIVolum()
    {
        if(thickness > 0)
        {
             return 4/3*Math.PI*Math.pow(radius-thickness,3);
        }
        return 0;
    }
    public double findSurfaceArea()
    {
        return 4*Math.PI*Math.pow(radius,2);
    }
    public double findWeight()
    {
        return (findVolume()-findIVolum())*density;
    }
    public void setThickness(double t){thickness = t > 0 && t < radius ? t : 0;}
    public double getThickness(){return thickness;}
}