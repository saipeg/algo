package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@SpringBootApplication
public class DemoApplication {

	/**
	 * Банкомат.
	 * Инициализируется набором купюр и умеет выдавать купюры для заданной суммы, либо отвечать отказом.
	 * При выдаче купюры списываются с баланса банкомата.
	 * Допустимые номиналы: 50₽, 100₽, 500₽, 1000₽, 5000₽.
	 *
	 * Другие валюты и номиналы должны легко добавляться разработчиками в будущем.
	 * Многопоточные сценарии могут быть добавлены позже (например резервирование).
	 *
	 * Вставить карту
	 * Ввести пинкод
	 * Выбрать операцию - снятие
	 *
	 *
	 * Проверить баланс
	 * Списать с баланса
	 * Выдать деньги
	 *
	 */

	public static void main(String[] args) {

	}

	class ATM {
		private static int bankomatBalance = 1_000_000;

		private int getMoney(int amount) {
			//12 300
			if (bankomatBalance <= amount && amount % 50 == 0) {
				int toGiveAmountWith5000 = amount / 5000;
				if (toGiveAmountWith5000 != 0) {
					int residue = amount - toGiveAmountWith5000;

				}
			}

			System.out.println("Выдано: " + amount );
			return 10;
		}




		class Amount {
			private static Map<NaminalForRubles, Integer> amount = new ConcurrentHashMap<>();

			Amount() {
				amount.put(NaminalForRubles.Fifty, 50);
				amount.put(NaminalForRubles.Hundred, 50);
				amount.put(NaminalForRubles.Five_hundred, 50);
				amount.put(NaminalForRubles.Thousand, 50);
				amount.put(NaminalForRubles.Five_thousand, 50);
			}

			public static int getAmountForNaminal(NaminalForRubles naminalForRubles) {
				return amount.get(naminalForRubles);
			}

			public boolean decrease(NaminalForRubles naminalForRubles, int amountToDecrease) {
				Integer currentAmount = amount.get(naminalForRubles);
				if (currentAmount >= amountToDecrease) {
					amount.put(naminalForRubles, currentAmount - amountToDecrease);
					return true;
				} else {
					System.out.println("Not enought money");
					return false;
				}
			}

			public boolean increase(NaminalForRubles naminalForRubles, int amountToIncrease) {
				amount.put(naminalForRubles, amountToIncrease);
				return true;
			}
		}

		public enum NaminalForRubles {
			Fifty(50),
			Hundred(100),
			Five_hundred(500),
			Thousand(1000),
			Five_thousand(5000);

			private final int digital;

			NaminalForRubles(int digital) {
				this.digital = digital;
			}

			public int getAmountInNumbers() {
				return digital;
			}

		}
	}



}
