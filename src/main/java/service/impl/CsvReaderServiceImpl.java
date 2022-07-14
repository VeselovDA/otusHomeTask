package service.impl;

import service.ReaderService;
import util.CsvReader;

import java.util.List;

public class CsvReaderServiceImpl implements ReaderService {

    @Override
    public List<String[]> readAllQuestions() {
        return CsvReader.readResource();
    }
}
