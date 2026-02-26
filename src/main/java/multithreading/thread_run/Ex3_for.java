package multithreading.thread_run;

public class Ex3_for {

    public static void main(String[] args) throws InterruptedException {
        Th1 th1 = new Th1();
        Th2 th2 = new Th2();

        th1.start();
        th2.start();

        th1.join();
        th2.join(); //На том потоке, в котором вызывается JOIN - ставится пауза в выполнении пока не закончатся указанные потоки

        System.out.println("_ _ _ F I N I S H _ _ _ ");
    }
}


class Th1 extends Thread {
    @Override
    public void run() {
        for(int i = 0; i < 100; i++ ) {
            System.out.println(i);
        }
    }
}

class Th2 extends Thread {
    @Override
    public void run() {
        for(int i = 100; i > 0; i-- ) {
            System.out.println(i);
        }
    }
}