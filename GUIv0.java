import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class GUIv0 extends Application {

	@Override
	public void start(Stage stage) {
		Scene scene = new Scene(200, 200);

		stage.setTitle("GUIv0");
		stage.setScene(scene);
	}

	public static void main(String[] args) {
		launch(args);
	}
}

