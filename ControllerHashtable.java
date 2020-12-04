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
    public Label LabelNum1;
    public Label LabelNum5;
    public Label LabelNum8;
    public Label LabelNum18;
    public Label LabelNum6;
    public Label LabelNum3;
    public Label LabelNum10;
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

        FadeTransition showLab1 = new FadeTransition(Duration.seconds(0.2), LabelNum1);
        LabelNum1.setVisible(true);
        showLab1.setFromValue(0.0);
        showLab1.setToValue(1.0);
        showLab1.setAutoReverse(true);
        hashtableSeqTranInsert.getChildren().add(showLab1);

        FadeTransition showEq1 = new FadeTransition(Duration.seconds(1), Label1Mod);
        showEq1.setFromValue(0.0);
        showEq1.setToValue(1.0);
        showEq1.setAutoReverse(true);
        hashtableSeqTranInsert.getChildren().add(showEq1);

        HashTableMoveRect(Rec1, LabelNum1,7.0, hashtableSeqTranInsert);
//
        FadeTransition showLab5 = new FadeTransition(Duration.seconds(0.2), LabelNum5);
        LabelNum5.setVisible(true);
        showLab5.setFromValue(0.0);
        showLab5.setToValue(1.0);
        showLab5.setAutoReverse(true);
        hashtableSeqTranInsert.getChildren().add(showLab5);

        FadeTransition showEq5 = new FadeTransition(Duration.seconds(1), Label5Mod);
        showEq5.setFromValue(0.0);
        showEq5.setToValue(1.0);
        showEq5.setAutoReverse(true);
        hashtableSeqTranInsert.getChildren().add(showEq5);

        HashTableMoveRect(Rec2, LabelNum5,-1.0, hashtableSeqTranInsert);
//
        FadeTransition showLab8 = new FadeTransition(Duration.seconds(0.2), LabelNum8);
        LabelNum8.setVisible(true);
        showLab8.setFromValue(0.0);
        showLab8.setToValue(1.0);
        showLab8.setAutoReverse(true);
        hashtableSeqTranInsert.getChildren().add(showLab8);

        FadeTransition showEq8 = new FadeTransition(Duration.seconds(1), Label8Mod);
        showEq8.setFromValue(0.0);
        showEq8.setToValue(1.0);
        showEq8.setAutoReverse(true);
        hashtableSeqTranInsert.getChildren().add(showEq8);
        HashTableMoveRect(Rec3, LabelNum8,-7.0, hashtableSeqTranInsert);
//
        FadeTransition showLab18 = new FadeTransition(Duration.seconds(0.2), LabelNum18);
        LabelNum18.setVisible(true);
        showLab18.setFromValue(0.0);
        showLab18.setToValue(1.0);
        showLab18.setAutoReverse(true);
        hashtableSeqTranInsert.getChildren().add(showLab18);

        FadeTransition showEq18 = new FadeTransition(Duration.seconds(1), Label18Mod);
        showEq18.setFromValue(0.0);
        showEq18.setToValue(1.0);
        showEq18.setAutoReverse(true);
        hashtableSeqTranInsert.getChildren().add(showEq18);
        HashTableMoveRect(Rec4, LabelNum18,-9.0, hashtableSeqTranInsert);
//
        FadeTransition showLab6 = new FadeTransition(Duration.seconds(0.2), LabelNum6);
        LabelNum6.setVisible(true);
        showLab6.setFromValue(0.0);
        showLab6.setToValue(1.0);
        showLab6.setAutoReverse(true);
        hashtableSeqTranInsert.getChildren().add(showLab6);

        FadeTransition showEq6 = new FadeTransition(Duration.seconds(1), Label6Mod);
        showEq6.setFromValue(0.0);
        showEq6.setToValue(1.0);
        showEq6.setAutoReverse(true);
        hashtableSeqTranInsert.getChildren().add(showEq6);
        HashTableMoveRect(Rec5, LabelNum6,-3.0, hashtableSeqTranInsert);
//
        FadeTransition showLab3 = new FadeTransition(Duration.seconds(0.2), LabelNum3);
        LabelNum3.setVisible(true);
        showLab3.setFromValue(0.0);
        showLab3.setToValue(1.0);
        showLab3.setAutoReverse(true);
        hashtableSeqTranInsert.getChildren().add(showLab3);

        FadeTransition showEq3 = new FadeTransition(Duration.seconds(1), Label3Mod);
        showEq3.setFromValue(0.0);
        showEq3.setToValue(1.0);
        showEq3.setAutoReverse(true);
        hashtableSeqTranInsert.getChildren().add(showEq3);
        HashTableMoveRect(Rec6, LabelNum3,3.0, hashtableSeqTranInsert);
//
        FadeTransition showLab10 = new FadeTransition(Duration.seconds(0.2), LabelNum10);
        LabelNum10.setVisible(true);
        showLab10.setFromValue(0.0);
        showLab10.setToValue(1.0);
        showLab10.setAutoReverse(true);
        hashtableSeqTranInsert.getChildren().add(showLab10);

        FadeTransition showEq10 = new FadeTransition(Duration.seconds(1), Label10Mod);
        showEq10.setFromValue(0.0);
        showEq10.setToValue(1.0);
        showEq10.setAutoReverse(true);
        hashtableSeqTranInsert.getChildren().add(showEq10);
        HashTableMoveRect(Rec7, LabelNum10,9.0, hashtableSeqTranInsert);
//
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
        FadeTransition fadeOutNum = new FadeTransition(Duration.seconds(1), LabelNum1);
        fadeOutNum.setFromValue(1.0);
        fadeOutNum.setToValue(0.0);
        ParallelTransition ptD = new ParallelTransition();
        ptD.getChildren().addAll(fadeOutRec, fadeOutNum);
        hashtableSeqTranDelete.getChildren().add(ptD);

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

    public void HashTableMoveRect (Rectangle rectangleStart, Label label, Double numOfShifts, SequentialTransition hashInsSeqTran) {

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

        PathTransition transitionOther = new PathTransition();
        transitionOther.setNode(label);
        transitionOther.setDuration(Duration.seconds(1.5));
        transitionOther.setPath(polyline);
        transitionOther.setCycleCount(1);

        //label.setVisible(true);

        ParallelTransition pt = new ParallelTransition();
        pt.getChildren().addAll(transition, transitionOther);
        hashInsSeqTran.getChildren().add(pt);
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