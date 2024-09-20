package com.huanan;

import java.util.Scanner;

public class Demo04method {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int[] arr2 = method(a, b);

        for (int i = 0; i < arr2.length; i++) {

            System.out.println(arr2[i]);

        }
    }

    public static int[] method(int a,int b) {
        int sum = a+b;
        int sub = a-b;
        int[] arr1 ={sum,sub};
        return arr1;
    }
}
