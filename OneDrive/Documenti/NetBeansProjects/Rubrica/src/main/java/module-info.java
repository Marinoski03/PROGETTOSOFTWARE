module com.mycompany.rubrica {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.mycompany.rubrica to javafx.fxml;
    exports com.mycompany.rubrica;
}
