package movie.game.popcorn;

public class Filmm {
    private String ad;
    private String yil;
    private String tur;
    private String ulke;
    private String direktor;
    private String yildiz;

    public Filmm(String ad, String  yil, String tur, String ulke, String direktor, String yildiz){
        this.ad = ad;
        this.yil = yil;
        this.tur = tur;
        this.ulke = ulke;
        this.direktor = direktor;
        this.yildiz= yildiz;
    }

    public String getAd() {
        return ad;
    }
    public void setAd() {
        this.ad = ad;
    }

    public String getYil() {
        return yil;
    }
    public void setYil() {
        this.yil = yil;
    }

    public String getTur() {
        return tur;
    }
    public void setTur() {
        this.tur = tur;
    }

    public String getUlke() {
        return ulke;
    }
    public void setUlke() {
        this.ulke = ulke;
    }

    public String getDirektor() {
        return direktor;
    }
    public void setDirektor() {
        this.direktor = direktor;
    }

    public String getYildiz() {
        return yildiz;
    }
    public void setYildiz() {
        this.yildiz = yildiz;
    }


}
