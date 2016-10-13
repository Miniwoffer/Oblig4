
class Ball extends Circle 
{
    double thickness;
    Ball()
    {
        this(5,2);
    }
    Ball(double r,double t)
    {
        super(5);
        thickness = 2;
    }
    double findVolume()
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
    double findSurfaceArea()
    {
        return 4*Math.PI*Math.pow(radius,2);
    }
    double findWeight()
    {
        return (findVolume()-findIVolum())*density;
    }
    void setThickness(double t){thickness = t > 0 && t < radius ? t : 0;}
    double getThickness(){return thickness;}
}
