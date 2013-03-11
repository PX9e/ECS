
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MenuItemBuilder;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 

class NewRestaurantWindow {

	Restaurant MonRestaurant;

	public Restaurant getMonRestaurant() {
		return MonRestaurant;
	}

	public void setMonRestaurant(Restaurant monRestaurant) {
		MonRestaurant = monRestaurant;
	}
	
	NewRestaurantWindow(){
		Stage Window = new Stage();
		final Group root = new Group();
		
		Window.setScene(new Scene(root, 400, 400));
		Window.show();
		
	}
	
	
}
