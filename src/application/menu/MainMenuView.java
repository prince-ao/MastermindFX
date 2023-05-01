package application.menu;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import application.utils.View;

public class MainMenuView implements View {
	public String getName() {
		return "Main Menu";
	}

	public Parent getView() throws Exception {
		return FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
	}
}