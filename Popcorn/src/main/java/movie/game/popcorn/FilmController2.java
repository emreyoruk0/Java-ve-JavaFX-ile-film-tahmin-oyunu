package movie.game.popcorn;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FilmController2 {

    @FXML
    Button yeniOyunButon;


    FilmApplication yeniOyun = new FilmApplication();

    public void yeniOyunuBaslat(ActionEvent event) {
        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();
        s.close();
        try{
            yeniOyun.start(new Stage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
