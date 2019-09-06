package za.org.wits.sbimb.shipment.shipment_ui;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

import za.org.wits.sbimb.shipment.model.Feedback;
import za.org.wits.sbimb.shipment.model.ShipmentManifest;
import za.org.wits.sbimb.shipment.service.FileUploadService;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.converter.LocalDateStringConverter;

/**
 * JavaFX App
 */
public class Main extends Application {

	 private Desktop desktop = Desktop.getDesktop();
	 TabPane tabPane = null;
	 GridPane gridPane = null;
	 Scene scene = null;
	 BorderPane borderPane = null;
	 FlowPane flowPane = null;
	 FileUploadService fileUploadService = new FileUploadService();
	 String filePath = null;
	 Label feedbackLabel = new Label("test");
	 Button nextButton = null;
	 Button cancelButton = null;
	 Button finishButton = null;
	 ShipmentManifest shipmentManifest = null;
	 
	 final float width = 600;
	 
		@Override
	    public void start(final Stage stage) {
									
			flowPane = new FlowPane();
			flowPane.setAlignment(Pos.CENTER);
			flowPane.setVgap(10.00);
			nextButton = new Button("Next");
			cancelButton = new Button("Cancel");
			finishButton = new Button("Finish");
			
								
			feedbackLabel.setPrefSize(width, 50.00);
			nextButton.setPrefSize(100.00, 30.00);
			cancelButton.setPrefSize(100.00, 30.00);
			finishButton.setPrefSize(100.00, 30.00);
			
			nextButton.setDisable(true);
			cancelButton.setDisable(true);
			finishButton.setDisable(true);
			
			feedbackLabel.setStyle("-fx-border-color: blue;");
			feedbackLabel.setWrapText(true);
			
			flowPane.getChildren().add(feedbackLabel);
			flowPane.getChildren().add(nextButton);
			flowPane.getChildren().add(cancelButton);
			flowPane.getChildren().add(finishButton);
			
			flowPane.setHgap(10.00);
			flowPane.setPadding(new Insets(10.00, 10.00, 10.00, 10.00));
	        
	        stage.setTitle("Shipment Handler");
	        stage.getIcons().add(new Image(Main.class.getResourceAsStream("/SBIMB Logo 2015.png")));

	        //gridPane = getGridPane();
	        borderPane = getBorderPane();
	        getTabPane(stage, 0);
	        
	        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {

				@SuppressWarnings("null")
				public void handle(MouseEvent mouseEvent) {
					ObservableList<Tab> tabs = tabPane.getTabs();
					System.out.println("Next step");
					Tab tab = tabs.get(0);
					System.out.println("Current tab 1 : "+tab.getText());
					Feedback feedback = null;
					switch (tab.getText()){
						case "Step 1/5: Upload File" :
							feedback = fileUploadService.postStepOne(filePath);
							if(feedback.getIsError()==false){
								fileUploadService.preStepTwo();
								getTabPane(stage, 1);
								System.out.println("Getting Tab 2: ");
								feedbackLabel.setText(feedback.getNote());
							}else{
								//getTabPane(stage, 2);								
								feedbackLabel.setText(feedback.getNote());
							}							
							break;
						case "Step 2/5: File Validation" :
							getTabPane(stage, 2);
							break;
						case "Step 3/5: Data Validation" :
							getTabPane(stage, 3);
							break;
						case "Step 4/5: Confirm Upload" :
							getTabPane(stage, 4);
							break;
						case "Step 5/5: Finish Upload" :
							getTabPane(stage, 5);
							break;
							default:
								break;
					}
					borderPane.setCenter(tabPane);
				}
			};
			
			nextButton.addEventFilter(MouseEvent.MOUSE_CLICKED, eventHandler);
	        
	        borderPane.setCenter(tabPane);
	        borderPane.setBottom(flowPane);
	        
	        //gridPane.add(tabPane, 0, 8);
	        scene = new Scene(borderPane, 640, 480);
	     
	        stage.setScene(scene);
	        stage.setResizable(false);
	        stage.show();
	    }
		
		private void openFile(File file) {
			try {
				desktop.open(file);
			} catch (IOException ex) {
				Logger.getLogger(
					Main.class.getName()).log(
		                    Level.SEVERE, null, ex
		                );
		        }
		   }
		
