package multithreading.thread_run;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ex9_tryLock {

}

/*
В данном примере показана работа c tryLock при использовании 1 ресурса несколькими потоками
Можно решить что делать в случае если ресурс занят и мы не хотим ждать.
 */

class Bankomat2 {
    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        new Employee2("Andro", lock);
        new Employee2("Mari", lock);
        new Employee2("Petro", lock);
        Thread.sleep(5000);
        new Employee2("Kent", lock);
        new Employee2("Nata", lock);
    }
}

class Employee2 extends Thread {
    String name;
    private Lock lock;

    public Employee2(String name, Lock lock) {
        this.name = name;
        this.lock = lock;
        this.start();
    }

    @Override
    public void run() {
        System.out.println(name + " ждет");
        if (lock.tryLock()) {
            try {
                System.out.println(name + " пользуется банкоматом");
                Thread.sleep(2000);
                System.out.println(name + " завершил дела");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {
                lock.unlock();
            }

        } else {
            System.out.println(name + " забил болт и ушел");
        }
    }
}
