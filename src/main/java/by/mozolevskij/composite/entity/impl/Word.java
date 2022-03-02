package by.mozolevskij.composite.entity.impl;

public class Word extends SimplePart /*implements Comparable<SimplePart>*/ {

    public Word(String item) {  //???
        super(item);
    }

    @Override
    public boolean isWord() {
        return true;
    }

    @Override
    public boolean isSpace() {
        return false;
    }

    @Override
    public boolean isPunctuation() {
        return false;
    }

    /*@Override
    public int compareTo(SimplePart o) {
        return getItem().compareToIgnoreCase(o.getItem());
    }*/
}
