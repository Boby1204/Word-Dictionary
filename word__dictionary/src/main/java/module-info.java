module com.example.word__dictionary {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.word__dictionary to javafx.fxml;
    exports com.example.word__dictionary;
}