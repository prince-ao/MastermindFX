package application.game;

import javafx.fxml.FXML;
// import javafx.scene.Parent;
// import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Paint;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.Stop;
import javafx.scene.paint.Color;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.shape.StrokeType;
import javafx.scene.Node;
import javafx.collections.ObservableList;
import application.MastermindController;

public class GameBoardController {

	private int currentCol = 0;
	private Paint selected;
	private Circle selectedCircle;
	private ObservableList<Node> children;
	
	@FXML
	public void handlePegClick(MouseEvent e) {
		Circle c =  ((Circle) e.getSource());

		if(selectedCircle != null) {
			deselectPeg(selectedCircle);
			turnOff(children);
		}
		
		switch(currentCol) {
			case 0:
				children = ((VBox)MastermindController.getStage().getScene().getRoot().lookup("#col1")).getChildren();
				break;
			case 1:
				children = ((VBox)MastermindController.getStage().getScene().getRoot().lookup("#col2")).getChildren();
				break;
			case 2:
				children = ((VBox)MastermindController.getStage().getScene().getRoot().lookup("#col3")).getChildren();
				break;
			case 3:
				children = ((VBox)MastermindController.getStage().getScene().getRoot().lookup("#col4")).getChildren();
				break;
			case 4:
				children = ((VBox)MastermindController.getStage().getScene().getRoot().lookup("#col5")).getChildren();
				break;
			case 5:
				children = ((VBox)MastermindController.getStage().getScene().getRoot().lookup("#col6")).getChildren();
				break;
			case 6:
				children = ((VBox)MastermindController.getStage().getScene().getRoot().lookup("#col7")).getChildren();
				break;
			case 7:
				children = ((VBox)MastermindController.getStage().getScene().getRoot().lookup("#col8")).getChildren();
				break;
			case 8:
				children = ((VBox)MastermindController.getStage().getScene().getRoot().lookup("#col9")).getChildren();
				break;
			case 9:
				children = ((VBox)MastermindController.getStage().getScene().getRoot().lookup("#col10")).getChildren();
				break;
		}

		lightUp(children);
		selectPeg(c);
		selectedCircle = c;
		Stop[] stops;
		
		switch(c.getId()) {
			case "pegOne":
				 stops = new Stop[] { new Stop(0, Color.rgb(31, 255, 45)), new Stop(1, Color.WHITE)};
				selected = new LinearGradient(
						0.32075473141168986, 
						0.7971698103169471, 
						0.830188679032221, 
						0.14150950753468827, 
						true, 
						CycleMethod.NO_CYCLE, stops);
				System.out.println("slected");
				break;
			case "pegTwo":
				stops = new Stop[] { new Stop(0, Color.rgb(31, 63, 255)), new Stop(1, Color.WHITE)};
				selected = new LinearGradient(
						0.32075473141168986, 
						0.7971698103169471, 
						0.830188679032221, 
						0.14150950753468827, 
						true, 
						CycleMethod.NO_CYCLE, stops);
				break;
			case "pegThree":
				stops = new Stop[] { new Stop(0, Color.rgb(238, 255, 31)), new Stop(1, Color.WHITE)};
				selected = new LinearGradient(
						0.32075473141168986, 
						0.7971698103169471, 
						0.830188679032221, 
						0.14150950753468827, 
						true, 
						CycleMethod.NO_CYCLE, stops);
				break;
			case "pegFour":
				stops = new Stop[] { new Stop(0, Color.rgb(135, 31, 255)), new Stop(1, Color.WHITE)};
				selected = new LinearGradient(
						0.32075473141168986, 
						0.7971698103169471, 
						0.830188679032221, 
						0.14150950753468827, 
						true, 
						CycleMethod.NO_CYCLE, stops);
				break;
			case "pegFive":
				stops = new Stop[] { new Stop(0, Color.rgb(255, 31, 31)), new Stop(1, Color.WHITE)};
				selected = new LinearGradient(
						0.32075473141168986, 
						0.7971698103169471, 
						0.830188679032221, 
						0.14150950753468827, 
						true, 
						CycleMethod.NO_CYCLE, stops);

				break;
		}
		
	}
	
	@FXML
	public void handleHoleClick(MouseEvent e) {
		if(selected == null) {
			((Circle)((AnchorPane) e.getSource()).getChildren().get(1)).setFill(Color.color(1.0, 1.0, 1.0, 0.0));
			return;
		}
		
		String s = ((VBox)((AnchorPane) e.getSource()).getParent().getParent()).getId();

		if((int)((s.charAt(s.length()-1))-'0') != currentCol+1) {
			return;
		}
		
		

		turnOff(children);
		((Circle)((AnchorPane) e.getSource()).getChildren().get(1)).setFill(selected);
	
		deselectPeg(selectedCircle);
		
		boolean allSelected = true;
		for(Node h : children) {
			if(((Circle)((AnchorPane)((HBox)h).getChildren().get(0)).getChildren().get(1)).getFill().equals(Color.color(1.0, 1.0, 1.0, 0.0)))
				allSelected = false;
		}
		if(allSelected) currentCol++;
		
		selected = null;
	}
	
	private void selectPeg(Circle c) {
		c.setStroke(Color.rgb(15,200,45, 0.5));
		c.setStrokeWidth(8);
		c.setStrokeType(StrokeType.OUTSIDE);
	}
	
	private void deselectPeg(Circle c) {
		c.setStroke(Color.BLACK);
		c.setStrokeWidth(1);
		c.setStrokeType(StrokeType.INSIDE);
	}
	
	private void lightUp(ObservableList<Node> children) {
		for(Node h : children) {
			if(((Circle)((AnchorPane)((HBox)h).getChildren().get(0)).getChildren().get(1)).getFill().equals(Color.color(1.0, 1.0, 1.0, 0.0)))
				((Circle)((AnchorPane)((HBox)h).getChildren().get(0)).getChildren().get(0)).setFill(Color.GREEN);
		}
	}
	
	
	private void turnOff(ObservableList<Node> children) {
		for(Node h : children) {
			((Circle)((AnchorPane)((HBox)h).getChildren().get(0)).getChildren().get(0)).setFill(Color.color(1.0,1.0,1.0,0.0));
		}
	}
}
