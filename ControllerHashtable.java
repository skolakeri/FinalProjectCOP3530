package sample;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import java.awt.*;

public class ControllerHashtable {
    //DO INSERT, SEARCH, THEN DELETE.  DO NOT DO DELETE BEFORE SEARCH.

    public Rectangle ModelPlaceholder;
    public Circle TravelCircle;
    public javafx.scene.control.Label Label10Mod;
    public javafx.scene.control.Label Label3Mod;
    public javafx.scene.control.Label Label6Mod;
    public javafx.scene.control.Label Label18Mod;
    public javafx.scene.control.Label Label8Mod;
    public javafx.scene.control.Label Label5Mod;
    public javafx.scene.control.Label Label1Mod;
    public Label LabelDelete;
    public Label LabelSearch;
    double sizeOfTopBar = 0;
    public Rectangle Rec1;
    public Rectangle Rec2;
    public Rectangle Rec3;
    public Rectangle Rec4;
    public Rectangle Rec5;
    public Rectangle Rec6;
    public Rectangle Rec7;

    //------------------------------------------------------\\

    public void PlayHashtableSequenceInsert () {
        //values: 1, 5, 8, 18, 6, 3, 10
        int[] recValues = new int[7];
        recValues[0] = 1;
        recValues[1] = 5;
        recValues[2] = 8;
        recValues[3] = 18;
        recValues[4] = 6;
        recValues[5] = 3;
        recValues[6] = 10;
        Double[] xLocations = new Double[10];   //double xPos = (i * 1700.0) / 5.0 + 100;
        for (int j = 0; j < 10; j++) {
            double jDoub = j;
            xLocations[j] = (jDoub * 150.0) + 14.0 + 25.0;
        }

        SequentialTransition hashtableSeqTranInsert = new SequentialTransition();
        FadeTransition showEq1 = new FadeTransition(Duration.seconds(1.5), Label1Mod);
        showEq1.setFromValue(0.0);
        showEq1.setToValue(1.0);
        showEq1.setAutoReverse(true);
        hashtableSeqTranInsert.getChildren().add(showEq1);
        HashTableMoveRect(Rec1, 7.0, hashtableSeqTranInsert);

        FadeTransition showEq5 = new FadeTransition(Duration.seconds(1.5), Label5Mod);
        showEq5.setFromValue(0.0);
        showEq5.setToValue(1.0);
        showEq5.setAutoReverse(true);
        hashtableSeqTranInsert.getChildren().add(showEq5);
        HashTableMoveRect(Rec2, -1.0, hashtableSeqTranInsert);

        FadeTransition showEq8 = new FadeTransition(Duration.seconds(1.5), Label8Mod);
        showEq8.setFromValue(0.0);
        showEq8.setToValue(1.0);
        showEq8.setAutoReverse(true);
        hashtableSeqTranInsert.getChildren().add(showEq8);
        HashTableMoveRect(Rec3, -7.0, hashtableSeqTranInsert);

        FadeTransition showEq18 = new FadeTransition(Duration.seconds(1.5), Label18Mod);
        showEq18.setFromValue(0.0);
        showEq18.setToValue(1.0);
        showEq18.setAutoReverse(true);
        hashtableSeqTranInsert.getChildren().add(showEq18);
        HashTableMoveRect(Rec4, -9.0, hashtableSeqTranInsert);

        FadeTransition showEq6 = new FadeTransition(Duration.seconds(1.5), Label6Mod);
        showEq6.setFromValue(0.0);
        showEq6.setToValue(1.0);
        showEq6.setAutoReverse(true);
        hashtableSeqTranInsert.getChildren().add(showEq6);
        HashTableMoveRect(Rec5, -3.0, hashtableSeqTranInsert);

        FadeTransition showEq3 = new FadeTransition(Duration.seconds(1.5), Label3Mod);
        showEq3.setFromValue(0.0);
        showEq3.setToValue(1.0);
        showEq3.setAutoReverse(true);
        hashtableSeqTranInsert.getChildren().add(showEq3);
        HashTableMoveRect(Rec6, 3.0, hashtableSeqTranInsert);

        FadeTransition showEq10 = new FadeTransition(Duration.seconds(1.5), Label10Mod);
        showEq10.setFromValue(0.0);
        showEq10.setToValue(1.0);
        showEq10.setAutoReverse(true);
        hashtableSeqTranInsert.getChildren().add(showEq10);
        HashTableMoveRect(Rec7, 9.0, hashtableSeqTranInsert);

        hashtableSeqTranInsert.play();
        }
    public void PlayHashtableSequenceDelete () {
        //delete and fade out the Rectangle at index 1.
        SequentialTransition hashtableSeqTranDelete = new SequentialTransition();

        FadeTransition showDelete = new FadeTransition(Duration.seconds(1.5), LabelDelete);
        showDelete.setFromValue(0.0);
        showDelete.setToValue(1.0);
        showDelete.setAutoReverse(true);
        hashtableSeqTranDelete.getChildren().add(showDelete);

        FadeTransition fadeInCircle = new FadeTransition(Duration.seconds(1), TravelCircle);
        TravelCircle.setVisible(true);
        fadeInCircle.setFromValue(0.0);
        fadeInCircle.setToValue(1.0);
        hashtableSeqTranDelete.getChildren().add(fadeInCircle);

        HashTableMoveCirc(TravelCircle, 7.0, hashtableSeqTranDelete);

        FadeTransition fadeOutCircle = new FadeTransition(Duration.seconds(1), TravelCircle);
        fadeOutCircle.setFromValue(1.0);
        fadeOutCircle.setToValue(0.0);
        hashtableSeqTranDelete.getChildren().add(fadeOutCircle);

        FadeTransition fadeOutRec = new FadeTransition(Duration.seconds(1), Rec1);
        fadeOutRec.setFromValue(1.0);
        fadeOutRec.setToValue(0.0);
        hashtableSeqTranDelete.getChildren().add(fadeOutRec);

        hashtableSeqTranDelete.play();
        TravelCircle.setVisible(true);
        Rec1.setVisible(true);
    }
    public void PlayHashtableSequenceSearch () {
        SequentialTransition hashtableSeqTranSearch = new SequentialTransition();

        FadeTransition showSearch = new FadeTransition(Duration.seconds(1.5), LabelSearch);
        showSearch.setFromValue(0.0);
        showSearch.setToValue(1.0);
        showSearch.setAutoReverse(true);
        hashtableSeqTranSearch.getChildren().add(showSearch);

        TravelCircle.setVisible(true);
        HashTableMoveCirc(TravelCircle, 3.0, hashtableSeqTranSearch);
        hashtableSeqTranSearch.play();
    }

