package application;

import application.menu.MainMenuView;
import application.utils.View;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Cursor;
import javafx.scene.ImageCursor;
import javafx.scene.paint.Color;
import javafx.scene.image.Image;
import java.util.List;
import application.utils.Name;

public class MastermindController {
	private static Stage mainStage;
	private static String[] players = {"Player 1", "Player 2"};
	private static int curr = 0;
	private static int rounds = 1;
	private static int player1Points;
	private static int player2Points;

	public MastermindController(Stage stage) {
		mainStage = stage;
	}
	
	public void startGame() throws Exception {
		MainMenuView v = new MainMenuView();
		Parent mainMenu = v.getView(null);
		Scene root = new Scene(mainMenu);
		root.setFill(Color.WHITE);
		Image image = new Image("assets/images/cursor.png");
		Cursor cursor = new ImageCursor(image);

		root.setCursor(cursor);
		root.getStylesheets().add(getClass().getResource("game/Game.css").toExternalForm());
		root.getStylesheets().add(getClass().getResource("menu/Menu.css").toExternalForm());
		root.getStylesheets().add(getClass().getResource("end/End.css").toExternalForm());
		

		mainStage.setScene(root);
		mainStage.setFullScreenExitHint("");
		mainStage.setFullScreen(true);
		mainStage.show();
	}

	public static void switchView(View v, List data) {
		try {
			Parent p = v.getView(data);
			mainStage.getScene().setRoot(p);
		}catch(Exception e) {
			System.err.println("Error while switchign to " + ((Name)v).getName());
			e.printStackTrace();
		}
	}
	
	public static Stage getStage() {
		return mainStage;
	}
	
	public static String getCurrentPlayer() {
		return players[curr];
	}
	
	public static void incrementPlayer() {
		curr = ++curr % 2;
	}
	
	public static void reset() {
		rounds = 0;
	}
	
	public static int getRounds() {
		return rounds++;
	}

	public static int getPlayer1Points() {
		return player1Points;
	}

	public static void setPlayer1Points(int p) {
		player1Points = p;
	}

	public static int getPlayer2Points() {
		return player2Points;
	}

	public static void setPlayer2Points(int p) {
		player2Points = p;
	}
	
}