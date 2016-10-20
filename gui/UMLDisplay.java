package gui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Group;
import javafx.geometry.Insets;




public class UMLDisplay extends Display {
	public UMLDisplay() {
		Image img = new Image("images/UML.png");
		ImageView view = new ImageView();
		view.setImage(img);
		view.setY(30);
		view.setFitHeight(570);
		view.setFitWidth(600);
		//view.setPadding(new Insets(40, 0,0,0));

		root = new Group(view);
	}
}