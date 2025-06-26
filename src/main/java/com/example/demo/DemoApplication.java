package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.Serializable;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	static class Parent implements Cloneable {

	}

	static class Singleton extends Parent implements Serializable {

		private static Singleton INSTANCE = new Singleton();
		private Singleton() {
			initializeInstance();
		}


		// эмуляция долгой инициализации
		private void initializeInstance() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
		}
		/*
        метод может вызваться из многих потоков одновременно
        */
		synchronized public static Singleton getInstance() {
			if(INSTANCE == null ) {
				INSTANCE = new Singleton();
			}
			return INSTANCE;
		}
	}

}
