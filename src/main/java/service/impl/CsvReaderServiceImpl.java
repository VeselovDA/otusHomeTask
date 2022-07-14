package service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import service.ReaderService;
import util.CsvReader;

import java.util.List;
@Service("readerService")
@PropertySource("classpath:application.properties")
public class CsvReaderServiceImpl implements ReaderService {
    @Value("${resourcePath}")
    private String resourcePath;

    @Override
    public List<String[]> readAllQuestions() {
        return CsvReader.readResource(resourcePath);
    }
}
