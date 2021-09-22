/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Vista.Main;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.Window;



public class MenuWindowController implements Initializable {

   @FXML
   private Button registroBT;
   @FXML
   private Button suscripcionBT;
   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
    @FXML
    public void abrirVentanaRegistro(ActionEvent event) {
        Stage stage = new Stage();
        Parent root = null;
        try {
            
            root = FXMLLoader.load(Main.class.getResource("/Vista/UserValidationWindow.fxml"));//por ahora a esta pero deberia ir a la de validacion de documento antes que al registro
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
            Stage primaryStage = (Stage) registroBT.getScene().getWindow();
            primaryStage.close();
        } catch (IOException ex) {
            Logger.getLogger(MenuWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    public void abrirVentanaConsultaSuscripcion(ActionEvent event) {
        Stage stage = new Stage();
        Parent root = null;
        try {

            root = FXMLLoader.load(Main.class.getResource("/Vista/QuerySubscription.fxml"));//por ahora a esta pero deberia ir a la de validacion de documento antes que al registro
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
            Stage primaryStage = (Stage) registroBT.getScene().getWindow();
            primaryStage.close();
        } catch (IOException ex) {
            Logger.getLogger(MenuWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
