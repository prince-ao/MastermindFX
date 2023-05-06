package application.game;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import application.utils.View;

public class GameBoardView implements View {
	public String getName() {
		return "Game Baord";
	}

	public Parent getView() throws Exception {
		return FXMLLoader.load(getClass().getResource("Board.fxml"));
		
	}
}