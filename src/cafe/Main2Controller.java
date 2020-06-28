/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cafe;


import java.awt.Color;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

 
 
public class Main2Controller implements Initializable {
     double [] drink = new double[5];
       double [] cake= new double[5];
       double [] cost= new double[3]; 
       int arr[]={10,10,10,10,10,10,10,10};
       int book;
       int remain;
     @FXML
     private Button tb1,tb2,tb3,tb4,tb5,tb6,tb7,tb8;
    @FXML
    private CheckBox ck1;
    
    @FXML
    private CheckBox ck2;
    @FXML
    private CheckBox ck3;
    @FXML
    private CheckBox ck4;
    @FXML
    private CheckBox ck5;
    @FXML
    private CheckBox ck6;
    @FXML
    private CheckBox ck7;
    @FXML
    private CheckBox ck8;
    @FXML
    private CheckBox ck9;
    @FXML
    private CheckBox ck10;
    @FXML
    private TextField tx1,tx2,tx3,tx4,tx5,tx6,tx7,tx8,tx9,tx10,txweight,txage,txcalorie,txbk,txrem;
     @FXML
   private RadioButton rbtn1,rbtn2;
             
    @FXML
     private Label lb1,lb2,lb4,lb5,lb6;
    
     @FXML
     private TextField lb3;
    
     
    @FXML
    private TextArea txarea;
    @FXML
    private ComboBox <String> cmbox1,cmbox2,cmbox3;
    
     ObservableList <String> list = FXCollections.observableArrayList("1","2","3","4","5","6","7","8"); 
      ObservableList <String> list1 = FXCollections.observableArrayList("1","2","3","4","5","6","7","8","9","10","11","12");
       ObservableList <String> list2 = FXCollections.observableArrayList("Sedentary","Lightly Active","Moderately Active","Very Active","Extremely Active"); 
  @FXML private void calculate(ActionEvent e)throws Exception
  {  double bmr=0;
     int calorie = 0;
      if(rbtn1.isSelected())
      {
          int weight=Integer.parseInt(txweight.getText());
          int fheight=Integer.parseInt(cmbox1.getValue());
          int Iheight=Integer.parseInt(cmbox2.getValue());
          int height=(fheight*12)+Iheight;
          int age=Integer.parseInt(txage.getText());
           bmr= (447.6 + (9.2*(weight/2.2)) + (3.1 * (height/0.39)) - (4.3 *age));
          
      }
      else if(rbtn2.isSelected()){
          int weight=Integer.parseInt(txweight.getText());
          int fheight=Integer.parseInt(cmbox1.getValue());
          int Iheight=Integer.parseInt(cmbox2.getValue());
          int height=(fheight*12)+Iheight;
          int age=Integer.parseInt(txage.getText());
          bmr=(88.3 + (13.4 * (weight/2.2)) + (4.8 * (height/0.39)) - (5.7*age));


      }
       if("Sedentary".equals(cmbox3.getValue()))
      {
          calorie=(int)(1.2*bmr);
      }
      else if("Lightly Active".equals(cmbox3.getValue()))
      {
          calorie=(int)(bmr*1.375);
      }
      else if("Moderately Active".equals(cmbox3.getValue()))
      {
          calorie=(int)(bmr*1.55);
      }
       else if("Very Active".equals(cmbox3.getValue()))
      {
          calorie=(int)(bmr*1.725);
      }
       else if("Extremely Active".equals(cmbox3.getValue()))
      {
          calorie=(int)(bmr*1.9);
      }
           String clre =String.format("%d",calorie);
           txcalorie.setText(clre);
      
  }
       @FXML 
  private void help(ActionEvent e)throws Exception{
      Alert alert = new Alert(AlertType.INFORMATION);
      
alert.setTitle("Information");

alert.setContentText("Sedentary = (little or no exercise, desk job)\n" +
"Lightly Active = (light exercise or sports 1-3 days/wk)\n" +
"Moderately Active = (moderate exercise or sports 3-5 days/wk)\n" +
"Very Active = (hard exercise or sports 6-7 days/wk)\n" +
"Extremely Active = (hard daily exercise or sports & physical labor job or 2 X day training, football camp, etc.)");

alert.showAndWait();
  }
  @FXML
  private void ourproduct(ActionEvent e)throws Exception{
      Alert alert = new Alert(AlertType.INFORMATION);
      
alert.setTitle("Information");
alert.setHeaderText("Our Food Contains");
alert.setContentText("Tea :\t\t\t 1 calorie\n" +
"Coffee:\t\t 0 calorie\nCold Coffee:\t\t59 calorie\n"+
"330ml can cocacola : 139 calorie\n369ml can sprite : 146 calori\n\n" +
"Samosa :\t\t\t308 calorie\n" +
"Burger :\t\t\t295 calori\n" +
"Khichuri :\t\t\t 177 calori\n" +
"Chicken biriyani : \t338 calori\n" +
"Chicken fry :\t\t 246 calori\n");

alert.showAndWait();
  }
  
