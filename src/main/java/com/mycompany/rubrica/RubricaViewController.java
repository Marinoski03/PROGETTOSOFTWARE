/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.rubrica;

import com.mycompany.rubrica.Contatto;
import com.mycompany.rubrica.FileManager;
import com.mycompany.rubrica.Rubrica;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author obbiv
 */
public class RubricaViewController implements Initializable {

    @FXML
    private TextField campoRicerca;
    @FXML
    private ListView<Contatto> listaContatti;
    @FXML
    private Button aggiungiContatto;
    @FXML
    private AnchorPane dettagliContatto;
    @FXML
    private TextField nome;
    @FXML
    private TextField cognome;
    @FXML
    private TextField numero1;
    @FXML
    private Button rimuoviNumero1;
    @FXML
    private Button aggiungiNumero1;
    @FXML
    private TextField numero2;
    @FXML
    private Button rimuoviNumero2;
    @FXML
    private Button aggiungiNumero2;
    @FXML
    private TextField numero3;
    @FXML
    private Button rimuoviNumero3;
    @FXML
    private Button aggiungiNumero3;
    @FXML
    private TextField email1;
    @FXML
    private Button rimuoviEmail1;
    @FXML
    private Button aggiungiEmail1;
    @FXML
    private TextField email2;
    @FXML
    private Button rimuoviEmail2;
    @FXML
    private Button aggiungiEmail2;
    @FXML
    private TextField email3;
    @FXML
    private Button rimuoviEmail3;
    @FXML
    private Button aggiungiEmail3;
    @FXML
    private Button modificaContatto;
    @FXML
    private Button salvaContatto;
    @FXML
    private Button eliminaContatto;

    private Rubrica r;
    private FileManager fm;
    private boolean addingNewContact = false;
    private boolean editingContact = false;

    // Regex patterns for validation
    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    private static final Pattern PHONE_PATTERN = Pattern.compile("^\\+?\\d{10,14}$");
    private static final String CONTATTI_FILE = "Contatti.txt";
    
    
    @Override
public void initialize(URL url, ResourceBundle rb) {
    try {
        fm=new FileManager();
        r = fm.caricaDaFileRubrica(CONTATTI_FILE);
        listaContatti.setItems(r.getContatti());
        listaContatti.setOnMouseClicked(this::onContattoSelezionato);
        
        campoRicerca.textProperty().addListener((observable, oldValue, newValue) -> filtraContatti(newValue));
        
        toggleContactFields(false);
        
        // Aggiungi listener per i pulsanti principali
        aggiungiContatto.setOnAction(event -> onStartAddContatto());
        modificaContatto.setOnAction(event -> onStartModificaContatto());
        salvaContatto.setOnAction(event -> onSalvaContatto(null));
        //salvaContatto.setOnMouseClicked(this::onSaveContatto);
        eliminaContatto.setOnAction(event -> onRemoveContatto(null));

        // Aggiungi listener per i pulsanti di aggiunta/rimozione numeri
        aggiungiNumero1.setOnMouseClicked(this::onAddNumero1);
        aggiungiNumero2.setOnMouseClicked(this::onAddNumero2);
        aggiungiNumero3.setOnMouseClicked(this::onAddNumero3);
        rimuoviNumero1.setOnMouseClicked(this::onRemoveNumero1);
        rimuoviNumero2.setOnMouseClicked(this::onRemoveNumero2);
        rimuoviNumero3.setOnMouseClicked(this::onRemoveNumero3);

        // Aggiungi listener per i pulsanti di aggiunta/rimozione email
        aggiungiEmail1.setOnMouseClicked(this::onAddEmail1);
        aggiungiEmail2.setOnMouseClicked(this::onAddEmail2);
        aggiungiEmail3.setOnMouseClicked(this::onAddEmail3);
        rimuoviEmail1.setOnMouseClicked(this::onRemoveEmail1);
        rimuoviEmail2.setOnMouseClicked(this::onRemoveEmail2);
        rimuoviEmail3.setOnMouseClicked(this::onRemoveEmail3);
        
    } catch (Exception e) {
        mostraErrore("Errore di inizializzazione", "Impossibile caricare i contatti: " + e.getMessage());
    }
}
    
    
    
