
import java.util.ArrayList;

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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

class NewModifierCuisineWindow extends Stage{

	public Cuisine MaCuisine;

	public Cuisine getMaCuisine() {
		return MaCuisine;
	}

	public void setMaCuisine(Cuisine monCuisine) {
		MaCuisine = monCuisine;
	}

	NewModifierCuisineWindow(Stage primaryStage)
	{
		this.initModality(Modality.WINDOW_MODAL);
		this.initOwner(primaryStage);
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Text scenetitle = new Text("Ajouter une cuisine");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);

		Label nomCuisineLabel = new Label("Nom de la cuisine:");
		grid.add(nomCuisineLabel, 0, 1);

		final ListView<AppareilElectrique> listAppareilsAssocies= new ListView<AppareilElectrique>();
		final ListView<AppareilElectrique> listAppareilsNonAssocies = new ListView<AppareilElectrique>();
		final ComboBox<Cuisine> nomCuisineTextField = new ComboBox<Cuisine>();
		nomCuisineTextField.setPrefSize(15, 20);
		grid.add(nomCuisineTextField, 1, 1);
		nomCuisineTextField.getItems().clear();
		nomCuisineTextField.setItems(FXCollections.observableArrayList(AppCore
				.getListeCuisines()));
		nomCuisineTextField.valueProperty().addListener(
				new ChangeListener<Cuisine>() {
					@Override
					public void changed(
							@SuppressWarnings("rawtypes") ObservableValue ov,
							Cuisine t, Cuisine t1) {
						if (t1 != null) {

							MaCuisine = (Cuisine) t1;
							ObservableList<AppareilElectrique> items = FXCollections
									.observableArrayList(MaCuisine
											.ObtenirAppareils());
								
							listAppareilsAssocies.setItems(items);
							ArrayList<AppareilElectrique> NonAssoci = new ArrayList<AppareilElectrique>();
							for(int i = 0;i<AppCore.getListeAppareilsElectriques().size();i++)
							{
								if(items.indexOf(AppCore.getListeAppareilsElectriques().get(i))==-1)
								{
									NonAssoci.add(AppCore.getListeAppareilsElectriques().get(i));
							
								}
							}
								ObservableList<AppareilElectrique> itemsA = FXCollections
									.observableArrayList(NonAssoci);
							listAppareilsNonAssocies.setItems(itemsA);

						}
					}
				});

		Button boutonAjouterCuisine = new Button("Ajouter Cuisine");
		grid.add(boutonAjouterCuisine,3,1);


		Button boutonEnregistrer = new Button("Enregistrer");
		Button boutonAnnuler = new Button("Annuler");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(boutonAnnuler);
		hbBtn.getChildren().add(boutonEnregistrer);
		grid.add(hbBtn, 1, 3);
		
		Button boutonFlecheGauche = new Button("<-");
		Button boutonFlecheDroite = new Button("->");
		boutonFlecheDroite.setPrefSize(boutonFlecheDroite.getMaxHeight(), boutonFlecheDroite.getMaxWidth());
		VBox vbBtnFleches = new VBox(10);
		vbBtnFleches.setAlignment(Pos.CENTER);
		vbBtnFleches.getChildren().add(boutonFlecheDroite);
		vbBtnFleches.getChildren().add(boutonFlecheGauche);
		
		
		HBox hbflechelist = new HBox(10);
		hbflechelist.getChildren().add(vbBtnFleches);
		hbflechelist.getChildren().add(listAppareilsNonAssocies);
		grid.add(hbflechelist, 1, 2);
		

		final Text actiontarget = new Text();
		grid.add(actiontarget, 1, 6);

		final ObservableList<AppareilElectrique> itemsAppareilsAssocies= FXCollections.observableArrayList ();
		
		grid.add(listAppareilsAssocies,0 ,2);
		
		final ObservableList<AppareilElectrique> itemsAppareilsNonAssocies = FXCollections.observableArrayList (AppCore.getListeAppareilsElectriques());
			
		boutonFlecheGauche.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e)
			{
				System.out.println("go");
				System.out.println(listAppareilsNonAssocies.getSelectionModel().getSelectedItem());
				if(listAppareilsNonAssocies.getSelectionModel().getSelectedItem() != null)
				{
					
				listAppareilsAssocies.getItems().add(listAppareilsNonAssocies.getSelectionModel().getSelectedItem());
				listAppareilsNonAssocies.getItems().remove(listAppareilsNonAssocies.getSelectionModel().getSelectedItem());
				
				}
			}
		});
		
		boutonFlecheDroite.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e)
			{
				if(listAppareilsAssocies.getFocusModel().getFocusedItem() != null)
				{
					listAppareilsAssocies.getItems().add(listAppareilsNonAssocies.getSelectionModel().getSelectedItem());
					listAppareilsNonAssocies.getItems().remove(listAppareilsNonAssocies.getSelectionModel().getSelectedItem());
				}
			}
		});
		
		listAppareilsAssocies.setOnMouseClicked(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent me) {
				if(me.getClickCount() > 1)
				{
					if(listAppareilsAssocies.getFocusModel().getFocusedItem() != null)
					{
					itemsAppareilsNonAssocies.add(listAppareilsAssocies.getFocusModel().getFocusedItem());
					itemsAppareilsAssocies.remove(listAppareilsAssocies.getFocusModel().getFocusedItem());
					}
				}
				
			}});
		
		listAppareilsNonAssocies.setOnMouseClicked(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent me) {
				if(me.getClickCount() > 1)
				{
					if(listAppareilsNonAssocies.getFocusModel().getFocusedItem() != null)
					{
					itemsAppareilsAssocies.add(listAppareilsNonAssocies.getFocusModel().getFocusedItem());
					itemsAppareilsNonAssocies.remove(listAppareilsNonAssocies.getFocusModel().getFocusedItem());
					}
				}
				
			}});
		
		boutonEnregistrer.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) 
			{
				
				ArrayList<AppareilElectrique> tempArraylist = new ArrayList<AppareilElectrique>();
				tempArraylist.clear();
				for(int i = 0; i < itemsAppareilsAssocies.size() ; i++ )
				{
					tempArraylist.add(itemsAppareilsAssocies.get(i));
				}
				
				Cuisine cuisineCreee = new Cuisine (nomCuisineTextField.getValue().getNom(),tempArraylist);
				
				AppCore.RetirerCuisineFromList(MaCuisine);
				AppCore.AjouterCuisineToList(cuisineCreee);
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

		this.setScene(new Scene(grid, 800, 600));
		this.show();
		nomCuisineTextField.requestFocus();



	}


}
