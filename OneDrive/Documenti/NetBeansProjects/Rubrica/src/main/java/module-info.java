module com.mycompany.rubrica {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.rubrica to javafx.fxml;
    exports com.mycompany.rubrica;
}
