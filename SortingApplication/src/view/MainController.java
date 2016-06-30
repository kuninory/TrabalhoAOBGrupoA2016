package view;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sortingapplication.BucketSort;
import sortingapplication.InsertionSort;
import sortingapplication.PigeonholeSort;
import sortingapplication.ShellSort;
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
     * Opens a FileChooser dialog to select the file that is supposed to be
     * sorted. Then, the file path is shown in the tfFileChosen textfield.
     * @throws java.io.IOException
     */
    @FXML
    public void chooseAFile() throws IOException {
        File file = fileChooser.showOpenDialog(btFileChooser.getScene().getWindow());
        if (file != null) {
            fileChosen = file;
            tfFileChosen.setText(file.getPath());

            TableGenerator generator = new TableGenerator();
            table = generator.generate(fileChosen);
            
            System.out.println("Table from " + fileChosen.getName() + " generated successfully");
        }
    }

    /**
     * Calls a TableGenerator to create a random table.
     */
    @FXML
    public void generateAFile() {
        String inputFromTextField = tfNumberOfRecords.getText();
        if (inputFromTextField != null && inputFromTextField.matches("\\d+")) {
            int numberOfRecords = Integer.valueOf(inputFromTextField);
            TableGenerator generator = new TableGenerator(numberOfRecords);
            table = generator.generateRandom();
            System.out.println("Random table generated successfully.");
        } else {
            System.out.println("Invalid number of records.");
        }
    }

    /**
     * Method used by the btSort button. It calls a sorting algorithm, according
     * to the selected radiobutton.
     * @throws java.lang.Exception
     */
    @FXML
    public void sort() throws Exception {
        if (table != null) {
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
     * @throws java.lang.Exception
     */
    public void insertionSort() throws Exception {
        InsertionSort insertion = new InsertionSort();
        insertion.sortTable(table);        
        SortingScreen sortingScreen = new SortingScreen(table);
        sortingScreen.start(new Stage());
    }

    /**
     * Calls the Shell Sort Algorithm.
     * @throws java.lang.Exception
     */
    public void shellSort() throws Exception {
        ShellSort shell = new ShellSort();
        shell.sortTable(table);        
        SortingScreen sortingScreen = new SortingScreen(table);
        sortingScreen.start(new Stage());
    }

    /**
     * Calls the Pigeon Hole Sort Algorithm.
     * @throws java.lang.Exception
     */
    public void pigeonHoleSort() throws Exception {
        PigeonholeSort pigeonhole = new PigeonholeSort();
        pigeonhole.sortTable(table);
        SortingScreen sortingScreen = new SortingScreen(table); 
        sortingScreen.start(new Stage());
    }

    /**
     * Calls the Bucket Sort Algorithm.
     * @throws java.lang.Exception
     */
    public void bucketSort() throws Exception {
        BucketSort bucket = new BucketSort();
        bucket.sortTable(table);        
        SortingScreen sortingScreen = new SortingScreen(table);
        sortingScreen.start(new Stage());
    }

}