     private void filtraContatti(String filtro) {
        if (filtro == null || filtro.isEmpty()) {
            listaContatti.setItems(r.getContatti());
        } else {
            // Filtra per nome o cognome (case-insensitive)
            ObservableList<Contatto> contattiFiltrati = r.getContatti().filtered(contatto -> 
                contatto.getNome().toLowerCase().contains(filtro.toLowerCase()) ||
                contatto.getCognome().toLowerCase().contains(filtro.toLowerCase())
            );
            listaContatti.setItems(contattiFiltrati);
        }
    }
    
      // Validazione email
    private boolean validaEmail(String email) {
        return email == null || email.isEmpty() || EMAIL_PATTERN.matcher(email).matches();
    }

    // Validazione numero di telefono
    private boolean validaNumeroTelefono(String numero) {
        return numero == null || numero.isEmpty() || PHONE_PATTERN.matcher(numero).matches();
    }
     
   private void toggleModificationFields(boolean enable) {
    aggiungiNumero1.setVisible(enable);
    aggiungiNumero2.setVisible(enable);
    aggiungiNumero3.setVisible(enable);
    aggiungiEmail1.setVisible(enable);
    aggiungiEmail2.setVisible(enable);
    aggiungiEmail3.setVisible(enable);
    rimuoviNumero1.setVisible(enable);
    rimuoviNumero2.setVisible(enable);
    rimuoviNumero3.setVisible(enable);
    rimuoviEmail1.setVisible(enable);
    rimuoviEmail2.setVisible(enable);
    rimuoviEmail3.setVisible(enable);
}
    
     private void toggleContactFields(boolean enable) {
        nome.setDisable(!enable);
        cognome.setDisable(!enable);
        numero1.setDisable(!enable);
        numero2.setDisable(!enable);
        numero3.setDisable(!enable);
        email1.setDisable(!enable);
        email2.setDisable(!enable);
        email3.setDisable(!enable);

        aggiungiNumero1.setDisable(!enable);
        aggiungiNumero2.setDisable(!enable);
        aggiungiNumero3.setDisable(!enable);
        aggiungiEmail1.setDisable(!enable);
        aggiungiEmail2.setDisable(!enable);
        aggiungiEmail3.setDisable(!enable);
        rimuoviNumero1.setDisable(!enable);
        rimuoviNumero2.setDisable(!enable);
        rimuoviNumero3.setDisable(!enable);
        rimuoviEmail1.setDisable(!enable);
        rimuoviEmail2.setDisable(!enable);
        rimuoviEmail3.setDisable(!enable);
        //eliminaContatto.setDisable(!enable);
    }
     
     private void toggleContattoSelezionato(boolean enable){
         modificaContatto.setDisable(!enable);
         eliminaContatto.setDisable(!enable);
     }

        private void onContattoSelezionato(MouseEvent event) {
        Contatto selectedContact = listaContatti.getSelectionModel().getSelectedItem();
        toggleContattoSelezionato(true);
        if (selectedContact != null) {
            nome.setText(selectedContact.getNome());
            cognome.setText(selectedContact.getCognome());

            // Carica i numeri di telefono
            if (!selectedContact.getNumeri().isEmpty()) numero1.setText(selectedContact.getNumeri().get(0));
            if (selectedContact.getNumeri().size() > 1) numero2.setText(selectedContact.getNumeri().get(1));
            if (selectedContact.getNumeri().size() > 2) numero3.setText(selectedContact.getNumeri().get(2));

            // Carica le email
            if (!selectedContact.getEmail().isEmpty()) email1.setText(selectedContact.getEmail().get(0));
            if (selectedContact.getEmail().size() > 1) email2.setText(selectedContact.getEmail().get(1));
            if (selectedContact.getEmail().size() > 2) email3.setText(selectedContact.getEmail().get(2));
        }
    }
        
    private void onStartAddContatto() {
    addingNewContact = true;
    editingContact = false;
    toggleContactFields(true);
    toggleContattoSelezionato(false);

     // Abilita specificamente i pulsanti di aggiunta
    aggiungiNumero1.setDisable(false);
    aggiungiNumero2.setDisable(false);
    aggiungiNumero3.setDisable(false);
    aggiungiEmail1.setDisable(false);
    aggiungiEmail2.setDisable(false);
    aggiungiEmail3.setDisable(false);

    // Svuota i campi
    nome.clear();
    cognome.clear();
    numero1.clear();
    numero2.clear();
    numero3.clear();
    email1.clear();
    email2.clear();
    email3.clear();

    listaContatti.getSelectionModel().clearSelection();
    
    // Abilita il salvataggio
    salvaContatto.setDisable(false);
    }
    
