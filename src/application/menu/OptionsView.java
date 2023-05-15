package application.menu;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import application.utils.View;
import application.utils.Name;
import java.util.List;

public class OptionsView extends Name implements View 
{
	public String getName() 
	{
		return "Options";
	}

	public Parent getView(List data) throws Exception 
	{
		return FXMLLoader.load(getClass().getResource("OptionsView.fxml"));
		
	}
}