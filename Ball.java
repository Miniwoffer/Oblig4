
class Ball extends Circle 
{
    double thickness;
    Ball()
    {
        Ball(5,2);
    }
    Ball(double r,double t)
    {
        super(5);
        thickness = 2;
    }
    double findVolum()
    {
        double innerVolum = 0;
        if(thickness > 0)
        {
            innerVolum = 4/3*Math.PI*Math.pow(radius-thickness,3);
        }
        return 4/3*Math.PI*Math.pow(radius,3)-innerVolum;
    }
    double findSurfaceArea()
    {
        double innerSurface = 0;
        if(thickness > 0)
        {
            innerSurface = 4*Math.PI*Math.pow(radius-thickness,2);
        }
        return 4*Math.PI*Math.pow(radius,2)+innerSurface;
    }
    double findWeight()
    {
        return findVolum()*density;
    }
    void setThickness(double t){thickness = t > 0 && t < radius ? t : 0;}
    double getThickness(){return thickness;}
}
