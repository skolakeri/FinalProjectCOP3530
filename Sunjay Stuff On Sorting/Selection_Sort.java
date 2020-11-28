package sample;
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

public class Selection_Sort extends Application {

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
        unsortedNums[1] = 3;
        unsortedNums[2] = 5;
        unsortedNums[3] = 2;
        unsortedNums[4] = 1;
        int[] sortedNums = new int[5];
        for (int a = 0; a < 5; a++) {
            sortedNums[a] = a+1;
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
        SequentialTransition seqTranSelection = new SequentialTransition(recGroup);
        VBox primaryVbox = new VBox(10);

        Rectangle[] arrRecs = new Rectangle[5];
        Double[] xLocations = new Double[arrRecs.length];
        for (int i = 0; i < arrRecs.length; i++) {   //create rectangles spaced out evenly
            Rectangle r = new Rectangle();
            double xPos = (i*1700.0)/5.0 + 100;
            r.setX(xPos);
            r.setY(450);
            r.setWidth(100);
            r.setHeight(100);
            r.setFill(Color.color(Math.random(), Math.random(), Math.random()));
            //r.setFill(Color.color(0.2*i, 0.2*i, 0.2*i));
            recGroup.getChildren().add(r);
            arrRecs[i] = r;
            xLocations[i] = xPos+ (r.getWidth()/2.0);
        }
        Label start = new Label("Starting Selection Sort");
        start.setLayoutX(775);
        start.setLayoutY(200);

        Label end = new Label("End of Selection Sort");
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
        CreateSelectionPath(arrRecs[0], xLocations[4], arrRecs[0], group1);
        CreateSelectionPath(arrRecs[4], xLocations[0], arrRecs[4], group1);
//part 2
        CreateSelectionPath(arrRecs[1], xLocations[3], arrRecs[1], group2);
        CreateSelectionPath(arrRecs[3], xLocations[1], arrRecs[3], group2);
//part 3
        CreateSelectionPath(arrRecs[2], xLocations[3], arrRecs[2], group3);
        CreateSelectionPath(arrRecs[3], xLocations[2], arrRecs[1], group3);
//part 4
        CreateSelectionPath(arrRecs[3], xLocations[4], arrRecs[2], group4);
        CreateSelectionPath(arrRecs[4], xLocations[3], arrRecs[0], group4);

        seqTranSelection.getChildren().addAll(startFade, group1, group2, group3, group4, endFade);
        seqTranSelection.setCycleCount(Timeline.INDEFINITE);
        seqTranSelection.play();

        //final steps
        root.getChildren().addAll(primaryVbox, recGroup);
        Scene firstSort = new Scene(root, 1700, 850);
        primaryStage.setTitle("Box Mover Title");
        primaryStage.setScene(firstSort);
        primaryStage.show();
    }

    public static void CreateSelectionPath (Rectangle rectangleStart, Double xLocation, Rectangle rectangleNode, ParallelTransition groupNum) {
        double xParamSelPath = (rectangleStart.getBoundsInLocal().getMinX() + rectangleStart.getBoundsInLocal().getMaxX()) / 2.0;
        double yParamSelPath = (rectangleStart.getBoundsInLocal().getMinY() + rectangleStart.getBoundsInLocal().getMaxY()) / 2.0;
        Path pathSel = new Path();
        pathSel.getElements().add(new MoveTo(xParamSelPath, yParamSelPath));//standard input? has to be included. (throws object to the middle of it)
        pathSel.getElements().add(new VLineTo(350));
        pathSel.getElements().add(new HLineTo(xLocation));   //the center of the square goes here
        pathSel.getElements().add(new VLineTo(yParamSelPath));
        PathTransition transSel = new PathTransition();
        transSel.setNode(rectangleNode);           //this is not arrRecs[2], it is arrRecs[0] since 0 rectangle is now at position 2.
        transSel.setDuration(Duration.seconds(2));
        transSel.setPath(pathSel);
        transSel.setCycleCount(1);
        groupNum.getChildren().add(transSel);
    }

    public static void ObjectMove (Rectangle rectangle, Double newXPos) {  //
        double xParam = (rectangle.getBoundsInLocal().getMinX() + rectangle.getBoundsInLocal().getMaxX()) / 2.0;
        double yParam = (rectangle.getBoundsInLocal().getMinY() + rectangle.getBoundsInLocal().getMaxY()) / 2.0;
        Path path = new Path();
        path.getElements().add(new MoveTo(xParam, yParam));//standard input? has to be included. (throws object to the middle of it)
        path.getElements().add(new VLineTo(rectangle.getY()-100));
        path.getElements().add(new HLineTo(newXPos));   //the center of the square goes here
        path.getElements().add(new VLineTo(yParam));

        PathTransition transition1 = new PathTransition();
        transition1.setNode(rectangle);
        transition1.setDuration(Duration.seconds(1));
        transition1.setPath(path);
        transition1.setCycleCount(1);
        transition1.play();
    }

    public void selectionSort(int arr[], int size) {
        for (int i = 0; i < size - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[min_index])
                    min_index = j;
            }
            int temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
        }
    }
}



//VLineTo(int) can help with pathing to various spots, determined by window size and if another element is at the preceding point
//transition1.setOnFinished(e -> System.out.println("Transition is over"));
/*
        SortedSet<Pair<Double, Double>> sortedCoords = new TreeSet<>();
        for (int pairIter = 0; pairIter < 5; pairIter++) {   //create rectangles spaced out evenly
            double xParamPair = (arrRecs[pairIter].getBoundsInLocal().getMinX() + arrRecs[pairIter].getBoundsInLocal().getMaxX()) / 2.0;
            double yParamPair = (arrRecs[pairIter].getBoundsInLocal().getMinY() + arrRecs[pairIter].getBoundsInLocal().getMaxY()) / 2.0;
            Pair<Double, Double> pair = new Pair<>(xParamPair,yParamPair);
            sortedCoords.add(pair);
        }
*/
//        System.out.println(arrRecs[0].getBoundsInLocal().getMinX());

/*
for (int buttonCreator = 0; buttonCreator < 5; buttonCreator++) {
            String name = "Button " + (buttonCreator+1);
            Button buttonA = new Button(name);
            root.getChildren().add(buttonA);
            int finalButtonCreator = buttonCreator;
            buttonA.setLayoutX(arrRecs[finalButtonCreator].getBoundsInLocal().getMinX());
            //buttonA.setLayoutY(arrRecs[finalButtonCreator].getLayoutY());
            buttonA.setLayoutY(arrRecs[finalButtonCreator].getBoundsInLocal().getMinY() + 125);
            buttonA.setOnAction(e -> ObjectMove(arrRecs[finalButtonCreator], xLocations[numbersSorted]));
        }
 */
