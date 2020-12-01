package sample;

import java.io.IOException; //added through an automatic fix
import java.util.Random;
import java.util.Hashtable;
import java.io.FileWriter;
public class Random_Data_Generator {
    public static void main(String[] args) throws IOException {

    }
    public static void CreateData() throws IOException {
        //create 3 datasets of integer, doubles, and floats worth 100,000 lines
        int[] intData = new int[100000];
        double[] doubleData = new double[100000];
        float[] floatData = new float[100000];

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

    public static void SendToFile(int[] intFileData, double[] doubleFileData, float[] floatFileData) throws IOException {
        //write to a csv file
        FileWriter csvFile = new FileWriter("Data Entries");
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
    public static void RetrieveDoubleFromFile(int howMany, double[] doubleFileData) throws IOException {
        Hashtable<Double, Double> pickStoreDouble = new Hashtable<Double, Double>();
        double pickDoub;
        Random rand = new Random();
        for (int retrieve = 0; retrieve < howMany; retrieve++) {
            pickDoub = rand.nextDouble() * 100000.00;
            //random int, NO repeats
            while (pickStoreDouble.containsKey(pickDoub)) {
                pickDoub = rand.nextDouble() * 100000.00;
            }
            pickStoreDouble.put(pickDoub, pickDoub);
        }

    }
    public static void RetrieveFloatFromFile(int howMany, float[] floatFileData) throws IOException {
        Hashtable<Float, Float> pickStoreFloat = new Hashtable<Float, Float>();
        float pickFloat;
        Random rand = new Random();
        for (int retrieve = 0; retrieve < howMany; retrieve++) {
            pickFloat = rand.nextFloat() * 100000f;
            //random int, NO repeats
            while (pickStoreFloat.containsKey(pickFloat)) {
                pickFloat = rand.nextFloat() * 100000f;
            }
            pickStoreFloat.put(pickFloat, pickFloat);
        }

    }
    public static void RetrieveIntFromFile(int howMany, int[] intFileData) throws IOException {
        //retrieve random data from the csv file depending on how many data inputs they want to get
        //int whichData is the answer of 1,2,3: corresponding to data as int, double, float
        //int howMany is how many elements of data will we be using
        //      retrieve the data randomly.
        int pickInt;
        Hashtable<Integer, Integer> pickStoreInt = new Hashtable<Integer, Integer>();
        Random rand = new Random();
        //iterate through the map and retrieve the elements at those indexes
        //  from the data arrays by accessing each iterator in the map
        for (int retrieve = 0; retrieve < howMany; retrieve++) {
            pickInt = rand.nextInt(100000);
            //random int, NO repeats
            while (pickStoreInt.containsKey(pickInt)) {
                pickInt = rand.nextInt(100000);
            }
            pickStoreInt.put(pickInt, pickInt);
        }
    }
}
//the data is stored, now it's a matter of retrieving it