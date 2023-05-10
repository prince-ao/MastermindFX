package application.game;

import javafx.fxml.FXML;
import javafx.animation.TranslateTransition;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.geometry.Bounds;
import javafx.util.Duration;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import application.MastermindController;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
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

	@FXML
	HBox ConfirmContainer; 

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
		boolean ret = false;
		Bounds circleBounds = dragCircle.localToScene(dragCircle.getBoundsInLocal());
		Bounds Hole1Bounds= Hole1.localToScene(Hole1.getBoundsInLocal());
		Bounds Hole2Bounds= Hole2.localToScene(Hole2.getBoundsInLocal());
		Bounds Hole3Bounds= Hole3.localToScene(Hole3.getBoundsInLocal());
		Bounds Hole4Bounds= Hole4.localToScene(Hole4.getBoundsInLocal());

		
		if (circleBounds.intersects(Hole1Bounds)) {
			Hole1.setFill(dragCircle.getFill());
			dragCircle.setTranslateX(orgTranslateX);
			dragCircle.setTranslateY(orgTranslateY);
			ret = true;
		}else if(circleBounds.intersects(Hole2Bounds)) {
			Hole2.setFill(dragCircle.getFill());
			dragCircle.setTranslateX(orgTranslateX);
			dragCircle.setTranslateY(orgTranslateY);
			ret = true;
		}else if(circleBounds.intersects(Hole3Bounds)) {
			Hole3.setFill(dragCircle.getFill());
			dragCircle.setTranslateX(orgTranslateX);
			dragCircle.setTranslateY(orgTranslateY);
			ret = true;
		}else if(circleBounds.intersects(Hole4Bounds)) {
			Hole4.setFill(dragCircle.getFill());
			dragCircle.setTranslateX(orgTranslateX);
			dragCircle.setTranslateY(orgTranslateY);
			ret = true;
		}
//		System.out.println(!Hole1.getFill().equals(Color.color(1.0, 1.0, 1.0, 0.0)));
//		System.out.println(!Hole2.getFill().equals(Color.color(1.0, 1.0, 1.0, 0.0)));
//		System.out.println(!Hole3.getFill().equals(Color.color(1.0, 1.0, 1.0, 0.0)));
//		System.out.println(!Hole4.getFill().equals(Color.color(1.0, 1.0, 1.0, 0.0)));
		if(ret) {
			if(!Hole1.getFill().equals(Color.color(1.0, 1.0, 1.0, 0.0)) && !Hole2.getFill().equals(Color.color(1.0, 1.0, 1.0, 0.0)) && !Hole3.getFill().equals(Color.color(1.0, 1.0, 1.0, 0.0)) && !Hole4.getFill().equals(Color.color(1.0, 1.0, 1.0, 0.0))) {
				Button confirm = new Button("Confirm");
				confirm.setOnMouseClicked(event -> {
					List<Paint> data = new ArrayList<>(Arrays.asList(Hole1.getFill(), Hole2.getFill(), Hole3.getFill(), Hole4.getFill()));
					MastermindController.switchView(new GameBoardView(), data);
				});
				ConfirmContainer.getChildren().add(confirm);
			}
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
