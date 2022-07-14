package service.impl;

import org.springframework.stereotype.Service;
import service.PrintService;

import java.util.List;
@Service("printService")
public class ConsolePrintServiceImpl implements PrintService {

    @Override
    public void print(Object object) {
        System.out.println(object);
    }

    @Override
    public <T> void printList(List<T> objects) {
        objects.forEach(System.out::println);
    }

}
