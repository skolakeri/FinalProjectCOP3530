package sample;

import com.sun.org.apache.bcel.internal.generic.FADD;
import com.sun.xml.internal.bind.v2.model.core.EnumLeafInfo;
import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import jdk.nashorn.internal.ir.Labels;

import java.awt.*;
import java.security.Key;
import java.sql.Time;


/* Binary Tree Representation
                17
            4       21
         2    11        25
             7
   Delete 11 (move 7 to 11's original spot)
   Search For 7
 */

//Click Insert, Search, Delete
public class ControllerBinaryTree {

    public Line Line3_6;
    public Line Line5_7;
    public Line Line2_5;
    public Line Line2_4;
    public Line Line1_3;
    public Line Line1_2;
    public Circle CircleIndex7;
    public Circle CircleIndex6;
    public Circle CircleIndex5;
    public Circle CircleIndex4;
    public Circle CircleIndex3;
    public Circle CircleIndex2;
    public Circle CircleIndex1;
    public Circle StartPlaceholderBT;
    public Button SearchButtonBT;
    public Button DeleteButtonBT;
    public Button InsertButtonBT;
    public Label Comparison6cBT;
    public Label Comparison6bBT;
    public Label Comparison6aBT;
    public Label Comparison5bBT;
    public Label Comparison5aBT;
    public Label Comparison4bBT;
    public Label Comparison4aBT;
    public Label Comparison3bBT;
    public Label Comparison3aBT;
    public Label Comparison2BT;
    public Label Comparison1BT;
    public Label LabelRootBT;
    public Circle Circle1;
    public Circle Circle2;
    public Circle Circle3;
    public Circle Circle4;
    public Circle Circle5;
    public Circle Circle6;
    public Circle Circle7;
    public Line LineFAKE;
    public Label LabelSearch7;
    public Circle DeleteCircle;
    public Label LabelMove7;
    public Label LabelDelete11;

