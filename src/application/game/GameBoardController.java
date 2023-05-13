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
import javafx.scene.text.Text;
import javafx.scene.layout.GridPane;
import javafx.collections.ObservableList;
import javafx.scene.text.Font;
import javafx.animation.PauseTransition;
import javafx.util.Duration;
import application.MastermindController;
import java.util.List;

public class GameBoardController {
	
	
	@FXML
	GridPane box1;
	@FXML
	GridPane box2;
	@FXML
	GridPane box3;
	@FXML
	GridPane box4;
	@FXML
	GridPane box5;
	@FXML
	GridPane box6;
	@FXML
	GridPane box7;
	@FXML
	GridPane box8;
	@FXML
	GridPane box9;
	@FXML
	GridPane box10;
	@FXML
	HBox TextScreen;
	

	private int currentCol = 0;
	private Paint selected;
	private Circle selectedCircle;
	private ObservableList<Node> children;
	private List<Paint> choices;
	
	public GameBoardController() { }
	public GameBoardController(List data) {
		choices = data;
	}
	
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
		if(allSelected) {
			ObservableList<Node> children = ((VBox)((HBox)((AnchorPane) e.getSource()).getParent()).getParent()).getChildren();
			Circle c1 = ((Circle)((AnchorPane)((HBox)children.get(0)).getChildren().get(0)).getChildren().get(1));
			Circle c2 = ((Circle)((AnchorPane)((HBox)children.get(1)).getChildren().get(0)).getChildren().get(1));
			Circle c3 = ((Circle)((AnchorPane)((HBox)children.get(2)).getChildren().get(0)).getChildren().get(1));
			Circle c4 = ((Circle)((AnchorPane)((HBox)children.get(3)).getChildren().get(0)).getChildren().get(1));
			
			boolean c1c = choices.get(0).toString().equals(c1.getFill().toString());
			boolean c2c = choices.get(1).toString().equals(c2.getFill().toString());
			boolean c3c = choices.get(2).toString().equals(c3.getFill().toString());
			boolean c4c = choices.get(3).toString().equals(c4.getFill().toString());
			
			int k = 0;

			if(c1c) k++;
			if(c2c) k++;
			if(c3c) k++;
			if(c4c) k++;
			
			String colId = ((VBox)((HBox)((AnchorPane) e.getSource()).getParent()).getParent()).getId();
			ObservableList<Node> child;
			int counter = 0;
			switch(colId) {
				case "col1":
					child = box1.getChildren();
					for (Node c : child) {
						if(counter++ == k) break;
						((Circle)c).setFill(Color.BLACK);
					};
					break;
				case "col2":
					child = box2.getChildren();
					for (Node c : child) {
						if(counter++ == k) break;
						((Circle)c).setFill(Color.BLACK);
					};
					break;
				case "col3":
					child = box3.getChildren();
					for (Node c : child) {
						if(counter++ == k) break;
						((Circle)c).setFill(Color.BLACK);
					};
					break;
				case "col4":
					child = box4.getChildren();
					for (Node c : child) {
						if(counter++ == k) break;
						((Circle)c).setFill(Color.BLACK);
					};
					break;
				case "col5":
					child = box5.getChildren();
					for (Node c : child) {
						if(counter++ == k) break;
						((Circle)c).setFill(Color.BLACK);
					};
					break;
				case "col6":
					child = box6.getChildren();
					for (Node c : child) {
						if(counter++ == k) break;
						((Circle)c).setFill(Color.BLACK);
					};
					break;
				case "col7":
					child = box7.getChildren();
					for (Node c : child) {
						if(counter++ == k) break;
						((Circle)c).setFill(Color.BLACK);
					};
					break;
				case "col8":
					child = box8.getChildren();
					for (Node c : child) {
						if(counter++ == k) break;
						((Circle)c).setFill(Color.BLACK);
					};
					break;
				case "col9":
					child = box9.getChildren();
					for (Node c : child) {
						if(counter++ == k) break;
						((Circle)c).setFill(Color.BLACK);
					};
					break;
				case "col10":
					child = box10.getChildren();
					for (Node c : child) {
						if(counter++ == k) break;
						((Circle)c).setFill(Color.BLACK);
					};
					break;
			}

			if(k == 4) {
				int points = 10 - currentCol;
				Text t = new Text(MastermindController.getCurrentPlayer() + " Won " + points + " points!");
				MastermindController.incrementPlayer();
				double fontSize = 35;
		        t.setFont(Font.font(fontSize));
				TextScreen.getChildren().add(t);
				PauseTransition pause = new PauseTransition(Duration.seconds(5));
				pause.setOnFinished(ss -> {
					if(MastermindController.getRounds() == 2) {
						System.out.println("Game Over!");
					}else {
						MastermindController.switchView(new ColorChoiceView(), null);
					}
	            });
				pause.play();
			}
				
			currentCol++;
			if(counter == 10) {
				Text t = new Text(MastermindController.getCurrentPlayer() + " Lost!");
				MastermindController.incrementPlayer();
				TextScreen.getChildren().add(t);
				// switch screens
			}
		}
		
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
