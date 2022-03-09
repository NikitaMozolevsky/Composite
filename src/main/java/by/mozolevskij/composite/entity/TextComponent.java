package by.mozolevskij.composite.entity;

import by.mozolevskij.composite.exception.CustomException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface TextComponent {

    static final Logger logger = LogManager.getLogger();

    void addComponent(TextComponent component) throws CustomException;

    void removeComponent(TextComponent component) throws CustomException;
}
