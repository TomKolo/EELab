package pl.gda.pg.eti.kask.javaee.jsf.business.entities;
public enum TypeOfMusic {
    CLASSIC("Classic"), ROCK("Rock"), BLUES("Blues"), JAZZ("Jazz"), POP("Pop");

    private final String text;

    TypeOfMusic(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}