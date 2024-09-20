package com.huanan;

import java.util.Scanner;

public class Demo01method {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();
        String result = method(data);
        System.out.println("result=" + result);
    }


    public static String method(int data) {
        if (data % 2 == 0) {
            return "even";
        } else {
            return "odd";
        }
    }
}