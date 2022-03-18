package by.mozolevskij.composite.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {

    private final TextComponentType textComponentType;
    private List<TextComponent> components = new ArrayList<>();

    public TextComposite(TextComponentType textComponentType) {
        this.textComponentType = textComponentType;
    }

    public TextComponentType getTextComponentType() {
        return getTextComponentType();
    }

    public void addComponent(TextComponent componentType) {
        components.add(componentType);
    }

    public ArrayList<TextComponent> getChildComponentsList() {
        return new ArrayList<>(components);
    }

    public void removeComponent(TextComponent textComponent) {
        components.remove(textComponent);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (TextComponent component:
             components) {
            stringBuilder.append(textComponentType.getPrefix());
            stringBuilder.append(component);
            stringBuilder.append(textComponentType.getPostfix());
        }
        return stringBuilder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TextComposite that = (TextComposite) o;

        if (textComponentType != that.textComponentType) return false;
        return components != null ? components.equals(that.components) : that.components == null;
    }

    @Override
    public int hashCode() {
        int result = textComponentType != null ? textComponentType.hashCode() : 0;
        result = 31 * result + (components != null ? components.hashCode() : 0);
        return result;
    }
}
