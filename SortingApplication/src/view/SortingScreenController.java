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
 * FXML Controller class.
 * It controls the sortingscreen.fxml file.
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
        System.out.println("chegou2");
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void onPrint() {
        if (rbAll.isSelected()) {
            printAll();
        } else if (rbRange.isSelected()) {
            printRange();
        }
    }
    
    public void printAll() {
        System.out.println("\nPrinting all records: ");
        table.print(0, table.getNumberOfRecords() - 1);
    }
    
    public void printRange() {
        boolean validFrom = false, 
                validTo = false;
        
        if (tfFrom == null) {
            from = 0;
            validFrom = true;
        } else if (tfFrom.getText().matches("\\d+")) {
            from = Integer.parseInt(tfFrom.getText());
            validFrom = true;
        } else {
            System.out.println("Invalid value/range.");
            validFrom = false;
        }
        
        if (tfTo != null && tfTo.getText().matches("\\d+")) {
            to = Integer.parseInt(tfTo.getText()) - 1;
            validTo = true;
        } else {
            System.out.println("Invalid value/range.");
            validTo = false;
        }
        
        if (validFrom == true && validTo == true) {
            System.out.println("\nPrinting from " + from + " to " + to + ": ");
            table.print(from, to);
        }

    }

    
}
