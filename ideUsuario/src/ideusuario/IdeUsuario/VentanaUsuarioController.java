/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideusuario.IdeUsuario;

import Clases.Cliente;
import Clases.Empresa;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

/**
 *
 * @author Usuario
 */
public class VentanaUsuarioController implements Initializable {
    
    // Selección inicial en la interfaz gráfica, tipo de usuario
    @FXML private Label tipoUsuarioLB;
    @FXML private RadioButton personaNaturalRB;
    @FXML private RadioButton empresaRB;
    @FXML private ToggleGroup tipoClienteToggleGroup;
    
    @FXML private Label documentoIdentidadLB;
    @FXML private TextField documentoIdentidadTF;
    @FXML private Label validaDocumentoIdentidadLB;
    
    @FXML private Label nitLB;
    @FXML private TextField nitTF;
    
    @FXML private Label nombreLB;
    @FXML private TextField nombreTF;
    
    @FXML private Label direccionLB;
    @FXML private TextField direccionTF;
    
    @FXML private Label numeroContactoLB;
    @FXML private TextField numeroContactoTF;
    
    @FXML private Label ocupacionLB;
    @FXML private TextField ocupacionTF;
    
    @FXML private Label nombreEmpresaLB;
    @FXML private TextField nombreEmpresaTF;
    
    @FXML private Label sectorComercialLB;
    @FXML private TextField sectorComercialTF;
    
    @FXML private Label direccionEmpresaLB;
    @FXML private TextField direccionEmpresaTF;
    
    @FXML private Button boton;
    
    @FXML private ListView<Cliente> clienteslst;
    
    private ArrayList<String> errores;
    private ObservableList<Cliente> clientes;
    private ObservableList<Empresa> empresas;

    
    public VentanaUsuarioController(){
        //En el constructor (este método) aún no existen los componentes de la interfaz de usuario
        errores = new ArrayList<String>();
        
}
    //Este método activa y desactiva campos de texto según la opción escogida
    //con los Radio Button de "Persona natural" y "Empresa"
    public void toggleCamposTexto(){
        
        if(this.tipoClienteToggleGroup.getSelectedToggle().equals(this.personaNaturalRB)){
            
            documentoIdentidadTF.setDisable(false);
            nombreTF.setDisable(false);
            direccionTF.setDisable(false);
            numeroContactoTF.setDisable(false);
            ocupacionTF.setDisable(false);
            
            nitTF.setDisable(true);
            nombreEmpresaTF.setDisable(true);
            sectorComercialTF.setDisable(true);
            direccionEmpresaTF.setDisable(true);
        }
            
        //En el caso de que se haya seleccionado anteriormente el radio button de "Persona natural"
        //se rehabilitan los cuatro campos inhabilidatos por ese radio button
        if(this.tipoClienteToggleGroup.getSelectedToggle().equals(this.empresaRB)){
            
            documentoIdentidadTF.setDisable(false);
            nombreTF.setDisable(false);
            direccionTF.setDisable(false);
            numeroContactoTF.setDisable(false);
            ocupacionTF.setDisable(false);
            
            nitTF.setDisable(false);
            nombreEmpresaTF.setDisable(false);
            sectorComercialTF.setDisable(false);
            direccionEmpresaTF.setDisable(false);
        }
    }
    
    public void validar(){
        if(documentoIdentidadTF.getText().isEmpty()){
            errores.add("Digitar documento de identidad, sólo números");
        }
        if(nitTF.getText().isEmpty() && empresaRB.isSelected()){
            errores.add("Digitar NIT");
        }
        if(nombreTF.getText().isEmpty()){
            errores.add("Digitar nombre");
        }
        if(direccionTF.getText().isEmpty()){
            errores.add("Digitar direccion de la persona");
        }
        if(numeroContactoTF.getText().isEmpty()){
            errores.add("Digitar número de contacto, sólo números");
        }
        if(ocupacionTF.getText().isEmpty()){
            errores.add("Digitar ocupación de la persona");
        }
        if(nombreEmpresaTF.getText().isEmpty() && empresaRB.isSelected()){
            errores.add("Digitar nombre de la empresa");
        }
        if(sectorComercialTF.getText().isEmpty() && empresaRB.isSelected()){    
            errores.add("Digitar sector comercial de la empresa");
        }
        if(direccionEmpresaTF.getText().isEmpty() && empresaRB.isSelected()){    
            errores.add("Digitar direccion de la empresa");
    }
    }
    
    @FXML
    public void guardar(){
        if(personaNaturalRB.isSelected()){
            clientes.add(
                    new Cliente(
                            documentoIdentidadTF.getText(),
                            nombreTF.getText(),
                            direccionTF.getText(),
                            numeroContactoTF.getText(),
                            ocupacionTF.getText()
                    )
            );
        }
        if(empresaRB.isSelected()){
            empresas.add(
                    new Empresa(
                            documentoIdentidadTF.getText(),
                            nitTF.getText(),
                            nombreTF.getText(),
                            direccionTF.getText(),
                            numeroContactoTF.getText(),
                            ocupacionTF.getText(),
                            nombreEmpresaTF.getText(),
                            sectorComercialTF.getText(),
                            direccionEmpresaTF.getText()
                    )
            );
        }
        validar();
        if(errores.size() > 0){
            String cadenaErrores = "";
            for(int i = 0; i<errores.size();i++){
                cadenaErrores += errores.get(i) + "\n";
            }
            Alert mensaje = new Alert(AlertType.ERROR);
            mensaje.setTitle("Error");
            mensaje.setHeaderText("Para diligenciar exitosamente este formulario se requiere:");
            mensaje.setContentText(cadenaErrores);
            mensaje.show();
            errores.clear();
            return;
        }
    }
    
       
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Agrupa los Radio Buttons de "Persona natural" y "Empresa" como una sola entidad para que opere solo uno a la vez
        tipoClienteToggleGroup = new ToggleGroup();
        this.personaNaturalRB.setToggleGroup(tipoClienteToggleGroup);
        this.empresaRB.setToggleGroup(tipoClienteToggleGroup);
        this.documentoIdentidadTF.setDisable(true);
        this.nitTF.setDisable(true);
        this.nombreTF.setDisable(true);
        this.direccionTF.setDisable(true);
        this.numeroContactoTF.setDisable(true);
        this.ocupacionTF.setDisable(true);
        this.nombreEmpresaTF.setDisable(true);
        this.sectorComercialTF.setDisable(true);
        this.direccionEmpresaTF.setDisable(true);
        clientes = FXCollections.observableArrayList();
        empresas = FXCollections.observableArrayList();
        clienteslst.setItems(clientes);
    }
    

    

}
