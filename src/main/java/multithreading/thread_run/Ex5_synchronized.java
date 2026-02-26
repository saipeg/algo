package multithreading.thread_run;

public class Ex5_synchronized {
    public static int counter = 0;

    public static synchronized void increment() { //Без синхронайза расчет будет неверный в рамках работы 2 и более потоков
        counter++;
    }

    public static void main(String[] args) throws InterruptedException {
        Thread coun1 = new Thread(new Count());
        Thread coun2 = new Thread(new Count());
        Thread coun3 = new Thread(new Count());
        coun1.start();
        coun2.start();
        coun3.start();
        coun1.join();
        coun2.join();
        coun3.join();
        System.out.println(counter);
    }

}

class Count implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 2000; i ++) {
            Ex5_synchronized.increment();
        }
    }
}
