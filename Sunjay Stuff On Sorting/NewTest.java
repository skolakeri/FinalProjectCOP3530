package sample;//package sample;

// Necessary Imports
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

public class NewTest {

//    enum SORT{
//        SELECTION,
//        BUBBLE,
//        INSERTION,
//    }
//    enum TYPE{
//        INT,
//        FLOAT,
//        DOUBLE,
//    }

    // List of XFML objects
    public Text numberSorted;
    // Need to rename to whatever algorithmn we are on
    public Text nameOfAlgorithmn;
    public TextArea unsortedArrayElements;
    public TextArea sortedArrayElements;
    public Text TimeExectionTextBox;
    public Button ShowSubScene;
    public BorderPane SubSceneBorderPane;
    public javafx.scene.SubScene SubScene;

    /*
        This method will be invoked when the back button is clicked. It loads the inputNumber FXML file
     */
    public void backToInputNumber(ActionEvent event) throws IOException {

        Parent inputNumberScene = FXMLLoader.load(getClass().getResource("InputNumber.fxml"));
        Scene newScene = new Scene(inputNumberScene);
        // This line gets the Stage information of the Input Number FXML
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        // Displays the Window
        window.setScene(newScene);
        window.show();
    }
    /*
        This method is called when the user inputs a number of values to be sorted
     */
    public void initData(TextField text, InputNumber.SORT sort, InputNumber.TYPE type) throws IOException {
        //create 3 datasets of integer, doubles, and floats worth 100,000 lines
        int[] intData = new int[100000];
        double[] doubleData = new double[100000];
        float[] floatData = new float[100000];
        // Populates the above array with random values
        CreateData(intData, doubleData, floatData);
        // Sets the numberSorted Text to the number sorted based off user input
        numberSorted.setText(text.getText());

        if(sort == InputNumber.SORT.SELECTION)
        {
            nameOfAlgorithmn.setText("Selection Sort");
            if(type == InputNumber.TYPE.DOUBLE)
            {
                // Creates a Hashtable with Key: randomNumber, Value: randomNumber that will be used to access the random generated numbers
                Hashtable<Double, Double> pickStoreDouble = new Hashtable<Double, Double>();
                // Populates the HashTable with the random values
                pickStoreDouble = RetrieveDoubleFromFile(text.getText().toString(), doubleData);
                // Sets the textBox of unsorted array values to all values in the textbox
                getUnsortedArrayDouble(unsortedArrayElements, pickStoreDouble);
                // Sets the textBox of sorted array values to all values in the textbox
                getSortedArrayDoubleSelection(sortedArrayElements, pickStoreDouble);
            }
            if(type == InputNumber.TYPE.INT)
            {
                // Creates a Hashtable with Key: randomNumber, Value: randomNumber that will be used to access the random generated numbers
                Hashtable<Integer, Integer> pickStoreDouble = new Hashtable<Integer, Integer>();
                // Populates the HashTable with the random values
                pickStoreDouble = RetrieveIntFromFile(text.getText().toString(), intData);
                // Sets the textBox of unsorted array values to all values in the textbox
                getUnsortedArrayInt(unsortedArrayElements, pickStoreDouble);
                // Sets the textBox of sorted array values to all values in the textbox
                getSortedArrayIntSelection(sortedArrayElements, pickStoreDouble);
            }
            if(type == InputNumber.TYPE.FLOAT)
            {
                // Creates a Hashtable with Key: randomNumber, Value: randomNumber that will be used to access the random generated numbers
                Hashtable<Float, Float> pickStoreDouble = new Hashtable<Float, Float>();
                // Populates the HashTable with the random values
                pickStoreDouble = RetrieveFloatFromFile(text.getText().toString(), floatData);
                // Sets the textBox of unsorted array values to all values in the textbox
                getUnsortedArrayFloat(unsortedArrayElements, pickStoreDouble);
                // Sets the textBox of sorted array values to all values in the textbox
                getSortedArrayFloatSelection(sortedArrayElements, pickStoreDouble);
            }
        }
        if(sort == InputNumber.SORT.INSERTION)
        {
            nameOfAlgorithmn.setText("Insertion Sort");
            if(type == InputNumber.TYPE.DOUBLE)
            {
                // Creates a Hashtable with Key: randomNumber, Value: randomNumber that will be used to access the random generated numbers
                Hashtable<Double, Double> pickStoreDouble = new Hashtable<Double, Double>();
                // Populates the HashTable with the random values
                pickStoreDouble = RetrieveDoubleFromFile(text.getText().toString(), doubleData);
                // Sets the textBox of unsorted array values to all values in the textbox
                getUnsortedArrayDouble(unsortedArrayElements, pickStoreDouble);
                // Sets the textBox of sorted array values to all values in the textbox
                getSortedArrayDoubleInsertion(sortedArrayElements, pickStoreDouble);
            }
            if(type == InputNumber.TYPE.INT)
            {
                // Creates a Hashtable with Key: randomNumber, Value: randomNumber that will be used to access the random generated numbers
                Hashtable<Integer, Integer> pickStoreDouble = new Hashtable<Integer, Integer>();
                // Populates the HashTable with the random values
                pickStoreDouble = RetrieveIntFromFile(text.getText().toString(), intData);
                // Sets the textBox of unsorted array values to all values in the textbox
                getUnsortedArrayInt(unsortedArrayElements, pickStoreDouble);
                // Sets the textBox of sorted array values to all values in the textbox
                getSortedArrayIntInsertion(sortedArrayElements, pickStoreDouble);
            }
            if(type == InputNumber.TYPE.FLOAT)
            {
                // Creates a Hashtable with Key: randomNumber, Value: randomNumber that will be used to access the random generated numbers
                Hashtable<Float, Float> pickStoreDouble = new Hashtable<Float, Float>();
                // Populates the HashTable with the random values
                pickStoreDouble = RetrieveFloatFromFile(text.getText().toString(), floatData);
                // Sets the textBox of unsorted array values to all values in the textbox
                getUnsortedArrayFloat(unsortedArrayElements, pickStoreDouble);
                // Sets the textBox of sorted array values to all values in the textbox
                getSortedArrayFloatInsertion(sortedArrayElements, pickStoreDouble);
            }
        }
        if(sort == InputNumber.SORT.BUBBLE)
        {
            nameOfAlgorithmn.setText("Bubble Sort");
            if(type == InputNumber.TYPE.DOUBLE)
            {
                // Creates a Hashtable with Key: randomNumber, Value: randomNumber that will be used to access the random generated numbers
                Hashtable<Double, Double> pickStoreDouble = new Hashtable<Double, Double>();
                // Populates the HashTable with the random values
                pickStoreDouble = RetrieveDoubleFromFile(text.getText().toString(), doubleData);
                // Sets the textBox of unsorted array values to all values in the textbox
                getUnsortedArrayDouble(unsortedArrayElements, pickStoreDouble);
                // Sets the textBox of sorted array values to all values in the textbox
                getSortedArrayDoubleBubble(sortedArrayElements, pickStoreDouble);
            }
            if(type == InputNumber.TYPE.INT)
            {
                // Creates a Hashtable with Key: randomNumber, Value: randomNumber that will be used to access the random generated numbers
                Hashtable<Integer, Integer> pickStoreDouble = new Hashtable<Integer, Integer>();
                // Populates the HashTable with the random values
                pickStoreDouble = RetrieveIntFromFile(text.getText().toString(), intData);
                // Sets the textBox of unsorted array values to all values in the textbox
                getUnsortedArrayInt(unsortedArrayElements, pickStoreDouble);
                // Sets the textBox of sorted array values to all values in the textbox
                getSortedArrayIntBubble(sortedArrayElements, pickStoreDouble);
            }
            if(type == InputNumber.TYPE.FLOAT)
            {
                // Creates a Hashtable with Key: randomNumber, Value: randomNumber that will be used to access the random generated numbers
                Hashtable<Float, Float> pickStoreDouble = new Hashtable<Float, Float>();
                // Populates the HashTable with the random values
                pickStoreDouble = RetrieveFloatFromFile(text.getText().toString(), floatData);
                // Sets the textBox of unsorted array values to all values in the textbox
                getUnsortedArrayFloat(unsortedArrayElements, pickStoreDouble);
                // Sets the textBox of sorted array values to all values in the textbox
                getSortedArrayFloatBubble(sortedArrayElements, pickStoreDouble);
            }
        }

    }

