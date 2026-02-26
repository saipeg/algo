package multithreading.thread_run;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ex10_ExecutorService_Fixed {
    public static void main(String[] args) {
//        ExecutorService executorService = Executors.newFixedThreadPool(5); //  в 5 раз быстрее
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++) {
            executorService.execute(new RunnableImplWork());
        }

        executorService.shutdown();
    }
}

class RunnableImplWork implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
