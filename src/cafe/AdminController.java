/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafe;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rifat
 */
public class AdminController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    
    
    
    @FXML
    
    private void admin(ActionEvent event)throws Exception
    {
         ((Node)event.getSource()).getScene().getWindow().hide();
            Stage stage =new Stage();
              Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        
        Scene scene = new Scene(root);
      
        scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    @FXML
        private void client(ActionEvent event)throws Exception
    {
         ((Node)event.getSource()).getScene().getWindow().hide();
            Stage stage =new Stage();
              Parent root = FXMLLoader.load(getClass().getResource("Client.fxml"));
        
        Scene scene = new Scene(root);
      
        scene.getStylesheets().add(getClass().getResource("client.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
