package finalproject;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
    
//Author     : Christos

public class Interface extends Application {
	//Create text area
	private final TextArea textArea = new TextArea();
	
	//Create buttons
	private final Button readButton = new Button("Read list");
	private final Button sortButton = new Button("Sort list");
	private final Button removeButton = new Button("Remove Birds");
	
	
	   birds b1 = new birds();
        

           
	public static void main(String[] args) {
		//Launches the interface
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
            
		//Setup dimensions for the text area
		textArea.setPrefColumnCount(20);
		textArea.setPrefRowCount(30);
                		
		
		//Put textArea in HBox
		HBox hbox = new HBox(textArea);
		//align HBox
                
                hbox.setAlignment(Pos.CENTER);
                
                //Insert Buttons into second hbox
                HBox hboxtwo = new HBox(10, readButton, sortButton, removeButton);
                
                //Allign the second hbox
                hboxtwo.setAlignment(Pos.CENTER);
                hboxtwo.setPadding(new Insets(10));
                
                //insert the two hbox's into a vbox
		 VBox finalVBox = new VBox(10, hbox, hboxtwo); 

		//Create scene and display it.
		Scene scene = new Scene(finalVBox);
                
                //Gets the style sheet.
                scene.getStylesheets().add(getClass().getResource("Stylesheet.css").toExternalForm());
                
		primaryStage.setScene(scene);
                
                primaryStage.setTitle("Linked List test!");

		primaryStage.show();
                
                
                //Styling for JavaFX
                finalVBox.setStyle("-fx-background:#6a8491");
                
               
          readButton.setOnAction(e ->
                {
                try{    
                File adds = new File("birds1.txt");

                 //remove all is used to clear the linked list. 
                   b1.removeall();
                   Scanner Add = new Scanner(adds);
                       while(Add.hasNext()){
                        String BdName=Add.nextLine();
                               
                           b1.search(BdName);
                                
                            }
                        
                        
                        textArea.setText("total Birds Unsorted : "+"\n"+b1.toString());
                }
                catch(IOException ex){
                          System.err.println(ex.getMessage());
                      }
                    
			
                      });
                
                sortButton.setOnAction(e ->
                      {
			b1.sort();
			
			textArea.setText("total Birds Sorted : "+"\n"+b1.toString());
		});
                
                removeButton.setOnAction(e ->{
                    try{
                	   File remove = new File ("birds_2.txt");

                        Scanner Rm = new Scanner(remove) ;
                            while(Rm.hasNext()){
                                String rdName=Rm.nextLine();
                                b1.removeBird(rdName);
                                
                                
                            }
                        
                        textArea.setText("Specified Sorted List : "+"\n"+b1.toString());
                    }
                    catch(IOException ex){
                          System.err.println(ex.getMessage());
                      }
                        
                   
                    
                });
                
                
	}
        
              
}

	
	
