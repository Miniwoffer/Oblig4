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

	//public Group root;
    CylinderDisplay myCylinderDisplay;
    BoxDisplay myBoxDisplay;
    static Stage stage;
    int selection = 1;

    static Scene[] scenes = new Scene[4];

	@Override
	public void start(Stage primaryStage) { 

		stage = primaryStage;

        myCylinderDisplay = new CylinderDisplay();
        myBoxDisplay = new BoxDisplay();
        

        scenes[0] = new Scene(myBoxDisplay.getGroup(), 600, 600);
		scenes[1] = new Scene(myCylinderDisplay.getGroup(), 600, 600);

		stage.setTitle("GUI");
        stage.setResizable(false);
		//change scene -> shape
		changeDisplay(1);
	}
	public static void main(String[] args) {
		launch(args);
	}
	public static void changeDisplay(int s) {
		//0 = box, 1 = cylinder, 2 = ball, 3 = cone
		try {
			stage.setScene( scenes[ s ] );
			stage.show();
		}
		catch( Exception e ) {
			System.out.println( e.getMessage() );
		}
	}
}
