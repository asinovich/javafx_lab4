package org.example;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.example.sourceClass.MainStream;


public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField aX;

    @FXML
    private TextField aY;

    @FXML
    private TextField aZ;

    @FXML
    private TextField bX;

    @FXML
    private TextField bY;

    @FXML
    private TextField bZ;

    @FXML
    private Label result;


    @FXML
    void buttonCalculate(ActionEvent event) throws InterruptedException {

        if(checkingEnteredValues()){
            ArrayList<Integer> vectorA = new ArrayList<Integer>();
            ArrayList<Integer> vectorB = new ArrayList<Integer>();

            vectorA.add(Integer.parseInt(aX.getText()));
            vectorA.add(Integer.parseInt(aY.getText()));
            vectorA.add(Integer.parseInt(aZ.getText()));

            vectorB.add(Integer.parseInt(bX.getText()));
            vectorB.add(Integer.parseInt(bY.getText()));
            vectorB.add(Integer.parseInt(bZ.getText()));

            MainStream ms = new MainStream(vectorA, vectorB);
            ms.calculateValue();
            result.setText(Integer.toString(ms.getResult()));
        }
        else{
            errorMessageBox("Введите значения (числа) в вектора");
        }
    }

    @FXML
    void initialize() { }


    void errorMessageBox(String message) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Ошибка");
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();

    }

    boolean checkingEnteredValues (){

        try {
            Integer.parseInt(aX.getText());
            Integer.parseInt(aY.getText());
            Integer.parseInt(aZ.getText());
            Integer.parseInt(bX.getText());
            Integer.parseInt(bY.getText());
            Integer.parseInt(bZ.getText());
        }
        catch (Exception e){
            return false;
        }
        return true;
    }
}
