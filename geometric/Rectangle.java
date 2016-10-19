//Barebone 3D objects based on a Rectangle
package geometric;

abstract class Rectangle extends GeometricObject
{
    protected double width;
    protected double height;
    //Constructors
    public Rectangle(){this(5,5);}
    public Rectangle(double w, double h)
    {
        width = w;
        height = h;
    }

    //sets the width to a possitive version of w
    public void setWidth(double w){width = w > 0 ? w : w * -1;}
    
    //sets the height to a possitive version of h
    public void setHeight(double h){height = h > 0 ? h : h * -1;}
    
    public double getWidth(){return width;}

    public double getHeight(){return height;}

    //returns the area of the Rectangle
    public double findArea(){return width*height;}

    //returns the circumfirance of the Rectangle by multiplying the biggest of 
    //height and width with 2*PI
    public double findCircumference(){return 2*(width+height);}

    public String toString() {
        return " Density: " + super.density +
            "\n Width: " + width +
            "\n Height: " + height;
    }
}
