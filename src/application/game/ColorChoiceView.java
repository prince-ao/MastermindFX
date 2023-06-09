package application.game;

import java.util.List;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import application.utils.View;
import application.utils.Name;

public class ColorChoiceView extends Name implements View {
	public String getName() {
		return "Color Choice";
	}

	public Parent getView(List data) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("ColorChoice.fxml"));
		loader.setControllerFactory(controllerClass -> {
			return new ColorChoiceController();
		});
		return loader.load();
	}
	
}
