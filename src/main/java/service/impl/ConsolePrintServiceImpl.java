package service.impl;

import service.PrintService;

import java.util.List;

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
