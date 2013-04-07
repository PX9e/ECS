
import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.binding.Bindings;
import javafx.beans.binding.NumberBinding;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MenuItemBuilder;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public  class main extends Application{


	private XYChart.Series<Number,Number> CuisineChart= new XYChart.Series<Number,Number>();
	private XYChart.Series<Number,Number> AppareilChart= new XYChart.Series<Number,Number>();
   
	public static void main(String[] args) {
		launch(args);
	}


	@Override
	public void start(final Stage primaryStage) {
		
		final NumberAxis xAxis = new NumberAxis(0, 24, 1);
		
	    final NumberAxis yAxis = new NumberAxis();
		final AreaChart<Number,Number> ac = new AreaChart<Number,Number>(xAxis,yAxis);
		
		ac.setTitle("Consommation electrique en fonction de la puissance en kW");
		primaryStage.setTitle("ECS");  		
		new KeyCombination() {};
		final Menu menuFichier = new Menu("Fichier");
		final Menu menuRestaurant = new Menu("Restaurant");
		final Menu menuCuisine = new Menu("Cuisine");
		final Menu menuAppareilElectrique = new Menu("Appareils Electriques");
		final Menu menuPlanAllumage = new Menu("Plans d'allumage");
		final Menu menuForfait = new Menu("Forfaits");
		final Menu menuPhase = new Menu("Phases");
		final Menu menuAide = new Menu("Aide");

		primaryStage.setOnShowing(new EventHandler<WindowEvent>()
				{

			@Override
			public void handle(WindowEvent arg0) {
				// TODO Auto-generated method stub
				if(arg0 != null)
					System.out.println(arg0.toString());
				else
					System.out.println("C'est nul !");
			}

				});

		menuPhase.getItems().add(MenuItemBuilder.create().text("Nouveau").build());
		menuPhase.getItems().add(MenuItemBuilder.create().text("Modifier").build());
		menuFichier.getItems().add(MenuItemBuilder.create()
				.text("Option")
				.onAction(
						new EventHandler<ActionEvent>()
						{
							@Override public void handle(ActionEvent e)
							{
							}
						}).accelerator( KeyCombination.keyCombination("ctrl+o")).build());

		menuFichier.getItems().add(MenuItemBuilder.create()
				.text("Quitter")
				.onAction(
						new EventHandler<ActionEvent>()
						{
							@Override public void handle(ActionEvent e)
							{
								primaryStage.close();
							}
						}).accelerator( KeyCombination.keyCombination("ctrl+q")).build());

		final ListView<Restaurant> listRestaurant = new ListView<Restaurant>();

		menuRestaurant.getItems().add(MenuItemBuilder.create()
				.text("Nouveau")
				.onAction(
						new EventHandler<ActionEvent>()
						{
							@Override public void handle(ActionEvent e)
							{
								NewRestaurantWindow maFenetreNouveauResto = new NewRestaurantWindow(primaryStage);
								maFenetreNouveauResto.setOnHiding(new EventHandler<WindowEvent>()
										{
											@Override
											public void handle(WindowEvent e) 
											{
												System.out.println("Fenetre Restruant : " + e.getEventType().toString());
												if(e.getEventType() == WindowEvent.WINDOW_HIDING)
												{
													ObservableList<Restaurant> itemsRestaurant = FXCollections.observableArrayList (AppCore.getListeRestaurants());
													listRestaurant.setItems(itemsRestaurant);
												}
											}
											});
								
								
								
								}
						}).accelerator( KeyCombination.keyCombination("ctrl+r")).build());

		menuCuisine.getItems().add(MenuItemBuilder.create()
				.text("Nouveau")
				.onAction(
						new EventHandler<ActionEvent>()
						{
							@Override public void handle(ActionEvent e)
							{
								@SuppressWarnings("unused")
								NewCuisineWindow maFenetreNouvelleCuisine = new NewCuisineWindow(primaryStage);
							}
						}).accelerator( KeyCombination.keyCombination("ctrl+c")).build());

		
		
		menuRestaurant.getItems().add(MenuItemBuilder.create()
				.text("Modifier/Supprimer")
				.onAction(
						new EventHandler<ActionEvent>()
						{
							@Override public void handle(ActionEvent e)
							{
								@SuppressWarnings("unused")
								modifyRestaurantWindow monModifyRestaurantWindow = new modifyRestaurantWindow(primaryStage);
							}
						}).accelerator( KeyCombination.keyCombination("ctrl+shift+R")).build());
		menuCuisine.getItems().add(new MenuItem("Modifier/Supprimer"));
		menuForfait.getItems().add(new MenuItem("Nouveau"));
		menuForfait.getItems().add(new MenuItem("Modifier/Supprimer"));
		menuAppareilElectrique.getItems().add(MenuItemBuilder.create()
				.text("Nouveau")
				.onAction(
						new EventHandler<ActionEvent>()
						{
							@Override public void handle(ActionEvent e)
							{
								@SuppressWarnings("unused")
								newAppareilWindow monAppareilWindow = new newAppareilWindow(primaryStage);
							}
						}).accelerator( KeyCombination.keyCombination("ctrl+E")).build());
		menuAppareilElectrique.getItems().add(new MenuItem("Modifier/Supprimer"));
		menuPlanAllumage.getItems().add(MenuItemBuilder.create()
				.text("Nouveau")
				.onAction(
						new EventHandler<ActionEvent>()
						{
							@Override public void handle(ActionEvent e)
							{
								newPlanAllumage maFenetreNouveauResto = new newPlanAllumage();
								maFenetreNouveauResto.setOnHiding(new EventHandler<WindowEvent>()
										{
											@Override
											public void handle(WindowEvent e) 
											{
												System.out.println("Fenetre Restruant : " + e.getEventType().toString());
												if(e.getEventType() == WindowEvent.WINDOW_HIDING)
												{
													ObservableList<Restaurant> itemsRestaurant = FXCollections.observableArrayList (AppCore.getListeRestaurants());
													listRestaurant.setItems(itemsRestaurant);
												}
											}
											});
								
								
								
								}
						}).accelerator( KeyCombination.keyCombination("ctrl+p")).build());

		menuPlanAllumage.getItems().add(MenuItemBuilder.create()
				.text("Modifier/Supprimer")
				.onAction(
						new EventHandler<ActionEvent>()
						{
							@Override public void handle(ActionEvent e)
							{
								modifyPlanAllumage maFenetreNouveauResto = new modifyPlanAllumage();
								maFenetreNouveauResto.setOnHiding(new EventHandler<WindowEvent>()
										{
											@Override
											public void handle(WindowEvent e) 
											{
												System.out.println("Fenetre Restruant : " + e.getEventType().toString());
												if(e.getEventType() == WindowEvent.WINDOW_HIDING)
												{
													ObservableList<Restaurant> itemsRestaurant = FXCollections.observableArrayList (AppCore.getListeRestaurants());
													listRestaurant.setItems(itemsRestaurant);
												}
											}
											});
								}
						}).accelerator( KeyCombination.keyCombination("ctrl+shift+p")).build());
		menuAide.getItems().add(new MenuItem("Guide Utilisateur"));

		MenuBar menuBar = new MenuBar();

		menuBar.getMenus().addAll(menuFichier, menuRestaurant, menuCuisine, menuAppareilElectrique,menuPlanAllumage,menuForfait,menuAide);

		/*******************Afficchage des restau et leurs cuisines *********************/

		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		final Label CuisineTitleLabel = new Label("Cuisines du restaurant");
		grid.add(CuisineTitleLabel, 1, 0);
		CuisineTitleLabel.setVisible(false); 


		final ListView<Cuisine> listCuisine = new ListView<Cuisine>();
		ObservableList<Cuisine> itemsCuisine = FXCollections.observableArrayList (AppCore.getListeCuisines());
		listCuisine.setItems(itemsCuisine);
		listCuisine.setPrefHeight(350);
		listCuisine.setPrefWidth(200);
		grid.add(listCuisine,1 ,1);
		listCuisine.setVisible(false);

		final Label AppareilTitleLabel = new Label("Appareils Électriques de la cuisine");
		grid.add(AppareilTitleLabel, 2, 0);
		AppareilTitleLabel.setVisible(false); 


		final ListView<AppareilElectrique> listAppareil = new ListView<AppareilElectrique>();
		ObservableList<AppareilElectrique> itemsAppareil = FXCollections.observableArrayList (AppCore.getListeAppareilsElectriques());
		listAppareil.setItems(itemsAppareil);
		listAppareil.setPrefHeight(350);
		listAppareil.setPrefWidth(200);
		grid.add(listAppareil,2 ,1);
		listAppareil.setVisible(false);
		
		Label RestaurantTitleLabel = new Label("Nom du restaurant:");
		grid.add(RestaurantTitleLabel, 0, 0);

		
		ObservableList<Restaurant> itemsRestaurant = FXCollections.observableArrayList (AppCore.getListeRestaurants());
		listRestaurant.setItems(itemsRestaurant);
		listRestaurant.setPrefHeight(350);
		listRestaurant.setPrefWidth(200);
		grid.add(listRestaurant,0 ,1);

	
		listAppareil.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				AppareilChart.setName(listAppareil.getSelectionModel().getSelectedItem().getNom());
				
			
				ArrayList<Double> Data = new ArrayList<Double>(1440);
				
				for(int i=0;i<1440;i++)
				{
					Data.add(0.0);
				}
				
				AppareilElectrique AppareilsAAnalyser = AppCore.getAppareilFromName(listAppareil.getSelectionModel().getSelectedItem().getNom());
				
			
					for(int o = 0 ; o<AppareilsAAnalyser.getCouples().size();o=o+2)
					{
				
						Mode MyMode = AppareilsAAnalyser.getModesByName(AppareilsAAnalyser.getCouples().get(o));
						PlanAllumage MyPlan = AppCore.getPlanAllumage(AppareilsAAnalyser.getCouples().get(o+1));
					
						
						ArrayList<PlageHoraire> MesHoraires = MyPlan.getPlageHoraire("Lundi");
					
						for(int u=0;u<MesHoraires.size();u++)
						{
							
							
							int start = MesHoraires.get(u).getDebut().getHeures() * 60 + MesHoraires.get(u).getDebut().getMinutes();
							System.out.println(MesHoraires.get(u).getDebut().getHeures() + " *60+ "+MesHoraires.get(u).getDebut().getMinutes()+" =" +  start);
							int fin = MesHoraires.get(u).getFin().getHeures() * 60 + MesHoraires.get(u).getFin().getMinutes();
							System.out.println(MesHoraires.get(u).getFin().getHeures() + " *60+ "+ MesHoraires.get(u).getFin().getMinutes()+" =" +  fin);
							
							
							System.out.println();
							if((fin-start)>(MyMode.getDown().size() + MyMode.getUp().size()))
							{
								
								for(int p = start ; p<start+MyMode.getUp().size();p++)
								{
									Data.set(p, Data.get(p)+MyMode.getUp().get(p-start));
									
								}
								
								for(int p = start+MyMode.getUp().size();p<fin-MyMode.getDown().size();p++)
								{
									Data.set(p, Data.get(p)+MyMode.getUp().get(MyMode.getUp().size()-1));
					
								}
								for(int p = fin-MyMode.getDown().size();p<fin;p++)
								{
									Data.set(p, Data.get(p)+MyMode.getDown().get(fin-MyMode.getDown().size()-p));
					
								}
							}
							
						}
						
					}	
				
				ac.getData().remove(AppareilChart);
				AppareilChart.getData().clear();
				AppareilChart.getData().add(new XYChart.Data((0), Data.get(0)));
				for(int i = 1 ; i<Data.size()-1;i++)
				{
					if((Data.get(i)-Data.get(i-1)!=0)||(Data.get(i)-Data.get(i+1)!=0))
					{
						AppareilChart.getData().add(new XYChart.Data((double)(i/60.0), Data.get(i)));
					}
				}
				AppareilChart.getData().add(new XYChart.Data(24, Data.get(1439)));
				ac.getData().addAll(AppareilChart);
				 
			}
		}); 
		listRestaurant.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				getCuisineChart().setName("Consommation Cuisine");
				Restaurant restaurantClique = listRestaurant.getFocusModel().getFocusedItem();
				ObservableList<Cuisine> itemsCuisine = FXCollections.observableArrayList (restaurantClique.getCuisine());
				listCuisine.setItems(itemsCuisine);
				listCuisine.setVisible(true);
				CuisineTitleLabel.setVisible(true);
				ArrayList<Double> Data = new ArrayList<Double>(1440);
				
				for(int i=0;i<1440;i++)
				{
					Data.add(0.0);
				}
				
				ArrayList<AppareilElectrique> AppareilsAAnalyser = restaurantClique.getCuisine().ObtenirAppareils();
				
				for(int t=0 ; t<AppareilsAAnalyser.size();t++)
				{
					
					for(int o = 0 ; o<AppareilsAAnalyser.get(t).getCouples().size();o=o+2)
					{
						System.out.println(AppareilsAAnalyser.get(t).getCouples().get(o));
						Mode MyMode = AppareilsAAnalyser.get(t).getModesByName(AppareilsAAnalyser.get(t).getCouples().get(o));
						PlanAllumage MyPlan = AppCore.getPlanAllumage(AppareilsAAnalyser.get(t).getCouples().get(o+1));
					
						
						ArrayList<PlageHoraire> MesHoraires = MyPlan.getPlageHoraire("Lundi");
					
						for(int u=0;u<MesHoraires.size();u++)
						{
							int start = MesHoraires.get(u).getDebut().getHeures() * 60 + MesHoraires.get(u).getDebut().getMinutes();
							System.out.println(MesHoraires.get(u).getDebut().getHeures() + " *60+ "+MesHoraires.get(u).getDebut().getMinutes()+" =" +  start);
							int fin = MesHoraires.get(u).getFin().getHeures() * 60 + MesHoraires.get(u).getFin().getMinutes();
							System.out.println(MesHoraires.get(u).getFin().getHeures() + " *60+ "+ MesHoraires.get(u).getFin().getMinutes()+" =" +  fin);
							
							
							System.out.println(MyMode.getName());
							if((fin-start)>(MyMode.getDown().size() + MyMode.getUp().size()))
							{
								
								for(int p = start ; p<start+MyMode.getUp().size();p++)
								{
									Data.set(p, Data.get(p)+MyMode.getUp().get(p-start));
									System.out.println(Data.get(p));
								}
								
								for(int p = start+MyMode.getUp().size();p<fin-MyMode.getDown().size();p++)
								{
									Data.set(p, Data.get(p)+MyMode.getUp().get(MyMode.getUp().size()-1));
									System.out.println(Data.get(p));
								}
								for(int p = fin-MyMode.getDown().size();p<fin;p++)
								{
									Data.set(p, Data.get(p)+MyMode.getDown().get(p-fin-MyMode.getDown().size()+2));
									System.out.println(Data.get(p));
								}
							}
							
						}
						
					}	
				}
				ac.getData().remove(getCuisineChart());
				
				getCuisineChart().getData().clear();
				getCuisineChart().getData().add(new XYChart.Data((0), Data.get(0)));
				for(int i = 1 ; i<Data.size()-1;i++)
				{
					if((Data.get(i)-Data.get(i-1)!=0)||(Data.get(i)-Data.get(i+1)!=0))
					{
						getCuisineChart().getData().add(new XYChart.Data((double)(i/60.0), Data.get(i)));
					}
				}
				getCuisineChart().getData().add(new XYChart.Data(24, Data.get(1439)));
				ac.getData().addAll(getCuisineChart());
				 
			}
		}); 
		
		listCuisine.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				Cuisine cuisineClique = listCuisine.getFocusModel().getFocusedItem();
				ObservableList<AppareilElectrique> itemsAppareil = FXCollections.observableArrayList (cuisineClique.ObtenirAppareils());
				listAppareil.setItems(itemsAppareil);
				listAppareil.setVisible(true);
				AppareilTitleLabel.setVisible(true);
			}
			
		});



		/*******************Fin Affichage des restaurants et leurs cuisines *********************/

		
	    xAxis.setMinorTickCount(0);
		
		
	    ac.setPadding(new Insets(30));
	    GridPane Grille = new GridPane();
	    GridPane MainGrille = new GridPane();
	    
	    Grille.add(ac, 0, 0);
		final Group root = new Group();  
		MainGrille.add(grid, 0, 0);
		MainGrille.add(Grille, 0, 1);
		
		grid.setStyle(" -fx-background-image: url(\"background_image.jpg\"); ");
		Grille.setStyle(" -fx-background-image: url(\"background_image.jpg\"); ");
		
		
		root.getChildren().add(MainGrille);
		root.getChildren().add(menuBar);	
		Scene MyScene = new Scene(root, 1000, 600);
		menuBar.prefWidthProperty().bind(primaryStage.widthProperty());
		MainGrille.prefWidthProperty().bind(primaryStage.widthProperty());
		Grille.prefWidthProperty().bind(primaryStage.widthProperty());
		grid.prefWidthProperty().bind(primaryStage.widthProperty());
		grid.setAlignment(Pos.BASELINE_LEFT);
		ac.prefWidthProperty().bind(primaryStage.widthProperty());
		Grille.setAlignment(Pos.BASELINE_CENTER);
		MyScene.getStylesheets().add(main.class.getResource("style.css").toExternalForm());
		
		NumberBinding multiplication = Bindings.divide(primaryStage.heightProperty(),2);
		Grille.prefHeightProperty().bind(primaryStage.heightProperty());
		grid.prefHeightProperty().bind(multiplication);
		ac.prefHeightProperty().bind(multiplication);
		
		primaryStage.setScene(MyScene);
		
		AppCore.LoadPlanAllumage();
		AppCore.LoadAppareilElectrique();
		AppCore.LoadCuisine();
		AppCore.LoadRestaurant();	
				
		primaryStage.show();
		ObservableList<Restaurant> itemsRestaurantB = FXCollections.observableArrayList (AppCore.getListeRestaurants());
		listRestaurant.setItems(itemsRestaurantB);
		ObservableList<Cuisine> itemsCuisineB = FXCollections.observableArrayList (AppCore.getListeCuisines());
		listCuisine.setItems(itemsCuisineB);

	}


	public XYChart.Series getCuisineChart() {
		return CuisineChart;
	}


	public void setCuisineChart(XYChart.Series cuisineChart) {
		CuisineChart = cuisineChart;
	}
	
}