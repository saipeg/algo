package com.ex1;

import java.util.Arrays;

public class Ex_1_leetcode {

    public static void main(String[] args) {
        int[] a = {2, 3, 5};
        int[] b = {4, 1, 4, 0, 0, 0};

        System.arraycopy(a, 0, b, 3, 3);

        System.out.println(Arrays.toString(b));

        Arrays.sort(b);

        System.out.println(Arrays.toString(b));

    }
}
