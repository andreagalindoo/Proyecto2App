package controlador;

import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
import modelo.Producto;

public class Product implements Initializable {

    @FXML
    private TextField txtId;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtDescripcion;
    @FXML
    private TextField txtPrecio;
    @FXML
    private TableColumn<Producto, Integer> colId;
    @FXML
    private TableColumn<Producto, String> colNombre;
    @FXML
    private TableColumn<Producto, String> colDescripcion;
    @FXML
    private TableColumn<Producto, Integer> colPrecio;
    @FXML
    private Button botonInsertar;
    @FXML
    private Button botonActualizar;
    @FXML
    private Button botonEliminar;
    @FXML
    private TableView<Producto> tabla;
    @FXML
    private TextField txtCantidad;
    @FXML
    private TableColumn<Producto, Integer> colCantidad;
    @FXML
    private Button botonRegresar;
    @FXML
    private Button botonGrid;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showProducts();
    }

    @FXML
    private void insert (ActionEvent event) {
        try {
            Producto producto = new Producto(txtNombre.getText(), txtDescripcion.getText(), Integer.parseInt(txtPrecio.getText()), Integer.parseInt(txtCantidad.getText()));
            Sesion.productos.add(producto);
            JOptionPane.showMessageDialog(null, "REGISTRO EXITOSO!", "NUEVO REGISTRO", JOptionPane.INFORMATION_MESSAGE);
            showProducts();
            cleanSpaces();
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ERROR, DATOS INVALIDOS S", "ERROR", JOptionPane.ERROR_MESSAGE);
            cleanSpaces();
        }
    }

    @FXML
    private void update (ActionEvent event) {
        int posicion = 0;
        try {
            Producto producto = new Producto(txtNombre.getText(), txtDescripcion.getText(), Integer.parseInt(txtPrecio.getText()), Integer.parseInt(txtCantidad.getText()));
            for (Producto p : Sesion.productos) {
                if (Integer.parseInt(txtId.getText()) == p.getId()) {
                    posicion = Sesion.productos.indexOf(p);
                    break;
                }
            }
            producto.setId(Integer.parseInt(txtId.getText()));
            Sesion.productos.set(posicion, producto);
            Producto.sigIdProducto--;
            JOptionPane.showMessageDialog(null, "REGISTRO ACTUALIZADO", "ACTUALIZAR REGISTRO", JOptionPane.INFORMATION_MESSAGE);
            showProducts();
            cleanSpaces();
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ERROR, NO SE PUDO ACTUALIZAR EL REGISTRO", "ERROR", JOptionPane.ERROR_MESSAGE);
            cleanSpaces();
        }
    }

    @FXML
    private void delete (ActionEvent event) {
        try {
            int posicion = 0;
            for (Producto p : Sesion.productos) {
                if (Integer.parseInt(txtId.getText()) == p.getId()) {
                    posicion = Sesion.productos.indexOf(p);
                    break;
                }
            }
            Sesion.productos.remove(posicion);
            JOptionPane.showMessageDialog(null, "EL REGISTRO HA SIDO ELIMINADO", "ElIMINAR REGISTRO", JOptionPane.INFORMATION_MESSAGE);
            showProducts();
            cleanSpaces();
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ERROR, IMPOSIBLE ELIMINAR EL REGISTRO", "ERROR", JOptionPane.ERROR_MESSAGE);
            cleanSpaces();
        }
    }

    public ObservableList<Producto> getProducts() {
        ObservableList<Producto> listaProductos = FXCollections.observableArrayList();
        for (Producto producto : Sesion.productos) {
            listaProductos.add(producto);
        }
        return listaProductos;
    }

    public void showProducts() {
        ObservableList<Producto> list = getProducts();
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colCantidad.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        tabla.setItems(list);
    }

    public void closeWindows() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/InicioVista.fxml"));
            Parent root = loader.load();
            Start controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            Stage myStage = (Stage) this.botonInsertar.getScene().getWindow();
            myStage.close();
        } catch (IOException ex) {
            Logger.getLogger(ControlCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void click(MouseEvent event) {
        Producto producto = tabla.getSelectionModel().getSelectedItem();
        txtId.setText(String.valueOf(producto.getId()));
        txtNombre.setText(producto.getNombre());
        txtDescripcion.setText(producto.getDescripcion());
        txtPrecio.setText(String.valueOf(producto.getPrecio()));
        txtCantidad.setText(String.valueOf(producto.getCantidad()));
    }

    public void cleanSpaces() {
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtPrecio.setText("");
        txtCantidad.setText("");
        txtId.setText("");
    }

    @FXML
    private void back (ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/InicioVista.fxml"));
            Parent root = loader.load();
            Start controlador = loader.getController();
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
    private void mostrarP(ActionEvent event) {
        try{
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/GridProductoVista.fxml"));
                Parent root = loader.load();
                GridProduct controlador = loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                stage.setOnCloseRequest(e -> controlador.closeWindows());
                Stage myStage = (Stage) this.botonGrid.getScene().getWindow();
                myStage.close();
               
         }catch(IOException e){
         }
    }
}
