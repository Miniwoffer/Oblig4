package geometric;

/* Box class
 * ver 1.0
 */

public class Box extends Rectangle
{
    private double length;
    private double thickness;
    public Box()
    {
        this(5,5,5,2);
    }
    public Box(double w, double h, double l, double t)
    {
        super(w,h);
        length = l;
        thickness = t;
    }
    public void setLength(double l)
    {
        length = l;
    }
    public void setThickness(double t)
    {
        thickness = t;
    } 
    public double getLength(){return length;}
    public double getThickness(){return thickness;}

    public double findVolume()
    {
        return width*height*length;
    }
    double findIVolume()
    {
        if(thickness > 0)
        {
            double t2 = thickness*2;
            Box innerBox = new Box(width-t2,height-t2,length-t2,0);
            return innerBox.findVolume();
        }
        return 0;
    }
    public double findSurfaceArea()
    {
        return 2*(width*height+width*length+height*length);
    }
    public double findWeight()
    {
        return (findVolume()-findIVolume())*density;
    }
    public String toString()
    {
        return "Box: \n" + 
            super.toString() + 
            "\n Length: " + length +
            "\n Thickness: " + thickness +
            "\n TotVolume: " + findVolume() +
            "\n InnerVolume: " + findIVolume() +
            "\n SurfaceArea: " + findSurfaceArea();
    }
    
}
