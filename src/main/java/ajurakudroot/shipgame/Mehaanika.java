package ajurakudroot.shipgame;

import java.util.Random;

public class Mehaanika { //mehhaanika klass vastutab mängu kõige üldisemate mehhanismide üle, siin tehakse algne maatriks , mitte graafiline
    private static int laevad; //paigutatakse laevu , kontrollitakse koordinaate, mida mängija annab jne
    private static int[][] maatriks = new int[9][9];
    private static boolean esimene_kord=true;
    private static boolean kolmene_laev=false;

    public static  String kontrollija(int veerg, int rida) {
        if (esimene_kord) { //kui mäng alles algas, siis paneme laevad maatriksisse
            topi_laevad();
            esimene_kord=false;
        }
        if (maatriks[veerg][rida]==1) return "X";
        else return "*";
    }

    public static void setLaevad(int laevad) {
        Mehaanika.laevad = laevad;
    }

    private static  void topi_laevad() { //see
        for (int i = 0; i < laevad; i++) {
            while (true) {
                Random koord = new Random();
                int laev_x = koord.nextInt(9);
                int laev_y = koord.nextInt(9);
                if (!kolmene_laev && (laev_x>=0 && laev_x<=6)) { //Asetame kolmese laeva lauale, võimalik koodi kõvasti optimiseerida
                    for (int veerg=laev_x;veerg<laev_x+3; veerg++ ) { //Tsükkel, mis paneb laeva lauale
                        Pommid.lisalaevad(veerg, laev_y); //
                        maatriks[laev_y][veerg]=1;
                        //System.out.println(veerg+1+" "+(laev_y+1)); //TESTIMISEKS
                    }
                    for (int x=laev_x-1; x<laev_x+5; x++) { //Paneme kinni need asukohad, kuhu enam ei tohi laeva panna
                        for (int y=laev_y-1;y<laev_y+2;y++) {
                            if (!Pommid.h6ivatud_asukohad.contains(x + "," + y) && (x>=0 & x<=8) && (y>=0 & y<=8)){
                                Pommid.lisa_hõivatud_asukohad(x,y);
                            }
                        }
                    }
                    kolmene_laev = true;
                    break;
                }


                else if (!Pommid.h6ivatud_asukohad.contains(laev_x + "," + laev_y) && kolmene_laev) {//Kui listis veel seda pole
                    Pommid.lisalaevad(laev_x, laev_y);
                    maatriks[laev_y][laev_x] = 1;
                    for (int x = laev_x - 1; x < laev_x + 2; x++) { //Lisame ümberkaudsed koordinaadid uudesse listi
                        for (int y = laev_y - 1; y < laev_y + 2; y++) {
                            if (!Pommid.h6ivatud_asukohad.contains(x + "," + y) && (x>-1 & x<9) && (y>-1 & y<9)) {
                                Pommid.lisa_hõivatud_asukohad(x, y);
                            }
                        }
                    }
                    break;
                }
            }
        }
    }
}