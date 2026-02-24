package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        getMaxChairsForWord("bbaaabbbbpeerrqlskfkfzzzlllzzzzzzzzlsdk");
    }

	/*
	Нужно написать функцию которая принимает на вход строку
	а на выходе возвращает для каждого уникального символа максимальное число его беспрерывных повторений.
	bbpdeeerdsaasfffge
	 */

    public static void getMaxChairsForWord(String word) {
        Map<Character, Integer> result = new HashMap<>();
        char[] wordLikeChar = word.toCharArray();

        for (int i = 0; i < wordLikeChar.length; i++) {
            if (!result.containsKey(wordLikeChar[i])) {
                result.put(wordLikeChar[i], 1);
            } else {
                int counter = 0;
                int k = i;
                counter++;
                if (k + 1 < wordLikeChar.length) {
                    while (wordLikeChar[k] == wordLikeChar[k + 1]) {
                        counter++;
                        k++;
                    }
                }


                if (result.get(wordLikeChar[i]) < counter) {
                    result.put(wordLikeChar[i], counter);
                }
            }
        }
        System.out.println(result);
    }


}
