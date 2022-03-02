package by.mozolevskij.composite.entity.impl;

public abstract class SimplePart {
    String item;

    public SimplePart(String item) {
        this.item = item;
    }

    public abstract boolean isWord();

    public abstract boolean isSpace();

    public abstract boolean isPunctuation();

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SimplePart that = (SimplePart) o;

        return item != null ? item.equals(that.item) : that.item == null;
    }

    @Override
    public int hashCode() {
        return item != null ? item.hashCode() : 0;
    }
}
