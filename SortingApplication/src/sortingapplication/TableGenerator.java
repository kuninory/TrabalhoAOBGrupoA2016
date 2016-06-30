package sortingapplication;

import java.util.Date;
import java.util.Random;

/**
 * This class represents a Random Table Generator. It creates a new Table which 
 * size is based on a given amount of records.
 *
 * @author Wanderley de Souza Alencar
 * @author eric
 */
public class TableGenerator {

    int numberOfRecordsDesired, // Number of record that... you want to generate
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

    /**
     * Constructor.
     *
     * @param numberOfRecordsDesired the number of records that the table is
     * supposed to hold.
     */
    public TableGenerator(int numberOfRecordsDesired) {
        this.numberOfRecordsDesired = numberOfRecordsDesired;
    }

    /**
     * Generates the random table.
     *
     * @return Table a new table
     */
    public Table generate() {

        applicationPath = "";
        applicationTable = new Table();
        applicationRecord = new PersonalRecord();
        applicationDocument = new IdentificationDocument();
        birthDay = new Date();
        randomNumber = new Random(); 

        System.out.println(
                "Generating <" + numberOfRecordsDesired + "> randomly records to form the table.");
        numberOfRecordsGenerated = applicationTable.randomGenerateToCSV(applicationPath + "TableTeste.csv", numberOfRecordsDesired);
        if (numberOfRecordsGenerated
                != 0) {
            System.out.println("Loading the stored record from  <" + "TableTeste.csv" + "> to the table.");
            numberOfRecordsLoaded = (int) applicationTable.loadFromCSV(applicationPath + "TableTeste.csv", 0, (numberOfRecordsGenerated - 1));
            if (numberOfRecordsLoaded == numberOfRecordsGenerated) {
                System.out.println("Printing records from the table.");
                numberOfRecordsPrinted = applicationTable.print(0, (numberOfRecordsGenerated - 1));
                if (numberOfRecordsPrinted == numberOfRecordsLoaded) {
                    System.out.println("All <" + numberOfRecordsPrinted + "> records were printed.");
                    auxiliaryString = (applicationTable.isSorted()) ? "YES" : "NO";
                    System.out.println("The records are in order by primary key?: " + auxiliaryString);
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

        applicationTable.exchangeRecords(
                0, 1);
        applicationTable.print(
                0, applicationTable.getNumberOfRecords() - 1);
        applicationTable.saveToCSV(applicationPath
                + "TableTeste.csv", 0, applicationTable.getNumberOfRecords() - 1);

        return applicationTable;
    }
}
