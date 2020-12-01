package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.swing.*;
import java.io.IOException;

public class Controller extends Main{



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
    enum ANIMATION{
        SELECTION,
        BUBBLE,
        INSERTION,
        TREE,
        TABLE,
    }
    enum MENU
    {
        SORT,
        ANIMATION,
    }


    public SplitPane horizontalSplit;
    public AnchorPane topHalf;
    public MenuButton dataType;
    public MenuItem doubleData;
    public MenuItem floatData;
    public MenuItem integerData;
    public AnchorPane bottomHalf;
    public SplitPane verticalSplit;
    public AnchorPane leftHalf;
    public MenuButton comp;
    public MenuItem selComp;
    public MenuItem insComp;
    public MenuItem bubComp;
    public MenuItem tabComp;
    public MenuItem treeComp;
    public AnchorPane rightHalf;
    public MenuButton anim;
    public MenuItem selAnim;
    public MenuItem insAnim;
    public MenuItem bubAnim;
    public MenuItem tabAnim;
    public MenuItem treeAnim;
    public Label instructions;


    SORT typeOfSort;
    TYPE typeOfPrimitive;

    public void doubleTypeClicked(ActionEvent actionEvent) {
        typeOfPrimitive = TYPE.DOUBLE;
    }

    public void floatTypeClicked(ActionEvent actionEvent) {
        typeOfPrimitive = TYPE.FLOAT;
    }

    public void integerTypeClicked(ActionEvent actionEvent) {
        typeOfPrimitive = TYPE.INT;
    }

    public void selectionSortClicked(ActionEvent actionEvent) throws IOException {
        typeOfSort = SORT.SELECTION;
        if(typeOfPrimitive != null)
        {
            loadInputWindow(actionEvent);
        }
    }

    public void insertionSortClicked(ActionEvent actionEvent) throws IOException {
        typeOfSort = SORT.INSERTION;
        if(typeOfPrimitive != null)
        {
            loadInputWindow(actionEvent);
        }
    }

    public void bubbleSortClicked(ActionEvent actionEvent) throws IOException {
        typeOfSort = SORT.BUBBLE;
        if(typeOfPrimitive != null)
        {
            loadInputWindow(actionEvent);
        }
    }

    public void selectionSortAnimationClicked(ActionEvent actionEvent) throws IOException {
        ANIMATION typeOfAnimation = ANIMATION.SELECTION;
        MENU menu = MENU.ANIMATION;
        loadAnimation(menu, actionEvent, typeOfAnimation);
    }

    public void insertionSortAnimationClicked(ActionEvent actionEvent) throws IOException {
        ANIMATION typeOfAnimation = ANIMATION.INSERTION;
        MENU menu = MENU.ANIMATION;
        loadAnimation(menu, actionEvent, typeOfAnimation);
    }

    public void bubbleSortAnimationClicked(ActionEvent actionEvent) throws IOException {
        ANIMATION typeOfAnimation = ANIMATION.BUBBLE;
        MENU menu = MENU.ANIMATION;
        loadAnimation(menu, actionEvent, typeOfAnimation);
    }

    public void hashTableAnimationClicked(ActionEvent actionEvent) throws IOException {
        ANIMATION typeOfAnimation = ANIMATION.TABLE;
        MENU menu = MENU.ANIMATION;
        loadAnimation(menu, actionEvent, typeOfAnimation);
    }

    public void treeAnimationClicked(ActionEvent actionEvent) throws IOException {
        ANIMATION typeOfAnimation = ANIMATION.TREE;
        MENU menu = MENU.ANIMATION;
        loadAnimation(menu, actionEvent, typeOfAnimation);
    }
    private void loadAnimation(MENU menuItem, ActionEvent actionEvent, ANIMATION animationType) throws IOException {
        // This line gets the Stage information
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("ExecutionWindow.fxml"));
        // Access the controller and call a method
        Parent root = (Parent) loader.load();
        ExecutionWindowController controller = loader.getController();
        Stage stage = (Stage) anim.getScene().getWindow();
        if(menuItem == MENU.ANIMATION)
        {
            controller.loadAnimationWindow(anim, actionEvent, animationType, stage);
        }
        if(menuItem == MENU.SORT)
        {
            controller.loadAnimationWindow(comp, actionEvent, animationType, stage);
        }

    }
    private void loadInputWindow(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("InputNumber.fxml"));
        Stage stage1 = new Stage(StageStyle.DECORATED);
        stage1.setScene(new Scene(loader.load()));
        InputNumber controller = loader.getController();
        controller.setTypes(typeOfSort, typeOfPrimitive);
        stage1.show();
    }
}