    public void getUnsortedArrayDouble(TextArea unsortedArrayElements, Hashtable<Double, Double> pickStoreDouble)
    {
        Set<Double> keys = pickStoreDouble.keySet();
        Iterator<Double> itr = keys.iterator();
        Double iteratorKey;
        String finalAns = "";
        int count = 0;
        String index;
        while (itr.hasNext())
        {
            iteratorKey = itr.next();
            iteratorKey*=100;
            iteratorKey= (double)Math.round(iteratorKey);
            iteratorKey/=100;
            index = String.valueOf(count) + " | ";
            finalAns+=index;
            finalAns+=String.valueOf(iteratorKey);
            finalAns+="\n";
            count++;
        }
        unsortedArrayElements.setText(finalAns);
    }
    public void getUnsortedArrayInt(TextArea unsortedArrayElements, Hashtable<Integer, Integer> pickStoreDouble)
    {
        Set<Integer> keys = pickStoreDouble.keySet();
        Iterator<Integer> itr = keys.iterator();
        int iteratorKey;
        String finalAns = "";
        int count = 0;
        String index;
        while (itr.hasNext())
        {
            iteratorKey = itr.next();
            index = String.valueOf(count) + " | ";
            finalAns+=index;
            finalAns+=String.valueOf(iteratorKey);
            finalAns+="\n";
            count++;
        }
        unsortedArrayElements.setText(finalAns);
    }
    public void getUnsortedArrayFloat(TextArea unsortedArrayElements, Hashtable<Float, Float> pickStoreDouble)
    {
        Set<Float> keys = pickStoreDouble.keySet();
        Iterator<Float> itr = keys.iterator();
        float iteratorKey;
        String finalAns = "";
        int count = 0;
        String index;
        while (itr.hasNext())
        {
            iteratorKey = itr.next();
            iteratorKey*=100;
            iteratorKey= (float) Math.round(iteratorKey);
            iteratorKey/=100;
            index = String.valueOf(count) + " | ";
            finalAns+=index;
            finalAns+=String.valueOf(iteratorKey);
            finalAns+="\n";
            count++;
        }
        unsortedArrayElements.setText(finalAns);
    }
    /*
       Given a hashtable of values of doubles, calls selection sort on them and returns a double array of sorted values
     */
    public double[] sortArraySelectionSortDouble(Hashtable<Double, Double> pickStoreDouble)
    {
        // First, sort the elements in pickStoreDouble
        double[] sortedArr = new double[pickStoreDouble.size()];
        Set<Double> keysOrig = pickStoreDouble.keySet();
        //Obtaining iterator over set entries
        Iterator<Double> itrOrig = keysOrig.iterator();
        Double val;
        int count = 0;
        //Displaying Key and value pairs
        while (itrOrig.hasNext()) {
            val = itrOrig.next();
            sortedArr[count] = val;
            count++;
        }
        selectionSortDouble(sortedArr, pickStoreDouble.size());
        return sortedArr;
    }
    public double[] sortArrayInsertionSortDouble(Hashtable<Double, Double> pickStoreDouble)
    {
        // First, sort the elements in pickStoreDouble
        double[] sortedArr = new double[pickStoreDouble.size()];
        Set<Double> keysOrig = pickStoreDouble.keySet();
        //Obtaining iterator over set entries
        Iterator<Double> itrOrig = keysOrig.iterator();
        Double val;
        int count = 0;
        //Displaying Key and value pairs
        while (itrOrig.hasNext()) {
            val = itrOrig.next();
            sortedArr[count] = val;
            count++;
        }
        insertionSortDouble(sortedArr, pickStoreDouble.size());
        return sortedArr;
    }
    public double[] sortArrayBubbleSortDouble(Hashtable<Double, Double> pickStoreDouble)
    {
        // First, sort the elements in pickStoreDouble
        double[] sortedArr = new double[pickStoreDouble.size()];
        Set<Double> keysOrig = pickStoreDouble.keySet();
        //Obtaining iterator over set entries
        Iterator<Double> itrOrig = keysOrig.iterator();
        Double val;
        int count = 0;
        //Displaying Key and value pairs
        while (itrOrig.hasNext()) {
            val = itrOrig.next();
            sortedArr[count] = val;
            count++;
        }
        bubbleSortDouble(sortedArr, pickStoreDouble.size());
        return sortedArr;
    }

