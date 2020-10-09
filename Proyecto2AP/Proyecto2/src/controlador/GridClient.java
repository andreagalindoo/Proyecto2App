package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelo.Cliente;
import modelo.Empresa;
import modelo.Individual;

public class GridClient implements Initializable {
    @FXML
    private Button botonRegresar;
    @FXML
    private GridPane grid;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        if(Sesion.tipoConsulta.equals("empresa")){
     CompanyInformation();
        }else{
            if(Sesion.tipoConsulta.equals("individual")){
                cargarInformacionIndividual();
            }else{
                cargarInformacion();
            }
        }
    }    

    public void closeWindows(){
    
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/ClientVista.fxml"));
            Parent root = loader.load();
            ControlCliente controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            Stage myStage = (Stage) this.botonRegresar.getScene().getWindow();
            myStage.close();
        } catch (IOException ex) {
            Logger.getLogger(ControlCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void back (ActionEvent event) {
          try {
           FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/ClientVista.fxml"));
                Parent root = loader.load();
                ControlCliente controlador = loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                Stage myStage = (Stage) this.botonRegresar.getScene().getWindow();
                myStage.close();
        } catch (IOException ex) {
            Logger.getLogger(ControlCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void CompanyInformation() {
        int xi=0;
        int y=0;
        grid.setAlignment(Pos.CENTER);
        Text ini = new Text("- EMPRESAS");
         Text esp0 = new Text("_________________");
         grid.add(ini, y, xi);
         grid.add(esp0, y, 1);
        xi=2;
        for (Cliente e : Sesion.clientes) {
            if (e.getTipoCliente().equals("empresa")) {
                
                
                
                Empresa empresa = (Empresa) e;
                
                Text tipoC = new Text("TIPO DE CLIENTE: ");
                Text txtTipo = new Text("Empresa");
                grid.add(tipoC, y, xi);
                y++;
                grid.add(txtTipo, y, xi);
                
                
                Text id = new Text("ID: ");
                Text txtId = new Text(String.valueOf(empresa.getId()));
                y=0;
                xi++;
                grid.add(id, y, xi);
                y++;
                grid.add(txtId, y, xi);
                
                Text nombreCliente = new Text("NOMBRE: ");
                Text txtNombre = new Text(empresa.getNombre());
                y=0;
                xi++;
                grid.add(nombreCliente, y, xi);
                y++;
                grid.add(txtNombre, y, xi);
                
                Text direccion = new Text("DIRECCION: ");
                Text txtDireccion = new Text(empresa.getDireccion());
                y=0;
                xi++;
                grid.add(direccion, y, xi);
                y++;
                grid.add(txtDireccion, y, xi);
                
                Text telefono = new Text("TELEFONO: ");
                Text txtTelefono = new Text(empresa.getTelefono());
                y=0;
                xi++;
                grid.add(telefono, y, xi);
                y++;
                grid.add(txtTelefono, y, xi);
                
                Text contacto = new Text("CONTACTO: ");
                Text txtContacto = new Text(empresa.getContacto());
                y=0;
                xi++;
                grid.add(contacto, y, xi);
                y++;
                grid.add(txtContacto, y,xi );
                
                Text descuento = new Text("DESCUENTO: ");
                Text txtDescuento = new Text(String.valueOf(empresa.getDescuento()));
                y=0;
                xi++;
                grid.add(descuento, y, xi);
                y++;
                grid.add(txtDescuento, y, xi);
                
               Text esp1 = new Text("_________________");
                y=0;
                xi++;
                grid.add(esp1, y, xi);
            }
        }
    }
    
    
    
    public void cargarInformacionIndividual() {
        int y=0;
        int xi=0;
        grid.setAlignment(Pos.CENTER);
        Text ini = new Text("- INDIVIDUAL");
         Text esp0 = new Text("_________________");
         grid.add(ini, y, xi);
         grid.add(esp0, y, 1);
        xi=2;
        for (Cliente i : Sesion.clientes) {
            if (i.getTipoCliente().equals("individual")) {
                
                
                
                Individual indi = (Individual) i;
                
                Text tipoC = new Text("TIPO DE CLIENTE: ");
                Text txtTipo = new Text("Individual");
                grid.add(tipoC, y, xi);
                y++;
                grid.add(txtTipo, y, xi);
                
                
                Text id = new Text("ID: ");
                Text txtId = new Text(String.valueOf(indi.getId()));
                y=0;
                xi++;
                grid.add(id, y, xi);
                y++;
                grid.add(txtId, y, xi);
                
                Text nombreC = new Text("NOMBRE: ");
                Text txtNombre = new Text(indi.getNombre());
                y=0;
                xi++;
                grid.add(nombreC, y, xi);
                y++;
                grid.add(txtNombre, y, xi);
                
                Text direccion = new Text("DIRECCION: ");
                Text txtDireccion = new Text(indi.getDireccion());
                y=0;
                xi++;
                grid.add(direccion, y, xi);
                y++;
                grid.add(txtDireccion, y, xi);
                
                Text telefono = new Text("TELEFONO: ");
                Text txtTelefono = new Text(indi.getTelefono());
                y=0;
                xi++;
                grid.add(telefono, y, xi);
                y++;
                grid.add(txtTelefono, y, xi);
                
                Text dpi = new Text("DPI: ");
                Text txtDpi = new Text(indi.getDPI());
                y=0;
                xi++;
                grid.add(dpi, y, xi);
                y++;
                grid.add(txtDpi, y, xi);
                Text esp1 = new Text("_________________");
                y=0;
                xi++;
                grid.add(esp1, y, xi);
            }
        }
    }

    private void cargarInformacion() {
        
        int xi=0;
        int y=0;
        grid.setAlignment(Pos.CENTER);
        Text ini = new Text("- TODOS LOS CLIENTES");
         Text esp0 = new Text("_________________");
         grid.add(ini, y, xi);
         grid.add(esp0, y, 1);
        xi=2;
        for (Cliente i : Sesion.clientes) {
            if (i.getTipoCliente().equals("individual")) {
                Individual indi = (Individual) i;
                Text tipoC = new Text("TIPO DE CLIENTE: ");
                Text txtTipo = new Text("Individual");
                grid.add(tipoC, y, xi);
                y++;
                grid.add(txtTipo, y, xi);
                
                
                Text id = new Text("ID: ");
                Text txtId = new Text(String.valueOf(indi.getId()));
                y=0;
                xi++;
                grid.add(id, y, xi);
                y++;
                grid.add(txtId, y, xi);
                
                Text nombreC = new Text("NOMBRE: ");
                Text txtNombre = new Text(indi.getNombre());
                y=0;
                xi++;
                grid.add(nombreC, y, xi);
                y++;
                grid.add(txtNombre, y, xi);
                
                Text direccion = new Text("DIRECCION: ");
                Text txtDireccion = new Text(indi.getDireccion());
                y=0;
                xi++;
                grid.add(direccion, y, xi);
                y++;
                grid.add(txtDireccion, y, xi);
                
                Text telefono = new Text("TELEFONO: ");
                Text txtTelefono = new Text(indi.getTelefono());
                y=0;
                xi++;
                grid.add(telefono, y, xi);
                y++;
                grid.add(txtTelefono, y, xi);
                
                Text dpi = new Text("DPI: ");
                Text txtDpi = new Text(indi.getDPI());
                y=0;
                xi++;
                grid.add(dpi, y, xi);
                y++;
                grid.add(txtDpi, y, xi);
                Text esp1 = new Text("_________________");
                y=0;
                xi++;
                grid.add(esp1, y, xi);
            }else{
                
                
                Empresa empresa = (Empresa) i;
                
                Text tipoC = new Text("TIPO DE CLIENTE: ");
                Text txtTipo = new Text("Empresa");
                grid.add(tipoC, y, xi);
                y++;
                grid.add(txtTipo, y, xi);
                
                
                Text id = new Text("ID: ");
                Text txtId = new Text(String.valueOf(empresa.getId()));
                y=0;
                xi++;
                grid.add(id, y, xi);
                y++;
                grid.add(txtId, y, xi);
                
                Text nombreC = new Text("NOMBRE: ");
                Text txtNombre = new Text(empresa.getNombre());
                y=0;
                xi++;
                grid.add(nombreC, y, xi);
                y++;
                grid.add(txtNombre, y, xi);
                
                Text direccion = new Text("DIRECCION: ");
                Text txtDireccion = new Text(empresa.getDireccion());
                y=0;
                xi++;
                grid.add(direccion, y, xi);
                y++;
                grid.add(txtDireccion, y, xi);
                
                Text telefono = new Text("TELEFONO: ");
                Text txtTelefono = new Text(empresa.getTelefono());
                y=0;
                xi++;
                grid.add(telefono, y, xi);
                y++;
                grid.add(txtTelefono, y, xi);
                
                Text contacto = new Text("CONTACTO: ");
                Text txtContacto = new Text(empresa.getContacto());
                y=0;
                xi++;
                grid.add(contacto, y, xi);
                y++;
                grid.add(txtContacto, y, xi);
                
                Text descuento = new Text("DESCUENTO: ");
                Text txtDescuento = new Text(String.valueOf(empresa.getDescuento()));
                y=0;
                xi++;
                grid.add(descuento, y, xi);
                y++;
                grid.add(txtDescuento, y, xi);
                
               Text esp1 = new Text("_________________");
                y=0;
                xi++;
                grid.add(esp1, y, xi);
                
            }
        }






    }
    
}
