package multithreading.thread_run;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ex7_lock_block {
    public static void main(String[] args) {
        Call call = new Call();
        Thread thr1 = new Thread(call::mobilCall);
        Thread thr2 = new Thread(call::skypeCall);
        Thread thr3= new Thread(call::whatsUpCall);

        thr1.start();
        thr2.start();
        thr3.start();

    }
}

class Call {
    private Lock lock = new ReentrantLock();

    void mobilCall() {
        lock.lock();
        try {
            System.out.println("Mobile call started");
            Thread.sleep(5000);
            System.out.println("Mobile call end");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        finally {
            lock.unlock();
        }
    }

    void skypeCall() {
        lock.lock();
        try {
            System.out.println("Skype call started");
            Thread.sleep(5000);
            System.out.println("Skype call end");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        finally {
            lock.unlock();
        }
    }

    void whatsUpCall() {
        lock.lock();
        try {
            System.out.println("WhatsUp call started");
            Thread.sleep(5000);
            System.out.println("WhatsUp call end");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        finally {
            lock.unlock();
        }
    }
}