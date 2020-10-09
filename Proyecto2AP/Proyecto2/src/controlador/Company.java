package controlador;

import java.awt.HeadlessException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
import modelo.Cliente;
import modelo.Empresa;

public class Company implements Initializable {

    @FXML
    private Button botonRegreso;
    @FXML
    private Button botonRegistrar;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtDireccion;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtContacto;
    @FXML
    private TextField txtDescuento;
    @FXML
    private TableView<Empresa> tabla;
    @FXML
    private TableColumn<Empresa, Integer> colId;
    @FXML
    private TableColumn<Empresa, String> colNombre;
    @FXML
    private TableColumn<Empresa, String> colTelefono;
    @FXML
    private TableColumn<Empresa, String> colContacto;
    @FXML
    private TableColumn<Empresa, Integer> colDescuento;
    @FXML
    private Button botonActualizar;
    @FXML
    private Button botonEliminar;
    @FXML
    private TextField txtId;
    @FXML
    private Button botonNuevo;
    @FXML
    private TableColumn<Empresa, String> colDireccion;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrarEmpresas();
    }


    @FXML
    private void actualizar(ActionEvent event) {
        int posicion = 0;
        try {
            Empresa empresa = new Empresa(txtContacto.getText(), Integer.parseInt(txtDescuento.getText()),
                    txtNombre.getText(), txtDireccion.getText(), txtTelefono.getText(), "empresa");
            for (Cliente cliente : Sesion.clientes) {
                if (Integer.parseInt(txtId.getText()) == cliente.getId()) {
                    posicion = Sesion.clientes.indexOf(cliente);
                    break;
                }
            }
            empresa.setId(Integer.parseInt(txtId.getText()));
            Sesion.clientes.set(posicion, empresa);
            Cliente.sigIdCliente--;
            JOptionPane.showMessageDialog(null, "SU REGISTRO FUE ACTUALIZADO", "ACTUALIZACION DE REGISTRO", JOptionPane.INFORMATION_MESSAGE);
            mostrarEmpresas();
            cleanspaces();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR, IMPOSIBLE ACTUALIZAR REGISTRO", "ERROR", JOptionPane.ERROR_MESSAGE);
            cleanspaces();
        }
    }

    @FXML
    private void delete (ActionEvent event) {
        int posicion = 0;
        try {
            for (Cliente c : Sesion.clientes) {
                if (Integer.parseInt(txtId.getText()) == c.getId()) {
                    posicion = Sesion.clientes.indexOf(c);
                    break;
                }
            }
            Sesion.clientes.remove(posicion);
            JOptionPane.showMessageDialog(null, "SU REGISTRO FUE ELIMINADO", "ElIMINACION DE REGISTRO", JOptionPane.INFORMATION_MESSAGE);
            mostrarEmpresas();
            cleanspaces();
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ERROR, IMPOSIBLE ELIMINAR REGISTRO", "ERROR", JOptionPane.ERROR_MESSAGE);
            cleanspaces();
        }
    }

    public ObservableList<Empresa> getEmpresas() {
        ObservableList<Empresa> listaEmpresas = FXCollections.observableArrayList();

        for (Cliente c : Sesion.clientes) {
            if (c.getTipoCliente().equals("empresa")) {
                Empresa e = (Empresa) c;
                listaEmpresas.add(e);
            }
        }
        return listaEmpresas;
    }

    public void mostrarEmpresas() {
        ObservableList<Empresa> list = getEmpresas();
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colContacto.setCellValueFactory(new PropertyValueFactory<>("contacto"));
        colDescuento.setCellValueFactory(new PropertyValueFactory<>("descuento"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        tabla.setItems(list);
    }

    public void closeWindows() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/ClientVista.fxml"));
            Parent root = loader.load();
            ControlCliente controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            Stage myStage = (Stage) this.botonRegreso.getScene().getWindow();
            myStage.close();
        } catch (IOException e) {
        }
    }

    @FXML
    private void regresar (ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/ClientVista.fxml"));
            Parent root = loader.load();
            ControlCliente controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            Stage myStage = (Stage) this.botonRegreso.getScene().getWindow();
            myStage.close();
        } catch (IOException e) {

        }
    }

    @FXML
    private void click(MouseEvent event) {
        Empresa empresa = tabla.getSelectionModel().getSelectedItem();
        txtId.setText(String.valueOf(empresa.getId()));
        txtNombre.setText(empresa.getNombre());
        txtContacto.setText(empresa.getContacto());
        txtDescuento.setText(String.valueOf(empresa.getDescuento()));
        txtDireccion.setText(empresa.getDireccion());
        txtTelefono.setText(empresa.getTelefono());
    }

    public void cleanspaces() {
        txtId.setText("");
        txtNombre.setText("");
        txtContacto.setText("");
        txtDescuento.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
    }

    @FXML
    private void nuevo(ActionEvent event) {
        cleanspaces();
    }

    @FXML
    private void companyRegistration (ActionEvent event) {
        try {
            Empresa empresa = new Empresa(txtContacto.getText(), Integer.parseInt(txtDescuento.getText()),
                    txtNombre.getText(), txtDireccion.getText(), txtTelefono.getText(), "empresa");
            Sesion.clientes.add(empresa);
            JOptionPane.showMessageDialog(null, "SE HA REGISTRADO EXITOSAMENTE", "REGISTRO NUEVO", JOptionPane.INFORMATION_MESSAGE);
            mostrarEmpresas();
            cleanspaces();
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ERROR, SUS DATOS SON INVALIDOS", "ERROR", JOptionPane.ERROR_MESSAGE);
            cleanspaces();
        }
    }
}
