package movie.game.popcorn;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;

public class FilmApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(FilmApplication.class.getResource("GUI.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 915, 820);
        stage.setTitle("CUTE POPCORN™ The Movie Guessing Game");
        stage.setScene(scene);
        stage.getIcons().add(new Image("https://upload.wikimedia.org/wikipedia/commons/6/6c/Popcorn_Time_logo.png?20140410070259"));
        stage.show();
    }

    public static void main(String[] args) {
        FilmController.filmGetir();
        launch();
    }
}