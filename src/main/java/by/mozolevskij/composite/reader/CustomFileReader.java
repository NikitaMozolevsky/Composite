package by.mozolevskij.composite.reader;

import by.mozolevskij.composite.exception.CustomException;

import java.io.File;

public interface CustomFileReader {
    String reader(String filePath) throws CustomException;
}
