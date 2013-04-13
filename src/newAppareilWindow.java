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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class newAppareilWindow extends Stage 
{
	
	public AppareilElectrique MonAppareilElectrique;
	public ArrayList<coupleint> Couples;
	
	newAppareilWindow(Stage primaryStage){
		Couples = new ArrayList<coupleint>();
		MonAppareilElectrique = new AppareilElectrique("");
		this.initModality(Modality.WINDOW_MODAL);
		this.initOwner(primaryStage);
		final Stage stage = this;
		GridPane grid = new GridPane();
		grid.setAlignment(Pos.CENTER);
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(25, 25, 25, 25));

		Text scenetitle = new Text("Ajouter un nouvel appareil");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		grid.add(scenetitle, 0, 0);
		HBox NameHbox = new HBox(30);
		Label nomAppareilLabel = new Label("Nom de l'appareil :");
		nomAppareilLabel.setAlignment(Pos.TOP_RIGHT);
		NameHbox.getChildren().add(nomAppareilLabel);
		HBox ListBox = new HBox(10);
		VBox ButtonBoxB = new VBox(10);
		final ListView<Mode> list = new ListView<Mode>();
		final ListView<PlanAllumage> listB = new ListView<PlanAllumage>();
		final ListView<coupleint> listC = new ListView<coupleint>();
		final TextField nomAppareilTextField = new TextField();
		final Button Combiner = new Button("->");
		final Button SupprimerBut = new Button("Sup mode");
		final Button SupprimerDuo = new Button("Sup duo");
		
	
		ListBox.getChildren().add(list);
		ListBox.getChildren().add(listB);
		ButtonBoxB.getChildren().add(Combiner);
		ButtonBoxB.getChildren().add(SupprimerBut);
		ButtonBoxB.getChildren().add(SupprimerDuo);
		ListBox.getChildren().add(ButtonBoxB);
		ListBox.getChildren().add(listC);
		NameHbox.getChildren().add(nomAppareilTextField);
		grid.add(NameHbox, 0, 1);
		ObservableList<PlanAllumage> itemsB = FXCollections.observableArrayList (AppCore.getListePlansAllumages());
		listB.setItems(itemsB);
		
		
		
		final Label consoModeLabel = new Label("Consommation mode : ");
		final Label nomModeLabel = new Label("Nom mode : ");
		final TextField consoModeTextField = new TextField();
		final Button AjouterMode = new Button("Ajouter Mode");
		final TextField nomModeTextField = new TextField();
		
		HBox ModeHbox = new HBox(5);
		
		consoModeLabel.setAlignment(Pos.TOP_RIGHT);
		ModeHbox.getChildren().add(nomModeLabel);
		ModeHbox.getChildren().add(nomModeTextField);
		ModeHbox.getChildren().add(consoModeLabel);
		ModeHbox.getChildren().add(consoModeTextField);
		ModeHbox.getChildren().add(AjouterMode);
		grid.add(ModeHbox,0, 2);
	
		
		consoModeTextField.lengthProperty().addListener(new ChangeListener<Number>(){
			 
			@Override
			public void changed(ObservableValue<? extends Number>observable,
					Number oldValue, Number newValue) {
				 if(newValue.intValue() > oldValue.intValue()){
						char ch = consoModeTextField.getText().charAt(oldValue.intValue());
						//System.out.println("Length:"+ oldValue+"  "+ newValue +" "+ch);                   
			 
						//Check if the new character is the number or other's
						if(!(ch >= '0' && ch <= '9' )&&(ch!=';')&&(ch!=':')&&(ch!=',')){       
							//if it's not number then just setText to previous one
							consoModeTextField.setText(consoModeTextField.getText().substring(0,consoModeTextField.getText().length()-1)); 
						}
					}
			}
			
		});
		/*final Button SupprimerBut = new Button("Sup mode");
		final Button SupprimerDuo = new Button("Sup duo");*/
		SupprimerBut.setOnAction(new EventHandler<ActionEvent>() 
				{
					@Override
					public void handle(ActionEvent e) 
					{
						if((list.getSelectionModel().getSelectedItem()!=null))
						{
							for(int k=0;k<MonAppareilElectrique.getModes().size();k++)
							{
								if(MonAppareilElectrique.getModes().get(k).getName() == list.getSelectionModel().getSelectedItem().getName())
								{
									MonAppareilElectrique.getModes().remove(k);
									break;
								}
							}
							ObservableList<Mode> items = FXCollections.observableArrayList (MonAppareilElectrique.getModes());
							list.setItems(items);
						
						}
					}
				});
		SupprimerDuo.setOnAction(new EventHandler<ActionEvent>() 
				{
					@Override
					public void handle(ActionEvent e) 
					{
						if((listC.getSelectionModel().getSelectedItem()!=null))
						{
							for(int k=0;k<MonAppareilElectrique.getCouples().size();k=k+2)
							{
								coupleint Temp = new coupleint(MonAppareilElectrique.getCouples().get(k),MonAppareilElectrique.getCouples().get(k+1));
								//System.out.println(listC.getSelectionModel().getSelectedItem().toString());
								//System.out.println(Temp.toString());
								if(Temp.getA().trim() == listC.getSelectionModel().getSelectedItem().getA().trim())
								{
									if(Temp.getB().trim() == listC.getSelectionModel().getSelectedItem().getB().trim())
									{
									//System.out.println("yeap");
									MonAppareilElectrique.getCouples().remove(k+1);
									MonAppareilElectrique.getCouples().remove(k);
								
									break;
									}
								}
							}
							Couples.clear();
							for(int k=0;k<MonAppareilElectrique.getCouples().size();k=k+2)
							{
								Couples.add(new coupleint(MonAppareilElectrique.getCouples().get(k),MonAppareilElectrique.getCouples().get(k+1)));
							}
							ObservableList<coupleint> itemsC = FXCollections.observableArrayList (Couples);
							listC.setItems(itemsC);
						
						}
					}
				});
		Combiner.setOnAction(new EventHandler<ActionEvent>() 
				{
					@Override
					public void handle(ActionEvent e) 
					{
						if((listB.getSelectionModel().getSelectedItem()!=null)&&(list.getSelectionModel().getSelectedItem()!=null))
						{
							
							
							
							
							
							
							MonAppareilElectrique.AddCouple(list.getSelectionModel().getSelectedItem().getName(), listB.getSelectionModel().getSelectedItem().getName());
							Couples.clear();
							for(int k=0;k<MonAppareilElectrique.getCouples().size();k=k+2)
							{
								Couples.add(new coupleint(MonAppareilElectrique.getCouples().get(k),MonAppareilElectrique.getCouples().get(k+1)));
							}
							ObservableList<coupleint> itemsC = FXCollections.observableArrayList (Couples);
							listC.setItems(itemsC);
						
						}
					}
				});
	
		Button boutonEnregistrer = new Button("Enregistrer");
		Button boutonAnnuler = new Button("Annuler");
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(boutonAnnuler);
		hbBtn.getChildren().add(boutonEnregistrer);
		grid.add(hbBtn, 0, 5);
		
	

		final Text actiontarget = new Text();
		grid.add(actiontarget, 0, 6);

	
		grid.add(ListBox,0 ,3);

		if(!AppCore.getListeAppareilsElectriques().isEmpty())
			//System.out.println(AppCore.getListeAppareilsElectriques().get(0));
		
		AjouterMode.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent e) 
			{
				if((nomModeTextField.getText()!="")&&(consoModeTextField.getText()!=""))
				{
					Mode MonNouveauMode = new Mode(nomModeTextField.getText());
					String ConsoChaine = consoModeTextField.getText();
					
					String[] UpAndDown = ConsoChaine.split(";");
					
					String[] Ups = UpAndDown[0].split(":");
					String[] Downs = UpAndDown[1].split(":");
			
					for(int i = 0 ; i<Ups.length;i++)
					{
						MonNouveauMode.AddUp(Double.parseDouble(Ups[i]));
					}
					for(int i = 0 ; i<Downs.length;i++)
					{
						MonNouveauMode.AddDown(Double.parseDouble(Downs[i]));
					}
					MonAppareilElectrique.AddModes(MonNouveauMode);
					
					ObservableList<Mode> items = FXCollections.observableArrayList (MonAppareilElectrique.getModes());
					list.setItems(items);
					nomModeTextField.setText("");
					consoModeTextField.setText("");
				}
				
			}
		});
		
		boutonEnregistrer.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent e) 
			{
				if(!nomAppareilTextField.getText().isEmpty())
				{
					
				if(AppCore.getAppareilFromName(nomAppareilTextField.getText())==null)
				{
					
					if(MonAppareilElectrique.getCouples().size()>0)
					{
						MonAppareilElectrique.setNom(nomAppareilTextField.getText());
						AppCore.AjouterAppareilToList(MonAppareilElectrique);
						close();
					}
					else
					{
						@SuppressWarnings("unused")
						final DialogBox dialogBox = new DialogBox(stage,"Vous devez configurer des couples",1);
					}
				}
				else
				{
					@SuppressWarnings("unused")
					final DialogBox dialogBox = new DialogBox(stage,"Vous devez specifier un nom qui n'est pas d�j� attribu�",1);
				}
				}
				else
				{
					@SuppressWarnings("unused")
					final DialogBox dialogBox = new DialogBox(stage,"Vous devez specifier un nom",1);
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

		this.setScene(new Scene(grid, 900, 400));
		this.show();
		nomAppareilTextField.requestFocus();
}
}
