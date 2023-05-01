package application.utils;

import javafx.scene.Parent;

public interface View {
	public Parent getView() throws Exception;
	public String getName();
}