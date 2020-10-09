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
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class ControlCliente implements Initializable {

    private Button botonRegistrar;
    @FXML
    private Button botonRegresar;
    @FXML
    private Button botonEmpresas;
    @FXML
    private Button botonIndividual;
    @FXML
    private Button botonConsult;

    @Override
    public void initialize(URL url, ResourceBundle iniciar) {

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
            Stage myStage = (Stage) this.botonRegresar.getScene().getWindow();
            myStage.close();
        } catch (IOException ex) {
            Logger.getLogger(ControlCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void botonRegresar (ActionEvent event) {
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
    private void gEmpresas(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/EmpVista.fxml"));
            Parent root = loader.load();
            Company controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(e -> controlador.closeWindows());
            Stage myStage = (Stage) this.botonRegresar.getScene().getWindow();
            myStage.close();
        } catch (IOException e) {

        }
    }

    @FXML
    private void gIndividual(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/IndVista.fxml"));
            Parent root = loader.load();
            IndController controlador = loader.getController();
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            stage.setOnCloseRequest(e -> controlador.closeWindows());
            Stage myStage = (Stage) this.botonRegresar.getScene().getWindow();
            myStage.close();
        } catch (IOException e) {
        }
    }

    @FXML
    private void consultar(ActionEvent event) {
        int seleccion = JOptionPane.showOptionDialog(null, "INGRESE CONSULTA",
                "CLASE CLIENTE", JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, new Object[]{"EMPRESA", "INDIVIDUAL", "TODOS"}, "EMPRESA");
        if (seleccion == 0) {
            Sesion.tipoConsulta = "empresa";
        }
        if (seleccion == 1) {
            Sesion.tipoConsulta = "individual";
        }
        if (seleccion == 2) {
            Sesion.tipoConsulta = "todos";
        }
        if (seleccion != -1) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/GridClienteVista.fxml"));
                Parent root = loader.load();
                GridClient controlador = loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                stage.setOnCloseRequest(e -> controlador.closeWindows());
                Stage myStage = (Stage) this.botonRegresar.getScene().getWindow();
                myStage.close();
            } catch (IOException e) {

            }
        }
    }
}
