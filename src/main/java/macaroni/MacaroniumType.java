package macaroni;

public enum MacaroniumType {

    GNOCCHI("gnocchi");

    public final String type;

    MacaroniumType(String macaroniumType) {
        this.type = macaroniumType;
    }

    public String getType() {
        return type;
    }
}
