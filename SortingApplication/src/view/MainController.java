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

/**
 * FXML Controller class. It controls the main.fxml file.
 *
 * @author eric
 */
public class MainController implements Initializable {

    private FileChooser fileChooser;
    private File fileChosen;

    @FXML
    private TextField tfFileChosen;
    @FXML
    private Button btFileChooser;
    @FXML
    private RadioButton rbSelectionSort;
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
    
    /**
     * Method used by the btSort button.
     * It calls a sorting algorithm, according to the selected radiobutton.
     */
    @FXML
    public void sort() {
        if (fileChosen != null) {
            if (rbSelectionSort.isSelected()) {
                selectionSort();
            } else if (rbInsertionSort.isSelected()) {
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
     * Calls the Selection Sort Algorithm.
     */
    public void selectionSort() {
        System.out.println("Chamou o Selection Sort para ordenar " + fileChosen.getName());
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
    public void pigeonHoleSort() {
        System.out.println("Chamou o Pigeon Hole Sort para ordenar " + fileChosen.getName());
    }
    
    /**
     * Calls the Bucket Sort Algorithm.
     */
    public void bucketSort() {
        System.out.println("Chamou o Bucket Sort para ordenar " + fileChosen.getName());
    }

}
