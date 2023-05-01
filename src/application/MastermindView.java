package application;

import javafx.application.Application;
import javafx.stage.Stage;

public class MastermindView extends Application {
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void  start(Stage stage) throws Exception {
		MastermindController mc = new MastermindController(stage);

		mc.startGame();
	}
	
	
}