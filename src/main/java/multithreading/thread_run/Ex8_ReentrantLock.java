package multithreading.thread_run;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ex8_ReentrantLock {

}

/*
В данном примере показана работа c Lock при использовании 1 ресурса несколькими потоками
 */

class Bankomat {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();
        new Employee("Andro", lock);
        new Employee("Mari", lock);
        new Employee("Petro", lock);
        new Employee("Kent", lock);
        new Employee("Nata", lock);
    }
}

class Employee extends Thread {
    String name;
    private Lock lock;

    public Employee(String name, Lock lock) {
        this.name = name;
        this.lock = lock;
        this.start();
    }

    @Override
    public void run() {
        System.out.println(name + " ждет");
        lock.lock();
        try {
            System.out.println(name + " пользуется банкоматом");
            Thread.sleep(5000);
            System.out.println(name + " завершил дела");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            lock.unlock();
        }

    }
}
