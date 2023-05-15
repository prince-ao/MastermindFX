package application.menu;

import application.utils.View;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import java.util.List;
import application.utils.Name;

public class RulesView extends Name implements View
{
	
	@Override
	public String getName() 
	{
		return "Rules";
	}

	@Override
	public Parent getView(List data) throws Exception 
	{
		return FXMLLoader.load(getClass().getResource("RulesView.fxml"));

	}
}