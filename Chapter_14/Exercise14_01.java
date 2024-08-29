package ch_14;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.layout.*;
import javafx.stage.*;

/**
 * 14.1 (Display images) Write a program that displays four images in a grid pane, as
 * shown in Figure 14.43a.
 */
public class Exercise14_01 extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane gridPane = new GridPane();
        ImageView imgV01 = new ImageView(new Image("resources/flag1.gif"));
        imgV01.setFitHeight(200);
        imgV01.setFitWidth(300);
        imgV01.setSmooth(true);
        imgV01.setCache(true);

        ImageView imgV02 = new ImageView(new Image("resources/flag2.gif"));
        imgV02.setFitHeight(200);
        imgV02.setFitWidth(300);
        imgV02.setSmooth(true);
        imgV02.setCache(true);

        ImageView imgV06 = new ImageView(new Image("resources/flag6.gif"));
        imgV03.setFitHeight(200);
        imgV03.setFitWidth(300);
        imgV03.setSmooth(true);
        imgV03.setCache(true);
        ImageView imgV07 = new ImageView(new Image("resources/flag7.gif"));
        imgV04.setFitHeight(200);
        imgV04.setFitWidth(300);
        imgV04.setSmooth(true);
        imgV04.setCache(true);
        GridPane.setConstraints(flag1, 0, 1);
        GridPane.setConstraints(flag2, 0, 2);
        GridPane.setConstraints(flag6, 0, 6);
        GridPane.setConstraints(flag7, 0, 7);

        gridPane.getChildren().addAll(flag01, flag02, flag06, flag07);
        Scene scene = new Scene(gridPane);
        primaryStage.setTitle(getClass().getName());
        primaryStage.setScene(scene);
        primaryStage.show();

    }

} 
