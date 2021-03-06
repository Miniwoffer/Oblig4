package gui;

import javafx.scene.Group;
import javafx.scene.input.MouseEvent;
import javafx.event.EventHandler;
import javafx.geometry.Point3D;
import javafx.scene.transform.Rotate;
import javafx.scene.control.Label;



public abstract class Display {

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


	public Display() {}

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
	        shapeGroup.getTransforms().add(new Rotate(newX-oldX,0,0,0,
                        shapeGroup.sceneToLocal(300,0,0)));

	        shapeGroup.getTransforms().add(new Rotate(oldY-newY,0,0,0,
                        shapeGroup.sceneToLocal(new Point3D(0,300,0))));
	                //shapeGroup.rx.setAngle(shapeGroup.rx.getAngle() - (oldX-newX));
	                //shapeGroup.ry.setAngle(shapeGroup.ry.getAngle() - (oldY-newY));
            oldX = newX;
			oldY = newY;
	        }
		});
		//Output labels
		volumeLabel = new Label("Volume:\t\t" + (int)gob.findVolume() + "\t dm^3");
        volumeLabel.setTranslateX(300);

		surfaceAreaLabel = new Label("Surface Area:\t" + (int)gob.findSurfaceArea() + "\t dm^2");
        surfaceAreaLabel.setTranslateX(300);
        surfaceAreaLabel.setTranslateY(20);
		
		weightLabel = new Label("Weight:\t\t" + (int)gob.findWeight() + "\t Kg");
        weightLabel.setTranslateX(300);
        weightLabel.setTranslateY(40);

        methodLabels = new Group(volumeLabel, surfaceAreaLabel, weightLabel);

        //color sliders om vi har ekstra tid;
	}
	public Group getGroup() {
		return this.root;
	}
	public void updateAll() {
		volumeLabel.setText("Volume: \t\t" + (int)gob.findVolume() + "\t dm^3");
		surfaceAreaLabel.setText("Surface Area:\t" + (int)gob.findSurfaceArea() + "\t dm^2");
        weightLabel.setText("Weight: \t\t" + (int)gob.findWeight() + "\t Kg");
	}

}
