package com.example.service;

import java.util.List;

public interface PrintService {
    void print(Object object);

    <T> void printList(List<T> objects);
}
