/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafe;

import java.io.*;
import java.io.FileWriter;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rifat
 */
public class ClientController implements Initializable {
   @FXML
   private TextField signuser,txuser;
   @FXML
   private PasswordField signpass,txpass;
   @FXML
   private Label lb1;
    /**
     * Initializes the controller class.
     */
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
    
    @FXML
      private void login (ActionEvent event)throws Exception
      {   String s=txuser.getText();
              String s2=txpass.getText();
                      String d=String.format("%s\t%s",s,s2);
            FileReader fil=new FileReader("portal.txt");
       BufferedReader bf=new BufferedReader(fil);
       String str;
       int b=0;
       while(( str=bf.readLine())!=null)
       
       { 
           if(d.equals(str))
           {   b=1;
               lb1.setText("Successfully logged in");
               ((Node)event.getSource()).getScene().getWindow().hide();
            Stage stage =new Stage();
              Parent root = FXMLLoader.load(getClass().getResource("Main2.fxml"));
        
        Scene scene = new Scene(root);
      
        scene.getStylesheets().add(getClass().getResource("Style2.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
           }
       }
       if (b==0)
       {
           lb1.setText("login failed");
       }
       
      }
       
      
      
      @FXML
      private void signup (ActionEvent event)throws Exception
      {
          String s=signuser.getText();
          String s2=signpass.getText();
          FileWriter fr=new FileWriter("portal.txt",true);
        	fr.append(s+"\t"+s2+"\r\n");
        	fr.close(); 
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
