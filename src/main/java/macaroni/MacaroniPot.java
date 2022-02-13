package macaroni;

public class MacaroniPot {

    public static void main(String[] args) {
        fillPot();
    }

    public static void fillPot() {
        MacaroniFetcher macaroniFetcher = new MacaroniFetcher();

        macaroniFetcher.getByType(MacaroniumType.GNOCCHI);
    }

}
