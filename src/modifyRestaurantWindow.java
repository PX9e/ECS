import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class modifyRestaurantWindow extends Stage{
	
	public modifyRestaurantWindow()
	{
		final Group root = new Group();
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Text scenetitle = new Text("Modifier ou Supprimer un retaurant");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);

		Label nomCuisineLabel = new Label("Liste des restaurants:");
		grid.add(nomCuisineLabel, 0, 1);
		
		final ListView<Restaurant> listRestaurants = new ListView<Restaurant>();
		ObservableList<Restaurant> items = FXCollections.observableArrayList (AppCore.getListeRestaurants());
		listRestaurants.setItems(items);
		grid.add(listRestaurants, 1,0);

		this.setScene(new Scene(grid, 600, 400));
		this.show();
	}
}
