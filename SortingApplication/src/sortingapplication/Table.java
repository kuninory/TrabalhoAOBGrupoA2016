/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortingapplication;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Random;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Class:       Table
 * Description: It is the table that stores the collection of information about person  
 * @author      Wanderley de Souza Alencar (june, 2016)
 */
public class Table {

    private final int MAXIMUM_SIZE = 50000;
    private int numberOfRecords;
    private PersonalRecord[] recordSet = new PersonalRecord[MAXIMUM_SIZE];

    /**
     * Method.....: Table Input......: nothing Output.....: nothing Description:
     * Initializes a Table object with ZERO records Observation:
     */
    public void Table() {
        this.numberOfRecords = 0;
    }

    /**
     * @return the maximum number of records allowed in the table
     */
    public int getMAXIMUM_SIZE() {
        return (this.MAXIMUM_SIZE);
    }

    /**
     * @return the number of records
     */
    public int getNumberOfRecords() {
        return (this.numberOfRecords);
    }

    /**
     * @param paramNumberOfRecords the numberOfRecords to set
     */
    public void setNumberOfRecords(int paramNumberOfRecords) {
        if ((paramNumberOfRecords > -1) && (paramNumberOfRecords <= this.MAXIMUM_SIZE)) {
            this.numberOfRecords = paramNumberOfRecords;
        }
    }

    /**
     * @return the record set
     */
    public PersonalRecord[] getRecordSet() {
        return (this.recordSet);
    }

    /**
     * @param paramRecordSet the record set
     */
    public void setRecordSet(PersonalRecord[] paramRecordSet) {
        this.recordSet = paramRecordSet;
    }

    /**
     * Method.....: getRecord Input......: paramPosition - position of the
     * desired record Output.....: the desired record or NULL Description: If is
     * possible, recovers the record of the desired position. Otherwise, return
     * NULL. Observation:
     */
    /**
     * @param paramPosition the desired position
     * @return If is possible, return the record in the requested position.
     * Otherwise, return NULL.
     */
    public PersonalRecord getRecord(int paramPosition) {
        if ((paramPosition > -1) && (paramPosition < getNumberOfRecords())) {
            return (this.recordSet[paramPosition]);
        } else {
            return (null);
        }
    }

    /**
     * Method.....: setRecord Input......: paramPosition - position in which the
     * record should be inserted Description: If is correct, stores the record
     * in the desired position Otherwise, do not anything. Observation:
     */
    /**
     * @param paramRecord the record that will be stored
     * @param paramPosition the desired position
     */
    public void setRecord(PersonalRecord paramRecord, int paramPosition) {
        if ((paramPosition > -1) && (paramPosition < getNumberOfRecords())) {
            this.recordSet[paramPosition] = paramRecord;
        }
    }

    /**
     * Method.....: addRecord Input......: paramRecord - a record that will be
     * inserted Output.....: true: operation OK, false: there is an error
     * Description: Add a new record in the end of the table Observation:
     */
    /**
     * @param paramRecord the record that will be inserted in the table (at end)
     * @return true, if the operation was done or false, if there is an error
     */
    public boolean addRecord(PersonalRecord paramRecord) {

        if ((this.getNumberOfRecords() + 1) <= this.getMAXIMUM_SIZE()) {
            this.setNumberOfRecords(this.numberOfRecords + 1);
            this.setRecord(paramRecord, (this.numberOfRecords - 1));
            return (true);
        } else {
            return (false);
        }
    }

