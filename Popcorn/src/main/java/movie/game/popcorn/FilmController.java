package movie.game.popcorn;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class FilmController {

    @FXML
    Pane filmPane; @FXML Pane filmPane1; @FXML Pane filmPane2; @FXML Pane filmPane3; @FXML Pane filmPane4;

    @FXML
    TextField txtField;

    @FXML
    Button guessButton;

    @FXML Button filmAdi; @FXML Button filmYili; @FXML Button filmTuru; @FXML Button filmUlkesi; @FXML Button filmDirektoru; @FXML Button filmYilidizi;
    @FXML Button filmAdi1; @FXML Button filmYili1; @FXML Button filmTuru1; @FXML Button filmUlkesi1; @FXML Button filmDirektoru1; @FXML Button filmYilidizi1;
    @FXML Button filmAdi2; @FXML Button filmYili2; @FXML Button filmTuru2; @FXML Button filmUlkesi2; @FXML Button filmDirektoru2; @FXML Button filmYilidizi2;
    @FXML Button filmAdi3; @FXML Button filmYili3; @FXML Button filmTuru3; @FXML Button filmUlkesi3; @FXML Button filmDirektoru3; @FXML Button filmYilidizi3;
    @FXML Button filmAdi4; @FXML Button filmYili4; @FXML Button filmTuru4; @FXML Button filmUlkesi4; @FXML Button filmDirektoru4; @FXML Button filmYilidizi4;

    @FXML ImageView filmUp; @FXML ImageView filmUp1; @FXML ImageView filmUp2; @FXML ImageView filmUp3; @FXML ImageView filmUp4;
    @FXML ImageView filmDown; @FXML ImageView filmDown1; @FXML ImageView filmDown2; @FXML ImageView filmDown3; @FXML ImageView filmDown4;

    @FXML
    ListView<String> listView;

    // Excel dosyasından filmleri okuyup tüm filmleri Filmm tipindeki filmler ArrayList'ine aktarıyor
    public static ArrayList<Filmm> filmGetir(){
        int sayac = 0;
        String line = "";
        ArrayList<Filmm> filmler = new ArrayList();

        try (BufferedReader br = new BufferedReader(new FileReader("src\\\\imdb_top_250.csv"))) {
            while ((line = br.readLine()) != null) {
                if(sayac == 0){
                    sayac++;
                    continue;
                }
                String[] veri = line.split(";");
                filmler.add(new Filmm(veri[1],veri[2],veri[3],veri[4],veri[5],veri[6]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filmler;
    }


    Random rastgele = new Random();
    final int r1 = rastgele.nextInt(filmGetir().size());
    int hak = 5;
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    ButtonType tekrarOynaButton = new ButtonType("Tekrar Oyna", ButtonBar.ButtonData.OK_DONE);
    public static ObservableList<String> listViewFilmler = FXCollections.observableArrayList();


    //constructor
    public FilmController(){
        for (int i = 0; i < filmGetir().size(); i++){ // listView içine filmler ArrayList'indeki filmlerin sadece isimlerini aktarıyor
            listViewFilmler.add(filmGetir().get(i).getAd());
        }
        // Tahmin edilecek filmi konsola yazdırıyor.
        System.out.println(filmGetir().get(r1).getAd() + " --> " + filmGetir().get(r1).getYil() + " | " + filmGetir().get(r1).getTur() + " | " + filmGetir().get(r1).getUlke() + " | " + filmGetir().get(r1).getDirektor() + " | " + filmGetir().get(r1).getYildiz());
    }

    public void txtSetOnAction(ActionEvent event){ // txtField'a metin girerken Entera basıldığında çağırılan metod
        handler();
        txtField.setText("");
    }
    public void guessSetOnAction(ActionEvent event){ // Tahmin Et butonuna basıldığında çağırılan metod
        handler();
        txtField.setText("");
        listView.setVisible(false);
    }


    public void handler(){
        for (int i = 0; i < filmGetir().size() & hak > 0; i++){

            if (filmGetir().get(i).getAd().equalsIgnoreCase(txtField.getText())) {

                System.out.println(filmGetir().get(i).getAd() + " --> " + filmGetir().get(i).getYil() + " | " + filmGetir().get(i).getTur() + " | " + filmGetir().get(i).getUlke() + " | " + filmGetir().get(i).getDirektor() + " | " + filmGetir().get(i).getYildiz() + " | KALAN HAK: " + hak);
                if (hak == 5){
                    filmGoster(filmAdi,filmYili,filmTuru,filmUlkesi,filmDirektoru,filmYilidizi,filmPane,filmUp,filmDown,i);
                }
                if (hak == 4){
                    filmGoster(filmAdi1,filmYili1,filmTuru1,filmUlkesi1,filmDirektoru1,filmYilidizi1,filmPane1,filmUp1,filmDown1,i);
                }
                if (hak == 3){
                    filmGoster(filmAdi2,filmYili2,filmTuru2,filmUlkesi2,filmDirektoru2,filmYilidizi2,filmPane2,filmUp2,filmDown2,i);
                }
                if (hak == 2){
                    filmGoster(filmAdi3,filmYili3,filmTuru3,filmUlkesi3,filmDirektoru3,filmYilidizi3,filmPane3,filmUp3,filmDown3,i);
                }
                if (hak == 1){
                    filmGoster(filmAdi4,filmYili4,filmTuru4,filmUlkesi4,filmDirektoru4,filmYilidizi4,filmPane4,filmUp4,filmDown4,i);
                }
                hak = hak-1;
                if (hak == 0) {
                    if (!(filmGetir().get(i).getYil().equalsIgnoreCase(filmGetir().get(r1).getYil()) & filmGetir().get(i).getTur().equalsIgnoreCase(filmGetir().get(r1).getTur()) & filmGetir().get(i).getUlke().equalsIgnoreCase(filmGetir().get(r1).getUlke()) & filmGetir().get(i).getDirektor().equalsIgnoreCase(filmGetir().get(r1).getDirektor()) & filmGetir().get(i).getYildiz().equalsIgnoreCase(filmGetir().get(r1).getYildiz()))){
                        alert.setTitle("!!!");
                        alert.setHeaderText("Maalesef oyunu kaybettiniz!");
                        alert.setContentText("Hakkınız bitti!! Doğru Filmi bulamadınız");
                        alert.getButtonTypes().setAll(tekrarOynaButton);
                        alert.showAndWait();
                        try {
                            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("tekrarOyna.fxml"));
                            Parent rootTekrarOyna = (Parent) fxmlLoader.load();
                            Stage stage = new Stage();
                            stage.setTitle("CUTE POPCORN™ The Movie Guessing Game");
                            stage.setScene(new Scene(rootTekrarOyna));
                            stage.getIcons().add(new Image("https://upload.wikimedia.org/wikipedia/commons/6/6c/Popcorn_Time_logo.png?20140410070259"));
                            stage.show();
                        } catch (Exception e) {
                            e.printStackTrace();
                        } finally {
                            ((Stage) guessButton.getScene().getWindow()).close();
                            listViewFilmler = FXCollections.observableArrayList();
                        }
                    }
                }
            }
        }
    }


    // Kullanıcı txtField' her değer girdiğinde bu metod çağırılıyor.
    public void filmListView(){
        listView.setVisible(true);
        txtField.setOnKeyPressed(event -> { // Metin girerken aşağı yön tuşuna basıldığında listView'e geçilmesi için
            if (event.getCode() == KeyCode.DOWN) {
                listView.requestFocus();
            }
        });
        txtField.textProperty().addListener((observableValue, oldValue, newValue) -> { // TextField’e girilen değere göre ListView’deki öğeleri filtrelemek için
            if (newValue.length() == 0) {
                listView.setItems(null);
            } else {
                ObservableList<String> ileBaslayanFilmler = FXCollections.observableArrayList();
                for (String arananFilm : listViewFilmler) {
                    if (arananFilm.toLowerCase().startsWith(newValue.toLowerCase())) {
                        ileBaslayanFilmler.add(arananFilm);
                    }
                }
                listView.setItems(ileBaslayanFilmler);
            }
        });
        listView.setOnKeyPressed(keyEvent -> { // ListView'deyken aşağı, yukarı ve enter tuşlarına basıldığında yapılacak işlemler
            if (keyEvent.getCode().equals(KeyCode.DOWN)) {
                int index = listView.getSelectionModel().getSelectedIndex();
                listView.getSelectionModel().select(index);
                keyEvent.consume();
            } else if (keyEvent.getCode().equals(KeyCode.UP)) {
                int index = listView.getSelectionModel().getSelectedIndex();
                listView.getSelectionModel().select(index);
                keyEvent.consume();
            } else if (keyEvent.getCode().equals(KeyCode.ENTER)) {
                String secilenFilm = listView.getSelectionModel().getSelectedItem();
                txtField.setText(secilenFilm);
                txtField.requestFocus();
                listView.setVisible(false);
            }
        });
        listView.setOnMouseClicked(mouseEvent -> { // ListView'deki elemanları mouse ile seçtiğimizde yapılacak işlemler
            String tiklananFilm = listView.getSelectionModel().getSelectedItem();
            txtField.setText(tiklananFilm);
            txtField.requestFocus();
            listView.setVisible(false);
        });
    }


    // Bilinecek film ile kullanıcının girdiği filmin özelliklerinin eşleşme durumuna göre ilgili kutucukların rengini değiştiren metod
    public void filmGoster(Button fAdi, Button fYili, Button fTuru, Button fUlkesi, Button fDirektoru, Button fYildizi,Pane fPane, ImageView fUp, ImageView fDown, int i){

        fAdi.setText(filmGetir().get(i).getAd());
        fYili.setText(filmGetir().get(i).getYil());
        fTuru.setText(filmGetir().get(i).getTur());
        fUlkesi.setText(filmGetir().get(i).getUlke());
        fDirektoru.setText(filmGetir().get(i).getDirektor());
        fYildizi.setText(filmGetir().get(i).getYildiz());
        fAdi.setWrapText(true);
        fDirektoru.setWrapText(true);
        fYildizi.setWrapText(true);
        if (filmGetir().get(i).getAd().equalsIgnoreCase(filmGetir().get(r1).getAd())) {
            System.out.println("TEBRİKLER FİLMİ BULDUNUZ");
            fAdi.setStyle("-fx-background-color: green");
            fPane.setVisible(true);
        }
        if (filmGetir().get(i).getYil().equalsIgnoreCase(filmGetir().get(r1).getYil())) {
            System.out.println("Girdiğiniz film ile belirlenen filmin 'YIL' bilgisi eşleşiyor. ");
            fYili.setStyle("-fx-background-color: green");
            fPane.setVisible(true);
        }
        if (Integer.parseInt(filmGetir().get(i).getYil()) > Integer.parseInt(filmGetir().get(r1).getYil())) {
            fDown.setVisible(true);
        }
        if (Integer.parseInt(filmGetir().get(i).getYil()) < Integer.parseInt(filmGetir().get(r1).getYil())) {
            fUp.setVisible(true);
        }
        if (filmGetir().get(i).getTur().equalsIgnoreCase(filmGetir().get(r1).getTur())) {
            System.out.println("Girdiğiniz film ile belirlenen filmin 'TÜR' bilgisi eşleşiyor. ");
            fTuru.setStyle("-fx-background-color: green");
            fPane.setVisible(true);
        }
        if (filmGetir().get(i).getUlke().equalsIgnoreCase(filmGetir().get(r1).getUlke())) {
            System.out.println("Girdiğiniz film ile belirlenen filmin 'ÜLKE' bilgisi eşleşiyor. ");
            fUlkesi.setStyle("-fx-background-color: green");
            fPane.setVisible(true);
        }
        if (filmGetir().get(i).getDirektor().equalsIgnoreCase(filmGetir().get(r1).getDirektor())) {
            System.out.println("Girdiğiniz film ile belirlenen filmin 'FİLM DİREKTÖRÜ' bilgisi eşleşiyor. ");
            fDirektoru.setStyle("-fx-background-color: green");
            fPane.setVisible(true);
        }
        if (filmGetir().get(i).getYildiz().equalsIgnoreCase(filmGetir().get(r1).getYildiz())) {
            System.out.println("Girdiğiniz film ile belirlenen filmin 'FİLM YILDIZI' bilgisi eşleşiyor. ");
            fYildizi.setStyle("-fx-background-color: green");
            fPane.setVisible(true);
        }
        if (!(filmGetir().get(i).getYil().equalsIgnoreCase(filmGetir().get(r1).getYil())) & !(filmGetir().get(i).getTur().equalsIgnoreCase(filmGetir().get(r1).getTur())) & !(filmGetir().get(i).getUlke().equalsIgnoreCase(filmGetir().get(r1).getUlke())) & !(filmGetir().get(i).getDirektor().equalsIgnoreCase(filmGetir().get(r1).getDirektor())) & !(filmGetir().get(i).getYildiz().equalsIgnoreCase(filmGetir().get(r1).getYildiz()))){
            System.out.println("HİÇBİR ÖZELLİK EŞLEŞMİYOR");
            fPane.setVisible(true);
        }
        if (filmGetir().get(i).getYil().equalsIgnoreCase(filmGetir().get(r1).getYil()) & filmGetir().get(i).getTur().equalsIgnoreCase(filmGetir().get(r1).getTur()) & filmGetir().get(i).getUlke().equalsIgnoreCase(filmGetir().get(r1).getUlke()) & filmGetir().get(i).getDirektor().equalsIgnoreCase(filmGetir().get(r1).getDirektor()) & filmGetir().get(i).getYildiz().equalsIgnoreCase(filmGetir().get(r1).getYildiz())){
            alert.setTitle("Tebrikler...");
            alert.setHeaderText("Tebrikler, oyunu kazandınız!");
            alert.setContentText("Doğru Filmi " + (6-hak) + ". denemede buldunuz");
            alert.getButtonTypes().setAll(tekrarOynaButton);
            alert.showAndWait();
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("tekrarOyna.fxml"));
                Parent rootTekrarOyna = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("CUTE POPCORN™ The Movie Guessing Game");
                stage.setScene(new Scene(rootTekrarOyna));
                stage.getIcons().add(new Image("https://upload.wikimedia.org/wikipedia/commons/6/6c/Popcorn_Time_logo.png?20140410070259"));
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                ((Stage) guessButton.getScene().getWindow()).close(); // Yeni oyunu başlatma ekranı geldiğinde önceki pencereyi kapatır.
                listViewFilmler = FXCollections.observableArrayList();
            }
        }
    }


}