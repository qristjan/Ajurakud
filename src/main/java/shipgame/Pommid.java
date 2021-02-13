package shipgame;

import java.util.ArrayList;

public class Pommid { //siin klassis teeme erinevad listid valmis

    public static ArrayList<String> asukohad = new ArrayList<>(); //kuhu on juba lastud
    public static ArrayList<String> laevad = new ArrayList<>(); //kus asuvad laevad
    public static ArrayList<String> h6ivatud_asukohad=new ArrayList<>(); //kuhu kindlasti ei lase programm laevu panna (iga laeva ümber peab jääma 8 vaba ruutu


    public static void lisakoordinaadid(int pomm_x, int pomm_y) {
        asukohad.add(pomm_x + "," + pomm_y);

    }
    public static void lisalaevad(int x, int y) {
        laevad.add(x + "," + y);

    }
    public static void lisa_hõivatud_asukohad(int x, int y) {
        h6ivatud_asukohad.add(x+","+y);
    }

}