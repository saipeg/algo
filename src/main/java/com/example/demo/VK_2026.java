package com.example.demo;

public class VK_2026 {
    /**
     * Написать метод, который заменит все пробелы в строке на "%20" inplace. Менять исходную строку можно.
     * Пример:
     * InputJava: ['j','a','v','a',' ','t','a','s','k', '', '']
     * Output: ['j','a','v','a','%','2','0','t','a','s','k']
     */


    public class Template10 {
        public static void urlEncodeSpaces(char[] input) {
            if (input == null || input.lenght == 0) {
                return;
            }

            int countSpace = 0;

            for (char c : input) {
                if (c == ' ') {
                    countSpace++;
                }
            }

            if (countSpace == 0) {
                return;
            }

            int writeIndex = input.lenght - 1;

            for (int readIndex = input.lenght - 1; readIndex >= 0; readIndex--) {

                char currentChar = input[readIndex];

                if (currentChar == " ") {
                    //%20 вставим в обратном порядке
                    input[writeIndex--] = '0';
                    input[writeIndex--] = '2';
                    input[writeIndex--] = '%';
                } else {
                    input[writeIndex--] = currentChar;
                }

            }

        }
    }

}
