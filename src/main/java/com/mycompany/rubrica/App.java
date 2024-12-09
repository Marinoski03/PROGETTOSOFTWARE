package com.mycompany.rubrica;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * La classe {@code App} estende { @link javafx.application.Application } e rappresenta l'applicazione JavaFX.
 * Gestisce la creazione della finestra principale dell'applicazione e il caricamento
 * delle scene tramite il framework FXML.
 */
public class App extends Application {

    private static Scene scene; //La scena principale dell'applicazione
    
     /**
     * Metodo principale di avvio dell'applicazione.
     * 
     * @param stage il palcoscenico principale dell'applicazione
     * @throws IOException se si verifica un errore durante il caricamento del file FXML
     */

    @Override
    public void start(Stage stage) throws IOException { 
        scene = new Scene(loadFXML("/fxml/RubricaView"), 640, 480); // Crea una scena a partire dal file FXML "primary.fxml"
        stage.setScene(scene); // Imposta la scena sullo stage
        stage.show(); // Mostra la finestra
    }

    /**
     * Imposta una nuova scena sull'applicazione cambiando la radice della scena.
     * 
     * @param fxml il nome del file FXML da caricare come nuova radice della scena
     * @throws IOException se si verifica un errore durante il caricamento del file FXML
     */
    
    static void setRoot(String fxml) throws IOException {  
        scene.setRoot(loadFXML(fxml)); // Cambia la radice della scena corrente con una nuova scena caricata dal file FXML
    }
    
    /**
     * Carica un file FXML e restituisce il relativo nodo radice.
     * 
     * @param fxml il nome del file FXML da caricare
     * @return il nodo radice della scena caricato dal file FXML
     * @throws IOException se si verifica un errore durante il caricamento del file FXML
     */
    
    private static Parent loadFXML(String fxml) throws IOException { 
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));  // Crea un oggetto FXMLLoader per caricare il file FXML
        return fxmlLoader.load(); // Carica e restituisce il nodo radice dal file FXML
    }

     /**
     * Il metodo principale che avvia l'applicazione JavaFX.
     * 
     * @param args gli argomenti della riga di comando
     */
    
    public static void main(String[] args) {
        launch(); //Avvia l'applicazione Javafx
    }

}