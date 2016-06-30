package view;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class.
 * It controls the console.fxml file.
 *
 * @author eric
 */
public class ConsoleController implements Initializable {

    @FXML
    private TextArea console;
    private PrintStream ps;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ps = new PrintStream(new Console(console));
        System.setOut(ps);
    }

    /**
     * Defines the custom console.
     */
    public class Console extends OutputStream {

        private TextArea console;

        public Console(TextArea console) {
            this.console = console;
        }

        public void appendText(String valueOf) {
            Platform.runLater(() -> console.appendText(valueOf));
        }

        public void write(int b) throws IOException {
            appendText(String.valueOf((char) b));
        }
    }

}
