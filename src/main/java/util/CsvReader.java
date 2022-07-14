package util;

import com.opencsv.CSVReader;
import org.springframework.core.io.DefaultResourceLoader;

import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
    public static List<String[]> readResource(String resourcePath) {
        try {
            var resource = new DefaultResourceLoader().getResource("classpath:" + resourcePath);
            var reader = new InputStreamReader(resource.getInputStream());
            var csvReader = new CSVReader(reader);
            var list = csvReader.readAll();
            reader.close();
            csvReader.close();
            return list;
        } catch (IOException ex) {
            System.out.printf("Exception while getting data from csv resource: %s", ex.getMessage());
            return new ArrayList<>();
        }
    }
}
