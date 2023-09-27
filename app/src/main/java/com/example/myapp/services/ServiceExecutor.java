package com.example.myapp.services;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public abstract class ServiceExecutor<T> {
    private ExecutorService executorService;

    public ServiceExecutor(int nThreads) {
        this.executorService = Executors.newFixedThreadPool(nThreads);
    }

    public abstract ServiceExecutor<T> getServiceExecutor();

    public void runnableMethod(Runnable runnable) {
        executorService.execute(runnable);
    }

    public Future submitMethodRun(Runnable runnable) {
        return executorService.submit(runnable);
    }

    public Future<T> submitMethodCallable(Callable<T> callable) {
        return executorService.submit(callable);
    }
    /*public List<Future<T>> submitMethodCallableAll(List<Callable<T>> callables){
        return executorService.invokeAll(callables);
    }
    public Future<T> submitMethodCallableAny(List<Callable<T>> callables){
        return executorService.invokeAny(callables);
    }*/

    public List<Runnable> taskRunnable() {
        return executorService.shutdownNow();
    }

    public void stop() {
        try {
            if (!executorService.awaitTermination(800, TimeUnit.MILLISECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }
    }
}