    /**
     * Method.....: compareRecordKey Input......: paramRecord1 - first record
     * for key comparison paramRecord2 - second record for key comparison
     * Output.....: -1, if key1 LESS THAN key2 0, if key1 EQUAL TO key2 +1, if
     * key1 GREATER THAN key2 Description: Compares the keys of the records
     * Observation:
     */
    /**
     * @param paramRecord1 the index of the first record for key comparison
     * @param paramRecord2 the index of the second record for key comparison
     * @return -1, 0 or +1, for key1 LESS THAN, EQUAL TO, GREATER THAN key2,
     * respectively
     */
    public int compareRecordKey(int paramRecord1, int paramRecord2) {

        if (this.recordSet[paramRecord1].getPersonalDocument().getType() < this.recordSet[paramRecord2].getPersonalDocument().getType()) {
            //
            // If the TYPE of the first record is less than the TYPE of the second record, then ...
            //
            return (-1);
        }
        if (this.recordSet[paramRecord1].getPersonalDocument().getType() > this.recordSet[paramRecord2].getPersonalDocument().getType()) {
            //
            // If the TYPE of the first record is greater than the TYPE of the second record, then ...
            //
            return (+1);
        }
        if (this.recordSet[paramRecord1].getPersonalDocument().getType() == this.recordSet[paramRecord2].getPersonalDocument().getType()) {
            //
            // If the TYPE of the first record is equal to the TYPE of the second record, then ... 
            //    it is necessary to compare the NUMBERS...
            //
            if (this.recordSet[paramRecord1].getPersonalDocument().getNumber() < this.recordSet[paramRecord2].getPersonalDocument().getNumber()) {
                //
                // If the NUMBER of the first record is less than the NUMBER of the second record, then ...
                //
                return (-1);
            }
            if (this.recordSet[paramRecord1].getPersonalDocument().getNumber() > this.recordSet[paramRecord2].getPersonalDocument().getNumber()) {
                //
                // If the NUMBER of the first record is greater than the NUMBER of the second record, then ...
                //
                return (+1);
            }
            if (this.recordSet[paramRecord1].getPersonalDocument().getNumber() == this.recordSet[paramRecord2].getPersonalDocument().getNumber()) {
                //
                // If the NUMBER of the first record is equal to the NUMBER of the second record, then ...    
                //    it is necessary to compare the COUNTRY CODES...
                //
                if (this.recordSet[paramRecord1].getPersonalDocument().getOriginCountryCode() < this.recordSet[paramRecord2].getPersonalDocument().getOriginCountryCode()) {
                    //
                    // If the ORIGIN COUNTRY CODE of the first record is less than the ORIGIN COUNTRY CODE of the second record, then ...
                    //
                    return (-1);
                }
                if (this.recordSet[paramRecord1].getPersonalDocument().getOriginCountryCode() > this.recordSet[paramRecord2].getPersonalDocument().getOriginCountryCode()) {
                    //
                    // If the ORIGIN COUNTRY CODE of the first record is greater than the ORIGIN COUNTRY CODE of the second record, then ...
                    //
                    return (+1);
                }
                if (this.recordSet[paramRecord1].getPersonalDocument().getOriginCountryCode() == this.recordSet[paramRecord2].getPersonalDocument().getOriginCountryCode()) {
                    //
                    // If the ORIGIN COUNTRY CODE of the first record is equal to the ORIGIN COUNTRY CODE of the second record, then ...
                    //    It is an error, because the key should be a primary key... 
                    return (0);
                }
            }
        }
        // 
        // this code is never reached, but it is necessary by constraint of the Java.
        //
        return (0);
    }

    /**
     * Method.....: exchangeRecords Input......: paramRecord1 - index of the
     * first record that will be exchanged paramRecord2 - index of the second
     * record that will be exchanged Output.....: nothing Description: Exchange
     * the records in the positions specified Observation:
     */
    /**
     * @param paramRecord1 the index of the first record that will be exchanged
     * @param paramRecord2 index of the second record that will be exchanged
     */
    public void exchangeRecords(int paramRecord1, int paramRecord2) {
        PersonalRecord auxiliaryElement;

        auxiliaryElement = this.recordSet[paramRecord1];
        this.setRecord(this.recordSet[paramRecord2], paramRecord1);
        this.setRecord(auxiliaryElement, paramRecord2);
    }

