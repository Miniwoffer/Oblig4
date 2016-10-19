
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
import java.text.DecimalFormat;


/* BoxDisplay
 * Version: 1.0
 */

public class BallDisplay extends Display {
    geometric.Ball myBall;
    Slider sliderRadius;
    Slider sliderThickness;

    javafx.scene.shape.Sphere drawBall;
    javafx.scene.shape.Sphere innerBall;

    Label radiusLabel;
    Label thicknessLabel;

    public BallDisplay()
    {
        //Init
        super();

        myBall = new geometric.Ball(100,25);

        super.gob = myBall;

        PhongMaterial phong = new PhongMaterial(Color.color(1,0,0,0.5));
        drawBall = new javafx.scene.shape.Sphere(myBall.getRadius());
        drawBall.setMaterial(phong);

        innerBall = new javafx.scene.shape.Sphere(myBall.getRadius()-myBall.getThickness());
        innerBall.setMaterial(phong);

        //From 1 to 10 defualt myBox.value
        radiusLabel = new Label("Radius");
        radiusLabel.setTranslateY(30);
        radiusLabel.setTranslateX(30);
        sliderRadius = new Slider(0,200,myBall.getRadius());
        sliderRadius.setShowTickLabels(true);
        sliderRadius.setTranslateY(50);

        thicknessLabel = new Label("Thickness");
        thicknessLabel.setTranslateY(80);
        thicknessLabel.setTranslateX(40);
        sliderThickness = new Slider(0,100,myBall.getThickness());
        sliderThickness.setShowTickLabels(true);
        sliderThickness.setTranslateY(100);

        shapeGroup = new Group(
                drawBall,
                innerBall);

        shapeGroup.setTranslateX(300);
        shapeGroup.setTranslateY(300);

        sliderRadius.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov, 
            Number old_val, Number new_val) {
                //change(new_val);
                updateAll();
            }
        });
        sliderThickness.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov, 
            Number old_val, Number new_val) {
                //change(new_val);
                updateAll();
            }
        });
        //drawBox.setWidth(50).bind( sliderWidth.getValue());

        super.bindRotation();

        root = new Group(
                shapeGroup,
                sliderRadius,
                radiusLabel,
                sliderThickness,
                thicknessLabel,
                super.methodLabels);

    }
    public void updateAll() {
        DecimalFormat df = new DecimalFormat("#.00");

        PhongMaterial phong = new PhongMaterial(Color.rgb(255,0,0,0.5));
        double r,t;
        r =  sliderRadius.getValue();

        sliderThickness.setMax(r);

        t = sliderThickness.getValue();

        radiusLabel.setText("Radius: " + df.format(r));    
        thicknessLabel.setText("Thickness: " + df.format(t));  
        //Change myBox(GeometricObject) 
        myBall.setRadius(r);
        myBall.setThickness(t);

        //Change outer 3D box
        drawBall.setRadius(r);
        //Change inner 3D box
        innerBall.setRadius(r - t);
        //reset Material to force re-draw
        drawBall.setMaterial(phong);

        super.updateAll();
        
    }
}
