package lahedada_annotatsioonid;

public class Main {
    public static void main(String[] args) {
        @AegunudAnnotatsioon(Reason = "pickle rick", Developer = "QR KOODI RISTJAN") var Kristjan = "Ma muutsin ennast lokaalseks muutujaks";
        System.out.println(Kristjan);
        var TAGANDAmINE = _markus();
    }


    static @AegunudAnnotatsioon(Reason = "BECAUSE, WHEN THE SUN SHINES WELL SHINE TOGETHER TOLD U ILL BE HERE FOREVER SAID ILL ALWAYS BE A FRIEND", Developer = "Markus") int _markus(){
        System.out.println("Ma muutsin end printeriks");
        return 0;
    }
}
