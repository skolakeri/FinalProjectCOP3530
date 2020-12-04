package sample.selectionSort;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.util.Duration;

import java.util.Hashtable;
import java.util.concurrent.atomic.AtomicBoolean;

public class Insertion_Sort extends Application {

    //this is the code for INSERTION SORT.
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //create the variables and data frist, then add it to the children of a group, then add the group to a scene.

        int[] unsortedNums = new int[5];
        unsortedNums[0] = 5;
        unsortedNums[1] = 3;
        unsortedNums[2] = 2;
        unsortedNums[3] = 1;
        unsortedNums[4] = 4;
        int[] sortedNums = new int[5];
        for (int a = 0; a < 5; a++) {
            sortedNums[a] = a + 1;
        }

        Group root = new Group();
        Group recGroup = new Group();
        ParallelTransition group1 = new ParallelTransition();
        ParallelTransition group2 = new ParallelTransition();
        ParallelTransition group3 = new ParallelTransition();
        VBox primaryVbox = new VBox(10);

        Rectangle[] arrRecs = new Rectangle[5];
        Double[] xLocations = new Double[arrRecs.length];
        for (int i = 0; i < arrRecs.length; i++) {   //create rectangles spaced out evenly
            Rectangle r = new Rectangle();
            double xPos = (i * 1700.0) / 5.0 + 100;
            r.setX(xPos);
            r.setY(450);
            r.setWidth(100);
            r.setHeight(100);
            //r.setFill(Color.color(Math.random(), Math.random(), Math.random()));
            r.setFill(Color.color(0.2*i, 0.2*i, 0.2*i));
            recGroup.getChildren().add(r);
            arrRecs[i] = r;
            xLocations[i] = xPos + (r.getWidth() / 2.0);
        }

        arrRecs[0].setFill(Color.RED);
        arrRecs[1].setFill(Color.ORANGE);
        arrRecs[2].setFill(Color.YELLOW);
        arrRecs[3].setFill(Color.GREEN);
        arrRecs[4].setFill(Color.BLUE); //3 1 4 0 2

        Label desc = new Label("Values\nRed: 4\nOrange: 2\nYellow: 5\nGreen: 1\nBlue: 3");
        desc.setLayoutX(100);
        desc.setLayoutY(80);
        desc.setFont(new Font(24.0));
        root.getChildren().add(desc);

        SequentialTransition seqTransBubble = new SequentialTransition(recGroup);

        Label start = new Label("Starting Insertion Sort");
        start.setLayoutX(775);
        start.setLayoutY(200);

        Label end = new Label("End of Insertion Sort");
        end.setLayoutX(775);
        end.setLayoutY(250);
        root.getChildren().addAll(start, end);
//fade-in/out "Start"
        FadeTransition startFade = new FadeTransition(Duration.seconds(3), start);
        startFade.setFromValue(1);
        startFade.setToValue(0);
        startFade.setCycleCount(1);
        startFade.setAutoReverse(true);
//fade-in/out "End"
        FadeTransition endFade = new FadeTransition(Duration.seconds(2), end);
        endFade.setFromValue(0);
        endFade.setToValue(1);
        endFade.setCycleCount(1);
        endFade.setAutoReverse(true);

//part 1
        CreateInsertionPath(arrRecs[1], xLocations[0], arrRecs[1], group1);
        ShiftOverOne(arrRecs[0], xLocations[1], arrRecs[0], group1);
//part 2
        CreateInsertionPath(arrRecs[3], xLocations[0], arrRecs[3], group2);
        ShiftOverOne(arrRecs[2], xLocations[3], arrRecs[2], group2);
        ShiftOverOne(arrRecs[1], xLocations[2], arrRecs[0], group2);
        ShiftOverOne(arrRecs[0], xLocations[1], arrRecs[1], group2);
//part 3
        CreateInsertionPath(arrRecs[4], xLocations[2], arrRecs[4], group3);
        ShiftOverOne(arrRecs[3], xLocations[4], arrRecs[2], group3);
        ShiftOverOne(arrRecs[2], xLocations[3], arrRecs[0], group3);

        seqTransBubble.getChildren().addAll(startFade, group1, group2, group3, endFade);
        seqTransBubble.setCycleCount(Timeline.INDEFINITE);
        seqTransBubble.play();
//final steps
        root.getChildren().addAll(primaryVbox, recGroup);
        Scene firstSort = new Scene(root, 1700, 850);
        primaryStage.setTitle("Box Mover Title");
        primaryStage.setScene(firstSort);
        primaryStage.show();
    }

    public static void CreateInsertionPath(Rectangle rectangleStart, Double xLocation, Rectangle rectangleNode, ParallelTransition groupNum) {
        double xParamPath = (rectangleStart.getBoundsInLocal().getMinX() + rectangleStart.getBoundsInLocal().getMaxX()) / 2.0;
        double yParamPath = (rectangleStart.getBoundsInLocal().getMinY() + rectangleStart.getBoundsInLocal().getMaxY()) / 2.0;
        Path createdPath = new Path();
        createdPath.getElements().add(new MoveTo(xParamPath, yParamPath));//standard input? has to be included. (throws object to the middle of it)
        createdPath.getElements().add(new VLineTo(rectangleStart.getBoundsInLocal().getMinY()-rectangleStart.getBoundsInLocal().getHeight()));
        createdPath.getElements().add(new HLineTo(xLocation));   //the center of the square goes here
        createdPath.getElements().add(new VLineTo(yParamPath));
        PathTransition createdTransition = new PathTransition();
        createdTransition.setNode(rectangleNode);           //this is not arrRecs[2], it is arrRecs[0] since 0 rectangle is now at position 2.
        createdTransition.setDuration(Duration.seconds(2));
        createdTransition.setPath(createdPath);
        createdTransition.setCycleCount(1);
        groupNum.getChildren().add(createdTransition);
    }

    public static void ShiftOverOne(Rectangle rectangleStart, Double xLocation, Rectangle rectangleNode, ParallelTransition groupNum) {
        double xParamPath = (rectangleStart.getBoundsInLocal().getMinX() + rectangleStart.getBoundsInLocal().getMaxX()) / 2.0;
        double yParamPath = (rectangleStart.getBoundsInLocal().getMinY() + rectangleStart.getBoundsInLocal().getMaxY()) / 2.0;
        Path createdPath = new Path();
        createdPath.getElements().add(new MoveTo(xParamPath, yParamPath));//standard input? has to be included. (throws object to the middle of it)
        createdPath.getElements().add(new HLineTo(xLocation));   //the center of the square goes here
        PathTransition createdTransition = new PathTransition();
        createdTransition.setNode(rectangleNode);           //this is not arrRecs[2], it is arrRecs[0] since 0 rectangle is now at position 2.
        createdTransition.setDuration(Duration.seconds(2));
        createdTransition.setPath(createdPath);
        createdTransition.setCycleCount(1);
        groupNum.getChildren().add(createdTransition);

    }

}