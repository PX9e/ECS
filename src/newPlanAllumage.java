import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class newPlanAllumage extends Stage 
{
	
	public AppareilElectrique MonAppareilElectrique;
	
	newPlanAllumage(){
		//Stage Window = new Stage();
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Text scenetitle = new Text("Ajouter un plan d'allumage");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);
		Label nomAppareilLabel = new Label("Nom du plan :");
		grid.add(nomAppareilLabel, 0, 1);

		final ListView<PlanAllumage> list = new ListView<PlanAllumage>();
		final TextField nomPlanTextField = new TextField();
		nomPlanTextField.setPrefSize(15, 200);
		grid.add(nomPlanTextField, 1, 1);

		Button boutonAjouterAppareil = new Button("Ajouter le plan");
		grid.add(boutonAjouterAppareil,3,1);


		Button boutonEnregistrer = new Button("Enregistrer");
		Button boutonAnnuler = new Button("Annuler");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(boutonAnnuler);
		hbBtn.getChildren().add(boutonEnregistrer);
		grid.add(hbBtn, 1, 2);
		
		nomPlanTextField.setOnKeyPressed(new EventHandler<KeyEvent>()
				{

			@Override
			public void handle(KeyEvent pressedKey) 
			{
				System.out.println(pressedKey.getCode());
				if(pressedKey.getCode() == KeyCode.ENTER)
				{
					if(!nomPlanTextField.getText().isEmpty())
					{
						MonAppareilElectrique = new AppareilElectrique(nomPlanTextField.getText());
						if(MonAppareilElectrique != null)
						{
							AppCore.AjouterAppareilToList(MonAppareilElectrique);
							//Rafraichissement affichage liste
							ObservableList<PlanAllumage> items = FXCollections.observableArrayList (AppCore.getListePlansAllumages());
							list.setItems(items);
							nomPlanTextField.setText("");
						}
					}
				}
			}

				});

		final Text actiontarget = new Text();
		grid.add(actiontarget, 1, 6);

		ObservableList<PlanAllumage> items = FXCollections.observableArrayList (AppCore.getListePlansAllumages());
		list.setItems(items);
		grid.add(list,0 ,2);

		if(!AppCore.getListeAppareilsElectriques().isEmpty())
			System.out.println(AppCore.getListeAppareilsElectriques().get(0));
		
		boutonEnregistrer.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) 
			{
				//TODO : Faire que ça enregistre 
				close();
			}
		});
		
		boutonAnnuler.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e)
			{
				close();
			}
		});

		this.setScene(new Scene(grid, 600, 400));
		this.show();
		nomPlanTextField.requestFocus();
}
}