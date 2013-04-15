
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

class NewModifierCuisineWindow extends Stage{

	public Cuisine MaCuisine;

	NewModifierCuisineWindow(Stage primaryStage)
	{
		this.initModality(Modality.WINDOW_MODAL);
		this.initOwner(primaryStage);
		final Stage stage = this;
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Text scenetitle = new Text("Modifier une cuisine");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);

		Label nomCuisineLabel = new Label("Nom de la cuisine:");
		HBox ChoixSup = new HBox(20);
		ChoixSup.getChildren().add(nomCuisineLabel);

		final ListView<AppareilElectrique> listAppareilsAssocies= new ListView<AppareilElectrique>();
		final ListView<AppareilElectrique> listAppareilsNonAssocies = new ListView<AppareilElectrique>();
		final ComboBox<Cuisine> nomCuisineTextField = new ComboBox<Cuisine>();
		Button boutonAjouterCuisine = new Button("Supprimer Cuisine");
		

		ChoixSup.getChildren().add(nomCuisineTextField);
		ChoixSup.getChildren().add(boutonAjouterCuisine);
		
		boutonAjouterCuisine.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				if ((nomCuisineTextField.getSelectionModel().getSelectedItem() != null)) {
					
					boolean Conflit = false;
					
					for(int i = 0 ; i<AppCore.getListeRestaurants().size();i++)
					{
						if(AppCore.getListeRestaurants().get(i).getCuisine().getNom() == nomCuisineTextField.getSelectionModel().getSelectedItem().getNom())
						{
							Conflit = true;
									break;
						}
					}
					
					
					if(Conflit ==false)
					{
						final DialogBox dialogBox = new DialogBox(
								stage,
								"Attention, ceci est un choix definitif etes-vous sûr ? ",
								2);

						System.out.println(dialogBox.getAnswer());
						dialogBox.setOnHiding(new EventHandler<WindowEvent>() {

							@Override
							public void handle(WindowEvent arg0) {
								if (dialogBox.getAnswer() == true) {
									System.out.println("go");
									AppCore.RetirerCuisineFromList(nomCuisineTextField.getSelectionModel().getSelectedItem().getNom());
									nomCuisineTextField.getItems().clear();
									nomCuisineTextField.setItems(FXCollections.observableArrayList(AppCore
											.getListeCuisines()));
									listAppareilsAssocies.getItems().clear();
									listAppareilsNonAssocies.getItems().clear();
									
								}
							}

						});
					

					}
					else
					{
						@SuppressWarnings("unused")
						final DialogBox dialogBox = new DialogBox(
								stage,
								"Attention cette cuisine est toujours utilisée  !",
								1);
					}
				}
			}
		});
		grid.add(ChoixSup, 0
				, 1);
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
								if(listAppareilsAssocies.getItems().indexOf(AppCore.getListeAppareilsElectriques().get(i))==-1)
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

		
		grid.add(listAppareilsAssocies,0 ,2);
		boutonFlecheGauche.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent e)
			{
				
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
				if(listAppareilsAssocies.getSelectionModel().getSelectedItem() != null)
				{
					
					listAppareilsNonAssocies.getItems().add(listAppareilsAssocies.getSelectionModel().getSelectedItem());
					listAppareilsAssocies.getItems().remove(listAppareilsAssocies.getSelectionModel().getSelectedItem());
				}
			}
		});
		
		listAppareilsAssocies.setOnMouseClicked(new EventHandler<MouseEvent>(){
			@Override
			public void handle(MouseEvent me) {
				if(me.getClickCount() > 1)
				{
					if(listAppareilsAssocies.getSelectionModel().getSelectedItem() != null)
					{
						
						listAppareilsNonAssocies.getItems().add(listAppareilsAssocies.getSelectionModel().getSelectedItem());
						listAppareilsAssocies.getItems().remove(listAppareilsAssocies.getSelectionModel().getSelectedItem());
					}
				}
			}});
		
		listAppareilsNonAssocies.setOnMouseClicked(new EventHandler<MouseEvent>(){

			@Override
			public void handle(MouseEvent me) {
				if(me.getClickCount() > 1)
				{
					if(listAppareilsNonAssocies.getSelectionModel().getSelectedItem() != null)
					{
						
					listAppareilsAssocies.getItems().add(listAppareilsNonAssocies.getSelectionModel().getSelectedItem());
					listAppareilsNonAssocies.getItems().remove(listAppareilsNonAssocies.getSelectionModel().getSelectedItem());
					
					}
				}
				
			}});
		
		boutonEnregistrer.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) 
			{
				
				ArrayList<AppareilElectrique> tempArraylist = new ArrayList<AppareilElectrique>();
				tempArraylist.clear();
				
				for(int i = 0; i < listAppareilsAssocies.getItems().size() ; i++ )
				{
					System.out.println(listAppareilsAssocies.getItems().get(i).getNom());
					tempArraylist.add(listAppareilsAssocies.getItems().get(i));
				}
				if(nomCuisineTextField.getSelectionModel().getSelectedItem()!=null)
						{
				Cuisine cuisineCreee = new Cuisine (nomCuisineTextField.getValue().getNom(),tempArraylist);
				
				AppCore.RetirerCuisineFromList(MaCuisine.getNom());
				AppCore.AjouterCuisineToList(cuisineCreee);
				AppCore.SaveCuisine();
				AppCore.LoadCuisine();
				close();
						}
				else
				{
				close();
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

		this.setScene(new Scene(grid, 800, 600));
		this.show();
		nomCuisineTextField.requestFocus();



	}


}
