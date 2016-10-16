package gui;

/* import geometric.Box;
import javafx.scene.shape.Box;*/
import javafx.scene.transform.Rotate;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.control.Slider;
import javafx.scene.control.Label;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import java.util.EventListener;
import javafx.event.EventHandler;
/* BoxDisplay
 * Version: 1.0
 */

public class BoxDisplay{
    geometric.Box myBox;
    Group myGroup;
    Group shapeGroup;
    Slider myWidth;
    Slider myHeight;
    Slider myLength;
    Slider myThickness;

    javafx.scene.shape.Box drawBox;
    javafx.scene.shape.Box innerBox;

    double oldX = 0;
    double oldY = 0;
    double newX = 0;
    double newY = 0;
    public BoxDisplay()
    {
        myBox = new geometric.Box(100,100,100,10);

        PhongMaterial phong = new PhongMaterial(Color.color(1,0,0,0.5));
        drawBox = new javafx.scene.shape.Box(
                myBox.getWidth(),
                myBox.getHeight(),
                myBox.getLength());
        drawBox.setMaterial(phong);

        double thickness = myBox.getThickness()*2;
        innerBox = new javafx.scene.shape.Box(
                myBox.getWidth()-thickness,
                myBox.getHeight()-thickness,
                myBox.getLength()-thickness);
        innerBox.setMaterial(phong);

        //From 1 to 10 defualt myBox.value
        Label widthLabel = new Label("Width");
        widthLabel.setTranslateY(30);
        myWidth = new Slider(1,200,myBox.getWidth());
        myWidth.setTranslateY(40);

        Label heightLabel = new Label("Height");
        heightLabel.setTranslateY(70);
        myHeight = new Slider(1,200,myBox.getHeight());
        myHeight.setTranslateY(80);

        Label lengthLabel = new Label("Length");
        lengthLabel.setTranslateY(110);
        myLength = new Slider(1,200,myBox.getLength());
        myLength.setTranslateY(120);

        Label thicknessLabel = new Label("Thickness");
        thicknessLabel.setTranslateY(150);
        myThickness = new Slider(1,200,myBox.getThickness());
        myThickness.setTranslateY(160);

        shapeGroup = new Group(
                drawBox,
                innerBox);
        shapeGroup.setTranslateX(300);
        shapeGroup.setTranslateY(300);

       shapeGroup.setOnMouseClicked(new EventHandler<MouseEvent>() {

           public void handle(MouseEvent t)
           {
                oldX = t.getSceneX();
                oldY = t.getSceneY();
           }
        });

        shapeGroup.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
                newX = t.getSceneX();
                newY = t.getSceneY();
                if(oldX == 0)
                {
                    oldX = newX;
                    oldY = newY;
                    return;
                }
                shapeGroup.getTransforms().add(new Rotate(oldX-newX,0,0,0,new Point3D(0,10,0)));
                shapeGroup.getTransforms().add(new Rotate(oldY-newY,0,0,0,new Point3D(-10,0,0)));

                //shapeGroup.rx.setAngle(shapeGroup.rx.getAngle() - (oldX-newX));
                //shapeGroup.ry.setAngle(shapeGroup.ry.getAngle() - (oldY-newY));
                oldX = newX;
                oldY = newY;
				
            }
		});
        myGroup = new Group(
                shapeGroup,
                myWidth,
                widthLabel,
                myHeight,
                heightLabel,
                myLength,
                lengthLabel,
                myThickness,
                thicknessLabel);
    }
    public Group getGroup()
    {
        return myGroup;
    }
    void updateThickness()
    {

    }
}
