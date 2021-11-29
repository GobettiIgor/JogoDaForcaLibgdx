package enums;

/*
FRUTA
CONSTRUÇÃO CIVIL
INFORMÁTICA
INSTRUMENTO MUSICAL
COMIDA
 */
public enum PossibleWords {
    MELANCIA("FRUTA"),
    AREIA("CONSTRUÇÃO CIVIL"),
    COMPUTADOR("INFORMÁTICA"),
    UVA("FRUTA"),
    TIJOLO("CONSTRUÇÃO CIVIL"),
    POLENTA("COMIDA"),
    SERVIDOR("INFORMÁTICA"),
    CRAVIOLA("INSTRUMENTO MUSICAL"),
    CUSCUZ("COMIDA"),
    CAVAQUINHO("INSTRUMENTO MUSICAL");

    private String description;

    PossibleWords(String description){
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }
}
