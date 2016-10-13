/* Rectangle abstract class
 * Ver 1.0
 */

abstract class Rectangle extends GeometricObject
{
    protected double width;
    protected double height;
    
    Rectangle(){this(5,5);}
    Rectangle(double w, double h)
    {
        width = w;
        height = h;
    }

    //sets the width to a possitive version of w
    void setWidth(double w){width = w > 0 ? w : w * -1;}
    
    //sets the height to a possitive version of h
    void setHeight(double h){height = h > 0 ? h : h * -1;}
    
    double getWidth(){return width;}

    double getHeight(){return height;}

    //returns the area of the Rectangle
    double findArea(){return width*height;}
    
    //returns the circumfirance of the Rectangle by multiplying the biggest of 
    //height and width with 2*PI
    double findCircumference(){return 2*(width+height);}
}
