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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class newPlanAllumage extends Stage 
{
	
	public PlanAllumage MonPlanAllumage ;
	
	newPlanAllumage(Stage primaryStage){
	
		MonPlanAllumage = new PlanAllumage();
		final Stage stage = this;
		this.initModality(Modality.WINDOW_MODAL);
		this.initOwner(primaryStage);
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
		final Button DeletePlage = new Button("Supprimer Plage");
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
		
	
		final Text actiontarget = new Text();
	

		
			
		boutonEnregistrer.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) 
			{
				if(!nomPlanTextField.getText().isEmpty())
				{
					if(AppCore.getPlanAllumage(nomPlanTextField.getText())==null)
					{	
						if(MonPlanAllumage.getPlageHoraire("Lundi").size()>0)
						{
							MonPlanAllumage.setName(nomPlanTextField.getText());
							AppCore.AjouterPlanAllumage(MonPlanAllumage); 	
							close();
						}
						else
						{
							@SuppressWarnings("unused")
							final DialogBox dialogBox = new DialogBox(stage,"Vous devez specifier au moins une plage horaire",1);
						}
					}
					else
					{
						@SuppressWarnings("unused")
						final DialogBox dialogBox = new DialogBox(stage,"Nom déjà existant",1);
					}
				}
				else
				{
					@SuppressWarnings("unused")
					final DialogBox dialogBox = new DialogBox(stage,"Nom vide",1);
				}
					
			}
		});
		
		boutonAnnuler.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e)
			{
				System.out.println("coucou");
				close();
			}
		});
		
		DeletePlage.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent e)
			{
				for(int y=0;y<list.getSelectionModel().getSelectedItems().size();y++)
				{
					MonPlanAllumage.remPlageHoraire("Lundi",list.getSelectionModel().getSelectedItems().get(y).getDebut(),list.getSelectionModel().getSelectedItems().get(y).getFin());
				}
				
				ObservableList<PlageHoraire> items = FXCollections.observableArrayList (MonPlanAllumage.getPlageHoraire("Lundi"));
				list.setItems(items);
			}
		});
		AddPlage.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent e)
			{
				if(((!HeureDebut.getText().isEmpty())&&(!MinuteDebut.getText().isEmpty()))&&((!HeureFin.getText().isEmpty())&&(!MinuteFin.getText().isEmpty())))
				{
					try{
					if(((Integer.parseInt(HeureDebut.getText())<24)&&(Integer.parseInt(MinuteDebut.getText())<60))&&((Integer.parseInt(HeureFin.getText())<24)&&(Integer.parseInt(MinuteFin.getText())<60)))
					{
						ArrayList<PlageHoraire> MyHoraires = MonPlanAllumage.getPlageHoraire("Lundi");
						int testingdata = Integer.parseInt(HeureDebut.getText()) * 60 + Integer.parseInt(MinuteDebut.getText());
						int testingdataB = Integer.parseInt(HeureFin.getText()) * 60 + Integer.parseInt(MinuteFin.getText());
						boolean flag = false;
						int reference;
						int referenceB;
						
						for(int z=0;z<MyHoraires.size();z++)
						{
							reference = MyHoraires.get(z).getDebut().getHeures() * 60 +MyHoraires.get(z).getDebut().getMinutes();
							referenceB = MyHoraires.get(z).getFin().getHeures() * 60 + MyHoraires.get(z).getFin().getMinutes();
							
							if((testingdata>reference)&&(testingdata<referenceB))
							{
								flag=true;
								break;	
							}
							if((testingdataB>reference)&&(testingdataB<referenceB))
							{
								flag=true;
								break;
							}
						}
						
						
						if(flag ==false)
						{
							MonPlanAllumage.addPlageHoraire("Lundi", new Heure(Integer.parseInt(HeureDebut.getText()),Integer.parseInt(MinuteDebut.getText())), new Heure(Integer.parseInt(HeureFin.getText()),Integer.parseInt(MinuteFin.getText())));
							ObservableList<PlageHoraire> items = FXCollections.observableArrayList (MonPlanAllumage.getPlageHoraire("Lundi"));
							list.setItems(items);
						}
						else
						{
							@SuppressWarnings("unused")
							final DialogBox Mydialog= new DialogBox(stage, "Chevauchement des horaires", 1);
						}
					}
					else
					{
						if(Integer.parseInt(HeureDebut.getText())>23)
						{
								HeureDebut.setText("23");
						}
						if(Integer.parseInt(MinuteDebut.getText())>59)
						{
								MinuteDebut.setText("59");
						}
						if(Integer.parseInt(HeureFin.getText())>23)
						{
								HeureFin.setText("23");
						}
						if(Integer.parseInt(MinuteFin.getText())>59)
						{
								MinuteFin.setText("59");
						}
					}
					}
					catch(Exception E)
					{
					
					}
				}
			}
		});
		hbHeure.getChildren().add(AddPlage);
		grid.add(nomAppareilLabel, 0, 1);
		grid.add(nomPlanTextField, 1, 1);
		grid.add(hbHeure, 0, 2,2,3);
		grid.add(DeletePlage,1,4);
		grid.add(list,0 ,4);
		grid.add(hbBtn, 1, 5);
		grid.add(actiontarget, 1, 6);
		this.setScene(new Scene(grid, 600, 400));
		this.show();
		nomPlanTextField.requestFocus();
}
}