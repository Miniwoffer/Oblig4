package gui;

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

public class CylinderDisplay extends Display {
    geometric.Cylinder myCyl;
    Slider sliderRadius;
    //Slider sliderHeight;
    Slider sliderLength;
    Slider sliderThickness;

    javafx.scene.shape.Cylinder drawBox;
    javafx.scene.shape.Cylinder innerBox;

    double oldX = 0;
    double oldY = 0;
    double newX = 0;
    double newY = 0;

    Label radiusLabel;
    Label lengthLabel;
    Label thicknessLabel;

    public CylinderDisplay()
    {
        //Init
        super();

        myCyl = new geometric.Cylinder(100,100,10);

        super.gob = myCyl;

        PhongMaterial phong = new PhongMaterial(Color.color(1,0,0,0.5));
        drawBox = new javafx.scene.shape.Cylinder(
                myCyl.getLength(),
                myCyl.getRadius());
        drawBox.setMaterial(phong);

        double thickness = myCyl.getThickness()*2;
        innerBox = new javafx.scene.shape.Cylinder(
                myCyl.getLength()-thickness,
                myCyl.getRadius()-thickness);
        innerBox.setMaterial(phong);

        //From 1 to 10 defualt myCyl.value
        radiusLabel = new Label("Width");
        radiusLabel.setTranslateY(30);
        radiusLabel.setTranslateX(30);
        sliderRadius = new Slider(0,200,myCyl.getRadius());
        sliderRadius.setShowTickLabels(true);
        sliderRadius.setTranslateY(50);

        lengthLabel = new Label("Length");
        lengthLabel.setTranslateY(80);
        lengthLabel.setTranslateX(40);
        sliderLength = new Slider(0,200,myCyl.getLength());
        sliderLength.setShowTickLabels(true);
        sliderLength.setTranslateY(100);

        thicknessLabel = new Label("Thickness");
        thicknessLabel.setTranslateY(130);
        thicknessLabel.setTranslateX(40);
        sliderThickness = new Slider(0,100,myCyl.getThickness());
        sliderThickness.setShowTickLabels(true);
        sliderThickness.setTranslateY(150);

        shapeGroup = new Group(
                drawBox,
                innerBox);

        shapeGroup.setTranslateX(300);
        shapeGroup.setTranslateY(300);

        sliderRadius.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov, 
            Number old_val, Number new_val) {
                //change(new_val);
                updateAll();
            }
        });
        sliderLength.valueProperty().addListener(new ChangeListener<Number>() {
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
        //drawBox.setWidth(50).bind( sliderRadius.getValue());

        super.bindRotation();

        root = new Group(
                shapeGroup,
                sliderRadius,
                radiusLabel,
                sliderLength,
                lengthLabel,
                sliderThickness,
                thicknessLabel,
                super.methodLabels);

    }
    public void updateAll() {
        DecimalFormat df = new DecimalFormat("#.00");

        PhongMaterial phong = new PhongMaterial(Color.rgb(255,0,0,0.5));
        double l, r, t;
        r =  sliderRadius.getValue();
        l = sliderLength.getValue();


        double smallest;
        smallest = (l < r) ? l : r;

        sliderThickness.setMax( smallest / 2 );

        t = sliderThickness.getValue();

        radiusLabel.setText("Radius: " + df.format(r));
        lengthLabel.setText("Length: " + df.format(l));
        thicknessLabel.setText("Thickness: " + df.format(t));        
        //Change myCyl(GeometricObject) 
        myCyl.setRadius(r);
        myCyl.setLength(l);
        myCyl.setThickness(t);

        //Change outer 3D box
        drawBox.setRadius(r);
        drawBox.setHeight(l);

        //Change inner 3D box
        innerBox.setRadius(r - t*2);
        innerBox.setHeight(l - t*2);

        //reset Material to force re-draw
        drawBox.setMaterial(phong);

        super.updateAll();
        
    }
}
