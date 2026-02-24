package com.example.demo.thread;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.TimeZone;

class VisualVolatileDemo {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║  ДЕМОНСТРАЦИЯ VOLATILE VS NON-VOLATILE   ║");
        System.out.println("╚════════════════════════════════════════════╝\n");

        // Тест 1: Проблема видимости
        System.out.println("🔴 ТЕСТ 1: Проблема видимости (без volatile)");
        System.out.println("----------------------------------------");
        testVisibility(false);

        Thread.sleep(1500);

        System.out.println("\n🟢 ТЕСТ 2: С volatile (проблема видимости решена)");
        System.out.println("----------------------------------------");
        testVisibility(true);

        Thread.sleep(1500);

        // Тест 3: Проблема number (даже с volatile ready)
        System.out.println("\n⚠️ ТЕСТ 3: number может быть 0 даже с volatile ready");
        System.out.println("----------------------------------------");
        testNumberVisibility();
    }

    private static void testVisibility(boolean useVolatile) throws InterruptedException {
        class TestClass {
            static boolean ready = false;
            static int counter = 0;
        }

        class VolatileTestClass {
            static volatile boolean ready = false; // volatile
            static int counter = 0;
        }

        if (!useVolatile) {
            // Тест без volatile
            Thread reader = new Thread(() -> {
                int localCounter = 0;
                while (!TestClass.ready) {
                    localCounter++;
                    if (localCounter % 100_000_000 == 0) {
                        System.out.println("   ⏳ Reader ждет... (итераций: " + localCounter + ")");
                    }
                }
                System.out.println("   ✅ Reader увидел ready! counter = " + TestClass.counter);
            });

            reader.start();
            Thread.sleep(500); // Даем потоку стартануть

            System.out.println("   Main: устанавливаю ready = true");
            TestClass.counter = 100;
            TestClass.ready = true;

            reader.join(2000);
            if (reader.isAlive()) {
                System.out.println("   ❌ Reader НЕ УВИДЕЛ ready! (поток завис)");
                reader.interrupt();
            }

        } else {
            // Тест с volatile
            Thread reader = new Thread(() -> {
                int localCounter = 0;
                while (!VolatileTestClass.ready) {
                    localCounter++;
                    if (localCounter % 100_000_000 == 0) {
                        System.out.println("   ⏳ Reader ждет... (итераций: " + localCounter + ")");
                    }
                }
                System.out.println("   ✅ Reader увидел ready! counter = " + VolatileTestClass.counter);
            });

            reader.start();
            Thread.sleep(500);

            System.out.println("   Main: устанавливаю ready = true");
            VolatileTestClass.counter = 100;
            VolatileTestClass.ready = true;

            reader.join(2000);
            if (reader.isAlive()) {
                System.out.println("   ❌ Reader НЕ УВИДЕЛ ready! (с volatile такого не должно быть)");
                reader.interrupt();
            }
        }
    }

    private static void testNumberVisibility() throws InterruptedException {
        class Test {
            static volatile boolean ready = false; // volatile
            static int number = 0; // обычная переменная
        }

        System.out.println("   Запускаем 10 раз тест с volatile ready, но обычным number:");

        int zeroCount = 0;
        for (int i = 0; i < 10; i++) {
            Test.ready = false;
            Test.number = 0;

            Thread reader = new Thread(() -> {
                while (!Test.ready) {
                    Thread.yield();
                }
                int value = Test.number;
                if (value == 0) {
                    System.out.println("   ⚠️  Прочитали number = 0 (хотя main присвоил 42!)");
                }
            });

            reader.start();

            // Иногда делаем reordering более вероятным
            if (i % 3 == 0) {
                Thread.sleep(1);
            }

            Test.number = 42;
            Test.ready = true;

            reader.join(500);

            if (Test.number == 42 && reader.isAlive()) {
                System.out.println("   ❌ Reader завис!");
            }
        }

        System.out.println("   📊 Итог: number может быть 0, потому что volatile ready");
        System.out.println("           не синхронизирует доступ к number!");
    }
}
