package enums;

/*
FRUTA
CONSTRUÇÃO CIVIL
INFORMÁTICA
INSTRUMENTO MUSICAL
COMIDA
 */
public enum PossibleWords {
    melancia("FRUTA"),
    areia("CONSTRUCAO CIVIL"),
    computador("INFORMATICA"),
    uva("FRUTA"),
    tijolo("CONSTRUCAO CIVIL"),
    polenta("COMIDA"),
    servidor("INFORMATICA"),
    craviola("INSTRUMENTO MUSICAL"),
    cuscuz("COMIDA"),
    cavaquinho("INSTRUMENTO MUSICAL");

    private String description;

    PossibleWords(String description){
        this.description = description;
    }

    public String getDescription(){
        return this.description;
    }
}
