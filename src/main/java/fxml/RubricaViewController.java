/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package fxml;

import com.mycompany.rubrica.Contatto;
import com.mycompany.rubrica.Contatto;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import com.mycompany.rubrica.*;

/**
 * FXML Controller class
 *
 * @author obbiv
 */
public class RubricaViewController implements Initializable {

    @FXML
    private ListView<Contatto> listaContatti;
    @FXML
    private TextField campoRicerca;
    @FXML
    private Button aggiungiContatto;
    @FXML
    private TextField nome;
    @FXML
    private TextField cognome;
    @FXML
    private TextField numero1;
    @FXML
    private TextField numero2;
    @FXML
    private TextField numero3;
    @FXML
    private TextField email1;
    @FXML
    private TextField email2;
    @FXML
    private TextField email3;
    @FXML
    private Button aggiungiNumero;
    @FXML
    private Button aggiungiEmail;
    @FXML
    private Button rimuoviNumero1;
    @FXML
    private Button rimuoviEmail1;
    @FXML
    private Button eliminaContatto;
    @FXML
    private Button rimuoviNumero2;
    @FXML
    private Button rimuoviNumero3;
    @FXML
    private Button rimuoviEmail3;
    @FXML
    private Button rimuoviEmail2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onAddContatto(MouseEvent event) {
    }

    @FXML
    private void onAddNumero(MouseEvent event) {
    }

    @FXML
    private void onAddEmail(MouseEvent event) {
    }

    @FXML
    private void onRemoveNumero1(MouseEvent event) {
    }

    @FXML
    private void onRemoveEmail1(MouseEvent event) {
    }

    @FXML
    private void onRemoveContatto(MouseEvent event) {
    }

    @FXML
    private void onRemoveNumero2(MouseEvent event) {
    }

    @FXML
    private void onRemoveNumero3(MouseEvent event) {
    }

    @FXML
    private void onRemoveEmail3(MouseEvent event) {
    }

    @FXML
    private void onRemoveEmail2(MouseEvent event) {
    }
    
}