    public void InsertBT () {
        SequentialTransition seqTranInsBT = new SequentialTransition();
//17
        ShowEqBT(LabelRootBT, seqTranInsBT);
        MoveCircleBT(Circle1, StartPlaceholderBT, CircleIndex1, LineFAKE, seqTranInsBT);
        HideEqBT(LabelRootBT, LineFAKE, seqTranInsBT);
//4
        ShowEqBT(Comparison1BT, seqTranInsBT);
        MoveCircleBT(Circle2, StartPlaceholderBT, CircleIndex1, LineFAKE, seqTranInsBT);
        MoveCircleBT(Circle2, CircleIndex1, CircleIndex2, Line1_2, seqTranInsBT);
        HideEqBT(Comparison1BT, Line1_2, seqTranInsBT);
//21
        ShowEqBT(Comparison2BT, seqTranInsBT);
        MoveCircleBT(Circle3, StartPlaceholderBT, CircleIndex1, LineFAKE, seqTranInsBT);
        MoveCircleBT(Circle3, CircleIndex1, CircleIndex3, Line1_3, seqTranInsBT);
        HideEqBT(Comparison2BT, Line1_3, seqTranInsBT);
//11
        ShowEqBT(Comparison3aBT, seqTranInsBT);
        MoveCircleBT(Circle4, StartPlaceholderBT, CircleIndex1, LineFAKE, seqTranInsBT);
        MoveCircleBT(Circle4, CircleIndex1, CircleIndex2, LineFAKE, seqTranInsBT);
        HideEqBT(Comparison3aBT, LineFAKE, seqTranInsBT);
        ShowEqBT(Comparison3bBT, seqTranInsBT);
        MoveCircleBT(Circle4, CircleIndex2, CircleIndex5, Line2_5, seqTranInsBT);
        HideEqBT(Comparison3bBT, Line2_5, seqTranInsBT);
//25
        ShowEqBT(Comparison4aBT, seqTranInsBT);
        MoveCircleBT(Circle5, StartPlaceholderBT, CircleIndex1, LineFAKE, seqTranInsBT);
        MoveCircleBT(Circle5, CircleIndex1, CircleIndex3, LineFAKE, seqTranInsBT);
        HideEqBT(Comparison4aBT, LineFAKE, seqTranInsBT);
        ShowEqBT(Comparison4bBT, seqTranInsBT);
        MoveCircleBT(Circle5, CircleIndex3, CircleIndex6, Line3_6, seqTranInsBT);
        HideEqBT(Comparison4bBT, Line3_6, seqTranInsBT);
//2
        ShowEqBT(Comparison5aBT, seqTranInsBT);
        MoveCircleBT(Circle6, StartPlaceholderBT, CircleIndex1, LineFAKE, seqTranInsBT);
        MoveCircleBT(Circle6, CircleIndex1, CircleIndex2, LineFAKE, seqTranInsBT);
        HideEqBT(Comparison5aBT, LineFAKE, seqTranInsBT);
        ShowEqBT(Comparison5bBT, seqTranInsBT);
        MoveCircleBT(Circle6, CircleIndex2, CircleIndex4, Line2_4, seqTranInsBT);
        HideEqBT(Comparison5bBT, Line2_4, seqTranInsBT);
//7
        ShowEqBT(Comparison6aBT, seqTranInsBT);
        MoveCircleBT(Circle7, StartPlaceholderBT, CircleIndex1, LineFAKE, seqTranInsBT);
        MoveCircleBT(Circle7, CircleIndex1, CircleIndex2, LineFAKE, seqTranInsBT);
        HideEqBT(Comparison6aBT, LineFAKE, seqTranInsBT);
        ShowEqBT(Comparison6bBT, seqTranInsBT);
        MoveCircleBT(Circle7, CircleIndex2, CircleIndex5, LineFAKE, seqTranInsBT);
        HideEqBT(Comparison6bBT, LineFAKE, seqTranInsBT);
        ShowEqBT(Comparison6cBT, seqTranInsBT);
        MoveCircleBT(Circle7, CircleIndex5, CircleIndex7, Line5_7, seqTranInsBT);
        HideEqBT(Comparison6cBT, Line5_7, seqTranInsBT);

        seqTranInsBT.play();
    }

    public void DeleteBT () {
        LabelSearch7.setVisible(false);
        DeHighlightNodeBT(Circle1);
        DeHighlightNodeBT(Circle2);
        DeHighlightNodeBT(Circle4);
        DeHighlightNodeBT(Circle7);

        SequentialTransition seqTranDelBT = new SequentialTransition();
        DeleteCircle.setVisible(true);
        ShowEqBT(LabelDelete11, seqTranDelBT);
        MoveCircleBT(DeleteCircle, StartPlaceholderBT, CircleIndex1, LineFAKE, seqTranDelBT);
        MoveCircleBT(DeleteCircle, CircleIndex1, CircleIndex2, LineFAKE, seqTranDelBT);
        MoveCircleBT(DeleteCircle, CircleIndex2, CircleIndex5, LineFAKE, seqTranDelBT);

        FadeTransition fadeOutDelCir = new FadeTransition(Duration.seconds(0.5));
        fadeOutDelCir.setFromValue(1.0);
        fadeOutDelCir.setToValue(0.0);
        fadeOutDelCir.setNode(DeleteCircle);
        seqTranDelBT.getChildren().add(fadeOutDelCir);

        FadeTransition fadeoutCir = new FadeTransition(Duration.seconds(0.5));
        fadeoutCir.setFromValue(1.0);
        fadeoutCir.setToValue(0.0);
        fadeoutCir.setNode(Circle4);
        seqTranDelBT.getChildren().add(fadeoutCir);
        HideEqBT(LabelDelete11, LineFAKE, seqTranDelBT);

        ShowEqBT(LabelMove7, seqTranDelBT);
        MoveCircleBT(Circle7, CircleIndex7, CircleIndex5, LineFAKE, seqTranDelBT);
        HideEqBT(LabelMove7, LineFAKE, seqTranDelBT);

        FadeTransition fadeOutLine = new FadeTransition(Duration.seconds(0.5));
        fadeOutLine.setNode(Line5_7);
        fadeOutLine.setFromValue(1.0);
        fadeOutLine.setToValue(0.0);
        seqTranDelBT.getChildren().add(fadeOutLine);

        seqTranDelBT.play();
    }

