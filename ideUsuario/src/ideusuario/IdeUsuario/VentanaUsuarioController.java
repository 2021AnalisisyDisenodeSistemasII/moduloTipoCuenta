/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ideusuario.IdeUsuario;

import Clases.PersonaNatural;
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
    
    @FXML private Button ingresarBT;
    @FXML private Button limpiarBT;
    
    @FXML private ListView<PersonaNatural> clienteslst;
    
    private boolean formularioLleno = true;
    private ArrayList<String> errores;
    private ObservableList<PersonaNatural> personasNaturales;
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
        if(!personaNaturalRB.isSelected() && !empresaRB.isSelected()){
            errores.add("Iniciar llenado del formulario indicando el tipo de cuenta a activar");
            formularioLleno = false;
            return;
        }
        if(documentoIdentidadTF.getText().isEmpty()){
            errores.add("Digitar documento de identidad, sólo números");
            formularioLleno = false;
        }
        if(nitTF.getText().isEmpty() && empresaRB.isSelected()){
            errores.add("Digitar NIT");
            formularioLleno = false;
        }
        if(nombreTF.getText().isEmpty()){
            errores.add("Digitar nombre");
            formularioLleno = false;
        }
        if(direccionTF.getText().isEmpty()){
            errores.add("Digitar direccion de la persona");
            formularioLleno = false;
        }
        if(numeroContactoTF.getText().isEmpty()){
            errores.add("Digitar número de contacto, sólo números");
            formularioLleno = false;
        }
        if(ocupacionTF.getText().isEmpty()){
            errores.add("Digitar ocupación de la persona");
            formularioLleno = false;
        }
        if(nombreEmpresaTF.getText().isEmpty() && empresaRB.isSelected()){
            errores.add("Digitar nombre de la empresa");
            formularioLleno = false;
        }
        if(sectorComercialTF.getText().isEmpty() && empresaRB.isSelected()){    
            errores.add("Digitar sector comercial de la empresa");
            formularioLleno = false;
        }
        if(direccionEmpresaTF.getText().isEmpty() && empresaRB.isSelected()){    
            errores.add("Digitar direccion de la empresa");
            formularioLleno = false;
        }
    }
    
    @FXML
    public void guardar(){
        validar();
        if(personaNaturalRB.isSelected() && formularioLleno == true){
            personasNaturales.add(
                    new PersonaNatural(
                            documentoIdentidadTF.getText(),
                            nombreTF.getText(),
                            direccionTF.getText(),
                            numeroContactoTF.getText(),
                            ocupacionTF.getText()
                    )
            );
        }
        if(empresaRB.isSelected() && formularioLleno == true){
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
            formularioLleno = true;
            return;
        }
    }
    
    @FXML
    public void limpiar(){
            documentoIdentidadTF.setText("");
            nitTF.setText("");
            nombreTF.setText("");
            direccionTF.setText("");
            numeroContactoTF.setText("");
            ocupacionTF.setText("");
            nombreEmpresaTF.setText("");
            sectorComercialTF.setText("");
            direccionEmpresaTF.setText("");
            tipoClienteToggleGroup.selectToggle(null);
            documentoIdentidadTF.setDisable(true);
            nitTF.setDisable(true);
            nombreTF.setDisable(true);
            direccionTF.setDisable(true);
            numeroContactoTF.setDisable(true);
            ocupacionTF.setDisable(true);
            nombreEmpresaTF.setDisable(true);
            sectorComercialTF.setDisable(true);
            direccionEmpresaTF.setDisable(true);
            formularioLleno = true;
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
        personasNaturales = FXCollections.observableArrayList();
        empresas = FXCollections.observableArrayList();
        clienteslst.setItems(personasNaturales);
    }
    

    

}
