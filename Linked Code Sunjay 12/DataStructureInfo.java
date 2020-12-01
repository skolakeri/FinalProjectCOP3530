package sample;

import javafx.event.ActionEvent;
import javafx.scene.SubScene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Random;
import java.util.TreeSet;

public class DataStructureInfo {
    public BorderPane SubSceneBorderPane;
    public Text numberSorted;
    public javafx.scene.SubScene SubScene;
    public Button ShowSubScene;
    public Text TimeExectionTextBox;
    public Text nameOfAlgorithmn;
    public TextArea elementsInDataStructure;
}

//    Hashtable<Integer, Integer> hashTableInt = new Hashtable<Integer, Integer>();
//    Hashtable<Double, Double> hashtableDouble = new Hashtable<Double, Double>();
//    Hashtable<Float, Float> hashtableFloat = new Hashtable<Float, Float>();
//
//    TreeSet<Integer> treeInt = new TreeSet<Integer>();
//    TreeSet<Double> treeDouble = new TreeSet<Double>();
//    TreeSet<Float> treeFloat = new TreeSet<Float>();
//
//
//    //Controller.DATASTRUCTURE datastructure;
//    //Controller.OPERATION operation;
//    //Controller.TYPE type;
//
//    public void backToInputNumber(ActionEvent actionEvent) {
//
//    }
//
//    public void loadAnimation(ActionEvent actionEvent) {
//    }
//    /*
//        This method is called when the user inputs a number of values to be sorted
//     */
//    public void initData(TextField text, Controller.DATASTRUCTURE datastructure, Controller.OPERATION operation, Controller.TYPE type) throws IOException {
//        //create 3 datasets of integer, doubles, and floats worth 100,000 lines
//        int[] intData = new int[100000];
//        double[] doubleData = new double[100000];
//        float[] floatData = new float[100000];
//        // Populates the above array with random values
//        CreateData(intData, doubleData, floatData);
//        // Sets the numberSorted Text to the number sorted based off user input
//        numberSorted.setText(text.getText());
//        this.operation = operation;
//        this.datastructure = datastructure;
//        this.type = type;
//        int countHashTable = 0;
//        int countTree = 0;
//
//        if(datastructure == Controller.DATASTRUCTURE.TREE)
//        {
//            if(type == Controller.TYPE.INT)
//            {
//                if(operation == Controller.OPERATION.ADD)
//                {
//                    int rnd = new Random().nextInt(intData.length);
//                    treeInt.add(intData[rnd]);
//                    String string = String.valueOf(intData[rnd]);
//                    elementsInDataStructure.setText(elementsInDataStructure.getText() + "\n" + String.valueOf(countTree) + " | " + string);
//                    countTree++;
//                }
//                if(operation == Controller.OPERATION.DELETE)
//                {
//                    int rnd = new Random().nextInt(treeInt.size());
//                    Iterator itr = treeInt.iterator();
//                    int val = 0;
//                    int count = 0;
//                    while (itr.hasNext())
//                    {
//                        val = (int) itr.next();
//                        if(count == rnd)
//                        {
//                            break;
//                        }
//                        count++;
//                    }
//                    treeInt.remove(val);
//                    // Remove it from the window
//                }
//                if(operation == Controller.OPERATION.SEARCH)
//                {
//                    // Add to data struture
//                }
//            }
//            if(type == Controller.TYPE.DOUBLE)
//            {
//                if(operation == Controller.OPERATION.ADD)
//                {
//                    int rnd = new Random().nextInt(doubleData.length);
//                    treeDouble.add(doubleData[rnd]);
//                    String string = String.valueOf(doubleData[rnd]);
//                    elementsInDataStructure.setText(elementsInDataStructure.getText() + "\n" + String.valueOf(countTree) + " | " + string);
//                    countTree++;
//                }
//                if(operation == Controller.OPERATION.DELETE)
//                {
//                    int rnd = new Random().nextInt(treeDouble.size());
//                    Iterator itr = treeDouble.iterator();
//                    double val = 0;
//                    int count = 0;
//                    while (itr.hasNext())
//                    {
//                        val = (double) itr.next();
//                        if(count == rnd)
//                        {
//                            break;
//                        }
//                        count++;
//                    }
//                    treeDouble.remove(val);
//                    // Remove it from the window
//                }
//                if(operation == Controller.OPERATION.SEARCH)
//                {
//                    // Add to data struture
//                }
//            }
//            if(type == Controller.TYPE.FLOAT)
//            {
//                if(operation == Controller.OPERATION.ADD)
//                {
//                    int rnd = new Random().nextInt(floatData.length);
//                    treeFloat.add(floatData[rnd]);
//                    String string = String.valueOf(floatData[rnd]);
//                    elementsInDataStructure.setText(elementsInDataStructure.getText() + "\n" + String.valueOf(countTree) + " | " + string);
//                    countTree++;
//                }
//                if(operation == Controller.OPERATION.DELETE)
//                {
//                    int rnd = new Random().nextInt(treeFloat.size());
//                    Iterator itr = treeFloat.iterator();
//                    float val = 0;
//                    int count = 0;
//                    while (itr.hasNext())
//                    {
//                        val = (float) itr.next();
//                        if(count == rnd)
//                        {
//                            break;
//                        }
//                        count++;
//                    }
//                    treeFloat.remove(val);
//                }
//                if(operation == Controller.OPERATION.SEARCH)
//                {
//                    // Add to data struture
//                }
//            }
//
//        }
//        if(datastructure == Controller.DATASTRUCTURE.HASHTABLE)
//        {
//            if(type == Controller.TYPE.INT)
//            {
//                if(operation == Controller.OPERATION.ADD)
//                {
//                    int rnd = new Random().nextInt(intData.length);
//                    hashTableInt.put(intData[rnd], intData[rnd]);
//                    String string = String.valueOf(intData[rnd]);
//                    elementsInDataStructure.setText(elementsInDataStructure.getText() + "\n" + String.valueOf(countHashTable) + " | " + string);
//                }
//                if(operation == Controller.OPERATION.DELETE)
//                {
//
//                    //String string = String.valueOf(intData[rnd]);
//                    //elementsInDataStructure.setText(elementsInDataStructure.getText() + "\n" + String.valueOf(countHashTable) + " | " + string);
//                }
//                if(operation == Controller.OPERATION.SEARCH)
//                {
//                    // Add to data struture
//                }
//            }
//            if(type == Controller.TYPE.DOUBLE)
//            {
//                if(operation == Controller.OPERATION.ADD)
//                {
//                    int rnd = new Random().nextInt(doubleData.length);
//                    hashtableDouble.put(doubleData[rnd], doubleData[rnd]);
//                    String string = String.valueOf(doubleData[rnd]);
//                    elementsInDataStructure.setText(elementsInDataStructure.getText() + "\n" + String.valueOf(countHashTable) + " | " + string);
//                }
//                if(operation == Controller.OPERATION.DELETE)
//                {
//                    int rnd = new Random().nextInt(hashtableDouble.size());
//                    hashtableDouble.remove((double) rnd);
//                }
//                if(operation == Controller.OPERATION.SEARCH)
//                {
//                    // Add to data struture
//                }
//            }
//            if(type == Controller.TYPE.FLOAT)
//            {
//                if(operation == Controller.OPERATION.ADD)
//                {
//                    int rnd = new Random().nextInt(floatData.length);
//                    hashtableFloat.put(floatData[rnd], floatData[rnd]);
//                    String string = String.valueOf(floatData[rnd]);
//                    elementsInDataStructure.setText(elementsInDataStructure.getText() + "\n" + String.valueOf(countHashTable) + " | " + string);
//                }
//                if(operation == Controller.OPERATION.DELETE)
//                {
//                    // Add to data struture
//                }
//                if(operation == Controller.OPERATION.SEARCH)
//                {
//                    // Add to data struture
//                }
//            }
//        }
//
//
//    }
//    public static void CreateData(int[] intData, double[] doubleData, float[] floatData) throws IOException {
//        //create 3 datasets of integer, doubles, and floats worth 100,000 lines
////        int[] intData = new int[100000];
////        double[] doubleData = new double[100000];
////        float[] floatData = new float[100000];
//
//        //create a map and clear it each time.  use it to search if there was already that number made, and if it was, make a new one.
//        //key and value are the same thing
//        Hashtable<Double, Double> doubleTable = new Hashtable<Double, Double>();
//        Hashtable<Float, Float> floatTable = new Hashtable<Float, Float>();
//
//        //randomly fill numbers
//        for (int randIntIter = 0; randIntIter < 100000; randIntIter++) {    //ints
//            intData[randIntIter] = randIntIter;     //0 to 100,000
//        }
//        for (int randDoubleIter = 0; randDoubleIter < 100000; randDoubleIter++) {    //doubles
//            double dVal = (Math.random() * (100001) + 0);
//            if (doubleTable.containsKey(dVal)) {
//                dVal = (Math.random() * (100001) + 0);
//            }
//            doubleTable.put(dVal, dVal);
//            doubleData[randDoubleIter] = dVal;
//        }
//        for (int randFloatIter = 0; randFloatIter < 100000; randFloatIter++) {    //floats
//            double tempDoubleVal = (Math.random() * (100001));
//            float fVal = (float) tempDoubleVal;
//            if (floatTable.containsKey(fVal)) {
//                tempDoubleVal = (Math.random() * (100001));
//                fVal = (float) tempDoubleVal;
//            }
//            floatTable.put(fVal, fVal);
//            floatData[randFloatIter] = fVal;
//        }
//
//        SendToFile(intData, doubleData, floatData); //made me automatically fix an error with this?
//
//    }
//
//    /*
//       Creates a txt file with all random values of the array
//     */
//    public static void SendToFile(int[] intFileData, double[] doubleFileData, float[] floatFileData) throws IOException {
//        //write to a csv file
//        FileWriter csvFile = new FileWriter("Data Entries.txt");
//        csvFile.append("Int");
//        csvFile.append(",");
//        csvFile.append("Double");
//        csvFile.append(",");
//        csvFile.append("Float");
//        csvFile.append("\n");
//
//        for (int writeIter = 0; writeIter < 100000; writeIter++) {
//            csvFile.append(Integer.toString(intFileData[writeIter]));
//            csvFile.append(",");
//            csvFile.append(Double.toString(doubleFileData[writeIter]));
//            csvFile.append(",");
//            csvFile.append(Float.toString(floatFileData[writeIter]));
//            csvFile.append("\n");
//            //System.out.println(intFileData[writeIter]);
//        }
//
//        csvFile.flush();
//        csvFile.close();    //important to do these so that all the data will be managed
//        //without this, I lost 70 lines of data.
//    }
//
//}
