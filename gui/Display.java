package gui;

import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point3D;
import javafx.scene.transform.Rotate;
import javafx.scene.control.Label;



abstract class Display {

	protected Group shapeGroup;
	protected Group methodLabels;
	protected Group root;
	protected double oldX;
	protected double oldY;
	protected double newX;
	protected double newY;
	protected Label volumeLabel;
	protected Label surfaceAreaLabel;
	protected Label weightLabel;

	protected geometric.GeometricObject gob;


	Display() {


		//

		

	}

	protected void bindRotation() {
		shapeGroup.setOnMouseClicked(new EventHandler<MouseEvent>() 
		{

	        public void handle(MouseEvent t)
	        {
	            oldX = t.getSceneX();
	            oldY = t.getSceneY();
	        }
	    });

	    shapeGroup.setOnMouseDragged(new EventHandler<MouseEvent>() 
	    {
			public void handle(MouseEvent t) 
			{
	           	newX = t.getSceneX();
	           	newY = t.getSceneY();
	            if(oldX == 0)
	            {
	                oldX = newX;
	            oldY = newY;
	            return;
	        }
	        shapeGroup.getTransforms().add(new Rotate(oldX-newX,0,0,0,new Point3D(0,10,0)));
	        shapeGroup.getTransforms().add(new Rotate(oldY-newY,0,0,0,new Point3D(-10,0,0)));
	                //shapeGroup.rx.setAngle(shapeGroup.rx.getAngle() - (oldX-newX));
	                //shapeGroup.ry.setAngle(shapeGroup.ry.getAngle() - (oldY-newY));
            oldX = newX;
			oldY = newY;
	        }
		});
		volumeLabel = new Label("Volume");
        volumeLabel.setTranslateX(300);

		surfaceAreaLabel = new Label("Surface Area");
        surfaceAreaLabel.setTranslateX(300);
        surfaceAreaLabel.setTranslateY(20);
		
		weightLabel = new Label("Weight");
        weightLabel.setTranslateX(300);
        weightLabel.setTranslateY(40);
        weightLabel.setText("Weight: " + gob.findWeight());

        methodLabels = new Group(volumeLabel, surfaceAreaLabel, weightLabel);
	}
	public Group getGroup() {
		return this.root;
	} 
}