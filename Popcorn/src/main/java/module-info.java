module movie.game.popcorn {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens movie.game.popcorn to javafx.fxml;
    exports movie.game.popcorn;
}