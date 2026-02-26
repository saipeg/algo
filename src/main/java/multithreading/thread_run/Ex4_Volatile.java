package multithreading.thread_run;

public class Ex4_Volatile extends Thread {
    volatile boolean b = true; // без volatile луп не закончится так как переменная кешируется

    public void run() {
        long counter = 0;
        while (b) {
            counter++;
        }
        System.out.println("Loop is finished. Loop count: " + counter);
    }

    public static void main(String[] args) throws InterruptedException {
        Ex4_Volatile exVolatile = new Ex4_Volatile();
        exVolatile.start();
        Thread.sleep(3000);
        System.out.println("Afret 3 sec time to wake up!");

        exVolatile.b = false;
        exVolatile.join();

        System.out.println("_ _ _ F I N I S H _ _ _ ");
    }
}
