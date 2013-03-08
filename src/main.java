
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class main extends Application {
    
	public static void main(String[] args) {
        launch(args);
    }
    
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("ECS");    

        final Menu menuFichier = new Menu("Fichier");
        final Menu menuRestaurant = new Menu("Restaurant");
        final Menu menuCuisine = new Menu("Cuisine");
        final Menu menuAppareilElectrique = new Menu("Appareils Electriques");
        final Menu menuPlanAllumage = new Menu("Plans d'allumage");
        final Menu menuForfait = new Menu("Forfaits");
        final Menu menuAide = new Menu("Aide");
        
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menuFichier, menuRestaurant, menuCuisine, menuAppareilElectrique,menuPlanAllumage,menuForfait,menuAide);
        
      
        
        StackPane root = new StackPane();
        root.getChildren().add(menuBar);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}