    public int[] sortArraySelectionSortInt(Hashtable<Integer, Integer> pickStoreDouble)
    {
        // First, sort the elements in pickStoreDouble
        int[] sortedArr = new int[pickStoreDouble.size()];
        Set<Integer> keysOrig = pickStoreDouble.keySet();
        //Obtaining iterator over set entries
        Iterator<Integer> itrOrig = keysOrig.iterator();
        int val;
        int count = 0;
        //Displaying Key and value pairs
        while (itrOrig.hasNext()) {
            val = itrOrig.next();
            sortedArr[count] = val;
            count++;
        }
        selectionSortInt(sortedArr, pickStoreDouble.size());
        return sortedArr;
    }
    public int[] sortArrayInsertionSortInt(Hashtable<Integer, Integer> pickStoreDouble)
    {
        // First, sort the elements in pickStoreDouble
        int[] sortedArr = new int[pickStoreDouble.size()];
        Set<Integer> keysOrig = pickStoreDouble.keySet();
        //Obtaining iterator over set entries
        Iterator<Integer> itrOrig = keysOrig.iterator();
        int val;
        int count = 0;
        //Displaying Key and value pairs
        while (itrOrig.hasNext()) {
            val = itrOrig.next();
            sortedArr[count] = val;
            count++;
        }
        insertionSortInt(sortedArr, pickStoreDouble.size());
        return sortedArr;
    }
    public int[] sortArrayBubbleSortInt(Hashtable<Integer, Integer> pickStoreDouble)
    {
        // First, sort the elements in pickStoreDouble
        int[] sortedArr = new int[pickStoreDouble.size()];
        Set<Integer> keysOrig = pickStoreDouble.keySet();
        //Obtaining iterator over set entries
        Iterator<Integer> itrOrig = keysOrig.iterator();
        int val;
        int count = 0;
        //Displaying Key and value pairs
        while (itrOrig.hasNext()) {
            val = itrOrig.next();
            sortedArr[count] = val;
            count++;
        }
        bubbleSortInt(sortedArr, pickStoreDouble.size());
        return sortedArr;
    }
    public float[] sortArraySelectionSortFloat(Hashtable<Float, Float> pickStoreDouble)
    {
        // First, sort the elements in pickStoreDouble
        float[] sortedArr = new float[pickStoreDouble.size()];
        Set<Float> keysOrig = pickStoreDouble.keySet();
        //Obtaining iterator over set entries
        Iterator<Float> itrOrig = keysOrig.iterator();
        float val;
        int count = 0;
        //Displaying Key and value pairs
        while (itrOrig.hasNext()) {
            val = itrOrig.next();
            sortedArr[count] = val;
            count++;
        }
        selectionSortFloat(sortedArr, pickStoreDouble.size());
        return sortedArr;
    }
    public float[] sortArrayInsertionSortFloat(Hashtable<Float, Float> pickStoreDouble)
    {
        // First, sort the elements in pickStoreDouble
        float[] sortedArr = new float[pickStoreDouble.size()];
        Set<Float> keysOrig = pickStoreDouble.keySet();
        //Obtaining iterator over set entries
        Iterator<Float> itrOrig = keysOrig.iterator();
        float val;
        int count = 0;
        //Displaying Key and value pairs
        while (itrOrig.hasNext()) {
            val = itrOrig.next();
            sortedArr[count] = val;
            count++;
        }
        insertionSortFloat(sortedArr, pickStoreDouble.size());
        return sortedArr;
    }
    public float[] sortArrayBubbleSortFloat(Hashtable<Float, Float> pickStoreDouble)
    {
        // First, sort the elements in pickStoreDouble
        float[] sortedArr = new float[pickStoreDouble.size()];
        Set<Float> keysOrig = pickStoreDouble.keySet();
        //Obtaining iterator over set entries
        Iterator<Float> itrOrig = keysOrig.iterator();
        float val;
        int count = 0;
        //Displaying Key and value pairs
        while (itrOrig.hasNext()) {
            val = itrOrig.next();
            sortedArr[count] = val;
            count++;
        }
        bubbleSortFloat(sortedArr, pickStoreDouble.size());
        return sortedArr;
    }

