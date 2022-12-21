package com.example.word__dictionary;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class DictionaryPageController {
    private DictionarySaver db;
    @FXML
    TextField search,newword,meaning,findWord;
    @FXML
    public void SearchButton(MouseEvent event) throws IOException, ClassNotFoundException {
        db = new DictionarySaver();
        db.deserializeHashMap();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Dictionary");
        if(search.getText().equals("")){
            alert.setContentText("Please enter a word to search");
            alert.showAndWait();
        }

       else if(db.getDictionaryList().containsKey(search.getText().toLowerCase()))
        {
            alert.setContentText("This word is available in the Dictionary");
            alert.showAndWait();
        }
        else
        {
            alert.setContentText("New word is not available in the Dictionary");
            alert.showAndWait();
        }

    }

    @FXML
    public void add(MouseEvent event) throws IOException, ClassNotFoundException {
        db = new DictionarySaver();
        db.deserializeHashMap();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Dictionary");
        if(newword.getText().equals("") || meaning.getText().equals("")){
            alert.setContentText("Please enter word/meaning to add in the Dictionary");
            alert.showAndWait();
        }
        else if(db.getDictionaryList().containsKey(newword.getText().toLowerCase())){
            alert.setContentText("The word is already present in the Dictionary");
            alert.showAndWait();
        }
        else {
            db.getDictionaryList().put(newword.getText().toLowerCase(), meaning.getText());
            db.serializeHashMap();
            alert.setContentText("New word is added to the Dictionary");
            alert.showAndWait();
        }
    }

    @FXML
    public void meaning(MouseEvent event) throws IOException, ClassNotFoundException {
        db = new DictionarySaver();
        db.deserializeHashMap();

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("Meaning");
        if(findWord.getText().equals("")){
            alert.setContentText("Please enter a word to find meaning from the Dictionary");
            alert.showAndWait();
        }

        else if(db.getDictionaryList().containsKey(findWord.getText().toLowerCase())){
            alert.setContentText(db.getDictionaryList().get(findWord.getText().toLowerCase()));
            alert.showAndWait();
        }
        else{
            alert.setContentText("The word is not available in the Dictionary");
            alert.showAndWait();
        }
    }
}
