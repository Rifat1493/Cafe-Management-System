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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Rifat
 */
public class MainController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    
    private TextField txuser;
     
    @FXML
     
    private TextField txpass;
    @FXML
    private void login(ActionEvent event) throws Exception {
        if((txuser.getText().equals("ERROR404"))&& txpass.getText().equals("pitar"))
        {
            label.setText("Successfully logged in");
            ((Node)event.getSource()).getScene().getWindow().hide();
            Stage stage =new Stage();
              Parent root = FXMLLoader.load(getClass().getResource("Main2.fxml"));
        
        Scene scene = new Scene(root);
      
        scene.getStylesheets().add(getClass().getResource("Style2.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
        }
        else
        {
            label.setText("Login failed");
        }
    }
      @FXML
    
    private void back(ActionEvent event)throws Exception
    {
         ((Node)event.getSource()).getScene().getWindow().hide();
            Stage stage =new Stage();
              Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
        
        Scene scene = new Scene(root);
      
        scene.getStylesheets().add(getClass().getResource("admin.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
