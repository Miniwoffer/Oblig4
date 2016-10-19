
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
//import shape.*;

/* BoxDisplay
 * Version: 1.0
 */

public class ConeDisplay extends Display {
    geometric.Cone myCone;
    Slider sliderRadius;
    Slider sliderThickness;

    shape.Cone drawCone;
    shape.Cone innerCone;

    Label radiusLabel;
    Label thicknessLabel;

    public ConeDisplay()
    {
        //Init
        super();

        myCone = new geometric.Cone(100,100);

        super.gob = myCone;

        PhongMaterial phong = new PhongMaterial(Color.color(1,0,0,0.5));
        drawCone = new shape.Cone(myCone.getRadius(), myCone.getLength());
        drawCone.mesh.setMaterial(phong);

        innerCone = new shape.Cone(myCone.getRadius()-myCone.getThickness(), myCone.getLength() - myCone.getThickness()*2);
        innerCone.mesh.setMaterial(phong);

        //From 1 to 10 defualt myBox.value
        radiusLabel = new Label("Radius");
        radiusLabel.setTranslateY(30);
        radiusLabel.setTranslateX(30);
        sliderRadius = new Slider(0,200,myCone.getRadius());
        sliderRadius.setShowTickLabels(true);
        sliderRadius.setTranslateY(50);

        thicknessLabel = new Label("Thickness");
        thicknessLabel.setTranslateY(80);
        thicknessLabel.setTranslateX(40);
        sliderThickness = new Slider(0,100,myCone.getThickness());
        sliderThickness.setShowTickLabels(true);
        sliderThickness.setTranslateY(100);

        shapeGroup = new Group(
                drawCone.mesh,
                innerCone.mesh);

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
        myCone.setRadius(r);
        myCone.setThickness(t);

        //Change outer 3D box
        drawCone.setRadius(r);
        //Change inner 3D box
        innerCone.setRadius(r - t);
        //reset Material to force re-draw
        drawCone.setMaterial(phong);

        super.updateAll();
        
    }
}
