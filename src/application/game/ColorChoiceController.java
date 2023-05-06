package application.game;

import javafx.fxml.FXML;
import javafx.animation.TranslateTransition;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.geometry.Bounds;
import javafx.util.Duration;
//import javafx.scene.layout.AnchorPane;

public class ColorChoiceController {
	
	@FXML
	Circle Hole1;
	@FXML
	Circle Hole2;
	@FXML
	Circle Hole3;
	@FXML
	Circle Hole4;

	private double orgSceneX, orgSceneY;
    private double orgTranslateX, orgTranslateY;
	
	public void startPegDrag(MouseEvent e) {
		Circle dragCircle = (Circle) e.getSource();
		dragCircle.getCenterX();
        orgSceneX = e.getSceneX();
        orgSceneY = e.getSceneY();
        orgTranslateX = dragCircle.getTranslateX();
        orgTranslateY = dragCircle.getTranslateY();
//        System.out.println(orgTranslateX + ", " + orgTranslateY);
//        System.out.println(orgSceneX + ", " + orgSceneY);
    }

	public void handlePegDrag(MouseEvent e) {
		Circle dragCircle = (Circle) e.getSource();

        double offsetX = e.getSceneX() - orgSceneX;
        double offsetY = e.getSceneY() - orgSceneY;
        double newTranslateX = orgTranslateX + offsetX;
        double newTranslateY = orgTranslateY + offsetY;

        dragCircle.setTranslateX(newTranslateX);
        dragCircle.setTranslateY(newTranslateY);
	}
	
	public void endPegDrag(MouseEvent e) {
		Circle dragCircle = (Circle) e.getSource();
		Bounds circleBounds = dragCircle.localToScene(dragCircle.getBoundsInLocal());
		Bounds Hole1Bounds= Hole1.localToScene(Hole1.getBoundsInLocal());
		Bounds Hole2Bounds= Hole2.localToScene(Hole2.getBoundsInLocal());
		Bounds Hole3Bounds= Hole3.localToScene(Hole3.getBoundsInLocal());
		Bounds Hole4Bounds= Hole4.localToScene(Hole4.getBoundsInLocal());

		
		if (circleBounds.intersects(Hole1Bounds)) {
			Hole1.setFill(dragCircle.getFill());
			dragCircle.setTranslateX(orgTranslateX);
			dragCircle.setTranslateY(orgTranslateY);
			return;
		}else if(circleBounds.intersects(Hole2Bounds)) {
			Hole2.setFill(dragCircle.getFill());
			dragCircle.setTranslateX(orgTranslateX);
			dragCircle.setTranslateY(orgTranslateY);
			return;
		}else if(circleBounds.intersects(Hole3Bounds)) {
			Hole3.setFill(dragCircle.getFill());
			dragCircle.setTranslateX(orgTranslateX);
			dragCircle.setTranslateY(orgTranslateY);
			return;
		}else if(circleBounds.intersects(Hole4Bounds)) {
			Hole4.setFill(dragCircle.getFill());
			dragCircle.setTranslateX(orgTranslateX);
			dragCircle.setTranslateY(orgTranslateY);
			return;
		}
		
		TranslateTransition transition = new TranslateTransition(Duration.seconds(0.5), dragCircle);

		transition.setToX(orgTranslateX);
        transition.setToY(orgTranslateY);
        transition.play();
	}
	
	public void printLocation(MouseEvent e) {
		System.out.println(((Circle)e.getSource()).getLayoutX());
		System.out.println(((Circle)e.getSource()).getLayoutY());
	}
}
