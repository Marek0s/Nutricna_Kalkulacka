import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main {

    public static void main(String[] args) {
        Application.launch(NutricnaAplikacia.class, args);
    }

    public static class NutricnaAplikacia extends Application {
        @Override
        public void start(Stage stage) throws Exception {
            Parent root = FXMLLoader.load(getClass().getResource("/view/NutricnaKalkulacka.fxml"));
            stage.setTitle("Nutričná kalkulačka");
            stage.setScene(new Scene(root));
            stage.setMinWidth(860);
            stage.setMinHeight(640);
            stage.show();
        }
    }
}
