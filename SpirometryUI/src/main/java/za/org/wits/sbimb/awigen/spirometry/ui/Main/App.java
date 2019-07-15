package za.org.wits.sbimb.awigen.spirometry.ui.Main;

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
import javafx.scene.control.PasswordField;
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

    private static final String FontWeight = null;
    private Desktop desktop = Desktop.getDesktop();

	@Override
    public void start(final Stage stage) {
        String javaVersion = SystemInfo.javaVersion();
        String javafxVersion = SystemInfo.javafxVersion();
        final FileChooser fileChooser = new FileChooser();

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("Load XML file");
        grid.add(userName, 0, 1);
                		
        final TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);
        
        final Button xmlBrowseBtn = new Button("Browse...");
	        xmlBrowseBtn.setOnAction(
	        		new EventHandler<ActionEvent>() {
	            
	        			public void handle(final ActionEvent e) {
	        				File file = fileChooser.showOpenDialog(stage);
	        				if (file != null) {
	        					//openFile(file);
	        					userTextField.setText(file.getAbsolutePath());
	        				}
	        			}
	        		});
        grid.add(xmlBrowseBtn, 2, 1);
        
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
        grid.add(xslBrowseBtn, 2, 2);
        
        PasswordField pwBox = new PasswordField();
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
        
        Label label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
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