    /**
     * Method.....: isSorted Input......: nothing Output.....: true: the table
     * records are ordered (strictly increasing) by the primary key false:
     * otherwise Description: Check if the table records are ordered by the
     * primary key Observation:
     */
    /**
     *
     * @return true: if the table records are ordered (strictly increasing) by
     * the primary key
     */
    public boolean isSorted() {
        int i;
        //
        // Test whether the table entries are in (strict increasing) order by the primary key
        //
        for (i = 1; (i < this.getNumberOfRecords()); i++) {
            if ((this.compareRecordKey(i - 1, i)) == +1) {
                return (false);
            }
        }
        return (true);
    }

    /**
     * Method.....: storeRecord Input......: paramRecord - record that will be
     * stored in the table, if possible paramPosition - position that the record
     * will be inserted Output.....: true: insertion held; false: failure to
     * insert Description: Initializes a Table object Observation:
     */
    /**
     * @param paramRecord the record of a person that will be inserted in the
     * set
     * @param paramPosition the position in which the record is inserted
     * @return true: the storage was done, false: the was a problem, storeRecord
     * not done.
     */
    public boolean storeRecord(PersonalRecord paramRecord, int paramPosition) {
        if ((paramPosition > -1) && (paramPosition < this.MAXIMUM_SIZE)) {
            if (this.numberOfRecords < this.MAXIMUM_SIZE) {
                this.numberOfRecords++;
                this.setRecord(paramRecord, paramPosition);
                return (true);
            } else {
                return (false);
            }
        } else {
            return (false);
        }
    }

