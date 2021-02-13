import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import shipgame.Admiral;
import shipgame.Edetabel;
import shipgame.Mehaanika;
import shipgame.Pommid;

import java.io.File;
import java.util.Date;

public class Graafiline_ruudustik extends Application {
    private int laskmisi_lubatud=50;
    private boolean mäng_pooleli=true;

    public static void main(String[] args) {
        launch();
    }

    public void start(Stage sissejuhatus) {
        //all esimese avaneva akna atribuudid
        Label tekst = new Label("EESMÄRK");
        Label tekst1 = new Label("Teie kui  admirali ülesandeks on põhja lasta kõik vaenlase " + "\n"
                + "alused enne, kui saabub vaenlase lennuvägi. Vaenlase" + "\n"
                + "laevad on üldjuhul ühekohalised, aga leidub ka kolmekohaline " + "\n"
                + "emalaev. Laevade asukohad on juhuslikult valitud, aga iga laeva" + "\n"
                + "ümber on alati tühjad ruudud.");

        Label tekst2 = new Label("Sisesta laevade arv (1-15): ");

        TextField laevade_arv = new TextField();
        laevade_arv.setAlignment(Pos.CENTER);

        Label tekst3 = new Label("Sisestage oma nimi (1-8 märki): ");

        TextField nimi = new TextField();
        nimi.setAlignment(Pos.CENTER);

        FlowPane pane = new FlowPane();
        Button ok = new Button("OK");

        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(ok);


        VBox vBox = new VBox(1); //SIIA HAKKA LISAMA INFOT!
        vBox.setPrefWidth(350);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(tekst, tekst1, tekst2, laevade_arv, tekst3, nimi, pane);

        Scene stseen = new Scene(vBox);
        sissejuhatus.setMinHeight(290);
        sissejuhatus.setMinWidth(370);
        sissejuhatus.setScene(stseen);
        sissejuhatus.show();

        ok.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me)   {
                sissejuhatus.hide(); //PANEME KINNI ESIMESE AKNA

                try {

                    if (Integer.parseInt(laevade_arv.getText())>15 || Integer.parseInt(laevade_arv.getText())<1 )  throw  new NumberFormatException(); //vale laevade arv
                    if (nimi.getText().equals("")) throw new IllegalArgumentException(); //nimi puudub
                    if (nimi.getLength() > 8) throw new IllegalArgumentException(); //nime pikkus on piiratud, et ei läheks aknast välja
                    Mehaanika.setLaevad(Integer.parseInt(laevade_arv.getText()));
                    String a=nimi.getText();//võtame admirali nime

                    loo_ruudustik(a, Integer.parseInt(laevade_arv.getText()));
                }
                catch (NumberFormatException e) {
                    tekkis_viga("number");
                }
                catch (IllegalArgumentException e) {
                    tekkis_viga("nimi");}
            }
        });
    }

    private void tekkis_viga(String põhjus) { //püüame kasutaja poolt tekitatud erindid kinni ja vaatame, millega täpsemalt tegemist
        Stage vastus = new Stage();
        Label tekst1 = new Label();
        if (põhjus.equals("number")) {
            tekst1.setText("Vigane laevade arv");
            tekst1.setFont(Font.font("Verdana", 15));
        }
        else if (põhjus.equals("nimi")) {
            tekst1.setText("Vigane nimi");
            tekst1.setFont(Font.font("Verdana", 15));
        }

        Button ok = new Button("OK");
        VBox vBox = new VBox(5); //SIIA HAKKA LISAMA INFOT!
        vBox.setPrefWidth(300);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(tekst1,ok);

        ok.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                start(new Stage());
                vastus.hide();
            }
        });

        Scene stseen2 = new Scene(vBox);
        vastus.setTitle("Viga");
        vastus.setMinHeight(100);
        vastus.setMinWidth(300);
        vastus.setScene(stseen2);
        vastus.show();
    }

    private void loo_ruudustik(String admiral, int laevad) {
        if (laevad > 0 && laevad <= 3) { laskmisi_lubatud = 65;} //otsustame palju laskmisi lubame
        else if (laevad > 3 && laevad <= 6) {laskmisi_lubatud = 60;}
        else if  (laevad > 6 && laevad <= 9) {laskmisi_lubatud = 55;}
        else if (laevad > 9 && laevad <= 12) {laskmisi_lubatud = 50;}
        else if (laevad > 12 && laevad < 16) {laskmisi_lubatud = 45;}

        int käikude_koguarv=laskmisi_lubatud;//seda vaja hiljem statistika loomeks
        //allpool loome peamise mänguakna ja sellega seonduva
        Admiral nimi=new Admiral(admiral);
        Stage peaLava = new Stage();
        BorderPane piir = new BorderPane();
        GridPane ruudustik = new GridPane();
        TextField mänguinfo = new TextField();
        mänguinfo.setText("Siia tuleb mänguinfo, admiral!");
        mänguinfo.setAlignment(Pos.CENTER);
        mänguinfo.setEditable(false);
        peaLava.setMinHeight(300);
        peaLava.setMinWidth(300);

        File file = new File("pilt.jpg"); //TAGATAUST
        Image image = new Image(file.toURI().toString());
        ImageView iv = new ImageView(image);

        //All erinevad hääled, mis mängus ilmnevad
        Media media1 = new Media(new File("boom.mp3").toURI().toString());
        MediaPlayer mediaPlayer1 = new MediaPlayer(media1);
        MediaView mediaView1 = new MediaView(mediaPlayer1);
        mediaPlayer1.setVolume(0.4);

        Media media2 = new Media(new File("miss.mp3").toURI().toString());
        MediaPlayer mediaPlayer2 = new MediaPlayer(media2);
        MediaView mediaView2 = new MediaView(mediaPlayer2);
        mediaPlayer2.setVolume(0.3);

        Media media = new Media(new File("laul.mp3").toURI().toString()); //taustalaul
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        MediaView mediaView = new MediaView(mediaPlayer);
        mediaPlayer.setVolume(0.2);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) { //PANEME NUPPE
                Button nupp = new Button("~"); //antud nupp tähistab "teadmata merd"
                nupp.setPrefWidth(25);
                ruudustik.add(nupp, i, j);


                nupp.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {

                    public void handle(MouseEvent me) {

                        if (mäng_pooleli) { //kontrollime, kas mäng veel kestab või on lõpppenud

                            int veerg = GridPane.getRowIndex(nupp);
                            int rida = GridPane.getColumnIndex(nupp);

                            if (!Pommid.asukohad.contains(veerg + "," + rida)) {

                                nupp.setText(Mehaanika.kontrollija(veerg, rida));
                                laskmisi_lubatud = laskmisi_lubatud - 1; //vähendame käikude arvu

                                if (nupp.getText().equals("X")) {

                                    mediaPlayer1.stop();
                                    mediaPlayer1.play();
                                    int index = Pommid.laevad.indexOf(rida + "," + veerg); //leiame sisestatud koordinaadi indeksi listist
                                    Pommid.laevad.remove(index);
                                    mänguinfo.setText(nimi.getNimi() + ", pihtalask! Laske jäänud " + laskmisi_lubatud+", tabamiskohti: "+Pommid.laevad.size());

                                    if (Pommid.laevad.size() == 0) {    //Prioriteetsete tingimuste kontroll

                                        mänguinfo.setText("Kõik vaenlase laevad uputatud, " + (nimi.getNimi()));
                                        mäng_pooleli=false;
                                        try { //Nõuab, et oleks try ja catch, kuigi tegelikult mingit viga ei saa tekkida
                                            mängu_lõpp(nimi.getNimi(), "võit", käikude_koguarv);
                                        } catch (Exception e) {System.out.println("Siia ta nkn ei jõua!");}

                                    } else if (laskmisi_lubatud == 0) {
                                        try {
                                            näita_laevad();
                                        } catch (Exception e) {System.out.println("Siia ta ei jõua!");}
                                    }

                                } else {

                                    mediaPlayer2.stop();
                                    mediaPlayer2.play();
                                    mänguinfo.setText(nimi.getNimi() + ", möödalask! Laske jäänud " + laskmisi_lubatud+", tabamiskohti: "+Pommid.laevad.size());
                                    if (laskmisi_lubatud == 0) {
                                        try {
                                            näita_laevad();
                                        } catch (Exception e) {System.out.println("Siia ta nkn ei jõua kunagi!");}
                                    }
                                }

                                Pommid.lisakoordinaadid(veerg, rida); //paneme kirja kuhu kasutaja juba pommitanud

                            } else {
                                mänguinfo.setText(nimi.getNimi() + ", olete siia juba lasknud!");
                            }

                        }

                    }
                    public void näita_laevad() throws Exception { //meetod mis tähistab kaotust, näitab ette kõik laevade asukohad

                        mänguinfo.setText("Vaenlase lennuvägi hävitas meie laevastiku, " + nimi.getNimi());
                        mäng_pooleli=false;
                        mängu_lõpp(nimi.getNimi(), "kaotus", käikude_koguarv);
                        for (String a: Pommid.laevad)  {
                            Button nupp = new Button("X");
                            nupp.setTextFill(Color.RED);
                            nupp.setPrefWidth(25);
                            String[] tükid=a.split(",");
                            ruudustik.add(nupp, Integer.parseInt(tükid[0]), Integer.parseInt(tükid[1]));
                        }
                    }
                });
            }
        }


        piir.getChildren().addAll(iv, mediaView, mediaView1, mediaView2);

        ruudustik.setAlignment(Pos.CENTER);
        piir.setTop(mänguinfo);
        piir.setCenter(ruudustik);

        Scene stseen = new Scene(piir, 350, 250, Color.SNOW);
        peaLava.setTitle("Laevade pommitamine");
        peaLava.setScene(stseen);
        peaLava.show();


    }
    private int getLaskmisi_lubatud() {
        return laskmisi_lubatud;
    }
    private void mängu_lõpp(String admiralinimi, String tulemus, int käikude_koguarv) throws Exception {
        //kui mäng läbi loome uue akna, kus teatame sellest ja näitame edetabelit
        Stage vastus = new Stage();
        Label tekst1 = new Label();
        Label tekst1_lisa=new Label();
        Label edetabel = new Label();
        Label edetabel1 = new Label();
        FlowPane pane = new FlowPane();
        Button exit = new Button("Välju");

        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(exit);

        VBox vBox = new VBox(10);
        vBox.setPrefWidth(275);
        vBox.setAlignment(Pos.CENTER);
        vBox.getChildren().addAll(tekst1,tekst1_lisa, edetabel , edetabel1,pane); //lisame vboxile sisu
        Edetabel uus = new Edetabel(admiralinimi, käikude_koguarv-getLaskmisi_lubatud(), new Date());
        edetabel.setText("Edetabel: " + "\n");
        edetabel.setFont(Font.font ("Verdana", 20));
        tekst1.setFont(Font.font ("Verdana", 16));
        tekst1_lisa.setFont(Font.font ("Verdana", 16));

        //ANALÜÜSIME KUIDAS MÄNG LÕPPES
        if (tulemus.equals("võit")) {
            vastus.setTitle("VÕIT");
            uus.kirjuta_faili();
            tekst1.setTextFill(Color.GREEN);
            tekst1_lisa.setTextFill(Color.GREEN);
            tekst1.setText("Suurepärane võit admiral! ");
            tekst1_lisa.setText("Mäng kestis "+(käikude_koguarv-getLaskmisi_lubatud())+" käiku!");
        }
        else if (tulemus.equals("kaotus")) {
            vastus.setTitle("KAOTUS");
            tekst1.setTextFill(Color.RED);
            tekst1_lisa.setTextFill(Color.RED);
            tekst1.setText("See lahing on kaotatud,");
            tekst1_lisa.setText("aga  sõja võidame me kindlasti!");
            edetabel.setFont(Font.font ("Verdana", 20));
        }
        edetabel1.setText(uus.edetabel());

        exit.setOnMouseClicked(event -> System.exit(1));
        Scene stseen3 = new Scene(vBox);
        vastus.setMinHeight(250);
        vastus.setMinWidth(300);
        vastus.setScene(stseen3);
        vastus.show();
    }
}