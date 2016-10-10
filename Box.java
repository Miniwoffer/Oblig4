/* Box class
 * ver 1.0
 */

class Box extends Rectangle
{
    private double length;
    private double thickness;
    Box(){this(5,5,5,2);}
    Box(double w, double h, double l, double t)
    {
        super(w,h);
        length = l;
        thickness = t;
    }
    void setLength(double l){length = l > 0 ? l : l * -1;}
    void setThickness(double t)
    {
        if(t < 0)
            t *= -1;
        if(t >= length/2 || t >= getWidth()/2 || t >= getHeight()/2)
            t = 0;
        thickness = t;
    } 
    double getLength(){return length;}
    double getThickness(){return thickness;}

    double findVolum()
    {
        double innerVol = 0;
        if(thickness > 0)
        {
            double t2 = thickness*2;
            Box innerBox = new Box(getWidth()-t2,getHeight()-t2,length-t2,0);
            innerVol = innerBox.findVolum();
        }
        return getWidth()*getHeight()*length-innerVol;
    }
    double findSurfaceArea()
    {
        double innerSurface = 0;
        if(thickness > 0)
        {
            double t2 = thickness*2;
            Box innerBox = new Box(getWidth()-t2,getHeight()-t2,length-t2,0);
            innerSurface = innerBox.findSurfaceArea();
        }
        return 2*(getWidth()*getHeight()+getWidth()*length+getHeight()*length) + innerSurface;
    }
    double findWeight()
    {
        return findVolum()*density;
    }
    
}