		private TabPane getTabPane(Stage stage, int step){
			 //
			if(tabPane==null)
				tabPane = new TabPane();
	        final Stage localStage = stage;
	        
	        tabPane.setStyle("-fx-border-color: blue;");
	        	           
	       
	        Tab uploadFileTab = new Tab();	        
	        Tab fileValidationTab = new Tab();
	        Tab dataValidationTab = new Tab();
	        Tab confirmUploadTab = new Tab();
	        Tab finishUplaodTab = new Tab();
	        	        
	        if(tabPane.getTabs().size()>0)
	        	tabPane.getTabs().remove(0);
	        
	        switch (step){
	        	case 1 : 	        		
	        		fileValidationTab.setText("Step 2/5: File Validation");
	    	        fileValidationTab.setContent(getFileValidationGridPane());
	        		tabPane.getTabs().add(fileValidationTab);
	        		System.out.println("Current tab 2 : "+fileValidationTab.getText());	        		
	        		flowPane.getChildren().get(2).setVisible(false);
	        		flowPane.getChildren().get(0).setVisible(true);
	        		break;
	        	case 2 :	        		
	        		dataValidationTab.setText("Step 3/5: Data Validation");
	    	        dataValidationTab.setContent(getDataValidationGridPane());
	    	        System.out.println("Inserting Current tab : "+fileValidationTab.getText());
	        		tabPane.getTabs().add(dataValidationTab);
	        		break;
	        	case 3 :
	        		confirmUploadTab.setText("Step 4/5: Confirm Upload");
	        		confirmUploadTab.setContent(getConfirmUploadGridPane());
	        		tabPane.getTabs().add(confirmUploadTab);
	        		break;
	        	case 4 : 
	        		finishUplaodTab.setText("Step 5/5: Finish Upload");
	    	        finishUplaodTab.setContent(getFinishUploadGridPane());
	        		tabPane.getTabs().add(finishUplaodTab);
	        		flowPane.getChildren().get(0).setVisible(false);
	        		flowPane.getChildren().get(2).setVisible(true);
	        		break;
	        	default:
	        		uploadFileTab.setText("Step 1/5: Upload File");
	        		uploadFileTab.setContent(getUploadFileGridPane(localStage));
	        		tabPane.getTabs().add(uploadFileTab);
	        		break;
	        }
	        return tabPane;
		}		
		
		private GridPane getGridPane(){
			Text scenetitle = new Text("SBIMB Biobank Shipment Manifest Handling");
			GridPane gridPane = new GridPane();
			
			//Set font details
	        scenetitle.setFont(Font.font("Tahoma", 20));
	        
	        gridPane.add(scenetitle, 0, 0, 2, 1);
			
		    gridPane.setAlignment(Pos.CENTER);
		    gridPane.setHgap(10);
		    gridPane.setVgap(10);
		    gridPane.setPadding(new Insets(25, 25, 25, 25));
		    gridPane.setStyle("-fx-border-color: blue;");
		    return gridPane;
		}
		
		private BorderPane getBorderPane(){
			BorderPane borderPane = new BorderPane();
			
			return borderPane;
		}
		
		private GridPane getUploadFileGridPane(Stage stage){
			final FileChooser fileChooser = new FileChooser();
			GridPane gridPane = new GridPane();
			final Stage localStage = stage; 
			Label shipmentManifestBrowseLbl = new Label("Load Shipment Manifest");
			final Button shipmentManifestBrowseBtn = new Button("Choose File");
			final Label shipmentManifestFilePathBrowseLbl = new Label("No File Choosen");
			final Label openingNote = new Label("Select the file containing data and click Next to continue.");
			final Label closingNote = new Label("Note: Only Excel files are accepted. \n \nNote: Click 'Download Template' for an example file. Header columns are required");
			
			//gridPane.setPadding(new Insets(100, 100, 10, 10));
			 //Shipment Manifest controllers(Label, Textbox and Button)
	        //Label	
			gridPane.add(openingNote, 1, 0, 3, 3);
	        gridPane.add(shipmentManifestBrowseLbl, 1, 4);
	        	        
	        //Button	        
	        shipmentManifestBrowseBtn.setOnAction(
		        		new EventHandler<ActionEvent>() {
		            
		        			public void handle(final ActionEvent e) {
		        				File file = fileChooser.showOpenDialog(localStage);
		        				if (file != null) {
		        					//openFile(file);
		        					filePath = file.getAbsolutePath();
		        					shipmentManifestFilePathBrowseLbl.setText(filePath);
		        				}else{
		        					shipmentManifestFilePathBrowseLbl.setText("No File Choosen");
		        				}
		        			}
		        		});
	        shipmentManifestFilePathBrowseLbl.textProperty().addListener(new ChangeListener<String>() {

				@Override
				public void changed(ObservableValue<? extends String> arg0, String oldValue,
						String newValue) {
					if(newValue.isEmpty() || newValue.equalsIgnoreCase("No File Choosen")){
						nextButton.setDisable(true);
						cancelButton.setDisable(true);
						finishButton.setDisable(true);
					}else{
						nextButton.setDisable(false);
					}
					
				}
	        	
			});
	        gridPane.add(shipmentManifestBrowseBtn, 2, 4);
	        
	        //Textbox 	        
	        gridPane.add(shipmentManifestFilePathBrowseLbl, 3, 4);
	     
	        //cancelButton.setS
	        
	        gridPane.add(closingNote, 1, 5, 3, 3);
	        gridPane.setAlignment(Pos.CENTER);
	        gridPane.setPrefSize(960, 720);
	        
	        GridPane.setMargin(openingNote, new Insets(5, 5, 5, 5));
	        GridPane.setMargin(shipmentManifestBrowseLbl, new Insets(5, 5, 5, 5));
	        GridPane.setMargin(shipmentManifestBrowseBtn, new Insets(5, 5, 5, 5));
	        GridPane.setMargin(shipmentManifestFilePathBrowseLbl, new Insets(5, 5, 5, 5));
	        GridPane.setMargin(closingNote, new Insets(5, 5, 5, 5));

	        ColumnConstraints column1 = new ColumnConstraints();
	        column1.setPercentWidth(10);
	        ColumnConstraints column2 = new ColumnConstraints();
	        column2.setPercentWidth(30);
	        ColumnConstraints column3 = new ColumnConstraints();
	        column3.setPercentWidth(20);
	        ColumnConstraints column4 = new ColumnConstraints();
	        column4.setPercentWidth(30);
	        ColumnConstraints column5 = new ColumnConstraints();
	        column5.setPercentWidth(10);
	        gridPane.getColumnConstraints().addAll(column1, column2, column3, column4, column5);
	        
	        gridPane.setGridLinesVisible(true);
	        
			return gridPane;
		}
		
