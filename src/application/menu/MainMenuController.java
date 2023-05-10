package application.menu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import application.MastermindController;
import application.game.ColorChoiceView;

public class MainMenuController {
	
	@FXML
	private void handlePlay(ActionEvent e) {
		e.consume();
		MastermindController.switchView(new ColorChoiceView(), null);
	}
	
}