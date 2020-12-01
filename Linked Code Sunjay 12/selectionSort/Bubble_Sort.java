package sample.selectionSort;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.util.Duration;

import java.util.Hashtable;
import java.util.concurrent.atomic.AtomicBoolean;

public class Bubble_Sort extends Application {

    //this is the code for BUBBLE SORT.
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //create the variables and data frist, then add it to the children of a group, then add the group to a scene.

        //map of: index (key) and numbers passed in (value)?
        //  test out with ints first
        //make a sorted AND unsorted array
        //sort it quickest way i can in code, then SHOW the animation of how it's being sorted (at least for selection sort)
        //sample array and sample animation

        //Hashtable<Integer, Integer> unsortedNums = new Hashtable<>();
        int[] unsortedNums = new int[5];
        unsortedNums[0] = 4;
        unsortedNums[1] = 2;
        unsortedNums[2] = 5;
        unsortedNums[3] = 1;
        unsortedNums[4] = 3;
        int[] sortedNums = new int[5];
        for (int a = 0; a < 5; a++) {
            sortedNums[a] = a + 1;
        }
        int numbersSorted = 0;
        double xParam;
        double yParam;
        Group root = new Group();
        Group recGroup = new Group();
        ParallelTransition group1 = new ParallelTransition();
        ParallelTransition group2 = new ParallelTransition();
        ParallelTransition group3 = new ParallelTransition();
        ParallelTransition group4 = new ParallelTransition();
        ParallelTransition group5 = new ParallelTransition();
        ParallelTransition group6 = new ParallelTransition();
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

        SequentialTransition seqTransBubble = new SequentialTransition(recGroup);

        Label start = new Label("Starting Bubble Sort");
        start.setLayoutX(775);
        start.setLayoutY(200);

        Label end = new Label("End of Bubble Sort");
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
        CreateBubblePath(arrRecs[0], xLocations[1], arrRecs[0], group1);
        CreateBubblePath(arrRecs[1], xLocations[0], arrRecs[1], group1);
//part 2
        CreateBubblePath(arrRecs[2], xLocations[3], arrRecs[2], group2);
        CreateBubblePath(arrRecs[3], xLocations[2], arrRecs[3], group2);
//part 3
        CreateBubblePath(arrRecs[3], xLocations[4], arrRecs[2], group3);
        CreateBubblePath(arrRecs[4], xLocations[3], arrRecs[4], group3);
//part 4
        CreateBubblePath(arrRecs[1], xLocations[2], arrRecs[0], group4);
        CreateBubblePath(arrRecs[2], xLocations[1], arrRecs[3], group4);
//part 5
        CreateBubblePath(arrRecs[2], xLocations[3], arrRecs[0], group5);
        CreateBubblePath(arrRecs[3], xLocations[2], arrRecs[4], group5);
//part 6
        CreateBubblePath(arrRecs[0], xLocations[1], arrRecs[1], group6);
        CreateBubblePath(arrRecs[1], xLocations[0], arrRecs[3], group6);

        seqTransBubble.getChildren().addAll(startFade, group1, group2, group3, group4, group5, group6, endFade);
        seqTransBubble.setCycleCount(Timeline.INDEFINITE);
        seqTransBubble.play();

//        for (int buttonCreator = 0; buttonCreator < 5; buttonCreator++) {
//            String name = "Button " + (buttonCreator + 1);
//            Button buttonA = new Button(name);
//            root.getChildren().add(buttonA);
//            int finalButtonCreator = buttonCreator;
//            buttonA.setLayoutX(arrRecs[finalButtonCreator].getBoundsInLocal().getMinX());
//            //buttonA.setLayoutY(arrRecs[finalButtonCreator].getLayoutY());
//            buttonA.setLayoutY(arrRecs[finalButtonCreator].getBoundsInLocal().getMinY() + 125);
//            buttonA.setOnAction(e -> ObjectMove(arrRecs[finalButtonCreator], xLocations[numbersSorted]));
//        }

        //final steps
        root.getChildren().addAll(primaryVbox, recGroup);
        Scene firstSort = new Scene(root, 1700, 850);
        primaryStage.setTitle("Box Mover Title");
        primaryStage.setScene(firstSort);
        primaryStage.show();
    }

    public static void ObjectMove(Rectangle rectangle, Double newXPos) {  //
        double xParam = (rectangle.getBoundsInLocal().getMinX() + rectangle.getBoundsInLocal().getMaxX()) / 2.0;
        double yParam = (rectangle.getBoundsInLocal().getMinY() + rectangle.getBoundsInLocal().getMaxY()) / 2.0;
        Path path = new Path();
        path.getElements().add(new MoveTo(xParam, yParam));//standard input? has to be included. (throws object to the middle of it)
        path.getElements().add(new VLineTo(rectangle.getY() - 100));
        path.getElements().add(new HLineTo(newXPos));   //the center of the square goes here
        path.getElements().add(new VLineTo(yParam));

        PathTransition transition1 = new PathTransition();
        transition1.setNode(rectangle);
        transition1.setDuration(Duration.seconds(1));
        transition1.setPath(path);
        transition1.setCycleCount(1);
        transition1.play();
    }

    public static void CreateBubblePath(Rectangle rectangleStart, Double xLocation, Rectangle rectangleNode, ParallelTransition groupNum) {
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
/*
VLineTo(int) can help with pathing to various spots, determined by window size and if another element is at the preceding point
transition1.setOnFinished(e -> System.out.println("Transition is over"));
        SortedSet<Pair<Double, Double>> sortedCoords = new TreeSet<>();
        for (int pairIter = 0; pairIter < 5; pairIter++) {   //create rectangles spaced out evenly
            double xParamPair = (arrRecs[pairIter].getBoundsInLocal().getMinX() + arrRecs[pairIter].getBoundsInLocal().getMaxX()) / 2.0;
            double yParamPair = (arrRecs[pairIter].getBoundsInLocal().getMinY() + arrRecs[pairIter].getBoundsInLocal().getMaxY()) / 2.0;
            Pair<Double, Double> pair = new Pair<>(xParamPair,yParamPair);
            sortedCoords.add(pair);
        }
     System.out.println(arrRecs[0].getBoundsInLocal().getMinX());
 */
