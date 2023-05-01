package application;

import application.menu.MainMenuView;
import application.utils.View;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;

public class MastermindController {
	private static Stage mainStage;

	public MastermindController(Stage stage) {
		mainStage = stage;
	}
	
	public void startGame() throws Exception {
		MainMenuView v = new MainMenuView();
		Parent mainMenu = v.getView();
		Scene root = new Scene(mainMenu);
		mainStage.setScene(root);
		mainStage.setFullScreenExitHint("");
		mainStage.setFullScreen(true);
		mainStage.show();
	}

	public static void switchView(View v) {
		try {
			Parent p = v.getView();
			mainStage.getScene().setRoot(p);
		}catch(Exception e) {
			System.err.println("Error while switchign to " + v.getName());
		}
		
	}
}