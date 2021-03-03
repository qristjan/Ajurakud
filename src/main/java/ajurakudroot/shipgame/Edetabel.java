package ajurakudroot.shipgame;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Edetabel {
    private String nimi;
    private int käikudearv;
    private Date aeg;
    private DateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");

    private List<String> sisu = new ArrayList<>();

    public Edetabel(String nimi, int käikudearv, Date aeg) {
        super();
        this.nimi = nimi;
        this.käikudearv = käikudearv;
        this.aeg = aeg;
    }

    public void kirjuta_faili() throws Exception {

        String tulemus = "Admiral: "+nimi + "; " + käikudearv + "; Kuupäev: " + df.format(aeg); //edetabeli rida


        try {
            @SuppressWarnings("resource")
            BufferedReader andmed = new BufferedReader(new InputStreamReader(new FileInputStream("andmed.txt"), "UTF-8")); //loeme failist edetabeli, kui seal midagi on (ka fail üldse)
            String rida = "";
            while ((rida = andmed.readLine()) != null) {
                System.out.println(rida);
                if (!sisu.contains(rida)) {
                    sisu.add(rida);}
            }
        }
        catch (IOException e) {} //tühi, sest pole selle veaga tegelikult vaja tegeleda

        sisu.add(tulemus); //lisame edetabelisse uue tulemuse
        //kirjutame uue tulemuse tagasi faili (kirjutame faile üle)
        PrintWriter writer = new PrintWriter("andmed.txt", "UTF-8");
        if (sisu.size() < 5) { //kui edetabel väiksem kui 5 rida, siis tulemus läheb kindlasti kirja
            for (int i = 0; i < sisu.size(); i++) {
                writer.println(järjestus(sisu).get(i));
            }
        }
        else if (sisu.size() >= 5) { //kui suurem, siis vastavalt "skoorile"
            for (int i = 0; i < 5; i++) {
                writer.println(järjestus(sisu).get(i));
            }
        }

        writer.close();

    }

    private List<String> järjestus(List<String> list) { //siin reastame tulemused vastavalt käikude arvule

        List<Integer> järg = new ArrayList<>();
        List<String> edetabel = new ArrayList<>();
        list.forEach(elem->järg.add(Integer.parseInt(elem.split(";")[1].trim())));

        Collections.sort(järg);

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (järg.get(i) == Integer.parseInt(list.get(j).split(";")[1].trim())) {
                    if (!edetabel.contains(list.get(j))) {
                        edetabel.add(list.get(j));}
                }
            }
        }
        return edetabel;
    }
    public String edetabel() throws IOException {
        String edetabelisse = "";
        try {
            @SuppressWarnings("resource")
            BufferedReader andmed = new BufferedReader(new InputStreamReader(new FileInputStream("andmed.txt"), "UTF-8"));
            String rida = "";
            while ((rida = andmed.readLine()) != null) {
                edetabelisse += rida + "\r\n";
            }
        }
        catch (IOException e) { //esialgu võime saada exceptioni, sest fail pole loodud, seega ka edetabel tühi
            edetabelisse = "Hetkel edetabel tühi!"; //näitame seda kasutajale
        }
        return edetabelisse;
    }

}