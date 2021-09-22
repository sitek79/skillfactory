package clock1;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.text.SimpleDateFormat;
import java.util.Date;

// chapter1/clock/ClockOne.java
public class ClockOne extends Application {
    // we are allowed to create UI objects on non-UI thread
    private final Text txtTime = new Text();
    private volatile boolean enough = false;
    // this is timer thread which will update out time view every second
    Thread timer = new Thread(() -> {
        SimpleDateFormat dt = new SimpleDateFormat("hh:mm:ss");
        while(!enough) {
            try {
// running "long" operation not on UI thread
                Thread.sleep(1000);
            } catch (InterruptedException ex) {}
            final String time = dt.format(new Date());
            Platform.runLater(()-> {
// updating live UI object requires JavaFX App Thread
                txtTime.setText(time);
            });
        }
    });
    @Override
    public void start(Stage stage) {
// Layout Manager
        BorderPane root = new BorderPane();
        root.setCenter(txtTime);
// creating a scene and configuring the stage
        Scene scene = new Scene(root, 200, 150);
        stage.initStyle(StageStyle.UTILITY);
        stage.setTitle("Clock");
        stage.setScene(scene);
        timer.start();
        //сформировать текст
        Text txt = new Text("Hello, JavaFX!");
        txt.setFont(Font.font ("Courier New", FontWeight.BOLD, FontPosture.ITALIC, 15));
        TextFlow textFlow = new TextFlow(txt);
        //добавить все в слой
        root.getChildren().addAll(
                // RED, opacity 0.3
                new Circle(130,80,30, Color.rgb(255, 0, 0, 0.3)),
                // GREEN, opacity 0.3
                new Circle(100,110,30, Color.hsb(120, 1.0, 1.0, 0.3)),
                // BLUE, opacity 0.3
                new Circle(160,110,30, Color.web("0x0000FF", 0.3)),
                textFlow
        );
        //
        stage.show();
    }
    // stop() method of the Application API
    @Override
    public void stop() {
// we need to stop our working thread after closing a window
// or our program will not exit
        enough = true;
    }
    public static void main(String[] args) {
        launch(args);
    }