      private void onStartModificaContatto() {
        Contatto selectedContact = listaContatti.getSelectionModel().getSelectedItem();
        if (selectedContact != null) {
            addingNewContact = false;
            editingContact = true;
            toggleContactFields(true);
            salvaContatto.setDisable(false);
        } else {
            mostraErrore("Errore", "Seleziona un contatto da modificare");
        }
    }
    
    private void onSalvaContatto(MouseEvent event) {
        // Validazione input
        if (nome.getText().trim().isEmpty() || cognome.getText().trim().isEmpty()) {
            mostraErrore("Errore", "Nome e cognome sono obbligatori");
            return;
        }

        // Validazione email e numeri
        if (!validaEmail(email1.getText()) || !validaEmail(email2.getText()) || !validaEmail(email3.getText())) {
            mostraErrore("Errore", "Formato email non valido");
            return;
        }

        if (!validaNumeroTelefono(numero1.getText()) || !validaNumeroTelefono(numero2.getText()) || !validaNumeroTelefono(numero3.getText())) {
            mostraErrore("Errore", "Formato numero di telefono non valido");
            return;
        }

        if (addingNewContact) {
            // Aggiunta nuovo contatto
            Contatto newContact = new Contatto(nome.getText().trim(), cognome.getText().trim());
            
            aggiungiDatiContatto(newContact);
            
            r.aggiungiContatto(newContact);
            //listaContatti.getItems().add(newContact);
            
             try {
            // Mostra dialogo di conferma
            if (mostraConferma("Salvataggio Contatto", "Vuoi salvare questo contatto su file?")) {
                // Utilizzo del metodo salvaSuFile del FileManager
                fm.salvaSuFile(CONTATTI_FILE, newContact);
                mostraConfermaInfo("Salvataggio Riuscito", "Contatto salvato correttamente su file");
            }
        } catch (Exception e) {
            mostraErrore("Errore di Salvataggio", "Impossibile salvare il contatto: " + e.getMessage());
        }
            
            addingNewContact = false;
        } else if (editingContact) {
            // Modifica contatto esistente
            Contatto selectedContact = listaContatti.getSelectionModel().getSelectedItem();
            if (selectedContact != null) {
                selectedContact.setNome(nome.getText().trim());
                selectedContact.setCognome(cognome.getText().trim());
                
                // Rimuovi vecchi dati
                selectedContact.getNumeri().clear();
                selectedContact.getEmail().clear();
                
                // Aggiungi nuovi dati
                aggiungiDatiContatto(selectedContact);
                
                listaContatti.refresh();
                editingContact = false;
            }
        }

        toggleContactFields(false);
        listaContatti.refresh();
    }

    private void aggiungiDatiContatto(Contatto contatto) {
        // Aggiungi numeri
        if (!numero1.getText().trim().isEmpty()) contatto.aggiungiNumero(numero1.getText().trim());
        if (!numero2.getText().trim().isEmpty()) contatto.aggiungiNumero(numero2.getText().trim());
        if (!numero3.getText().trim().isEmpty()) contatto.aggiungiNumero(numero3.getText().trim());

        // Aggiungi email
        if (!email1.getText().trim().isEmpty()) contatto.aggiungiEmail(email1.getText().trim());
        if (!email2.getText().trim().isEmpty()) contatto.aggiungiEmail(email2.getText().trim());
        if (!email3.getText().trim().isEmpty()) contatto.aggiungiEmail(email3.getText().trim());
    } 
      
