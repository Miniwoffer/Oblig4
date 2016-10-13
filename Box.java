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
        if(t >= length/2 || t >= width/2 || t >= height/2)
            t = 0;
        thickness = t;
    } 
    double getLength(){return length;}
    double getThickness(){return thickness;}

    double findVolume()
    {
        return width*height*length;
    }
    double findSurfaceArea()
    {
        return 2*(width*height+width*length+height*length);
    }
    double findWeight()
    {
        double innerVol = 0;
        if(thickness > 0)
        {
            double t2 = thickness*2;
            Box innerBox = new Box(width-t2,height-t2,length-t2,0);
            innerVol = innerBox.findVolume();
        }

        return (findVolume()-innerVol)*density;
    }
    
}
