package sortingapplication;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Felipe
 */
public class PigeonholeSort {

    private HashMap<Integer, List<PersonalRecord>> typesHoles = new HashMap<>();
    private HashMap<Long, List<PersonalRecord>> numbersHoles = new HashMap<>();
    private HashMap<Integer, List<PersonalRecord>> originCountryCodesHoles = new HashMap<>();

    public void getHolesLists(Table table) {
        PersonalRecord[] listOfRecords = table.getRecordSet();
        int i;
        for (i = 0; i < table.getNumberOfRecords(); i++) {

            if (!numbersHoles.containsKey(listOfRecords[i].getPersonalDocument().getNumber())) {
                numbersHoles.put(listOfRecords[i].getPersonalDocument().getNumber(), new ArrayList<>());
            }

            if (!originCountryCodesHoles.containsKey(listOfRecords[i].getPersonalDocument().getOriginCountryCode())) {
                originCountryCodesHoles.put(listOfRecords[i].getPersonalDocument().getOriginCountryCode(), new ArrayList<>());
            }
        }
    }

    public void sortTable(Table table) {

        typesHoles.put(1, new ArrayList<>());
        typesHoles.put(2, new ArrayList<>());
        getHolesLists(table);

    }

}