    private void onAddContatto(MouseEvent event) {
        if (addingNewContact) {
            Contatto newContact = new Contatto("nome", "cognome");
            newContact.setNome(nome.getText());
            newContact.setCognome(cognome.getText());
            if (!numero1.getText().isEmpty())
                if(!PHONE_PATTERN.matcher(numero1.getText()).matches()){
            mostraErrore("Errore nel formato del numero di telefono", "Inserisci un numero valido");
            }else newContact.getNumeri().add(numero1.getText());
            if (!numero2.getText().isEmpty())
                 if(!PHONE_PATTERN.matcher(numero2.getText()).matches()){
            mostraErrore("Errore nel formato del numero di telefono", "Inserisci un numero valido");
            }else newContact.getNumeri().add(numero2.getText());
            if (!numero3.getText().isEmpty())
                 if(!PHONE_PATTERN.matcher(numero3.getText()).matches()){
            mostraErrore("Errore nel formato del numero di telefono", "Inserisci un numero valido");
            }else newContact.getNumeri().add(numero3.getText());
            if (!email1.getText().isEmpty())
                if(!EMAIL_PATTERN.matcher(email1.getText()).matches()){
            mostraErrore("Errore nel formato dell'email", "Inserisci un email valida");
            }else newContact.getEmail().add(email1.getText());
            if (!email2.getText().isEmpty())
                 if(!EMAIL_PATTERN.matcher(email2.getText()).matches()){
            mostraErrore("Errore nel formato dell'email", "Inserisci un email valida");
            }else newContact.getEmail().add(email2.getText());
            if (!email3.getText().isEmpty())
                 if(!EMAIL_PATTERN.matcher(email3.getText()).matches()){
            mostraErrore("Errore nel formato dell'email", "Inserisci un email valida");
            }else newContact.getEmail().add(email3.getText());

            r.aggiungiContatto(newContact);
            listaContatti.getItems().add(newContact);
            addingNewContact = false;
        }
    }


    private void onRemoveNumero1(MouseEvent event) {
    Contatto selectedContact = listaContatti.getSelectionModel().getSelectedItem();
    if (selectedContact != null && !numero1.getText().isEmpty()) {
        selectedContact.rimuoviNumero(numero1.getText());
        numero1.clear();
        listaContatti.refresh();
    }
    }

    private void onRemoveEmail1(MouseEvent event) {
         Contatto selectedContact = listaContatti.getSelectionModel().getSelectedItem();
    if (selectedContact != null && !email1.getText().isEmpty()) {
        selectedContact.rimuoviEmail(email1.getText());
        email1.clear();
        listaContatti.refresh();
    }
    }

    private void onRemoveContatto(MouseEvent event) {
             Contatto selectedContact = listaContatti.getSelectionModel().getSelectedItem();
        if (selectedContact != null) {
            if (mostraConferma("Conferma Eliminazione", "Sei sicuro di voler eliminare questo contatto?")) {
                r.eliminaContatto(selectedContact);
                listaContatti.getItems().remove(selectedContact);
                toggleContactFields(false);

                // Svuota i campi
                nome.clear();
                cognome.clear();
                numero1.clear();
                numero2.clear();
                numero3.clear();
                email1.clear();
                email2.clear();
                email3.clear();
            }
        }
    }

    private void onRemoveNumero2(MouseEvent event) {
        Contatto selectedContact = listaContatti.getSelectionModel().getSelectedItem();
    if (selectedContact != null && !numero2.getText().isEmpty()) {
        selectedContact.rimuoviNumero(numero2.getText());
        numero2.clear();
        listaContatti.refresh();
    }
    }

    private void onRemoveNumero3(MouseEvent event) {
        Contatto selectedContact = listaContatti.getSelectionModel().getSelectedItem();
    if (selectedContact != null && !numero3.getText().isEmpty()) {
        selectedContact.rimuoviNumero(numero3.getText());
        numero3.clear();
        listaContatti.refresh();
    }
    }

    private void onRemoveEmail3(MouseEvent event) {
         Contatto selectedContact = listaContatti.getSelectionModel().getSelectedItem();
    if (selectedContact != null && !email3.getText().isEmpty()) {
        selectedContact.rimuoviEmail(email3.getText());
        email3.clear();
        listaContatti.refresh();
    }
    }

    private void onRemoveEmail2(MouseEvent event) {
         Contatto selectedContact = listaContatti.getSelectionModel().getSelectedItem();
    if (selectedContact != null && !email2.getText().isEmpty()) {
        selectedContact.rimuoviEmail(email2.getText());
        email2.clear();
        listaContatti.refresh();
    }
    }

    private void onAddNumero1(MouseEvent event) {
         Contatto selectedContact = listaContatti.getSelectionModel().getSelectedItem();
    if (selectedContact != null && !numero1.getText().isEmpty()) {
        if(!PHONE_PATTERN.matcher(numero1.getText()).matches()){
            mostraErrore("Errore nel formato del numero di telefono", "Inserisci un numero valido");
        }else{
        selectedContact.aggiungiNumero(numero1.getText());
        numero1.clear();
        listaContatti.refresh();
        }
    }
    }

