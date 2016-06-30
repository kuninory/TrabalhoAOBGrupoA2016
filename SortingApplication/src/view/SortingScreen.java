package view;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import sortingapplication.Table;

/**
 * This class represents the window where the sortings will be printed.
 * 
 * @author eric
 */
public class SortingScreen extends Application {

    private Table table;

    public SortingScreen(Table table) {
        this.table = table;
    }
    
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sortingscreen.fxml"));

        SortingScreenController controller = new SortingScreenController(table);
        loader.setController(controller);
        Scene scene = new Scene((Pane) loader.load());
        stage.setScene(scene);

        stage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
