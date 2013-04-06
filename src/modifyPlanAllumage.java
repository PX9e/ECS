import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
import javafx.stage.Stage;


public class modifyPlanAllumage extends Stage 
{
	
	public PlanAllumage MonPlanAllumage ;
	
	modifyPlanAllumage(){
		
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
		final ComboBox<PlanAllumage> comboPlans = new ComboBox<PlanAllumage>();
		final Button AddPlage = new Button("Ajouter Plage");
		final Button DeletePlage = new Button("Supprimer Plage");
		final Button Delete = new Button("Supprimer");
		final Button ModifierNom = new Button("Modifier Nom");
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
				for(int i = 0; i<AppCore.getListePlansAllumages().size();i++)
				{
					if(AppCore.getListePlansAllumages().get(i).getName() == MonPlanAllumage.getName())
					{
						AppCore.getListePlansAllumages().remove(i);
						AppCore.AjouterPlanAllumage(MonPlanAllumage);
						break;
					}
					
				}
				close();
			}
		});
		ModifierNom.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) 
			{
				for(int i = 0; i<AppCore.getListePlansAllumages().size();i++)
				{
					if(AppCore.getListePlansAllumages().get(i).getName() == MonPlanAllumage.getName())
					{
						AppCore.getListePlansAllumages().remove(i);
						MonPlanAllumage.setName(nomPlanTextField.getText());
						AppCore.AjouterPlanAllumage(MonPlanAllumage);
						
						comboPlans.setItems(FXCollections.observableArrayList(AppCore.getListePlansAllumages()));
						break;
					}
					
				}

			}
		});
		Delete.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) 
			{
				for(int i = 0; i<AppCore.getListePlansAllumages().size();i++)
				{
					if(AppCore.getListePlansAllumages().get(i).getName() == MonPlanAllumage.getName())
					{
						AppCore.getListePlansAllumages().remove(i);
						AppCore.SavePlanAllumage();
						list.getItems().clear();
						nomPlanTextField.clear();
						comboPlans.setItems(FXCollections.observableArrayList(AppCore.getListePlansAllumages()));
						break;
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
				
				MonPlanAllumage.addPlageHoraire("Lundi", new Heure(Integer.parseInt(HeureDebut.getText()),Integer.parseInt(MinuteDebut.getText())), new Heure(Integer.parseInt(HeureFin.getText()),Integer.parseInt(MinuteFin.getText())));
				ObservableList<PlageHoraire> items = FXCollections.observableArrayList (MonPlanAllumage.getPlageHoraire("Lundi"));
				list.setItems(items);
			}
		});
		
		
		
		comboPlans.setItems(FXCollections.observableArrayList(AppCore.getListePlansAllumages()));
		comboPlans.valueProperty().addListener(new ChangeListener<PlanAllumage>() {
		        @Override public void changed(ObservableValue ov, PlanAllumage t, PlanAllumage t1) {
		          if(t1!=null)
		          {
		          MonPlanAllumage = t1;
		          nomPlanTextField.setText(MonPlanAllumage.getName());
		          ObservableList<PlageHoraire> items = FXCollections.observableArrayList (MonPlanAllumage.getPlageHoraire("Lundi"));
				  list.setItems(items);
		        }
		        }    
		    });
		VBox Options = new VBox(10);
		hbHeure.getChildren().add(AddPlage);
		HBox Deletedbox = new HBox(40);
		Deletedbox.getChildren().add(nomAppareilLabel);
		Deletedbox.getChildren().add(comboPlans);
		Deletedbox.getChildren().add(Delete);
	
		grid.add(Deletedbox, 0, 1);
		Options.getChildren().add(new Label("  "));
		Options.getChildren().add(DeletePlage);
		Options.getChildren().add(new Label("  "));
		Options.getChildren().add(new Label("Nom :"));
		Options.getChildren().add(nomPlanTextField);
		Options.getChildren().add(ModifierNom);
		grid.add(hbHeure, 0, 2,2,3);

		grid.add(list,0 ,4);
		grid.add(hbBtn, 1, 5);
		grid.add(actiontarget, 1, 6);
		grid.add(Options, 1, 4);
		this.setScene(new Scene(grid, 600, 400));
		this.show();
		nomPlanTextField.requestFocus();
}
}