    public void SearchBT () {
        LabelSearch7.setVisible(true);
        HighlightNodeBT(Circle1);
        HighlightNodeBT(Circle2);
        HighlightNodeBT(Circle4);
        HighlightNodeBT(Circle7);

        //        SequentialTransition seqTranSearchBT = new SequentialTransition();
//        //Timeline timelineDelBT = new Timeline();
//        CircleIndex2.setVisible(true);
//        CircleIndex4.setVisible(true);
//
//        EnglargeNodeBT(CircleIndex4, timelineDelBT);
//        EnglargeNodeBT(Circle2, timelineDelBT);
//        //ShrinkNodeBT(CircleIndex4, timelineDelBT);
//
//        timelineDelBT.setAutoReverse(true);
//        timelineDelBT.setCycleCount(2);
//        timelineDelBT.play();
    }

    public void EnglargeNodeBT (Circle circle, Timeline timeline) {
//        Glow glow = new Glow();
//        glow.setLevel(3.0);
//        circle.setEffect(glow);
        KeyValue start = new KeyValue(circle.radiusProperty(), 50);
        KeyValue end = new KeyValue(circle.radiusProperty(), 75);
        KeyFrame frame = new KeyFrame(Duration.seconds(1), start, end);

        timeline.getKeyFrames().add(frame);
    }

    public void HighlightNodeBT (Circle circle) {
        Glow glowUp = new Glow();
        glowUp.setLevel(3.0);
        circle.setEffect(glowUp);
    }

    public void DeHighlightNodeBT (Circle circle) {
        Glow glowUp = new Glow();
        glowUp.setLevel(0.0);
        circle.setEffect(glowUp);
    }

    public void MoveCircleBT (Circle circleToMove, Circle from, Circle destination, Line line, SequentialTransition seqTran) {
        Polyline path = new Polyline();
        //destination points
        double start1 = from.getLayoutX()-200;
        //System.out.println(from.getLayoutX() + " ," + from.getLayoutY());
        double start2 = from.getLayoutY()-100;
        double loc1 = destination.getLayoutX()-200.0;
        double loc2 = destination.getLayoutY()-100.0;
        path.getPoints().addAll(start1, start2,
                loc1, loc2);
        PathTransition transition = new PathTransition();
        transition.setNode(circleToMove);
        transition.setDuration(Duration.seconds(1.5));
        transition.setPath(path);
        transition.setCycleCount(1);
        seqTran.getChildren().add(transition);
        line.setVisible(true);
        LineFAKE.setVisible(false);
    }

    public void ShowEqBT (Label label, SequentialTransition seqTranBT2) {
        FadeTransition showEq = new FadeTransition(Duration.seconds(0.5), label);
        label.setVisible(true);
        showEq.setFromValue(0.0);
        showEq.setToValue(1.0);
        showEq.setAutoReverse(true);
        seqTranBT2.getChildren().add(showEq);
        }

    public void HideEqBT (Label label, Line line, SequentialTransition seqTranBT3) {

        if (line != LineFAKE) {
            FadeTransition showLine = new FadeTransition(Duration.seconds(0.5), line);
            showLine.setFromValue(0.0);
            showLine.setToValue(1.0);
            seqTranBT3.getChildren().add(showLine);
        }

        FadeTransition hideEq = new FadeTransition(Duration.seconds(0.5), label);
        hideEq.setFromValue(1.0);
        hideEq.setToValue(0.0);
        seqTranBT3.getChildren().add(hideEq);
    }

}
