import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class newForfait extends Stage 
{
	
	public PlanAllumage MonPlanAllumage ;
	
	newForfait(Stage primaryStage){
	
		MonPlanAllumage = new PlanAllumage();
		final Stage stage = this;
		this.initModality(Modality.WINDOW_MODAL);
		this.initOwner(primaryStage);
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));
		
		Text scenetitle = new Text("Configurer forfait");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0, 2, 1);
		Label nomAppareilLabel = new Label("Nom du Forfait:  ");
		
		
		final TextField nomPlanTextField = new TextField();
	
		final TextField HeureDebut = new TextField();
		final TextField MinuteDebut = new TextField();
		final TextField HeureFin = new TextField();
		final TextField MinuteFin = new TextField();
		
		final TextField HeureDebutB = new TextField();
		final TextField MinuteDebutB = new TextField();
		final TextField HeureFinB = new TextField();
		final TextField MinuteFinB = new TextField();
		
		final TextField HeureCreuse = new TextField();
		final TextField HeurePlein = new TextField();
		final TextField PicDeConso = new TextField();
		if(AppCore.getTHEFORFAIT()!=null)
		{
			nomPlanTextField.setText(AppCore.getTHEFORFAIT().getName());
			
			HeureDebut.setText(Integer.toString(AppCore.getTHEFORFAIT().getPleineH().getDebut().getHeures()));
			MinuteDebut.setText(Integer.toString(AppCore.getTHEFORFAIT().getPleineH().getDebut().getMinutes()));
			HeureFin.setText(Integer.toString(AppCore.getTHEFORFAIT().getPleineH().getFin().getHeures()));
			MinuteFin.setText(Integer.toString(AppCore.getTHEFORFAIT().getPleineH().getFin().getMinutes()));
			
			HeureDebutB.setText(Integer.toString(AppCore.getTHEFORFAIT().getCreuseH().getDebut().getHeures()));
			MinuteDebutB.setText(Integer.toString(AppCore.getTHEFORFAIT().getCreuseH().getDebut().getMinutes()));
			HeureFinB.setText(Integer.toString(AppCore.getTHEFORFAIT().getCreuseH().getFin().getHeures()));
			MinuteFinB.setText(Integer.toString(AppCore.getTHEFORFAIT().getCreuseH().getFin().getMinutes()));
			
			HeureCreuse.setText(Double.toString(AppCore.getTHEFORFAIT().getCreuse()));
			HeurePlein.setText(Double.toString(AppCore.getTHEFORFAIT().getPleine()));
			
			PicDeConso.setText(Double.toString(AppCore.getTHEFORFAIT().getPic()));
		}
		Label LHeureCreuse = new Label("Prix Heure Creuse :");
		Label LHeurePleine= new Label("Prix Heure Pleine :");
		Label LPicDeConso = new Label("Pic de consommation :");
		Label Info = new Label("(en cts €)");
		
		HBox Prix = new HBox(10);
		HBox Pic = new HBox(10);
		 
		Pic.getChildren().add(LPicDeConso);
		Pic.getChildren().add(PicDeConso);
		
		Prix.getChildren().add(LHeurePleine);
		Prix.getChildren().add(HeurePlein);
		Prix.getChildren().add(LHeureCreuse);
		Prix.getChildren().add(HeureCreuse);
		Prix.getChildren().add(Info);
		
		
		HeureCreuse.setPrefSize(50, 15);

		HeurePlein.setPrefSize(50, 15);

		PicDeConso.setPrefSize(50, 15);
		nomPlanTextField.setPrefSize(200, 15);
		HeureDebut.setPrefSize(30, 15);
		MinuteDebut.setPrefSize(30, 15);
		HeureFin.setPrefSize(30, 15);
		MinuteFin.setPrefSize(30, 15);
	
		HeureDebutB.setPrefSize(30, 15);
		MinuteDebutB.setPrefSize(30, 15);
		HeureFinB.setPrefSize(30, 15);
		MinuteFinB.setPrefSize(30, 15);
		
		HBox hbHeure = new HBox(10);
		HBox hbHeureB = new HBox(10);
		
		Label DemandeDateDebut = new Label("Date de debut(Pleine) :");
		Label DemandeDateFin = new Label("Date de fin :");
		Label H1 = new Label("h");
		Label H2 = new Label("h");
		Label DemandeDateDebutB = new Label("Date de debut(Creuse) :");
		Label DemandeDateFinB = new Label("Date de fin :");
		Label H1B = new Label("h");
		Label H2B = new Label("h");
	
		hbHeure.getChildren().add(DemandeDateDebut);
		hbHeure.getChildren().add(HeureDebut);
		hbHeure.getChildren().add(H1);
		hbHeure.getChildren().add(MinuteDebut);
		hbHeure.getChildren().add(DemandeDateFin);
		hbHeure.getChildren().add(HeureFin);
		hbHeure.getChildren().add(H2);
		hbHeure.getChildren().add(MinuteFin);
		
		hbHeureB.getChildren().add(DemandeDateDebutB);
		hbHeureB.getChildren().add(HeureDebutB);
		hbHeureB.getChildren().add(H1B);
		hbHeureB.getChildren().add(MinuteDebutB);
		hbHeureB.getChildren().add(DemandeDateFinB);
		hbHeureB.getChildren().add(HeureFinB);
		hbHeureB.getChildren().add(H2B);
		hbHeureB.getChildren().add(MinuteFinB);


		Button boutonEnregistrer = new Button("Enregistrer");
		Button boutonAnnuler = new Button("Annuler");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(boutonAnnuler);
		hbBtn.getChildren().add(boutonEnregistrer);
		
	
		final Text actiontarget = new Text();
	

		
			
		boutonEnregistrer.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent e) 
			{
				try{
				AppCore.setTHEFORFAIT(new Forfait(nomPlanTextField.getText(),Double.parseDouble(HeurePlein.getText()),Double.parseDouble(HeureCreuse.getText()),new PlageHoraire(new Heure(Integer.parseInt(HeureDebut.getText()),Integer.parseInt(MinuteDebut.getText())), new Heure(Integer.parseInt(HeureFin.getText()),Integer.parseInt(MinuteFin.getText()))),new PlageHoraire(new Heure(Integer.parseInt(HeureDebutB.getText()),Integer.parseInt(MinuteDebutB.getText())), new Heure(Integer.parseInt(HeureFinB.getText()),Integer.parseInt(MinuteFinB.getText()))),Double.parseDouble(PicDeConso.getText())));
				close();
				}
				catch(Exception E)
				{
					@SuppressWarnings("unused")
					final DialogBox dialogBox = new DialogBox(
							stage,
							"Certains champs sont vides ou érronés !",
							1);
				}
			}
		});
		
		boutonAnnuler.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e)
			{
				System.out.println("coucou");
				close();
			}
		});
		
		
		HBox BoxName = new HBox();
		
		BoxName.getChildren().add(nomAppareilLabel);
		BoxName.getChildren().add(nomPlanTextField);
		grid.add(BoxName, 0, 1);

		grid.add(hbHeure, 0,2);
		grid.add(hbHeureB, 0, 3);
		grid.add(Prix, 0, 4);
		grid.add(Pic, 0, 5);
		grid.add(hbBtn, 0, 6);
		grid.add(actiontarget, 0, 7);
		this.setScene(new Scene(grid, 600, 400));
		this.show();
		nomPlanTextField.requestFocus();
}
}