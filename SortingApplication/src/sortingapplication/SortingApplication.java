/*
 * 
 *  Class: Algorithms: Sorting and Searching
 *
 */
/**
 * @author Wanderley de Souza Alencar
 */
package sortingapplication;

import java.util.Date;
import java.util.Random;

public class SortingApplication {

    public static void selectionSort(Table paramTable, int paramNumberOfElements) {

    }

    public static void insertionSort() {
    }

    public static void shellSort() {
    }

    public static void pigeonholeSort() {
    }

    public static void bucketSort() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //
        // The main application should be inserted here..
        //
        int i,
                numberOfRecordsDesired, // Number of record that... you want to generate
                numberOfRecordsGenerated, // effectively generated to the .csv file
                numberOfRecordsLoaded, // recovered from the .csv file
                numberOfRecordsPrinted;     // printed (for checking) from the table
        String applicationPath,
                auxiliaryString;
        Random randomNumber;               // an auxiliary variable to random generation...
        IdentificationDocument applicationDocument;
        PersonalRecord applicationRecord;
        Table applicationTable;
        Date birthDay;

        PigeonholeSort pigeonholeSort = new PigeonholeSort();
        TimerCounter timerCounter = new TimerCounter();

        //
        // The path of the application... set up for your use
        //
        applicationPath = "";
        applicationTable = new Table();
        applicationRecord = new PersonalRecord();
        applicationDocument = new IdentificationDocument();
        birthDay = new Date();
        randomNumber = new Random();

        numberOfRecordsDesired = 50000;
        System.out.println("Generating <" + numberOfRecordsDesired + "> randomly records to form the table.");
        numberOfRecordsGenerated = applicationTable.randomGenerateToCSV(applicationPath + "TableTeste.csv", numberOfRecordsDesired);
        if (numberOfRecordsGenerated != 0) {
            System.out.println("Loading the stored record from  <" + "TableTeste.csv" + "> to the table.");
            numberOfRecordsLoaded = (int) applicationTable.loadFromCSV(applicationPath + "TableTeste.csv", 0, (numberOfRecordsGenerated - 1));
            if (numberOfRecordsLoaded == numberOfRecordsGenerated) {
                /*
                System.out.println("Printing records from the table.");
                numberOfRecordsPrinted = applicationTable.print(0, (numberOfRecordsGenerated - 1));
                if (numberOfRecordsPrinted == numberOfRecordsLoaded) {
                    //System.out.println("All <" + numberOfRecordsPrinted + "> records were printed.");
                    auxiliaryString = (applicationTable.isSorted()) ? "YES" : "NO";
                    System.out.println("The records are in order by primary key?: " + auxiliaryString);
                } else {
                    System.out.println("Unfortunately, there are records that have not been printed.");
                    System.out.println("Please check the parameters entered for the priting process.");
                }
                 */
                timerCounter.setStartTime();
                pigeonholeSort.sortTable(applicationTable);
                timerCounter.setEndTime();

                System.out.println("Printing records from the table. /2");
                numberOfRecordsPrinted = applicationTable.print(0, (numberOfRecordsGenerated - 1));
                if (numberOfRecordsPrinted == numberOfRecordsLoaded) {
                    System.out.println("All <" + numberOfRecordsPrinted + "> records were printed.");
                    auxiliaryString = (applicationTable.isSorted()) ? "YES" : "NO";
                    System.out.println("The records are in order by primary key?: " + auxiliaryString);

                    System.out.printf("Tempo decorrido em millis: %.2f", (double) timerCounter.getDiffMillis());
                    System.out.println("");
                    System.out.printf("Tempo decorrido em segundos: %.2f", (double) timerCounter.getDiffSeconds());
                    System.out.println("");
                    System.out.printf("Início: " + timerCounter.getStartTime());
                    System.out.println("");
                    System.out.printf("Fim: " + timerCounter.getEndTime());
                    System.out.println("");
                    System.out.printf("Média: " + timerCounter.getMediumTime(numberOfRecordsLoaded));
                    System.out.println("");
                } else {
                    System.out.println("Unfortunately, there are records that have not been printed.");
                    System.out.println("Please check the parameters entered for the priting process.");
                }
            } else {
                System.out.println("Unfortunately there are records that have not been uploaded to the table (from .csv file).");
                System.out.println("Please check the parameters entered for the loading process.");
            }
        } else {
            System.out.println("Unfortunately no record can be generated.");
            System.out.println("Please check the parameters entered for the generation process.");
        }

        /*
        applicationTable.exchangeRecords(0, 1);
        applicationTable.print(0, 4);
        applicationTable.saveToCSV(applicationPath + "TableTeste.csv", 0, 4);
         */
        pigeonholeSort.sortTable(applicationTable);

    }

}