    private void onAddNumero2(MouseEvent event) {
         Contatto selectedContact = listaContatti.getSelectionModel().getSelectedItem();
    if (selectedContact != null && !numero2.getText().isEmpty()) {
        if(!PHONE_PATTERN.matcher(numero2.getText()).matches()){
            mostraErrore("Errore nel formato del numero di telefono", "Inserisci un numero valido");
        }else{
        selectedContact.aggiungiNumero(numero2.getText());
        numero2.clear();
        listaContatti.refresh();
        }
    }
    }

    private void onAddEmail2(MouseEvent event) {
          Contatto selectedContact = listaContatti.getSelectionModel().getSelectedItem();
    if (selectedContact != null && !email2.getText().isEmpty()) {
        if(!EMAIL_PATTERN.matcher(email2.getText()).matches()){
            mostraErrore("Errore nel formato dell'email", "Inserisci un email valida");
        }else{
        selectedContact.aggiungiEmail(email2.getText());
        email2.clear();
        listaContatti.refresh();
        }
    }
    }

    private void onAddEmail3(MouseEvent event) {
          Contatto selectedContact = listaContatti.getSelectionModel().getSelectedItem();
    if (selectedContact != null && !email3.getText().isEmpty()) {
        if(!EMAIL_PATTERN.matcher(email3.getText()).matches()){
            mostraErrore("Errore nel formato dell'email", "Inserisci un email valida");
        }else{
        selectedContact.aggiungiEmail(email3.getText());
        email3.clear();
        listaContatti.refresh();
        }
    }
    }

    private void onAddNumero3(MouseEvent event) {
         Contatto selectedContact = listaContatti.getSelectionModel().getSelectedItem();
    if (selectedContact != null && !numero3.getText().isEmpty()) {
        if(!PHONE_PATTERN.matcher(numero3.getText()).matches()){
            mostraErrore("Errore nel formato del numero di telefono", "Inserisci un numero valido");
        }else{
        selectedContact.aggiungiNumero(numero3.getText());
        numero3.clear();
        listaContatti.refresh();
        }
    }
    }

    private void onAddEmail1(MouseEvent event) {
          Contatto selectedContact = listaContatti.getSelectionModel().getSelectedItem();
    if (selectedContact != null && !email1.getText().isEmpty()) {
        if(!EMAIL_PATTERN.matcher(email1.getText()).matches()){
            mostraErrore("Errore nel formato dell'email", "Inserisci un email valida");
        }else{
        selectedContact.aggiungiEmail(email1.getText());
        email1.clear();
        listaContatti.refresh();
        }
    }
    }

    private void onModificaContatto(MouseEvent event) {
         toggleModificationFields(true);
    }
    
      // Metodo per mostrare messaggi di errore
    private void mostraErrore(String titolo, String messaggio) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titolo);
        alert.setHeaderText(null);
        alert.setContentText(messaggio);
        alert.showAndWait();
    }

    // Metodo per mostrare messaggi di conferma
    private boolean mostraConferma(String titolo, String messaggio) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(titolo);
        alert.setHeaderText(null);
        alert.setContentText(messaggio);
        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == ButtonType.OK;
    }

   /* private void onSaveContatto(MouseEvent event) {
        Contatto selectedContact = listaContatti.getSelectionModel().getSelectedItem();
        if (selectedContact == null) {
            mostraErrore("Errore", "Seleziona un contatto da salvare");
            return;
        }

        try {
            // Mostra dialogo di conferma
            if (mostraConferma("Salvataggio Contatto", "Vuoi salvare questo contatto su file?")) {
                // Utilizzo del metodo salvaSuFile del FileManager
                fm.salvaSuFile(CONTATTI_FILE, selectedContact);
                mostraConfermaInfo("Salvataggio Riuscito", "Contatto salvato correttamente su file");
            }
        } catch (Exception e) {
            mostraErrore("Errore di Salvataggio", "Impossibile salvare il contatto: " + e.getMessage());
        }
    } */
    
    private void mostraConfermaInfo(String titolo, String messaggio){
        
        Alert alert=new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titolo);
        alert.setHeaderText(null);
        alert.setContentText(messaggio);
        alert.showAndWait();
        
    }
}
