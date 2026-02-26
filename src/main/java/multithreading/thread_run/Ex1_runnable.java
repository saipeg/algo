package multithreading.thread_run;

public class Ex_runnable {
    public static void main(String[] args) {
        Thread thr1 = new Thread(new MyThread());
        thr1.start();
    }
}

class MyThread implements Runnable {

    @Override
    public void run() {
        System.out.println("Do some work");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Work done");
    }
}
