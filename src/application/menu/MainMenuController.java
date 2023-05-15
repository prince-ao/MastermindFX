package application.menu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.event.Event;
import application.MastermindController;
import application.game.ColorChoiceView;

public class MainMenuController {
	
	private static int numRounds;
	private static int numPegs;
	private static int numColors;
	
	@FXML
	private void handlePlay(Event e) {
		e.consume();
		MastermindController.switchView(new ColorChoiceView(), null);
	}
	
	@FXML
	private void handleMainMenu(Event e) {
//		e.consume();
		MastermindController.switchView(new MainMenuView(), null);
	}
	
	@FXML
	private void handleRules(Event e) {
		e.consume();
		MastermindController.switchView(new RulesView(), null);
	}
	
	@FXML
	private void handleOptionsMenu(Event e) {
		e.consume();
		MastermindController.switchView(new OptionsView(), null);
	}
	
	public static int getNumRounds() {
		return numRounds;
	}
	
	public static void setNumRounds(int numRounds) {
		MainMenuController.numRounds = numRounds;
	}
	
}