package sample;

import javafx.scene.control.TextField;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class InputNumber {




    enum SORT{
        SELECTION,
        BUBBLE,
        INSERTION,
    }
    enum TYPE{
        INT,
        FLOAT,
        DOUBLE,
    }

    SORT typeOfSort;
    TYPE typeOfPrimitive;

    public Button nextButton;
    public TextField userNumberInput;
    public Button SelectionSortButton;
    public Button InsertionSort;
    public Button BubbleSortButton;
    public Button intButton;
    public Button DoubleButton;
    public Button floatButton;
     /*
    Handling changing of scene
     */

    public void changeToSelectionSort(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("SelectionSort.fxml"));
        Parent parent = loader.load();

        Scene newScene = new Scene(parent);

        // Access the controller and call a method
        NewTest controller = loader.getController();
        controller.initData(userNumberInput, typeOfSort, typeOfPrimitive);

        // This line gets the Stage information
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(newScene);
        window.show();
    }
     /*
    Handling changing of scene, pass the userNumberInput to the Selection Sort .fxml
     */

    public void changeToSelectionSortWithInput(ActionEvent event) throws IOException {


    }
    public void selectionSortButtonClicked(ActionEvent actionEvent) {
        typeOfSort = SORT.SELECTION;
    }

    public void insertionButtonClicked(ActionEvent actionEvent) {
        typeOfSort = SORT.INSERTION;
    }

    public void bubbleSortClicked(ActionEvent actionEvent) {
        typeOfSort = SORT.BUBBLE;
    }

    public void intButtonClicked(ActionEvent actionEvent) {
        typeOfPrimitive = TYPE.INT;
    }

    public void doubleButtonClicked(ActionEvent actionEvent) {
        typeOfPrimitive = TYPE.DOUBLE;
    }
    public void floatButtonClicked(ActionEvent actionEvent) {
        typeOfPrimitive = TYPE.FLOAT;
    }

    public void obtainUserInput()
    {

        System.out.println(userNumberInput.getText());
        System.out.println("Log In Clicked");
    }
    private boolean isInt(TextField userNumberInput, String message)
    {
        try{
            int value = Integer.parseInt(userNumberInput.getText());
            return true;
        }catch (NumberFormatException e){
            System.out.println("Error, please put in a valid number");
            return false;
        }
    }
}
