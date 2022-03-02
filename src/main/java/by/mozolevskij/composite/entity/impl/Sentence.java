package by.mozolevskij.composite.entity.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Sentence implements Iterable<SimplePart> {
    private List<SimplePart> parts = new ArrayList<>();

    public Sentence(List<SimplePart> parts) {
        this.parts = parts;
    }

    public List<SimplePart> getParts() {
        return parts;
    }

    public void setParts(List<SimplePart> parts) {
        this.parts = parts;
    }


    @Override
    public Iterator<SimplePart> iterator() {
        return parts.iterator();
    }
}
