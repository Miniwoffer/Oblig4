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

public class BoxDisplay extends Display {
    geometric.Box myBox;
    Slider sliderWidth;
    Slider sliderHeight;
    Slider sliderLength;
    Slider sliderThickness;

    javafx.scene.shape.Box drawBox;
    javafx.scene.shape.Box innerBox;

    double oldX = 0;
    double oldY = 0;
    double newX = 0;
    double newY = 0;

    Label widthLabel;
    Label heightLabel;
    Label lengthLabel;
    Label thicknessLabel;

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
        widthLabel = new Label("Width");
        widthLabel.setTranslateY(30);
        widthLabel.setTranslateX(30);
        sliderWidth = new Slider(0,200,myBox.getWidth());
        sliderWidth.setShowTickLabels(true);
        sliderWidth.setTranslateY(50);

        heightLabel = new Label("Height");
        heightLabel.setTranslateY(80);
        heightLabel.setTranslateX(40);
        sliderHeight = new Slider(0,200,myBox.getHeight());
        sliderHeight.setShowTickLabels(true);
        sliderHeight.setTranslateY(100);

        lengthLabel = new Label("Length");
        lengthLabel.setTranslateY(130);
        lengthLabel.setTranslateX(40);
        sliderLength = new Slider(0,200,myBox.getLength());
        sliderLength.setShowTickLabels(true);
        sliderLength.setTranslateY(150);

        thicknessLabel = new Label("Thickness");
        thicknessLabel.setTranslateY(180);
        thicknessLabel.setTranslateX(40);
        sliderThickness = new Slider(0,100,myBox.getThickness());
        sliderThickness.setShowTickLabels(true);
        sliderThickness.setTranslateY(200);

        shapeGroup = new Group(
                drawBox,
                innerBox);

        shapeGroup.setTranslateX(300);
        shapeGroup.setTranslateY(300);

        sliderWidth.valueProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> ov, 
            Number old_val, Number new_val) {
                //change(new_val);
                updateAll();
            }
        });
        sliderHeight.valueProperty().addListener(new ChangeListener<Number>() {
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
                sliderThickness,
                thicknessLabel,
                super.methodLabels);

    }
    public void updateAll() {
        DecimalFormat df = new DecimalFormat("#.00");

        PhongMaterial phong = new PhongMaterial(Color.rgb(255,0,0,0.5));
        double l, w, h, t;
        w =  sliderWidth.getValue();
        h = sliderHeight.getValue();
        l = sliderLength.getValue();


        double smallest;
        if( l < h) {
            if( w < l) {
                smallest = w;
            }
            else {
                smallest = l;
            }
        }
        else if(h < w) {
            smallest = h;
        }
        else {
            smallest = w;
        }

        sliderThickness.setMax( smallest / 2 );

        t = sliderThickness.getValue();

        widthLabel.setText("Width: " + df.format(w));
        heightLabel.setText("Height: " + df.format(h));
        lengthLabel.setText("Length: " + df.format(l));      
        thicknessLabel.setText("Thickness: " + df.format(t));  
        //Change myBox(GeometricObject) 
        myBox.setWidth(l);
        myBox.setHeight(w);
        myBox.setLength(h);
        myBox.setThickness(t);

        //Change outer 3D box
        drawBox.setWidth(w);
        drawBox.setDepth(l);
        drawBox.setHeight(h);

        //Change inner 3D box
        innerBox.setWidth(w - t*2);
        innerBox.setDepth(l - t*2);
        innerBox.setHeight(h - t*2);

        //reset Material to force re-draw
        drawBox.setMaterial(phong);

        super.updateAll();
        
    }
}
