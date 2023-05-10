package application.utils;

import javafx.scene.Parent;
import java.util.List;

public interface View {
	public Parent getView(List Data) throws Exception;
	public String getName();
}