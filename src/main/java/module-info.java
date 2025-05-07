module inclass2week2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    opens org.example.inclass2week2 to javafx.fxml;
    exports org.example.inclass2week2;
}