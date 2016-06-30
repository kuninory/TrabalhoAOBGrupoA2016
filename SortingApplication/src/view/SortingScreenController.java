package view;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import sortingapplication.Table;

/**
 * FXML Controller class. It controls the sortingscreen.fxml file.
 *
 * @author eric
 */
public class SortingScreenController implements Initializable {

    private Table table;
    int from, to;

    @FXML
    private RadioButton rbAll;
    @FXML
    private RadioButton rbRange;
    @FXML
    private TextField tfFrom;
    @FXML
    private TextField tfTo;
    @FXML
    private Button btPrint;

    public SortingScreenController(Table table) {
        this.table = table;
    }

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    /**
     * Method called by the btPrint button. It chooses which method of print
     * will be called, based on the selected RadioButton.
     */
    public void onPrint() {
        if (rbAll.isSelected()) {
            printAll();
        } else if (rbRange.isSelected()) {
            printRange();
        }
    }

    /**
     * Prints all the records of the table.
     */
    public void printAll() {
        System.out.println("############ Sorting Results ############");
        System.out.println("\nPrinting all sorted records: ");
        table.print(0, table.getNumberOfRecords() - 1);
    }

    /**
     * Prints a range of records of the table, set by the user.
     */
    public void printRange() {
        boolean validFrom = false,
                validTo = false;

        if (tfFrom == null) {
            from = 0;
            validFrom = true;
        } else if (tfFrom.getText().matches("\\d+")) {
            from = Integer.parseInt(tfFrom.getText());
            if (from >= 0 && from <= Integer.parseInt(tfTo.getText())) {
                validFrom = true;
            } else {
                validFrom = false;
            }
        } else {
            System.out.println("Invalid value/range.");
            validFrom = false;
        }

        if (tfTo != null && tfTo.getText().matches("\\d+")) {
            to = Integer.parseInt(tfTo.getText());
            if (to >= from && to < table.getNumberOfRecords()) {
                validTo = true;
            } else {
                validTo = false;
            }
        } else {
            System.out.println("Invalid value/range.");
            validTo = false;
        }

        if (validFrom == true && validTo == true) {
            System.out.println("############ Sorting Results ############");
            System.out.println("\nPrinting sorted records from " + from + " to " + to + ": ");
            table.print(from, to);
        } else {
            System.out.println("Invalid value/range.");
        }
    }

}
