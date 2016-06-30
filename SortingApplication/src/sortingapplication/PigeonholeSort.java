package sortingapplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

/**
 *
 * @author Felipe
 */
public class PigeonholeSort {

    private HashMap<Integer, List<PersonalRecord>> typesHoles = new HashMap<>();
    private HashMap<Long, List<PersonalRecord>> numbersHoles = new HashMap<>();
    private HashMap<Integer, List<PersonalRecord>> originCountryCodesHoles = new HashMap<>();

    public void sortTable(Table table) {

        int i, j, x, y, z;
        int auxNumSorted = 0;

        //Get the array of PersonalRecords
        PersonalRecord[] listOfRecords = table.getRecordSet();

        //Starting with the Type of document, lets get every Type of document and store separately the unique types as keys
        for (i = 0; i < table.getNumberOfRecords(); i++) {
            if (!typesHoles.containsKey(listOfRecords[i].getPersonalDocument().getType())) {
                typesHoles.put(listOfRecords[i].getPersonalDocument().getType(), new ArrayList<>());
            }
        }
        //Parse the list of Types to a TreeMap to order the keys
        TreeMap<Integer, List<PersonalRecord>> sortedTypes = new TreeMap<>(typesHoles);
        //Search and store in the appropriate key of Type every PersonalRecords
        for (i = 0; i < table.getNumberOfRecords(); i++) {
            if (sortedTypes.containsKey(listOfRecords[i].getPersonalDocument().getType())) {
                sortedTypes.get(listOfRecords[i].getPersonalDocument().getType()).add(listOfRecords[i]);
            }
        }

        //For every unique Type of document, let's apply the Pigeonhole Sort again, now focusing on Number of document
        for (i = 0; i < sortedTypes.size(); i++) {

            //Getting the List of PersonalRecords in the same Type
            List<PersonalRecord> numbers = new ArrayList<>();
            int key = (int) sortedTypes.keySet().toArray()[i];
            numbers = sortedTypes.get(key);

            //Getting every Number of document and store separately the unique Number as keys
            for (j = 0; j < numbers.size(); j++) {
                if (!numbersHoles.containsKey(numbers.get(j).getPersonalDocument().getNumber())) {
                    numbersHoles.put(numbers.get(j).getPersonalDocument().getNumber(), new ArrayList<>());
                }
            }
            //Parse the list of Numbers to a TreeMap to order the keys
            TreeMap<Long, List<PersonalRecord>> sortedNumbers = new TreeMap<>(numbersHoles);
            //Search and store in the appropriate key of Number every PersonalRecords
            for (j = 0; j < numbers.size(); j++) {
                if (sortedNumbers.containsKey(numbers.get(j).getPersonalDocument().getNumber())) {
                    sortedNumbers.get(numbers.get(j).getPersonalDocument().getNumber()).add(numbers.get(j));
                }
            }

            //For every unique Number of document, let's apply the Pigeonhole Sort again, now focusing on OriginCountryCode of document
            for (x = 0; x < sortedNumbers.size(); x++) {

                //Getting the List of PersonalRecords in the same Number
                List<PersonalRecord> originCountryCodes = new ArrayList<>();
                long keyCountryCode = (long) sortedNumbers.keySet().toArray()[x];
                originCountryCodes = sortedNumbers.get(keyCountryCode);

                //Getting every OriginCountryCode of document and store separately the unique OriginCountryCode as keys
                for (y = 0; y < originCountryCodes.size(); y++) {
                    if (!originCountryCodesHoles.containsKey(originCountryCodes.get(y).getPersonalDocument().getOriginCountryCode())) {
                        originCountryCodesHoles.put(originCountryCodes.get(y).getPersonalDocument().getOriginCountryCode(), new ArrayList<>());
                    }
                }
                //Parse the list of OriginCountryCode to a TreeMap to order the keys
                TreeMap<Integer, List<PersonalRecord>> sortedOriginCountryCode = new TreeMap<>(originCountryCodesHoles);
                //Search and store in the appropriate key of OriginCountryCode every PersonalRecords
                for (y = 0; y < originCountryCodes.size(); y++) {
                    if (sortedOriginCountryCode.containsKey(originCountryCodes.get(y).getPersonalDocument().getOriginCountryCode())) {
                        sortedOriginCountryCode.get(originCountryCodes.get(y).getPersonalDocument().getOriginCountryCode()).add(originCountryCodes.get(y));
                    }
                }

                for (y = 0; y < originCountryCodes.size(); y++) {
                    List<PersonalRecord> sorted = new ArrayList<>();
                    int keyFinal = (int) sortedOriginCountryCode.keySet().toArray()[y];
                    sorted = sortedOriginCountryCode.get(keyFinal);

                    for (z = 0; z < sorted.size(); z++) {
                        listOfRecords[auxNumSorted] = sorted.get(z);
                        auxNumSorted++;
                    }

                }

                originCountryCodesHoles.clear();
            }

            numbersHoles.clear();
        }

    }

}
