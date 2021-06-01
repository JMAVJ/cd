package me.cd.countries.models;

public enum EnumContinents {
    STRING_ONE("Asia"), 
    STRING_TWO("Europe"),
    STRING_THREE("North America"),
    STRING_FOUR("Africa"),
    STRING_FIVE("Oceania"),
    STRING_SIX("Antarctica"),
    STRING_SEVEN("South America");
    
    private String text;
    
    EnumContinents(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
