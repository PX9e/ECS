



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

import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;


class NewRestaurantWindow extends Stage{

	public Restaurant MonRestaurant;

	public Restaurant getMonRestaurant() {
		return MonRestaurant;
	}

	public void setMonRestaurant(Restaurant monRestaurant) {
		MonRestaurant = monRestaurant;
	}




	NewRestaurantWindow(Stage primaryStage){

		this.initModality(Modality.WINDOW_MODAL);
		this.initOwner(primaryStage);
		

		GridPane grid = new GridPane();
		
		
		
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Text scenetitle = new Text("Ajouter un restaurant");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);

		Label nomRestaurantLabel = new Label("Nom du restaurant:");
		nomRestaurantLabel.setAlignment(Pos.BOTTOM_RIGHT);
		grid.add(nomRestaurantLabel, 0, 1);

		Label listTitleLabel = new Label("Choisir une cuisine dans la liste : ");

		grid.add(listTitleLabel, 0, 2);

		final TextField nomRestaurantTextField = new TextField();
		nomRestaurantTextField.setPrefSize(15, 200);
		grid.add(nomRestaurantTextField, 1, 1);

		Button boutonEnregistrer = new Button("Enregistrer");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(boutonEnregistrer);
		grid.add(hbBtn, 1, 4);

		final ListView<Cuisine> list = new ListView<Cuisine>();
		ObservableList<Cuisine> items = FXCollections.observableArrayList (AppCore.getListeCuisines());
		list.setItems(items);
		grid.add(list,0 ,4);


		final Text actiontarget = new Text();
		grid.add(actiontarget, 1, 6);


		boutonEnregistrer.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) {
				String tempNomRestaurant = nomRestaurantTextField.getText();

				if((list.getSelectionModel().getSelectedItem() != null) && (tempNomRestaurant != null))
				{
					MonRestaurant = new Restaurant(list.getSelectionModel().getSelectedItem(),nomRestaurantTextField.getText());
					AppCore.AjouterRestaurantToList(MonRestaurant);
					actiontarget.setFill(Color.LIMEGREEN);
					actiontarget.setText("Enregistrement réussi");
					
				}
				else
				{
					actiontarget.setFill(Color.FIREBRICK);
					actiontarget.setText("Une erreur s'est produite");
				}
				close();
			}
		});
		this.setScene(new Scene(grid, 600, 400));

		this.show();



	}



}
