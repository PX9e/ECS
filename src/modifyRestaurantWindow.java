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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


public class modifyRestaurantWindow extends Stage{

	public modifyRestaurantWindow(Stage maitre)
	{
		this.initModality(Modality.WINDOW_MODAL);
		this.initOwner(maitre);
		final Stage stage = this;
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Text scenetitle = new Text("Modifier ou Supprimer un restaurant");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);

		Label listRestaurantLabel = new Label("Liste des restaurants:");
		grid.add(listRestaurantLabel, 0, 1);

		final ListView<Restaurant> listRestaurants = new ListView<Restaurant>();
		final ObservableList<Restaurant> items = FXCollections.observableArrayList (AppCore.getListeRestaurants());
		listRestaurants.setItems(items);
		grid.add(listRestaurants, 0, 2);

		Label recapLabelRecap = new Label("Récapitulatif : ");
	
		Label recapLabelCuisine = new Label("Cuisine : ");
		final ComboBox<Cuisine> comboCuisines = new ComboBox<Cuisine>();

		comboCuisines.setPrefSize(150, 50);
		Label recapListAppareils = new Label("Liste des appareils associés : ");
		final ListView<AppareilElectrique> listAppareilsAssocies = new ListView<AppareilElectrique>();

		HBox hbRestaurant = new HBox(10);
	

		HBox hbCuisine = new HBox(10);
		hbCuisine.getChildren().add(recapLabelCuisine);
		hbCuisine.getChildren().add(comboCuisines);


		VBox vbRecap = new VBox(10);
		vbRecap.getChildren().add(recapLabelRecap);
		vbRecap.getChildren().add(hbRestaurant);
		vbRecap.getChildren().add(hbCuisine);
		vbRecap.getChildren().add(recapListAppareils);
		vbRecap.getChildren().add(listAppareilsAssocies);
		grid.add(vbRecap,1,2);

		Button boutonEnregistrer = new Button("Enregistrer");
		Button boutonAnnuler = new Button("Annuler");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(boutonAnnuler);
		hbBtn.getChildren().add(boutonEnregistrer);
		grid.add(hbBtn, 1, 4);

		Button boutonSupprimer = new Button("Supprimer");
		HBox hbBtnSupMod = new HBox(10);
		hbBtnSupMod.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtnSupMod.getChildren().add(boutonSupprimer);
		grid.add(hbBtnSupMod, 1, 3);

		listRestaurants.setOnMouseClicked(new EventHandler<MouseEvent>() 
				{

			@Override
			public void handle(MouseEvent me) 
			{
				Restaurant selectedRestaurant = listRestaurants.getFocusModel().getFocusedItem(); 
				final ObservableList<Cuisine> itemsCuisineCombo = FXCollections.observableArrayList (AppCore.getListeCuisines());
				comboCuisines.setItems(itemsCuisineCombo);
				comboCuisines.getSelectionModel().select(selectedRestaurant.getCuisine());
				final ObservableList<AppareilElectrique> itemsAppareilsList = FXCollections.observableArrayList (comboCuisines.getSelectionModel().getSelectedItem().ObtenirAppareils());
				listAppareilsAssocies.setItems(itemsAppareilsList);
			}
				});

		comboCuisines.setOnMouseClicked(new EventHandler<MouseEvent>() 
				{

			@Override
			public void handle(MouseEvent me) 
			{
				final ObservableList<AppareilElectrique> itemsAppareilsList = FXCollections.observableArrayList (comboCuisines.getSelectionModel().getSelectedItem().ObtenirAppareils());
				listAppareilsAssocies.setItems(itemsAppareilsList);
			}
				});

				boutonSupprimer.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent ae) 
					{ 
						final DialogBox dialogBox = new DialogBox(stage,"Etes vous sur de faire cela ?",2);

						dialogBox.setOnHiding(new EventHandler<WindowEvent>() 
								{

							@Override
							public void handle(WindowEvent arg0) 
							{						
								if(dialogBox.getAnswer()==true)
								{
									AppCore.RetirerRestaurantFromList(listRestaurants.getFocusModel().getFocusedItem());
									items.remove(listRestaurants.getFocusModel().getFocusedItem());
								}
							}

								});
					}
				});
				
				boutonEnregistrer.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent ae) 
					{
						
						Restaurant Temp = new Restaurant(comboCuisines.getSelectionModel().getSelectedItem(),listRestaurants.getSelectionModel().getSelectedItem().getNom());
						AppCore.RetirerRestaurantFromList(listRestaurants.getSelectionModel().getSelectedItem().getNom());
						AppCore.AjouterRestaurantToList(Temp);
						AppCore.SaveRestaurant();
						AppCore.SaveCuisine();
						//AppCore.SaveAppareilElectrique();
						close();
					}
				});
				
				boutonAnnuler.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent arg0) {
						// TODO Auto-generated method stub
						AppCore.LoadRestaurant();
						AppCore.LoadCuisine();
						//AppCore.LoadAppareilElectrique();
						close();
					}
					
				});

		this.setScene(new Scene(grid, 600, 400));
		this.show();
	}
}
