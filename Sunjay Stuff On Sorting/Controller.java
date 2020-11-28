package sample;

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

public class Controller {
    /*
    Handling changing of scene
     */

    public void changeScreenButtonPushed(ActionEvent event) throws IOException {

        Parent newSceneParetn = FXMLLoader.load(getClass().getResource("SelectionSort.fxml"));
        Scene newScene = new Scene(newSceneParetn);

        // This line gets the Stage information
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();

        window.setScene(newScene);
        window.show();
    }
    public void animationButtonClicked()
    {
        System.out.println("Log In Clicked");
    }
}