  @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     
     cmbox1.setItems(list);
     cmbox2.setItems(list1);
     cmbox3.setItems(list2);
    
     
    } 
    
    @FXML
    private void receipt(ActionEvent event)throws Exception {
    int refs= 1325+(int)(Math.random()*4000);
     Calendar timer=Calendar.getInstance();
     
      SimpleDateFormat tTime= new SimpleDateFormat("HH:mm:ss");
     // tTime.format(timer.getTime());
      
        SimpleDateFormat Tdate= new SimpleDateFormat("dd-MMM-yyyy");
     // Tdate.format(timer.getTime());
     drink[0]=Double.parseDouble(tx1.getText());
     drink[1]=Double.parseDouble(tx2.getText());
     drink[2]=Double.parseDouble(tx3.getText());
     drink[3]=Double.parseDouble(tx4.getText());
     drink[4]=Double.parseDouble(tx5.getText());
     cake[0]=Double.parseDouble(tx6.getText());
     cake[1]=Double.parseDouble(tx7.getText());
     cake[2]=Double.parseDouble(tx8.getText());
     cake[3]=Double.parseDouble(tx9.getText());
     cake[4]=Double.parseDouble(tx10.getText());
     cost[0]=Double.parseDouble(lb4.getText());
   cost[1]=Double.parseDouble(lb5.getText());
 cost[2]=Double.parseDouble(lb6.getText());  
       
  
  txarea.appendText("\t\t\t\t\tMAGPIE CAFE CORNER\n\n"+
          "Reference:\t\t\t\t\t\t\t\t\t\t\t\t"+refs+"\n================================================"+"\nProduct\t\t\t\t\t\t\tQty\t\t\tPrice(BDT)\n"+
        "________\t\t\t\t\t\t\t_____\t\t\t___________"+"\nCoffee:\t\t\t\t\t\t\t"+drink[0]+"\t\t\t\t"+drink[0]*20+
          "\nCold Coffee:\t\t\t\t\t\t"+drink[1]+"\t\t\t\t"+drink[1]*45+
          "\nTea:\t\t\t\t\t\t\t\t"+drink[2]+"\t\t\t\t"+drink[2]*12+
          "\nCocaCola:\t\t\t\t\t\t\t"+drink[3]+"\t\t\t\t"+drink[3]*25+
          "\nSprite:\t\t\t\t\t\t\t"+drink[4]+"\t\t\t\t"+drink[4]*25+
          "\nSamosa:\t\t\t\t\t\t\t"+cake[0]+"\t\t\t\t"+cake[0]*15+
          "\nBurger:\t\t\t\t\t\t\t"+cake[1]+"\t\t\t\t"+cake[1]*50+
          "\nKhichuri:\t\t\t\t\t\t\t"+cake[2]+"\t\t\t\t"+cake[2]*130+
          "\nBiryani:\t\t\t\t\t\t\t"+cake[3]+"\t\t\t\t"+cake[3]*160+
          "\nPizza:\t\t\t\t\t\t\t"+cake[4]+"\t\t\t\t"+cake[4]*210+
                                                    "\n================================================"+
          "\nVAT(15%):\t\t\t\t\t\t\t\t\t\t"+cost[0]+
          "\nSubtotal:\t\t\t\t\t\t\t\t\t\t\t"+cost[1]+
          "\nTotal:\t\t\t\t\t\t\t\t\t\t\t"+cost[2]+
                                                    "\n================================================"+
          "\nDate:"+Tdate.format(timer.getTime())+"\t\t\t\t\t\t\t\tTime:"+ tTime.format(timer.getTime())+
          "\n\n\t\t\t\t\t\tThank you"
          
  );
    }
    @FXML
    private void reset(ActionEvent event)throws Exception{
        tx1.setText("0");
        tx2.setText("0");
 tx3.setText("0");
 tx4.setText("0");
 tx5.setText("0");
 tx6.setText("0");
 tx7.setText("0");
 tx8.setText("0");
 tx9.setText("0");
 tx10.setText("0");
 lb1.setText("0");
 lb2.setText("0");
 lb3.setText("0");
 lb4.setText("0");
 lb5.setText("0");
 lb6.setText("0");
 txarea.setText(null);
 ck1.setSelected(false);
  ck2.setSelected(false);
 ck3.setSelected(false);
 ck4.setSelected(false);
 ck5.setSelected(false);
 ck6.setSelected(false);
 ck7.setSelected(false);
 ck8.setSelected(false);
 ck9.setSelected(false);
 ck10.setSelected(false);
    }
    @FXML
    public void signout (ActionEvent event)throws Exception{
     ((Node)event.getSource()).getScene().getWindow().hide();
            Stage stage =new Stage();
              Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        
        Scene scene = new Scene(root);
      
        scene.getStylesheets().add(getClass().getResource("Style.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

    }
      @FXML
    private void handlecoffee(ActionEvent event)throws Exception{
        double coffee=Double.parseDouble(lb1.getText());
        double ccoffee=Double.parseDouble(tx1.getText());
        
        double a;
        
          if(ck1.isSelected()) {
              a =(ccoffee*20)+coffee;
            String cdrink= String.format("%.2f",a);
            lb1.setText(cdrink);
            
            
          }
           
    }
    @FXML
    private void handlecold(ActionEvent event)throws Exception{
        double cold=Double.parseDouble(lb1.getText());
        double ccold=Double.parseDouble(tx2.getText());
        
        double b;
        
          if(ck2.isSelected()) {
              b =(ccold*45)+cold;
            String cdrink= String.format("%.2f",b);
            lb1.setText(cdrink);
            
            
          }
           
    }
    @FXML
    private void handletea(ActionEvent event)throws Exception{
        double tea=Double.parseDouble(lb1.getText());
        double ctea=Double.parseDouble(tx3.getText());
        
        double c;
        
          if(ck3.isSelected()) {
              c=(ctea*12)+tea;
            String cdrink= String.format("%.2f",c);
            lb1.setText(cdrink);
            
            
          }
           
    }
    @FXML
  private void handlecola(ActionEvent event)throws Exception{
        double cola=Double.parseDouble(lb1.getText());
        double ccola=Double.parseDouble(tx4.getText());
        
        double d;
        
          if(ck4.isSelected()) {
              d=(ccola*25)+cola;
            String cdrink= String.format("%.2f",d);
            lb1.setText(cdrink);
            
            
          }
           
    }@FXML
  private void handlesprite(ActionEvent event)throws Exception{
        double sprite=Double.parseDouble(lb1.getText());
        double csprite=Double.parseDouble(tx5.getText());
        
        double e;
        
          if(ck5.isSelected()) {
              e=(csprite*25)+sprite;
            String cdrink= String.format("%.2f",e);
            lb1.setText(cdrink);
            
            
          }
           
    }@FXML
     private void handlesamosa(ActionEvent event)throws Exception{
        double samosa=Double.parseDouble(lb2.getText());
        double csamosa=Double.parseDouble(tx6.getText());
        
        double f;
        
          if(ck6.isSelected()) {
              f=(csamosa*15)+samosa;
            String cdrink= String.format("%.2f",f);
            lb2.setText(cdrink);
            
            
          }
           
    }
     @FXML
     private void handleburger(ActionEvent event)throws Exception{
        double burger=Double.parseDouble(lb2.getText());
        double cburger=Double.parseDouble(tx7.getText());
        
        double g;
        
          if(ck7.isSelected()) {
              g =(cburger*50)+burger;
            String cdrink= String.format("%.2f",g);
            lb2.setText(cdrink);
            
            
          }
           
    }
     @FXML
     private void handlekhichuri(ActionEvent event){
        double khichuri=Double.parseDouble(lb2.getText());
        double ckhichuri=Double.parseDouble(tx8.getText());
        
        double h;
        
          if(ck8.isSelected()) {
              h=(ckhichuri*130)+khichuri;
            String cdrink= String.format("%.2f",h);
            lb2.setText(cdrink);
            
            
          }
           
    }@FXML
     private void handlebiryani(ActionEvent event){
        double biryani=Double.parseDouble(lb2.getText());
        double cbiryani=Double.parseDouble(tx9.getText());
        
        double j;
        
          if(ck9.isSelected()) {
              j =(cbiryani*160)+biryani;
            String cdrink= String.format("%.2f",j);
            lb2.setText(cdrink);
            
            
          }
           
    }@FXML
     private void handlepizza(ActionEvent event){
        double pizza=Double.parseDouble(lb2.getText());
        double cpizza=Double.parseDouble(tx10.getText());
        
        double k;
        
          if(ck10.isSelected()) {
              k =(cpizza*210)+pizza;
            String cdrink= String.format("%.2f",k);
            lb2.setText(cdrink);
            
            
          }
           
    }
     @FXML
     private void total(ActionEvent event)throws Exception
     {    double serv=Double.parseDouble(lb3.getText());
         double a= Double.parseDouble(lb1.getText());
           double b= Double.parseDouble(lb2.getText());
           double c= a+b;
           double vat=(15*c)/100;
           double total=c+serv+vat;
           String sub=String.format("%.2f",c);
           lb5.setText(sub);
          String cvat=String.format("%.2f",vat);
           lb4.setText(cvat);
            String ctotal=String.format("%.2f",total);
           lb6.setText(ctotal);
     }
     @FXML
     private void tb1btn(ActionEvent event)
     {  
       if(arr[0]==10){
           tb1.setStyle("-fx-background-color:#ee0303");
           arr[0]=20;
           int bk=Integer.parseInt(txbk.getText());
           bk++;
           String cbk=String.format("%d",bk);
           txbk.setText(cbk);
           int rm=Integer.parseInt(txrem.getText());
           rm--;
           String crm=String.format("%d",rm);
           txrem.setText(crm);
       }
       else if(arr[0]==20)
       {
            tb1.setStyle("-fx-background-color:#0a5b04");
            arr[0]=10;
            int bk=Integer.parseInt(txbk.getText());
           bk--;
           String cbk=String.format("%d",bk);
           txbk.setText(cbk);
           int rm=Integer.parseInt(txrem.getText());
           rm++;
           String crm=String.format("%d",rm);
           txrem.setText(crm);
       }
       
     }
     @FXML
     private void save(ActionEvent event){
          Stage primarystage=new Stage(); 
       FileChooser fileChooser = new FileChooser();
  
              //Set extension filter
              FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("All Files", "*.doc");
              fileChooser.getExtensionFilters().add(extFilter);
              
              //Show save file dialog
              File file = fileChooser.showSaveDialog(primarystage);
              
              if(file != null){
                  SaveFile(txarea.getText(), file);
              }
     }
    
    
 private void SaveFile(String content, File file){
        try {
            FileWriter fileWriter = null;
             
            fileWriter = new FileWriter(file);
            fileWriter.write(content);
            fileWriter.close();
        } catch (IOException ex) {
            
        }
         
    }
 @FXML
     private void tb2btn(ActionEvent event)
     {  
       if(arr[1]==10){
           tb2.setStyle("-fx-background-color:#ee0303");
           arr[1]=20;
           int bk=Integer.parseInt(txbk.getText());
           bk++;
           String cbk=String.format("%d",bk);
           txbk.setText(cbk);
           int rm=Integer.parseInt(txrem.getText());
           rm--;
           String crm=String.format("%d",rm);
           txrem.setText(crm);
       }
       else if(arr[1]==20)
       {
            tb2.setStyle("-fx-background-color:#0a5b04");
            arr[1]=10;
            int bk=Integer.parseInt(txbk.getText());
           bk--;
           String cbk=String.format("%d",bk);
           txbk.setText(cbk);
           int rm=Integer.parseInt(txrem.getText());
           rm++;
           String crm=String.format("%d",rm);
           txrem.setText(crm);
       }
       
     }
     @FXML
     private void tb3btn(ActionEvent event)
     {  
       if(arr[2]==10){
           tb3.setStyle("-fx-background-color:#ee0303");
           arr[2]=20;
           int bk=Integer.parseInt(txbk.getText());
           bk++;
           String cbk=String.format("%d",bk);
           txbk.setText(cbk);
           int rm=Integer.parseInt(txrem.getText());
           rm--;
           String crm=String.format("%d",rm);
           txrem.setText(crm);
       }
       else if(arr[2]==20)
       {
            tb3.setStyle("-fx-background-color:#0a5b04");
            arr[2]=10;
            int bk=Integer.parseInt(txbk.getText());
           bk--;
           String cbk=String.format("%d",bk);
           txbk.setText(cbk);
           int rm=Integer.parseInt(txrem.getText());
           rm++;
           String crm=String.format("%d",rm);
           txrem.setText(crm);
       }
       
     }
     @FXML
     private void tb4btn(ActionEvent event)
     {  
       if(arr[3]==10){
           tb4.setStyle("-fx-background-color:#ee0303");
           arr[3]=20;
           int bk=Integer.parseInt(txbk.getText());
           bk++;
           String cbk=String.format("%d",bk);
           txbk.setText(cbk);
           int rm=Integer.parseInt(txrem.getText());
           rm--;
           String crm=String.format("%d",rm);
           txrem.setText(crm);
       }
       else if(arr[3]==20)
       {
            tb4.setStyle("-fx-background-color:#0a5b04");
            arr[3]=10;
            int bk=Integer.parseInt(txbk.getText());
           bk--;
           String cbk=String.format("%d",bk);
           txbk.setText(cbk);
           int rm=Integer.parseInt(txrem.getText());
           rm++;
           String crm=String.format("%d",rm);
           txrem.setText(crm);
       }
       
     }
     @FXML
     private void tb5btn(ActionEvent event)
     {  
       if(arr[4]==10){
           tb5.setStyle("-fx-background-color:#ee0303");
           arr[4]=20;
           int bk=Integer.parseInt(txbk.getText());
           bk++;
           String cbk=String.format("%d",bk);
           txbk.setText(cbk);
           int rm=Integer.parseInt(txrem.getText());
           rm--;
           String crm=String.format("%d",rm);
           txrem.setText(crm);
       }
       else if(arr[4]==20)
       {
            tb5.setStyle("-fx-background-color:#0a5b04");
            arr[4]=10;
            int bk=Integer.parseInt(txbk.getText());
           bk--;
           String cbk=String.format("%d",bk);
           txbk.setText(cbk);
           int rm=Integer.parseInt(txrem.getText());
           rm++;
           String crm=String.format("%d",rm);
           txrem.setText(crm);
       }
       
     }
     @FXML
     private void tb6btn(ActionEvent event)
     {  
       if(arr[5]==10){
           tb6.setStyle("-fx-background-color:#ee0303");
           arr[5]=20;
           int bk=Integer.parseInt(txbk.getText());
           bk++;
           String cbk=String.format("%d",bk);
           txbk.setText(cbk);
           int rm=Integer.parseInt(txrem.getText());
           rm--;
           String crm=String.format("%d",rm);
           txrem.setText(crm);
       }
       else if(arr[5]==20)
       {
            tb6.setStyle("-fx-background-color:#0a5b04");
            arr[5]=10;
            int bk=Integer.parseInt(txbk.getText());
           bk--;
           String cbk=String.format("%d",bk);
           txbk.setText(cbk);
           int rm=Integer.parseInt(txrem.getText());
           rm++;
           String crm=String.format("%d",rm);
           txrem.setText(crm);
       }
       
     }
    @FXML
     private void tb7btn(ActionEvent event)
     {  
       if(arr[6]==10){
           tb7.setStyle("-fx-background-color:#ee0303");
           arr[6]=20;
           int bk=Integer.parseInt(txbk.getText());
           bk++;
           String cbk=String.format("%d",bk);
           txbk.setText(cbk);
           int rm=Integer.parseInt(txrem.getText());
           rm--;
           String crm=String.format("%d",rm);
           txrem.setText(crm);
       }
       else if(arr[6]==20)
       {
            tb7.setStyle("-fx-background-color:#0a5b04");
            arr[6]=10;
            int bk=Integer.parseInt(txbk.getText());
           bk--;
           String cbk=String.format("%d",bk);
           txbk.setText(cbk);
           int rm=Integer.parseInt(txrem.getText());
           rm++;
           String crm=String.format("%d",rm);
           txrem.setText(crm);
       }
       
     }
     @FXML
     private void tb8btn(ActionEvent event)
     {  
       if(arr[7]==10){
           tb8.setStyle("-fx-background-color:#ee0303");
           arr[7]=20;
           int bk=Integer.parseInt(txbk.getText());
           bk++;
           String cbk=String.format("%d",bk);
           txbk.setText(cbk);
           int rm=Integer.parseInt(txrem.getText());
           rm--;
           String crm=String.format("%d",rm);
           txrem.setText(crm);
       }
       else if(arr[7]==20)
       {
            tb8.setStyle("-fx-background-color:#0a5b04");
            arr[7]=10;
            int bk=Integer.parseInt(txbk.getText());
           bk--;
           String cbk=String.format("%d",bk);
           txbk.setText(cbk);
           int rm=Integer.parseInt(txrem.getText());
           rm++;
           String crm=String.format("%d",rm);
           txrem.setText(crm);
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
}
    
    

