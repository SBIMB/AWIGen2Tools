package za.org.wits.sbimb.shipment.shipment_ui;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

	 private Desktop desktop = Desktop.getDesktop();

		@Override
	    public void start(final Stage stage) {
			GridPane gridPane = null;
			BorderPane borderPane = null;
			TabPane tabPane = null;
	        
	        stage.setTitle("Shipment Handler");
	        stage.getIcons().add(new Image(App.class.getResourceAsStream("/SBIMB Logo 2015.png")));

	        //gridPane = getGridPane();
	        borderPane = getBorderPane();
	        tabPane = getTabPane(stage);
	        
	        borderPane.setCenter(tabPane);
	        //gridPane.add(tabPane, 0, 8);
	        Scene scene = new Scene(borderPane, 640, 480);
	        stage.setScene(scene);
	        stage.show();
	    }
		
		private void openFile(File file) {
			try {
				desktop.open(file);
			} catch (IOException ex) {
				Logger.getLogger(
					App.class.getName()).log(
		                    Level.SEVERE, null, ex
		                );
		        }
		   }
		
		private TabPane getTabPane(Stage stage){
			 //
	        TabPane tabPane = new TabPane();
	        final Stage localStage = stage;
	        
	        tabPane.setStyle("-fx-border-color: blue;");
	        	           
	        Tab uploadFileTab = new Tab();
	        uploadFileTab.setText("Step 1/5: Upload File");
	        uploadFileTab.setContent(getUploadFileGridPane(localStage));
	        	        
	        Tab fileValidationTab = new Tab();
	        fileValidationTab.setText("Step 2: File Validation");
	        fileValidationTab.setContent(getFileValidationGridPane());
	        
	        Tab dataValidationTab = new Tab();
	        dataValidationTab.setText("Step 3: Data Validation");
	        dataValidationTab.setContent(getDataValidationGridPane());
	        
	        Tab confirmUploadTab = new Tab();
	        confirmUploadTab.setText("Step 4: Confirm Upload");
	        confirmUploadTab.setContent(getConfirmUploadGridPane());
	        
	        Tab finishUplaodTab = new Tab();
	        finishUplaodTab.setText("Step 5: Finish Upload");
	        finishUplaodTab.setContent(getFinishUploadGridPane());
	        
	        tabPane.getTabs().add(uploadFileTab);
	        tabPane.getTabs().add(fileValidationTab);
	        tabPane.getTabs().add(dataValidationTab);
	        tabPane.getTabs().add(confirmUploadTab);
	        tabPane.getTabs().add(finishUplaodTab);
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
			 //Shipment Manifest controllers(Label, Textbox and Button)
	        //Label	
			gridPane.add(openingNote, 1, 0);
	        gridPane.add(shipmentManifestBrowseLbl, 1, 1);
	        	        
	        //Button	        
	        shipmentManifestBrowseBtn.setOnAction(
		        		new EventHandler<ActionEvent>() {
		            
		        			public void handle(final ActionEvent e) {
		        				File file = fileChooser.showOpenDialog(localStage);
		        				if (file != null) {
		        					//openFile(file);
		        					shipmentManifestFilePathBrowseLbl.setText(file.getAbsolutePath());
		        				}else{
		        					shipmentManifestFilePathBrowseLbl.setText("No File Choosen");
		        				}
		        			}
		        		});
	        gridPane.add(shipmentManifestBrowseBtn, 2, 1);
	        
	        //Textbox 	        
	        gridPane.add(shipmentManifestFilePathBrowseLbl, 2, 1);
	      
			return gridPane;
		}
		
		private GridPane getFileValidationGridPane(){
			GridPane gridPane = new GridPane();
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