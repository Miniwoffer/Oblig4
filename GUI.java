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

/*  GUI
 * Version: 1.0
 */

public class GUI extends Application {

	public Group root;
    CylinderDisplay myBoxDisplay;

	@Override
	public void start(Stage stage) { 
		Sphere sphere = new Sphere(100); 
		Sphere sphere2 = new Sphere(50);
        
        myBoxDisplay = new CylinderDisplay();

		root = new Group(sphere, sphere2);

		root.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent t) {
				System.out.println("l");
			}
		});

		Scene scene = new Scene(myBoxDisplay.getGroup(), 600, 600);
		root.setTranslateX(300);
		root.setTranslateY(300);

		PhongMaterial phong = new PhongMaterial(Color.color(1,0,0,0.5));
		//sphere.setMaterial(phong);
		PhongMaterial phong2 = new PhongMaterial(Color.color(0,1,0,0.8));
		sphere2.setMaterial(phong2);



		stage.setTitle("GUIv0");
		stage.setScene(scene);
        stage.setResizable(false);
		stage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
