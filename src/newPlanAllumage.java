import java.util.ArrayList;

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
	
	public PlanAllumage MonPlanAllumage ;
	
	newPlanAllumage(){
		MonPlanAllumage = new PlanAllumage();
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
		
		
		final ListView<PlageHoraire> list = new ListView<PlageHoraire>();
		final TextField nomPlanTextField = new TextField();
		final Button AddPlage = new Button("Ajouter Plage");
		final TextField HeureDebut = new TextField();
		final TextField MinuteDebut = new TextField();
		final TextField HeureFin = new TextField();
		final TextField MinuteFin = new TextField();
		
		nomPlanTextField.setPrefSize(200, 15);
		HeureDebut.setPrefSize(30, 15);
		MinuteDebut.setPrefSize(30, 15);
		HeureFin.setPrefSize(30, 15);
		MinuteFin.setPrefSize(30, 15);
		
		HBox hbHeure = new HBox(10);
		
		Label DemandeDateDebut = new Label("Date de debut :");
		Label DemandeDateFin = new Label("Date de fin :");
		Label H1 = new Label("h");
		Label H2 = new Label("h");
	
		hbHeure.getChildren().add(DemandeDateDebut);
		hbHeure.getChildren().add(HeureDebut);
		hbHeure.getChildren().add(H1);
		hbHeure.getChildren().add(MinuteDebut);
		hbHeure.getChildren().add(DemandeDateFin);
		hbHeure.getChildren().add(HeureFin);
		hbHeure.getChildren().add(H2);
		hbHeure.getChildren().add(MinuteFin);
		
		
		
		
	


		Button boutonEnregistrer = new Button("Enregistrer");
		Button boutonAnnuler = new Button("Annuler");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(boutonAnnuler);
		hbBtn.getChildren().add(boutonEnregistrer);
		
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
					/*	MonAppareilElectrique = new AppareilElectrique(nomPlanTextField.getText());
						if(MonAppareilElectrique != null)
						{
							AppCore.AjouterAppareilToList(MonAppareilElectrique);
							//Rafraichissement affichage liste
							ObservableList<PlanAllumage> items = FXCollections.observableArrayList (AppCore.getListePlansAllumages());
							list.setItems(items);
							nomPlanTextField.setText("");
						}*/
					}
				}
			}

				});

		final Text actiontarget = new Text();
	

		
		
		

		if(!AppCore.getListeAppareilsElectriques().isEmpty())
			System.out.println(AppCore.getListeAppareilsElectriques().get(0));
		
		boutonEnregistrer.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) 
			{
				AppCore.AjouterPlanAllumage(MonPlanAllumage); 	
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
		
		AddPlage.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent e)
			{
				MonPlanAllumage.addPlageHoraire("Lundi", new Heure(Integer.parseInt(HeureDebut.getText()),Integer.parseInt(MinuteDebut.getText())), new Heure(Integer.parseInt(HeureFin.getText()),Integer.parseInt(MinuteFin.getText())));
				ObservableList<PlageHoraire> items = FXCollections.observableArrayList (MonPlanAllumage.getPlageHoraire("Lundi"));
				list.setItems(items);
			}
		});
		hbHeure.getChildren().add(AddPlage);
		grid.add(nomAppareilLabel, 0, 1);
		grid.add(nomPlanTextField, 1, 1);
		grid.add(hbHeure, 0, 2,2,3);
	
		grid.add(list,0 ,4);
		grid.add(hbBtn, 1, 5);
		grid.add(actiontarget, 1, 6);
		this.setScene(new Scene(grid, 600, 400));
		this.show();
		nomPlanTextField.requestFocus();
}
}