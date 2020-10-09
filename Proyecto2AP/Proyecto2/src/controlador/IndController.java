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
import modelo.Individual;

public class IndController implements Initializable {

    @FXML
    private Button botonRegresar;
    @FXML
    private Button botonRegistrar;
    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtDireccion;
    @FXML
    private TextField txtTelefono;
    @FXML
    private TextField txtDpi;
    @FXML
    private TableView<Individual> tabla;
    @FXML
    private TableColumn<Individual, Integer> colId;
    @FXML
    private TableColumn<Individual, String> colNombre;
    @FXML
    private TableColumn<Individual, String> colTelefono;
    @FXML
    private Button botoActualizar;
    @FXML
    private Button botonEliminar;
    @FXML
    private TextField txtId;
    @FXML
    private Button botonNuevo;
    @FXML
    private TableColumn<Individual, String> colDpi;
    @FXML
    private TableColumn<Individual, String> colDireccion;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showIndividuales();
    }    

    
    @FXML
    private void BackFunction (ActionEvent event) {
        try {
            Individual individual = new Individual(txtDpi.getText(), txtNombre.getText(),
                    txtDireccion.getText(), txtTelefono.getText(), "individual");
            Sesion.clientes.add(individual);
            JOptionPane.showMessageDialog(null, "REGISTRO ACEPTADO", "NUEVO REGISTRO", JOptionPane.INFORMATION_MESSAGE);
            showIndividuales();
            cleanSpaces();
        } catch (HeadlessException e) {
           JOptionPane.showMessageDialog(null, "ERROR, DATOS INVALIDOS", "ERROR", JOptionPane.ERROR_MESSAGE);
            cleanSpaces();
        }

    }
    
    @FXML
    private void upgrade (ActionEvent event) {
         int posicion = 0;
        try {
            Individual individual = new Individual(txtDpi.getText(), txtNombre.getText(),
                    txtDireccion.getText(), txtTelefono.getText(), "individual");
            for (Cliente cliente : Sesion.clientes) {
                if (Integer.parseInt(txtId.getText()) == cliente.getId()) {
                    posicion = Sesion.clientes.indexOf(cliente);
                    break;
                }
            }
            individual.setId(Integer.parseInt(txtId.getText()));
            Sesion.clientes.set(posicion, individual);
            Cliente.sigIdCliente--;
            JOptionPane.showMessageDialog(null, "SU REGISTRO HA SIDO ACTUALIZADO", "ACTUALIZAR REGISTRO", JOptionPane.INFORMATION_MESSAGE);
            showIndividuales();
            cleanSpaces();
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ERROR, IMPOSIBLE ACTUALIZAR EL REGISTRO", "ERROR", JOptionPane.ERROR_MESSAGE);
            cleanSpaces();
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
            JOptionPane.showMessageDialog(null, "EL REGISTRO HA SIDO ELIMINADO", "ElIMINAR REGISTRO", JOptionPane.INFORMATION_MESSAGE);
            showIndividuales();
            cleanSpaces();
        } catch (HeadlessException | NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ERROR, IMPOSIBLE ELIMINAR REGISTRO", "ERROR", JOptionPane.ERROR_MESSAGE);
            cleanSpaces();
        }
    }
    
    
    public ObservableList<Individual> getIndividuales(){
        ObservableList<Individual> listaIndi = FXCollections.observableArrayList();
        for(Cliente c: Sesion.clientes){
            if(c.getTipoCliente().equals("individual")){
                Individual i = (Individual) c;
                 listaIndi.add(i);
            }
           
            }
        return listaIndi;
    }
    
    public void showIndividuales(){
        ObservableList<Individual> list = getIndividuales();
        colId.setCellValueFactory(new PropertyValueFactory<>("id") );
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        colDpi.setCellValueFactory(new PropertyValueFactory<>("DPI"));
        colDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        tabla.setItems(list);
    }

    public void closeWindows(){
         try{
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/ClientVista.fxml"));
                Parent root = loader.load();
                ControlCliente controlador = loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                Stage myStage = (Stage) this.botonRegresar.getScene().getWindow();
                myStage.close();
         }catch(IOException e){
             
         }
    }

    @FXML
    private void click(MouseEvent event) {
        Individual ind = tabla.getSelectionModel().getSelectedItem();
        txtId.setText(String.valueOf(ind.getId()));
        txtNombre.setText(ind.getNombre());
        txtDireccion.setText(ind.getDireccion());
        txtTelefono.setText(ind.getTelefono());
        txtDpi.setText(ind.getDPI());
    }

   
    @FXML
    private void nuevo(ActionEvent event) {
        cleanSpaces();
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
            Stage myStage = (Stage) this.botonRegresar.getScene().getWindow();
            myStage.close();
        } catch (IOException e) {
        }
    }

     public void cleanSpaces() {
        txtId.setText("");
        txtNombre.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtDpi.setText("");
    }
    
}
