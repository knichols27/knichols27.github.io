package ch_35;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ProgAssi35 extends Application
{
    @Override
    public void start(Stage stage)
    {
        DBConnectionPane connectionPane = new DBConnectionPane();

        Scene scene = new Scene(connectionPane, 350, 200);
        stage.setTitle("Problem$01");
        stage.setScene(scene);
        stage.show();
    }
}
