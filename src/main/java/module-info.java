module com.firstapplication.javaapplicationfinal {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.firstapplication.javaapplicationfinal to javafx.fxml;
    exports com.firstapplication.javaapplicationfinal;
}