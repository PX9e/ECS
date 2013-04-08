import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class DialogBox extends Stage 
{
	boolean reponse;
	
	DialogBox(Stage maitre,String Msg,int mode)
	{
	this.initModality(Modality.WINDOW_MODAL);
	this.initOwner(maitre);
	GridPane grid = new GridPane();
	grid.setAlignment(Pos.CENTER);
	grid.setHgap(10);
	grid.setVgap(10);
	grid.setPadding(new Insets(25, 25, 25, 25));

	Text scenetitle = new Text(Msg);
	scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
	grid.add(scenetitle, 0, 0, 2, 1);
	if(mode == 1 )
	{
		Button boutonOui = new Button("Ok");
	
		HBox hbBtn = new HBox(10);
		hbBtn.getChildren().add(boutonOui);
	
		hbBtn.setAlignment(Pos.CENTER);
		grid.add(hbBtn, 1, 1);boutonOui.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent ae) 
			{
				reponse=true;
				close();
			}
		});
		
	}
	else
	{
		Button boutonOui = new Button("Oui");
		Button boutonNon = new Button("Non");
		HBox hbBtn = new HBox(10);
		hbBtn.getChildren().add(boutonOui);
		hbBtn.getChildren().add(boutonNon);
		hbBtn.setAlignment(Pos.CENTER);
		grid.add(hbBtn, 1, 1);boutonOui.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent ae) 
			{
				reponse=true;
				close();
			}
		});
		
		boutonNon.setOnAction(new EventHandler<ActionEvent>(){

			@Override
			public void handle(ActionEvent ae) 
			{
				reponse=false;
				close();
			}
		});
		
	}
	
	
	
	
	this.setScene(new Scene(grid, 50+Msg.length()*5, 100));
	this.show();
	}
	
	boolean getAnswer()
	{
		return reponse;
	}
}
