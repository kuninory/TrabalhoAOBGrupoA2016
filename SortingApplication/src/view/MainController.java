package view;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sortingapplication.PigeonholeSort;
import sortingapplication.Table;
import sortingapplication.TableGenerator;

/**
 * FXML Controller class. It controls the main.fxml file.
 *
 * @author eric
 */
public class MainController implements Initializable {

    private FileChooser fileChooser;
    private File fileChosen;
    private Table table;

    @FXML
    private TextField tfFileChosen;
    @FXML
    private Button btFileChooser;
    @FXML
    private TextField tfNumberOfRecords;
    @FXML
    private Button btGenerate;
    @FXML
    private RadioButton rbInsertionSort;
    @FXML
    private RadioButton rbShellSort;
    @FXML
    private RadioButton rbPigeonHoleSort;
    @FXML
    private RadioButton rbBucketSort;
    @FXML
    private Button btSort;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fileChooser = new FileChooser();
    }

    /**
     * Opens a FileChooser dialog to select the file that is supposed to be sorted.
     * Then, the file path is shown in the tfFileChosen textfield.
     */
    @FXML
    public void chooseAFile() {
        File file = fileChooser.showOpenDialog(btFileChooser.getScene().getWindow());
        if (file != null) {
            fileChosen = file;
            tfFileChosen.setText(file.getPath());
        }
    }
    
    @FXML
    public void generateAFile() {
        String inputFromTextField = tfNumberOfRecords.getText();
        if (inputFromTextField != null && inputFromTextField.matches("\\d+")) {
            int numberOfRecords = Integer.valueOf(inputFromTextField);
            TableGenerator generator = new TableGenerator(numberOfRecords);
            table = generator.generate();
            System.out.println("Table generated successfuly.");
        } else {
            System.out.println("Invalid number of records.");
        }
    }
    
    /**
     * Method used by the btSort button.
     * It calls a sorting algorithm, according to the selected radiobutton.
     */
    @FXML
    public void sort() throws Exception {
        if (fileChosen != null || table != null) {
            if (rbInsertionSort.isSelected()) {
                insertionSort();
            } else if (rbShellSort.isSelected()) {
                shellSort();
            } else if (rbPigeonHoleSort.isSelected()) {
                pigeonHoleSort();
            } else if (rbBucketSort.isSelected()) {
                bucketSort();
            }
        }
    }
    
    /**
     * Calls the Insertion Sort Algorithm.
     */
    public void insertionSort() {
        System.out.println("Chamou o Insertion Sort para ordenar " + fileChosen.getName());
    }
    
    /**
     * Calls the Shell Sort Algorithm.
     */
    public void shellSort() {
        System.out.println("Chamou o Shell Sort para ordenar " + fileChosen.getName());
    }
    
    /**
     * Calls the Pigeon Hole Sort Algorithm.
     */
    public void pigeonHoleSort() throws Exception {
        PigeonholeSort pigeonhole = new PigeonholeSort();
        pigeonhole.sortTable(table);
        SortingScreen sortingScreen = new SortingScreen(table); // Calls a new
        sortingScreen.start(new Stage());                       // sorting screen
    }
    
    /**
     * Calls the Bucket Sort Algorithm.
     */
    public void bucketSort() {
        System.out.println("Chamou o Bucket Sort para ordenar " + fileChosen.getName());
    }

}