    /*
         Given a text object, and a HashTable of values, performs selection sort on them
     */
    public void getSortedArrayDoubleSelection(TextArea sortedArrayElements, Hashtable<Double, Double> pickStoreDouble)
    {
        // First, sort the elements in pickStoreDouble
        double[] sortedArr = sortArraySelectionSortDouble(pickStoreDouble);
        // Set the text object to hold the values of the sort of format Index | Val
        String finalString = "";
        for(int i = 0; i < sortedArr.length; i++)
        {
            sortedArr[i]*=100;
            sortedArr[i]= (double)Math.round(sortedArr[i]);
            sortedArr[i]/=100;
            finalString+= String.valueOf(i)  + " | " + sortedArr[i] + "\n";
        }
        sortedArrayElements.setText(finalString);
    }
    public void getSortedArrayIntSelection(TextArea sortedArrayElements, Hashtable<Integer, Integer> pickStoreInt)
    {
        // First, sort the elements in pickStoreDouble
        int[] sortedArr = sortArraySelectionSortInt(pickStoreInt);
        // Set the text object to hold the values of the sort of format Index | Val
        String finalString = "";
        for(int i = 0; i < sortedArr.length; i++)
        {
            finalString+= String.valueOf(i)  + " | " + sortedArr[i] + "\n";
        }
        sortedArrayElements.setText(finalString);
    }
    public void getSortedArrayFloatSelection(TextArea sortedArrayElements, Hashtable<Float, Float> pickStoreFloat)
    {
        // First, sort the elements in pickStoreDouble
        float[] sortedArr = sortArraySelectionSortFloat(pickStoreFloat);
        // Set the text object to hold the values of the sort of format Index | Val
        String finalString = "";
        for(int i = 0; i < sortedArr.length; i++)
        {
            sortedArr[i]*=100;
            sortedArr[i]= (float) Math.round(sortedArr[i]);
            sortedArr[i]/=100;
            finalString+= String.valueOf(i)  + " | " + sortedArr[i] + "\n";
        }
        sortedArrayElements.setText(finalString);
    }
    public void getSortedArrayDoubleInsertion(TextArea sortedArrayElements, Hashtable<Double, Double> pickStoreDouble)
    {
        // First, sort the elements in pickStoreDouble
        double[] sortedArr = sortArrayInsertionSortDouble(pickStoreDouble);
        // Set the text object to hold the values of the sort of format Index | Val
        String finalString = "";
        for(int i = 0; i < sortedArr.length; i++)
        {
            sortedArr[i]*=100;
            sortedArr[i]= (double)Math.round(sortedArr[i]);
            sortedArr[i]/=100;
            finalString+= String.valueOf(i)  + " | " + sortedArr[i] + "\n";
        }
        sortedArrayElements.setText(finalString);
    }
    public void getSortedArrayIntInsertion(TextArea sortedArrayElements, Hashtable<Integer, Integer> pickStoreInt)
    {
        // First, sort the elements in pickStoreDouble
        int[] sortedArr = sortArrayInsertionSortInt(pickStoreInt);
        // Set the text object to hold the values of the sort of format Index | Val
        String finalString = "";
        for(int i = 0; i < sortedArr.length; i++)
        {
            finalString+= String.valueOf(i)  + " | " + sortedArr[i] + "\n";
        }
        sortedArrayElements.setText(finalString);
    }
    public void getSortedArrayFloatInsertion(TextArea sortedArrayElements, Hashtable<Float, Float> pickStoreFloat)
    {
        // First, sort the elements in pickStoreDouble
        float[] sortedArr = sortArrayInsertionSortFloat(pickStoreFloat);
        // Set the text object to hold the values of the sort of format Index | Val
        String finalString = "";
        for(int i = 0; i < sortedArr.length; i++)
        {
            sortedArr[i]*=100;
            sortedArr[i]= (float) Math.round(sortedArr[i]);
            sortedArr[i]/=100;
            finalString+= String.valueOf(i)  + " | " + sortedArr[i] + "\n";
        }
        sortedArrayElements.setText(finalString);
    }
    public void getSortedArrayDoubleBubble(TextArea sortedArrayElements, Hashtable<Double, Double> pickStoreDouble)
    {
        // First, sort the elements in pickStoreDouble
        double[] sortedArr = sortArrayBubbleSortDouble(pickStoreDouble);
        // Set the text object to hold the values of the sort of format Index | Val
        String finalString = "";
        for(int i = 0; i < sortedArr.length; i++)
        {
            sortedArr[i]*=100;
            sortedArr[i]= (double)Math.round(sortedArr[i]);
            sortedArr[i]/=100;
            finalString+= String.valueOf(i)  + " | " + sortedArr[i] + "\n";
        }
        sortedArrayElements.setText(finalString);
    }
    public void getSortedArrayIntBubble(TextArea sortedArrayElements, Hashtable<Integer, Integer> pickStoreInt)
    {
        // First, sort the elements in pickStoreDouble
        int[] sortedArr = sortArrayBubbleSortInt(pickStoreInt);
        // Set the text object to hold the values of the sort of format Index | Val
        String finalString = "";
        for(int i = 0; i < sortedArr.length; i++)
        {
            finalString+= String.valueOf(i)  + " | " + sortedArr[i] + "\n";
        }
        sortedArrayElements.setText(finalString);
    }
    public void getSortedArrayFloatBubble(TextArea sortedArrayElements, Hashtable<Float, Float> pickStoreFloat)
    {
        // First, sort the elements in pickStoreDouble
        float[] sortedArr = sortArrayBubbleSortFloat(pickStoreFloat);
        // Set the text object to hold the values of the sort of format Index | Val
        String finalString = "";
        for(int i = 0; i < sortedArr.length; i++)
        {
            sortedArr[i]*=100;
            sortedArr[i]= (float) Math.round(sortedArr[i]);
            sortedArr[i]/=100;
            finalString+= String.valueOf(i)  + " | " + sortedArr[i] + "\n";
        }
        sortedArrayElements.setText(finalString);
    }

