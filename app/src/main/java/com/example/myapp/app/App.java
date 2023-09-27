package com.example.myapp.app;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App extends android.app.Application {
    ExecutorService executorService = Executors.newFixedThreadPool(4);
}
