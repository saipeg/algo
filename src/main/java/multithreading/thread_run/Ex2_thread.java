package multithreading.thread_run;

public class Ex2_thread {
    public static void main(String[] args) {
        new Thread(() -> System.out.println("Do some work from lambda")).start();
        MyThreadFromExtend thr1 = new MyThreadFromExtend();
        thr1.start();
    }
}

class MyThreadFromExtend extends Thread {
    public void run() {
        System.out.println("Worked from extend Thread");
    }
}
