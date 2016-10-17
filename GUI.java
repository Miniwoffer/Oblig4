import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.scene.shape.Sphere;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.AmbientLight;
import javafx.scene.PointLight;
import javafx.scene.paint.Color;
import javafx.scene.input.MouseEvent;
import java.util.EventListener;
import javafx.event.EventHandler;
import gui.*;
import javafx.scene.control.ComboBox;
import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.layout.Pane;
import java.util.EventListener;
import javafx.event.EventHandler;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;


/*  GUI
 * Version: 1.0
 */

public class GUI extends Application {
    //Difrent displays
    Group[] disps;
    //CylinderDisplay myCylinderDisplay;
    //BoxDisplay myBoxDisplay;


    //Root group
    Pane root;
    //Scene
    Scene scene;
    //Display selector
    ComboBox dispSelector;
    //disp list
    static ObservableList<String> displays =
        FXCollections.observableArrayList(
                "Box",
                "Cylinder",
                "Ball",
                "Cone"
                );

	public void start(Stage stage) { 
        disps = new Group[3];
        disps[0] = new BoxDisplay().getGroup();
        disps[1] = new CylinderDisplay().getGroup();
        disps[2] = new BallDisplay().getGroup();
        dispSelector = new ComboBox<String>(displays);
        dispSelector.setValue(displays.get(0));
        root = new Pane();
        root.getChildren().addAll(dispSelector);

        dispSelector.valueProperty().addListener(new ChangeListener<String>() {
            public void changed(ObservableValue<? extends String> ov, String old_val, String new_val) {
                updateDisplay(new_val);
            }});


        scene = new Scene(root,600,600); 
        updateDisplay("Box");
        stage.setScene(scene);
		stage.setTitle("GUI");
        stage.setResizable(false);
        stage.show();
    }
	public static void main(String[] args) {
		launch(args);
	}
	public void updateDisplay(String disp) {
        Group dispGroup;
        if(root.getChildren().size() > 1)
            root.getChildren().remove(1,2);
        switch(disp)
        {
            case "Box":
                dispGroup = disps[0];
            break;
            case "Cylinder":
                dispGroup = disps[1];
            break;
            case "Ball":
                dispGroup = disps[2];
            break;
            default:
                dispGroup = disps[0];
            break;
        }
		root.getChildren().addAll(dispGroup);
	}
}
