package com.example.config;

import com.example.service.TestingService;
import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
@RequiredArgsConstructor
public class MyShellComponent {
    private final TestingService testingService;

    @ShellMethod(value = "Test")
    void test (){
        testingService.startTest();
    }
}
