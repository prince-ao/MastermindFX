package application.game;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import application.utils.View;
import application.utils.Name;
import java.util.List;

public class GameBoardView extends Name implements View {
	public String getName() {
		return "Game Baord";
	}

	public Parent getView(List data) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Board.fxml"));
		loader.setControllerFactory(controllerClass -> {
			return new GameBoardController(data);
		});
		return loader.load();
		
	}
}