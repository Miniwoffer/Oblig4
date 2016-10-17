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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

/* BoxDisplay
 * Version: 1.0
 */

public class BoxDisplay extends Display {
    geometric.Box myBox;
    Slider sliderWidth;
    Slider sliderHeight;
    Slider sliderLength;
    Slider myThickness;

    javafx.scene.shape.Box drawBox;
    javafx.scene.shape.Box innerBox;

    double oldX = 0;
    double oldY = 0;
    double newX = 0;
    double newY = 0;


    public BoxDisplay()
    {
        //Init
        super();

        myBox = new geometric.Box(100,100,100,10);

        super.gob = myBox;

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
        sliderWidth = new Slider(1,200,myBox.getWidth());
        sliderWidth.setTranslateY(40);

        Label heightLabel = new Label("Height");
        heightLabel.setTranslateY(70);
        sliderHeight = new Slider(1,200,myBox.getHeight());
        sliderHeight.setTranslateY(80);

        Label lengthLabel = new Label("Length");
        lengthLabel.setTranslateY(110);
        sliderLength = new Slider(1,200,myBox.getLength());
        sliderLength.setTranslateY(120);

        Label thicknessLabel = new Label("Thickness");
        thicknessLabel.setTranslateY(150);
        myThickness = new Slider(1,200,myBox.getThickness());
        myThickness.setTranslateY(160);

        shapeGroup = new Group(
                drawBox,
                innerBox);

        shapeGroup.setTranslateX(300);
        shapeGroup.setTranslateY(300);

        sliderWidth.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov, 
            Number old_val, Number new_val) {
                //change(new_val);
                drawBox.setWidth((double) new_val);
            }
        });
        //drawBox.setWidth(50).bind( sliderWidth.getValue());

        super.bindRotation();

        root = new Group(
                shapeGroup,
                sliderWidth,
                widthLabel,
                sliderHeight,
                heightLabel,
                sliderLength,
                lengthLabel,
                myThickness,
                thicknessLabel,
                super.methodLabels);

    }
}
