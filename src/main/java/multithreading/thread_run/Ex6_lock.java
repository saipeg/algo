package multithreading.thread_run;

public class Ex6_lock {
    /*
    Без блока семафора для всех методов - будет одновременный доступ.
    Просто синхронайз на методе не поможет в таком случае.
     */

    static final Object lock = new Object();
    void phoneCall() {
        synchronized (lock) {
            System.out.println("Phone Call started");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Phone Call end");
        }
    }

    void skypeCall() {
        synchronized (lock) {

            System.out.println("Skype Call started");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Skype Call end");
        }
    }

    void whatsUpCall() {
        synchronized (lock) {

            System.out.println("WhatsUp Call started");
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("WhatsUp Call end");
        }
    }

    public static void main(String[] args) {
        Thread th1 = new Thread(new RunnableImplPhone());
        Thread th2 = new Thread(new RunnableImplWhatsUp());
        Thread th3 = new Thread(new RunnableImplSkype());

        th1.start();
        th2.start();
        th3.start();
    }
}

class RunnableImplPhone implements Runnable {

    @Override
    public void run() {
        new Ex6_lock().phoneCall();
    }
}

class RunnableImplSkype implements Runnable {

    @Override
    public void run() {
        new Ex6_lock().skypeCall();
    }
}

class RunnableImplWhatsUp implements Runnable {

    @Override
    public void run() {
        new Ex6_lock().whatsUpCall();
    }
}