    public void HashTableMoveRect (Rectangle rectangleStart, Double numOfShifts, SequentialTransition hashInsSeqTran) {

        double xStart = (rectangleStart.getBoundsInLocal().getMinX() + rectangleStart.getBoundsInLocal().getMaxX()) / 2.0;
        double yStart = (rectangleStart.getBoundsInLocal().getMinY() + rectangleStart.getBoundsInLocal().getMaxY()) / 2.0;
        double centerSquare = (ModelPlaceholder.getBoundsInLocal().getMinY() + ModelPlaceholder.getBoundsInLocal().getMaxY()) * 0.9;
        double squareLength = (ModelPlaceholder.getBoundsInLocal().getMinX() + ModelPlaceholder.getBoundsInLocal().getMaxX()) / 2.0;
        Polyline polyline = new Polyline(); //polyline seems like it bases its coordinates off of the top left point of the OBJECT I'm using.
        polyline.getPoints().addAll(xStart, yStart,
                xStart, 200.0,
                xStart - (numOfShifts*squareLength), 200.0,
                xStart - (numOfShifts*squareLength), 200.0 + centerSquare);
        PathTransition transition = new PathTransition();
        transition.setNode(rectangleStart);
        transition.setDuration(Duration.seconds(1.5));
        transition.setPath(polyline);
        transition.setCycleCount(1);
        hashInsSeqTran.getChildren().add(transition);
    }

    public void HashTableMoveCirc (Circle circleSearcher, Double numOfShifts, SequentialTransition hashSeqTran) {

        double xStart = (circleSearcher.getBoundsInLocal().getMinX() + circleSearcher.getBoundsInLocal().getMaxX()) / 2.0;
        double yStart = (circleSearcher.getBoundsInLocal().getMinY() + circleSearcher.getBoundsInLocal().getMaxY()) / 2.0;
        double centerSquare = (ModelPlaceholder.getBoundsInLocal().getMinY() + ModelPlaceholder.getBoundsInLocal().getMaxY()) * 0.9;
        double squareLength = (ModelPlaceholder.getBoundsInLocal().getMinX() + ModelPlaceholder.getBoundsInLocal().getMaxX()) / 2.0;
        Polyline polyline = new Polyline(); //polyline seems like it bases its coordinates off of the top left point of the OBJECT I'm using.
        polyline.getPoints().addAll(xStart, yStart,
                xStart - (numOfShifts*squareLength), 200.0,
                xStart - (numOfShifts*squareLength), 150 + centerSquare);
        PathTransition transition = new PathTransition();
        transition.setNode(circleSearcher);
        transition.setDuration(Duration.seconds(2));
        transition.setPath(polyline);
        transition.setCycleCount(1);
        hashSeqTran.getChildren().add(transition);
    }
}
