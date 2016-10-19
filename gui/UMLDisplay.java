package gui;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.Group;



public class UMLDisplay extends Display {
	public UMLDisplay() {
		Image img = new Image("images/UML.png");
		ImageView view = new ImageView();
		view.setImage(img);

		root = new Group(view);
	}
}