    /**
     * Method.....: loadFromCSV Input......: paramTextFileName - the filename
     * that was used to stored the table records paramFirstPosition - the first
     * position (or record) that will be loaded paramLastPosition - the last
     * position (or record) that will be loaded Output.....: Load, from the .CSV
     * file, the records in a certain specified range Description: Initializes a
     * Table object Observation:
     */
    /**
     * @param paramTextFileName the filename that was used to stored the table
     * records
     * @param paramFirstPosition the first position (or record) that will be
     * loaded
     * @param paramLastPosition the last position (or record) that will be
     * loaded
     * @return number of records read from the file or -1, if an error occurs
     */
    public int loadFromCSV(String paramTextFileName, int paramFirstPosition, int paramLastPosition) {

        int i, j,
                lineCounter,
                recordCounter;          // number of records loaded from file

        boolean isCorrectInformation,
                continueLoop;

        String inputTextLine,
                COMMA,
                BLOOD_TYPES,
                GENRE_TYPES;
        IdentificationDocument auxiliaryDocument;
        PersonalRecord auxiliaryRecord;

        BufferedReader inputBuffer;
        FileReader inputFile;

        recordCounter = 0;
        if (paramFirstPosition > paramLastPosition) {
            return (recordCounter);
        }
        lineCounter = 0;
        COMMA = ",";
        BLOOD_TYPES = "A+A-B+B-O+O-AB+AB-";
        GENRE_TYPES = "MmFf*";
        continueLoop = true;
        //
        // At the moment, the informations about the CSV file are considered correct 
        //
        try {
            inputFile = new FileReader(paramTextFileName);
            inputBuffer = new BufferedReader(inputFile);
            //
            // reading the next line in the text file... 
            //
            inputTextLine = inputBuffer.readLine();
            while ((inputTextLine != null) && (lineCounter < paramFirstPosition)) {
                inputTextLine = inputBuffer.readLine();
                lineCounter++;
            }
            StringTokenizer lineTokens = new StringTokenizer(inputTextLine, COMMA);
            continueLoop = (lineTokens.hasMoreTokens());
            while (continueLoop) {
                //
                // Record fields: Identification document, name, ...
                //    
                // 1: Document (type, number and origin country)
                //
                auxiliaryDocument = new IdentificationDocument();
                auxiliaryDocument.setType(Integer.parseInt(lineTokens.nextToken().trim()));
                auxiliaryDocument.setNumber(Long.parseLong(lineTokens.nextToken().trim()));
                auxiliaryDocument.setOriginCountryCode(Integer.parseInt(lineTokens.nextToken().trim()));
                //
                // Check if the "type of the document" amd the "country code" are correct...
                //
                isCorrectInformation = ((auxiliaryDocument.getType() == 1) || (auxiliaryDocument.getType() == 2))
                        && ((auxiliaryDocument.getOriginCountryCode() > 0) && (auxiliaryDocument.getOriginCountryCode() < 10000));
                if (isCorrectInformation) {
                    auxiliaryRecord = new PersonalRecord();
                    auxiliaryRecord.setPersonalDocument(auxiliaryDocument);

                    auxiliaryRecord.setCompleteName(lineTokens.nextToken().trim());
                    auxiliaryRecord.setGenre(lineTokens.nextToken().trim().toUpperCase());
                    //
                    // Check if the "name" and the "genre" are correct...
                    //
                    isCorrectInformation = ((!(auxiliaryRecord.getCompleteName().isEmpty()))
                            && GENRE_TYPES.contains(auxiliaryRecord.getGenre()));
                    if (isCorrectInformation) {
                        auxiliaryRecord.setDateOfBirth(auxiliaryRecord.formatDate(lineTokens.nextToken()));

                        auxiliaryRecord.setNationalityCode(Integer.parseInt(lineTokens.nextToken().trim()));
                        auxiliaryRecord.setCitizenshipCode(Integer.parseInt(lineTokens.nextToken().trim()));

                        isCorrectInformation = ((auxiliaryRecord.getNationalityCode() > 0) && (auxiliaryRecord.getNationalityCode() < 10000))
                                && ((auxiliaryRecord.getCitizenshipCode() > 0) && (auxiliaryRecord.getCitizenshipCode() < 10000));

                        if (isCorrectInformation) {
                            auxiliaryRecord.setBloodType(lineTokens.nextToken().trim().toUpperCase());
                            auxiliaryRecord.setIsDisabledPerson(Boolean.parseBoolean(lineTokens.nextToken().trim()));
                            auxiliaryRecord.setDisabledDescription(lineTokens.nextToken().trim());
                            auxiliaryRecord.setObservation(lineTokens.nextToken().trim());

                            isCorrectInformation = BLOOD_TYPES.contains(auxiliaryRecord.getBloodType());

                            if (isCorrectInformation) {
                                //
                                // Only create a entry for the table if everything is correct...
                                // 
                                if (this.addRecord(auxiliaryRecord)) {
                                    recordCounter++;
                                }
                            }
                        }
                    }
                }
                //
                // reading the next line in the text file...   
                //
                inputTextLine = inputBuffer.readLine();
                if (inputTextLine != null) {
                    lineTokens = new StringTokenizer(inputTextLine, COMMA);
                    continueLoop = (lineTokens.hasMoreTokens());
                } else {
                    continueLoop = false;
                }
            }
            inputBuffer.close();
        } catch (IOException | NumberFormatException e) {
            recordCounter = -1;
            return (recordCounter);
        } catch (Exception ex) {
            Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (recordCounter);
    }

    /**
     * Method.....: saveToCSV Input......: paramTextFileName - the filename that
     * will be used to save the talbe records paramFirstPosition - the first
     * position (or record) that will be saved paramLastPosition - the last
     * position (or record) that will be saved Output.....: The number of saved
     * records Description: Save, to the .CSV file, the records in the range
     * specified. Observation:
     */
    /**
     * @param paramTextFileName the filename that will be used to save the table
     * records
     * @param paramFirstPosition the first position (or record) that will be
     * saved
     * @param paramLastPosition the last position (or record) that will be saved
     * @return the number of records saved in the file
     */
    public int saveToCSV(String paramTextFileName, int paramFirstPosition, int paramLastPosition) {

        int i, j,
                errorStatus,
                recordCounter;

        boolean isCorrectInformation;

        String COMMA,
                csvRecord,
                auxiliaryDate;
        PersonalRecord auxiliaryRecord;
        SimpleDateFormat date;
        FileWriter outputFile;
        BufferedWriter outputBuffer;

        COMMA = ",";
        recordCounter = 0;
        if (paramFirstPosition > paramLastPosition) {
            return (recordCounter);
        } else if (paramLastPosition > (this.MAXIMUM_SIZE - 1)) {
            return (recordCounter);
        }
        date = new SimpleDateFormat("dd/MM/yyyy");
        try {
            outputFile = new FileWriter(paramTextFileName, false);
            outputBuffer = new BufferedWriter(outputFile);
            for (i = paramFirstPosition; (i <= paramLastPosition); i++) {
                auxiliaryRecord = this.recordSet[i];
                auxiliaryDate = date.format(auxiliaryRecord.getDateOfBirth());
                csvRecord = auxiliaryRecord.getPersonalDocument().getType() + COMMA
                        + auxiliaryRecord.getPersonalDocument().getNumber() + COMMA
                        + auxiliaryRecord.getPersonalDocument().getOriginCountryCode() + COMMA
                        + auxiliaryRecord.getCompleteName() + COMMA
                        + auxiliaryRecord.getGenre() + COMMA
                        + auxiliaryDate + COMMA
                        + auxiliaryRecord.getNationalityCode() + COMMA
                        + auxiliaryRecord.getCitizenshipCode() + COMMA
                        + auxiliaryRecord.getBloodType() + COMMA
                        + auxiliaryRecord.getIsDisabledPerson() + COMMA
                        + auxiliaryRecord.getDisabledDescription() + COMMA
                        + auxiliaryRecord.getObservation();

                outputBuffer.write(csvRecord);
                outputBuffer.newLine();
                outputBuffer.flush();

                recordCounter++;
            }
            outputBuffer.close();
            outputFile.close();
        } catch (IOException | NumberFormatException e) {
            errorStatus = -1;
            return (errorStatus);
        } catch (Exception ex) {
            Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (recordCounter - 1);
    }

    /**
     * Method.....: randomGenerateToCSV Input......: paramTextFileName - the
     * filename that was used to stored the table records paramNumberOfRecords -
     * the number of records that will be generated randomly Output.....: The
     * number of generated records Description: Store, to the .CSV file, the
     * number of specified records. The records are randomly generated.
     * Observation:
     */
    /**
     * @param paramTextFileName the filename that was used to stored the table
     * records
     * @param paramNumberOfRecords the number of records that will be generated
     * to storeRecord in the file
     * @return number of records stored in the file
     */
    public int randomGenerateToCSV(String paramTextFileName, int paramNumberOfRecords) {

        int i, j,
                errorStatus,
                recordCounter;

        boolean isCorrectInformation;

        Random randomNumber;

        String auxiliaryString,
                csvRecord,
                COMMA,
                BLOOD_TYPES,
                GENRE_TYPES,
                auxiliaryDate;
        IdentificationDocument auxiliaryDocument;
        PersonalRecord auxiliaryRecord;

        FileWriter outputFile;
        BufferedWriter outputBuffer;

        recordCounter = 0;
        if (paramNumberOfRecords < 1) {
            return (recordCounter);
        }
        randomNumber = new Random();
        COMMA = ",";
        BLOOD_TYPES = "A+A-B+B-O+O-AB+AB-";
        GENRE_TYPES = "MF*";
        //
        // At the moment, the informations about the CSV file are considered correct 
        //
        try {
            outputFile = new FileWriter(paramTextFileName, false);
            outputBuffer = new BufferedWriter(outputFile);
            auxiliaryDocument = new IdentificationDocument();
            auxiliaryRecord = new PersonalRecord();

            while (recordCounter < paramNumberOfRecords) {
                //
                // Record fields: Identification document, name, ...
                //    
                // 1: Document (type, number and origin country)
                //
                auxiliaryDocument.setType(randomNumber.nextInt(2) + 1);
                auxiliaryDocument.setNumber(Math.abs(randomNumber.nextInt()));
                auxiliaryDocument.setOriginCountryCode(randomNumber.nextInt(1000) + 1);
                auxiliaryRecord.setPersonalDocument(auxiliaryDocument);

                auxiliaryString = "";
                for (i = 0; (i < randomNumber.nextInt(50) + 1); i++) {
                    j = (randomNumber.nextInt('z' - 'a' + 1) + 1) + 'a' - 1;
                    auxiliaryString += Character.toString((char) j);
                }
                auxiliaryRecord.setCompleteName(auxiliaryString.toUpperCase());
                j = randomNumber.nextInt(3);
                auxiliaryRecord.setGenre(GENRE_TYPES.substring(j, (j + 1)));
                auxiliaryDate = Integer.toString(randomNumber.nextInt(29) + 1) + "/"
                        + Integer.toString(randomNumber.nextInt(12) + 1) + "/"
                        + Integer.toString(randomNumber.nextInt(75) + 1940 + 1);
                try {
                    auxiliaryRecord.setDateOfBirth(auxiliaryRecord.formatDate(auxiliaryDate));
                } catch (Exception ex) {
                    Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
                }

                auxiliaryRecord.setNationalityCode(randomNumber.nextInt(9999) + 1);
                auxiliaryRecord.setCitizenshipCode(randomNumber.nextInt(9999) + 1);

                j = randomNumber.nextInt(8);
                if (j < 6) {
                    auxiliaryString = BLOOD_TYPES.substring(2 * j, (2 * j + 2));
                } else if (j == 6) {
                    auxiliaryString = BLOOD_TYPES.substring(2 * j, (2 * j + 3));
                } else {
                    auxiliaryString = BLOOD_TYPES.substring((2 * j + 1), (2 * j + 4));
                }

                auxiliaryRecord.setBloodType(auxiliaryString);

                auxiliaryRecord.setIsDisabledPerson((randomNumber.nextInt(2) == 0));
                if (auxiliaryRecord.getIsDisabledPerson()) {
                    auxiliaryString = "something";
                } else {
                    auxiliaryString = "nothing";
                }
                auxiliaryRecord.setDisabledDescription(auxiliaryString);
                auxiliaryRecord.setObservation("nothing");

                csvRecord = auxiliaryDocument.getType() + COMMA
                        + auxiliaryDocument.getNumber() + COMMA
                        + auxiliaryDocument.getOriginCountryCode() + COMMA
                        + auxiliaryRecord.getCompleteName() + COMMA
                        + auxiliaryRecord.getGenre() + COMMA
                        + auxiliaryDate + COMMA
                        + auxiliaryRecord.getNationalityCode() + COMMA
                        + auxiliaryRecord.getCitizenshipCode() + COMMA
                        + auxiliaryRecord.getBloodType() + COMMA
                        + auxiliaryRecord.getIsDisabledPerson() + COMMA
                        + auxiliaryRecord.getDisabledDescription() + COMMA
                        + auxiliaryRecord.getObservation();

                outputBuffer.write(csvRecord);
                outputBuffer.newLine();
                outputBuffer.flush();

                recordCounter++;
            }
            outputBuffer.close();
            outputFile.close();
        } catch (IOException | NumberFormatException e) {
            errorStatus = -1;
            return (errorStatus);
        } catch (Exception ex) {
            Logger.getLogger(Table.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (recordCounter);
    }

    /**
     * Method.....: print Input......: paramFirstPosition - the first position
     * (or record) that will be saved paramLastPosition - the last position (or
     * record) that will be saved Output.....: The number of saved records
     * Description: Save, to the .CSV file, the records in the range specified.
     * Observation:
     */
    /**
     * @param paramFirstPosition the first position (or record) that will be
     * printed
     * @param paramLastPosition the last position (or record) that will be
     * printed
     * @return the number of records printed in the output device
     */
    public int print(int paramFirstPosition, int paramLastPosition) {

        int i,recordCounter;

        recordCounter = 0;
        if (paramFirstPosition > paramLastPosition) {
            return (recordCounter);
        } else if (paramLastPosition > (this.MAXIMUM_SIZE - 1)) {
            return (recordCounter);
        } else {
            recordCounter = paramLastPosition - paramFirstPosition + 1;
        }

        for (i = paramFirstPosition; (i < paramLastPosition + 1); i++) {
            this.recordSet[i].print();
        }
        return (recordCounter);
    }
}
