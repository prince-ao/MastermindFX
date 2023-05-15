package application.end;

import java.util.List;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.Parent;
import javafx.scene.text.Text;
import application.MastermindController;
import application.utils.View;
import application.game.ColorChoiceView;
import application.menu.MainMenuView;
import application.utils.Name;

public class EndView extends Name implements View {

	@Override
	public Parent getView(List Data) throws Exception {
    	Label gameover = new Label("GAME OVER!");
    	gameover.setTranslateX(600);
    	gameover.setTranslateY(50);
    	gameover.setId("gameover");
    	String w;
    	
    	if((int)Data.get(0) > (int)Data.get(1)) {
    		w = "Winner: Player 1";
    	}else if((int)Data.get(0) < (int)Data.get(1)) {
    		w = "Winner: Player 2";
    	}else {
    		w = "Tie";
    	}
    	

    	
    	Label winner=new Label(w);
    	winner.setId("winner");
    	
    	
    	
    	Text text1= new Text("Player 1 points: " + Data.get(0));

    	text1.setId("p1p");
    	
    	Text text2= new Text("Player 2 points: " + Data.get(1));

    	text2.setId("p2p");
    	
    	
    	
    	DropShadow dp= new DropShadow();
    	dp.setOffsetX(10);
    	dp.setOffsetY(10);
    	
    		
    	VBox vbox=new VBox();
    	vbox.getChildren().addAll(text1,text2,winner);
    	vbox.setTranslateX(650);
    	vbox.setTranslateY(400);
    	vbox.setId("vbox1");
    	
    	
    	
    	
    	
	   Button button1=new Button("Rematch");
	   button1.setId("myButton");
	   button1.setTranslateX(1630);
	   button1.setTranslateY(950);
	   button1.setEffect(dp);
	   button1.setOnAction(event->{
		   MastermindController.reset();
		   MastermindController.switchView(new ColorChoiceView(), null);
	   });


	   Button button2=new Button("Main Menu");
	   button2.setId("myButton");
	   button2.setTranslateX(20);
	   button2.setTranslateY(950);
	   button2.setEffect(dp);
	   button2.setOnAction(event->{
		   MastermindController.reset();
		   MastermindController.switchView(new MainMenuView(), null);
		
	   });

	   return new Pane(button1,button2,gameover,vbox);
	}

	@Override
	public String getName() {
		return "End View";
	}
}