    /*
         Performs Selection sort on an array of double
     */
    public void selectionSortDouble(double arr[], int size) {
        long startTime = System.nanoTime();
        for (int i = 0; i < size - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[min_index])
                    min_index = j;
            }
            double temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
        }
        long stopTime = System.nanoTime();
        TimeExectionTextBox.setText(String.valueOf((stopTime - startTime) / 1000000.0) + " milliseconds");
        //System.out.println(stopTime - startTime);
    }
    public void bubbleSortDouble(double arr[], int size) {
        long startTime = System.nanoTime();
        for (int i = 0; i < size - 1; i++) {
            int swapped = 0;
            for (int j = 0; j < size - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    double temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = 1;
                }
            }
            if (swapped == 0) {
                break;
            }
        }
        long stopTime = System.nanoTime();
        TimeExectionTextBox.setText(String.valueOf((stopTime - startTime) / 1000000.0) + " milliseconds");
    }
    public void insertionSortDouble(double arr[], int size) {
        long startTime = System.nanoTime();
        for (int j = 1; j < size; j++) {
            double key = arr[j];
            int i = j-1;
            while ( (i > -1) && ( arr [i] > key ) ) {
                arr [i+1] = arr [i];
                i--;
            }
            arr[i+1] = key;
        }
        long stopTime = System.nanoTime();
        TimeExectionTextBox.setText(String.valueOf((stopTime - startTime) / 1000000.0) + " milliseconds");
    }

    public void bubbleSortInt(int arr[], int size) {
        long startTime = System.nanoTime();
        for (int i = 0; i < size - 1; i++) {
            int swapped = 0;
            for (int j = 0; j < size - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = 1;
                }
            }
            if (swapped == 0) {
                break;
            }
        }
        long stopTime = System.nanoTime();
        TimeExectionTextBox.setText(String.valueOf((stopTime - startTime) / 1000000.0) + " milliseconds");
    }
    public void insertionSortInt(int arr[], int size) {
        long startTime = System.nanoTime();
        for (int j = 1; j < size; j++) {
            int key = arr[j];
            int i = j-1;
            while ( (i > -1) && ( arr [i] > key ) ) {
                arr [i+1] = arr [i];
                i--;
            }
            arr[i+1] = key;
        }
        long stopTime = System.nanoTime();
        TimeExectionTextBox.setText(String.valueOf((stopTime - startTime) / 1000000.0) + " milliseconds");
    }
    public void selectionSortInt(int arr[], int size) {
        long startTime = System.nanoTime();
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
        long stopTime = System.nanoTime();
        TimeExectionTextBox.setText(String.valueOf((stopTime - startTime) / 1000000.0) + " milliseconds");
    }

    public void bubbleSortFloat(float arr[], int size) {
        long startTime = System.nanoTime();
        for (int i = 0; i < size - 1; i++) {
            int swapped = 0;
            for (int j = 0; j < size - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    float temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = 1;
                }
            }
            if (swapped == 0) {
                break;
            }
        }
        long stopTime = System.nanoTime();
        TimeExectionTextBox.setText(String.valueOf((stopTime - startTime) / 1000000.0) + " milliseconds");
    }
    public void insertionSortFloat(float arr[], int size) {
        long startTime = System.nanoTime();
        for (int j = 1; j < size; j++) {
            float key = arr[j];
            int i = j-1;
            while ( (i > -1) && ( arr [i] > key ) ) {
                arr [i+1] = arr [i];
                i--;
            }
            arr[i+1] = key;
        }
        long stopTime = System.nanoTime();
        TimeExectionTextBox.setText(String.valueOf((stopTime - startTime) / 1000000.0) + " milliseconds");
    }
    public void selectionSortFloat(float arr[], int size) {
        long startTime = System.nanoTime();
        for (int i = 0; i < size - 1; i++) {
            int min_index = i;
            for (int j = i + 1; j < size; j++) {
                if (arr[j] < arr[min_index])
                    min_index = j;
            }
            float temp = arr[min_index];
            arr[min_index] = arr[i];
            arr[i] = temp;
        }
        long stopTime = System.nanoTime();
        TimeExectionTextBox.setText(String.valueOf((stopTime - startTime) / 1000000.0) + " milliseconds");
    }


    public void obtainUserInput()
    {
        System.out.println("Log In Clicked");
    }
    /*
        Populates three arrays with random values
     */
    public static void CreateData(int[] intData, double[] doubleData, float[] floatData) throws IOException {
        //create 3 datasets of integer, doubles, and floats worth 100,000 lines
//        int[] intData = new int[100000];
//        double[] doubleData = new double[100000];
//        float[] floatData = new float[100000];

        //create a map and clear it each time.  use it to search if there was already that number made, and if it was, make a new one.
        //key and value are the same thing
        Hashtable<Double, Double> doubleTable = new Hashtable<Double, Double>();
        Hashtable<Float, Float> floatTable = new Hashtable<Float, Float>();

        //randomly fill numbers
        for (int randIntIter = 0; randIntIter < 100000; randIntIter++) {    //ints
            intData[randIntIter] = randIntIter;     //0 to 100,000
        }
        for (int randDoubleIter = 0; randDoubleIter < 100000; randDoubleIter++) {    //doubles
            double dVal = (Math.random() * (100001) + 0);
            if (doubleTable.containsKey(dVal)) {
                dVal = (Math.random() * (100001) + 0);
            }
            doubleTable.put(dVal, dVal);
            doubleData[randDoubleIter] = dVal;
        }
        for (int randFloatIter = 0; randFloatIter < 100000; randFloatIter++) {    //floats
            double tempDoubleVal = (Math.random() * (100001));
            float fVal = (float) tempDoubleVal;
            if (floatTable.containsKey(fVal)) {
                tempDoubleVal = (Math.random() * (100001));
                fVal = (float) tempDoubleVal;
            }
            floatTable.put(fVal, fVal);
            floatData[randFloatIter] = fVal;
        }

        SendToFile(intData, doubleData, floatData); //made me automatically fix an error with this?
    }

    /*
       Creates a txt file with all random values of the array
     */
    public static void SendToFile(int[] intFileData, double[] doubleFileData, float[] floatFileData) throws IOException {
        //write to a csv file
        FileWriter csvFile = new FileWriter("Data Entries.txt");
        csvFile.append("Int");
        csvFile.append(",");
        csvFile.append("Double");
        csvFile.append(",");
        csvFile.append("Float");
        csvFile.append("\n");

        for (int writeIter = 0; writeIter < 100000; writeIter++) {
            csvFile.append(Integer.toString(intFileData[writeIter]));
            csvFile.append(",");
            csvFile.append(Double.toString(doubleFileData[writeIter]));
            csvFile.append(",");
            csvFile.append(Float.toString(floatFileData[writeIter]));
            csvFile.append("\n");
            //System.out.println(intFileData[writeIter]);
        }

        csvFile.flush();
        csvFile.close();    //important to do these so that all the data will be managed
        //without this, I lost 70 lines of data.
    }
    //use templates to make these functions instead of making them 3 times
    public static Hashtable<Double, Double> RetrieveDoubleFromFile(String howMany, double[] doubleFileData) throws IOException {
        Hashtable<Double, Double> pickStoreDouble = new Hashtable<Double, Double>();
        double pickDoub;
        Random rand = new Random();
        int intHowMany = Integer.parseInt(howMany);
        for (int retrieve = 0; retrieve < intHowMany; retrieve++) {
            pickDoub = rand.nextDouble() * 100000.00;
            //random int, NO repeats
            while (pickStoreDouble.containsKey(pickDoub)) {
                pickDoub = rand.nextDouble() * 100000.00;
            }
            pickStoreDouble.put(pickDoub, pickDoub);
        }
        return pickStoreDouble;

    }
    public static Hashtable<Float, Float> RetrieveFloatFromFile(String howMany, float[] floatFileData) throws IOException {
        Hashtable<Float, Float> pickStoreFloat = new Hashtable<Float, Float>();
        float pickFloat;
        Random rand = new Random();
        int intHowMany = Integer.parseInt(howMany);
        for (int retrieve = 0; retrieve < intHowMany; retrieve++) {
            pickFloat = rand.nextFloat() * 100000f;
            //random int, NO repeats
            while (pickStoreFloat.containsKey(pickFloat)) {
                pickFloat = rand.nextFloat() * 100000f;
            }
            pickStoreFloat.put(pickFloat, pickFloat);
        }
        return pickStoreFloat;

    }
    public static Hashtable<Integer, Integer> RetrieveIntFromFile(String howMany, int[] intFileData) throws IOException {
        //retrieve random data from the csv file depending on how many data inputs they want to get
        //int whichData is the answer of 1,2,3: corresponding to data as int, double, float
        //int howMany is how many elements of data will we be using
        //      retrieve the data randomly.
        int pickInt;
        Hashtable<Integer, Integer> pickStoreInt = new Hashtable<Integer, Integer>();
        Random rand = new Random();
        int intHowMany = Integer.parseInt(howMany);
        //iterate through the map and retrieve the elements at those indexes
        //  from the data arrays by accessing each iterator in the map
        for (int retrieve = 0; retrieve < intHowMany; retrieve++) {
            pickInt = rand.nextInt(100000);
            //random int, NO repeats
            while (pickStoreInt.containsKey(pickInt)) {
                pickInt = rand.nextInt(100000);
            }
            pickStoreInt.put(pickInt, pickInt);
        }
        return pickStoreInt;
    }

    /*
        Method will load animation
     */
    public void loadAnimationSelectionSort(ActionEvent actionEvent) throws IOException {
        //javafx.scene.SubScene scene = FXMLLoader.load(getClass().getResource("Hashtable.fxml"));
        //BorderPane pane = FXMLLoader.load(getClass().getResource("Hashtable.fxml"));


        // This code is used to pass into the animation JavaFx code to return back to the main Sort Page
        Parent newSceneParetn = FXMLLoader.load(getClass().getResource("SelectionSort.fxml"));
        // This line gets the Stage information
        Stage windowAnimation = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        loadAnimationWindowSelectionSort(windowAnimation);

    }
    public void loadAnimationWindowSelectionSort(Stage primaryStage) throws IOException{
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
        CreateSelectionPathSelectionSort(arrRecs[0], xLocations[4], arrRecs[0], group1);
        CreateSelectionPathSelectionSort(arrRecs[4], xLocations[0], arrRecs[4], group1);
//part 2
        CreateSelectionPathSelectionSort(arrRecs[1], xLocations[3], arrRecs[1], group2);
        CreateSelectionPathSelectionSort(arrRecs[3], xLocations[1], arrRecs[3], group2);
//part 3
        CreateSelectionPathSelectionSort(arrRecs[2], xLocations[3], arrRecs[2], group3);
        CreateSelectionPathSelectionSort(arrRecs[3], xLocations[2], arrRecs[1], group3);
//part 4
        CreateSelectionPathSelectionSort(arrRecs[3], xLocations[4], arrRecs[2], group4);
        CreateSelectionPathSelectionSort(arrRecs[4], xLocations[3], arrRecs[0], group4);

        seqTranSelection.getChildren().addAll(startFade, group1, group2, group3, group4, endFade);
        seqTranSelection.setCycleCount(Timeline.INDEFINITE);
        seqTranSelection.play();
        Button button = new Button("Back");

        //final steps
        root.getChildren().addAll(primaryVbox, recGroup);
        root.getChildren().add(button);
        Scene firstSort = new Scene(root, 1700, 850);
        primaryStage.setTitle("Box Mover Title");
        primaryStage.setScene(firstSort);
        primaryStage.show();
        // If this button is pressed, will return back to the main page
        button.setOnAction(e -> {
            Parent newSceneParetn = null;
            try {
                newSceneParetn = FXMLLoader.load(getClass().getResource("SelectionSort.fxml"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            Scene newScene = new Scene(newSceneParetn);
            // This line gets the Stage information
            primaryStage.setScene(newScene);
            primaryStage.show();
        });
    }
    public static void CreateSelectionPathSelectionSort(Rectangle rectangleStart, Double xLocation, Rectangle rectangleNode, ParallelTransition groupNum) {
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

}