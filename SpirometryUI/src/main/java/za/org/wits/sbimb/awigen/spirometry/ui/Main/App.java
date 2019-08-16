package za.org.wits.sbimb.awigen.spirometry.ui.Main;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
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
        final FileChooser fileChooser = new FileChooser();

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
       //
        TabPane tabPane = new TabPane();
        
        Tab tab = new Tab();
        tab.setText("Convert file");
        tabPane.getTabs().add(tab);
        
        Text scenetitle = new Text("Welcome");
        
        //Set font details
        scenetitle.setFont(Font.font("Tahoma", 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        //XML controllers(Label, Textbox and Button)
        //Label
        Label xmlBrowseLbl = new Label("Load XML file");
        grid.add(xmlBrowseLbl, 0, 1);
        
        //Textbox 
        final TextField xmlBrowseTxt = new TextField();
        grid.add(xmlBrowseTxt, 1, 1);
        
        //Button
        final Button xmlBrowseBtn = new Button("Browse...");
	        xmlBrowseBtn.setOnAction(
	        		new EventHandler<ActionEvent>() {
	            
	        			public void handle(final ActionEvent e) {
	        				File file = fileChooser.showOpenDialog(stage);
	        				if (file != null) {
	        					//openFile(file);
	        					xmlBrowseTxt.setText(file.getAbsolutePath());
	        				}
	        			}
	        		});
        grid.add(xmlBrowseBtn, 2, 1);
                
        //XSL Controllers
        Label pw = new Label("Load XSL file");
        grid.add(pw, 0, 2);
        
        final Button xslBrowseBtn = new Button("Browse...");
        xslBrowseBtn.setOnAction(
        		new EventHandler<ActionEvent>() {
            
        			public void handle(final ActionEvent e) {
        				File file = fileChooser.showOpenDialog(stage);
        				if (file != null) {
        					openFile(file);
        				}
        			}
        		});
        xslBrowseBtn.setDisable(Boolean.TRUE);
        grid.add(xslBrowseBtn, 2, 2);
        
        final PasswordField pwBox = new PasswordField();
        pwBox.setDisable(Boolean.TRUE);
        grid.add(pwBox, 1, 2);
        
        final Button xmlConvertBtn = new Button("Convert XML to CSV");
        xmlConvertBtn.setOnAction(
        		new EventHandler<ActionEvent>() {
        			
        			public void handle(final ActionEvent e) {
        				
        			}
        		});
        grid.add(xmlConvertBtn, 1, 3);

        final Button csvDownloadBtn = new Button("Convert XML to CSV");
        csvDownloadBtn.setOnAction(
        		new EventHandler<ActionEvent>() {
        			
        			public void handle(final ActionEvent e) {
        				
        			}
        		});
        grid.add(csvDownloadBtn, 1, 4);
        
        final Button csvUploadBtn = new Button("Upload CSV to REDCap");
        csvUploadBtn.setOnAction(
        		new EventHandler<ActionEvent>() {
        			
        			public void handle(final ActionEvent e) {
        				
        			}
        		});
        grid.add(csvUploadBtn, 1, 5);
        
        ObservableList<String> xmlTemplates = FXCollections.observableArrayList("Export All Test Parameter", "Example EN", 
        		"Example", "8 Forced Trials", "Example Convert Graph", "Export All Dlco Trials", 
        		"Export All Forced Trials", "Export All FRC Trials", "Export All Trial Parameter",
        		"Export Best Values Of Forced Tests", "Load customised template");
        
        final ComboBox<String> xmlTemplatesCBO = new ComboBox<String>(xmlTemplates);
        xmlTemplatesCBO.getSelectionModel().selectFirst();
        xmlTemplatesCBO.setOnAction(new EventHandler<ActionEvent>() {
        	public void handle(ActionEvent event){
        		String selection = xmlTemplatesCBO.getSelectionModel().getSelectedItem();
        		if(selection=="Load customised template"){
					pwBox.setDisable(Boolean.FALSE);
					xslBrowseBtn.setDisable(Boolean.FALSE);
        		}else{
        			pwBox.setDisable(Boolean.TRUE);
					xslBrowseBtn.setDisable(Boolean.TRUE);
        		}
			}
		});
        
        grid.add(xmlTemplatesCBO, 1, 6);
        
        final Button configREDCapBtn = new Button("Configure REDCap settings");
        configREDCapBtn.setOnAction(
        		new EventHandler<ActionEvent>() {
        			
        			public void handle(final ActionEvent e) {
        				
        			}
        		});
        grid.add(configREDCapBtn, 1, 7);
        
        grid.add(tabPane, 0, 8);
        
        Scene scene = new Scene(grid, 640, 480);
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
	
    public static void main(String[] args) {
        launch();
    }
}