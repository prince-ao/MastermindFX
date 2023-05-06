package application.menu;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import application.utils.View;
import javafx.scene.layout.Pane;

public class MainMenuView implements View {
	public String getName() {
		return "Main Menu";
	}

	public Parent getView() throws Exception {
		Parent fxml = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
		Pane parent = (Pane)fxml.lookup("mainMenuLayout");
		return fxml;
	}
}