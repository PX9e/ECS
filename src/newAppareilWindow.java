import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class newAppareilWindow extends Stage 
{
	
	public AppareilElectrique MonAppareilElectrique;
	
	newAppareilWindow(Stage primaryStage){
		MonAppareilElectrique = new AppareilElectrique("");
		this.initModality(Modality.WINDOW_MODAL);
		this.initOwner(primaryStage);
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Text scenetitle = new Text("Ajouter un nouvel appareil");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0);
		HBox NameHbox = new HBox(30);
		Label nomAppareilLabel = new Label("Nom de l'appareil :");
		nomAppareilLabel.setAlignment(Pos.TOP_RIGHT);
		NameHbox.getChildren().add(nomAppareilLabel);
		
		final ListView<AppareilElectrique> list = new ListView<AppareilElectrique>();
		final TextField nomAppareilTextField = new TextField();
		
		NameHbox.getChildren().add(nomAppareilTextField);
		grid.add(NameHbox, 0, 1);
		
		final Label consoModeLabel = new Label("Consommation mode : ");
		final Label nomModeLabel = new Label("Nom mode : ");
		final TextField consoModeTextField = new TextField();
		final Button AjouterMode = new Button("Ajouter Mode");
		final TextField nomModeTextField = new TextField();
		
		HBox ModeHbox = new HBox(5);
		
		consoModeLabel.setAlignment(Pos.TOP_RIGHT);
		ModeHbox.getChildren().add(nomModeLabel);
		ModeHbox.getChildren().add(nomModeTextField);
		ModeHbox.getChildren().add(consoModeLabel);
		ModeHbox.getChildren().add(consoModeTextField);
		ModeHbox.getChildren().add(AjouterMode);
		grid.add(ModeHbox,0, 2);
	
		
		consoModeTextField.lengthProperty().addListener(new ChangeListener<Number>(){
			 
			@Override
			public void changed(ObservableValue<? extends Number>observable,
					Number oldValue, Number newValue) {
				 if(newValue.intValue() > oldValue.intValue()){
						char ch = consoModeTextField.getText().charAt(oldValue.intValue());
						System.out.println("Length:"+ oldValue+"  "+ newValue +" "+ch);                   
			 
						//Check if the new character is the number or other's
						if(!(ch >= '0' && ch <= '9' )&&(ch!=';')&&(ch!=':')&&(ch!=',')){       
							//if it's not number then just setText to previous one
							consoModeTextField.setText(consoModeTextField.getText().substring(0,consoModeTextField.getText().length()-1)); 
						}
					}
			}
			
		});

	
		Button boutonEnregistrer = new Button("Enregistrer");
		Button boutonAnnuler = new Button("Annuler");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(boutonAnnuler);
		hbBtn.getChildren().add(boutonEnregistrer);
		grid.add(hbBtn, 0, 5);
		
		nomAppareilTextField.setOnKeyPressed(new EventHandler<KeyEvent>()
		{
			@Override
			public void handle(KeyEvent pressedKey) 
			{
				System.out.println(pressedKey.getCode());
				if(pressedKey.getCode() == KeyCode.ENTER)
				{
					if(!nomAppareilTextField.getText().isEmpty())
					{
					
						if(MonAppareilElectrique != null)
						{
							
							//Rafraichissement affichage liste
							ObservableList<AppareilElectrique> items = FXCollections.observableArrayList (AppCore.getListeAppareilsElectriques());
							list.setItems(items);
							nomAppareilTextField.setText("");
						}
					}
				}
			}

				});

		final Text actiontarget = new Text();
		grid.add(actiontarget, 0, 6);

		ObservableList<AppareilElectrique> items = FXCollections.observableArrayList (AppCore.getListeAppareilsElectriques());
		list.setItems(items);
		grid.add(list,0 ,3);

		if(!AppCore.getListeAppareilsElectriques().isEmpty())
			System.out.println(AppCore.getListeAppareilsElectriques().get(0));
		
		boutonEnregistrer.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent e) 
			{
				if(nomAppareilTextField.getText()!="")
				{
					if(consoModeTextField.getText()!=""){
						MonAppareilElectrique = new AppareilElectrique(nomAppareilTextField.getText());
						AppCore.AjouterAppareilToList(MonAppareilElectrique);
						close();
					}
				}
			}
		});
		
		
		boutonAnnuler.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e)
			{
				close();
			}
		});

		this.setScene(new Scene(grid, 650, 400));
		this.show();
		nomAppareilTextField.requestFocus();
}
}
