
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public  class main extends Application{


	private XYChart.Series<Number,Number> CuisineChart= new XYChart.Series<Number,Number>();
	private XYChart.Series<Number,Number> AppareilChart= new XYChart.Series<Number,Number>();
	private XYChart.Series<Number,Number> HighLimit= new XYChart.Series<Number,Number>();
	final ListView<Restaurant> listRestaurant = new ListView<Restaurant>();
	final ListView<Cuisine> listCuisine = new ListView<Cuisine>();
	final ListView<AppareilElectrique> listAppareil = new ListView<AppareilElectrique>();
	final NumberAxis xAxis = new NumberAxis(0, 24, 1);
    final NumberAxis yAxis = new NumberAxis();
	final AreaChart<Number,Number> ac = new AreaChart<Number,Number>(xAxis,yAxis);
	boolean Picccc= false;
	Label PrixValue = new Label();
	Label ConsoValue = new Label();
	Label DepassementValue = new Label();
	@SuppressWarnings(value = { "all" })
	public static void main(String[] args) {
		launch(args);
	}


	@Override
	public void start(final Stage primaryStage) {
		
		
	
		
		ac.setTitle("Consommation electrique en fonction de la puissance en W");
		primaryStage.setTitle("ECS");
		HighLimit.setName("Puissance Max");
		new KeyCombination() {};
		final Menu menuFichier = new Menu("Fichier");
		final Menu menuRestaurant = new Menu("Restaurant");
		final Menu menuCuisine = new Menu("Cuisine");
		final Menu menuAppareilElectrique = new Menu("Appareils Electriques");
		final Menu menuPlanAllumage = new Menu("Plans d'allumage");
		final Menu menuForfait = new Menu("Forfaits");
		final Menu menuPhase = new Menu("Phases");
		final Menu menuAide = new Menu("Aide");

		

		menuPhase.getItems().add(MenuItemBuilder.create().text("Nouveau").build());
		menuPhase.getItems().add(MenuItemBuilder.create().text("Modifier").build());
	
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
											
												if(e.getEventType() == WindowEvent.WINDOW_HIDING)
												{
													refreshListAll();

													DrawGrapB();
													DrawGraphA();
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
								
								NewCuisineWindow maFenetreNouvelleCuisine = new NewCuisineWindow(primaryStage);
								maFenetreNouvelleCuisine.setOnHiding(new EventHandler<WindowEvent>()
										{
											@Override
											public void handle(WindowEvent e) 
											{
											
												if(e.getEventType() == WindowEvent.WINDOW_HIDING)
												{
													refreshListAll();

													DrawGrapB();
													DrawGraphA();
												}
											}
											});
								
							}
						}).accelerator( KeyCombination.keyCombination("ctrl+c")).build());
		menuCuisine.getItems().add(MenuItemBuilder.create()
				.text("Modifier/Supprimer")
				.onAction(
						new EventHandler<ActionEvent>()
						{
							@Override public void handle(ActionEvent e)
							{
								
								NewModifierCuisineWindow maFenetreNouvelleCuisine = new NewModifierCuisineWindow(primaryStage);
								maFenetreNouvelleCuisine.setOnHiding(new EventHandler<WindowEvent>()
										{
											@Override
											public void handle(WindowEvent e) 
											{
											
												if(e.getEventType() == WindowEvent.WINDOW_HIDING)
												{
													refreshListAll();

													DrawGrapB();
													DrawGraphA();
												}
											}
											});
								
							}
						}).accelerator( KeyCombination.keyCombination("ctrl+shift+C")).build());
		menuRestaurant.getItems().add(MenuItemBuilder.create()
				.text("Modifier/Supprimer")
				.onAction(
						new EventHandler<ActionEvent>()
						{
							@Override public void handle(ActionEvent e)
							{
								
								modifyRestaurantWindow monModifyRestaurantWindow = new modifyRestaurantWindow(primaryStage);
								monModifyRestaurantWindow.setOnHiding(new EventHandler<WindowEvent>()
										{
											@Override
											public void handle(WindowEvent e) 
											{
											
												if(e.getEventType() == WindowEvent.WINDOW_HIDING)
												{
													refreshListAll();

													DrawGrapB();
													DrawGraphA();
												}
											}
											});
							}
						}).accelerator( KeyCombination.keyCombination("ctrl+shift+R")).build());
		menuForfait.getItems().add(MenuItemBuilder.create()
				.text("Configurer")
				.onAction(
						new EventHandler<ActionEvent>()
						{
							@Override public void handle(ActionEvent e)
							{
								newForfait monAppareilWindow = new newForfait(primaryStage);
								monAppareilWindow.setOnHiding(new EventHandler<WindowEvent>()
										{
											@Override
											public void handle(WindowEvent e) 
											{
											
												if(e.getEventType() == WindowEvent.WINDOW_HIDING)
												{
													refreshListAll();

													DrawGrapB();
													DrawGraphA();
												}
											}
											});
							}
						}).accelerator( KeyCombination.keyCombination("ctrl+F")).build());
	
		menuAppareilElectrique.getItems().add(MenuItemBuilder.create()
				.text("Nouveau")
				.onAction(
						new EventHandler<ActionEvent>()
						{
							@Override public void handle(ActionEvent e)
							{
								newAppareilWindow monAppareilWindow = new newAppareilWindow(primaryStage);
								monAppareilWindow.setOnHiding(new EventHandler<WindowEvent>()
										{
											@Override
											public void handle(WindowEvent e) 
											{
											
												if(e.getEventType() == WindowEvent.WINDOW_HIDING)
												{
													refreshListAll();

													DrawGrapB();
													DrawGraphA();
												}
											}
											});
							}
						}).accelerator( KeyCombination.keyCombination("ctrl+E")).build());
		menuAppareilElectrique.getItems().add(MenuItemBuilder.create()
				.text("Modifier/Supprimer")
				.onAction(
						new EventHandler<ActionEvent>()
						{
							@Override public void handle(ActionEvent e)
							{	
								newModifierAppareilWindow monAppareilWindow = new newModifierAppareilWindow(primaryStage);
								monAppareilWindow.setOnHiding(new EventHandler<WindowEvent>()
										{
											@Override
											public void handle(WindowEvent e) 
											{
											
												if(e.getEventType() == WindowEvent.WINDOW_HIDING)
												{
													refreshListAll();

													DrawGrapB();
													DrawGraphA();
												}
											}
											});
							}
						}).accelerator( KeyCombination.keyCombination("ctrl+shift+E")).build());
		menuPlanAllumage.getItems().add(MenuItemBuilder.create()
				.text("Nouveau")
				.onAction(
						new EventHandler<ActionEvent>()
						{
							@Override public void handle(ActionEvent e)
							{
								newPlanAllumage maFenetreNouveauResto = new newPlanAllumage(primaryStage);
								maFenetreNouveauResto.setOnHiding(new EventHandler<WindowEvent>()
										{
											@Override
											public void handle(WindowEvent e) 
											{
											
												if(e.getEventType() == WindowEvent.WINDOW_HIDING)
												{
													System.out
															.println("coolA");
													refreshListAll();
												
													DrawGrapB();
													DrawGraphA();
												}
												if(e.getEventType() == WindowEvent.WINDOW_CLOSE_REQUEST)
												{
													System.out
															.println("cool");
													refreshListAll();
												
													DrawGrapB();
													DrawGraphA();
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
								modifyPlanAllumage maFenetreNouveauResto = new modifyPlanAllumage(primaryStage);
								maFenetreNouveauResto.setOnHiding(new EventHandler<WindowEvent>()
										{
											@Override
											public void handle(WindowEvent e) 
											{
												
												if(e.getEventType() == WindowEvent.WINDOW_HIDING)
												{
													System.out
															.println("coolA");
													refreshListAll();
												
													DrawGrapB();
													DrawGraphA();
												}
												if(e.getEventType() == WindowEvent.WINDOW_CLOSE_REQUEST)
												{
													System.out
															.println("cool");
													refreshListAll();
												
													DrawGrapB();
													DrawGraphA();
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


		
		
		listCuisine.setPrefHeight(350);
		listCuisine.setPrefWidth(200);
		grid.add(listCuisine,1 ,1);
		listCuisine.setVisible(false);

		final Label AppareilTitleLabel = new Label("Appareils Électriques de la cuisine");
		grid.add(AppareilTitleLabel, 2, 0);
		AppareilTitleLabel.setVisible(false); 

		
		listAppareil.setPrefHeight(350);
		listAppareil.setPrefWidth(200);
		grid.add(listAppareil,2 ,1);
		listAppareil.setVisible(false);
		VBox Summary = new VBox(10);
		HBox Price = new HBox(10);
		HBox ConsoH = new HBox(10);
		HBox DepassementH = new HBox(10);
		Label Prix  = new Label("Coût : ");
		
		Label Conso = new Label("Consommation : ");
		
		Label Depassement = new Label("Depassement :");
		
		ConsoH.getChildren().add(Conso);
		ConsoH.getChildren().add(ConsoValue);
		Price.getChildren().add(Prix);
		Price.getChildren().add(PrixValue);
		DepassementH.getChildren().add(Depassement);
		DepassementH.getChildren().add(DepassementValue);
		Summary.getChildren().add(Price);
		Summary.getChildren().add(ConsoH);
		Summary.getChildren().add(DepassementH);
		grid.add(Summary, 3, 1);
		
		Label RestaurantTitleLabel = new Label("Nom du restaurant:");
		grid.add(RestaurantTitleLabel, 0, 0);

		
		
		listRestaurant.setPrefHeight(350);
		listRestaurant.setPrefWidth(200);
		grid.add(listRestaurant,0 ,1);

		listAppareil.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				
				DrawGraphA();
			}
		}); 
		listRestaurant.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				if(listRestaurant.getSelectionModel().getSelectedItem()!=null)
				{
				listAppareil.getItems().clear();
				refreshListB();
				listCuisine.setVisible(true);
				CuisineTitleLabel.setVisible(true);
				DrawGrapB();
				}
			}
		}); 
		
		listCuisine.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent e) {
				
				refreshListC();
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
		
		NumberBinding multiplication = Bindings.divide(primaryStage.heightProperty(),2.05);
		Grille.prefHeightProperty().bind(primaryStage.heightProperty());
		grid.prefHeightProperty().bind(multiplication);
		ac.prefHeightProperty().bind(multiplication);
		
		primaryStage.setScene(MyScene);
		
		
		primaryStage.show();
		refreshListAll();

	}


	private void refreshListAll()
	{
		AppCore.LoadForfait();
		AppCore.LoadPlanAllumage();
		AppCore.LoadAppareilElectrique();
		AppCore.LoadCuisine();
		AppCore.LoadRestaurant();
		refreshListA();
		refreshListB();
		refreshListC();
	}
	private void refreshListA()
	{
		ObservableList<Restaurant> itemsRestaurant = FXCollections.observableArrayList (AppCore.getListeRestaurants());
		listRestaurant.setItems(itemsRestaurant);
	}
	private void refreshListB()
	{
		if(listRestaurant.getSelectionModel().getSelectedItem()!=null)
		{
		
		ObservableList<Cuisine> itemsCuisine = FXCollections.observableArrayList (listRestaurant.getSelectionModel().getSelectedItem().getCuisine());
		listCuisine.setItems(itemsCuisine);
		}
		}
	
	private void refreshListC()
	{
		if(listCuisine.getSelectionModel().getSelectedItem()!=null)
		{
		ObservableList<AppareilElectrique> itemsAppareil = FXCollections.observableArrayList (listCuisine.getSelectionModel().getSelectedItem().ObtenirAppareils());
		listAppareil.setItems(itemsAppareil);
		}
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void DrawGraphA()
	{
		
		ac.setAnimated(false);
		if(listAppareil.getSelectionModel().getSelectedItem()!=null)
		{
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
					
					int fin = MesHoraires.get(u).getFin().getHeures() * 60 + MesHoraires.get(u).getFin().getMinutes();
					
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
		ac.getData().clear();
		
		ac.getData().retainAll();
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
	
		double SumA = 0.0;
		double SumB = 0.0;
		int NbPic = 0 ;
		if(AppCore.getTHEFORFAIT()!=null)
		{
			
			for(int i = 0; i<Data.size();i++)
			{
				if(AppCore.getTHEFORFAIT().getPleineH().getDebut().toInt()<AppCore.getTHEFORFAIT().getCreuseH().getFin().toInt())
				{
					if((i >= AppCore.getTHEFORFAIT().getPleineH().getDebut().toInt())&&(i<AppCore.getTHEFORFAIT().getCreuseH().getFin().toInt()))
					{
						SumA = SumA + Data.get(i);
					}
					else
					{
						SumB = SumB + Data.get(i);
					}
				}
				else
				{
					if((i <= AppCore.getTHEFORFAIT().getPleineH().getDebut().toInt())&&(i>=AppCore.getTHEFORFAIT().getCreuseH().getFin().toInt()))
					{
						SumA = SumA + Data.get(i);
					}
					else
					{
						SumB = SumB + Data.get(i);
					}
				}
				if(Data.get(i)>AppCore.getTHEFORFAIT().getPic())
				{
					NbPic = NbPic +1 ;
				}
			}
			double Cout = ((SumA/60) * AppCore.getTHEFORFAIT().getPleine()/100 + (SumB/60) * AppCore.getTHEFORFAIT().getCreuse()/100)/1000;
			double Consom = ((SumA +SumB)/60)/1000;
			PrixValue.setText(Double.toString(Cout) + " €");
			ConsoValue.setText(Double.toString(Consom)+ " kWh");
			DepassementValue.setText(Integer.toString(NbPic));
			if((NbPic > 0 )||(Picccc==true))
			{ 
				
				HighLimit.getData().clear();
				HighLimit.getData().add(new XYChart.Data(0,AppCore.getTHEFORFAIT().getPic()));

				HighLimit.getData().add(new XYChart.Data(24,AppCore.getTHEFORFAIT().getPic()));
				
			
				ac.getData().add(CuisineChart);
				ac.getData().add(AppareilChart);
				ac.getData().add(HighLimit);
		
			}
			else
			{
		
			ac.getData().add(CuisineChart);
			ac.getData().add(AppareilChart);
			}
			ac.setAnimated(false);
		}
		
		}
		
		 
	}
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void DrawGrapB()
	{
	
		getCuisineChart().setName("Consommation Cuisine");
		
		if(listRestaurant.getSelectionModel().getSelectedItem() != null)
		{	
		Restaurant restaurantClique = listRestaurant.getSelectionModel().getSelectedItem();
		
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
				
				Mode MyMode = AppareilsAAnalyser.get(t).getModesByName(AppareilsAAnalyser.get(t).getCouples().get(o));
				PlanAllumage MyPlan = AppCore.getPlanAllumage(AppareilsAAnalyser.get(t).getCouples().get(o+1));
			
				
				ArrayList<PlageHoraire> MesHoraires = MyPlan.getPlageHoraire("Lundi");
			
				for(int u=0;u<MesHoraires.size();u++)
				{
					int start = MesHoraires.get(u).getDebut().getHeures() * 60 + MesHoraires.get(u).getDebut().getMinutes();
				
					int fin = MesHoraires.get(u).getFin().getHeures() * 60 + MesHoraires.get(u).getFin().getMinutes();
				
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
							Data.set(p, Data.get(p)+MyMode.getDown().get(p-fin-MyMode.getDown().size()+2));
							
						}
					}
					
				}
				
			}	
		}
		
		
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
		
		ac.getData().retainAll();
		ac.getData().clear();
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
		
		
		double SumA = 0.0;
		double SumB = 0.0;
		int NbPic = 0 ;
		if(AppCore.getTHEFORFAIT()!=null)
		{
			
			for(int i = 0; i<Data.size();i++)
			{
				if(AppCore.getTHEFORFAIT().getPleineH().getDebut().toInt()<AppCore.getTHEFORFAIT().getCreuseH().getFin().toInt())
				{
					if((i >= AppCore.getTHEFORFAIT().getPleineH().getDebut().toInt())&&(i<AppCore.getTHEFORFAIT().getCreuseH().getFin().toInt()))
					{
						SumA = SumA + Data.get(i);
					}
					else
					{
						SumB = SumB + Data.get(i);
					}
				}
				else
				{
					if((i <= AppCore.getTHEFORFAIT().getPleineH().getDebut().toInt())&&(i>=AppCore.getTHEFORFAIT().getCreuseH().getFin().toInt()))
					{
						SumA = SumA + Data.get(i);
					}
					else
					{
						SumB = SumB + Data.get(i);
					}
				}
				if(Data.get(i)>AppCore.getTHEFORFAIT().getPic())
				{
					NbPic = NbPic +1 ;
				}
			}
			double Cout = ((SumA/60) * AppCore.getTHEFORFAIT().getPleine()/100 + (SumB/60) * AppCore.getTHEFORFAIT().getCreuse()/100)/1000;
			double Consom = ((SumA +SumB)/60)/1000;
			PrixValue.setText(Double.toString(Cout) + " €");
			ConsoValue.setText(Double.toString(Consom)+ " kWh");
			DepassementValue.setText(Integer.toString(NbPic));
			if(NbPic > 0 )
			{ 
				
				HighLimit.getData().clear();
				HighLimit.getData().add(new XYChart.Data(0,AppCore.getTHEFORFAIT().getPic()));

				HighLimit.getData().add(new XYChart.Data(24,AppCore.getTHEFORFAIT().getPic()));
				
			
				ac.getData().add(CuisineChart);
				//ac.getData().add(AppareilChart);
				ac.getData().add(HighLimit);
				Picccc = true;
		
			}
			else
			{
			Picccc = false;
			ac.getData().add(CuisineChart);
			//ac.getData().add(AppareilChart);
			}
		}
		ac.setAnimated(true);}
	}
	@SuppressWarnings("rawtypes")
		
	public XYChart.Series getCuisineChart() {
		return CuisineChart;
	}


	@SuppressWarnings("unchecked")
	public void setCuisineChart(@SuppressWarnings("rawtypes") XYChart.Series cuisineChart) {
		CuisineChart = cuisineChart;
	}
	
}