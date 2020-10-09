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
import modelo.Producto;

public class GridProduct implements Initializable {

    @FXML
    private Button btnRegresar;
    @FXML
    private GridPane grid;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ProcessInformation();
    }    

    @FXML
    private void regresar(ActionEvent event) {
        
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/ProductoVista.fxml"));
            Parent root = loader.load();
            Product controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            Stage myStage = (Stage) this.btnRegresar.getScene().getWindow();
            myStage.close();
        } catch (IOException ex) {
            Logger.getLogger(ControlCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void ProcessInformation(){
        int xi=0;
        int y=0;
        grid.setAlignment(Pos.CENTER);
        Text ini = new Text("- PRODUCTOS");
         Text esp0 = new Text("_________________");
         grid.add(ini, y, xi);
         grid.add(esp0, y, 1);
        xi=2;
        for (Producto p : Sesion.productos) {
                Text id = new Text("ID: ");
                Text txtId = new Text(String.valueOf(p.getId()));
                y=0;
                xi++;
                grid.add(id, y, xi);
                y++;
                grid.add(txtId, y, xi);
                
                Text nombreC = new Text("NOMBRE: ");
                Text txtNombre = new Text(p.getNombre());
                y=0;
                xi++;
                grid.add(nombreC, y, xi);
                y++;
                grid.add(txtNombre, y, xi);
                
                Text descripcion = new Text("DESCRIPCION: ");
                Text txtDescripcion = new Text(p.getDescripcion());
                y=0;
                xi++;
                grid.add(descripcion, y, xi);
                y++;
                grid.add(txtDescripcion, y, xi);
                
                Text precio = new Text("PRECIO: ");
                Text txtPrecio = new Text(String.valueOf(p.getPrecio()));
                y=0;
                xi++;
                grid.add(precio, y, xi);
                y++;
                grid.add(txtPrecio, y, xi);
                
                Text cantidad = new Text("CANTIDAD: ");
                Text txtCantidad = new Text(String.valueOf(p.getCantidad()));
                y=0;
                xi++;
                grid.add(cantidad, y, xi);
                y++;
                grid.add(txtCantidad, y, xi);
                Text esp1 = new Text("_________________");
                y=0;
                xi++;
                grid.add(esp1, y, xi);
            
        }
    }
    public void closeWindows(){
        
    }
    
    
}