		private GridPane getFileValidationGridPane(){
			GridPane gridPane = new GridPane();
			FlowPane flowPane = new FlowPane();
			
			if(shipmentManifest!= null){
				//String manifestNumber;
				Label manifestNumberlbl = new Label("Manifest Number");
				Text manifestNumberTxt = new Text(shipmentManifest.getManifestNumber());
				
				gridPane.add(manifestNumberlbl,0,0);
				gridPane.add(manifestNumberTxt,1,0);
				
				//String collectionCentre;
				Label collectionCentrelbl = new Label("Collection Centre");
				Text collectionCentreTxt = new Text(shipmentManifest.getCollectionCentre());
				
				//String refNumber;
				Label refNumberlbl = new Label("Reference Number");
				Text refNumberTxt = new Text(shipmentManifest.getRefNumber());
				
				//Date dateSent;
				Label dateSentlbl = new Label("Date Sent");
				ZoneId defaultZoneId = ZoneId.systemDefault();
				Instant instant = shipmentManifest.getDateSent().toInstant();
				LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate();
				DatePicker dateSentDP = new DatePicker(localDate);
							
				//Integer numberOfBoxes;
				Label numberOfBoxeslbl = new Label("Number Of Boxes");
				Text numberOfBoxesTxt = new Text(shipmentManifest.getNumberOfBoxes().toString());
				
				//String responsiblePerson;
				Label responsiblePersonlbl = new Label("Responsible Person");
				Text responsiblePersonTxt = new Text(shipmentManifest.getResponsiblePerson());
				
				//String contactDetails;
				Label contactDetailslbl = new Label("Contact Details");
				Text contactDetailsTxt = new Text(shipmentManifest.getContactDetails());
				
				//String methodOfShipment;
				Label methodOfShipmentlbl = new Label("Method Of Shipment");
				Text methodOfShipmentTxt = new Text(shipmentManifest.getMethodOfShipment());
				
				gridPane.add(manifestNumberlbl,0,0);
			
			}
			return gridPane;
		}
		
		private GridPane getDataValidationGridPane(){
			GridPane gridPane = new GridPane();
			return gridPane;
		}
		
		private GridPane getConfirmUploadGridPane(){
			GridPane gridPane = new GridPane();
			final Button configREDCapBtn = new Button("Configure REDCap settings");
	        configREDCapBtn.setOnAction(
	        		new EventHandler<ActionEvent>() {
	        			
	        			public void handle(final ActionEvent e) {
	        				
	        			}
	        		});
	        gridPane.add(configREDCapBtn, 1, 7);
	        
	        final Button csvUploadBtn = new Button("Upload CSV to REDCap");
	        csvUploadBtn.setOnAction(
	        		new EventHandler<ActionEvent>() {
	        			
	        			public void handle(final ActionEvent e) {
	        				
	        			}
	        		});
	        gridPane.add(csvUploadBtn, 1, 5);
	        
			return gridPane;
		}
		
		private GridPane getFinishUploadGridPane(){
			GridPane gridPane = new GridPane();
			return gridPane;
		}
		
	    public static void main(String[] args) {
	        launch();
	    }
}