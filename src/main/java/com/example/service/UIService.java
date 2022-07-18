package com.example.service;

import java.util.List;
import java.util.Map;

public interface UIService {
    void print(Object object);

    <T> void printList(List<T> objects);

    Map<String, List<String>> readConsole(List<String> question);
}
