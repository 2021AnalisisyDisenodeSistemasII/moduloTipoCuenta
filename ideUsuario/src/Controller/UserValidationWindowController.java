/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Controller.MenuWindowController;
import Modelo.CompanyDAO;
import Modelo.NaturalPersonDAO;
import com.mongodb.DB;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author user
 */
public class UserValidationWindowController implements Initializable {
    
    private ToggleGroup tipoIdToggleGroup;
    @FXML
    private TextField identificacionValidacionTF;
    @FXML
    private RadioButton empresaRB;
    @FXML
    private RadioButton personaNaturalRB;
    @FXML
    private Button validarBT;
    private boolean campolleno;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       formatTextNumber(identificacionValidacionTF);//formato numerico desde el inicio para evitar errores
       campolleno = true; //para saber cuando el campo no esta vacio 
       tipoIdToggleGroup = new ToggleGroup();
        this.personaNaturalRB.setToggleGroup(tipoIdToggleGroup);
        this.empresaRB.setToggleGroup(tipoIdToggleGroup);
        personaNaturalRB.setSelected(true);
        
    }    
    @FXML
    private void toggleCamposTexto(ActionEvent event) {//dependiendo del radio button presioando se activan los campos el formulario
        //saber a que textField debe ir la direccion   
            if (this.tipoIdToggleGroup.getSelectedToggle().equals(this.personaNaturalRB)&& campolleno == true) {
            validarExistenciaPersona(event);
        }
        if (this.tipoIdToggleGroup.getSelectedToggle().equals(this.empresaRB)&& campolleno == true) {
            validarExistenciaEmpresa(event);
        }
        
       
    }
    public void validarExistenciaEmpresa(ActionEvent event){
      
        emptyText(identificacionValidacionTF);
        CompanyDAO validaEmpresa = new CompanyDAO();//crear un objeto de CompanyDAO para hacer la consulta dentro de la base de datos
        if (validaEmpresa.consultar(identificacionValidacionTF.getText()) == false ) {
            mensaje("Alerta", "El cliente no esta registrado,\n desea hace un registro nuevo?").showAndWait().ifPresent(response -> {//siempre y cuando el boton del mensaje de registro exitoso sea presionado
                if (response == ButtonType.OK) {
                    abrirVentanaYCerrar(event, "VentanaRegistroUser");//cambiar de ventana
                }
            });
        }

        if (validaEmpresa.consultar(identificacionValidacionTF.getText()) == true ) {
            mensaje("Alerta", "El cliente ya se encuentra registrado").showAndWait().ifPresent(response -> {//siempre y cuando el boton del mensaje de registro exitoso sea presionado
                if (response == ButtonType.OK) {
                    abrirVentanaYCerrar(event, "VentanaMenuPrincipal");//cambiar de ventana
                }
            });
        }

    }
    
    public void validarExistenciaPersona(ActionEvent event){
      
        emptyText(identificacionValidacionTF);
        NaturalPersonDAO validaPersona = new NaturalPersonDAO();//crear un objeto de NaturalPersonDAO para hacer la consulta dentro de la base de datos
        if (validaPersona.consultar(identificacionValidacionTF.getText()) == false && campolleno == true) {
            mensaje("Alerta", "El cliente no esta registrado,\n desea hace un registro nuevo?").showAndWait().ifPresent(response -> {//siempre y cuando el boton del mensaje de registro exitoso sea presionado
                if (response == ButtonType.OK) {
                    abrirVentanaYCerrar(event, "VentanaRegistroUser");//cambiar de ventana
                }
            });
        }

        if (validaPersona.consultar(identificacionValidacionTF.getText()) == true && campolleno == true) {
            mensaje("Alerta", "El cliente ya se encuentra registrado").showAndWait().ifPresent(response -> {//siempre y cuando el boton del mensaje de registro exitoso sea presionado
                if (response == ButtonType.OK) {
                    abrirVentanaYCerrar(event, "VentanaMenuPrincipal");//cambiar de ventana
                }
            });
        }

    }

    public void abrirVentanaYCerrar(ActionEvent event, String fxmlDocument) {
        Stage stage = new Stage();
        Parent root = null;
        Button btn = (Button) event.getSource();//obteber el id del botton de registro para saber que escena es y asi cerrarla cuando el registro sea exitoso

        try {
            root = FXMLLoader.load(getClass().getResource(fxmlDocument + ".fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
            Stage primaryStage = (Stage) btn.getScene().getWindow();
            primaryStage.close();
        } catch (IOException ex) {
            Logger.getLogger(MenuWindowController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void formatTextNumber(TextField text) {//solo numeros en el campo
        text.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("\\d-*")) {
                text.setText(newValue.replaceAll("[^\\d-]", ""));
            }
        });

    }

    public void emptyText(TextField text) {//campo vacio y formulario false
        try {
            if (text == null || text.getText().isEmpty()) {
                throw new RuntimeException("Subclasses of Valueables cannot take in an empty String or null value for the \"name\" constructor");
            }
            campolleno = true;
        } catch (RuntimeException exc) {//controla que no este vacio el campo
            System.out.println("error");
           mensaje("error ", "error, el campo id/nit  esta vacio,\n diligencie el campo").show();
           campolleno = false;
        }

    }
   
    public Alert mensaje(String title,String mensa){
        Alert mensaje = new Alert(Alert.AlertType.ERROR);//crear ventana de mensaje para el resgistro exitoso
        mensaje.setTitle(title);
        mensaje.setHeaderText(mensa);
        return mensaje; 

   }
           
}
