package by.mozolevskij.composite.reader.impl;

import by.mozolevskij.composite.exception.CustomException;
import by.mozolevskij.composite.reader.CustomFileReader;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CustomFileReaderImpl implements CustomFileReader {

    private static final Logger log = LogManager.getLogger();
    @Override
    public String reader(String filePath) {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath)))
        {

            String sCurrentLine;
            while ((sCurrentLine = br.readLine()) != null)
            {
                contentBuilder.append(sCurrentLine).append("\n");
            }
        }
        catch (IOException e)
        {
            log.log(Level.ERROR, e);
        }
        return contentBuilder.toString();
    }
}
